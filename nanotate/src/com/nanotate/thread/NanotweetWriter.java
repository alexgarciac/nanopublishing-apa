package com.nanotate.thread;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLDecoder;
import java.sql.Timestamp;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import com.nanotate.Settings;
import com.nanotate.dao.custom.SequenceMapper;
import com.nanotate.dao.model.Annotation;
import com.nanotate.dao.model.AnnotationMapper;
import com.nanotate.dao.util.MyBatis;

public class NanotweetWriter implements Runnable {

	Logger log = Logger.getLogger(NanotweetWriter.class);
	
	String text;
	String uuid;
	
	public NanotweetWriter(String text, String documentUUID ) {
		this.text = text;
		this.uuid = documentUUID;
	}
	
	@Override
	public void run() {
		
		try {
			
			log.info("Using text: " + text );
			System.out.println("Die");
			Annotation annotation = insertNewAnnotation( java.net.URLDecoder.decode(text, "UTF-8"), uuid ); 
			
			LinkedHashMap<String, Integer> annotations = new LinkedHashMap<String, Integer>();
			
			// Query whatizit to all pipelines 
			for ( String pipeline : Settings.WHATIZIT_PIPELINE ) {
				log.info("Using pipeline: " + pipeline );
				String whatizitText = executeWhatizitQuery( pipeline );
				Matcher matcher = Settings.pattern.matcher( whatizitText );
		    	
				while ( matcher.find() )
				{
					if ( !StringUtils.isEmpty( matcher.group() ) ) {
						annotations.put(matcher.group() , 0);
					}
				}
			}
			
			// Annotations there ??
			if ( !annotations.isEmpty() ) {
				
				String annotationResult = StringUtils.join(annotations.keySet(), "");
				
				log.debug( "annotations: " + annotationResult );
				
				// Change annotation status and result in database
				annotation.setAnnotatedText(annotationResult);
				annotation.setStatus("COMPLETED");
				
			} else {
				annotation.setStatus("EMPTY");
				log.debug( "No annotations found across all whatizit pipelines. " );
			}
			
			annotation.setCompleted( new Timestamp(new Date().getTime()) );
			
			updateAnnotation( annotation );
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void updateAnnotation(Annotation annotation) throws Exception {
		// Create a new entry in database
		SqlSession session = MyBatis.getSession();

    	AnnotationMapper mapper = session.getMapper(AnnotationMapper.class);
    	
    	mapper.updateByPrimaryKey(annotation);
    	
    	session.commit();
    	session.close();
	}

	private Annotation insertNewAnnotation(String text, String uuid) throws Exception {
		// Create a new entry in database
		SqlSession session = MyBatis.getSession();
    	
		SequenceMapper sequenceMapper = session.getMapper(SequenceMapper.class);
		
    	AnnotationMapper mapper = session.getMapper(AnnotationMapper.class);
    	Annotation annotation = new Annotation();
    	
    	Integer id = sequenceMapper.getNextValueSeqAnnotation();
    	
    	annotation.setId(id);
    	annotation.setOriginalText(text);
		annotation.setAnnotatedText("");
		annotation.setDocument( uuid );
    	annotation.setCreation( new Timestamp(new Date().getTime()) );
    	annotation.setStatus( "WORKING" );
     
    	mapper.insert(annotation);
    	
    	session.commit();
    	session.close();
    	log.info(annotation.getOriginalText());
		return annotation;
	}

	private String executeWhatizitQuery(String pipeline) {
		
		String whatizitText = "";
		InputStream in = null;
		
		try {
			
			log.debug("Using pipeline: " + pipeline );
		
			String query = 
					pipeline + "\n" +
					"<document xmlns:xlink='http://www.w3.org/1999/xlink' " +
					"xmlns:z='http://www.ebi.ac.uk/z' source='Whatizit'>" +
					"<text>" + text + "</text>" +
					"</document>";
	
			URLConnection connection;
			connection = new URL( "http://www.ebi.ac.uk/webservices/whatizit/pipe" ).openConnection();
			
			connection.setUseCaches(false);    
	        connection.setDoInput(true);
	        connection.setDoOutput(true);                   
	        connection.setRequestProperty("Content-Type", "UTF-8");
	        connection.setRequestProperty("Transfer-Encoding", "chunked");   
	
	    	connection.getOutputStream().write(query.getBytes("UTF-8"));
	    	connection.getOutputStream().close();
	
	    	in = connection.getInputStream();
	
	    	log.info("Receiving response...");
	    	
	    	StringWriter writer = new StringWriter();
	    	IOUtils.copy(in, writer, "UTF-8");
	    	
	    	whatizitText = writer.toString();
	    	
	    	IOUtils.closeQuietly(in);
	    	
	    	log.info( whatizitText );
		
		} catch (MalformedURLException e) {
			whatizitText = "";
			e.printStackTrace();
			IOUtils.closeQuietly(in);
			
		} catch (IOException e) {
			whatizitText = "";
			e.printStackTrace();
			IOUtils.closeQuietly(in);
		} 
    	
		return whatizitText;
	}

}

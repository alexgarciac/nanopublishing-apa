package com.nanotate.thread;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;
import utils.SocialBuilder;

import com.nanotate.Settings;
import com.nanotate.dao.custom.SequenceMapper;
import com.nanotate.dao.model.Annotation;
import com.nanotate.dao.model.AnnotationExample;
import com.nanotate.dao.model.AnnotationMapper;
import com.nanotate.dao.model.AnnotationWithBLOBs;
import com.nanotate.dao.model.Document;
import com.nanotate.dao.model.DocumentMapper;
import com.nanotate.dao.model.FacebookPost;
import com.nanotate.dao.model.FacebookPostMapper;
import com.nanotate.dao.model.TwitterPost;
import com.nanotate.dao.model.TwitterPostMapper;
import com.nanotate.dao.model.User;
import com.nanotate.dao.model.UserExample;
import com.nanotate.dao.model.UserMapper;
import com.nanotate.dao.util.MyBatis;

import facebook4j.Facebook;
import facebook4j.FacebookException;
import facebook4j.FacebookFactory;
import facebook4j.Post;
import facebook4j.auth.AccessToken;



public class NanotweetWriter implements Runnable {

	Logger log = Logger.getLogger(NanotweetWriter.class);
	public static final String annotatorUrl = "http://data.bioontology.org/annotator?";
	
	String text;
	String uuid;
	String user;
	String comment;
	Facebook facebook;
	Twitter twitter;
	
	public NanotweetWriter(String text, String comment, String documentUUID, String user, Facebook facebook, Twitter twitter ) {
		try {
//			text = text.replaceAll("%(?![0-9a-fA-F]{2})", "%25");
//			text = text.replaceAll("+", "%2B");
			this.text = URLDecoder.decode(text.replace("%", ""), "UTF-8");
			this.user=user;
			this.comment=comment;
			this.facebook=facebook;
			this.twitter=twitter;
			log.info(text);
			
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.uuid = documentUUID;
	}
	
	@Override
	public void run() {
		
		try {
			
			log.info("Using text: " + text );
			System.out.println("Die");
			AnnotationWithBLOBs annotation = insertNewAnnotation( text, comment, uuid , user); 
			
//			LinkedHashMap<String, Integer> annotations = new LinkedHashMap<String, Integer>();
			
			// Query whatizit to all pipelines 
//			for ( String pipeline : Settings.WHATIZIT_PIPELINE ) {
//				log.info("Using pipeline: " + pipeline );
//				String whatizitText = executeWhatizitQuery( pipeline );
//				Matcher matcher = Settings.pattern.matcher( whatizitText );
//		    	
//				while ( matcher.find() )
//				{
//					if ( !StringUtils.isEmpty( matcher.group() ) ) {
//						annotations.put(matcher.group() , 0);
//					}
//				}
//			}
//			
			// Annotations there ??
			
			String annotationResult = this.getBioportalAnnotations();
			log.info(annotationResult );
			if ( annotationResult.equals("[]\n")) {
				
				annotation.setStatus("EMPTY");
				log.debug( "No annotations found across all whatizit pipelines. " );
				
			
				
			} else {
				log.info( "annotations: " + annotationResult );
				
				// Change annotation status and result in database
				annotation.setJson_value(annotationResult);
				annotation.setTags(getTagsFromJSON(annotationResult));
				annotation.setStatus("COMPLETED");
			}
			
			annotation.setCompleted( new Timestamp(new Date().getTime()) );
			log.info("Holaaaaaaa id:"+annotation.getId());
			sendToNanotateTwitter(annotation);
			sendToNanotateFacebook(annotation);
			updateAnnotation( annotation );
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void sendToNanotateFacebook(AnnotationWithBLOBs annotation) {

		  
		facebook.setOAuthAccessToken(new AccessToken("CAADW5nmJZCZCcBAIdV6nJtvvufeVlILOWvPC2h3ro6V2Nk7eOPNPufpAjZAZCkQwgVkzO82C4tIZAzjMeOFMUJm1FkgAV9I96ZCeA5azCg9JX0wmZC5QMpxDxgabKLnDHzRxZBaS5CX4EYoiAk7bCDIPV6ZBlRZCrIQ5TtiQLINO22N8ZAkyNbFZC1lK",null));
		try{
		String data = facebook.postStatusMessage(annotation.getOriginal_text()+"\n from: "+annotation.getDoi());
        Post post = facebook.getPost(data.split("_")[1]);
        
        if(StringUtils.isEmpty(annotation.getComment()))
        {	
        	
        	SqlSession session = null;
        	try {
				session = MyBatis.getSession();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			UserMapper usMapper = session.getMapper(UserMapper.class);
			UserExample usExample = new UserExample();
			usExample.createCriteria().andUsernameEqualTo(annotation.getUser_name());
			User us =  usMapper.selectByExample(usExample).get(0);
			session.close();
			if(!StringUtils.isEmpty(us.getFacebook_token()))
			{
				
				facebook.setOAuthAccessToken(new AccessToken(us.getFacebook_token(), us.getFacebook_token_expires()));
				facebook.commentPost(post.getId(), annotation.getComment());
			}
			else
				facebook.commentPost(post.getId(), annotation.getUser_name()+" said: "+annotation.getComment());
		
				

        }
        
        if(!data.equals(""))
        {
        	SqlSession session = null;
			try {
				session = MyBatis.getSession();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	FacebookPostMapper mapper=(FacebookPostMapper) session.getMapper(FacebookPostMapper.class);
        	FacebookPost record = new FacebookPost();
        	record.setUsername("nanotate");
        	record.setIdannotation(annotation.getId());
        	record.setUrl_post("https://www.facebook.com/nanotateapp/posts/"+post.getId());
        	mapper.insert(record);
        	session.commit();
        	session.close();
        }
	}
		catch(FacebookException e){
			e.printStackTrace();
		}
		
		facebook.setOAuthAccessToken(null);
	}

	private void sendToNanotateTwitter(AnnotationWithBLOBs annotation) {

     
	
        twitter.setOAuthAccessToken(new twitter4j.auth.AccessToken("2326910304-Dpi1MBlPBq37KyUxBmd03jkkFxhXLzffds1cG5X","iCmxAjp0XTtmgpuoV7fKItPajXzqTJkj9jetGLTcQnEOG"));
        try {
        	
        	String message=annotation.getTags().replace(",", ", " );
        	
        	if(message.length()>105)
        		message=message.substring(0,100)+"...";
       
        	
            Status data = twitter.updateStatus(message+" #Nanotate "+annotation.getDoi());
           
            
            if(!data.equals(""))
            {
            	SqlSession session = null;
				try {
					session = MyBatis.getSession();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            	TwitterPostMapper mapper=(TwitterPostMapper) session.getMapper(TwitterPostMapper.class);
            	TwitterPost record = new TwitterPost();
            	record.setUsername("nanotate");
            	record.setIdannotation(annotation.getId());
            	record.setTweet_url("www.twitter.com/"+twitter.getScreenName()+"/"+data.getId());
            	mapper.insert(record);
            	session.commit();
            	session.close();
            }
           
            
         } catch (TwitterException e) {
        	 e.printStackTrace();
        	
//             throw new ServletException(e);
         }
        twitter.setOAuthAccessToken(null);
		
	}

	private void updateAnnotation(AnnotationWithBLOBs annotation) throws Exception {
		// Create a new entry in database
		SqlSession session = MyBatis.getSession();

    	AnnotationMapper mapper = session.getMapper(AnnotationMapper.class);
    	log.info("Holaaaaaaa id:"+annotation.getId());
    	AnnotationExample ae = new AnnotationExample();
    	ae.createCriteria().andIdEqualTo(annotation.getId());
    	mapper.updateByPrimaryKeyWithBLOBs(annotation);
    	
    	session.commit();
    	session.close();
	}

	private AnnotationWithBLOBs insertNewAnnotation(String text, String comment, String uuid, String user) throws Exception {
		// Create a new entry in database
		SqlSession session = MyBatis.getSession();
    	
		SequenceMapper sequenceMapper = session.getMapper(SequenceMapper.class);
		
    	AnnotationMapper mapper = session.getMapper(AnnotationMapper.class);
    	DocumentMapper docMapper = session.getMapper(DocumentMapper.class);
    	
    	Document document = docMapper.selectByPrimaryKey(uuid);
    	
    	AnnotationWithBLOBs annotation = new AnnotationWithBLOBs();
    	
//    	Integer id = sequenceMapper.getNextValueSeqAnnotation();
//    	
//    	annotation.setId(id);
    	annotation.setOriginal_text(text);
		annotation.setTags("");
		annotation.setComment(comment);
		annotation.setDocument( uuid );
    	annotation.setCreation( new Timestamp(new Date().getTime()) );
    	annotation.setDoi(document.getDoi());
    	annotation.setStatus( "WORKING" );
    	annotation.setUser_name(user);
    	mapper.insert(annotation);
    	session.commit();
    	session.close();
    	log.info("i'm working with id:"+annotation.getId());
    	log.info("i'm working:"+annotation.getOriginal_text());
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
	
	public String  getBioportalAnnotations(){
				
				StringBuffer result = new StringBuffer();
				
		   try {
	        	
	            HttpClient client =  new DefaultHttpClient();
	                  
	            
	           
	            
	            
	            
	            String nameValuePairs = "";
	            // Configure the form parameters
	           nameValuePairs =  nameValuePairs.concat("longest_only=true");
	            nameValuePairs =  nameValuePairs.concat("&whole_word_only=true");
	            nameValuePairs =  nameValuePairs.concat("&exclude_numbers=true");
	            //method.appendParameter("stop_words=I,a,above,after,against,all,alone,always,am,amount,an,and,any,are,around,as,at,back,be,before,behind,below,between,bill,both,bottom,by,call,can,co,con,de,detail,do,done,down,due,during,each,eg,eight,eleven,empty,ever,every,few,fill,find,fire,first,five,for,former,four,from,front,full,further,get,give,go,had,has,hasnt,he,her,hers,him,his,i,ie,if,in,into,is,it,last,less,ltd,many,may,me,mill,mine,more,most,mostly,must,my,name,next,nine,no,none,nor,not,nothing,now,of,off,often,on,once,one,only,or,other,others,out,over,part,per,put,re,same,see,serious,several,she,show,side,since,six,so,some,sometimes,still,take,ten,then,third,this,thick,thin,three,through,to,together,top,toward,towards,twelve,two,un,under,until,up,upon,us,very,via,was,we,well,when,while,who,whole,will,with,within,without,you,yourself,yourselves");
//	            nameValuePairs =  nameValuePairs.concat("&withDefaultStopWords=true");
//	            nameValuePairs =  nameValuePairs.concat("&isTopWordsCaseSensitive=false");
	            nameValuePairs =  nameValuePairs.concat("&minimum_match_length=3");
//	            nameValuePairs =  nameValuePairs.concat("&scored=true");
	            nameValuePairs =  nameValuePairs.concat("&include_synonyms=true"); 
	            nameValuePairs =  nameValuePairs.concat("&ontologies=APAONTO");
//	            nameValuePairs =  nameValuePairs.concat("&ontologiesToKeepInResult="); 
//	            nameValuePairs =  nameValuePairs.concat("&isVirtualOntologyId=true"); 
	            nameValuePairs =  nameValuePairs.concat("&semantic_types="); 
	            nameValuePairs =  nameValuePairs.concat("&max_level=0");
	            nameValuePairs =  nameValuePairs.concat("&mappings=true"); //null, Automatic, Manual 
	            nameValuePairs =  nameValuePairs.concat("&text="+ URLEncoder.encode(text, "UTF-8"));  //"Melanoma is a malignant tumor of melanocytes which are found predominantly in skin but also in the bowel and the eye");
	            nameValuePairs =  nameValuePairs.concat("&format=json"); //Options are 'text', 'xml', 'tabDelimited'   
	            nameValuePairs =  nameValuePairs.concat("&apikey=028697e9-f8b5-4086-a252-a446b60b232b");
	            System.out.println(annotatorUrl+nameValuePairs);
	            HttpGet  method = new HttpGet(annotatorUrl+nameValuePairs);
	            // Execute the POST method
	           
	            
//	            BufferedReader rd = new BufferedReader(
//	        			new InputStreamReader(method.getEntity().getContent()));
//	        	 
//	        		StringBuffer result = new StringBuffer();
//	        		String line = "";
//	        		while ((line = rd.readLine()) != null) {
//	        			result.append(line);
//	        			result.append("\n");
//	        		}
//	        		System.out.println(result);
	            
	            HttpResponse statusCode = client.execute(method);
	           
	            if( statusCode.getStatusLine().getStatusCode() != -1 ) {
	            	BufferedReader rd = new BufferedReader(
	            			new InputStreamReader(statusCode.getEntity().getContent()));
	            	 
	            		
	            		String line = "";
	            		while ((line = rd.readLine()) != null) {
	            			result.append(line);
	            			result.append("\n");
	            		}
	            		System.out.println(result);
	            }
	        }
	        catch( Exception e ){
	            e.printStackTrace();
	            return "";
	        }
		return result.toString();
		
	}
	
	public String getTagsFromJSON(String result)
	{
				String ret="";
		 		  JSONParser parser = new JSONParser();
		  
			try {
		 
				Object obj = parser.parse(result);
		 
				JSONArray jsonObjects = (JSONArray) obj;
				for (Object object : jsonObjects )
				{
					JSONObject jsonObject =(JSONObject) object;
					JSONArray annotations = (JSONArray) jsonObject.get("annotations");
					System.out.println(annotations.toJSONString());
					for (Object annotation : annotations )
					{
						JSONObject jsonAnnotation=(JSONObject) annotation;
						String tag = (String) jsonAnnotation.get("text");
						if(!ret.contains(tag))
						ret+=tag+",";
					}
					
					
				
				}
				if(ret!="")
				ret=ret.substring(0, ret.length()-1);
				System.out.println(ret);
		 
			} catch (ParseException e) {
				e.printStackTrace();
			}
		   return ret;
	   }
	}
	
//	   public static void main( String[] args ) {
//	   


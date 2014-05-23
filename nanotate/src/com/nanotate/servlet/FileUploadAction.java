package com.nanotate.servlet;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItemIterator;
import org.apache.commons.fileupload.FileItemStream;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.util.Streams;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.ibatis.session.SqlSession;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.util.PDFTextStripper;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.crocodoc.CrocodocDocument;
import com.crocodoc.CrocodocException;
import com.nanotate.crocodoc.CrocodocDownload;
import com.nanotate.dao.model.Document;
import com.nanotate.dao.model.DocumentMapper;
import com.nanotate.dao.util.MyBatis;

public class FileUploadAction extends HttpServlet {

	private static final long serialVersionUID = 3447685998419256747L;
	private static final String RESP_SUCCESS = "{\"jsonrpc\" : \"2.0\", \"result\" : \"success\", \"id\" : \"id\"}";
	private static final String RESP_ERROR = "{\"jsonrpc\" : \"2.0\", \"error\" : {\"code\": 101, \"message\": \"Failed to open input stream.\"}, \"id\" : \"id\"}";
	public static final String JSON = "application/json";
	public static final int BUF_SIZE = 2 * 1024;
	public static final String FileDir = "uploadfile/";

	private int chunk;
	private int chunks;
	private String name;
	private String user;
	private String time;

	/**
	 * Handles an HTTP POST request from Plupload.
	 * 
	 * @param req The HTTP request
	 * @param resp The HTTP response
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String responseString = RESP_SUCCESS;
		boolean isMultipart = ServletFileUpload.isMultipartContent(req);

		if(isMultipart){
			ServletFileUpload upload = new ServletFileUpload();
			try {
				FileItemIterator iter = upload.getItemIterator(req);
				while (iter.hasNext()) {
				    FileItemStream item = iter.next();
				    InputStream input = item.openStream();

				    // Handle a form field.
				    if(item.isFormField()){
				        String fileName = item.getFieldName();
				        String value = Streams.asString(input);

				        if("name".equals(fileName)){
				        	this.name = value;
				        }else if("chunks".equals(fileName)){
				        	this.chunks = Integer.parseInt(value);
				        }else if("chunk".equals(fileName)){
				        	this.chunk = Integer.parseInt(value);
				        }else if("user".equals(fileName)){
				        	this.user = value;
				        }else if("time".equals(fileName)){
				        	this.time = value;
				        }
				    }

				    // Handle a multi-part MIME encoded file.
				    else {
				    	String fileDir = req.getSession().getServletContext().getRealPath("/")+FileDir;
						File dstFile = new File(fileDir);
						if (!dstFile.exists()){
							dstFile.mkdirs();
						}

						File dst = new File(dstFile.getPath()+ "/" + this.name);
						System.out.println("Path: "+dst.getAbsolutePath());
				        saveUploadFile(input, dst);
				    }
				}
			}
			catch (Exception e) {
				responseString = RESP_ERROR;
				e.printStackTrace();
			}
		}

		// Not a multi-part MIME request.
		else {
			responseString = RESP_ERROR;
		}

		if(this.chunk == this.chunks - 1){
	    	System.out.println("User: "+this.user);
	    	System.out.println("Name: "+this.name);
	    	System.out.println("Time: "+this.time);
	    	
	    }

		resp.setContentType(JSON);
		byte[] responseBytes = responseString.getBytes();
		resp.setContentLength(responseBytes.length);
		ServletOutputStream output = resp.getOutputStream();
		output.write(responseBytes);
		output.flush();
	}

	/**
	 * Saves the given file item (using the given input stream) to the web server's
	 * local temp directory.
	 * 
	 * @param input The input stream to read the file from
	 * @param dst The dir of upload
	 */
	private void saveUploadFile(InputStream input, File dst) throws IOException {
		
		
		OutputStream out = null;
		try {
			if (dst.exists()) {
				out = new BufferedOutputStream(new FileOutputStream(dst, true),
						BUF_SIZE);
			} else {
				out = new BufferedOutputStream(new FileOutputStream(dst),
						BUF_SIZE);
			}

			byte[] buffer = new byte[BUF_SIZE];
			int len = 0;
			while ((len = input.read(buffer)) > 0) {
				out.write(buffer, 0, len);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (null != input) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (null != out) {
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		try {
			this.sendToCrocodoc(dst);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void sendToCrocodoc(File file) throws Exception{
		SqlSession session = MyBatis.getSession();
		String uuid="";
		DocumentMapper mapper = session.getMapper(DocumentMapper.class);
		Document document =  new Document();
		PDDocument pdDoc = PDDocument.load(file);
		PDFTextStripper stripper = new PDFTextStripper();
		stripper.setStartPage(1);
		stripper.setEndPage(1);
		String text=stripper.getText(pdDoc);
		int doi_begin_index=text.indexOf("DOI: ");
		int doi_end_index=text.indexOf("\n", doi_begin_index);
		String doi= text.substring(doi_begin_index+5, doi_end_index);
		
		
		
		 try {
	        	
	            System.out.print("  Uploading... ");
	            uuid = CrocodocDocument.upload(file);
	            System.out.println("success :)");
	            System.out.println("  UUID is " + uuid);
	            document= this.getDoiData(doi);
	            document.setUuid(uuid);
	            mapper.insert(document);
	            session.commit();
	        	session.close();
	        } catch (CrocodocException e) {
	            System.out.println("failed :(");
	            System.out.println("  Error Code: " + e.getCode());
	            System.out.println("  Error Message: " + e.getMessage());
	       }
	      
	}
	

	
	public Document  getDoiData(String doi){
		
			StringBuffer result = new StringBuffer();
			
	   try {
	    	
	        HttpClient client =  new DefaultHttpClient();
	              
	        HttpGet  method = new HttpGet("http://search.crossref.org/dois?q="+URLEncoder.encode(doi,"UTF-8"));
	        // Execute the POST method
	       
	        
	//        BufferedReader rd = new BufferedReader(
	//    			new InputStreamReader(method.getEntity().getContent()));
	//    	 
	//    		StringBuffer result = new StringBuffer();
	//    		String line = "";
	//    		while ((line = rd.readLine()) != null) {
	//    			result.append(line);
	//    			result.append("\n");
	//    		}
	//    		System.out.println(result);
	        
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
	        return new Document();
	    }
	   
	   JSONParser parser = new JSONParser();
	   
	   Document ret = new Document();
		  
		try {
	 
			Object obj = parser.parse(result.toString().replace("\u2019", "'"));
			
			JSONArray jsonObjects = (JSONArray) obj;
			for (Object object : jsonObjects )
			{
				
				JSONObject jsonObject = (JSONObject) object;
				ret.setDoi((String) jsonObject.get("doi"));
				ret.setTitle((String) jsonObject.get("title"));
//				String title = ret.getTitle();
//				for(int j=0; j<title.length();j++){
//					char registered = title.charAt(j);
//					System.out.println(registered);
//					System.out.println(String.format("And this is an hexa code: %x", (int) registered));
//					System.out.println(String.format("This is an int-code: %d", (int) registered));
//					System.out.println(String.format("And this is an hexa code: %x", (int) registered));
//				}
					
				ret.setFull_citation((String) jsonObject.get("fullCitation"));
				ret.setYear(Integer.parseInt( (String) jsonObject.get("year")));
			
			}
			
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
	return ret;
	
	}
}
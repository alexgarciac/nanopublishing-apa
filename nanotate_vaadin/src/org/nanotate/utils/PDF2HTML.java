package org.nanotate.utils;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLConnection;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.json.JSONException;
import org.json.JSONObject;
 
public class PDF2HTML {
	
	public static String sendPDFToBoxView(File file){
		
		String docid="";
		
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpPost uploadFile = new HttpPost("https://upload.view-api.box.com/1/documents");
		uploadFile.setHeader("Authorization","Token 7tpuie82v51mlnfemhs76f28lid4gzof");

		MultipartEntityBuilder builder = MultipartEntityBuilder.create();
		builder.addTextBody("field1", "yes", ContentType.TEXT_PLAIN);
		builder.addBinaryBody("file", file, ContentType.APPLICATION_OCTET_STREAM, "file.ext");
		HttpEntity multipart = builder.build();

		uploadFile.setEntity(multipart);

		HttpResponse response;
		try {
			response = httpClient.execute(uploadFile);
			HttpEntity responseEntity = response.getEntity();
			
			StringWriter writer = new StringWriter();
			IOUtils.copy(responseEntity.getContent(), writer, "UTF8");
			String theString = writer.toString();
			JSONObject json = new JSONObject(theString);
			docid=json.getString("id");
			System.out.println(theString+" "+docid);
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return docid;
		
	}
	
	public static void downloadHTML(String docid, String path){
		
		URL url;
		while(true){
			
			
			
			try {
				if(StringUtils.equalsIgnoreCase(getDocStatus(docid), "done")){
					try {
						// get URL content
						url = new URL("https://view-api.box.com/1/documents/"+docid+"/content.zip");
						URLConnection conn = url.openConnection();
						
						conn.setRequestProperty("Authorization","Token 7tpuie82v51mlnfemhs76f28lid4gzof");
 
						// open the stream and put it into BufferedReader
						BufferedReader br = new BufferedReader(
				                           new InputStreamReader(conn.getInputStream()));
 
						String inputLine;
 
						//save to this filename
						String fileName = path+"/content1.zip";
						File file = new File(fileName);
 
						if (!file.exists()) {
							file.createNewFile();
						}
 
						//use FileWriter to write file
						FileWriter fw = new FileWriter(file.getAbsoluteFile());
						BufferedWriter bw = new BufferedWriter(fw);
 
						while ((inputLine = br.readLine()) != null) {
							bw.write(inputLine);
						}
 
						bw.close();
						br.close();
 
						System.out.println("Done");
 
					} catch (MalformedURLException e) {
						e.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					}
					break;
				}
			else if(StringUtils.equalsIgnoreCase(getDocStatus(docid), "error"))
			{
				break;
			}
			else
			{
				try {
				    Thread.sleep(5000);
				} catch(InterruptedException ex) {
				    Thread.currentThread().interrupt();
				}
			}
					
			} catch (Exception e) {
				// TODO Auto-generated catch block
				
				e.printStackTrace();
				break;
			}
			
			
		}
		
 
	}
	
	public static String getDocStatus(String docid) throws Exception {
		 
		String url = "https://view-api.box.com/1/documents/"+docid;
 
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
 
		// optional default is GET
		con.setRequestMethod("GET");
 
		//add request header
		con.setRequestProperty("User-Agent", "Mozilla/5.0");
		con.setRequestProperty("Authorization", "Token 7tpuie82v51mlnfemhs76f28lid4gzof");
 
		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'GET' request to URL : " + url);
		System.out.println("Response Code : " + responseCode);
 
		BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();
 
		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
 
		//print result
		JSONObject json = new JSONObject(response.toString());
		System.out.println("Response status : " + json.getString("status"));
		return json.getString("status");
		
 
	}
 
	
	
		
		
	
}
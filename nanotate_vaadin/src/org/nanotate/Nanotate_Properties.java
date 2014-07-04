package org.nanotate;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.util.Properties;


public class Nanotate_Properties implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6280192507802601766L;
	private static Properties INSTANCE = null;
	
	private Nanotate_Properties(){}
	
	 private synchronized static void createInstance() {
	        if (INSTANCE == null) { 
	            INSTANCE = new Properties();
	            try {
	 			   
					 INSTANCE.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("nanotate.properties"));
					    
				   } catch (FileNotFoundException e) {
				    System.out.println("Properties file not found");
				   } catch (IOException e) {
				    System.out.println("Can't read properties file");
				   }
	        }
	    }
	
	public static Properties getInstance() {
		
		if (INSTANCE == null) createInstance();
	        return INSTANCE;
		
	}
	
	public static void main(String[] args){
		
		System.out.println(Nanotate_Properties.getInstance().getProperty("repository.dir"));
		
	}
	

}

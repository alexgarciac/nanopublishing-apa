package org.annotatorjs.store;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.util.Properties;


public class StoreProperties implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6280192507802601766L;
	private static Properties INSTANCE = null;
	
	private StoreProperties(){}
	
	 private synchronized static void createInstance() {
	        if (INSTANCE == null) { 
	            INSTANCE = new Properties();
	            try {
	 			   
					 INSTANCE.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("store.properties"));
					    
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
		
		System.out.println(StoreProperties.getInstance().getProperty("database.host"));
		
	}
	

}

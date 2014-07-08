package org.annotatorjs.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;

import org.annotatorjs.model.Annotation;
import org.annotatorjs.model.Permissions;
import org.annotatorjs.model.Range;
import org.annotatorjs.store.Store_Properties;



public class Connector { 
	
	Connection conn = null;
	String DATABASE_HOST;
	String DATABASE_NAME;
	String DATABASE_USER;
	String DATABASE_PASS;
	
	
	public Connector() {
		
		DATABASE_HOST = Store_Properties.getInstance().getProperty("database.host");
		DATABASE_NAME = Store_Properties.getInstance().getProperty("database.name");
		DATABASE_USER = Store_Properties.getInstance().getProperty("database.user");
		DATABASE_PASS = Store_Properties.getInstance().getProperty("database.pass");
		
		try {
			
			
			conn = DriverManager.getConnection("jdbc:mysql://"+DATABASE_HOST+"/"+DATABASE_NAME+"?" +
				                                   "user="+DATABASE_USER+"&password="+DATABASE_PASS);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	

	public ArrayList<Annotation> getAll() {
		
		 ArrayList<Annotation> annotations = new ArrayList<Annotation>();
		 Statement stmt = null;
		 ResultSet rs = null;
		
		try {
		    
		    
		    stmt = conn.createStatement();

		    if (stmt.execute("SELECT * FROM annotations")) {
		        rs = stmt.getResultSet();
		        
		        while(rs.next()) {
		        	
		        	Annotation annotation =  new Annotation();
		            annotation.setId(rs.getString("annotation_id"));
		            annotation.setAnnotator_schema_version(rs.getString("annotator_schema_version"));
		            annotation.setCreated(rs.getString("created"));
		            annotation.setUpdated(rs.getString("updated"));
		            annotation.setText(rs.getString("text"));
		            annotation.setQuote(rs.getString("quote"));
		            annotation.setUri(rs.getString("uri"));
		            annotation.setUser(rs.getString("user"));
		            annotation.setConsumer(rs.getString("consumer"));
		        	
		        	annotations.add(annotation);
		            
		        }
		        
		    }


		    // Do something with the Connection

		} catch (SQLException ex) {
		    // handle any errors
		    System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
		} finally {
		    // it is a good idea to release
		    // resources in a finally{} block
		    // in reverse-order of their creation
		    // if they are no-longer needed

		    if (rs != null) {
		        try {
		            rs.close();
		        } catch (SQLException sqlEx) { } // ignore

		        rs = null;
		    }

		    if (stmt != null) {
		        try {
		            stmt.close();
		        } catch (SQLException sqlEx) { } // ignore

		        stmt = null;
		    }
		
		
		}
		return annotations;
	}

	public ArrayList<Annotation> getAllComplete() {
		
		return completeAnnotations(getAll());
	}
	
	public ArrayList<Range> getRangesForAnnotation(String annotation_id){
		
		ArrayList<Range> ranges = new ArrayList<Range>();
		 Statement stmt = null;
		 ResultSet rs = null;
		
		 try {
			    
			    
			    stmt = conn.createStatement();

			    if (stmt.execute("SELECT * FROM ranges WHERE annotation_id=\""+annotation_id+"\"")) {
			        rs = stmt.getResultSet();
			        
			        while(rs.next()) {
			        	
			        	Range range =  new Range();
			            range.setStart(rs.getString("start"));
			            range.setEnd(rs.getString("end"));
			            range.setStartOffset(rs.getInt("startOffset"));
			            range.setEndOffset(rs.getInt("endOffset"));
			          
			        	
			        	ranges.add(range);
			            
			        }
			        
			    }


			    // Do something with the Connection

			} catch (SQLException ex) {
			    // handle any errors
			    System.out.println("SQLException: " + ex.getMessage());
			    System.out.println("SQLState: " + ex.getSQLState());
			    System.out.println("VendorError: " + ex.getErrorCode());
			} finally {
			    // it is a good idea to release
			    // resources in a finally{} block
			    // in reverse-order of their creation
			    // if they are no-longer needed

			    if (rs != null) {
			        try {
			            rs.close();
			        } catch (SQLException sqlEx) { } // ignore

			        rs = null;
			    }

			    if (stmt != null) {
			        try {
			            stmt.close();
			        } catch (SQLException sqlEx) { } // ignore

			        stmt = null;
			    }
			
			
			}
		
		
		return ranges;
		
	}
	
	public ArrayList<String> getTagsForAnnotation(String annotation_id){
		
		ArrayList<String> tags = new ArrayList<String>();
		 Statement stmt = null;
		 ResultSet rs = null;
		
		 try {
			    
			    
			    stmt = conn.createStatement();

			    if (stmt.execute("SELECT * FROM tags WHERE annotation_id=\""+annotation_id+"\"")) {
			        rs = stmt.getResultSet();
			        
			        while(rs.next()) {
			        	
			        	String tag = rs.getString("tag_label");
			          
			        	
			        	tags.add(tag);
			            
			        }
			        
			    }


			    // Do something with the Connection

			} catch (SQLException ex) {
			    // handle any errors
			    System.out.println("SQLException: " + ex.getMessage());
			    System.out.println("SQLState: " + ex.getSQLState());
			    System.out.println("VendorError: " + ex.getErrorCode());
			} finally {
			    // it is a good idea to release
			    // resources in a finally{} block
			    // in reverse-order of their creation
			    // if they are no-longer needed

			    if (rs != null) {
			        try {
			            rs.close();
			        } catch (SQLException sqlEx) { } // ignore

			        rs = null;
			    }

			    if (stmt != null) {
			        try {
			            stmt.close();
			        } catch (SQLException sqlEx) { } // ignore

			        stmt = null;
			    }
			
			
			}
		
		
		return tags;
		
	}
	
	public Permissions getPermissionsForAnnotation(String annotation_id){
		
		Permissions permissions =  new Permissions();
		 Statement stmt = null;
		 ResultSet rs = null;
		
		 try {
			    
			    
			    stmt = conn.createStatement();

			    if (stmt.execute("SELECT * FROM permissions WHERE annotation_id=\""+annotation_id+"\"")) {
			        rs = stmt.getResultSet();
			        
			        while(rs.next()) {
			        	
			        	permissions.setAdmin((ArrayList<String>) Arrays.asList(rs.getString("admin_permission").split("\\s*,\\s*")));
			        	permissions.setDelete((ArrayList<String>) Arrays.asList(rs.getString("delete_permission").split("\\s*,\\s*")));
			        	permissions.setRead((ArrayList<String>) Arrays.asList(rs.getString("read_permission").split("\\s*,\\s*")));
			        	permissions.setUpdate((ArrayList<String>) Arrays.asList(rs.getString("update_permission").split("\\s*,\\s*")));
			            
			        }
			        
			    }


			    // Do something with the Connection

			} catch (SQLException ex) {
			    // handle any errors
			    System.out.println("SQLException: " + ex.getMessage());
			    System.out.println("SQLState: " + ex.getSQLState());
			    System.out.println("VendorError: " + ex.getErrorCode());
			} finally {
			    // it is a good idea to release
			    // resources in a finally{} block
			    // in reverse-order of their creation
			    // if they are no-longer needed

			    if (rs != null) {
			        try {
			            rs.close();
			        } catch (SQLException sqlEx) { } // ignore

			        rs = null;
			    }

			    if (stmt != null) {
			        try {
			            stmt.close();
			        } catch (SQLException sqlEx) { } // ignore

			        stmt = null;
			    }
			
			
			}
		
		
		return permissions;
		
	}

	public ArrayList<Annotation> completeAnnotations(ArrayList<Annotation> annotations){
		 
		ArrayList<Annotation> completeAnnotations = new ArrayList<Annotation>();
		
		for(Annotation annotation : annotations){
			
			annotation.setRanges(getRangesForAnnotation(annotation.getId()));
			annotation.setTags(getTagsForAnnotation(annotation.getId()));
			annotation.setPermissions(getPermissionsForAnnotation(annotation.getId()));
			
			completeAnnotations.add(annotation);
		}
		
		return completeAnnotations;
		
	}
	
	public Annotation completeAnnotation(Annotation annotation){
		 
			Annotation completeAnnotation = new Annotation();
			completeAnnotation.setRanges(getRangesForAnnotation(annotation.getId()));
			completeAnnotation.setTags(getTagsForAnnotation(annotation.getId()));
			completeAnnotation.setPermissions(getPermissionsForAnnotation(annotation.getId()));
			
		
		
		return completeAnnotation;
		
	}
}

package org.annotatorjs.store;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.annotatorjs.database.Connector;
import org.annotatorjs.model.Annotation;


@Path("/search")
public class Search_Service {
	
		private Connector connector;
	
		
		@GET
	 	@Path("?uri={uri}")
	    @Produces("application/json")
	    public ArrayList<Annotation> search(@PathParam("uri") String uri) {
	 		
	 		//TODO Get annotation from database
	 	
	 		
	        return  null;
	    }
		
		@GET
	 	@Path("?limit={limit}&uri={uri}")
	    @Produces("application/json")
	    public ArrayList<Annotation> search(@PathParam("limit") int limit, @PathParam("uri") String uri) {
	 		
	 		//TODO Get annotation from database
	 	
	 		
	        return  null;
	    }
	 
		@GET
	 	@Path("?limit={limit}&offset{offset}&uri={uri}")
	    @Produces("application/json")
	    public ArrayList<Annotation> search(@PathParam("limit") int limit, @PathParam("offset") int offset, @PathParam("uri") String uri) {
	 		
	 		//TODO Get annotation from database
	 	
	 		
	        return  null;
	    }
	 	
	 	@GET
	 	@Path("?text={text}")
	    @Produces("application/json")
	    public Annotation search_text(@PathParam("text") String text) {
	 		
	 		
	        return null;
	    }
	 	
	 	@GET
	 	@Path("?limit={limit}&text={text}")
	    @Produces("application/json")
	    public ArrayList<Annotation> search_text(@PathParam("limit") int limit, @PathParam("text") String text) {
	 		
	 		//TODO Get annotation from database
	 	
	 		
	        return  null;
	    }
	 
		@GET
	 	@Path("?limit={limit}&offset{offset}&text={text}")
	    @Produces("application/json")
	    public ArrayList<Annotation> search_text(@PathParam("limit") int limit, @PathParam("offset") int offset, @PathParam("text") String text) {
	 		
	 		//TODO Get annotation from database
	 	
	 		
	        return  null;
	    }
	
	

}

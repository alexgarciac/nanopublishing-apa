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


@Path("/annotations")
public class AnnotationsService {
	
		private Connector connector;
		
		public AnnotationsService () {
			
			connector = new Connector();
		}
		
		
	 	@GET 
	    @Produces("application/json")
	    public ArrayList<Annotation> index() {
	 		
	 		ArrayList<Annotation> allAnnotatios = connector.getAllComplete();
	 		
	 		
	        return allAnnotatios;
	    }
	 	
	 	@POST
	    @Consumes(MediaType.APPLICATION_JSON)
	    public Response create(@Context UriInfo ui, Annotation annotation) {
	 		
	 		//TODO Create annotation in database
	 		
	 		String uuid = connector.createAnnotation(annotation);
	 		 URI location = null;
	 		
	 		try {
				location = new URI(StoreProperties.getInstance().getProperty("store.host")+"/store/annotations/"+uuid);
			} catch (URISyntaxException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	       
			return Response.seeOther(location).build();
	    }
	 	
	 	@GET
	 	@Path("/{id}")
	    @Produces("application/json")
	    public Annotation read(@Context UriInfo ui, @PathParam("id") String id) {
	 		
	 		
	 		Annotation ret = connector.getCompleteAnnotation(id);
	 		
	        return ret;
	    }
	
	 	@PUT
	 	@Path("/{id}")
	    @Consumes(MediaType.APPLICATION_JSON)
	    public Response update(@Context UriInfo ui, Annotation annotation) {
	 		
	 		URI location = null;
	 		 
	 		connector.updateAnnotation(annotation);
	 		
	 		try {
				location = new URI(StoreProperties.getInstance().getProperty("store.host")+"/store/annotations/"+annotation.getId());
			} catch (URISyntaxException e) {
				
				e.printStackTrace();
			}
	       
			return Response.seeOther(location).build();
	    }
	 	
	 	@DELETE
	 	@Path("/{id}")
	    public Response delete(@PathParam("id") String id) {
	 		
	 		connector.deleteAnnotation(id);
	 		
	 		return Response.noContent().build();
	    }
	

}

package org.annotatorjs.store;

import java.util.ArrayList;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import org.annotatorjs.database.Connector;
import org.annotatorjs.model.Annotation;
import org.annotatorjs.model.SearchResult;


@Path("/search")
public class SearchService {
	
		private Connector connector;
		
		public SearchService () {
			
			connector = new Connector();
		}
		
		@GET
		@Produces("application/json")
	    public SearchResult search(
	    		
	    		@DefaultValue("-1")@QueryParam("limit") int limit,
	    		@QueryParam("uri") String uri
	    		) {
			
			SearchResult searchResult = new SearchResult();
	 		
			ArrayList<Annotation> annotations = connector.searchAnnotationsByUriComplete(uri, limit);
			
	 	
	 		if(annotations!=null)
	 			searchResult = new SearchResult(annotations.size(),annotations);
			else
			{
	 		ArrayList<Annotation> empty = new ArrayList<Annotation>();
	 		empty.add(new Annotation());
	 				searchResult = new SearchResult(0,empty);
			}
	 		
	 		return searchResult;
	    }
	
	
	

}

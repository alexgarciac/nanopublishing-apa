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
	 		
	 		System.out.println("Holi "+ uri+" "+limit);
			ArrayList<Annotation> annotations = connector.searchAnnotationsByUriComplete(uri, limit);
			SearchResult searchResult = new SearchResult(annotations.size(),annotations);
	 	
	 		if(annotations!=null)
				return  searchResult;
			else
			{
	 		ArrayList<Annotation> empty = new ArrayList<Annotation>();
	 		empty.add(new Annotation());
				return  new SearchResult(0,empty);
			}
	    }
	
	
	

}

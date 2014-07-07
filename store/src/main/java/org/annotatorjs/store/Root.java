
package org.annotatorjs.store;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;

import org.annotatorjs.model.Store;


@Path("/")
public class Root {
    
    /** Method processing HTTP GET requests, producing "text/plain" MIME media
     * type.
     * @return String that will be send back as a response of type "text/plain".
     */
    @GET 
    @Produces("application/json")
    public Store root(@Context UriInfo ui) {
        return new Store("Java Annotator Store API "+ui.getAbsolutePath(), "2.0.0");
    }
}

package com.mycompany.jsfapp.resources;

import ejb.BookBean;
import entity.BookMaster;
import java.util.Collection;
import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 *
 * @author 
 */
@Path("rest")
public class JakartaEE8Resource {
    @EJB BookBean book;
    
    
    @GET
    @Produces("application/json")
    public Collection<BookMaster> getBooks(){
        return book.getAllBooks();
    }
}

package com.mycompany.restapp.resources;

import java.util.ArrayList;
import java.util.Collection;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 *
 * @author 
 */
@Path("rest")
public class JakartaEE8Resource {
    
    @GET
    @Produces("text/html")
    public String hello(){
        return "<h2>Hello World of REST !!!<h2>";
    }
    
    
     @GET
     @Path("special/{pname}")
    @Produces("text/html")
    public String saySpecialhello(@PathParam("pname") String pname){
        return "<h2>Hello World of REST to "+ pname +"<h2>";
    }
    
    
    @PUT
    @Path("ucases")
    @Produces("application/json")
    @Consumes("application/json")
    public Collection<String> toUppers(Collection<String> lcases)
    {
        Collection<String> ucases = new ArrayList<>();
        
        for(String l : lcases)
        {
            ucases.add(l.toUpperCase());
        }
       
        return ucases;
    }
    
    
}

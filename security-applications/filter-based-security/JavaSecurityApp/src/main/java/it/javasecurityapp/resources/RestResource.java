/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/GenericResource.java to edit this template
 */
package it.javasecurityapp.resources;

import ejb.SecureBean;
import javax.annotation.security.DeclareRoles;
import javax.annotation.security.RolesAllowed;
import javax.ejb.EJB;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author root
 */
@Path("rest")
@DeclareRoles({"Admin","Supervisor"})
@RequestScoped
public class RestResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of RestResource
     */
    public RestResource() {
    }

    /**
     * Retrieves representation of an instance of rest.RestResource
     * @return an instance of java.lang.String
     */
   @EJB SecureBean sb;
    
    @RolesAllowed("Admin")
    @GET
    @Produces("text/html")
    public String sayHello(){
        return sb.sayHello()+ " from Secure Rest Call !!";
    }

    /**
     * PUT method for updating or creating an instance of RestResource
     * @param content representation for the resource
     */
   
}

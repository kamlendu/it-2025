/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/GenericResource.java to edit this template
 */
package rest;

import ejb.PublishBeanLocal;
import entity.Address;
import entity.Customer;
import entity.Subscription;
import java.util.Collection;
import javax.ejb.EJB;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 * REST Web Service
 *
 * @author root
 */
@Path("publish")
@RequestScoped
public class PublishResource {
    
     @EJB PublishBeanLocal pbl;

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of PublishResource
     */
    public PublishResource() {
    }

    /**
     * Retrieves representation of an instance of rest.PublishResource
     * @return an instance of java.lang.String
     */
    
    
   @POST 
   @Path("addcustomer/{fname}/{lname}")
    public void addCustomer(@PathParam("fname") String fname, @PathParam("lname") String lname) {
       
    pbl.addCustomer(fname, lname);
    }

   
    @DELETE
    @Path("remcustomer/{custid}")
    public void removeCustomer(@PathParam("custid") Integer custId) {
        pbl.removeCustomer(custId);
    }

    @GET
    @Produces("application/json")
    public Collection<Customer> getAllCustomers() {
     return pbl.getAllCustomers();
    }

    @GET
    @Path("custbyfname/{fname}")
    @Produces("application/json")
    public Collection<Customer> getAllCustomersByFirstName(@PathParam("fname") String fname) {
     return pbl.getAllCustomersByFirstName(fname);
    }

    
   
    @GET
    @Path("custbyid/{cid}")
    @Produces("application/json")
    public Customer getCustomerById(@PathParam("cid") Integer custId) {
      return pbl.getCustomerById(custId);
    }

   
    @POST
    @Path("addadress/{street}/{city}/{state}/{zip}/{cid}")
    public void addAddressToCustomer(@PathParam("street") String street, @PathParam("city") String city, @PathParam("state") String state, @PathParam("zip") String zip, @PathParam("cid") Integer custId) {
      
    pbl.addAddressToCustomer(street, city, state, zip, custId);
    }

    
    @DELETE
    @Path("remaddress/{aid}/{cid}")
    public void removeAddressFromCustomer(@PathParam("aid") Integer addressId, @PathParam("cid") Integer custId) {
       
    pbl.removeAddressFromCustomer(addressId, custId);
    }

    @GET
    @Path("addofcust/{cid}")
    @Produces("application/json")
    public Collection<Address> getAddressesOfCustomer(@PathParam("cid") Integer custId) {
       
        return pbl.getAddressesOfCustomer(custId);
    }

    
   
    @GET
    @Path("custbyaddress/{aid}")
    @Produces("application/json")
    public Customer getCustomerByAddress(@PathParam("aid") Integer addressId) {
    
        return pbl.getCustomerByAddress(addressId);
    }

    @GET
    @Path("addressbyid/{aid}")
    @Produces("application/json")
    public Address getAddressById(@PathParam("aid") Integer addressId) {
        return pbl.getAddressById(addressId);
    }

    @POST
    @Path("addsubs/{title}/{type}")
    public void addSubscription(@PathParam("title") String title, @PathParam("type") String type) {
     
    pbl.addSubscription(title, type);
    }

    
    @DELETE
    @Path("remsubs/{sid}")
    public void removeSubscription(@PathParam("sid") Integer subId) {
        pbl.removeSubscription(subId);
    }

    @POST
    @Path("addsubstocust/{cid}")
    @Consumes("application/json")
    public void addSubscriptionsToCustomer(@PathParam("cid") Integer custId, Collection<Integer> subids) {
    
        pbl.addSubscriptionsToCustomer(custId, subids);
    }

    @POST
    @Path("remsubstocust/{cid}")
    @Consumes("application/json") 
    public void removeSubscriptionsToCustomer(@PathParam("cid") Integer custId, Collection<Integer> subids) {
      pbl.removeSubscriptionsToCustomer(custId, subids);
    
    }

     @GET
    @Path("getsubsofcusts/{cid}")
    @Produces("application/json")
    public Collection<Subscription> getSubscriptionsOfCustomer(@PathParam("cid") Integer custId) {
       
        return pbl.getSubscriptionsOfCustomer(custId);
    }

     @GET
    @Path("getcustsofsubs/{sid}")
    @Produces("application/json")
    public Collection<Customer> getCustomersOfSubscription(@PathParam("sid") Integer subId) {
       return pbl.getCustomersOfSubscription(subId);
    }

     @GET
    @Path("getallsubs")
    @Produces("application/json")
    public Collection<Subscription> getAllSubscriptions() {
    return pbl.getAllSubscriptions();
    }

    
   
     @GET
    @Path("getsubbyid/{sid}")
    @Produces("application/json")
    public Subscription getSubscriptionById(@PathParam("sid") Integer subId) {
     return pbl.getSubscriptionById(subId);
    }
    
    
}

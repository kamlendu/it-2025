/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package ejb;

import entity.Address;
import entity.Customer;
import entity.Subscription;
import java.util.Collection;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author root
 */
@Stateless
public class PublishBean implements PublishBeanLocal {
    @PersistenceContext(unitName = "publishpu")
    EntityManager em;

    @Override
    public void addCustomer(String fname, String lname) {
       // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    
       Customer c = new Customer();
       c.setFirstName(fname);
       c.setLastName(lname);
       em.persist(c);
       
    
    }

    @Override
    public void updateCustomer(Integer custId, String fname, String lname) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void removeCustomer(Integer custId) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    Customer c = (Customer) em.find(Customer.class, custId );
    
    em.remove(c);
    
    }

    @Override
    public Collection<Customer> getAllCustomers() {
      //  throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    
    return em.createNamedQuery("Customer.findAll").getResultList();
      
    }

    @Override
    public Collection<Customer> getAllCustomersByFirstName(String fname) {
     //   throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    
    return em.createNamedQuery("Customer.findByFirstName")
            .setParameter("firstName", fname)
            .getResultList();
    }

    @Override
    public Collection<Customer> getAllCustomersByLastName(String lname) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Customer getCustomerById(Integer custId) {
      //  throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
     Customer c = (Customer) em.find(Customer.class, custId );
    
     return c;
    }

    @Override
    public void addAddressToCustomer(String street, String city, String state, String zip, Integer custId) {
      //  throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    
     Customer c = (Customer) em.find(Customer.class, custId );
     Collection<Address> addresses = c.getAddressCollection();
    
     Address a  = new Address();
     a.setStreet(street);
     a.setCity(city);
     a.setState(state);
     a.setZip(zip);
     a.setCustomer(c);
     
     addresses.add(a);
     c.setAddressCollection(addresses);
     
     em.persist(a);
     em.merge(c);
    
    
    
    
    }

    @Override
    public void updateAddressToCustomer(Integer addressId, String street, String city, String state, String zip, Integer custId) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void removeAddressFromCustomer(Integer addressId, Integer custId) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    
     Customer c = (Customer) em.find(Customer.class, custId );
     Address a = (Address) em.find(Address.class, addressId);
     
     Collection<Address> addresses = c.getAddressCollection();
     
     if(addresses.contains(a))
     {
         addresses.remove(a);
         c.setAddressCollection(addresses);
         
         em.remove(a);
         
         
     }
    
    
    }

    @Override
    public Collection<Address> getAddressesOfCustomer(Integer custId) {
       // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
     Customer c = (Customer) em.find(Customer.class, custId );
    return c.getAddressCollection();
    }

    @Override
    public Collection<Address> getAddressesOfCustomerByCity(Integer custId, String city) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Collection<Address> getAddressesByCity(String city) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Collection<Address> getAddressesOfCustomerByState(Integer custId, String state) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Collection<Address> getAddressesByState(String state) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Collection<Address> getAddressesOfCustomerByZip(Integer custId, String zip) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Collection<Address> getAddressesByZip(String zip) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Customer getCustomerByAddress(Integer addressId) {
     //   throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    Address a = (Address) em.find(Address.class, addressId);
    return a.getCustomer();
    }

    @Override
    public Address getAddressById(Integer addressId) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
     Address a = (Address) em.find(Address.class, addressId);
    return a;
    }

    @Override
    public void addSubscription(String title, String type) {
      //  throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    
    Subscription s = new  Subscription();
    s.setTitle(title);
    s.setType(type);
    
    em.persist(s);
    
    }

    @Override
    public void updateSubscription(Integer subId, String title, String type) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void removeSubscription(Integer subId) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    Subscription s  = (Subscription) em.find(Subscription.class, subId);
    
    em.remove(s);
    
    }

    @Override
    public void addSubscriptionsToCustomer(Integer custId, Collection<Integer> subids) {
      //  throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
   
    Customer c = (Customer) em.find(Customer.class, custId);
    Collection<Subscription> subs = c.getSubscriptionCollection();
    
    for(Integer sid : subids)
    {
    
        Subscription s = (Subscription) em.find(Subscription.class, sid);
        
        if(!subs.contains(s))
        {
    
            Collection<Customer> custs = s.getCustomerCollection();
            
            custs.add(c);
            subs.add(s);
            
            c.setSubscriptionCollection(subs);
            s.setCustomerCollection(custs);
            
            em.merge(c);
            
        }
        
        }
    
    }

    @Override
    public void removeSubscriptionsToCustomer(Integer custId, Collection<Integer> subids) {
       // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
      Customer c = (Customer) em.find(Customer.class, custId);
    Collection<Subscription> subs = c.getSubscriptionCollection();
    
    for(Integer sid : subids)
    {
    
        Subscription s = (Subscription) em.find(Subscription.class, sid);
        
        if(subs.contains(s))
        {
    
            Collection<Customer> custs = s.getCustomerCollection();
            
            custs.remove(c);
            subs.remove(s);
            
            c.setSubscriptionCollection(subs);
            s.setCustomerCollection(custs);
            
            em.merge(c);
            
        }
        
        }
    
    
    }

    @Override
    public Collection<Subscription> getSubscriptionsOfCustomer(Integer custId) {
       // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
     Customer c = (Customer) em.find(Customer.class, custId);
    return c.getSubscriptionCollection();
    }

    @Override
    public Collection<Customer> getCustomersOfSubscription(Integer subId) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    Subscription s = (Subscription) em.find(Subscription.class, subId);
    return s.getCustomerCollection();
    }

    @Override
    public Collection<Subscription> getAllSubscriptions() {
       // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    
    return em.createNamedQuery("Subscription.findAll").getResultList();
    }

    @Override
    public Collection<Subscription> getAllSubscriptionsByType(String type) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Subscription getSubscriptionById(Integer subId) {
      //  throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    
     Subscription s = (Subscription) em.find(Subscription.class, subId);
  
    return s;
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")



}

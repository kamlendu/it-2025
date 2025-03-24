/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionLocal.java to edit this template
 */
package ejb;

import entity.Address;
import entity.Customer;
import entity.Subscription;
import java.util.Collection;
import javax.ejb.Local;

/**
 *
 * @author root
 */
@Local
public interface PublishBeanLocal {
    
    //==== Customer ====
    void addCustomer(String fname, String lname);
    void updateCustomer(Integer custId, String fname, String lname);
    void removeCustomer(Integer custId);
    Collection<Customer> getAllCustomers();
    Collection<Customer> getAllCustomersByFirstName(String fname);
    Collection<Customer> getAllCustomersByLastName(String lname);
    Customer getCustomerById(Integer custId);
    
    //=== Address ====
    
    void addAddressToCustomer(String street, String city, String state, String zip, Integer custId);
     void updateAddressToCustomer(Integer addressId, String street, String city, String state, String zip, Integer custId);
   void removeAddressFromCustomer(Integer addressId, Integer custId);
   Collection<Address> getAddressesOfCustomer(Integer custId);
   Collection<Address> getAddressesOfCustomerByCity(Integer custId, String city);
   Collection<Address> getAddressesByCity(String city);
   Collection<Address> getAddressesOfCustomerByState(Integer custId, String state);
   Collection<Address> getAddressesByState(String state);
   Collection<Address> getAddressesOfCustomerByZip(Integer custId, String zip);
   Collection<Address> getAddressesByZip(String zip);
   Customer  getCustomerByAddress(Integer addressId);
   Address getAddressById(Integer addressId);
   
   //==== Subscription =====
   
   void addSubscription(String title, String type);
   void updateSubscription(Integer subId, String title, String type);
   void removeSubscription(Integer subId);
   void addSubscriptionsToCustomer(Integer custId, Collection<Integer> subids);
   void removeSubscriptionsToCustomer(Integer custId, Collection<Integer> subids);
   
   Collection<Subscription> getSubscriptionsOfCustomer(Integer custId);
   Collection<Customer> getCustomersOfSubscription(Integer subId);
   
   Collection<Subscription> getAllSubscriptions();
   Collection<Subscription> getAllSubscriptionsByType(String type);
   Subscription getSubscriptionById(Integer subId);
   
   
  
   
   
   
   
   
   
    
    
    
    
    
    
}

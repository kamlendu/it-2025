/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package ejb;

import entity.BookMaster;
import java.util.Collection;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author root
 */
@Stateless
public class DataBean implements DataBeanLocal {
    
    @PersistenceContext(unitName = "datapu")
    EntityManager em;

    @Override
    public Collection<BookMaster> getAllBooks() {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    
     Collection<BookMaster> books = em.createNamedQuery("BookMaster.findAll").getResultList();
    
    return books;
    }

    @Override
    public void addBook(String bookName, String authorName, String publisherName, String synopsis) {
      //  throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    
      BookMaster b = new  BookMaster();
      b.setBookName(bookName);
      b.setAuthorName(authorName);
      b.setPublisherName(publisherName);
      b.setSynopsis(synopsis);
      
      em.persist(b);
    
    
    }

    @Override
    public void updateBook(Integer id, String bookName, String authorName, String publisherName, String synopsis) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    
        BookMaster b = (BookMaster) em.find(BookMaster.class, id);
       b.setBookName(bookName);
       b.setAuthorName(authorName);
       b.setPublisherName(publisherName);
       b.setSynopsis(synopsis);
    
        em.merge(b);
    
    }

    @Override
    public void removeBook(Integer id) {
      //  throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    
    BookMaster b = (BookMaster) em.find(BookMaster.class, id);
    
    em.remove(b);
    
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public Collection<BookMaster> getBooksByPublisher(String pname) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    
//    Collection<BookMaster> books = em.createNamedQuery("BookMaster.findByPublisherName")
//            .setParameter("publisherName", pname)
//            .getResultList();


String query = "SELECT b FROM BookMaster b WHERE b.publisherName = :publisherName";

Collection<BookMaster> books = em.createQuery(query)
        .setParameter("publisherName", pname)
        .getResultList();


    
    return books;
    }




}

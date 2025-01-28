
import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/ServletListener.java to edit this template
 */

/**
 * Web application lifecycle listener.
 *
 * @author root
 */
public class NewServletListener implements ServletContextListener, ServletContextAttributeListener, HttpSessionListener, HttpSessionAttributeListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        
        sce.getServletContext().setAttribute("company","XYZ Ltd.");
        System.out.println("Context Initialized .....");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        
        sce.getServletContext().removeAttribute("company");
          System.out.println("Context Destroyed .....");
    }
    

    @Override
    public void attributeAdded(ServletContextAttributeEvent event) {
        
        System.out.println("Context Attribute Added....."+ event.getName() + " value = "+ event.getValue());
        
    }

    @Override
    public void attributeRemoved(ServletContextAttributeEvent event) {
   System.out.println("Context Attribute removed.....");
    
    }

    @Override
    public void attributeReplaced(ServletContextAttributeEvent event) {
    
    System.out.println("Context Attribute replaced with....."+ event.getValue());
    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        
        System.out.println("Session Created.....");
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        
         System.out.println("Session Destroyed.....");
    }

    @Override
    public void attributeAdded(HttpSessionBindingEvent event) {
        
         System.out.println("Session Attribute added with name ="+ event.getName()+ "  value = "+ event.getValue());
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent event) {
           System.out.println("Session Attribute removed with name ="+ event.getName()+ "  value = "+ event.getValue());

    
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent event) {
        
                System.out.println("Session Attribute replaced with name ="+ event.getName()+ "  value = "+ event.getValue());

    }
}

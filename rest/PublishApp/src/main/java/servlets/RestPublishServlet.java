/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import client.PublishClient;
import entity.Address;
import entity.Customer;
import entity.Subscription;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

/**
 *
 * @author root
 */
@WebServlet(name = "RestPublishServlet", urlPatterns = {"/RestPublishServlet"})
public class RestPublishServlet extends HttpServlet {
    
    PublishClient pbl;
    Response rs;
    Collection<Customer> customers;
    Collection<Address> addresses;
    Collection<Subscription> subs;
    
   GenericType<Collection<Customer>> gcustomers;
    GenericType<Collection<Address>> gaddresses;
    GenericType<Collection<Subscription>> gsubs;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet RestPublishServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            
            pbl = new PublishClient();
            
            customers = new ArrayList<>();
            addresses = new ArrayList<>();
            subs = new ArrayList<>();
            
            gcustomers = new GenericType<Collection<Customer>>(){};
            gaddresses = new GenericType<Collection<Address>>(){};
            gsubs = new GenericType<Collection<Subscription>>(){};
            
            
            //pbl.addCustomer("Rohit", "Sharma");
            
          //pbl.addAddressToCustomer("10th Street", "Pune", "Maharashtra", "445123", "11");
          //pbl.addAddressToCustomer("13th Street", "Surat", "Gujarat", "395005", "11");
          //         Collection<Integer> subids = new ArrayList<>();  
         
          //      pbl.removeAddressFromCustomer("8", "11");
           //    pbl.removeAddressFromCustomer("9", "11");
          
          pbl.removeCustomer("11");
          Collection<Integer> subids = new ArrayList<>();
         subids.add(1);
         subids.add(2);
         subids.add(3);
         
        //pbl.addSubscriptionsToCustomer(subids, "11");
      //  pbl.removeSubscriptionsToCustomer(subids, "11");
         
        
        
        rs = pbl.getAllCustomers(Response.class);
            
             customers = rs.readEntity(gcustomers);
            
            for(Customer c : customers)
            {
            out.println("<br> custid = "+ c.getCustomerID()+  " Name : "+ c.getFirstName() + "  "+ c.getLastName());
            
            rs = pbl.getAddressesOfCustomer(Response.class, c.getCustomerID().toString());
            addresses = rs.readEntity(gaddresses);
            
            for(Address a : addresses)
            {
                
                out.println("<br> + addressid : "+ a.getAddressId()+ " street : "+ a.getStreet()+ " City : "+ a.getCity()+ " State : "+ a.getState());
            }
            
            rs = pbl.getSubscriptionsOfCustomer(Response.class, c.getCustomerID().toString());
             subs = rs.readEntity(gsubs);
            
            for(Subscription s : subs)
            {
                out.println("<br/>sub id : "+ s.getSubscriptionId()+ " Title : "+ s.getTitle()+ " Type : "+ s.getType());
            }
            
            out.println("<hr/>");
            
            }
            
            out.println("<h1>Servlet RestPublishServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

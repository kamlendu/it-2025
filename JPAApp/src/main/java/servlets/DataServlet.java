/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import ejb.DataBeanLocal;
import entity.BookMaster;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author root
 */
@WebServlet(name = "DataServlet", urlPatterns = {"/DataServlet"})
public class DataServlet extends HttpServlet {
    
    @EJB DataBeanLocal dbl;

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
            out.println("<title>Servlet DataServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            
           // dbl.addBook("World Peace", "T. Eliot", "Rupa", "General world politics");
           // dbl.updateBook(361, "Entire World Peace", "P. Thomson", "Rupa", "World Politics");
         //  dbl.removeBook(361);
           
           Collection<BookMaster> books = dbl.getAllBooks();
            out.println("<table border='1'>");
            for(BookMaster b : books)
            {
                
                out.println("<tr><td>"+ b.getBookID()+"</td><td>"+b.getBookName()+"</td><td>"+b.getAuthorName()+"</td><td>"+b.getPublisherName()+"</td><td>"+ b.getSynopsis()+"</td></tr>");
            }
            
            out.println("</table><br/><br/>");
            
          
            Collection<BookMaster> pbooks = dbl.getBooksByPublisher("TMH");
            out.println("<table border='1'>");
            for(BookMaster b : pbooks)
            {
                
                out.println("<tr><td>"+ b.getBookID()+"</td><td>"+b.getBookName()+"</td><td>"+b.getAuthorName()+"</td><td>"+b.getPublisherName()+"</td><td>"+ b.getSynopsis()+"</td></tr>");
            }
            
            out.println("</table>");
            out.println("</h2><h1>Servlet DataServlet at " + request.getContextPath() + "</h1>");
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

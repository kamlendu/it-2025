/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

//import ejb.MyLocalHelloLocal;
import ejb.MyRemoteBeanLocal;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author root
 */
@WebServlet(name = "RemoteServlet", urlPatterns = {"/RemoteServlet"})
public class RemoteServlet extends HttpServlet {
    
 // @EJB   MyLocalHelloLocal mylocal;
 // @EJB(mappedName = "ejb/rhello") 
          MyRemoteBeanLocal myremote;

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
            out.println("<title>Servlet RemoteServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            
            Properties p = new Properties();
            p.setProperty("org.omg.CORBA.ORBInitialHost", "localhost");
            p.setProperty("org.omg.CORBA.ORBInitialPort", "3700");
            
            try {
                
                InitialContext ic = new InitialContext(p);
                
                myremote= (MyRemoteBeanLocal)ic.lookup("ejb/rhello");
           
            
            } catch (NamingException ex) {
                Logger.getLogger(RemoteServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
            
            
            
            
            
            
            out.println("<h1> Remote Bean Says : " + myremote.sayRemoteHello("M.Sc. IT") + "</h1>");
       //     out.println("<h1> Local Bean Says : " + mylocal.sayLocalHello("M.Sc. IT") + "</h1>");
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

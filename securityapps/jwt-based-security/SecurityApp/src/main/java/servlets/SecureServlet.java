/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import client.HelloClient;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.security.DeclareRoles;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.HttpConstraint;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import record.KeepRecord;

/**
 *
 * @author root
 */
@DeclareRoles({"Admin","Supervisor"})
@ServletSecurity(@HttpConstraint(rolesAllowed = {"Admin","Supervisor"}))
@WebServlet(name = "SecureServlet", urlPatterns = {"/SecureServlet"})
public class SecureServlet extends HttpServlet {
//@EJB HelloBeanLocal cl; 
    @Inject KeepRecord keepRecord;

    HelloClient cl;

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
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet SecureServllet</title>");            
            out.println("</head>");
            out.println("<body>");
//            String username = request.getSession().getAttribute("username").toString();
//            String password = request.getSession().getAttribute("password").toString();
String sessionId = request.getSession().getId();

        HttpClient client = HttpClient.newHttpClient();
            try {
                HttpRequest request1 = HttpRequest.newBuilder()
                        .uri(new URI("https://localhost:8181/SecurityApp/resources/rest"))
                        .header("Cookie", "JSESSIONID=" + sessionId)
                        .GET()  
                        .build();
            } catch (URISyntaxException ex) {
                Logger.getLogger(SecureServlet.class.getName()).log(Level.SEVERE, null, ex);
            }


//HttpURLConnection conn = (HttpURLConnection) new URL("https://localhost:8181/SecurityApp/resources/rest").openConnection();
//conn.setRequestMethod("GET");
//conn.setRequestProperty("Cookie", "JSESSIONID="+request.getSession().getId());
             cl = new HelloClient(keepRecord.getToken());
            
           // out.println("<h1>Servlet SecureServllet at " + request.getContextPath() + "</h1>");
           out.println("A secure Call :  " + cl.sayHello() + "</h1>");
           
            
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

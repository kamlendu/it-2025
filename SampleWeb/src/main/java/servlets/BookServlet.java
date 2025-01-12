package servlets;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author root
 */
@WebServlet(name = "BookServlet", urlPatterns = {"/BookServlet"})
public class BookServlet extends HttpServlet {
    
    Connection con;
    ResultSet rs;
    Statement stmt;
    PreparedStatement psmt;

    public BookServlet() {
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?useSSL=false", "root", "ompandey");
            
            
            
            
        }
        catch(ClassNotFoundException e)
        {
           System.out.println("No Such Driver Found");
        }
        catch(SQLException sq)
        {
            System.out.println("Could not connect to the database");
        }
    }
    
    
    
    

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
            out.println("<title>Servlet BookServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet BookServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            
          String bname = request.getParameter("bname");
              String aname= request.getParameter("authname");
             String pname = request.getParameter("pname");
             String synopsis= request.getParameter("synopsis");
             
          try{
             
         //    addBook(bname, aname, pname, synopsis);
  







     stmt = con.createStatement();
     rs = stmt.executeQuery("select * from BookMaster");

 out.println("<table border='1'>");
 
 while(rs.next())
            {
                out.println("<tr><td>"
                +rs.getString("BookName")+"</td><td>"
                +rs.getString("AuthorName")+"</td><td>"
                +rs.getString("PublisherName")+"</td><td>"
                +rs.getString("Synopsis")+"</td><td>"
                + "<a href='?BookID="+rs.getString("BookID")+"&mode=update'>Update</a></td><td>"+"</td><td>"
                +"<a href='?BookID="+rs.getString("BookID")+"&mode=del'>Delete</a></td><td>"+"</td>"
                );
            }
     
out.println("</table>");


            
            
            
}
catch(SQLException sqx)
{
    sqx.printStackTrace();
}
            
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

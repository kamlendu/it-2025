<%-- 
    Document   : Books
    Created on : 23-Jan-2025, 12:25:04 PM
    Author     : root
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>
            <%!
                
            String bname;
            String pname;
            String authname;
            String synopsis;

                
                %>
            
         <%   
            bname = request.getParameter("bname");
            authname = request.getParameter("authname");
            pname = request.getParameter("pname"); 
            synopsis = request.getParameter("synopsis");  
            
            
            
           %>
           
           <br/> Book Name: <%=bname.toUpperCase()%>
           <br/> Author Name: <%=authname.toUpperCase()%>
            <br/> Publisher Name: <%=pname.toUpperCase()%>
             <br/> Synopsis: <%=synopsis%>
           
           
           
           
        </h1>
    </body>
</html>

<%-- 
    Document   : Another.jsp
    Created on : 27-Jan-2025, 10:44:27 AM
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
            
            Full Name = <%=session.getAttribute("full")%>
            <br/> Company = <%=application.getAttribute("company")%>
                     
            
        </h1>
    </body>
</html>

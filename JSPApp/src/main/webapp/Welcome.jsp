<%-- 
    Document   : Welcome
    Created on : 23-Jan-2025, 12:02:16 PM
    Author     : root
--%>

<%@page contentType="text/html" import="java.util.Date" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%@include  file="Header.jsp" %>
       
        <%!
            String fullName;
            
            %>
        
            <%-- Getting Parameters --%>
        <%
            String firstName = request.getParameter("fname");
             String lastName = request.getParameter("lname");
            
           fullName = firstName + " "+ lastName;
            
            //out.println("Full Name : "+ fullName);
            
            %>
        
        
        
        <h1>
            Today date is <%=new Date().toString()%>
            
            <br/>The Full Name is : <%=fullName%>
        </h1>
    </body>
</html>

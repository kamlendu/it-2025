<%-- 
    Document   : Welcome
    Created on : 03-Feb-2025, 10:47:37 AM
    Author     : root
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            
             pageContext.setAttribute("user", "I am a page");
            request.setAttribute("user", "There is error in the page");
            session.setAttribute("user", "Admin");
            application.setAttribute("user", "XYZ Ltd.");
            %>
         
        <c:set var="x" value="50"/>
        <c:set var="y" value="70"/>
        <c:set var="num1" value="${param.m}"/>
        <c:set var="num2" value="${param.n}"/>
        <h1>
          
             <br/> <c:out value="The value of user is ${pageScope.user}"/>
             <br/> <c:out value="The value of user is ${requestScope.user}"/>
             <br/> <c:out value="The value of user is ${sessionScope.user}"/>
             <br/> <c:out value="The value of user is ${applicationScope.user}"/>
           
            
             <br/> <c:out value=" The sum of ${num1} and ${num2}  is ${num1+num2}"/>
           
            <br/> <c:out value=" The sum of ${x} and ${y}  is ${x+y}"/>
            
           <br/> <c:out value="The sum of 40 and 60 is ${40+60}"/>
            
        <br/>    
        <c:out value="Hello World of JSTL and EL"/>
        
        <c:forEach var="i" begin="1" end="10">
            <br/>The square of ${i} is ${i*i}
        </c:forEach>
        
        </h1>
        
        <c:forEach var="q" items="${paramValues.qual}">
         <br/>   ${q}
        </c:forEach>
        
    </body>
</html>

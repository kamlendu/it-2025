<%-- 
    Document   : condition
    Created on : 03-Feb-2025, 11:23:33 AM
    Author     : root
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>
            <c:set var="x" value="19"/>
            
            <c:if test="${x<15}">
                <br> x is less than 15
            </c:if>
            <c:if test="${x>15}">
                <br> x is greater than 15
            </c:if>
            <c:if test="${x==15}">
                <br> x is equal to  15
            </c:if>
                
                <c:choose>
                    <c:when test="${x>15}">
                      <br> x is greater than 15    
                    </c:when>
                       <c:when test="${x<15}">
                      <br> x is less than 15    
                    </c:when>
                    <c:otherwise>
                        <br> x is equal to 15 
                    </c:otherwise>
                </c:choose>      
                
                
                
                
            
            
            
            
            
            
            
            
        </h1>
    </body>
</html>

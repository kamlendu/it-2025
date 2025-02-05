<%-- 
    Document   : formating
    Created on : 05-Feb-2025, 11:43:22 AM
    Author     : root
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            request.setAttribute("curdate", new java.util.Date());
            %>
            
            <fmt:setLocale value="hi_IN"/>
            <fmt:setBundle basename="myvalues" var="val"/>       
            
            
            <br/> <fmt:message key="welcome" bundle="${val}"/>
            
            <br/>
            
            <fmt:setLocale value="gu_IN"/>
            <fmt:formatDate type="both" value="${curdate}"/>
            <br/><fmt:formatDate type="date" value="${curdate}"/>
            <br/><fmt:formatDate type="time" value="${curdate}"/>
            <br/><fmt:formatDate pattern="dd-MMM-YYYY hh:mm:ss" value="${curdate}"/>
            
            <c:set var="x" value="73421.86421"/>
           <br/><br/><br/><br/> <c:out value="${x}"/>
            <br/><fmt:formatNumber maxFractionDigits="2" value="${x}"/>
            <br/><fmt:formatNumber maxIntegerDigits="3" value="${x}"/>
            <br/><fmt:formatNumber type="currency" currencySymbol="$" maxFractionDigits="2" value="${x}"/>
           
            
        
        <h1></h1>
    </body>
</html>

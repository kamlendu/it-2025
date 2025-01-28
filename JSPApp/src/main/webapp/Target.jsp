<%-- 
    Document   : Target
    Created on : 27-Jan-2025, 11:16:01 AM
    Author     : root
--%>
<jsp:useBean id="emp" class="bean.Employee" scope="request"/>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>
            
     <br/>     <jsp:getProperty name="emp" property="empno"/>
    <br/>    <jsp:getProperty name="emp" property="ename"/>
     <br/>   <jsp:getProperty name="emp" property="salary"/>
          
            
            
        </h1>
    </body>
</html>

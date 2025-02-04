<%-- 
    Document   : data
    Created on : 04-Feb-2025, 11:43:54 AM
    Author     : root
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib  prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <sql:setDataSource dataSource="jdbc/itdata"/>
        
        
        <sql:update var="insert">
            insert into employee values(?,?,?)
            <sql:param value="21"/>
            <sql:param value="Prathamesh"/>
            <sql:param value="15000"/>           
        </sql:update>
  
            
            
            
        <sql:query var="query">
            select * from employee
        </sql:query>
        
            <table border="1">
            <c:forEach var="row" items="${query.rowsByIndex}">
                <tr><td>${row[0]}</td><td>${row[1]}</td><td>${row[2]}</td></tr>  
            </c:forEach>    
            
            </table>
        
        <h1>Hello World!</h1>
    </body>
</html>

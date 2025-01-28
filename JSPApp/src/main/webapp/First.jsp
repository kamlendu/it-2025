<%-- 
    Document   : First
    Created on : 27-Jan-2025, 10:57:16 AM
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
        <h1>Hello World From First Page</h1>
        
<%--        <jsp:include page="Second.jsp">
            <jsp:param name="city" value="Surat"/>
        </jsp:include>
        --%>
         <jsp:forward page="Second.jsp">
            <jsp:param name="city" value="Surat"/>
        </jsp:forward>
    </body>
</html>

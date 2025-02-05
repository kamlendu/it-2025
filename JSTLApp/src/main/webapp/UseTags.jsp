<%-- 
    Document   : UseTags
    Created on : 05-Feb-2025, 12:24:42 PM
    Author     : root
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  prefix="mytags" tagdir="/WEB-INF/tags/" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>The current date is <mytags:curdate/></h1>
        <br/> <mytags:upper> m.sc. it </mytags:upper>
        <br/><!-- comment -->
        <mytags:ccase type="uppersasa"> hello </mytags:ccase>
        
    </body>
</html>

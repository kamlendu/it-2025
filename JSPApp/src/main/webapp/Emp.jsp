<%-- 
    Document   : Emp.jsp
    Created on : 28-Jan-2025, 11:44:54 AM
    Author     : root
--%>
<jsp:useBean id="emp" class="bean.Employee" scope="request">
    <jsp:setProperty name="emp" property="*"/>
</jsp:useBean>    
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>
            
            <%
                
            if(emp.validate())
            {
             out.println("<br/>Emp no :"+ emp.getEmpno());
             out.println("<br/>Ename :"+ emp.getEname());
             out.println("<br/>Emp no :"+ emp.getSalary());
            }
            else
            {
                %>
                <jsp:forward page="EmpForm.jsp"/>
                
                <%
                    }
                    %>
            
            
            
            
            
            
            
            
            
            
            
            
        </h1>
    </body>
</html>

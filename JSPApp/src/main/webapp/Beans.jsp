<%-- 
    Document   : Beans
    Created on : 27-Jan-2025, 11:08:28 AM
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
        <h2> UseBean Tag Methods </h2>
        <jsp:setProperty name="emp" property="empno" value="1"/>
        <jsp:setProperty name="emp" property="ename" value="Prakash"/>
        <jsp:setProperty name="emp" property="salary" value="5000.0"/>
        
        
   <br/>     <jsp:getProperty name="emp" property="empno"/>
    <br/>    <jsp:getProperty name="emp" property="ename"/>
     <br/>   <jsp:getProperty name="emp" property="salary"/>
        
     <h2> Java Methods </h2>
        <br/> Empno : <%=emp.getEmpno()%>
        <br/> Ename : <%=emp.getEname()%>
        <br/> Salary : <%=emp.getSalary()%>
        
        
         <jsp:forward page="Target.jsp">
            <jsp:param name="city" value="Surat"/>
        </jsp:forward>
        
        <h1>Hello World!</h1>
    </body>
</html>

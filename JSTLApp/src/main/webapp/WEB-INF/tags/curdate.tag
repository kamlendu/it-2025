<%-- 
    Document   : curdate
    Created on : 05-Feb-2025, 12:22:35 PM
    Author     : root
--%>

<%@tag description="put the tag description here" pageEncoding="UTF-8"%>

<%-- The list of normal or fragment attributes can be specified here: --%>
<%@attribute name="message"%>

<%-- any content can be specified here e.g.: --%>
<h2>
    <%
        out.print(new java.util.Date().toString());
        %> 
    
    
</h2>
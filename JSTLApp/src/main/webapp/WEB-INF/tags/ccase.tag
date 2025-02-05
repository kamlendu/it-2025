<%-- 
    Document   : ccase
    Created on : 05-Feb-2025, 12:33:35 PM
    Author     : root
--%>

<%@tag description="put the tag description here" pageEncoding="UTF-8"%>

<%-- The list of normal or fragment attributes can be specified here: --%>
<%@attribute name="type"%>
<jsp:doBody var="content"/>

<%-- any content can be specified here e.g.: --%>
<h2>
    <%
    String type = jspContext.getAttribute("type").toString();
    String str = jspContext.getAttribute("content").toString();
    
    if(type.equals("upper"))
    out.println(str.toUpperCase());
    else if(type.equals("lower"))
    out.println(str.toLowerCase());
    else
    out.println("error : attribute values are wrong");
    

    
    %>
</h2>
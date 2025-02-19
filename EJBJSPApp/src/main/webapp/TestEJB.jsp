<%-- 
    Document   : TestEJB
    Created on : Feb 19, 2025, 11:43:11 AM
    Author     : root
--%>

<%@page import="java.util.Properties"%>
<%@page import="ejb.MyRemoteBeanLocal, ejb.MathBeanLocal, javax.naming.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%!
            MyRemoteBeanLocal mr=null;
            MathBeanLocal ml=null;
            

            public void jspInit()
            {
                try{

                Properties p = new Properties();
                p.setProperty("org.omg.CORBA.ORBInitialHost", "localhost");
                p.setProperty("org.omg.CORBA.ORBInitialPort", "3700");
                
                 InitialContext ic = new InitialContext(p);

                mr = (MyRemoteBeanLocal)ic.lookup("ejb/rhello");
                
                InitialContext ic1 = new InitialContext();

                ml = (MathBeanLocal) ic1.lookup("java:global/EJBJSPApp/MathBean");


               }

                 catch(Exception e )
               { 

                }
              }       

              public void jspDestroy()
                {
                    mr=null;
                    ml=null;

                 }
            
            
            %>
        
        
        
        
        
        
        <h1>
            <br/>Remote Bean Say : <%=mr.sayRemoteHello("M.Sc. IT")%>
        <br/>Local Bean Say-  The sum of 40 and 60 is  : <%=ml.add(40,60)%>
        
        </h1>
    </body>
</html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Authentication Page</title>
    </head>
    <body>

      

        <form method="POST" action="j_security_check">
            <table border ="1">
                <tr>
                    <td colspan="2">Login:</td>
                </tr>
                <tr>
                    <td>User Name:</td>
                    <td><input type="text" name="j_username"/></td>
                </tr>

                <tr>
                    <td>Password:</td>
                    <td><input type="password" name="j_password"/></td>
                </tr>
                <tr>
                    <td><input type="submit" name="submit" value="submit"/></td>
                    <td><input type="reset"/></td>
                </tr>
            </table>
        </form>

        <br>
        <% if(request.getAttribute("error")!=null) {%>
        <div style="color:red"> ** <%=request.getAttribute("error")%></div>
        <% } %>
    </body>
</html>
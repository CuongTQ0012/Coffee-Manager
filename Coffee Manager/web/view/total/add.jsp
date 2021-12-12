<%@page import="model.Total"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        
        <%
            ArrayList<Total> total = (ArrayList<Total>)request.getAttribute("cate");
        %>
        
    </head>
    <body>
        <form method="POST" action="add">
            
            
            Drinks ID: <input type="text" name="did"/> <br/>
            Quantity: <input type="text" name="tQuan"/> <br/>
            Date <input type="Date" name="tdob"/> <br/>
            
            
            
            <br/>
            <input type="submit" value="Save"/>
        </form>
    </body>
</html>

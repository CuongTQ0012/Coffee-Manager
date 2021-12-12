<%@page import="model.Total"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%
            Total total = (Total)request.getAttribute("total");
        %>
    <h1>Edit Total</h1>
    </head>
        
    <body>
        <a href="../product/list">Product</a>
        <form method="POST" action="edit">
            id: <%=total.gettID()%> <br>
            Drinks: <%=total.getdID().getdID()%> 
            <input type="hidden" name="tid" value="<%=total.gettID() %>"/>
            <input type="hidden" name="did" value="<%=total.getdID().getdID() %>"/>
            <br/>
            
            
            Quantity: <input type="text" name="tquan" value="<%=total.gettQuantity()%>"/> <br/>
            Date <input type="Date" name="tdob" value="<%=total.getTdob()%>"/> <br/>
            
            
            <br/>
            <input type="submit" value="Save"/>
        </form>

    </body>
</html>
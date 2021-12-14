<%@page import="model.DrinksDetail"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Drink Detail</title>
        <%
            DrinksDetail drinksDetail = (DrinksDetail)request.getAttribute("drinksDetail");
        %>
        
    </head>
        
    <body>
        <form method="POST" action="edit">
            id: <%=drinksDetail.getDdID()%> <br>
            Drinks: <%=drinksDetail.getdID().getdName()%> <br>
            Product: <%=drinksDetail.getPid().getpName()%> <br>
            <input type="hidden" name="ddid" value="<%=drinksDetail.getDdID() %>"/>
            <input type="hidden" name="did" value="<%=drinksDetail.getdID().getdID() %>"/>
            <input type="hidden" name="pid" value="<%=drinksDetail.getPid().getpID() %>"/>
            
            
            Quantity: <input type="text" name="tquan" value="<%=drinksDetail.getDdQuantity()%>"/> <br/>
            
            
            <br/>
            <input type="submit" value="Save"/>
        </form>

    </body>
</html>
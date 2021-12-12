<%-- 
    Document   : detail1
    Created on : Dec 12, 2021, 9:27:21 AM
    Author     : Admin
--%>
<%@page import="model.DrinksDetail"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>


        <%
            ArrayList<DrinksDetail> drinksdetail = (ArrayList<DrinksDetail>) request.getAttribute("ddetail");

            String id = request.getParameter("id");
            int id_int = Integer.parseInt(id);
        %>

    </head>
    <body>
        <a href="list">List</a>
        <h2>Drinks Detail id: <%=id%> </h2>


        <table border="1px"> 
            <tr>
                <td>Drink</td>
                <td>Product</td>
                <td>Quan</td>
            </tr>

            <% for (DrinksDetail dd : drinksdetail) {%>
            <tr>
                <td><%=dd.getdID().getdName()%></td>
                <td><%=dd.getPid().getpName()%></td>
                <td><%=dd.getDdQuantity()%></td>
            </tr>    
            <%}%>
        </table>
        </br>
        <input type="button" value="Add Drinks Detail" 
               onclick="window.location.href = 'add_drinks_detail?id=<%=id%>'" />

    </body>
</html>

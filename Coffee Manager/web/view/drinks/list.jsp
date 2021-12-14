<%@page import="model.Drinks"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>List Drinks</title>
        <%
            ArrayList<Drinks> drinks = (ArrayList<Drinks>)request.getAttribute("drinks");
        %>
    </head>
    <body>
        <a href="../product/list">Product</a>
        <a href="../drinks/list">Drinks</a>
        <a href="../total/list">Total</a>
        <table border="1px"> 
            <tr>
                <td>ID</td>
                <td>Name</td>
                <td>Image</td>
            </tr>
            
            
            <% for (Drinks p : drinks) {%>
            <tr>
                <td><%=p.getdID()%></td>
                <td><%=p.getdName()%></td>
                <td>
                    <img src="../<%=p.getdImage()%>" width=100px height=120px>
                </td><!--image-->
                <td>
                    <input type="button" value="Detail" 
                           onclick="window.location.href = 'detail1?id=<%=p.getdID()%>' " />
                    
                </td>
            </tr>    
            <%}%>
            
            
        </table>
        
        
        
        
        <input type="button" value="Add" onclick="window.location.href = 'add' " />
        
    </body>
</html>

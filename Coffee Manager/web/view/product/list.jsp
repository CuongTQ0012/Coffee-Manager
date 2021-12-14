
<%@page import="model.Category"%>
<%@page import="model.Product"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>List Product</title>
        <%
            ArrayList<Product> product = (ArrayList<Product>)request.getAttribute("product");
        %>
    </head>
    <body>
        <a href="../product/list">Product</a>
        <a href="../drinks/list">Drinks</a>
        <a href="../total/list">Total</a>
        
        <form action="list" method="POST">
            
            
            <table border="0">
                <tbody>
                    <tr>
                        <td>Name Product</td>
                        <td><input type="text" name="search" value="" /></td>
                        <td><input type="submit" value="Search" /></td>
                    </tr>
                </tbody>
            </table>

            </form>
        
        
        
        <table border="1px"> 
            <tr>
                <td>ID</td>
                <td>Name</td>
                <td>Quantity</td>
                <td>Unit</td>
                <td></td>
            </tr>
            
            
            <% for (Product p : product) {%>
            <tr>
                
                <td><%=p.getpID()%></td>
                <td><%=p.getpName()%></td>
                <td><%=p.getpQuantity()%></td>
                <td><%=p.getCate().getcName()%></td>
                <td>
                    <input type="button" value="Edit" 
                           onclick="window.location.href = 'edit?id=<%=p.getpID()%>' " />
                    
                    <input type="button" value="Delete" 
                           onclick="window.location.href = 'delete?id=<%=p.getpID()%>' " />
                </td>
            </tr>    
            <%}%>
            
            
        </table>
        
        
        
        
        <input type="button" value="Add" onclick="window.location.href = 'add' " />
        
    </body>
</html>

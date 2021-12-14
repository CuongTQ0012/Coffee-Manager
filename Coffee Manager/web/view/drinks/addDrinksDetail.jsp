<%@page import="java.util.ArrayList"%>
<%@page import="model.Product"%>
<%@page import="model.Drinks"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%
            Drinks dr = (Drinks)request.getAttribute("drinks");
            ArrayList<Product> product = (ArrayList<Product>)request.getAttribute("product");
        %>
    </head>
    <body>
        
        <form action="add_drinks_detail?id=<%=dr.getdID()%>" method="POST">
            
            
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
        <%if(product.size()>0){%>
        
        
        <table border="1px"> 
            <tr>
                <td>ID</td>
                <td>Name</td>
                <td>Unit</td>
            </tr>
            
            
            <% for (Product p : product) {%>
            <tr>
                
                <td><%=p.getpID()%></td>
                <td><%=p.getpName()%></td>
                <td><%=p.getCate().getcName()%></td>
            </tr>    
            <%}%>
            
            
        </table>
        <%}%>
        
        
        
        
        <form method="POST" action="forAddDetail">




            ID: <%=dr.getdName()%> 
            <input type="hidden" name="did" value="<%=dr.getdID()%>"/><br/>
            
            <!--Drink ID: <input type=\"text\" name="did"/> <br/>-->
            Product ID: <input type=\"text\" name="pid"/> <br/>
            Quantity: <input type=\"text\" name="ddQuan"/> <br/>

            <br/>
            <input type="submit" value="Save"/>
        </form>






    </body>
</html>
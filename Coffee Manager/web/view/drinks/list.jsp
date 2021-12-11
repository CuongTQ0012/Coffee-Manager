<%@page import="model.Drinks"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%
            ArrayList<Drinks> drinks = (ArrayList<Drinks>)request.getAttribute("drinks");
        %>
    </head>
    <body>
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
                <td></td><!--image-->
                <td>
                    <input type="button" value="Detail" 
                           onclick="window.location.href = 'detail?id=<%=p.getdID()%>' " />
                    
                </td>
            </tr>    
            <%}%>
            
            
        </table>
        
        
        
        
        <input type="button" value="Add" onclick="window.location.href = 'add' " />
        
    </body>
</html>

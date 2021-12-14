
<%@page import="model.Total"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%
            ArrayList<Total> total = (ArrayList<Total>) request.getAttribute("total");
        %>
    </head>
    <body>
        <a href="../product/list">Product</a>
        <a href="../drinks/list">Drinks</a>
        <a href="../total/list">Total</a>
        
        <h1>List total</h1>
        <%if(total.size() > 0){%>  
        <table border="1px"> 
            <tr>
                <td>dID</td>
                <td>Quantity</td>
                <td>DOB</td>
                <td>Edit</td>
            </tr>


            <% for (Total p : total) {%>
            <tr>

                <td><%=p.getdID().getdName()%></td>
                <td><%=p.gettQuantity()%></td>
                <td><%=p.getTdob()%></td>
                <td>
                    <input type="button" value="Edit" 
                           onclick="window.location.href = 'edit?id=<%=p.gettID()%>'" />

                    <input type="button" value="Delete" 
                           onclick="window.location.href = 'delete?id=<%=p.gettID()%>'" />
                </td>
            </tr>    
            <%}%>


        </table>

<%}%>  


        <input type="button" value="Add" onclick="window.location.href = 'add'" />

        <input type="button" value="Action" 
               onclick="window.location.href = 'action'" />
    </body>
</html>

<%@page import="model.Category"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Product</title>
        
        <%
            ArrayList<Category> cate = (ArrayList<Category>)request.getAttribute("cate");
        %>
        
    </head>
    <body>
        <form method="POST" action="add">
            
            
            ID: <input type="text" name="pid"/> <br/>
            Name: <input type="text" name="pname"/> <br/>
            Quantity: <input type="text" name="pquantity"/> <br/>
            
            
            
            Unit:
            
            <select name="unit"> 
                <% for (Category d : cate) {%>
                <option value="<%=d.getcID()%>" ><%=d.getcName()%></option>
                <%}%>
            </select>
            
            <br/>
            <input type="submit" value="Save"/>
        </form>
    </body>
</html>

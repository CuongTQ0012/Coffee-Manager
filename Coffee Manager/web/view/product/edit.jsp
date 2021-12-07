<%@page import="model.Product"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Category"%>
<%@page import="model.Category"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%
            ArrayList<Category> cate = (ArrayList<Category>)request.getAttribute("cate");
            Product pro = (Product)request.getAttribute("product");
        %>
    </head>
    
    
    <body>
        <form method="POST" action="edit">
            
            
            ID: <%=pro.getpID()%> 
            <input type="hidden" name="id" value="<%=pro.getpID() %>"/>
            <br/>
            
            
            Name: <input type="text" name="name" value="<%=pro.getpName()%>"/> <br/>
            Quantity: <input type="text" name="quantity:" value="<%=pro.getpQuantity()%>"/> <br/>
            Unit: 
            <select name="did"> 
                <% for (Category c : cate) {%>
                <option
                    <%=(pro.getCate().getcID()== c.getcID()?"selected=\"selected\"":"")%>
                     value="<%=c.getcID()%>" ><%=c.getcName()%></option>
                <%}%>
            </select>
            <br/>
            <input type="submit" value="Save"/>
        </form>
    </body>
</html>

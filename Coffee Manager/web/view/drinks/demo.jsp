<%-- 
    Document   : demo
    Created on : Dec 11, 2021, 5:07:23 PM
    Author     : Admin
--%>

<%@page import="model.Drinks"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%
            Drinks dr = (Drinks)request.getAttribute("drinks");
        %>
    </head>
    <body>

        <form method="POST" action="detail">


<!--            ID: <input type="text" name="pid"/> <br/>
            Name: <input type="text" name="pname"/> <br/>
            Quantity: <input type="text" name="pquantity"/> <br/>-->



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

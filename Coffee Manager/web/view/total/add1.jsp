<%@page import="java.util.ArrayList"%>
<%@page import="model.Drinks"%>
<%@page import="model.Product"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%
            ArrayList<Drinks> drinks = (ArrayList<Drinks>)request.getAttribute("drinks");
        %>
        <a href="../product/list">Product</a>
        <a href="../drinks/list">Drinks</a>
        <a href="../total/list">Total</a>
    <h1>Add Total detail</h1>
        <form action="add" method="POST">
            
            
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
      <%if(drinks.size() > 0){%>      
            
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
            </tr>    
            <%}%>
            
            
        </table>
        
    <%}%>
    
    
        <script> 
            var index = 0;
            function addTotal()
            {
                index++;
                var container = document.getElementById("container");
                var div = document.createElement("div");
                div.setAttribute("id", "total"+index);
                container.appendChild(div);
                div.innerHTML += "<input type=\"hidden\" value=\""+index+"\" name=\"index\"/>";
                
                div.innerHTML += "Product ID: <input type=\"text\" name=\"did"+index+"\"/> <br/>";
                div.innerHTML += "Quantity: <input type=\"text\" name=\"tQuan"+index+"\"/> <br/>";
                
                div.innerHTML += "Dob: <input type=\"date\" name=\"tdob"+index+"\"/> <br/>";
                div.innerHTML += "<input type=\"button\" value=\"Remove\" onclick=\"removeTotal("+index+");\" /> <br/>";
            }
            
            function removeTotal(index)
            {
                var container = document.getElementById("container");
                var div = document.getElementById("total"+index);
                container.removeChild(div);
            }
            
        </script>
    </head>
    <body>
        <form action="add" method="POST">
            <div>
                <input type="button" value="Add Total" onclick="addTotal();" />
            </div>
            <div id="container">
            </div>
            <input type="submit" value="Save"/>
        </form>
    </body>
</html>

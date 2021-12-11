<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script> 
            var index = 0;
            function addDrinksDetail()
            {
                index++;
                var container = document.getElementById("container");
                var div = document.createElement("div");
                div.setAttribute("id", "student"+index);
                container.appendChild(div);
                div.innerHTML += "<input type=\"hidden\" value=\""+index+"\" name=\"index\"/>";
                
                
                
                div.innerHTML += "Drink ID: <input type=\"text\" name=\"did"+index+"\"/> <br/>";
                div.innerHTML += "Product ID: <input type=\"text\" name=\"pid"+index+"\"/> <br/>";
                div.innerHTML += "Quantity: <input type=\"text\" name=\"ddQuan"+index+"\"/> <br/>";
                
                
                
                
                
                div.innerHTML += "<input type=\"button\" value=\"Remove\" onclick=\"removeDrinksDetail("+index+");\" /> <br/>";
            }
            
            function removeDrinksDetail(index)
            {
                var container = document.getElementById("container");
                var div = document.getElementById("student"+index);
                container.removeChild(div);
            }
            
        </script>
    </head>
    <body>
        <form action="add" method="POST">
            
            
            
            
            
            
            
            
            <div>
                <h1>List</h1>
                
                <input type="button" value="Add Drinks Detail" onclick="addDrinksDetail();" />
            </div>
            <div id="container">
            </div>
            <input type="submit" value="Save"/>
        </form>
    </body>
</html>
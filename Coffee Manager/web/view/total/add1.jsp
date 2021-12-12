<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    <h1>Add Total detail</h1>
        
        
        
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
                
                div.innerHTML += "Total ID: <input type=\"text\" name=\"did"+index+"\"/> <br/>";
                div.innerHTML += "Total Name: <input type=\"text\" name=\"tQuan"+index+"\"/> <br/>";
                
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

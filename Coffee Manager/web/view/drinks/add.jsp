<%@page import="model.Category"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        
        
    </head>
    <body>
        <form method="POST" action="add">
            
            
            ID: <input type="text" name="did"/> <br/>
            Name: <input type="text" name="dname"/> <br/>
            
            
            <br/>
            <input type="submit" value="Save"/>
        </form>
    </body>
</html>

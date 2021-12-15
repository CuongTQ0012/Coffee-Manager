
<%@page import="model.Category"%>
<%@page import="model.Product"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
            ArrayList<Product> product = (ArrayList<Product>)request.getAttribute("product");
        %>


<html lang="en">

    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Lato">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <title>List Product</title>

    <body>

        <!-- Navbar -->
        <div class="w3-top">
            <div class="w3-bar w3-black w3-card">
                <a class="w3-bar-item w3-button w3-padding-large w3-hide-medium w3-hide-large w3-right" href="javascript:void(0)" onclick="myFunction()" title="Toggle Navigation Menu"><i class="fa fa-bars"></i></a>
                <a href="../home.html" class="w3-bar-item w3-button w3-padding-large">HOME</a>
                <a href="../product/list" class="w3-bar-item w3-button w3-padding-large w3-hide-small">Product</a>
                <a href="../drinks/list" class="w3-bar-item w3-button w3-padding-large w3-hide-small">Drinks</a>
                <a href="../total/list" class="w3-bar-item w3-button w3-padding-large w3-hide-small">Total</a>
                <div class="w3-dropdown-hover w3-hide-small">
                    <button class="w3-padding-large w3-button" title="More">MORE <i class="fa fa-caret-down"></i></button>     
                    <div class="w3-dropdown-content w3-bar-block w3-card-4">
                        <a href="#" class="w3-bar-item w3-button">Merchandise</a>
                        <a href="#" class="w3-bar-item w3-button">Extras</a>
                        <a href="#" class="w3-bar-item w3-button">Media</a>
                    </div>
                </div>
            </div>
        </div>


        <!-- Page content -->
        <div class="w3-content" style="max-width:2000px;margin-top:300px">



            <!-- The Band Section -->
            <div class="w3-container w3-content w3-center w3-padding-64" style="max-100" id="band">

                
                
        <form action="list" method="POST">
            
            
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
        
        
        
        <table border="1px"> 
            <tr>
                <td>ID</td>
                <td>Name</td>
                <td>Quantity</td>
                <td>Unit</td>
                <td></td>
            </tr>
            
            
            <% for (Product p : product) {%>
            <tr>
                
                <td><%=p.getpID()%></td>
                <td><%=p.getpName()%></td>
                <td><%=p.getpQuantity()%></td>
                <td><%=p.getCate().getcName()%></td>
                <td>
                    <input type="button" value="Edit" 
                           onclick="window.location.href = 'edit?id=<%=p.getpID()%>' " />
                    
                    <input type="button" value="Delete" 
                           onclick="window.location.href = 'delete?id=<%=p.getpID()%>' " />
                </td>
            </tr>    
            <%}%>
            
            
        </table>
        
        
        
        
        <input type="button" value="Add" onclick="window.location.href = 'add' " />
        


            </div>

            <!-- The Tour Section -->
            <div class="w3-black" id="tour">
                <div class="w3-container w3-content w3-padding-64" style="max-width:1000px;margin-top:100px">
                    <h2 class="w3-wide w3-center">Coffee manager</h2>
                    <p class="w3-opacity w3-center"><i>Remember to book your tickets!</i></p><br>



                </div>
            </div>

        </div>


        <!-- Footer -->
        <footer class="w3-container w3-padding-64 w3-center w3-opacity w3-light-grey w3-xlarge">
            <i class="fa fa-facebook-official w3-hover-opacity"></i>
            <i class="fa fa-instagram w3-hover-opacity"></i>
            <i class="fa fa-snapchat w3-hover-opacity"></i>
            <i class="fa fa-pinterest-p w3-hover-opacity"></i>
            <i class="fa fa-twitter w3-hover-opacity"></i>
            <i class="fa fa-linkedin w3-hover-opacity"></i>
        </footer>


    </body>
</html>




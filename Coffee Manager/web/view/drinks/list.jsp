<%@page import="model.Drinks"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    ArrayList<Drinks> drinks = (ArrayList<Drinks>) request.getAttribute("drinks");
%>

<html lang="en">

    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Lato">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <title>List Drinks</title>

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
                        <td>
                            <input type="button" value="Detail" 
                                   onclick="window.location.href = 'detail1?id=<%=p.getdID()%>'" />

                        </td>
                    </tr>    
                    <%}%>


                </table>




                <input type="button" value="Add" onclick="window.location.href = 'add'" />



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

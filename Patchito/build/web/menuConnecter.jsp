<%-- 
    Document   : menu_connecter
    Created on : 15 nov. 2020, 19:42:47
    Author     : Hamza
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String mon_user = (String) session.getAttribute("nom");
%>
<!DOCTYPE html>
<html>
    <head>
        <!--<title> Patchito </title>-->
        <meta charset="UTF-8"/> 
        <link rel="icon" type="image/png" href="./image/icon.jpg" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="boostrap/css/bootstrap.min.css" >
        <link rel=stylesheet href="./css/mm.css">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>
    </head>
    <body>
        <nav>
            <ul>
                <li><img src="./image/logo.jpg" alt="logo" class ="logo" width="140" height="70"/></li>
                <li><a href ="acceuil.jsp" class="text-white">Home</a> </li>
                <li> <a href ="afficherProduit?name=Shop" class="text-white">Shop</a> </li>
                <li>  <a href="afficherProduit?name=Shoes"class="text-white">Shoes</a></li>
                <li>  <a href="afficherProduit?name=Bag"class="text-white">Bag</a></li>
                <li>   <a href="afficherProduit?name=Clothes"class="text-white">Clothes</a></li>
                <li>  <a href="afficherProduit?name=Scarf"class="text-white">Scarf</a></li>
                <li>  <a href="afficherProduit?name=Accessory"class="text-white">Accessory</a></li>
                <div class="dropdown" >
                    <button class="dropbtn"><img src="./image/connexion.png" width="30" height="30"></button>
                    <div class="dropdown-content">
                       <a href="" style="font-size: 16px;"><%=mon_user%></a>                      
                        <a href ="afficherProduitPanier"style="font-size: 16px;"> <i class="fa fa-shopping-cart"></i> My basket </a> 
                        <a href="logOut"style="font-size: 16px;">  Log out</a>
                    </div>
                </div>
               <li><a href ="" class="text-white" style="visibility: hidden"></a></li>
            </ul>
        </nav>
    </body>
</html>

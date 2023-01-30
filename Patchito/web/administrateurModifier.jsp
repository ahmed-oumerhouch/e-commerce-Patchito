<%-- 
    Document   : administrateur
    Created on : 2020-11-15, 22:03:24
    Author     : Farid
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="com.entities.Produit"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    Produit article = (Produit) request.getAttribute("article");
    String msg = (String) request.getAttribute("message");
    String tout ="tout";
%>
<!DOCTYPE html>
<html>
    <head>
        <title> Administrator </title>
        <meta charset="UTF-8"/> 
        <link rel="icon" type="image/png" href="./image/icon.jpg" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="boostrap/css/bootstrap.min.css" >
        <link rel=stylesheet href="./css/mm.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <script src=fonctions.js></script>
        <style>           
            .center {
                margin: auto;
                width: 60%;

                padding: 10px;
            }</style>
    </head>

    <body>
        <nav>
            <ul>
                <li> <a href =""> <img src="./image/logo.jpg" alt="logo" width="140" height="70"/> </a> </li>
                <li style="margin-right: 30%; margin-left: 5%;" ><a href="logOut"  class="text-white" >Log out</a></li>

            </ul>

        </nav>
        <% if (msg == null) {
                msg = " ";
            }%>

        <h2 style="color:red;"><%= msg%></h2>
      
         
        <div class="container"> 
            <a href ="modifierSupprimerAdmin?action=<%=tout%>&code=<%= 0%>" style="font-size: 2em;">retour</a>
             <% if (article != null) {
        %> 
            <div class="row-cols-md-4">
                <br>
                <img src="./image/<%=article.getNom()%>/<%=article.getCode()%>.jpg" alt="logo" width="100" height="50"/>
                <br>  
 

                <form name="form3" action="adminModifier"    method="post" id="form">
                    <input type="hidden" id="codearticle" required="" name="codearticle" value="<%= article.getCode() %>">
                    
                    <input type="hidden" id="select" required="" name="select" value="<%= article.getNom()%>">
 
                    <br> <br>
                    <label class="text">Modèle :</label>
                    <br><input type="text" id="modele" required="" name="modele" value="<%= article.getModele()%>">
                    <label class="text">Price :</label>
                    <br><input type="number" id="prix" required="" name="prix" value="<%= article.getPrix()%>">
                    <br><label class="text">Description :</label>
                    <br><textarea id="Description" required="" name="Description" rows="3" cols="40"  > <%= article.getDescription() %>  </textarea>
                    <br><br> <label class="text">Taille :</label>
                    <br><label class="text">example (7.5-8-10.5-9)</label><br>
                    <textarea id="Taille" required="" name="Taille" rows="3" cols="40"   ><%= article.getTaille()%> </textarea>
                    <br></br> <label class="text">Quantity :</label><br>
                    <input type="number" id="Quantite" required="" name="Quantite" value="<%= article.getQuantity()%>" ><br>
                    

                    <button name="button" type="submit" > Modifier </button>
                </form>
                
            </div>
            <%   }%>
            <br><br>

</body>
<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
<jsp:include page="footer.jsp"/>

</html>

<%-- 
    Document   : administrateur
    Created on : 2020-11-15, 22:03:24
    Author     : Farid
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="com.entities.Produit"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String msg = (String) request.getAttribute("message");
    String msgSuppr = (String) request.getAttribute("msgSuppr");
    ArrayList<Produit> mesproduits = (ArrayList<Produit>) request.getAttribute("mesProduits");
    String modifier ="Modifier";
    String supprimer ="Supprimer";
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
          <% if (msgSuppr == null) {
                    msgSuppr = " ";
                }%>
                <h2 style="color:red;"><%= msgSuppr%></h2>
        <% if (msg == null) {
                msg = " ";
            }%>
        <h2 style="color:red;"><%= msg%></h2>
        <div class="container"> 
            <div class="row-cols-md-4">
                <br> <br>

                <label class="text" > Add products :</label>

                <br>

                <form name="form3" action="ajouterProduitAdmin"  enctype="multipart/form-data" method="post" id="form">
                    <br>
                    <select class="center" name="select"  id="select" class="browser-default custom-select">
                        <option value="Shoes" >Shoes</option>
                        <option value="Bag" >Bag</option>
                        <option value="Clothes" >Clothes</option>
                        <option value="Scarf" >Scarf</option>
                        <option value="Accessory" >Accessory</option>
                    </select>
                    <br> <br>
                    <label class="text">Modèle :</label>
                    <br><input type="text" id="modele" required="" name="modele" >
                    <label class="text">Price :</label>
                    <br><input type="number" id="prix" required="" name="prix" >
                    <br><label class="text">Description :</label>
                    <br><textarea id="Description" required="" name="Description" rows="3" cols="40"> </textarea>
                    <br><br> <label class="text">Taille :</label>
                    <br><label class="text">example (7.5-8-10.5-9)</label><br>
                    <textarea id="Taille" required="" name="Taille" rows="3" cols="40"> </textarea>
                    <br></br> <label class="text">Quantity :</label><br>
                    <input type="number" id="Quantite" required="" name="Quantite" ><br>
                    <label>Choose a picture :</label>
                    <input type="file" id="pictureProduct" name="pictureProduct" value="Upload" accept="image/jpg">
                    <button name="button" type="submit" > Add </button>
                </form>
                
            </div>
            <br><br>

            
            <div class="row-cols-md-6">
                <form  action="searchAdmin" method="post">
                     
                    <label class="text">Product code :</label>
                    <br><input type="number" id="codesearch" required="" name="codesearch" >
                    <br><br>
                    <button  type="submit"> submit </button>
                </form><br>
                <a href ="modifierSupprimerAdmin?action=<%=tout%>&code=<%= 0%>">Tout afficher</a>


                <br><br>	
            </div>
            
            <table class="table">
                <tr class="tr">
                    <th class="th" >Code</th>
                    <th class="th" >Name</th>
                    <th class="th" >model</th>
                    <th class="th" >Price</th>
                    <th class="th" >Description</th>
                    <th class="th" >Taille</th>
                    <th class="th" >Quantity</th>
                    <th class="th" >option</th>
                </tr>
                <%
                    if (mesproduits != null) {
                        for (Produit m : mesproduits) {
                %>
                <tr class="tr" >
                    <td class="td" ><%= m.getCode()%></td>
                    <td class="td" ><%= m.getNom()%></td>
                    <td class="td" ><%= m.getModele() %></td>
                    <td class="td" ><%= m.getPrix() %></td>
                    <td class="td" ><%= m.getDescription() %></td>
                    <td class="td" ><%= m.getTaille() %></td>
                    <td class="td" ><%= m.getQuantity() %></td>
                    <td class="td" > 
                     <a href ="modifierSupprimerAdmin?action=<%=modifier%>&code=<%= m.getCode()%>">Modifier</a>
                     <a href ="modifierSupprimerAdmin?action=<%=supprimer%>&code=<%= m.getCode()%>">Supprimer</a>
                    </td>
                </tr>
                <%
                        }
                    }
                %>
            </table>
            

        </div>




    </div>
</body>
<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
<jsp:include page="footer.jsp"/>

</html>

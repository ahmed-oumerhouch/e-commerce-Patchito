<%-- 
    Document   : panier
    Created on : 2020-11-18, 11:17:52
    Author     : Farid
--%>

<%@page import="com.entities.Produit"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    ArrayList<Produit> mesproduits = (ArrayList<Produit>) request.getAttribute("ProduitsPanierUserCurent");
    String mon_user = (String) session.getAttribute("nom");
    String email_user = (String) session.getAttribute("email");
%>
<html>
    <%if (mon_user != null) {%> 
    <jsp:include page="menuConnecter.jsp"/>
    <%} else {%>
    <jsp:include page="menu.jsp"/>
    <%}%>
        <style>
            #customers {
                font-family: Arial, Helvetica, sans-serif;
                font-size: 2.0em;
                border-collapse: collapse;
                width: 100%;
            }

            #customers td, #customers th {
                border: 1px solid #ddd;
                padding: 8px;
            }

            #customers tr:nth-child(even){background-color: #f2f2f2;}

            #customers tr:hover {background-color: #ddd;}

            #customersss {
                padding-top: 12px;
                padding-bottom: 12px;
                text-align: left;
                background-color: black;
                color: white;
            }
 

        </style>
    <body>
        <h1 style="text-align: center">PANIER</h1>
         <%  if (mesproduits.size()==0 && session.getAttribute("panier")== null) {   
         %>
            
         <h3 style="text-align: center">Basket empty</h3>
          <% }
            %>
 
            <div class="container">
                <table id="customers">
                    <tr>
                        <th   >Image</th>
                        <th  >Nom</th>
                        <th >Model</th>
                        <th   >Description</th>
                        <th   >Taille</th>
                        <th   >Prix</th>
                    </tr>    
                        

            <%        if (mesproduits != null) {
                    int cpt = 0;
                    for (Produit p : mesproduits) {

 
            %> 
            <tr>
                <th> <img id="image"   src="./image/<%=p.getNom()%>/<%=p.getCode()%>.jpg"  alt="nike Air Max" style="width:40%;"> </th>
                <th style="background-color: white;color: black;" ><%=p.getModele()%></th>
                <th style="background-color: white;color: black;" ><%=p.getPrix()%>$</th>
                <th style="background-color: white;color: black;" ><%=p.getTaille()%></th>
                <th style="background-color: white;color: black;" ><%=p.getDescription()%></th>              
                <th><a href="supprimerPanier?code=<%=p.getCode()%>"><p><button type="button">Delete</button></p></a></th> 
            </tr> 
            <%
                    }
                }
            %>

                                </table>
            </div>
            
            
        <div class="container" style="width: 30%; height: 40%; font-size: 20px">
            <a href="payer_caisse?email=<%=email_user%>"><p><button type="button">Payer</button></p></a>
        </div>
    </body>
</html>

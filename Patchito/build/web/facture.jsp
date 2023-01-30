<%-- 
    Document   : facture
    Created on : 2 déc. 2020, 21:43:05
    Author     : Hamza
--%>

<%@page import="com.entities.Produit"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    ArrayList<Produit> mesproduits = (ArrayList<Produit>) request.getAttribute("ProduitsPanierUserCurent");
    String mon_user = (String) session.getAttribute("nom");
    String email = (String) session.getAttribute("email");
    double somme = 0;
%>
<!DOCTYPE html>
<html>
    <%if (mon_user != null) {%>
    <jsp:include page="menuConnecter.jsp"/>
    <%} else {%>
    <jsp:include page="menu.jsp"/>
    <%}%>
    <head>
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

            #customers th {
                padding-top: 12px;
                padding-bottom: 12px;
                text-align: left;
                background-color: black;
                color: white;
            }
        </style>
    <div class="container">
        <table id="customers">
            <tr>
                <th>Produit</th>
                <th>Prix</th>
            </tr>
            </head>
            <body>
                <h1 style="text-align: center;">Facture</h1>
                <%        if (mesproduits != null) {
                        for (Produit p : mesproduits) {

                            somme += p.getPrix();
                %>
            <tr>
                <td><%=p.getModele()%></td>

                <td><%=p.getPrix()%></td>


            </tr>

            <%
                    }
                }

            %>
            <tr>
                <td><h2>Total avant taxes</h2></td>

                <%somme = (double) Math.round(somme * 100) / 100;%>
                <td><h2><%=somme%>$</h2></td>




            </tr>
            <tr>
                <td><h2>Total apres taxes</h2></td>
                <td><h2><%=(somme + (somme * 0.05) + (somme * 0.1))%>$</h2></td>
            </tr>
        </table>   
    </div>
    <div class="container" style="width: 30%; height: 40%; font-size: 20px">
        <a href="viderTousPanier?email=<%=email%>"><p><button type="button">Payer</button></p></a>
    </div>

</body>
<jsp:include page="footer.jsp"/>
</html>

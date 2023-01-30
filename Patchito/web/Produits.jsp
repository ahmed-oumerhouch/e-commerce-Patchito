<%-- 
    Document   : Produits
    Created on : 2020-10-25, 21:03:27
    Author     : Farid
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="com.entities.Produit"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    ArrayList<Produit> mesproduits = (ArrayList<Produit>) request.getAttribute("mesProduits");
    String mon_user = (String) session.getAttribute("nom");
    String email_user = (String) session.getAttribute("email");
%>
<!DOCTYPE html>
<html>
    <%if (mon_user != null) {%>
    <jsp:include page="menuConnecter.jsp"/>
    <%} else {%>
    <jsp:include page="menu.jsp"/>
    <%}%>
    <br><br>
     <body>
        <div class="container">
            <div class="row row-cols-1 row-cols-md-4">
                <%        if (mesproduits != null) {
                        int cpt = 0;
                        for (Produit p : mesproduits) {

                            if (cpt == 3) {
                                cpt = 0;
                %> 
            </div>
            <div class="row row-cols-1 row-cols-md-4">
                <%}
                    cpt++;
                %> 
                <div class="col mb-4">
                    <div class="card">
                        <img src="./image/<%=p.getNom()%>/<%=p.getCode()%>.jpg"  alt="nike Air Max" style="width:100%">
                        <div class="card-body">
                            <h1><%=p.getModele()%></h1>
                            <p class="price">Prix :<%=p.getPrix()%>$</p>
                            <p>Taille : <%=p.getTaille()%></p>
                            <p>Description :<%=p.getDescription()%></p>              
                            <a href="ajouterPanier?code=<%=p.getCode()%>&email=<%=email_user%>"><p><button type="button">Add to Cart</button></p></a>
                        </div>
                    </div>
                </div>
                <%
                        }
                    }
                %>
            </div>
        </div>
    </body>
    <jsp:include page="footer.jsp"/>
</html>
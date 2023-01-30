<%-- 
    Document   : acceuil
    Created on : 2020-11-15, 15:35:24
    Author     : Farid
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="javax.servlet.http.Cookie"%>
<!DOCTYPE html>
<%   
    String mon_user = (String) session.getAttribute("nom");
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
        <img class="displayed" src="./image/acceuil.jpg" alt="acceuil" usemap="#shop"/>
        <map name = "shop">
            <area shape = "shop" coords = "502,201,817,283" href ="afficherProduit?name=Shop"/>
        </map>
    </body>
    <br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>

    <jsp:include page="footer.jsp"/>
</html>

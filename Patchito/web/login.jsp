<%-- 
    Document   : login
    Created on : 2020-10-25, 21:57:38
    Author     : Farid
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    //Cookie cookie = null;
    String email = "", mdp = "";
    int cpt=0;
    Cookie[] cookies = null;
    cookies = request.getCookies();
    if (cookies != null) {

        for (int i = 0; i < cookies.length; i++) {
            cpt++;%>
            
    <% }
        if (cpt >1) {
            email = cookies[1].getValue();
            mdp = cookies[2].getValue();
        }
    } 
else {%>
    <p> Pas de cookies trouvees :</p>
<% }%>
<html>
    <head>
        <title>Create an account</title>
        <meta charset="UTF-8"/> 

        <link rel="icon" type="image/png" href="./image/icon.jpg" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="boostrap/css/bootstrap.min.css" >
        <link rel=stylesheet href="css/mm.css">
    </head>
    <body>
        <nav>
            <ul>
                <li><a href ="acceuil.jsp"><img src="./image/logo.jpg" alt="logo" width="140" height="70"/></a></li>
            </ul>
        </nav>
        <div class="container">
            <header class="imgcontainer">           
                <img src="./image/connexion.png" width="60" height="60">
                <h1> Connexion </h1>
            </header>	
            <form  action="login" method="get">
                <div class="Connexion container">					
                    Adresse email  <br />
                    <input type="email" id="email" name="email" placeholder="example@example.com" value= "<%=email%>" required> <br /><br />

                    Mot de passe  <br />
                    <input type="password" id="password" name="password" value="<%=mdp%>" required>
                    <label class="checkbox pull-left">
                        Remember me <input type="checkbox" name="sauvegarde" value="yes">
                    </label>

                </div >

                <div class="button container">
                    <button type="submit">Login</button> <br>
                </div>




            </form>
            <div class="container">
                <span class="lien_se_connecter"> <a href="createAccount.jsp"><span style="color:blue;">Create an account |</span> </a></span>
                <span class="lien_pass"> <a href="forgetpassword.jsp"><span style="color:blue;"> Forgot password ?</span> </a></span>

            </div>
        </div>



    </body>
    <br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>




    <jsp:include page="footer.jsp"/>
</html>
</html>

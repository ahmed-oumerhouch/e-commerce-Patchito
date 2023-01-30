<%-- 
    Document   : createAccount
    Created on : 2020-11-18, 14:55:50
    Author     : ahmed
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
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



        <div class = "formNewCompt">

            <form action="inscription" method="get" id="form">
                <div class="container">
                    <h2 style= " text-align: center; font-family: Lucida Handwriting;">Join us !</h2>
                </div>

                <div class="container">
                    <label class="text"for="username">Username :</label>
                    <input type="text"  id="username" name="username" required="" placeholder="Username">
                    <p id="nomerreur" style="color:red;" ></p>
                </div>

                <div class="container">
                    <label class="text"for="email">Email :</label>
                    <input type="email" id="email" name="email" required=""  placeholder="example@example.com">
                    <p id="emailerreur" style="color:red;" ></p>
                </div>

                <div class="container">
                    <label class="text"for="password">Password : </label> 
                    <input type="password" id="password" name="password" required="" placeholder="*******************" >
                    <p id="passworderreur" style="color:red;" ></p>
                </div>

                <div class="container">
                    <label class="text"for="email">Confirm Password  :</label> 
                    <input type="password" id="password2" name="password2" required="" placeholder="*******************">
                    <p id="password2erreur" style="color:red;" ></p>
                </div>

                <div class="container">
                    <button  name="button" type="submit">Register </button> <br>
                    <span class = "psq">Already have an account? <a href="login.jsp">log in.</a></span>
                </div>
            </form>


        </div>

    </body>
    <br><br><br><br><br><br><br><br><br><br><br><br><br>
    <jsp:include page="footer.jsp"/>
</html>













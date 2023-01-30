<%-- 
    Document   : forgetpassword
    Created on : 2020-11-18, 14:24:47
    Author     : ahmed
--%>

<%@page import="com.entities.Compte"%>
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
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    </head>
    <body>
        <nav>
            <ul>
                <li><a href ="acceuil.jsp"><img src="./image/logo.jpg" alt="logo" width="140" height="70"/></a></li>
            </ul>
        </nav>
<%
    Compte compte = (Compte) request.getAttribute("reponse");
    
    if(compte != null){
  %>  
   <h1> votre mots de passe est  <%=compte.getPass()%></h1>
  <%      
    }
%>
       
<div class = "formMdpOublie">

            
            <form    action="forgetMyPassword" method="get" id="form">
                
                <div class="imgcontainer">
                    <img src="./image/forget0.jpg" alt="Avatar" class="avatar">
                    <p>Find my account</p>
                </div>

                <div class="container">
                    <label class="text"for="email">Email :</label>
                    <input type="text" id="email" name="email" placeholder="example@example.com">

                </div>
                <br>
                <div class="container">
                    <button type="submit">Submit</button> 
                    <span class = "psq">Create <a href="createAccount.jsp">an account?</a></span>
                </div>
                
            </form>



        </div>
    </body>
    <br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
    <jsp:include page="footer.jsp"/>
</html>

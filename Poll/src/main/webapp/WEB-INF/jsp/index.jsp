<%-- 
    Document   : index
    Created on : Apr 6, 2020, 1:10:46 AM
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome</title>
        <link rel="icon" type="image/ico" href="${pageContext.request.contextPath}/images/icon.png">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/index.css">
    </head>

    <body>
        <form action="dologin" method="POST" id="myform">
            <div style="text-align: center;">
                <span id="labels">Username: </span><input type="text" name = "username" >
                &nbsp;&nbsp;<span id="labels">Password: </span><input type="password" name = "password" > <span style="color: red"><strong></strong></span>
                <input id="loginbtn" type="submit" value=" Login "><span style="color: red"><strong>${wrongCredentials}</strong></span>
            </div>
        </form>
        <hr/>
        <div class="registration"><a href="preregister">Click to Register</a></div>
        <hr>
        <h3>${alreadyvoted}</h3>
    </body>

</html>

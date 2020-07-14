<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registration Form Page</title>
        <link rel="icon" type="image/ico" href="${pageContext.request.contextPath}/images/icon.png">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
        
        <script src="registration.js"></script>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/registration.css">

    </head>
    <body>
        <div class="container" id="myform">
            <div class="row">
                <div class="span12">
                    <form:form cssClass="form-horizontal" action='doregister' method="POST" modelAttribute="registeruser">
                        <div class="control-group">
                            <!-- Username -->
                            <label class="control-label"  for="username">Username</label>
                            <div class="controls">
                                <form:input path="username" cssClass="input-xlarge" id="username"/><span id="usernameresult"></span>
                            </div>
                        </div>
                        <div class="control-group">
                            <!-- Password-->
                            <label class="control-label" for="password">Password</label>
                            <div class="controls">
                                <form:input path="password" id="password" cssClass="input-xlarge" type="password"/><span id="passwordresult"></span>
                            </div>
                        </div>
                        <div class="control-group">
                            <!-- Password-->
                            <label class="control-label" for="password">Retype Password</label>
                            <div class="controls">
                                <form:input path="password2" id="password2" cssClass="input-xlarge" type="password"/><span id="password2result"></span>
                            </div>
                        </div>
                        <div class="control-group">
                            <!-- First Name -->
                            <label class="control-label" for="firstname">First Name</label>
                            <div class="controls">
                                <form:input id = "fn" path="firstname" cssClass="inputTextBox input-xlarge"/><span id="fnresult"></span>
                            </div>
                        </div>
                        <div class="control-group">
                            <!-- Last Name-->
                            <label class="control-label" for="lastname">Last Name</label>
                            <div class="controls">
                                <form:input id = "ln" path="lastname" cssClass="inputTextBox input-xlarge"/><span id="lnresult"></span>
                            </div>
                        </div>
                        <!-- Role -->
                        <div class="control-group">
                            <label class="control-label " for="sel1">Select role:</label>
                            <form:select path="role" cssClass="form-control">
                                <form:options items="${allroles}" itemValue="roleid" itemLabel="rolename" />
                            </form:select>
                        </div>
                        <br><br>
                        <div class="control-group">
                            <!-- Button -->
                            <div class="controls">
                                <button id="rgsbutton" class="btn btn-success" disabled="true">Register</button>
                            </div>
                        </div>
                    </form:form>
                </div>
            </div>
        </div>
        <script src="${pageContext.request.contextPath}/js/registration.js"></script>
    </body>

</html>

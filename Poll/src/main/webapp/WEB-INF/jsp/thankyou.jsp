<%-- 
    Document   : thankyou
    Created on : Jul 10, 2020, 12:28:54 PM
    Author     : User
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="icon" type="image/ico" href="${pageContext.request.contextPath}/images/icon.png">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/thankyou.css">
        <title>Thank you</title>

    </head>
    <body>
        <h2>${voteComplete}</h2>
        <c:choose>
            <c:when test="${userRole=='1'}">
            </c:when>  
            <c:when test="${userRole=='2'}">
                <h2>Click <a class="here" href="myvotes">here</a> to see your votes</h2> 
            </c:when>
            <c:otherwise>
                <h2>Admin</h2> 
            </c:otherwise>
        </c:choose>
    </body>
</html>

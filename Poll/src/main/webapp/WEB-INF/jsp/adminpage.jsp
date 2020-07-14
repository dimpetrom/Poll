<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!DOCTYPE html>
<html>
    <head>
        <link rel="icon" type="image/ico" href="${pageContext.request.contextPath}/images/icon.png">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Page</title>

        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/adminpage.css">

    </head>
    <body>
        <div class="container">
            
            <h3>All Poll users</h3>
            
            <table id="votingTable" class="table table-bordered">
                <thead>
                    <tr class="info">
                        <th>UserID</th>
                        <th>UserFirstName</th>
                        <th>UserLastName</th>
                        <th>Username</th>
                        <th>UserPassword</th>
                        <th>RoleID</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${users}" var="u">
                        <tr>
                            <td>${u.userid}</td>
                            <td>${u.userfirstname}</td>
                            <td>${u.userlastname}</td>
                            <td>${u.username}</td>
                            <td>${u.userpassword}</td>
                            <td>${u.roleid.roleid}</td>        
                        </tr>
                    </c:forEach>  
                </tbody>
            </table>    
        </div>
    </body>
</html>

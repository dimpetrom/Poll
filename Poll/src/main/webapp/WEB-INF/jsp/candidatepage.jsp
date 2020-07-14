<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Votes</title>
        <link rel="icon" type="image/ico" href="${pageContext.request.contextPath}/images/icon.png">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/candidatepage.css">
    </head>
    
    <body>

        <h3>${candidatefirstname} ${candidatelastname} Total Votes: ${totalvotes}</h3>
        <% int i = 1;%>

        <div class="container">
            <table id="candidateVotes" class="table table-bordered">
                <thead>
                    <tr class="info">
                        <th>Vote Number</th>
                        <th>Vote Rating</th>
                        <th>Vote Datetime</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${candidateVotes}" var="v">
                        <tr>
                            <td> <%=i++%> </td>
                            <td>${v.rating}</td>
                            <td>${v.datetime}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table> 
        </div>
    </body>
</html>
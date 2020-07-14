<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Voting Page</title>
        <link rel="icon" type="image/ico" href="${pageContext.request.contextPath}/images/icon.png">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/votingpage.css">

    </head>
    <body>

        <div class="container">
            <form:form action='aftervoting' method="POST" modelAttribute="votingdto">
                <table id="votingTable" class="table table-bordered">
                    <thead>
                        <tr class="info">
                            <th>Candidate First Name</th>
                            <th>Candidate Last Name</th>
                            <th>Candidate Total Votes</th>
                            <th>Rating</th>
                            <th>Pick</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${candidates}" var="u">
                            <tr>
                                <td>${u.firstName}</td>
                                <td>${u.lastName}</td>
                                <td>${u.totalVotes}</td>
                                <td><form:select path="rating" id="userRating" cssClass="form-control">
                                        <form:option value="5" />
                                        <form:option value="4" />
                                        <form:option value="3" />
                                        <form:option value="2" />
                                        <form:option value="1" />
                                    </form:select></td>
                                <td><form:radiobutton onclick="getCandidate(this);" path="userId" value="${u.id}" /></td>
                            </tr>
                        </c:forEach> 
                    </tbody>
                </table> 
                <button id="votebtn" class="btn btn-success" disabled="true">Vote</button>
            </form:form>
        </div>

        <script src="${pageContext.request.contextPath}/js/votingpage.js"></script>

    </body>

</html>


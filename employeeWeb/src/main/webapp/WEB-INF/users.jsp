<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <title>Title</title>
</head>
<body>

<div class="container">

    <h2>Users</h2>
    <table class="table table-hover">
        <tbody>
        <tr>
            <th>Name</th><th>Password</th><th>Id</th><th>Role</th><th>E-mail</th>
        </tr>
        <c:forEach items="${users}" var="user">
            <tr>
                <td>${user.username}</td>
                <td>${user.password}</td>
                <td>${user.id}</td>
                <td>${user.role}</td>
                <td>${user.email}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

</div>
</body>
</html>

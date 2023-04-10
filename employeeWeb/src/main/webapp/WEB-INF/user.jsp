<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
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
    <h2>User by ID</h2>
    <table class="table table-hover">
        <tbody>
        <tr>
            <th>Name</th>
            <th>Password</th>
            <th>Id</th>
            <th>Role</th>
            <th>E-mail</th>
        </tr>
        <c:forEach items="${userById}" var="user">
            <tr>
                <td>${userById.username}</td>
                <td>${userById.password}</td>
                <td>${userById.id}</td>
                <td>${userById.role}</td>
                <td>${userById.email}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>

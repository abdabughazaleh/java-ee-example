<%--
  Created by IntelliJ IDEA.
  User: abdab
  Date: 3/2/2022
  Time: 8:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>

    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.4.1/dist/css/bootstrap.min.css"/>

    <!-- Optional theme -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.4.1/dist/css/bootstrap-theme.min.css"/>

</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-md-8">
            <h1>Users</h1>
            <table border="1" class="table">
                <thead>
                <tr>
                    <th>User ID</th>
                    <th>Username</th>
                    <th>Email</th>
                    <th>Full Name</th>
                    <th>Delete</th>
                    <th>Update</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="std" items="${users}">
                    <tr>
                        <td>${std.userId}</td>
                        <td>${std.username}</td>
                        <td>${std.email}</td>
                        <td>${std.fullname}</td>
                        <td><a href="delete?ID=${std.userId}&action=delete">Delete</a></td>
                        <td><a href="delete?ID=${std.userId}&action=update">Update</a></td>
                    </tr>
                </c:forEach>
                </tbody>

            </table>
        </div>
        <div class="col-md-4">
            <h2>Add new User</h2>
            <hr>
            <form action="add-user" method="POST">
                <div class="form-group" >
                    <label for="">Full Name</label>
                    <input type="text" name="full_name" class="form-control">
                </div>
                <div class="form-group" >
                    <label for="">Username</label>
                    <input type="text" name="username" class="form-control">
                </div>
                <div class="form-group" >
                    <label for="">Password</label>
                    <input type="password" name="password" class="form-control">
                </div>
                <div class="form-group" >
                    <label for="">email</label>
                    <input type="email" name="email" class="form-control">
                </div>
                <input type="hidden" name="type" value="insert">
                <div class="form-group" >
                    <button type="submit" class="btn btn-primary btn-block"> Save User</button>
                </div>
            </form>

        </div>
    </div>
</div>


<!-- Latest compiled and minified JavaScript -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@3.4.1/dist/js/bootstrap.min.js" ></script>
</body>
</html>

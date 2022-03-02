<%--
  Created by IntelliJ IDEA.
  User: abdab
  Date: 3/2/2022
  Time: 8:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<html>
<head>
    <title>Title</title>

    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.4.1/dist/css/bootstrap.min.css"/>

    <!-- Optional theme -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.4.1/dist/css/bootstrap-theme.min.css"/>

</head>
<body>
<c:set var="userId" value="${user_id}"/>
<jsp:useBean id="user_details" scope="request" type="com.erp.crud.dao.User"/>
<c:set var="userDetails" scope="request"  value="${user_details}"/>
<div class="container">
    <div class="row">
        <div class="col-md-6">
            <h2>Update User : <span style="background: yellow; color:red;">${userDetails.fullname}</span></h2>
            <hr>
            <form action="add-user" method="POST">
                <div class="form-group">
                    <label for="">Full Name</label>
                    <input type="text" value="${userDetails.fullname}" name="full_name" class="form-control">
                </div>
                <div class="form-group">
                    <label for="">Username</label>
                    <input type="text" value="${userDetails.username}" name="username" class="form-control">
                </div>
                <div class="form-group">
                    <label for="">Password</label>
                    <input type="password" name="password" class="form-control">
                </div>
                <div class="form-group">
                    <label for="">email</label>
                    <input type="email" value="${userDetails.email}" name="email" class="form-control">
                </div>
                <input type="hidden" name="type"  value="update">
                <input type="hidden" name="user_id_x" value="${userDetails.userId}">
                <div class="form-group">
                    <button type="submit" class="btn btn-primary btn-block"> Save User</button>
                </div>
            </form>

        </div>
    </div>
</div>


<!-- Latest compiled and minified JavaScript -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@3.4.1/dist/js/bootstrap.min.js"></script>
</body>
</html>

<%-- 
    Document   : jsp
    Created on : Mar 14, 2016, 12:58:14 PM
    Author     : Victor Nguyen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <title>Hello Spring Boot MVC + JDBC</title>
        <link rel="stylesheet" href="../../resources/css/style.css">
    </head>
    <body>
        <h2>Here is list all users in system</h2>
        <table>
            <tr>
                <th>ID</th>
                <th>Username</th>
                <th>Full Name</th>
                <th>Email</th>
            </tr>
            <c:forEach items="${users}" var="user">
                <tr>
                    <td>${user.id}</td>
                    <td>${user.username}</td>  
                    <td>${user.fullname}</td>  
                    <td>${user.email}</td>  
                </tr>
            </c:forEach>
        </table>
        Click <a href="/">here</a> to go back!
        <h4>Author: ${author}</h4>
    </body>
</html>

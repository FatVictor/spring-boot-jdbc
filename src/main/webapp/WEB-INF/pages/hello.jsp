<%-- 
    Document   : jsp
    Created on : Mar 14, 2016, 12:58:14 PM
    Author     : Victor Nguyen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib prefix="f" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <title>Hello Spring Boot MVC</title>
    </head>
    <body>
        <h1>Hello, welcome to Spring Boot MVC standalone webapp!</h1>
        Click <a href="users">here</a> to view all users in system!
        <h4>Author: ${author}</h4>
    </body>
</html>

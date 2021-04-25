<%@ page import="java.io.PrintWriter" %><%--
  Created by IntelliJ IDEA.
  User: itak
  Date: 3/23/2021
  Time: 10:22 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<link rel="stylesheet" type="text/css" href="cssfils/Home.css"/>
<body>

<%
    response.setHeader("cache-control","no-store");
    if (session.getAttribute("username") == null) {
        response.sendRedirect("LostUser.html");
    }

%>


<div class="header">

    <h1>Welcome Dear employee: ${username}</h1>
</div>

<div class="navbar">
    <a href="PendingOrder">Pending orders </a>
    <a href="TakeMoreOrder">Take More Order </a>
    <a href="logoutCostomer">LogOut </a>
</div>

<div class="row">
    <div class="side">
        <h2>About Me</h2>
        //TODO
    </div>
    <div class="main">
        <section>

        </section>
        <script src="home.js"></script>
    </div>
</div>
</body>
</html>

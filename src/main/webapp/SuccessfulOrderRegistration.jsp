<%--
  Created by IntelliJ IDEA.
  User: itak
  Date: 3/30/2021
  Time: 12:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<link rel="stylesheet" type="text/css" href="cssfils/Home.css"/>
<%
    response.setHeader("cache-control","no-store");
    if (session.getAttribute("username") == null) {
        response.sendRedirect("LostUser.html");
    }

%>


<div class="header">
    <h1>Dear ${username}</h1>
    <h3>Your order has been successfully registered</h3>

<h3>Your Tracking number ${trackingNumber}</h3>
</div>
<div class="navbar">
    <a href="customerPage.jsp">profile</a>
    <a href="LogoutServlet">Log out </a>
</div>
</body>
</html>

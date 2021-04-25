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
    <h1>welcome ${username}</h1>
</div>

<div class="navbar">
    <a href="Newdelivery.jsp">New Delivery </a>
    <a href="CheckStatus.jsp">Track Order </a>
    <a href= logoutCostomer>Log Out </a>

</div>

    <div class="main">


    </div>

</body>
</html>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<link rel="stylesheet" type="text/css" href="cssfils/TakeMoreOrders.css"/>
<link rel="stylesheet" type="text/css" href="cssfils/Home.css"/>
<body>
<section>
    <div class="navbar">
        <a href="adminPage.jsp">. profile</a>
        <a href="logoutCostomer">LogOut </a>
    </div>

    </div>
    <!--for demo wrap-->
    <h1>List Employee</h1>
    <div class="tbl-header">
        <table cellpadding="0" cellspacing="0" border="0">
            <thead>
            <tr>
                <th>Name</th>
                <th>phoneNumber</th>
                <th>email</th>
            </tr>
            </thead>
        </table>
    </div>
    <div class="tbl-content">
        <table cellpadding="0" cellspacing="0" border="0">
            <tbody>
            <c:forEach items="${ST}" var="T">
            <tr>
                <td>${T.userName}</td>
                <td>${T.phoneNumber}</td>
                <td>${T.email}</td>
            </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</section>
</body>
</html>

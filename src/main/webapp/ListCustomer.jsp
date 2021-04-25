<%@ page import="java.util.List" %>
<%@ page import="com.post.model.entity.EnvelopeInformation" %>
<%@ page import="com.post.model.entity.Envelope" %>
<%@ page import="com.post.model.entity.Customer" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<link rel="stylesheet" type="text/css" href="cssfils/TakeMoreOrders.css"/>
<link rel="stylesheet" type="text/css" href="cssfils/Home.css"/>
<body>
<%
    int count = 0;
%>
<section>
    <div class="navbar">
        <a href="adminPage.jsp">. profile</a>
        <a href="logoutCostomer">LogOut </a>
    </div>

    </div>
    <!--for demo wrap-->
    <h1>List Customer</h1>
    <div class="tbl-header">
        <table cellpadding="0" cellspacing="0" border="0">
            <thead>
            <tr>
                <th>Name</th>
                <th>phoneNumber</th>
                <th>email</th>
                <th>Number of orders</th>
            </tr>
            </thead>
        </table>
    </div>
    <div class="tbl-content">
        <table cellpadding="0" cellspacing="0" border="0">
            <tbody>
            <c:forEach items="${ST}" var="T">
                <%
                    List<Customer> st = (List<Customer>) request.getAttribute("ST");
                    int size = st.get(count).getEnvelopes().size();
                    request.setAttribute("size", size);
                    count++;
                %>
                <%--                <c:forEach items="${SZ}" var="Z">--%>
                <%--                    <tr>--%>
                <td>${T.userName}</td>
                <td>${T.phoneNumber}</td>
                <td>${T.email}</td>
                <td>${size}</td>
                </tr>
            </c:forEach>
            <%--            </c:forEach>--%>
            </tbody>
        </table>
    </div>
</section>
</body>
</html>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<link rel="stylesheet" type="text/css" href="cssfils/TakeMoreOrders.css"/>
<body>
<section>
    <!--for demo wrap-->
    <h1>Take More Order</h1>
    <div class="tbl-header">
        <table cellpadding="0" cellspacing="0" border="0">
            <thead>
            <tr>
                <th>Description</th>
                <th>dateTime</th>
                <td>employeeName</td>
                <td>EnvelopeStatus</td>
            </tr>
            </thead>
        </table>
    </div>
    <div class="tbl-content">
        <table cellpadding="0" cellspacing="0" border="0">
            <tbody>
            <c:forEach items="${ST}" var="T">

                <tr>
                    <td>${T.description}</td>
                    <td>${T.dateTime}</td>
                    <td>${T.employeeName}</td>
                    <td>${T.envelopeStatus}</td>

                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</section>
</body>
</html>

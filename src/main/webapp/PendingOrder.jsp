

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
    <h1>Pending order</h1>
    <div class="tbl-header">
        <table cellpadding="0" cellspacing="0" border="0">
            <thead>
            <tr>
                <th>trackingNumber</th>
                <th>sourceAddress</th>
                <th>destinationAddress</th>
                <th>weight</th>
                <td>height</td>
                <td>length</td>
                <td>width</td>
                <td>EnvelopeType</td>
                <td>postType</td>
            </tr>
            </thead>
        </table>
    </div>
    <div class="tbl-content">
        <table cellpadding="0" cellspacing="0" border="0">
            <tbody>
            <c:forEach items="${ST}" var="T">

                <tr>
                    <td>${T.trackingNumber}</td>
                    <td>${T.sourceAddress}</td>
                    <td>${T.destinationAddress}</td>
                    <td>${T.weight}</td>
                    <td>${T.height}</td>
                    <td>${T.length}</td>
                    <td>${T.width}</td>
                    <td>${T.envelopeType}</td>
                    <td>${T.postType}</td>

                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
    <form method="get" action="PendOrder">
        TrackingNumber:   <input type="text" name="trackingNumber">
        <br>
        Description : <input type="text" name="description">
        <br>
        <input type="submit" value="Pending">
        Status: <select id="status" name="status" >
            <option value="">-- Status --</option>
            <option value="sending">sending</option>
            <option value="Delivered">Delivered</option>
        </select>
    </form>
</section>
</body>
</html>

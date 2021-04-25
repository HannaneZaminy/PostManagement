<%--
  Created by IntelliJ IDEA.
  User: itak
  Date: 4/14/2021
  Time: 10:39 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<link rel="stylesheet" type="text/css" href="cssfils/Newdelivery.css"/>
<body>
<%
    response.setHeader("cache-control", "no-store");
    if (session.getAttribute("username") == null) {
        response.sendRedirect("costomerForm.html");
    }

%>
<div class="header">
    <h1>dear ${username}</h1>
    <h2>You are tracking your order</h2>
</div>

<form action="TrakeOrder" method="get">

    <div class="row">
        <div class="side">


            <br>
            <br>
            <br>
            <div class="form__group">
                <label for="input0"></label><label for="input0"></label><input style="border:2px solid Tomato;"
                                                                               type="text" class="form__inputdDOC"
                                                                               id="input0"
                                                                               placeholder=" trackingNumber"
                                                                               name="trackingNumber" required=""
            >

            </div>
            <input type="submit" value="Track order"/>
        </div>
    </div>
</form>
</body>
</html>

<!DOCTYPE html>
<html>
<head>
    <title>Page Title</title>
</head>
<link rel="stylesheet" type="text/css" href="cssfils/addEmployee.css"/>
<body>
<div class="login-div">
    <div class="logo"></div>
    <div class="title">Employee Register</div>
    <div class="fields">

        <form action="AddEmployee" method="post" onsubmit="return check()">




            <input type="text" name="user" id="user2" placeholder="Username" required/>
            <span id="usererror"></span><br/><br/>
            <input type="password" name="pass" id="pass2" placeholder="Password" required/>
            <span id="passerror"></span><br/><br/>
            <input type="text" name="email" id="email" placeholder="Email" required/>
            <span id="emailerror"></span><br/><br/>
            <input type="text" name="phon" id="phon" placeholder="phone number" required/>
            <span id="phonerror"></span><br/><br/>
            <input type="text" name="name" id="name" placeholder="Name" required/>
            <br/><br/>

            State:
            <select id="car" name="address1" onchange="ChangeCarList()">
                <option value="">-- استان --</option>
                <option value="VO">تهران</option>
                <option value="VW">سمنان</option>
                <option value="BMW">خراسان رضوی</option>
            </select>


            City: <select id="carmodel" name="address2"></select>
            <br>
            <br>

            <div class="signin-button">
                <button class="signin-button" type="submit">Register</button>
            </div>
        </form>
    </div>
</div>


</body>
<script src="jsfile/customerform.js"></script>
</html>

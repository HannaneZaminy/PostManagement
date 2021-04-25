<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
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
    <h2>You are sending packages</h2>
</div>

<section>
    <form action="Requestpost" onsubmit=" return myFunction2()" method="post">
        <!-- The flexible grid (content) -->
        <div class="row">
            <div class="side">
                <!--    <label class="checkbox">
                          <input type="checkbox" name="check" value="check"   id="isAgeSelected"  onclick=" return myFunction()"/>
                    <span>Check Me</span>
                </label> -->
                <label class="checkbox" name="check" value="check" id="isAgeSelected" onclick="myFunction()">
                    <input type="checkbox"/>
                    <span>Document</span>
                </label>


                <br>
                <br>
                <br>


                <div class="form__group">
                    <label for="input0"></label><label for="input0"></label><input style="border:2px solid Tomato;"
                                                                                   type="text" class="form__inputdDOC"
                                                                                   id="input0"
                                                                                   placeholder=" Packaged material"
                                                                                   name="material" required=""
                                                                                   disabled/>

                </div>

                <div class="form__group">
                    <label for="input1"></label><input style="border:2px solid Tomato;" type="text"
                                                       class="form__inputdDOC" id="input1"
                                                       placeholder=" Length" name="Length" required="" disabled/>
                </div>

                <div class="form__group">
                    <label for="input2"></label><input width="80%" ; style="border:2px solid Tomato;" type="text"
                                                       class="form__inputdDOC" id="input2"
                                                       placeholder=" Width" name="width" required="" disabled/>

                </div>
                <div class="form__group">
                    <label for="input3"></label><input style="border:2px solid Tomato;" type="text"
                                                       class="form__inputdDOC" id="input3"
                                                       placeholder=" Height" name="Height" required="" disabled/>

                </div>
                <br>
                <br>
                <br>
                <div class="form__group">
                    <label for="input"></label><label for="input"></label><input style="border:2px solid DeepPink;"
                                                                                 type="text" class="form__input"
                                                                                 id="input" placeholder=" Weight"
                                                                                 required="" name="Weight"/>
                    <label class="form__label"> Weight</label>
                    <span id="Weighterror"></span><br/><br/>
                </div>

                <br>
                <br>
                <br>
                <br>
                <label>Premium
                    <input type="radio" checked="checked" name="radio" value="Premium">
                    <span></span>
                </label>
                <label>Gold
                    <input type="radio" name="radio" value="Gold">
                    <span></span>
                </label>
                <label>Silver
                    <input type="radio" name="radio" value="Silver">
                    <span></span>
                </label>
            </div>
            <div class="main">
                <h2>Source Address</h2>
                <div class="fakeimg" style="height:200px;">
                    <img src="AD1.jpeg" width="200" height="200">
                </div>

                State: <select id="State1" onchange="ChangeCityList1()" name="address1">
                <option value="">-- Ostan --</option>
                <option value="VO">Tehran</option>
                <option value="VW">semnan</option>
                <option value="BMW">Khorasan Razavi</option>
                <br>
            </select>
                City: <select id="city1" name="address2"></select>
                Continue address:<label for="Destinationaddress"></label><input type="text" placeholder="address"
                                                                                id="Destinationaddress"
                                                                                name="address3"/>
                <h2>Destination Address</h2>
                <div class="fakeimg" style="height:200px;">
                    <img src="AD2.png" width="200" height="200">
                </div>
                State: <label for="State"></label><select id="State" onchange="ChangeCityList()" name="address4">
                <option value="">-- استان --</option>
                <option value="VO">Tehran</option>
                <option value="VW">semnan<</option>
                <option value="BMW">Khorasan Razavi</option>
                <br>
            </select>
                City: <select id="city" name="address5"></select>
                Continue address:<label>
                <input type="text" placeholder="address" name="address6">
            </label>


            </div>
        </div>

        <!-- Footer -->
        <div class="footer">
            <h3>If you want to place your order, answer the question: </h3>


            <label id="demo"> +</label>
            <label> + </label>
            <label id="demo2"></label>
            = <input type="text" name="sum" id="sum" value="">
            <input type="submit" value="Send">
            <br>
            <span id="error"></span>
        </div>
    </form>
    <h2 style="color:Goldenrod;">Premium</h2>
    <div class="form__group">
        <input style="border:2px solid Goldenrod;" type="text" class="form__inputPrice" id="Premium"
               placeholder=" Premium" required="" name="inp" disabled/>

    </div>


    <div class="form__group">
        <input style="border:2px solid Goldenrod;" type="text" class="form__inputPrice" id="timePremium"
               placeholder=" Delivery time" required="" name="inp" disabled/>

    </div>
    <h2 style="color:rgb(180, 180, 180);">silver</h2>
    <div class="form__group">
        <input style="border:2px Gainsboro;" type="text" class="form__inputPrice" id="Silver"
               placeholder=" Silver"
               required="" name="inp" disabled/>

    </div>

    <div class="form__group">
        <label for="timeSilver"></label><label for="timeSilver"></label><label
            for="timeSilver"></label><input type="text" class="form__inputPrice" id="timeSilver"
                                            placeholder="Delivery time" required=""
                                            name="inp" disabled/>

    </div>
    <h2 style="color:Gold;">Gold</h2>
    <div class="form__group">
        <label for="Gold"></label><label for="Gold"></label><input style="border:2px solid Gold;"
                                                                   type="text" class="form__inputPrice"
                                                                   id="Gold" placeholder="Gold"
                                                                   required="" name="inp" disabled/>

    </div>

    <div class="form__group">
        <label for="timeGold"></label><input style="border:2px solid Gold;" type="text"
                                             class="form__inputPrice" id="timeGold"
                                             placeholder="Delivery time" required="" name="inp" disabled/>

    </div>
    <input type="submit" id="price" name="price" value="Get the price" onclick="price()"/>
    <br>
    <br>


    <script src="jsfile/Newdeliver.js"></script>
    </div>
</section>

</body>
</html>
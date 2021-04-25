var carsAndModels = {};
carsAndModels['VO'] = ['Damavand', 'Firooz Kooh', 'varamin'];
carsAndModels['VW'] = ['Shahrod', 'Damghan', 'Semnan', 'Shahmirzad'];
carsAndModels['BMW'] = ['Mashhad', 'Tos', 'Torghabe'];

function ChangeCityList1() {
    var carList = document.getElementById("State1");
    var modelList = document.getElementById("city1");
    var selCar = carList.options[carList.selectedIndex].value;
    while (modelList.options.length) {
        modelList.remove(0);
    }
    var cars = carsAndModels[selCar];
    if (cars) {
        var i;
        for (i = 0; i < cars.length; i++) {
            var car = new Option(cars[i], i);
            modelList.options.add(car);
        }
    }
}
function ChangeCityList() {
    var carList = document.getElementById("State");
    var modelList = document.getElementById("city");
    var selCar = carList.options[carList.selectedIndex].value;
    while (modelList.options.length) {
        modelList.remove(0);
    }
    var cars = carsAndModels[selCar];
    if (cars) {
        var i;
        for (i = 0; i < cars.length; i++) {
            var car = new Option(cars[i], i);
            modelList.options.add(car);
        }
    }
}
function myFunction() {
    document.getElementById('isAgeSelected').onchange = function (event) {
        if (event.target.checked) {
            document.getElementById("input0").disabled = false;
            document.getElementById("input1").disabled = false;
            document.getElementById("input2").disabled = false;
            document.getElementById("input3").disabled = false;
        } else {
            document.getElementById("input0").disabled = true;
            document.getElementById("input1").disabled = true;
            document.getElementById("input2").disabled = true;
            document.getElementById("input3").disabled = true;
        }
    }
}
function price(){
    document.getElementById('Premium').value = parseInt(document.getElementById('input').value)*20000;
    document.getElementById('Gold').value = parseInt(document.getElementById('input').value)*14000;
    document.getElementById('Silver').value = parseInt(document.getElementById('input').value)*10000;
    document.getElementById('timeSilver').value = "Next 4 day";
    document.getElementById('timePremium').value = "Next 1 day";
    document.getElementById('timeGold').value = "Next 3 day";
}



const error = document.getElementById('error');
// randomNumber = 0 + Math.floor(Math.random() * 100);
var rand1= 0 + Math.floor(Math.random() * 100);
var rand2= 0 + Math.floor(Math.random() * 100);
// document.write(rand2);
document.getElementById("demo").innerHTML = rand2;
document.getElementById("demo2").innerHTML = rand1;
// document.write(rand1);
function myFunction2(){
    var sum = document.getElementById("sum").value;
    if(parseInt(sum) != rand2+rand1){
        error.textContent='Getting is wrong'
        return false;
    }
    else
        return true;
}


const form = document.querySelector('form');
form.addEventListener('submit' , validate);

function validate(event){
    const Weight = document.getElementById('input');
    const Weighterror = document.getElementById('Weighterror');

    const simple = /^[0-5000]/;
    Weighterror.textContent = '';

    if(!simple.test(Weight.value) ){
        passerror.textContent ='Invalid weight value';
        event.preventDefault();
        return false;
    }

    return true;

}
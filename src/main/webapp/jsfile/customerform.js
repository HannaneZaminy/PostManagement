const form = document.querySelector('form');
form.addEventListener('submit' , validate);

function validate(event){
	const user = document.getElementById('user');
	const pass = document.getElementById('pass');
  const email = document.getElementById('email');
  const phon = document.getElementById('phon');
	const usererror = document.getElementById('usererror');
	const passerror = document.getElementById('passerror');
  const emailerror = document.getElementById('emailerror');
  const phonerror = document.getElementById('phonerror');
  
  
  const simpleEmail = /^[a-z0-9._-]+@[a-z0-9.-]+\.[a-z]{2,4}$/;
  const simplPhone = /^[0]+[0-9]/;
   const simplePass = /^[a-z._-]+[0-9._-]+[a-z0-9._-]/;
	usererror.textContent = '';
	passerror.textContent = '';
  
	if(user.value.length < 5){
		usererror.textContent = 'Username must be at least 5 characters long';
		event.preventDefault();
    return false;
	}
	if(pass.value.length < 8 ){
		passerror.textContent ='Password must be at least 8 characters long';
		event.preventDefault();
	}
  if(!simplePass.test(pass.value) ){
		passerror.textContent ='Password is not secure';
		event.preventDefault();
    return false;
	}
  
  if(!simpleEmail.test(email.value)){
        emailerror.textContent = 'Enter a valid email';
        event.preventDefault();
    return false;
    }
  
  if( !simplPhone.test(phon.value) && phon.value.length < 8){
        phonerror.textContent='Enter the correct phone number'
    event.preventDefault();
     return false;
    }
   return true;
  
}
function check(){
	const user = document.getElementById('user');
	const pass = document.getElementById('pass');
  const email = document.getElementById('email');
  const phon = document.getElementById('phon');
	const usererror = document.getElementById('usererror');
	const passerror = document.getElementById('passerror');
  const emailerror = document.getElementById('emailerror');
  const phonerror = document.getElementById('phonerror');
  
  
  const simpleEmail = /^[a-z0-9._-]+@[a-z0-9.-]+\.[a-z]{2,4}$/;
  const simplPhone = /^[0]+[0-9]/;
   const simplePass = /^[a-z._-]+[0-9._-]+[a-z0-9._-]/;
	usererror.textContent = '';
	passerror.textContent = '';
  
	if(user.value.length < 5){
		usererror.textContent = 'نام کاربری باید حداقل 5  کاراکتر باشد';
		event.preventDefault();
    return false;
	}
	if(pass.value.length < 8 ){
		passerror.textContent ='کلمه‌ی عبور باید حداقل 8 کارکتر باشد';
		event.preventDefault();
	}
  if(!simplePass.test(pass.value) ){
		passerror.textContent ='کلمه‌ی عبور امن نیست';
		event.preventDefault();
    return false;
	}
  
  if(!simpleEmail.test(email.value)){
        emailerror.textContent = 'Enter a valid email';
        event.preventDefault();
    return false;
    }
  
  if( !simplPhone.test(phon.value)  || phon.value.length < 11){
        phonerror.textContent='Enter the correct phone number'
    event.preventDefault();
     return false;
    }
   return true;
  
}
var carsAndModels = {};
carsAndModels['VO'] = ['دماوند', 'فیروز کوه', 'ورامین'];
carsAndModels['VW'] = ['شاهرود', 'دامغان', 'سمنان', 'شهمیرزاد'];
carsAndModels['BMW'] = ['مشهد', 'توس', 'طرقبه'];

function ChangeCarList() {
    var carList = document.getElementById("car");
    var modelList = document.getElementById("carmodel");
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


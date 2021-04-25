const form = document.querySelector('form');
form.addEventListener('submit' , validate);

function validate(event){
    //const user = document.getElementById('username');
    const pass = document.getElementById('password');
    const phon = document.getElementById('phone');
    const simplPhone = /^[0]+[0-9]/;
    const simplePass = /^[a-z._-]+[0-9._-]+[a-z0-9._-]/;
    const simplePass2 = /^[0-9._-]+[a-z._-]+[a-z0-9._-]/;
    const usererror = document.getElementById('usererror');
    const passerror = document.getElementById('passerror');
    const phonerror= document.getElementById('phonerror');
    const email = document.getElementById('email');
    const emailerror = document.getElementById('emailerror');
    const simpleEmail = /^[a-z0-9._-]+@[a-z0-9.-]+\.[a-z]{2,4}$/;
    emailerror.textContent = '';
    usererror.textContent = '';
    passerror.textContent = '';
    phonerror.textContent='';
    if( !simplPhone.test(phon.value) && phon.value.length!==11){
        phonerror.textContent='Enter the correct phone number'
    }
    if(user.value.length < 3 || user.value.length > 6){
        usererror.textContent = 'نام کاربری باید3 تا 6 کاراکتر باشد';
        event.preventDefault();
    }
    if((!simplePass.test(pass.value) && pass.value.length < 8) || (!simplePass2.test(pass.value) && pass.value.length < 8)){
        passerror.textContent ='Password is not secure';
        event.preventDefault();
    }

    if(!simpleEmail.test(email.value)){
        emailerror.textContent = 'Enter a valid email';
        event.preventDefault();
    }
}
const data = [
    {
        "username": "Jeannie_23",
        "name": "Jeannie Randolph",
        "pass": "$3z&Se8Ph8",
    },
    {
        "username": "k_brown",
        "name": "Kathie Brown",
        "pass": "*7Gf5iNy7@",
    },
    {
        "username": "mega_powers",
        "name": "Powers Justice",
        "pass": "8*DkE87jb&",
    },
    {
        "username": "o.neal",
        "name": "Morales Oneal",
        "pass": "68Zp6-@vUp",
    },
    {
        "username": "A-dela",
        "name": "Adela Heath",
        "pass": "83-2pgJSj$",
    }];

const root = document.getElementById('root');

const form = document.createElement('form');
form.setAttribute('class', 'form');

const form__modal_wrapper = document.createElement('div');
form__modal_wrapper.setAttribute('class', 'form__modal_wrapper');

const firstName = document.createElement('input');
firstName.setAttribute('class', 'form__firstName form__input');
firstName.setAttribute('maxLength', '10');
firstName.setAttribute('placeholder', 'Firstname');

const lastName = document.createElement('input');
lastName.setAttribute('class', 'form__lastName form__input');
lastName.setAttribute('maxLength', '20');
lastName.setAttribute('placeholder', 'Lastname');

const password = document.createElement('input');
password.setAttribute('class', 'form__password form__input');
password.setAttribute('type', 'password');
password.setAttribute('placeholder', 'Password');
password.setAttribute('required', 'true');
password.setAttribute('maxLength', '10');

const passBtn = document.createElement('button');
passBtn.setAttribute('class', 'form__password form__input form__input_button');
passBtn.setAttribute('type', 'button');

const btnNode = document.createTextNode('*');
passBtn.append(btnNode);

const alertField = document.createElement('div');
alertField.setAttribute('class', 'form__alertWindow form__div');

const messageField = document.createElement('p');
messageField.setAttribute('class', 'form__message form__p');

const btn = document.createElement('button');
btn.setAttribute('class', 'form__btn');
btn.setAttribute('type', 'button');

const textnode = document.createTextNode('Authorization');

btn.append(textnode);
alertField.append(messageField);
alertField.hidden = true;

form__modal_wrapper.append(firstName);
form__modal_wrapper.append(lastName);
form__modal_wrapper.append(password);
form__modal_wrapper.append(btn);
form__modal_wrapper.append(alertField);

form.append(form__modal_wrapper);

root.append(form);

btn.addEventListener('click', (ev) => {
    sendData();
});

function sendData() {
    let firstVal = firstName.value;
    let lastVal = lastName.value;
    let passVal = password.value;
    let fieldsCounter = 0;
    const singleField = 'Поле';
    const multipleFields = 'Поля';
    let fiedls = '';
    const fullName = firstVal + " " + lastVal;
    const regex = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[$&@*-])[A-Za-z\d$&@*-]{5,10}$/;
    let checkReg = regex.test(password.value);
    if (checkReg !== true) {
        password.style.border = '1px solid red'
    } else {
        password.style.borderColor = 'green';
    }
    if (firstName.value === '' || lastName.value === '' || checkReg !== true) {
        let fieldsToShow = '';
        let alertString = '';
        if (firstVal === '') {
            fieldsToShow += 'firstname, '
            fieldsCounter++;
        }
        if (lastVal === '') {
            fieldsToShow += 'lastname, '
            fieldsCounter++;
        }
        if (passVal === '') {
            fieldsToShow += 'password '
            fieldsCounter++;
        } else if (checkReg === false) {
            fieldsToShow += 'пароль должен состоять только из букв, цифр и спецсимволов $, &, @, *'
        }
        if (fieldsCounter < 2) {
            alertString = singleField + ' ' + fieldsToShow + 'обязательное к заполнению';
        } else {
            alertString = multipleFields + ' ' + fieldsToShow + 'обязательные к заполнению';
        }
        messageField.innerHTML = 'Ошибка валидации: \n' + alertString;
        alertField.hidden = false;
    } else {
        auth(fullName, passVal);
    }
}

firstName.addEventListener('input', (e) => {
    const regex = /^[A-Za-z-]{2,10}$/;
    let checkFirst = regex.test(firstName.value);
    if (checkFirst !== true) {
        firstName.style.border = '1px solid red'
    } else {
        firstName.style.borderColor = 'green';
    }
});

lastName.addEventListener('input', (e) => {
    const regex = /^[A-Za-z-]{2,20}$/;
    let checkLast = regex.test(lastName.value);
    if (checkLast !== true) {
        lastName.style.border = '1px solid red'
    } else {
        lastName.style.borderColor = '#499449';
    }
});

function auth(name, password) {
    let answer = false;
    let i = 0;
    let userName = ''
    while(i < data.length) {
        if (data[i].name === name && data[i].pass === password) {
            userName = data[i].username;
            answer = true;
            i = data.length + 1;
        }
        i++;
    }
    if (answer === true) {
        messageField.innerHTML = "Вы успешно авторизировались как: " + "\n" + userName + ', ' + name;
        alertField.hidden = false;
        alertField.style.background = '#499449';
    } else {
        messageField.innerHTML = "Ошибка аутентификации";
        alertField.hidden = false;
        alertField.style.background = '#ff5858';
    }

}

window.addEventListener('keypress', (e) => {
    if (e.key === 'Enter') {
        sendData();
    }
})

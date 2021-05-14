const buttonLeft = document.getElementById('leftButton');
const buttonRight = document.getElementById('rightButton');
const scrollContainer = document.getElementById('reviewMain');
const sendContacts = document.getElementById('submitButton');
const sendGood = document.getElementById('contactsSendGood');

buttonLeft.onclick = function () {
    scrollContainer.scrollLeft -= 800;
}

buttonRight.onclick = function () {
    scrollContainer.scrollLeft += 800;
}

sendContacts.addEventListener('click', (e) => {
    sendGood.style.transition = '0.5s';
    console.log('pressed');
    sendGood.style.opacity = '100';
    sendGood.style.visibility = 'visible';
    setTimeout(function () {
        console.log('got in timeout');
        sendGood.style.opacity = '0';
        sendGood.style.visibility = 'hidden';
    }, 5000);
})
var
    color = 'black',
    canv = document.getElementById('canvas'),
    ctx = canv.getContext('2d'),
    back_color = document.getElementById('background_color'),
    back_color_canv = 'white',
    back_color_log = false,
    isMouseDown = false,
    coords = [],
    rep = false;

function color_black() {
    color = 'black';
}

function color_yellow() {
    color = 'yellow';
}

function color_green() {
    color = 'green';
}

function color_red() {
    color = 'red';
}

function color_blue() {
    color = 'blue';
}

function color_orange() {
    color = '#b05814';
}

function color_white() {
    color = 'white';
}

function color_lightblue() {
    color = "#3f9bb7";
}

function color_violet() {
    color = "#55329b";
}

function clear() {
    ctx.fillStyle = back_color_canv;
    ctx.fillRect(0, 0, canv.width, canv.height);

    ctx.beginPath();
    ctx.fillStyle = color;
}

canv.width = window.innerWidth
canv.height = window.innerHeight

canv.addEventListener('mousedown', function () {
    isMouseDown = true;
});

canv.addEventListener('mouseup', function () {
    isMouseDown = false;
    ctx.beginPath();
    coords.push('mouseup');
});

ctx.lineWidth = 10;
canv.addEventListener('mousemove', function (e) {
    canv.style.backgroundColor = back_color_canv;
    if (isMouseDown && !rep) {
        ctx.strokeStyle = color;
        ctx.fillStyle = color;
        coords.push([e.clientX, e.clientY, color])
        ctx.lineTo(e.clientX, e.clientY);
        ctx.stroke();

        ctx.beginPath();
        ctx.arc(e.clientX, e.clientY, 5, 0, Math.PI * 2);
        ctx.fill();

        ctx.beginPath();
        ctx.moveTo(e.clientX, e.clientY);
    }
});



ctx.lineWidth = 10;

function replay() {
    var
        timer = setInterval(function () {
            if (!coords.length) {
                rep = false;
                clearInterval(timer);
                ctx.beginPath();
                return;
            } else {
                rep = true;
            }

            var
                crd = coords.shift(),
                e = {
                    clientX: crd["0"],
                    clientY: crd["1"]
                };
            ctx.strokeStyle = crd["2"];
            ctx.fillStyle = crd["2"];
            ctx.lineTo(e.clientX, e.clientY);
            ctx.stroke();

            ctx.beginPath();
            ctx.arc(e.clientX, e.clientY, 5, 0, Math.PI * 2);
            ctx.fill();

            ctx.beginPath();
            ctx.moveTo(e.clientX, e.clientY);

        }, 25);
}

document.addEventListener('keydown', function (e) {

    if (e.keyCode == 83) {
        save();
        console.log('saved')
    }

    if (e.keyCode == 82) {
        coords = JSON.parse(localStorage.getItem('coords'));

        clear();
        replay();
        console.log('replay ...')
    }

    if (e.keyCode == 67) {
        clear();
        console.log('cleared')
    }

});
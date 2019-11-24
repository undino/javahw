let arr = [
    'p0.img',
    'p1.img',
    'p2.img',
    'p3.img',
    'p4.img',
    'p5.img',
    'p6.img',
    'p7.img',
    'p8.img',
    'p9.img',
    'p10.img',
    'p11.img',
    'p12.img',
];

let count = 0;
let interval;
document.getElementById('slideShowPictures').onclick = function () {
    let timeout = (prompt("Specify the interval between pictures in seconds") * 1000);
    interval = setInterval(startShow, timeout);
};

document.getElementById('stopSlideShowPictures').onclick = function () {
    clearInterval(interval);
};

document.getElementById('nextPicture').onclick = startShow;

document.getElementById('previousPicture').onclick = function () {
    if (count)
    count -= 2;
    startShow();
};

function startShow() {
    if (count === -1) count = 12;

    if (count !== 13) {
        document.getElementById('pictures').setAttribute('src', 'img/p' + count + '.jpg');
        count++
    } else {
        count = 0;
    }
}


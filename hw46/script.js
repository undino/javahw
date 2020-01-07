let arr = [
    'p0.jpg',
    'p1.jpg',
    'p2.jpg',
    'p3.jpg',
    'p4.jpg',
    'p5.jpg',
    'p6.jpg',
    'p7.jpg',
    'p8.jpg',
    'p9.jpg',
    'p10.jpg',
    'p11.jpg',
    'p12.jpg',
];

let index = 0;
let interval;
slideShowPictures.onclick = function () {
    let timeout = (prompt("Specify the interval between pictures in seconds") * 1000);
    // перед установкой нового интервала нужно проверять не запущено ли было
    // слайд шоу ранее и если так, то остановить иначе слайд шоу можно несколько
    // раз запустить после чего невозможно будет остановить
    interval = setInterval(startShow, timeout);
};

stopSlideShowPictures.onclick = function () {
    clearInterval(interval);
};

nextPicture.onclick = startShow;

previousPicture.onclick = function () {
    if (index)
        index -= 2;
    startShow();
};

function startShow() {
    if (index === -1) index = 12;

    if (index !== arr.length) {
        document.getElementById('pictures').setAttribute('src', 'img/' + arr[index]);
        index++
    } else {
        index = 0;
    }
}


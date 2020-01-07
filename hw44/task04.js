"use strict";
let arrFirst = [1, 15, 12, [10, [19], 20], 30];

function array_Clone(arr) {
    return arr.slice(0, arrFirst.length);
}

let arrSecond = array_Clone(arrFirst);

arrFirst[3][0] = 100;
console.log(arrFirst);
console.log(arrSecond); // Почему меняются два массива? Потому, что клонирование нужно было делать рекурсивным

'use strict';

let arr = [1, 2, 3, 4, 5, 6, 7, 8, 9];

function arrRandom(arr) {
    let item = '';
    for (let i = 0; i < arr.length; i++) {
        for (let j = Math.floor(Math.random() * arr.length); true;) {
           item = arr[i];
           arr[i] = arr[j];
           arr[j] = item;
           break
        }
    }
    return arr;
}
document.writeln(arrRandom(arr));
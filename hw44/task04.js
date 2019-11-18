"use strict";
let arrFirst = [1, 15, 12, 10, 19, 20, 30];

function copyOfArray(arr) {
   return  arr.slice(0, arrFirst.length);
}

let arrSecond = copyOfArray(arrFirst);

for (let i = 0; i < arrSecond.length - 1; i++) {
    document.writeln(arrSecond[i]);
}

'use strict';

let arr = [2, 3, 9, 42, 33, 16, 2];
let sumNum = pow(arr);
function pow(arr) {
    let value = 0;
    for (let i = 0; i < arr.length; i++) {
        value += Math.pow(arr[i], 2);
    }
    return value;
}
document.writeln(sumNum);
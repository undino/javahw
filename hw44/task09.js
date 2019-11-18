'use strict';

let arr = [1, 2, 3, 4, 5, 1, 1, 2, 3, 4, 3, 2, 9, 10, 22, 16, 7];

function f(arr) {
    let newArr = [];
    for (let i = 0; i < arr.length; i++) {
        if (i === 0) {
            newArr.push(arr[i]);
        } else if (newArr.indexOf(arr[i]) === -1) {
            newArr.push(arr[i]);
        }
    }
    return newArr ;
}
document.writeln(f(arr));
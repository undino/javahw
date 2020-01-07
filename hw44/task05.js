"use strict";
let arr = [20, 22, 33, 'aa', 10, 30, 'fff'];
let first = function (arr, count = 1) {
    return arr[0];
};
console.log(first(arr)); // здесь все правильно - 20
console.log(first(arr, 2)); // здесь должны получить [20, 22]

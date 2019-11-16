"use strict";
let a = prompt("Enter any number of numbers separated by spaces");
let arr = a.split(" ");
let positiveNumber = 0;
let negativeNumber = 0;
let evenNumber = 0;
let oddNumber = 0;
let zero = 0;
for (let i = 0; i < arr.length; i++) {
    if (arr[i] > 0) {
        positiveNumber++;
    }  if (arr[i] < 0) {
        negativeNumber++;
    }  if (arr[i] == 0) {
        zero++;
    }  if (arr[i] % 2 == 0) {
        evenNumber++;
    }  if (arr[i] % 2 != 0) {
        oddNumber++;
    }
}
document.write('positiveNumber = ' + positiveNumber + '<br>'
    + 'negativeNumber = ' + negativeNumber + '<br>'
    + 'evenNumber = ' + evenNumber + '<br>'
    + 'oddNumber = ' + oddNumber + '<br>'
    + 'zero = ' + zero);


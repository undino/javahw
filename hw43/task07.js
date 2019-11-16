"use strict";
let a = parseInt(prompt("Enter number"));
let b = parseInt(prompt("How mush number need to displace "));
let counterNumber = '';
let result = '';
counterNumber += a;
for (let i = 0; i < b; i++) {
    result = counterNumber.slice(b, counterNumber.length) + counterNumber.slice(0, b);
}
document.write(result);
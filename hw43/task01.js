"use strict";
let a = parseInt(prompt("Enter the starting number"));
let b= parseInt(prompt("Enter the final number"));
let result = 0;
for (let i = a; i < b; i++){
    result += i;
}
document.write(result);
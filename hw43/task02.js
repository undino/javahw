"use strict";
let a = parseInt(prompt("Enter the first number"));
let b= parseInt(prompt("Enter the second number"));
let temp = 0;
while (b != 0){
    temp = a%b;
    a = b;
    b = temp;
}
document.write(a);


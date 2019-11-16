"use strict";
let a = parseInt(prompt("Enter number"));
let string = "";
for (let i = 1; i < a; i++) {
    if (a % i === 0) {
        string += i + ', ';
    }
}
document.write(string);


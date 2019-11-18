'use strict';
alert("Guess  a number from 0 to 100");
let start = 0;
let end = 100;
let equal = true;
let count = 0;
do {
    let result = prompt("If you number equal " + (Math.round((end + start)/2)) + " specify \"=\", then specify \">\" or \"<\"");
    if (result === "=") {
        equal = false;
    } else if (result === ">") {
        start = (start + end) / 2;
    } else if (result === "<") {
        end = (start + end) / 2;
    }
    count++;
} while (equal);
alert("I guessed your number in " + count + " attempts")
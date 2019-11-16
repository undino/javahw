"use strict";
let a;
let b;
let sing;

do {
    a = parseInt(prompt("Enter first number"));
    sing = prompt("Enter sing");
    b = parseInt(prompt("Enter second number"));
    let result = 0;
    if (sing === '-') {
        alert( a - b);
    } else if (sing == '+') {
        alert( a + b);
    } else if (sing == '/') {
        alert( a / b);
    } else if (sing == '*') {
        alert( a * b);
    }

    if (confirm("Хотите ли вы решить еще пример?")) {
        continue;
    } else {
        break;
    }
} while (true);

// confirm("Yo Do you want another try?")
'use strict';
let usersNumber = prompt('Insert the number');
let newStringNumber = '';
for (let i = 0; i < usersNumber.length; i++) {
    if (usersNumber[i] % 2 === 0) {
        newStringNumber += usersNumber[i] + '-';
    } else {
        newStringNumber += usersNumber[i];
    }
}

document.writeln(newStringNumber);
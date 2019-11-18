"use strict";
let arrValue = [3, 'a', 'a', 'a', 2, 3, 'a', 3, 'a', 2, 4, 9, 3];
let countAll = 0;
let countItem = 0;
let value = '';
for (let i = 0; i < arrValue.length - 1; i++) {

    let item = arrValue[i];

    for (let j = 0; j < arrValue.length - 1; j++) {
        if (arrValue[j] === arrValue[i]) {
            countAll++;
        }
    }

    if (countItem < countAll && item !== value) {
        value = item;
        countItem = countAll;
    }
    countAll = 0;

}
document.write("Value \"" + value + "\" count \"" + countItem + "\"");

"use strict";

let color;

/*
Задание 1
	- объявить глобальную переменную color +
	- объявить функцию setColor() +
	- в функции setColor() объявить локальную переменную color -
	- с вероятностью 50% задать значение локальной переменной или глобальной -
	- для глобальной переменной задается цвет красный, для локальной - черный
	- вывести значение локальной и глобальной переменной в консоль через console.log() +
	- передать значение измененной переменной в функцию drawBox() +
	- объявить функцию drawBox() с одним параметром color +
	- вывести через document.writeln() в html блочный элемент (div) закрашенный цветом color +
*/



function setColor() {
    let color;
    if (Math.round(Math.random(1)) === 0) {
        window.color = 'red';
        drawBox(window.color);
    } else {
        color = 'black';
        drawBox(color);
    }
    console.log("Global variable is " + window.color);
    console.log("Local variable is " + color);
}

function drawBox(color) {
    document.write("<div style='width: 200px; height: 150px; background-color: " + color + " '></div>")
}

setColor();
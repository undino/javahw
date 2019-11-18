"use strict";
let color = 'black';
console.log("Global variable is " + color)

if (Math.round(Math.random(1)) === 0) {
    drawBox(color)
} else {
    setColor("red");
}

function setColor(color) {
    console.log("Local variable is " + color)
    drawBox(color);
}

function drawBox(color) {
    document.write("<div style='width: 200px; height: 150px; background-color: " + color + " '></div>")
}
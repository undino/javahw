"use strict";
const daysOfTheWeek = ['Sunday', 'Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday', 'Saturday'];
let count = new Date().getDay();
do {
    if (count >= 7) count = 0;
} while (confirm("Now is the day of the week = " + daysOfTheWeek[count++] + ".\nWant to see the next day of the week?"));

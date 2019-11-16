'use strict'
document.write("<table style='border: 1px solid black'><caption>Multiplication table</caption>");
for (let i = 1; i < 10; i++) {
    document.write("<tr>");
    for (let j = 1; j < 10; j++) {
        document.write("<td>" + (i * j) + "</td>");
    }
    document.write("</tr>");
}
document.write("</table>");
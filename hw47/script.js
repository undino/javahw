let body = document.querySelector("body");

let div = body.appendChild(document.createElement("div"));
div.style.borderColor = "black";
div.style.borderStyle = "solid";
div.style.padding = "0px 50px 50px";
div.style.position = "relative";

let h1 = div.appendChild(document.createElement("h1"));
h1.appendChild(document.createTextNode("TODO list"));
let hr = div.appendChild(document.createElement("hr"));
hr.style.border = "none";
hr.style.height = "2px";
hr.style.backgroundColor = "black";

let input = div.appendChild(document.createElement("input"));
input.setAttribute("placeholder", "New TODO item");
input.style.width = "70%";
input.style.marginTop = "20px";
input.style.height = "30px";
input.style.borderColor = "black";
input.style.fontSize = "15px";
input.style.paddingLeft = "10px";

let button = div.appendChild(document.createElement("button"));
button.appendChild(document.createTextNode("Create TODO"));
button.style.marginLeft = "20px";
button.style.height = "30px";
button.style.borderRadius = "5px";
button.style.boxShadow = "2px 2px 2px 1px rgba(0, 0, 0, 0.2)";
button.style.position = "absolute";
button.style.top = "110px";
button.style.right = "50px";

let ol = div.appendChild(document.createElement("ol"));
ol.style.marginTop = "25px";
ol.style.listStyleType = "none";
ol.style.paddingLeft = "0px";


button.addEventListener("click", newTODO);


function newTODO() {
    if (input.value !== "") {

        let li = ol.appendChild(document.createElement("li"));
        li.style.height = "30px";
        li.style.borderBottom = "1px solid black";
        li.style.verticalAlign = "middle";
        li.style.marginTop = "25px";
        li.style.position = "relative";

        let checkBox = li.appendChild(document.createElement("input"));
        checkBox.setAttribute("type", "checkBox");
        checkBox.style.width = "20px";
        checkBox.style.height = "20px";
        checkBox.style.verticalAlign = "middle";

        let spanTextBox = li.appendChild(document.createElement("span"));
        spanTextBox.appendChild(document.createTextNode(input.value));
        spanTextBox.style.fontSize = "17px";
        spanTextBox.style.fontFamily = "Arial";
        spanTextBox.style.marginLeft = "25px";
        spanTextBox.style.display = "inline-block";
        spanTextBox.style.verticalAlign = "middle";

        let buttonRemove = li.appendChild(document.createElement("button"));
        buttonRemove.appendChild(document.createTextNode("Delete"));
        buttonRemove.style.position = "absolute";
        buttonRemove.style.right = "45px";
        buttonRemove.style.border = "none";
        buttonRemove.style.borderBottom = "1px solid blue";
        buttonRemove.style.backgroundColor = "white";
        buttonRemove.style.color = "blue";
        buttonRemove.style.cursor = "pointer";
        input.value = "";

        buttonRemove.addEventListener("click", removeItem);

        function removeItem() {
            this.parentNode.parentNode.removeChild(this.parentNode);
        }

        checkBox.addEventListener("click", show);

        function show() {
            if (checkBox.checked) {
                let span = checkBox.nextElementSibling;
                console.log("Everything = " + span.innerHTML);
                let textInnerSpan = span.style.textDecoration = "line-through";
                textInnerSpan = span.style.color = "darkgray";
            } else {
                let span = checkBox.nextElementSibling;
                console.log("Everything = " + span.innerHTML);
                let textInnerSpan = span.style.textDecoration = "none";
                textInnerSpan = span.style.color = "black";
            }
        }

    }
}








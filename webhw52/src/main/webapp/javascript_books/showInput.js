

document.getElementById("select").addEventListener("change", function (ev) {
    let inputInner = document.getElementById("inputRequest");
    let valueOfSelect = document.getElementById("select");


    if (parseInt(valueOfSelect.value) >= 5) {
        inputInner.style.display = "block";
        inputInner.placeholder = "Введите значение поиска запроса";
        inputInner.setAttribute("required", true);

        if (parseInt(valueOfSelect.value) === 5) {
            document.getElementById("Actors").style.display = "none";
            document.getElementById("Genres").style.display = "block";
            document.getElementById("Directors").style.display = "none";
        } else if (parseInt(valueOfSelect.value) === 6) {
            document.getElementById("Actors").style.display = "block";
            document.getElementById("Genres").style.display = "none";
            document.getElementById("Directors").style.display = "none";
        } else if (parseInt(valueOfSelect.value) === 7) {
            document.getElementById("Actors").style.display = "none";
            document.getElementById("Genres").style.display = "none";
            document.getElementById("Directors").style.display = "block";
        }

    } else if (parseInt(valueOfSelect.value) < 5) {
        inputInner.style.display = "none";
        document.getElementById("Actors").style.display = "none";
        document.getElementById("Genres").style.display = "none";
        document.getElementById("Directors").style.display = "none";
    }

});


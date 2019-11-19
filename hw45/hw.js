function isUpperCaseFirstLetter(str) {
    return /^[A-ZА-Я]/.test(str);
}

function isValidEmail(str) {
    return /.+@[^.].+\..+/.test(str);
}

function trimString(str) {
    return str.replace(/^\s*/, "").replace(/\s*$/, "").replace(/\s/, " ");
}

function thousandsSeparators(num) {
    return String(num).replace(/(\d)(?=((\d{3})+)(\D|$))/g, '$1,');
}


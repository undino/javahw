function isUpperCaseFirstLetter(str) {
    return /^[A-ZА-ЯЁ]/.test(str); // У буквы Ё код 1025 и он не входит в диапазон А-Я (для unicode)
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


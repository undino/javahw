function formatCurrency(num) {
    num = num.replace(/(\d)(?=((\d{3})+)(\D|$))/, ',');
    return String(num);
}

alert('123456789.25'.replace(/(\d)(?=((\d{3})+)(\D|$))/g, '$1,'))


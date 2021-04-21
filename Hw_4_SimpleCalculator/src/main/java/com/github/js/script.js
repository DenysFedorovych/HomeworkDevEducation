function equal() {
    switch (operation.value) {
        case "+":
            result.value = parseFloat(first.value) + parseFloat(second.value);
            break;
        case "-":
            result.value = parseFloat(first.value) - parseFloat(second.value);
            break;
        case "*":
            result.value = parseFloat(first.value) * parseFloat(second.value);
            break;
        case "/":
            result.value = parseFloat(first.value) / parseFloat(second.value);
            break;
        case "%":
            result.value = parseFloat(first.value) % parseFloat(second.value);
            break;
        default:
            result.value = "No such math oper";
    }
}
function checkDigits(num) {
    var last = num%10;
    num = Math.floor(num / 10);
    while(num !== 0) {
        if(num % 10 !== last)
            return false;
        num = Math.floor(num / 10);
    }
    return true;
}

console.log(checkDigits(5555));

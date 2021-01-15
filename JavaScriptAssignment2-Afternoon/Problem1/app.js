class input {
    constructor(param) {
        this.input = param;
    }
    calculateLength() {
        return this.input.length;
    };
    getUpperCase() {
        return this.input.toUpperCase();
    };
    getLowerCase() {
        return this.input.toLowerCase();
    };
    separate() {
        let vowels = [];
        let consonants =[];
        for(var letter of this.input) {
            if (/[aeiouAEIOU]/.test(letter)) {
                vowels.push(letter);
            } else if(/[A-Za-z]/.test(letter)) {
                consonants.push(letter);
            }
        }
        return "Vowels: "+ vowels + " Consonants: " +consonants;
    };

    isNUmberPresent() {
        for (var letter of this.input){
            if (/[0-9]/.test(letter)){
                return "YES";
            }
        }
        return "NO";
    }
}

function callFunction() {
    var inputValue = document.getElementById("inputTxt").value;
    let inputObject = new input(inputValue);
    document.getElementById("lengthOp").innerHTML = inputObject.calculateLength();
    document.getElementById("ucOp").innerHTML = inputObject.getUpperCase();
    document.getElementById("lcOp").innerHTML = inputObject.getLowerCase();
    document.getElementById("sep").innerHTML = inputObject.separate();
    document.getElementById("num").innerHTML = inputObject.isNUmberPresent();
}
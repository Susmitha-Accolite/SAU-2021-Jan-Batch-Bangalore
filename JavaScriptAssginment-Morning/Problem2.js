

function toggle_case(txt) {
    var s = "";
    for (let i = 0; i < txt.length; i++) {
        if (/[A-Z]/.test(txt[i])) 
            s += txt[i].toLowerCase();
        else s += txt[i].toUpperCase();
    }
    return s;
}

console.log(toggle_case("w3resource"));
console.log(toggle_case("Germany"));
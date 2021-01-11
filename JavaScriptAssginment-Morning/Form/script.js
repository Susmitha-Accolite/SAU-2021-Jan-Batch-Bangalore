function printDetails() {
    var firstName = document.getElementById("first-name").value;
    var lastName = document.getElementById("last-name").value;
    var email = document.getElementById("email").value;
    var gender = document.getElementById("gender").value;
    var job = document.getElementById("dropdown").value;
    let details = {
        'FirstName' : firstName,
        'LastName' : lastName,
        'Email': email,
        'Gender': gender,
        'Job Role': job
    };
    console.log(details);
}

function validateEmail() {
    var pattern = /^[a-zA-Z0-9]+(.)+@[a-zA-Z0-9]+(.com)*$/;
    var param = document.getElementById("email").value;
    if(param.match(pattern)){
        printDetails();
        return true;
    }
    else {
        alert("Invalid Email address!!");
        document.getElementById("email").focus();
        return false;
    }
}
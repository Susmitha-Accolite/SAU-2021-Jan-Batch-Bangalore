class details {
    constructor(param1, param2, param3, param4, param5, param6) {
        this.rollno = param1;
        this.firstname = param2;
        this.lastname = param3;
        this.email = param4;
        this.dob = param5;
        this.gender = param6;
    };
};

var detailsObject;

function emailCheck(email) {
    //Only true for the email IDs with domain as ".com"
    var pattern = /^[a-zA-Z0-9]+(.)+@[a-zA-Z0-9]+(.com)*$/;
    if(email.match(pattern)){
        return true;
    }
    else
        return false;
}

function validateDetails(rollno, firstName, lastName, lastName, email, dob, gender) {
    if(rollno == '') {
        alert("Please Enter Roll no");
        return false;
    }
    else if(firstName ==''){
        alert("please enter first name");
        return false;
    }
    else if(lastName ==''){
        alert("please enter last name");
        return false;
    }
    else if(emailCheck(email)){
        alert("please enter valid email");
        return false;
    }
    else if(gender == ''){
        alert("please choose gender");
        return false;
    }
    else if(dob ==''){
        alert("please enter date of birth");
        return false;
    }
    else{
        return true;
    }
}

function chooseGender() {
    if(!document.getElementById("female").checked && !document.getElementById("male")){
        return '';
    }
    if(document.getElementById("female").checked){
        return "female";
    }
    else{
        return "male";
    }
}

function setDetails() {
    var rollno = document.getElementById("rollno").value;
    var firstName = document.getElementById("first-name").value;
    var lastName = document.getElementById("last-name").value;
    var email = document.getElementById("email").value;
    var dob = document.getElementById("dob").value;
    var gender = chooseGender();
    var occupation = document.getElementById("occupation").value;

    // validating the user inputs
    if(validateDetails(rollno, firstName, lastName, email, dob, gender)) {
        alert("All details are submitted successfully");
        detailsObject = new details(rollno, firstName, lastName, email, dob, gender);

        // Creates a new field occupation according to the user input
        if(occupation !== ''){
            detailsObject["Occupation"] = occupation;
        }
    }
}


function printDetails() {
    var roll = document.forms["myform"]["roll"].value;
    console.log(roll);
    if(roll == detailsObject["rollno"]){
        document.getElementById("r").innerHTML = "Roll No:"+detailsObject["rollno"];
        document.getElementById("fname").innerHTML = "FirstName: "+detailsObject["firstname"];
        document.getElementById("lname").innerHTML = "LastName: "+detailsObject["lastname"];
        document.getElementById("e").innerHTML = "Email: "+detailsObject["email"];
        document.getElementById("d").innerHTML = "Date Of Birth: "+detailsObject["dob"];
        document.getElementById("gen").innerHTML = "Gender: "+detailsObject["gender"];
        console.log(detailsObject["Occupation"])
        if(detailsObject["Occupation"] !== undefined && detailsObject["Occupation"]){
            document.getElementById("occ").innerHTML = "Occupation: "+detailsObject["Occupation"];
        }
        else{
            document.getElementById("occ").innerHTML="";
        }
    }

    else{
        alert("Invalid RollNo");
    }
        
}
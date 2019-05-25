/**
 * 
 */
function taskAdded() {
    alert("New task was added!");
    document.getElementById("subject").value = "";
    document.getElementById("taskNo").value = "";
}

function sentEmailConfirm() {
    alert("Mail has been sent!");
    document.getElementById("subject").value = "";
    document.getElementById("message").value = "";
    document.getElementById("replyMail").value = "";
}

function dateTime() {
    var today = new Date();
    var day = today.getDate();
    var month = today.getMonth() + 1;
    if (month < 10)
        month = "0" + month;
    var year = today.getFullYear();
    var hours = today.getHours();
    if (hours < 10)
        hours = "0" + hours;
    var minute = today.getMinutes();
    if (minute < 10)
        minute = "0" + minute;
    var seconde = today.getSeconds();
    if (seconde < 10)
        seconde = "0" + seconde;
    document.getElementById("clock").innerHTML = "Date & time now: " + day +
        "/" + month + "/" + year + " " + " " + hours + ":" + minute + ":" +
        seconde;
    setTimeout("dateTime()", 1000);
}

function goBack() {
    window.history.back();
}

function validateLoginForm() {
    if (document.loginForm.username.value == "" && document.loginForm.password.value == "") {
        alert("Login i hasło są wymagane!");
        document.loginForm.username.focus();
        return false;
    }
    if (document.loginForm.username.value == "") {
        alert("Proszę podać login!");
        document.loginForm.userName.focus();
        return false;
    }
    if (document.loginForm.password.value == "") {
        alert("Proszę podać hasło");
        document.loginForm.password.focus();
        return false;
    }
}

function userAdded(){
    document.getElementById("username").value = "";
    document.getElementById("password").value = "";
    document.getElementById("firstName").value = "";
    document.getElementById("lastName").value = "";
    document.getElementById("email").value = "";
    alert("New user was added!");
}
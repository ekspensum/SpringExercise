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
    document.getElementById("clock").innerHTML = "Date & time now: " + day + "/" + month + "/" + year + " " + " " + hours + ":" + minute + ":" + seconde;
    setTimeout("dateTime()", 1000);
}
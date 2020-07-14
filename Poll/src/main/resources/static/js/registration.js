/* 
 * Created on 29/06/2020 at 15:11:19 GMT+2
 */

let rgsbutton = document.getElementById("rgsbutton");
let username = $("#username");
let password = $("#password");
let password2 = $("#password2");
let fn = $("#fn");
let ln = $("#ln");
let usernameConfirmation;
let passwordConfirmation;
let password2Confirmation;
let fnConfirmation;
let lnConfirmation;

window.onload = "registerButton()";

function registerButton() {
    rgsbutton.disabled = true;
    usernameConfirmation = false;
    passwordConfirmation = false;
    password2Confirmation = false;
    fnConfirmation = false;
    lnConfirmation = false;
}

// Registration Button Activation 
document.addEventListener("mousemove", function () {
    if (passwordConfirmation && password2Confirmation && usernameConfirmation
            && fnConfirmation && lnConfirmation) {
        console.log("passwordConfirmation", passwordConfirmation);
        console.log("password2Confirmation", password2Confirmation);
        console.log("usernameConfirmation", usernameConfirmation);
        console.log("fnConfirmation", fnConfirmation);
        console.log("lnConfirmation", lnConfirmation);
        rgsbutton.disabled = false;
    } else {
        rgsbutton.disabled = true;
    }
});

document.addEventListener("keyup", function () {
    if (passwordConfirmation && password2Confirmation && usernameConfirmation
            && fnConfirmation && lnConfirmation) {
        rgsbutton.disabled = false;
    } else {
        rgsbutton.disabled = true;
    }
});

// First and Last Name Legal Characters
$(document).ready(function () {
    $(".inputTextBox").keydown(function (event) {
        var inputValue = event.which;
        // allow letters and whitespaces only.
        if (!(inputValue >= 65 && inputValue <= 122) &&
                (inputValue !== 32 && inputValue !== 0) &&
                (inputValue !== 8 && inputValue !== 9)) {
            event.preventDefault();
        }
    });
});

// Username Validation
$(document).ready(function () {
    username.keyup(function () {
        let usernameValue = username.val();
        if (usernameValue.length < 3) {
            $("#usernameresult").html("too short");
            usernameConfirmation = false;
        } else if (usernameValue.length > 15) {
            $("#usernameresult").html("too big");
            usernameConfirmation = false;
        } else {
            $.ajax({
                url: "checkusername/" + usernameValue,
                success: function (result) {
                    $("#usernameresult").html(result);
                    if (result === "ok") {
                        usernameConfirmation = true;
                    } else {
                        usernameConfirmation = false;
                    }
                }});
        }
    });
});

// Password Validation
$(document).ready(function () {
    password.keyup(() => {
        let passwordValue = password.val();
        if (passwordValue.length < 4) {
            $("#passwordresult").html('weak password');
            passwordConfirmation = false;
        } else if (passwordValue.length > 15) {
            $("#passwordresult").html('password too big');
            passwordConfirmation = false;
        } else if (password2Confirmation && passwordValue !== password2.val()) {
            password2Confirmation = false;
            $("#password2result").html('passwords mismatch');
        } else {
            $("#passwordresult").html("password ok");
            passwordConfirmation = true;
        }
    });
});

// Password2 Validation
$(document).ready(function () {
    password2.keyup(() => {
        let password2Value = $("#password2").val();
        if (password.val().length !== password2Value.length) {
            $("#password2result").html('passwords mismatch');
            password2Confirmation = false;
        } else if (password.val() !== password2Value) {
            $("#password2result").html('passwords mismatch');
            password2Confirmation = false;
        } else {
            $("#password2result").html("password ok");
            password2Confirmation = true;
        }
    });
});

// First Name Validation
$(document).ready(() => {
    fn.keyup(() => {
        let fnValue = fn.val();
        if (fnValue.length < 2) {
            $("#fnresult").html("too short");
            fnConfirmation = false;
        } else {
            $("#fnresult").html("ok");
            fnConfirmation = true;
        }
    });
});

// Last Name Validation
$(document).ready(() => {
    ln.keyup(() => {
        let lnValue = ln.val();
        if (lnValue.length < 2) {
            $("#lnresult").html("too short");
            lnConfirmation = false;
        } else {
            $("#lnresult").html("ok");
            lnConfirmation = true;
        }
    });
});

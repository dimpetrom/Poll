/* 
 * Created on 09/07/2020 at 13:54:58 GMT+2
 */

let votebutton = document.getElementById("votebtn");

window.load = "voteButton()";

function voteButton() {
    votebutton.disabled = true;
}

function getCandidate(source) {
    console.log(source.value);
    if (source.value !== null) {
        votebutton.disabled = false;
    } else {
        votebutton.disabled = true;
    }
}

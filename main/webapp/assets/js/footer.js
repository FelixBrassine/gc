let winnerReveald;
let round = 2;
function nextRound() {
    console.log(round);
    winnerReveald = false;
    footerRound();
    pointCompare();

}
function pointCompare() {
    var xhr = new XMLHttpRequest(),
        method = "GET",
        url = "/gc/winnerReveald";
    xhr.open(method, url, true);
    xhr.onreadystatechange = function () {
        if (xhr.readyState === 4 && xhr.status === 200) {
            console.log(xhr.responseText);
            let win = document.getElementById("win");
            // nextRound.innerText = xhr.responseText;
            win.innerText = " YOU WIN";
        }
    }
    xhr.send();
    console.log(round);
    winnerReveald = true;
    round ++;
}

function footerRound(){
    console.log(round);
    let nbRound = document.getElementById("nbRound");
    nbRound.innerHTML = "Round : " + round;
}
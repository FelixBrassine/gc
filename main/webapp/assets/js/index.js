let gameSelected = false;
let cardsDealt = false;
let nbPlayer = 2;
let counter = 0;
function playKlondike(){
    if (gameSelected){
        return;
    }
}

function playWar(){
    if (gameSelected){
        return;
    }
    start();
    let deck = document.getElementById("deck");
    deck.setAttribute("onclick", "visibleCard()");
    let nextRound = document.querySelector("#nextRound");
    nextRound.style.visibility = "visible";

    gameSelected = true;

}

function visibleCard(){
    counter ++;
        if (counter<=nbPlayer){
            let imgHidden = document.getElementById("imgCardFace" + counter);
            imgHidden.style.visibility = "visible";

        }else {
            return;
        }
}

function getsuitRank(imgCardFace){
    let request = new XMLHttpRequest(),
        method = "GET",
        url = "/gc/cardsDealt";
    request.open(method, url, true);
    request.onreadystatechange = function () {
        if(request.readyState === 4 && request.status === 200) {
            console.log(request.responseText);
            imgCardFace.setAttribute("src","/gc/assets/image/card"+request.responseText+".svg");
        }
    }
    request.send();
}

function distribute(){
    for (let i = 1 ; i<=nbPlayer ; i ++){
        if (cardsDealt){
            return;
        }
        let cardFace = document.createElement("div");
        let imgCardFace = document.createElement("img");
        let game = document.getElementById("game");
        cardFace.setAttribute("class", "cardFace");
        imgCardFace.setAttribute("class", "imgCardFace");
        cardFace.setAttribute("id", "cardFace" + i);
        imgCardFace.setAttribute("id", "imgCardFace" + i);
        getsuitRank(imgCardFace);
        game.appendChild(cardFace);
        cardFace.appendChild(imgCardFace);
    }
    cardsDealt = true;
}

function start(){
    let main = document.getElementById("main");
    let board = document.createElement("div");
    let topBoard = document.createElement("div");
    let deck = document.createElement("div");
    let imgDeck = document.createElement("img");
    let treat = document.createElement("div");
    let imgTreat = document.createElement("img");
    let game = document.createElement("div");

    board.setAttribute("id","board");
    topBoard.setAttribute("id","topBoard");
    deck.setAttribute("id","deck");
    imgDeck.setAttribute("id", "imgDeck");
    imgDeck.setAttribute("src", "/gc/assets/image/cardBack.png");
    treat.setAttribute("id","treat");
    imgTreat.setAttribute("id", "imgTreat");
    game.setAttribute("id","game");

    main.appendChild(board);
    board.appendChild(topBoard);
    topBoard.appendChild(deck);
    deck.appendChild(imgDeck);
    topBoard.appendChild(treat);
    treat.appendChild(imgTreat);
    board.appendChild(game);

    distribute();
}

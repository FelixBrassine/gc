let gameSelected = false;
let cardsDealt = false;

function playWar(){
    start();
    let deck = document.getElementById("deck");
    let request = new XMLHttpRequest();
    request.open("GET", "gc/war" );
    request.send();
    request.responseType = "json";
    let rankSuit = JSON.stringify(request.response);
    console.log(rankSuit);

    deck.setAttribute("onclick", "war()");

    let cardBack = document.getElementsByClassName("cardBack");
    cardBack.setAttribute("onclick", "flipCard()");
    cardBack.setAttribute("src","/gc/assets/image/cards"+suitRank+".png");
}

function flipCard(){
    console.log("ok");
}

function war() {
    if (cardsDealt){
        return;
    }
    cardBack();
    cardBack();
    cardsDealt = true;
}

function playKlondike(){
    start();
}

function start(){
    if (gameSelected) {
        return;
    }
    let board = document.createElement("div");
    let deck = document.createElement("div");
    let imgDeck = document.createElement("img");
    let game = document.createElement("div");

    board.setAttribute("id","board");
    deck.setAttribute("id","deck");
    imgDeck.setAttribute("src","/gc/assets/image/deck2.png");
    imgDeck.setAttribute("id","imgDeck");
    game.setAttribute("id","game");

    main.appendChild(board);
    board.appendChild(deck);
    deck.appendChild(imgDeck);
    board.appendChild(game);
    gameSelected = true;
}

function cardBack(){

    let game = document.getElementById("game");
    let cardBackCont = document.createElement("div");
    let imgBack = document.createElement("img");

    cardBackCont.setAttribute("class","cardBackCont");
    imgBack.setAttribute("src","/gc/assets/image/deck2.png");
    imgBack.setAttribute("class","cardBack");

    game.appendChild(cardBackCont);
    cardBackCont.appendChild(imgBack);

}

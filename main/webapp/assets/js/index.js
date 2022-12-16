let gameSelected = false;
let cardsDealt = false;
let nbPlayer;

function playWar(){
    start();
    nbPlayer = 2;
    let deck = document.getElementById("deck");
    deck.setAttribute("onclick", "getsuitRank()");


}

function getsuitRank(){
    if (cardsDealt) {
        return;
    } else if (nbPlayer>0){
        nbPlayer -= 1;
        var xhr = new XMLHttpRequest(),
            method = "GET",
            url = "/gc/cardsDealt";
        xhr.open(method, url, true);
        xhr.onreadystatechange = function () {
            if(xhr.readyState === 4 && xhr.status === 200) {
                console.log(xhr.responseText);
                let game = document.getElementById("game");
                let cardBackCont = document.createElement("div");
                let cardBack = document.createElement("img");

                game.appendChild(cardBackCont);
                cardBackCont.appendChild(cardBack);
                cardBackCont.setAttribute("class", "cardBackCont");
                cardBack.setAttribute("src","/gc/assets/image/card"+xhr.responseText+".svg");
            }
        };
        xhr.send();
    }else{
        cardsDealt = true;
    }

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
    imgDeck.setAttribute("src","/gc/assets/image/deck.png");
    imgDeck.setAttribute("id","imgDeck");
    game.setAttribute("id","game");

    main.appendChild(board);
    board.appendChild(deck);
    deck.appendChild(imgDeck);
    board.appendChild(game);
    gameSelected = true;
}


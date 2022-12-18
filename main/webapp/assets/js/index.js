let gameSelected = false;
let cardsDealt = false;
let nbPlayer;
let countClick = 0;

function playWar(){
    nbPlayer = 2;
    start(nbPlayer);
    console.log("playwar");
    console.log(nbPlayer);
    getsuitRank();
    let imgDeck = document.getElementById("imgDeck");
    imgDeck.setAttribute("onclick", "getsuitRank()");

}

function getsuitRank(){
    if (nbPlayer>0) {
        countClick ++;
        console.log("get1");
        console.log(nbPlayer);
        var xhr = new XMLHttpRequest(),
            method = "GET",
            url = "/gc/cardsDealt";
        xhr.open(method, url, true);
        xhr.onreadystatechange = function () {
            if(xhr.readyState === 4 && xhr.status === 200) {
                console.log(xhr.responseText);
                let imgCardFace = document.getElementById("imgCardFace" +countClick);
                imgCardFace.setAttribute("src","/gc/assets/image/card"+xhr.responseText+".svg");
            }
        };
        xhr.send();
        nbPlayer -= 1;
        console.log("get2");
        console.log(nbPlayer);
    }else{
        cardsDealt = true;
    }

}

function start(nbPlayer){
    if (gameSelected) {
        return;
    }
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
    for (let i = 1 ; i<=nbPlayer ; i ++){
        let cardFace = document.createElement("div");
        let imgCardFace = document.createElement("img");
        cardFace.setAttribute("class", "cardFace");
        imgCardFace.setAttribute("class", "imgCardFace");
        cardFace.setAttribute("id", "cardFace" + i);
        imgCardFace.setAttribute("id", "imgCardFace" + i);
        game.appendChild(cardFace);
        cardFace.appendChild(imgCardFace);
        console.log("start");
        console.log(nbPlayer);
    }
    gameSelected = true;
}

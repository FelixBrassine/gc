let gameSelected = false;
let cardsDealt = false;
let nbPlayer;

function playWar(){
    start();
    nbPlayer = 2;
    let imgDeck = document.getElementById("imgDeck");
    imgDeck.setAttribute("onclick", "getsuitRank()");

}

function getsuitRank(){
    if (nbPlayer>0) {
        nbPlayer -= 1;
        var xhr = new XMLHttpRequest(),
            method = "GET",
            url = "/gc/cardsDealt";
        xhr.open(method, url, true);
        xhr.onreadystatechange = function () {
            if(xhr.readyState === 4 && xhr.status === 200) {
                console.log(xhr.responseText);
                let game = document.getElementById("game");
                let cardFace = document.createElement("div");
                let imgCardFace = document.createElement("img");

                cardFace.setAttribute("class", "cardFace")
                game.appendChild(cardFace);
                cardFace.appendChild(imgCardFace);
                imgCardFace.setAttribute("class", "imgCardFace");
                imgCardFace.setAttribute("src","/gc/assets/image/card"+xhr.responseText+".svg");
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
                imgDeck.setAttribute("src", "/gc/assets/image/cardBack.png")
                treat.setAttribute("id","treat");
                imgTreat.setAttribute("id", "imgTreat");
                imgTreat.setAttribute("src", "/gc/assets/image/cardBack.png")
            game.setAttribute("id","game");

    main.appendChild(board);
        board.appendChild(topBoard);
            topBoard.appendChild(deck);
                deck.appendChild(imgDeck);
            topBoard.appendChild(treat);
                treat.appendChild(imgTreat);
        board.appendChild(game);
    gameSelected = true;
}


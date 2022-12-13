let refresh = true;

function playWar(){
    start();
}

function playKlondike(){
    start();
}

function start (){
    if (!refresh) {
        return;
    }

    let board = document.createElement("div");
    let deck = document.createElement("div");
    let game = document.createElement("div");

    board.setAttribute("id","board");
    deck.setAttribute("id","deck");
    game.setAttribute("id","game");

    main.appendChild(board);
    board.appendChild(deck);
    board.appendChild(game);

    refresh = false;
}

package be.technobel.fbrassine.gc.servlets;

import be.technobel.fbrassine.gc.service.View;
import be.technobel.fbrassine.gc.model.Deck;
import be.technobel.fbrassine.gc.model.Player;
import be.technobel.fbrassine.gc.model.PlayingCard;

import java.util.ArrayList;
import java.util.List;

public class GameController {
    enum GameState{
        AddingPlayers, CardsDealt, WinnerRevealed;
    }
    Deck deck;
    List<Player> players;
    Player winner;
    View view;
    GameState gameState;

    public GameController(Deck deck, View view) {
        this.deck = deck;
        this.view = view;
        players = new ArrayList<Player>();
        this.gameState = GameState.AddingPlayers;
        view.setController(this);
    }
    public void run(){
        if (gameState ==  GameState.AddingPlayers){
            view.newPlayer();
        } else if (gameState == GameState.CardsDealt) {
            view.cardFlip();
        } else {
            view.newGame();
        }
    }
    public void addPlayer( Player p){
        if (gameState == GameState.AddingPlayers){
            players.add(p);
            view.showPlayerName(players.size(), p);
        }
    }
    public void startGame(){
        if (gameState != GameState.CardsDealt){
            deck.shuffle();
            for (Player player : players){
                int playerIndex = 1;
                player.addCardToHand(deck.removeTopCard());
                view.showCardBack(playerIndex++, player.getName());
            }
            gameState = GameState.CardsDealt;
        }
        this.run();
    }
    public void flipCards(){
        for (Player player : players){
            int playerIndex = 1;
            PlayingCard pc = player.getCardToHand(0);
            pc.flip();
            view.showCardFace(playerIndex++, player.getName(), pc.getRank().toString(), pc.getSuit().toString());
        }
        evaluateWinner();
        displayWinner();
        rebuildDeck();
        gameState = GameState.WinnerRevealed;
        this.run();
    }
    public void evaluateWinner(){
        Player bestPlayer = null;
        int bestRank = -1;
        int bestSuit = -1;

        for (Player player : players){
            boolean newBestPlayer = false;
            if (bestPlayer == null){
                newBestPlayer = true;
            } else {
                PlayingCard pc = player.getCardToHand(0);
                int thisRank = pc.getRank().value();
                if (thisRank >= bestRank){
                    if (thisRank>bestRank){
                        newBestPlayer =true;
                    }else{
                        if (pc.getSuit().value() > bestSuit){
                            newBestPlayer = true;
                        }
                    }
                }
            }
            if (newBestPlayer) {
                bestPlayer = player;
                PlayingCard pc = player.getCardToHand(0);
                bestRank= pc.getRank().value();
                bestSuit = pc.getSuit().value();
            }

        }
    }
    public void displayWinner(){
        view.showWinner(winner.getName());
    }
    public void rebuildDeck(){
        for (Player player : players){
            deck.returnCardToDeck(player.removeCardToHand());
            player.removeCardToHand();
        }
    }
}

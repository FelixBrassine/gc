package be.technobel.fbrassine.gc.service;

import be.technobel.fbrassine.gc.model.Deck;
import be.technobel.fbrassine.gc.model.Player;
import be.technobel.fbrassine.gc.model.PlayingCard;

import java.util.ArrayList;
import java.util.List;

public class GameController {
    private Deck deck;
    private List<Player> players;
    private Player winner;
    private GameState gameState;
    private List<PlayingCard> flipCards = new ArrayList<>();

    public GameController(Deck deck) {
        this.deck = deck;
        players = new ArrayList<Player>();
        this.gameState = GameState.ADDINGPLAYERS;
    }
    public void addPlayer( Player p){
            players.add(p);
    }
    public void startGame(){
        if (gameState != GameState.CARDSDEALT){
            deck.shuffle();
            for (Player player : players){
                player.addCardToHand(deck.removeTopCard());
            }
            gameState = GameState.CARDSDEALT;
        }
    }
    public List<PlayingCard> flipCards(){
        for (Player player : players){
            int playerIndex = 1;
            PlayingCard pc = player.getCardToHand(0);
            pc.flip();
            flipCards.add(pc);
            return flipCards;
        }
        evaluateWinner();
        rebuildDeck();
        gameState = GameState.WINNERREVEALD;
        return flipCards;
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
    public void rebuildDeck(){
        for (Player player : players){
            deck.returnCardToDeck(player.removeCardToHand());
            player.removeCardToHand();
        }
    }

    public List<PlayingCard> getFlipCards() {
        return new ArrayList<>(flipCards);
    }
}

package be.technobel.fbrassine.gc.model;

public class Player {
    private String name;
    private Hand hand;

    public Player(String name) {
        this.name = name;
        hand = new Hand();
    }
    public void addCardToHand(PlayingCard pc){
        hand.addCard(pc);
    }
    public PlayingCard getCardToHand(int index){
        return hand.getCard(index);
    }
    public PlayingCard removeCardToHand(){
        return hand.removeCard();
    }
    public String getName() {
        return name;
    }
}

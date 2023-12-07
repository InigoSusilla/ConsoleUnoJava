package players;

import cards.Card;
import piles.DiscardPile;
import piles.DrawPile;

import java.util.ArrayList;

public abstract class Player {
    private String name;
    private ArrayList<Card> hand;

    public Player(String name){
        this.name = name;
        this.hand = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }
    public ArrayList<Card> getHand() {
        return this.hand;
    }
    public void drawCardFrom(DrawPile pile){
        Card taken = pile.draw();
        this.hand.add(taken);
        System.out.println("Drawing....");
    }
    public boolean hasPlayableHand(Card topCard){
        boolean ret = false;
        for(Card c : this.hand){
            if(c.mathes(topCard)){
                ret = true;
                break;
            }
        }
        return ret;
    }
    public void receiveCard(Card c){
        this.hand.add(c);
    }

    public String playerHandsToString(){
        String ret = "";
        for(Card c : this.hand){
            ret = ret + c.toString()+", ";
        }
        return ret;
    }

    public void displayHand(){
        for(Card card : this.hand){
            System.out.println(card.toString());
        }
    }
    public void removeCardFomHand(Card c){
        this.hand.remove(c);
    }

    public abstract Card playCard(DiscardPile pile);

}

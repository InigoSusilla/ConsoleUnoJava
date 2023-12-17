package Uno.players;

import Uno.cards.Card;
import Uno.cards.Color;
import Uno.piles.DiscardPile;
import Uno.piles.DrawPile;

import java.util.ArrayList;
import Uno.Descriptable;

public abstract class Player implements Descriptable{
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
    }
    public boolean hasPlayableHand(Card topCard){
        boolean ret = false;
        for(Card c : this.hand){
            if(c.matches(topCard)){
                ret = true;
                break;
            }
        }
        return ret;
    }

    public abstract Color announceColor();
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

package Uno.piles;

import Uno.Descriptable;
import Uno.cards.Card;

import java.util.ArrayList;
import java.util.Collections;

public class DiscardPile implements Descriptable {
    private ArrayList<Card> discardedCards;

    public DiscardPile(Card card) {
        if (this.discardedCards == null) {
            discardedCards = new ArrayList<>();
            discardedCards.add(card);
        } else {
            discardedCards.add(card);
        }
    }

    public Card getTopCard(){
        return this.discardedCards.getFirst();
    }

    public boolean addCard(Card card) {
        if (card.matches(this.discardedCards.getFirst())) {
            this.discardedCards.addFirst(card);
            return true;
        }else{
            return false;
        }
    }

    public ArrayList<Card> suffleAndTurnAround() {
        Card topCard = discardedCards.getFirst();
        discardedCards.removeFirst();
        Collections.shuffle(discardedCards);
        ArrayList<Card> toReturn = discardedCards;
        discardedCards = null;
        return toReturn;

    }

    public Card retrieve(boolean topBottom) {
        if (topBottom) {
            Card a = discardedCards.getFirst();
            discardedCards.removeFirst();
            return a;
        } else {
            Card a = discardedCards.getLast();
            discardedCards.removeLast();
            return a;
        }
    }

    @Override
    public String getDescription() {
        return "In this class we have the functionality to make the discard pile work emptying when its necesary";
    }
}

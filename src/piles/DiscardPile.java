package piles;

import cards.Card;

import java.util.ArrayList;
import java.util.Collections;

public class DiscardPile {
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
        return this.discardedCards.get(0);
    }

    public boolean addCard(Card card) {
        if (card.mathes(this.discardedCards.get(0))) {
            this.discardedCards.add(0, card);
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
}

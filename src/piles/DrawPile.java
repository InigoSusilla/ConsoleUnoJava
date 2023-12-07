package piles;

import cards.Card;
import cards.Color;
import cards.NumberCard;

import java.util.ArrayList;
import java.util.Collections;

public class DrawPile {
    private final ArrayList<Card> cards;

    public DrawPile() {
        this.cards = new ArrayList<>();
        for (Color color : Color.values()) {
            if (color == Color.WILD) {
            } else {
                for (int i = 1; i <= 9; i++) {
                    NumberCard nc = new NumberCard(color, i);
                    cards.add(nc);
                }
            }
        } for (Color color : Color.values()) {
            if (color == Color.WILD) {
            } else {
                for (int i = 1; i <= 9; i++) {
                    NumberCard nc = new NumberCard(color, i);
                    cards.add(nc);
                }
            }
            //All the number cards are now TODO the special cards
            Collections.shuffle(cards);
        }


    }

    public DrawPile(ArrayList<Card> cards){
        this.cards = cards;
    }

    public Card draw() {
        if (this.cards.isEmpty()) {
            throw new EmptyDrawPileException("The draw pile is empty");
        } else {
            Card ret = cards.getFirst();
            cards.removeFirst();
            return ret;
        }
    }

    public boolean isEmpty() {
        return cards.isEmpty();
    }

    public int getSize() {
        return cards.size();
    }

}

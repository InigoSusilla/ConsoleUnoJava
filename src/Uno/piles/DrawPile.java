package Uno.piles;

import Uno.Descriptable;
import Uno.cards.Card;
import Uno.cards.Color;
import Uno.cards.NumberCard;

import java.util.ArrayList;
import java.util.Collections;

public class DrawPile implements Descriptable {
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
            //All the number Uno.cards are now TODO the special Uno.cards
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

    @Override
    public String getDescription() {
        return "In this class is the functionality to make the draw pile work and fill it when its empty";
    }
}

package Uno.piles;

import Uno.Descriptable;
import Uno.cards.Card;
import Uno.cards.Color;
import Uno.cards.NumberCard;
import Uno.cards.actioncards.*;

import java.util.ArrayList;
import java.util.Collections;

public class DrawPile implements Descriptable {
    private final ArrayList<Card> cards;

    public DrawPile() {
        this.cards = new ArrayList<>();
        for (int j = 0; j < 2; j++) {
        for (Color color : Color.values()) {
            if (color == Color.WILD) {
                Card cd = new WildCard();
                cards.add(cd);
            } else {
                for (int l = 0; l < 2; l++) {
                    Draw2 dr = new Draw2(color);
                    cards.add(dr);
                    ReverseCard rc = new ReverseCard(color);
                    cards.add(rc);
                    SkipCard sc = new SkipCard(color);
                    cards.add(sc);
                }
                for (int i = 1; i <= 9; i++) {
                    NumberCard nc = new NumberCard(color, i);
                    cards.add(nc);
                }
            }
        }
        }

        for (int i = 0; i < 4; i++) {
            WildDraw4Card wdc = new WildDraw4Card();
            cards.add(wdc);

        }
        Collections.shuffle(cards);
        do {
            Collections.shuffle(cards);
        }while(cards.getFirst().getColor().equals("WILD"));


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

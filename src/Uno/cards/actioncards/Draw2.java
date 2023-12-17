package Uno.cards.actioncards;

import Uno.UnoGame;
import Uno.cards.Card;
import Uno.cards.Color;

public class Draw2 extends ActionCard {
    public Draw2(Color color) {
        super(color);
    }

    @Override
    public String getDescription() {
        return "This card makes you draw 2 more";
    }

    @Override
    public boolean matches(Card card) {
        if (card instanceof Draw2) {
            return this.getColor().equals(card.getColor()) || card instanceof Draw2;
        } else {
            if(this.getColor().equals(card.getColor())){
                return true;
            }else {
                return false;
            }
        }
    }

    @Override
    public void action(UnoGame game) {
        game.getSubsequentPlayer().drawCardFrom(game.getDrawPile());
        game.getSubsequentPlayer().drawCardFrom(game.getDrawPile());
    }

    @Override
    public String toString() {
        return "DRAW2_"+this.getColor();
    }
}

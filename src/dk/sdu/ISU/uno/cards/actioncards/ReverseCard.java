package dk.sdu.ISU.uno.cards.actioncards;

import dk.sdu.ISU.uno.UnoGame;
import dk.sdu.ISU.uno.cards.Card;
import dk.sdu.ISU.uno.cards.Color;

public class ReverseCard extends ActionCard {
    public ReverseCard(Color color) {
        super(color);
    }

    @Override
    public String getDescription() {
        return "This card changes the order od the players";
    }

    @Override
    public boolean matches(Card card) {
        if (card instanceof ReverseCard) {
            return this.getColor().equals(card.getColor()) || card instanceof ReverseCard;
        }else{
            if ((this.getColor().equals(card.getColor()))){
                return true;
            }else {
                return false;
            }
        }

    }

    @Override
    public void action(UnoGame game) {
        game.reversePlayerOrder();
        game.passTurn();
    }

    @Override
    public String toString() {
        return "Reversecard_" + this.getColor();
    }
}

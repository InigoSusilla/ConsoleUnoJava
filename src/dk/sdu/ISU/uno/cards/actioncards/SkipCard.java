package dk.sdu.ISU.uno.cards.actioncards;

import dk.sdu.ISU.uno.UnoGame;
import dk.sdu.ISU.uno.cards.Card;
import dk.sdu.ISU.uno.cards.Color;

public class SkipCard extends ActionCard{
    public SkipCard(Color color) {
        super(color);
    }

    @Override
    public String getDescription() {
        return "This card skips the next players turn";
    }

    @Override
    public boolean matches(Card card) {
        if(card instanceof SkipCard){
            if(this.getColor().equals(card.toString()) || card instanceof  SkipCard){
                return true;
            }else{
                return false;
            }
        }if(this.getColor().equals(card.getColor())){
            return true;
        }else{
            return false;
        }

    }

    @Override
    public void action(UnoGame game) {
        game.skipTurn();
    }

    @Override
    public String toString() {
        return "SKIP_" + this.getColor();
    }
}

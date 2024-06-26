package dk.sdu.ISU.uno.cards.actioncards;

import dk.sdu.ISU.uno.UnoGame;
import dk.sdu.ISU.uno.cards.Card;
import dk.sdu.ISU.uno.cards.Color;
import dk.sdu.ISU.uno.players.Player;

public class WildCard extends ActionCard{


    public WildCard() {
        super(Color.WILD);
    }

    @Override
    public boolean matches(Card card) {
        return true;
    }

    @Override
    public String getDescription() {
        return "This class constructs an object of the type Wild";
    }

    @Override
    public void action(UnoGame game) {
        Player pl = game.getCurrentPlayer();
       Color selected =  pl.announceColor();
       System.out.println("The color chosen is " + selected.toString());
       this.setColor(String.valueOf(selected));
    }
    @Override
    public String toString() {
        return "WILD";
    }
}

package dk.sdu.ISU.uno.cards.actioncards;

import dk.sdu.ISU.uno.UnoGame;
import dk.sdu.ISU.uno.cards.Color;
import dk.sdu.ISU.uno.players.Player;

public class WildDraw4Card extends WildCard{

    public WildDraw4Card(){
        super();
    }

    @Override
    public void action(UnoGame game) {
        Player pl = game.getCurrentPlayer();
        Color selected =  pl.announceColor();
        System.out.println("The color chosen is " + selected.toString());
        this.setColor(String.valueOf(selected));
        for (int i = 0; i < 5; i++) {
            game.getSubsequentPlayer().drawCardFrom(game.getDrawPile());
        }

    }

    @Override
    public String toString() {
        return "WILD+4";
    }
}

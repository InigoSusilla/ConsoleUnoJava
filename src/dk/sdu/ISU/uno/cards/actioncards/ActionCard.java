package dk.sdu.ISU.uno.cards.actioncards;

import dk.sdu.ISU.uno.UnoGame;
import dk.sdu.ISU.uno.cards.Card;
import dk.sdu.ISU.uno.cards.Color;

public abstract class ActionCard extends Card {
    public ActionCard(Color color) {
        super(color);
    }

    public abstract void action(UnoGame game);
}

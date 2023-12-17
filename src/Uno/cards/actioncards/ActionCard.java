package Uno.cards.actioncards;

import Uno.UnoGame;
import Uno.cards.Card;
import Uno.cards.Color;

public abstract class ActionCard extends Card {
    public ActionCard(Color color) {
        super(color);
    }

    public abstract void action(UnoGame game);
}

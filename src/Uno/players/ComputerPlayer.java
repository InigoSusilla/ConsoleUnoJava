package Uno.players;

import Uno.cards.Card;
import Uno.piles.DiscardPile;

public class ComputerPlayer extends Player{

    public ComputerPlayer(String name) {
        super(name);
    }

    @Override
    public Card playCard(DiscardPile pile) {
        Card playable = null;

        for(Card c : this.getHand()){
            if(c.mathes(pile.getTopCard())){
                playable = c;
                break;
            }
        }
        if(playable==null){
            throw new NoPlayableCardException("No playable Uno.cards avatible");
        }else{
            pile.addCard(playable);
            this.removeCardFomHand(playable);
            return playable;
        }
    }

    @Override
    public String getDescription() {
        return "In this class we have the functionality to make the computer generated bots play y themself";
    }
}

package players;

import cards.Card;
import piles.DiscardPile;

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
            throw new NoPlayableCardException("No playable cards avatible");
        }else{
            pile.addCard(playable);
            this.removeCardFomHand(playable);
            return playable;
        }
    }
}

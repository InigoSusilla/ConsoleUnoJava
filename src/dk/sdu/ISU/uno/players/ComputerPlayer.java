package dk.sdu.ISU.uno.players;

import dk.sdu.ISU.uno.cards.Card;
import dk.sdu.ISU.uno.cards.Color;
import dk.sdu.ISU.uno.piles.DiscardPile;

import java.util.Random;

public class ComputerPlayer extends Player{

    public ComputerPlayer(String name) {
        super(name);
    }

    @Override
    public Color announceColor() {
        Color[] colors = Color.values();
        Random rdm = new Random();
        return colors[rdm.nextInt(colors.length)];
    }

    @Override
    public Card playCard(DiscardPile pile) {
        Card playable = null;

        for(Card c : this.getHand()){
            if(c.matches(pile.getTopCard())){
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

package Uno.players;

import Uno.cards.Card;
import Uno.piles.DiscardPile;

import java.util.ArrayList;
import java.util.Scanner;

public class HumanPlayer extends Player {


    public HumanPlayer(String name) {
        super(name);
    }


    @Override
    public Card playCard(DiscardPile pile) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Card> playableCards = new ArrayList<>();
        for (Card c : this.getHand()) {
            if (c.mathes(pile.getTopCard())) {
                playableCards.add(c);
            }
        }
        boolean isSelected = false;
        Card ret = null;
        do {
            System.out.println("Select one from your hand");
            for (int i = 0; i < playableCards.size(); i++) {
                System.out.println(i + ") " + playableCards.get(i).toString());
            }
            String input = scanner.nextLine();
            if(input.equals("")){
                input = "1231313";
            }
            if (Integer.parseInt(input) >= 0 && Integer.parseInt(input) < playableCards.size()) {

                ret = playableCards.get(Integer.parseInt(input));
                pile.addCard(ret);
                this.removeCardFomHand(ret);
                isSelected = true;
            }
        } while (!isSelected);

        return ret;
    }

    @Override
    public String getDescription() {
        return "In this class we have the functionality to make the human player interact with the game and choose the card to play";
    }
}

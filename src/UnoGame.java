import cards.Card;
import piles.DiscardPile;
import piles.DrawPile;
import players.HumanPlayer;
import players.Player;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class UnoGame {
    private ArrayList<Player> players;
    private DrawPile drawPile;
    private DiscardPile discardPile;
    private Player currentPlayer;
    private Player winner;

    public UnoGame(){
        this.players = new ArrayList<>();
        this.drawPile = new DrawPile();
        this.discardPile = new DiscardPile(this.drawPile.draw());

    }

    public ArrayList<Player> getPlayers() {
        return this.players;
    }

    public DrawPile getDrawPile() {
        return this.drawPile;
    }

    public Player getCurrentPlayer() {
        return this.currentPlayer;
    }

    public Player getSubsequentPlayer(){
        int index = this.players.indexOf(this.currentPlayer);
        if(index == this.players.size()-1){
            return this.players.getFirst();
        }else{
            return this.players.get(index +1);
        }
    }

    public void reversePlayerOrder(){
        Collections.reverse(this.players);
    }

    public void addPlayer(Player p){
        if(!(this.players.size()<11)){
            System.out.println("Too much players");
            throw new RuntimeException();
        }else{
            if(this.players.contains(p)){
                System.out.println("Already playing");
                throw new RuntimeException();
            }else{

                this.players.add(p);
                System.out.println("Adding player " + p.getName());
            }
        }
    }

    public void passTurn(){
    this.currentPlayer = this.getSubsequentPlayer();
    }

    public void suffleDiscardPile(){
        if(this.drawPile.isEmpty()){
            this.drawPile = new DrawPile(this.discardPile.suffleAndTurnAround());
        }
    }



    public void play(){
        Scanner scanner = new Scanner(System.in);
        String text;
        if(!(this.players.size() >= 2 && this.players.size() <= 11)){
            System.out.println("Incorrect number of players "+ this.players.size());
            throw new RuntimeException();
        }
        for(Player p : this.players){
            for (int i = 0; i < 8; i++) {
                p.drawCardFrom(drawPile);
            }
        }

        Collections.shuffle(this.players);
        this.currentPlayer = this.players.getFirst();

        boolean gameNotFinnished    = false;
        do {
            System.out.println("-------------------------------------------------------");
            System.out.println("| Player: "+ this.currentPlayer.getName()+" | Current top card " + this.discardPile.getTopCard() + " |");
            System.out.println("|-----------------------------------------------------|");
            System.out.println("| Player current hand and number:"+ this.currentPlayer.getHand().size() +"   |");
            System.out.println("| " + this.currentPlayer.playerHandsToString() +" |");
            System.out.println("-------------------------------------------------------");

            if(!this.currentPlayer.hasPlayableHand(this.discardPile.getTopCard())){
                //this.currentPlayer.playCard(discardPile);
                if(this.drawPile.isEmpty()){
                    System.out.println("Suffling the cards");
                    suffleDiscardPile();
                    this.currentPlayer.drawCardFrom(drawPile);

                }else{
                    this.currentPlayer.drawCardFrom(drawPile);
                }
            }
          //  this.currentPlayer.displayHand();
            if(!this.currentPlayer.hasPlayableHand(this.discardPile.getTopCard())){
                System.out.println("Enter to continue...");
                text = scanner.nextLine();
                passTurn();
            }else{
               Card playeyCard = this.currentPlayer.playCard(discardPile);
               System.out.println("Playing:                           "+playeyCard);
               if(this.currentPlayer.getHand().isEmpty()){
                   gameNotFinnished = true;
                   this.winner=this.currentPlayer;
               }else{
                   passTurn();
                   System.out.println("Enter to continue...");
                   text = scanner.nextLine();
               }

            }
        }while (!gameNotFinnished);

        System.out.println("the winner is: " +this.winner.getName());
    }
}
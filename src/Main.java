import players.ComputerPlayer;
import players.HumanPlayer;
import players.Player;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        UnoGame game = new UnoGame();
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many players are we playing (2-9)");
        String text = scanner.nextLine();
        int number = Integer.parseInt(text);
        ArrayList<Player> players = new ArrayList<>();
        if (number >= 2 && number <= 9) {
            for (int i = 0; i < number; i++) {
                System.out.println("Name of the bot");
                text = scanner.nextLine();
                ComputerPlayer cp = new ComputerPlayer(text);
                players.add(cp);
            }
            System.out.println("Your name: ");
            text = scanner.nextLine();
            HumanPlayer hp = new HumanPlayer(text);
            players.add(hp);


        }
        for(Player p : players){
            game.addPlayer(p);
        }
        game.play();


    }
}

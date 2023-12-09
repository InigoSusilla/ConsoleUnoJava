package Uno.players;

public class NoPlayableCardException extends RuntimeException{
    public NoPlayableCardException(String message){
        super(message);
    }
}

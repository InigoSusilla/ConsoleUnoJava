package dk.sdu.ISU.uno.players;

public class NoPlayableCardException extends RuntimeException{
    public NoPlayableCardException(String message){
        super(message);
    }
}

package dk.sdu.ISU.uno.piles;

public class EmptyDrawPileException extends RuntimeException{
    public EmptyDrawPileException(String message){
        super(message);
    }
}

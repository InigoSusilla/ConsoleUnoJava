package Uno.piles;

public class EmptyDrawPileException extends RuntimeException{
    public EmptyDrawPileException(String message){
        super(message);
    }
}
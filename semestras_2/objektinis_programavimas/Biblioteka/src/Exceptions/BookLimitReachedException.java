package Exceptions;

public class BookLimitReachedException extends LibraryException{
    public BookLimitReachedException(){
        super("Paimtas maksimalus kiekis knygų");
    }
}

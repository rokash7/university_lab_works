package Exceptions;

public class BookAlreadyTakenException extends LibraryException{
    public BookAlreadyTakenException(){
        super("Knyga, kurią norite paimti, jau paimta");
    }
}

package Exceptions;

public class LibraryException extends Exception{
    LibraryException(String message){
        super("Bibliotekos klaida: " + message);
    }
}

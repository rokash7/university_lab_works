package Exceptions;
import Leidinys.Knyga;

public class BookNotTakenException extends LibraryException {
    private Knyga grazinamaKnyga;

    public BookNotTakenException(Knyga grazinamaKnyga){
        super("Knyga, kurią norima grąžinti, nėra paimta");
        this.grazinamaKnyga = grazinamaKnyga;
    }

    public Knyga getGrazinamaKnga(){
        return grazinamaKnyga;
    }
}

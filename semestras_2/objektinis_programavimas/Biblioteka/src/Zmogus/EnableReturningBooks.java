package Zmogus;

import Leidinys.Knyga;
import Exceptions.BookNotTakenException;

public interface EnableReturningBooks {

    void grazintiKnyga(Knyga knyga) throws BookNotTakenException;
}

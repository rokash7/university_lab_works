package Zmogus;

import Leidinys.Knyga;
import Exceptions.BookAlreadyTakenException;
import Exceptions.BookLimitReachedException;

public interface EnableTakingBooks extends EnableReturningBooks {

    void skaitytiKnyga(Knyga knyga) throws BookLimitReachedException, BookAlreadyTakenException;
}

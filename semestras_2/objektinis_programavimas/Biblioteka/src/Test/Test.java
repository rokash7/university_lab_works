package Test;

import Zmogus.*;
import Leidinys.*;

import java.util.Date;
import java.util.LinkedList;

public class Test{
    private final int n;
    LinkedList<Skaitytojas> skaitytojai = new LinkedList<Skaitytojas>();
    LinkedList<Darbuotojas> darbuotojai = new LinkedList<Darbuotojas>();
    LinkedList<Knyga> knygos = new LinkedList<Knyga>();
    LinkedList<DVD> dvd = new LinkedList<DVD>();

    public Test(int n, LinkedList skaitytojai, LinkedList darbuotojai, LinkedList knygos, LinkedList dvd){
        this.n = n;

        this.skaitytojai = skaitytojai;
        this.darbuotojai = darbuotojai;
        this.knygos = knygos;
        this.dvd = dvd;
    }

    public void beginTest(){
        createKnygos();
        createDarbuotojai();
        createDVD();
        createSkatytojai();
    }

    public void createKnygos() {
        for (int i = 0; i < n; i++) {
            knygos.add(new Knyga("author" + i, "name" + i, "genre" + i, i));
        }
    }

    public void createDVD() {
        for (int i = 0; i < n; i++) {
            dvd.add(new DVD("author" + i, "name" + i, "genre" + i));
        }
    }

    public void createDarbuotojai() {
        darbuotojai.add(new Darbuotojas("darbuotojas1", 861234567, new Date(100, 1, 1)));
    }

    public void createSkatytojai() {
        Skaitytojas biblioteka = new Skaitytojas("BIBLIOTEKA", 851234567, "Bibliotekos adresas", new Date(100, 1, 1));
        skaitytojai.add(biblioteka);

        for(int i = 1; i < n; i++){
            skaitytojai.add(new Skaitytojas("skaitytojas" + i, i, "Skaitytojo gatve " + i, new Date(100, i, i)));
        }
    }

    public void printTest() {
        for (int i=0; i < n; i++){
            //System.out.println(knygos.get(i).toString() + "\n");
        }
    }

    public LinkedList getSkaitytojai(){
        return skaitytojai;
    }

    public LinkedList getDarbuotojai(){
        return darbuotojai;
    }

    public LinkedList getDVD(){
        return dvd;
    }

    public LinkedList getKnygos(){
        return knygos;
    }
}

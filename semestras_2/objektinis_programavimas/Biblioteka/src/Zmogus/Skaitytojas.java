package Zmogus;

import java.util.Date;
import java.util.LinkedList;

import Leidinys.Knyga;
import Exceptions.*;

public class Skaitytojas extends Zmogus{
    //fields
    private String adresas;
    private final int ID;
    private static int skaitytojuSkaicius = 0;
    private final LinkedList<Knyga> skaitomosKnygos = new LinkedList<Knyga>();

    //get/set methods
    public String getAdresas(){return this.adresas;}
    public void setAdresas(String adresas){this.adresas = adresas;}
    public void setBauda(int bauda){this.bauda = bauda;}
    public int getBauda(){return this.bauda;}
    public int getID(){return this.ID;}

    public Skaitytojas(String name, int telNr, String adresas, Date gimimoData){
        super(name, telNr, gimimoData);
        this.ID = skaitytojuSkaicius++;
        this.adresas = adresas;
    }

    public void sumoketi(int suma){
        this.bauda -= suma;
    }

    public void skaitytiKnyga(Knyga knyga)throws BookLimitReachedException, BookAlreadyTakenException{
        if(knyga.getKnygaPaimta()) throw new BookAlreadyTakenException();

        if(skaitomosKnygos.size()<3){
            skaitomosKnygos.add(knyga);
            knyga.paimtiKnyga();
        } else throw new BookLimitReachedException();
    }

    public void grazintiKnyga(Knyga knyga)throws BookNotTakenException{
        for (int i = 0; i < skaitomosKnygos.size(); i++){

            if(skaitomosKnygos.get(i).equals(knyga)){
                knyga.grazintiKnyga();
                return;
            }
        }

        throw new BookNotTakenException(knyga);
    }

    public void println(){
        super.println();
        System.out.println(
                "ID " + ID +
                "\nAdresas: " + adresas +
                "\nSkaitytojas bibliotekai skolingas: " + bauda+
                "\n_____________________________________"
        );
    }

}

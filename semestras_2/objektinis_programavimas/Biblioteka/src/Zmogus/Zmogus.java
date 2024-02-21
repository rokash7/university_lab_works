package Zmogus;

import java.io.Serializable;
import java.util.Date;

public abstract class Zmogus implements EnableTakingBooks, Serializable {
    protected String name;
    protected int telNr;
    protected int bauda;
    protected boolean buvimasBibliotekoje = false;
    protected Date gimimoData;

    Zmogus (String name, int telNr, Date gimimoData){
        this.name = name;
        this.telNr = telNr;
        this.gimimoData = gimimoData;
    }

    public void setTelNr(int telNr){
        this.telNr = telNr;
    }

    public void priregistruotiIejima(){this.buvimasBibliotekoje = true;}

    public void isregistruotiIejima(){this.buvimasBibliotekoje = false;}

    void println(){
        System.out.println(
                "Vardas Pavarde : " + name +
                "\nTel Nr.: " + telNr +
                "\nGimimo data: " + gimimoData.toString()
        );
    }
}

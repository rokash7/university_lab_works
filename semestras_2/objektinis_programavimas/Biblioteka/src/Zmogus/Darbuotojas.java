package Zmogus;

import Leidinys.Knyga;

import java.util.Date;
import java.util.LinkedList;

public class Darbuotojas extends Zmogus{

    private int valandinisUzmokestisEur = 10;
    private int valandinisUzmokestisCt = 0;
    private String pareigos;
    private int neismoketasAtlyginimasCt;
    private String bankoSaskaitosNr;
    private Date darboPradzia = new Date();
    private final LinkedList<Knyga> skaitomosKnygos = new LinkedList<Knyga>();

    void setPareigos(String pareigos){
        this.pareigos = pareigos;
    }
    void setValandinisUzmokestis(int valandinisUzmokestisEur, int valandinisUzmokestisCt){
        this.valandinisUzmokestisEur = valandinisUzmokestisEur;
        this.valandinisUzmokestisCt = valandinisUzmokestisCt;
    }
    float getNeismoketasAtlyginimas(){return neismoketasAtlyginimasCt;}

    public Darbuotojas(String name, int telNr, Date gimimoData) {
        super(name, telNr, gimimoData);
    }

    public void dirbti(int isdirbtosValandos){
        neismoketasAtlyginimasCt = isdirbtosValandos * (valandinisUzmokestisEur * 100 + valandinisUzmokestisCt) ;
    }

    public void sumoketi(int suma){
        neismoketasAtlyginimasCt -= suma;
    }

    public void priregistruotiIejima(){
        this.buvimasBibliotekoje = true;
        this.darboPradzia = new Date();
    }

    @Override
    public String toString() {
        return super.name +
                ", valandinis uzmokestis = " + valandinisUzmokestisEur + "." + valandinisUzmokestisCt +
                ", pareigos = " + pareigos +
                ", skolaDarbuotojui = " + neismoketasAtlyginimasCt/100 + "." + neismoketasAtlyginimasCt%100 +
                ", bankoSaskaitosNr = " + bankoSaskaitosNr;
    }

    @Override
    public void grazintiKnyga(Knyga knyga){
        for (int i = 0; i < skaitomosKnygos.size(); i++){

            if(skaitomosKnygos.get(i).equals(knyga)){
                knyga.grazintiKnyga();
                return;
            }
        }

        //exception library -> missing book library
    }

    @Override
    public void skaitytiKnyga(Knyga knyga){
            skaitomosKnygos.add(knyga);
            knyga.paimtiKnyga();
    }
}

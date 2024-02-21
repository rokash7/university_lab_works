package Threads;

import Leidinys.DVD;
import Leidinys.Knyga;
import Zmogus.Darbuotojas;
import Zmogus.Skaitytojas;

import java.io.*;
import java.util.LinkedList;

public class AutoSaveThread extends Thread implements Serializable{

    LinkedList<Skaitytojas> skaitytojai = new LinkedList<Skaitytojas>();
    LinkedList<Darbuotojas> darbuotojai = new LinkedList<Darbuotojas>();
    LinkedList<Knyga> knygos = new LinkedList<Knyga>();
    LinkedList<DVD> dvd = new LinkedList<DVD>();

    public AutoSaveThread(LinkedList<Skaitytojas> skaitytojai, LinkedList<Darbuotojas> darbuotojai,
                          LinkedList<Knyga> knygos, LinkedList<DVD> dvd){

        this.skaitytojai = skaitytojai;
        this.darbuotojai = darbuotojai;
        this.knygos = knygos;
        this.dvd = dvd;
    }

    @Override
    public void run(){
        for(;;){
            try {
                Thread.sleep(300000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Saving...");

            saveData();

        }
    }

    private void saveData(){
        FileOutputStream fileOut = null;

        try {
            fileOut = new FileOutputStream("Info.ser");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        ObjectOutputStream out = null;
        try {
            out = new ObjectOutputStream(fileOut);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            out.writeObject(skaitytojai);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            out.writeObject(darbuotojai);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            out.writeObject(knygos);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            out.writeObject(dvd);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            fileOut.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

import Leidinys.DVD;
import Leidinys.Knyga;
import Zmogus.Darbuotojas;
import Zmogus.Skaitytojas;

import java.io.*;
import java.util.Date;
import java.util.LinkedList;

public class Lists  implements Serializable {

    private LinkedList<Skaitytojas> skaitytojai = new LinkedList<Skaitytojas>();
    private LinkedList<Darbuotojas> darbuotojai = new LinkedList<Darbuotojas>();
    private LinkedList<Knyga> knygos = new LinkedList<Knyga>();
    private LinkedList<DVD> dvd = new LinkedList<DVD>();

    public LinkedList<Skaitytojas> getSkaitytojai() {
        return skaitytojai;
    }

    public void setSkaitytojai(LinkedList<Skaitytojas> skaitytojai) {
        this.skaitytojai = skaitytojai;
    }


    public LinkedList<Darbuotojas> getDarbuotojai() {
        return darbuotojai;
    }

    public void setDarbuotojai(LinkedList<Darbuotojas> darbuotojai) {
        this.darbuotojai = darbuotojai;
    }


    public LinkedList<Knyga> getKnygos() {
        return knygos;
    }

    public void setKnygos(LinkedList<Knyga> knygos) {
        this.knygos = knygos;
    }


    public LinkedList<DVD> getDvd() {
        return dvd;
    }

    public void setDvd(LinkedList<DVD> dvd) {
        this.dvd = dvd;
    }

    public void deserialize(){
//        createKnygos();
//        createDarbuotojai();
//        createDVD();
//        createSkatytojai();

        FileInputStream fileIn = null;
        try {
            fileIn = new FileInputStream("Info.ser");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        ObjectInputStream in = null;
        try {
            in = new ObjectInputStream(fileIn);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            skaitytojai = (LinkedList) in.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            darbuotojai = (LinkedList) in.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            knygos = (LinkedList) in.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            dvd = (LinkedList) in.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            fileIn.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

//    public void createKnygos() {
//        for (int i = 0; i < 5; i++) {
//            knygos.add(new Knyga("author" + i, "name" + i, "genre" + i, i));
//        }
//    }
//
//    public void createDVD() {
//        for (int i = 0; i < 5; i++) {
//            dvd.add(new DVD("author" + i, "name" + i, "genre" + i));
//        }
//    }
//
//    public void createDarbuotojai() {
//        darbuotojai.add(new Darbuotojas("darbuotojas1", 861234567, new Date(100, 1, 1)));
//    }
//
//    public void createSkatytojai() {
//        Skaitytojas biblioteka = new Skaitytojas("BIBLIOTEKA", 851234567, "Bibliotekos adresas", new Date(100, 1, 1));
//        skaitytojai.add(biblioteka);
//
//        for(int i = 1; i < 5; i++){
//            skaitytojai.add(new Skaitytojas("skaitytojas" + i, i, "Skaitytojo gatve " + i, new Date(100, i, i)));
//        }
//    }

}

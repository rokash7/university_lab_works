package Leidinys;

import java.io.Serializable;

public abstract class Leidinys implements Cloneable, Serializable {

    private String author;
    private String name;

    public Leidinys(String name, String author){
        this.name = name;
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setAuthor(String author) {
        this.author = author;
    }

    public Object clone(){
        Object clone = null;

        try {
            clone = super.clone();

        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        return clone;
    }

//    public Object clone(Knyga object){
//        Knyga clone = new Knyga();
//        Knyga knyga = (Knyga)object;
//
//        if(knyga != null){
//            clone.setName(knyga.getName());
//            clone.setAuthor(knyga.getAuthor());
//            clone.setGenre(knyga.getGenre());
//            clone.setPuslapiuSkaicius(knyga.getPuslapiuSkaicius());
//        }
//
//        return clone;
//    }

}

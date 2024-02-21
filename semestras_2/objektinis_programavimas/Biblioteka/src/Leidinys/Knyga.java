package Leidinys;

public class Knyga extends Leidinys implements Cloneable{
    private String genre;
    private int puslapiuSkaicius;
    private boolean knygaPaimta = false;
    public static int egzemplioriuSkaicius = 0;

    public Knyga(){
        this("nezinoma", "nezinoma", "nezinoma", 0);
    }

    public Knyga(String author, String name, String genre, int puslapiuSkaicius){
        super(name, author);
        egzemplioriuSkaicius++;
        this.genre = genre;
        this.puslapiuSkaicius = puslapiuSkaicius;
    }

//    public Knyga(Knyga knyga){
//        egzemplioriuSkaicius++;
//        this.author = knyga.getAuthor();
//        this.name = knyga.getName();
//        this.genre = knyga.getGenre();
//        this.puslapiuSkaicius = knyga.getPuslapiuSkaicius();
//    }

    //get/set methods


    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public boolean getKnygaPaimta(){
        return knygaPaimta;
    }

    public int getPuslapiuSkaicius() {
        return puslapiuSkaicius;
    }

    public void setPuslapiuSkaicius(int puslapiuSkaicius) {
        this.puslapiuSkaicius = puslapiuSkaicius;
    }

    //methods
    public void paimtiKnyga(){
        this.knygaPaimta = true;
    }

    public void grazintiKnyga(){
        this.knygaPaimta = false;
    }

}

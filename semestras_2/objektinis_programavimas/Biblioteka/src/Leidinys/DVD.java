package Leidinys;

public class DVD extends Leidinys{
    private String tipas;
    private boolean arDiskasPaimtas = false;

    public DVD(String leidykla, String pavadinimas, String tipas){
        super(pavadinimas, leidykla);
        this.tipas = tipas;
    }

    public String getTipas() {
        return tipas;
    }

    public void setTipas(String tipas) {
        this.tipas = tipas;
    }

    public boolean getDVDpaimtas(){
        return arDiskasPaimtas;
    }

    public void setArDiskasPaimtas(boolean arDiskasPaimtas) {
        this.arDiskasPaimtas = arDiskasPaimtas;
    }

}

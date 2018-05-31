package com.stephantasy.mechanics;

public abstract class Moteur {
    protected TypeMoteur type = TypeMoteur.INDEFINI;
    private String cylindre;
    private double prix;


    public Moteur(String cylindre, double prix){
        this.setCylindre(cylindre);
        this.setPrix(prix);
    }


    public TypeMoteur getType() {
        return type;
    }

    public void setType(TypeMoteur type) {
        this.type = type;
    }

    public String getCylindre() {
        return cylindre;
    }

    public void setCylindre(String cylindre) {
        this.cylindre = cylindre;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    @Override
    public String toString() {
        return type.toString();
    }
}

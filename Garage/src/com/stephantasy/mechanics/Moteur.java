package com.stephantasy.mechanics;

import java.io.Serializable;

/**
 * Moteur d'un véhicule
 */
public abstract class Moteur implements Serializable {
    protected TypeMoteur type = TypeMoteur.INDEFINI;
    private String cylindre;
    private double prix;


    public Moteur(String cylindre, double prix){
        this.setCylindre(cylindre);
        this.setPrix(prix);
    }

    /**
     * Type du moteur
     * @return Le type du moteur
     */
    public TypeMoteur getType() {
        return type;
    }
    public void setType(TypeMoteur type) {
        this.type = type;
    }

    /**
     * Cylindré du moteur
     * @return Cylindré du moteur
     */
    public String getCylindre() {
        return cylindre;
    }
    public void setCylindre(String cylindre) {
        this.cylindre = cylindre;
    }

    /**
     * Prix du moteur
     * @return Prix du moteur
     */
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

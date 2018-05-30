package com.stephantasy.mechanics;

public abstract class Moteur {
    private TypeMoteur type;
    private String cylindre;
    private double prix;


    public Moteur(String cylindre, double prix){
        this.cylindre = cylindre;
        this.prix = prix;
    }
}

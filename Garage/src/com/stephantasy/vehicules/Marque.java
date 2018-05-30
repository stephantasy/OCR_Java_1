package com.stephantasy.vehicules;

public enum Marque {
    RENO("RENO"),
    PIGEOT("PIGEOT"),
    TROEN("TROEN");

    private String nom;

    Marque(String nom){
        this.nom = nom;
    }

    @Override
    public String toString() {
        return nom;
    }
}

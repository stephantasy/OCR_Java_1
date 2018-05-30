package com.stephantasy.mechanics;

public enum TypeMoteur {
    DIESEL("DIESEL"),
    ESSENCE("ESSENCE"),
    HYBRIDE("HYBRIDE"),
    ELECTRIQUE("ELECTRIQUE");

    private String nom;

    TypeMoteur(String nom){
        this.nom = nom;
    }

    @Override
    public String toString() {
        return nom;
    }
}

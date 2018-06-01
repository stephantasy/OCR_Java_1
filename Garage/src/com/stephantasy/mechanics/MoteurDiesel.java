package com.stephantasy.mechanics;

public class MoteurDiesel extends Moteur {

    private static final long serialVersionUID = 1L;

    public MoteurDiesel(String cylindre, double prix) {
        super(cylindre, prix);
        type = TypeMoteur.DIESEL;
    }
}

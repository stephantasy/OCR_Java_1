package com.stephantasy.mechanics;

public class MoteurDiesel extends Moteur {

    public MoteurDiesel(String cylindre, double prix) {
        super(cylindre, prix);
        type = TypeMoteur.DIESEL;
    }
}

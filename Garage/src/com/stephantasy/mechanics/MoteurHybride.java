package com.stephantasy.mechanics;

public class MoteurHybride extends Moteur {

    private static final long serialVersionUID = 1L;

    public MoteurHybride(String cylindre, double prix) {
        super(cylindre, prix);
        type = TypeMoteur.HYBRIDE;
    }
}

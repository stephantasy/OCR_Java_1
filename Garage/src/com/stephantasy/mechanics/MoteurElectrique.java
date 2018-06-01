package com.stephantasy.mechanics;

public class MoteurElectrique extends Moteur {

    private static final long serialVersionUID = 1L;

    public MoteurElectrique(String cylindre, double prix) {
        super(cylindre, prix);
        type = TypeMoteur.ELECTRIQUE;
    }
}

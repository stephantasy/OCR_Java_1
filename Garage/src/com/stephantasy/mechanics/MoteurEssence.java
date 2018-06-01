package com.stephantasy.mechanics;

public class MoteurEssence extends Moteur {

    private static final long serialVersionUID = 1L;

    public MoteurEssence(String cylindre, double prix) {
        super(cylindre, prix);
        type = TypeMoteur.ESSENCE;
    }
}

package com.stephantasy.mechanics;

public class MoteurEssence extends Moteur {

    public MoteurEssence(String cylindre, double prix) {
        super(cylindre, prix);
        type = TypeMoteur.ESSENCE;
    }
}

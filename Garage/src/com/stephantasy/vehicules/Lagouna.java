package com.stephantasy.vehicules;

public class Lagouna extends Vehicule {

    private static final long serialVersionUID = 1L;

    public Lagouna(){
        super();
        this.nom = "Laguna";
        this.nomMarque = Marque.RENO;
        this.prix = 12867d;     // Prix de la carcasse
    }
}

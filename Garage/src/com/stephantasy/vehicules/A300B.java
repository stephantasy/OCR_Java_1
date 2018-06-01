package com.stephantasy.vehicules;

public class A300B extends Vehicule {

    private static final long serialVersionUID = 1L;

    public A300B(){
        super();
        this.nom = "A300B";
        this.nomMarque = Marque.PIGEOT;
        this.prix = 14509d;     // Prix de la carcasse
    }
}

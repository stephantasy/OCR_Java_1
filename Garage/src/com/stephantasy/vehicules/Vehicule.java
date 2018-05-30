package com.stephantasy.vehicules;

import com.stephantasy.mechanics.Moteur;
import com.stephantasy.misc.Option;

import java.io.Serializable;
import java.util.List;
import java.util.Random;

public class Vehicule implements Serializable {

    private double prix;
    private String nom;
    private List<Option> options;
    private Marque nomMarque;
    private long id;

    public Vehicule(){
        id = getRandomNumber();
    }

    public void setMoteur(Moteur moteur){

    }

    public void addOption(Option option) {
    }



    private long getRandomNumber() {
        Random r = new Random();
        return r.nextLong();
    }

    public long getId() {
        return id;
    }
}

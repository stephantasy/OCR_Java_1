package com.stephantasy.vehicules;

import com.stephantasy.mechanics.Moteur;
import com.stephantasy.equipment.Option;

import java.io.Serializable;
import java.util.*;

public abstract class Vehicule implements Serializable {

    protected String nom = "Undefini";
    protected double prix = 0;              // Prix de la voiture sans moteur, ni option
    protected Marque nomMarque = Marque.INDEFINIE;

    private Set<Option> options = new HashSet<>();    // Un Set pour éviter d'ajouter 2 fois la même option
    private Moteur moteur;
    private final long id  = getRandomNumber();


    // NOM
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Le prix est celui de la carcasse
     * @return le prix du véhicule (sans moteur, ni options)
     */
    public double getPrix() {
        return prix;
    }
    public void setPrix(double prix){
        this.prix = prix;
    }


    // OPTIONS
    public Set<Option> getOptions(){
        return options;
    }
    public void addOption(Option option) {
        options.add(option);
    }

    // MARQUE
    public Marque getNomMarque() {
        return nomMarque;
    }
    public void setNomMarque(Marque nomMarque) {
        this.nomMarque = nomMarque;
    }

    // MOTEUR
    public Moteur getMoteur() {
        return moteur;
    }
    public void setMoteur(Moteur moteur){
        this.moteur = moteur;
    }


    public long getId() {
        return id;
    }


    @Override
    public String toString() {
        return String.format("Voiture %s : %s Moteur %s %s (%.2f€) %s d'une valeur totale de %.2f€",
                nomMarque.toString(), nom, moteur.toString(), moteur.getCylindre(), prix + moteur.getPrix(), getOptionsDetail(), getPrixTotal());
    }

    private String getOptionsDetail() {
        if(options.isEmpty()){
            return "[Sans option]";
        }
        return options.toString();
    }

    /**
     * Prix total du véhicule = Carcasse + moteur + options
     * @return Prix total
     */
    private double getPrixTotal() {
        double prixOptions = options.stream().map(x -> x.getPrix()).reduce(0d, (x, y) -> x + y);
        return prix + moteur.getPrix() + prixOptions;
    }


    private long getRandomNumber() {
        Random r = new Random();
        return r.nextLong();
    }

}

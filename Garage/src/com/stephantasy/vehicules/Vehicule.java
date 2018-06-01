package com.stephantasy.vehicules;

import com.stephantasy.mechanics.Moteur;
import com.stephantasy.equipment.Option;

import java.io.Serializable;
import java.util.*;

public abstract class Vehicule implements Serializable {

    private static final long serialVersionUID = 1L;

    protected String nom = "Undefini";
    protected double prix = 0;              // Prix de la voiture sans moteur, ni option
    protected Marque nomMarque = Marque.INDEFINIE;

    private Set<Option> options = new HashSet<>();    // Un Set pour éviter d'ajouter 2 fois la même option
    private Moteur moteur;
    private final long id  = getRandomNumber();


    /**
     * NOM
     * @return le nom du véhicule
     */
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


    /**
     * OPTION
     * @return la liste des options
     */
    public Set<Option> getOptions(){
        return options;
    }
    public void addOption(Option option) {
        options.add(option);
    }

    /**
     * MARQUE
     * @return La marque du véhicule
     */
    public Marque getNomMarque() {
        return nomMarque;
    }
    public void setNomMarque(Marque nomMarque) {
        this.nomMarque = nomMarque;
    }

    /**
     * MOTEUR
     * @return le moteur du véhicule
     */
    public Moteur getMoteur() {
        return moteur;
    }
    public void setMoteur(Moteur moteur){
        this.moteur = moteur;
    }

    /**
     * Identifiant du véhicule servant à nommer le fichier de sauvegarde
     * (Devrait être unique, mais ce n'est pas le cas. Cependat avoir 2 véhicules avec le même ID est peu probable !)
     * @return L'id du véhicule
     */
    public long getId() {
        return id;
    }


    /**
     * Liste des options ou message indiquant qu'il n'y en a pas
     * @return La liste des options
     */
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
        double prixOptions = options.stream().map(Option::getPrix).reduce(0d, (x, y) -> x + y);
        return prix + moteur.getPrix() + prixOptions;
    }

    /**
     * Crée un nombre aléatoire servant d'identifiant au véhicule
     * @return Un nombre aléatoire
     */
    private long getRandomNumber() {
        Random r = new Random();
        return r.nextLong();
    }


    @Override
    public String toString() {
        return String.format("Voiture %s : %s Moteur %s %s (%.2f€) %s d'une valeur totale de %.2f€",
                nomMarque.toString(), nom, moteur.toString(), moteur.getCylindre(), prix + moteur.getPrix(), getOptionsDetail(), getPrixTotal());
    }
}

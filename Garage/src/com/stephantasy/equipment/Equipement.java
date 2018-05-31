package com.stephantasy.equipment;

public abstract class Equipement implements Option{

    protected String nom;
    protected double prix;

    /**
     * Possibilité de modifier le prix prédéfini
     * @param prix nouveau prix
     */
    public void setPrix(double prix) {
        if(prix >= 0) {
            this.prix = prix;
        }
    }

    public String getNom() {
        return nom;
    }

    @Override
    public double getPrix() {
        return prix;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (obj == this) return true;
        if (!(obj instanceof Equipement))return false;
        return nom.equalsIgnoreCase(((Equipement)obj).nom);
    }

    @Override
    public int hashCode() {
        return nom.hashCode();
    }

    @Override
    public String toString() {
        return String.format("%s (%.2f€)", nom, prix);
    }
}

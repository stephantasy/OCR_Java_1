package com.stephantasy.garage;

import com.stephantasy.vehicules.Vehicule;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Garage contenant la liste des voitures
 * Chaque véhicule créé est ajouté à la liste et sauvegardé dans un fichier
 * À chaque instanciation, les fichiers de sauvegarde sont lus et la liste est pré-remplie des voitures s'y trouvant
 *
 * ATTENTION : Comme rien ne différencie 2 véhicules, à chaque éxecution du Main les voitures sont ajoutées à
 * la liste et aux fichiers de sauvegarde. Ce comportement est connu et accepté.
 * Les raisons sont :
 *      - Rien n'a été spécifié à ce sujet
 *      - Il est tout à fait possible d'avoir deux voitures totalement identiques
 */
public class Garage {

    private List<Vehicule> voitures = new ArrayList<>();
    private final String folderName = "Save";

    public Garage(){
        // Lecture des fichiers sauvegardés
        readSavedFile();
    }

    /**
     * Ajout d'un véhicule à la liste et sauvegarde de celui-ci
     * @param voiture Véhicule a ajouter
     */
    public void addVoiture(Vehicule voiture){
        // On ajoute la voiture à la liste
        addVoitureToList(voiture);

        // On la suavegarde dans le fichier
        saveToFile(voiture);
    }

    /**
     * Ajout d'un véhicule à la liste (sans sauvegarde)
     * @param vehicule Véhicule a ajouter
     */
    private void addVoitureToList(Vehicule vehicule) {
        voitures.add(vehicule);
    }

    /**
     * Lecture des fichiers de sauvegarde
     */
    private void readSavedFile() {

        String[] files = new String[0];
        
        // On récupère la liste des fichiers
        File file = new File(folderName);

        // check if the specified pathname is directory first
        if(file.isDirectory()){
            //list all files on directory
            files = file.list();
        }

        if (files != null) {
            for(String currentFile : files) {
                Vehicule voiture;
                try {
                    FileInputStream fileIn = new FileInputStream(folderName + "/" + currentFile);
                    ObjectInputStream in = new ObjectInputStream(fileIn);
                    voiture = (Vehicule) in.readObject();
                    addVoitureToList(voiture);
                    in.close();
                    fileIn.close();
                } catch (IOException i) {
                    i.printStackTrace();
                    return;
                } catch (ClassNotFoundException c) {
                    System.out.println("#Erreur : Impossible de récupérer l'objet " + currentFile);
                    c.printStackTrace();
                    return;
                }
            }
        }
    }

    /**
     * Sauvegarde du véhicule dans un fichier
     * @param voiture véhicule à sauvegarder
     */
    private void saveToFile(Vehicule voiture) {
        try {
            // Si le dossier de sauvegarde n'existe pas, on le crée
            (new File(folderName)).mkdirs();
            FileOutputStream fileOut = new FileOutputStream(folderName + "/" + String.valueOf(voiture.getId()));
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(voiture);
            out.close();
            fileOut.close();
        } catch (IOException e) {
            System.out.println("#Erreur lors de la sauvegarde de " + voiture.toString() + "\n" + e);
        }
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("\n******************************\n");
        result.append("*    Garage OpenClassRooms   *\n");
        result.append("******************************\n\n");
        if (voitures.isEmpty()){
            result.append("* Le garage est actuellement vide ! *");
        }else{
            result.append("* Le garage contient " + voitures.size() + " véhicule(s) *\n\n");
            for(Vehicule v : voitures){
                result.append("+ ").append(v.toString()).append("\n");
            }
        }
        return result.toString();
    }
}

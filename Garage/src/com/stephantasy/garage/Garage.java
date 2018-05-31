package com.stephantasy.garage;

import com.stephantasy.vehicules.Vehicule;
import com.stephantasy.vehicules.VehiculeFactory;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

public class Garage {

    private List<Vehicule> voitures = new ArrayList<>();
    private final String folderName = "Save";

    public Garage(){
        // Lecture des fichiers sauvegardés
        //readSavedFile();
    }

    public void addVoiture(Vehicule voiture){
        // On ajoute la voiture à la liste
        addVoitureToList(voiture);

        // On la suavegarde dans le fichier
        //saveToFile(voiture);
    }


    private void readSavedFile() {

        String[] files = new String[0];
        
        // On récupère la liste des fichiers
        File file = new File(folderName);

        // check if the specified pathname is directory first
        if(file.isDirectory()){
            //list all files on directory
            files = file.list();
        }

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

    private void addVoitureToList(Vehicule vehicule) {
        voitures.add(vehicule);
    }


    private void saveToFile(Vehicule voiture) {
        try {
            (new File(folderName)).mkdirs();
            FileOutputStream fileOut = new FileOutputStream(folderName + "/" + String.valueOf(voiture.getId()));
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(voiture);
            out.close();
            fileOut.close();
        } catch (IOException e) {
            System.out.printf("#Erreur lors de la sauvegarde de " + voiture.toString());
        }
    }

    @Override
    public String toString() {
        String result = "\n******************************\n";
        result += "*    Garage OpenClassRooms   *\n";
        result += "******************************\n\n";
        if (voitures.isEmpty()){
            result += "* Le garage est actuellement vide ! *";
        }else{
            for(Vehicule v : voitures){
                result += "+ " + v.toString() + "\n";
            }
        }
        return result;
    }
}

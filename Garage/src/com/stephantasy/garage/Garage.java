package com.stephantasy.garage;

import com.stephantasy.vehicules.Vehicule;
import com.stephantasy.vehicules.VehiculeFactory;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Garage {

    private List<Vehicule> voitures = new ArrayList<>();
    private final String folderName = "Save";

    public Garage(){
        // Lecture du fichier de sauvegarde
        readSavedFile();

    }

    public void addVoiture(Vehicule voiture){
        // On ajoute la voiture à la liste
        addVoitureToList(voiture);
        // On la suavegarde dans le fichier
        saveToFile(voiture);
    }

    @Override
    public String toString() {
        //TODO
        return super.toString();
    }


    /**
     *
     * @throws Exception
     */
    private void readSavedFile() {
        //TODO
        /*try (Stream<String> stream = Files.lines( Paths.get(nomFichier), StandardCharsets.UTF_8))
        {
            stream.forEach(s -> addVoitureToList(VehiculeFactory.getVehicule(s)));
        }
        catch (IOException e)
        {
            System.out.println("Erreur lors de la lecture du fichier " + nomFichier);
        }
        catch (Exception e){
            System.out.println("#Erreur lors de la lecture du fichier de sauvegarde : " + e.getMessage());
        }*/
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

    public void close() {
        System.out.println("C'est fini !");
    }
}

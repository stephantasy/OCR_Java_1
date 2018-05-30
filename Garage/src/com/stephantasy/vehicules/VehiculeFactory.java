package com.stephantasy.vehicules;

public final class VehiculeFactory {


    public static Vehicule getVehicule(String data){
        return new Lagouna();
    }
}

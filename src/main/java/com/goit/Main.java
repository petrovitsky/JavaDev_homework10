package com.goit;
import client.Client;
import client.ClientCrudService;
import client.HibernateClientCrudService;
import planet.HibernatePlanetCrudService;
import planet.Planet;
import planet.PlanetCrudService;
import storage.DataBaseInitService;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //Flyway init DB
        DataBaseInitService dataBaseInitService = new DataBaseInitService();
        dataBaseInitService.initDB();
        //Testing PlanetCRUDService
        PlanetCrudService planetCrudService = new HibernatePlanetCrudService();
        final Planet planet = new Planet();
        planet.setId("TEST");
        planet.setName("test planet");
            // Create method
        planetCrudService.create(planet);
            //Get method
        final Planet createdPlanet = planetCrudService.getById("TEST");
        System.out.println("createdPlanet = " + createdPlanet);
            // Update method
        planetCrudService.update("TEST", "updated planet");
            // Get list of all
        final List<Planet> planets = planetCrudService.listAll();
        System.out.println("planets = " + planets);
            // Delete method
        planetCrudService.deleteById("TEST");
        final List<Planet> afterDeleting = planetCrudService.listAll();
        System.out.println("After deleting = " + afterDeleting);

        //Testing ClientCRUDService
        ClientCrudService clientCrudService = new HibernateClientCrudService();
        final Client newClient = new Client();
        newClient.setName("Vika");
            // Create method
        clientCrudService.create(newClient);
            //Get method
        final Client createdClient = clientCrudService.getById(newClient.getId());
        System.out.println("createdClient = " + createdClient);
            // Update method
        clientCrudService.update(newClient.getId(), "updated name");
            // Get list of all
        System.out.println("clientCrudService.listAll() = " + clientCrudService.listAll());
            // Delete method
        clientCrudService.deleteById(newClient.getId());
        System.out.println("After deleting " + clientCrudService.listAll());

    }
}

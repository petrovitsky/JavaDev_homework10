package com.goit;

import client.Client;
import client.ClientCrudService;
import client.HibernateClientCrudService;
import planet.HibernatePlanetCrudService;
import planet.Planet;
import planet.PlanetCrudService;
import storage.DataBaseInitService;
import ticket.HibernateTicketCrudService;
import ticket.Ticket;
import ticket.TicketCrudService;

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
        System.out.println("clientCrudService.listAll() = "
                + clientCrudService.listAll());
            // Delete method
        clientCrudService.deleteById(newClient.getId());
        System.out.println("After deleting " + clientCrudService.listAll());


        // Ticket CRUD service
        TicketCrudService ticketCrudService = new HibernateTicketCrudService();

              //Create
        final Ticket ticket = new Ticket();
        ticket.setClient(new HibernateClientCrudService().getById(41));
        ticket.setFromPlanet(new HibernatePlanetCrudService().getById("EARTH"));
        ticket.setToPlanet(new HibernatePlanetCrudService().getById("MARS"));
        final long createdTicketId = ticketCrudService.create(ticket);
        System.out.println("createdTicketId = " + createdTicketId);

                //GetById
        final Ticket byId = ticketCrudService.getById(createdTicketId);
        System.out.println("byId = " + byId);
        System.out.println("byId.getClient() = " + byId.getClient());

                // Update
        Client client = new Client();
        client.setName("TestClient");
        final long newId = clientCrudService.create(client);

        ticketCrudService
                .update(
                        createdTicketId,
                        clientCrudService.getById(newId),
                        planetCrudService.getById("PLUTO"),
                        planetCrudService.getById("VENUS"));
        System.out.println(
                "ticketCrudService.getById(createdTicketId) = "
                        + ticketCrudService.getById(createdTicketId));

                // listAll()
        final List<Ticket> tickets = ticketCrudService.listAll();
        for (Ticket ticket1 : tickets) {
            System.out.println("ticket = " + ticket1);
        }
                // DeleteById
        ticketCrudService.deleteById(createdTicketId);

    }
}

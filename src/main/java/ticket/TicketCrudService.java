package ticket;

import client.Client;
import planet.Planet;

import java.util.List;

public interface TicketCrudService {
    long create(Ticket ticket);

    Ticket getById(long id);

    void deleteById(long id);

    List<Ticket> listAll();

    void update(long id, Client client, Planet fromPlanet, Planet toPlanet);
}

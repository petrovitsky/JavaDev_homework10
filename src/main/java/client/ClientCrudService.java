package client;

import java.util.List;

public interface ClientCrudService {
    long create(Client client);

    Client getById(long id);

    void deleteById(long id);

    List<Client> listAll();
    void update(long id, String name);
}

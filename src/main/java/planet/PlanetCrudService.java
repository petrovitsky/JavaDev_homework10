package planet;

import java.util.List;

public interface PlanetCrudService {
    String create(Planet planet);

    Planet getById(String id);

    void deleteById(String id);

    List<Planet> listAll();
    void update(String id, String name);
}

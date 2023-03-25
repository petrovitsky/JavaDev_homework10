package planet;

import org.hibernate.Session;
import org.hibernate.Transaction;
import storage.hibernate.HibernateUtil;

import java.util.List;

public class HibernatePlanetCrudService implements PlanetCrudService {
    @Override
    public String create(Planet planet) {
        final Session session = HibernateUtil.getINSTANCE().getSessionFactory().openSession();
        final Transaction transaction = session.beginTransaction();
        session.persist(planet);
        transaction.commit();
        session.close();
        return planet.getId();
    }

    @Override
    public Planet getById(String id) {
        try (final Session session = HibernateUtil.getINSTANCE().getSessionFactory().openSession()) {
            return session.get(Planet.class, id);
        }
    }

    @Override
    public void deleteById(String id) {
        try (final Session session = HibernateUtil.getINSTANCE().getSessionFactory().openSession()) {
            final Transaction transaction = session.beginTransaction();
            session.remove(session.get(Planet.class, "TEST"));
            transaction.commit();
        }
    }

    @Override
    public List<Planet> listAll() {
        try (final Session session = HibernateUtil
                .getINSTANCE()
                .getSessionFactory()
                .openSession()) {
            return session.createQuery("from Planet", Planet.class).list();
        }
    }

    @Override
    public void update(String id, String name) {
        try (final Session session = HibernateUtil.getINSTANCE().getSessionFactory().openSession()) {
            final Transaction transaction = session.beginTransaction();
            final Planet planet = session.get(Planet.class, id);
            planet.setName(name);
            transaction.commit();
        }
        catch (NullPointerException ex){
            ex.printStackTrace();
            System.out.println("Object with id \"" + id + "\" is not exist" );
        }
    }
}



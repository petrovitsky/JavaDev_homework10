package client;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import storage.hibernate.HibernateUtil;

import java.util.List;

public class HibernateClientCrudService implements ClientCrudService {
    @Override
    public long create(Client client) {
        try (final Session session = HibernateUtil.getINSTANCE().getSessionFactory().openSession()) {
            final Transaction transaction = session.beginTransaction();
            session.persist(client);
            transaction.commit();
            return client.getId();
        }
    }
    @Override
    public Client getById(long id) {
        try (final Session session = HibernateUtil.getINSTANCE().getSessionFactory().openSession()) {
            return session.get(Client.class, id);
        }
    }
    @Override
    public void deleteById(long id) {
        try (final Session session = HibernateUtil.getINSTANCE().getSessionFactory().openSession()) {
            final Transaction transaction = session.beginTransaction();
            final Client toDelete = session.get(Client.class, id);
            session.remove(toDelete);
            transaction.commit();
        }
    }
    @Override
    public List<Client> listAll() {
        try (final Session session =
                     HibernateUtil.getINSTANCE()
                             .getSessionFactory().openSession()) {
            return session.createQuery("from Client", Client.class).list();
        }
    }
    @Override
    public void update(long idToUpd, String newName) {
        try (final Session session = HibernateUtil.getINSTANCE().getSessionFactory().openSession()){
            final Transaction transaction = session.beginTransaction();
            session.get(Client.class,idToUpd).setName(newName);
            transaction.commit();
        }
    }
}

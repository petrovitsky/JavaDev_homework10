package ticket;

import client.Client;
import org.hibernate.Session;
import org.hibernate.Transaction;
import planet.Planet;
import storage.hibernate.HibernateUtil;

import java.util.List;

public class HibernateTicketCrudService implements TicketCrudService {
    @Override
    public long create(Ticket ticket) {
        try (final Session session = HibernateUtil.getINSTANCE().getSessionFactory().openSession()) {
            final Transaction transaction = session.beginTransaction();
            session.persist(ticket);
            transaction.commit();
            return ticket.getId();
        }
    }

    @Override
    public Ticket getById(long id) {
        try (final Session session = HibernateUtil.getINSTANCE().getSessionFactory().openSession()) {
            return session.get(Ticket.class, id);
        }
    }

    @Override
    public void deleteById(long id) {
        try (final Session session = HibernateUtil.getINSTANCE().getSessionFactory().openSession()) {
            final Transaction transaction = session.beginTransaction();
            final Ticket toDelete = session.get(Ticket.class, id);
            session.remove(toDelete);
            transaction.commit();
        }
    }

    @Override
    public List<Ticket> listAll() {
        try (final Session session =
                     HibernateUtil.getINSTANCE()
                             .getSessionFactory().openSession()) {
            return session.createQuery("from Ticket", Ticket.class).list();
        }
    }

    @Override
    public void update(long id, Client client, Planet fromPlanet, Planet toPlanet) {
        try (final Session session = HibernateUtil.getINSTANCE().getSessionFactory().openSession()){
            final Transaction transaction = session.beginTransaction();
            session.get(Ticket.class,id).setClient(client);
            session.get(Ticket.class,id).setFromPlanet(fromPlanet);
            session.get(Ticket.class,id).setToPlanet(toPlanet);
            transaction.commit();
        }
    }
}

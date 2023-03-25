package storage.hibernate;

import client.Client;
import lombok.Getter;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import planet.Planet;

import java.util.List;

public class HibernateUtil {
    private static final HibernateUtil INSTANCE;

    static {
        INSTANCE = new HibernateUtil();
    }

    @Getter
    private SessionFactory sessionFactory;

    private HibernateUtil() {
        sessionFactory = new Configuration()
                .addAnnotatedClass(Client.class)
                .addAnnotatedClass(Planet.class)
                .buildSessionFactory();
    }

    public static HibernateUtil getINSTANCE() {
        return INSTANCE;
    }

    public void close() {
        sessionFactory.close();
    }

    public static void main(String[] args) {

        HibernateUtil hibernateUtil = new HibernateUtil();

        // Get single
//        Session session = hibernateUtil.getSessionFactory().openSession();
//        final Passenger passenger = session.get(Passenger.class, 1l);
//        System.out.println("passenger = " + passenger);
//        session.close();


        // List of passengers
//        Session session = hibernateUtil.getSessionFactory().openSession();
//        List<Passenger> passengerList = session.createQuery("from Passenger", Passenger.class).list();
//        System.out.println("passengerList = " + passengerList);
//        session.close();

//Add new passenger
//        Session session = hibernateUtil.getSessionFactory().openSession();
//            Transaction transaction = session.beginTransaction();
//                Passenger newPassenger = new Passenger();
//                newPassenger.setName("Mira");
//                newPassenger.setPassport("nl15");
//                session.persist(newPassenger);
//                System.out.println("newPassenger = " + newPassenger);
//            transaction.commit();
//        session.close();

        //List all tickets
//        Session session = hibernateUtil.getSessionFactory().openSession();
//        List<Ticket> tickets = session.createQuery("from Ticket",Ticket.class).list();
//        System.out.println("tickets = " + tickets);
//        session.close();


//        Session session = hibernateUtil.getSessionFactory().openSession();
//            final Transaction transaction = session.beginTransaction();
//                Person newPerson = new Person();
//                newPerson.setAddressList(Arrays.asList("a1", "a2"));
//                session.persist(newPerson);
//                System.err.println("newPerson = " + newPerson);
//        transaction.commit();
//        session.close();


        Session session = hibernateUtil.getSessionFactory().openSession();
        final List<Planet> fromPerson = session.createQuery("from Planet ", Planet.class).list();
        System.out.println("fromPerson = " + fromPerson);
        session.close();

    }

}


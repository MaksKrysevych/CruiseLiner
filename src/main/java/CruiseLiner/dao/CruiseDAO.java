package CruiseLiner.dao;

import CruiseLiner.model.Cruise;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import java.util.List;

public class CruiseDAO {

    /**
     * Connection factory to database.
     */
    private static final SessionFactory factory = new Configuration().configure().buildSessionFactory();

    /**
     * Create new engine in engines table.
     *
     * @param cruise for add.
     */
    public static void create(Cruise cruise) {
        try (final Session session = factory.openSession()) {

            session.beginTransaction();

            session.persist(cruise);

            session.getTransaction().commit();
        }
    }

    /**
     * Get user by name.
     *
     * @return user.
     */
    public static Cruise findCruiseByName(String name) {
        try (final Session session = factory.openSession()) {

            Cruise result = session.get(Cruise.class, name);

            return result != null ? result : new Cruise();
        }
    }

    /**
     * Get all cruises.
     *
     * @return all cruises.
     */
    public static List<Cruise> read() {
        List<Cruise> cruises;
        try (final Session session = factory.openSession()) {

            cruises = session.createQuery("from Cruise", Cruise.class).getResultList();

            return cruises;
        }
    }

    /**
     * Update cruise state.
     *
     * @param cruise new state.
     */
    public static void update(Cruise cruise) {
        try (Session session = factory.openSession()) {
            session.beginTransaction();

            session.merge(cruise);

            session.getTransaction().commit();
        }
    }

    /**
     * Delete cruise.
     *
     * @param cruise for delete.
     */
    public static void delete(Cruise cruise) {
        try (Session session = factory.openSession()) {
            session.beginTransaction();

            session.remove(cruise);

            session.getTransaction().commit();
        }
    }
}

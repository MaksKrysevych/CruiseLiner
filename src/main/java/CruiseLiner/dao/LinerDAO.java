package CruiseLiner.dao;

import CruiseLiner.model.Liner;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import java.util.List;

public class LinerDAO {

    /**
     * Connection factory to database.
     */
    private static final SessionFactory factory = new Configuration().configure().buildSessionFactory();

    /**
     * Create new liner in liner table.
     *
     * @param liner for add.
     */
    public static void create(Liner liner) {
        try (final Session session = factory.openSession()) {

            session.beginTransaction();

            session.persist(liner);

            session.getTransaction().commit();
        }
    }

    /**
     * Get liner by name.
     *
     * @return liner.
     */
    public static Liner findLinerByName(String name) {
        try (final Session session = factory.openSession()) {

            Liner result = session.get(Liner.class, name);

            return result != null ? result : new Liner();
        }
    }

    /**
     * Get all liners.
     *
     * @return all liners.
     */
    public static List<Liner> read() {
        List<Liner> liners;
        try (final Session session = factory.openSession()) {

            liners = session.createQuery("from Liner", Liner.class).getResultList();

            return liners;
        }
    }

    /**
     * Update liner state.
     *
     * @param liner new state.
     */
    public static void update(Liner liner) {
        try (Session session = factory.openSession()) {
            session.beginTransaction();

            session.merge(liner);

            session.getTransaction().commit();
        }
    }

    /**
     * Delete liner.
     *
     * @param liner for delete.
     */
    public static void delete(Liner liner) {
        try (Session session = factory.openSession()) {
            session.beginTransaction();

            session.remove(liner);

            session.getTransaction().commit();
        }
    }
}

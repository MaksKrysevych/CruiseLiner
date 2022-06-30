package CruiseLiner.dao;

import CruiseLiner.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import java.util.List;

public class UserDAO {

    /**
     * Connection factory to database.
     */
    private static final SessionFactory factory = new Configuration().configure().buildSessionFactory();

    /**
     * Create new engine in engines table.
     *
     * @param user for add.
     */
    public static void create(User user) {
        try (final Session session = factory.openSession()) {

            session.beginTransaction();

            session.persist(user);

            session.getTransaction().commit();
        }
    }

    /**
     * Get user by name.
     *
     * @return user.
     */
    public static User findUserByLogin(String name) {
        try (final Session session = factory.openSession()) {

            User result = session.get(User.class, name);

            return result != null ? result : new User();
        }
    }

    /**
     * Get all users.
     *
     * @return all users.
     */
    public static List<User> read() {
        List<User> users;
        try (final Session session = factory.openSession()) {

            users = session.createQuery("from User", User.class).getResultList();

            return users;
        }
    }

    /**
     * Update user state.
     *
     * @param user new state.
     */
    public static void update(User user) {
        try (Session session = factory.openSession()) {
            session.beginTransaction();

            session.merge(user);

            session.getTransaction().commit();
        }
    }

    /**
     * Delete user.
     *
     * @param user for delete.
     */
    public static void delete(User user) {
        try (Session session = factory.openSession()) {
            session.beginTransaction();

            session.remove(user);

            session.getTransaction().commit();
        }
    }
}
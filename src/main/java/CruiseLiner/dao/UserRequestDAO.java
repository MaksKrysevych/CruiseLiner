package CruiseLiner.dao;

import CruiseLiner.model.UserRequest;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import java.util.List;

public class UserRequestDAO {

    /**
     * Connection factory to database.
     */
    private static final SessionFactory factory = new Configuration().configure().buildSessionFactory();

    /**
     * Create new userRequest in userRequest table.
     *
     * @param userRequest for add.
     */
    public static void create(UserRequest userRequest) {
        try (final Session session = factory.openSession()) {

            session.beginTransaction();

            session.persist(userRequest);

            session.getTransaction().commit();
        }
    }

    /**
     * Get user by userRequest.
     *
     * @return userRequest.
     */
    public static UserRequest findUserRequestByLogin(String name) {
        try (final Session session = factory.openSession()) {

            UserRequest result = session.get(UserRequest.class, name);

            return result != null ? result : new UserRequest();
        }
    }

    /**
     * Get all userRequests.
     *
     * @return all userRequests.
     */
    public static List<UserRequest> read() {
        List<UserRequest> userRequests;
        try (final Session session = factory.openSession()) {

            userRequests = session.createQuery("from UserRequest", UserRequest.class).getResultList();

            return userRequests;
        }
    }

    /**
     * Update userRequest state.
     *
     * @param userRequest new state.
     */
    public static void update(UserRequest userRequest) {
        try (Session session = factory.openSession()) {
            session.beginTransaction();

            session.merge(userRequest);

            session.getTransaction().commit();
        }
    }

    /**
     * Delete userRequest.
     *
     * @param userRequest for delete.
     */
    public static void delete(UserRequest userRequest) {
        try (Session session = factory.openSession()) {
            session.beginTransaction();

            session.remove(userRequest);

            session.getTransaction().commit();
        }
    }
}

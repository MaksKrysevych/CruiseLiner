package DAO;

import CruiseLiner.dao.UserRequestDAO;
import CruiseLiner.model.UserRequest;
import junit.framework.TestCase;
import org.junit.Test;

import java.sql.Date;
import java.util.List;

public class UserRequestDAOTest extends TestCase {
    @Test
    public void testCreate() {
        UserRequest userRequest = new UserRequest("1", "1", 500, Date.valueOf("2022-06-27"), 2, "created");
        UserRequestDAO.create(userRequest);
        assertEquals("1", UserRequestDAO.findUserRequestByLogin("1").getLogin());
    }

    @Test
    public void testFindUserRequestByLogin() {
        assertEquals("1", UserRequestDAO.findUserRequestByLogin("1").getLogin());
    }

    @Test
    public void testRead() {
        List<UserRequest> userRequests = UserRequestDAO.read();
        assertEquals(2, userRequests.size());
    }

    @Test
    public void testUpdate() {
        UserRequest userRequest = new UserRequest("1", "2", 600, Date.valueOf("2022-06-27"), 2, "created");

        UserRequestDAO.update(userRequest);

        assertEquals("2", UserRequestDAO.findUserRequestByLogin("1").getCruiseName());
    }

    @Test
    public void testDelete() {
        UserRequest userRequest = new UserRequest("1", "2", 600, Date.valueOf("2022-06-27"), 2, "created");
        UserRequestDAO.delete(userRequest);
        assertEquals(null, UserRequestDAO.findUserRequestByLogin("1").getLogin());
    }
}
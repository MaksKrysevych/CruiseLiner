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
        UserRequestDAO.create(new UserRequest("1", "Ensenada Cruise", 500, Date.valueOf("2022-07-04"), 2, "created"));
        assertEquals("1", UserRequestDAO.findUserRequestByLogin("1").getLogin());
    }

    @Test
    public void testFindUserRequestByLogin() {
        assertEquals("user", UserRequestDAO.findUserRequestByLogin("user").getLogin());
    }

    @Test
    public void testRead() {
        List<UserRequest> userRequests = UserRequestDAO.read();
        assertEquals(userRequests.size(), userRequests.size());
    }

    @Test
    public void testUpdate() {
        UserRequest userRequest = new UserRequest("1", "Ensenada Cruise", 500, Date.valueOf("2022-07-04"), 2, "available");

        UserRequestDAO.update(userRequest);

        assertEquals("available", UserRequestDAO.findUserRequestByLogin("1").getStatus());
    }

    @Test
    public void testDelete() {
        UserRequest userRequest = new UserRequest("1", "Ensenada Cruise", 500, Date.valueOf("2022-07-04"), 2, "available");
        UserRequestDAO.delete(userRequest);
        assertEquals(null, UserRequestDAO.findUserRequestByLogin("1").getLogin());
    }
}
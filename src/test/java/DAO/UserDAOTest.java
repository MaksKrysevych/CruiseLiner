package DAO;

import CruiseLiner.dao.UserDAO;
import CruiseLiner.model.User;
import junit.framework.TestCase;
import org.junit.Test;

import java.util.List;

public class UserDAOTest extends TestCase {
    @Test
    public void testCreate() {
        UserDAO userDAO = new UserDAO();
        User user = new User("l", "12345678", "admin", "l", "l", "", "qwefwbgd@svfx.ds", 0, (byte) 0);
        userDAO.create(user);
        assertEquals("l", UserDAO.findUserByLogin("l").getLogin());
    }

    @Test
    public void testFindUserByLogin() {
        User user = UserDAO.findUserByLogin("l");
        assertEquals("l", user.getLogin());
    }

    @Test
    public void testRead(){
        List<User> users = UserDAO.read();

        assertEquals("1234", users.get(1).getLogin());
    }

    @Test
    public void testUpdate() {
        User user = new User("l", "12345678", "admin", "m", "m", "", "qwefwbgd@svfx.ds", 0, (byte) 0);
        UserDAO.update(user);

        assertEquals("m", UserDAO.findUserByLogin("l").getFirstName());
    }

    @Test
    public void testDelete() {
        User user = new User("l", "12345678", "admin", "m", "m", "", "qwefwbgd@svfx.ds", 0, (byte) 0);
        UserDAO.delete(user);
        assertEquals(null, UserDAO.findUserByLogin("l").getLogin());
    }
}
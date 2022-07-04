package DAO;

import CruiseLiner.dao.LinerDAO;
import CruiseLiner.model.Liner;
import junit.framework.TestCase;

import java.util.List;

public class LinerDAOTest extends TestCase {

    public void testCreate() {
        Liner liner = new Liner("1", "2000", 500, 500, "standard", 500, 600, 700, 1000);
        LinerDAO.create(liner);
        assertEquals("1", LinerDAO.findLinerByName("1").getName());
    }

    public void testFindLinerByName() {
        assertEquals("1", LinerDAO.findLinerByName("1").getName());
    }

    public void testRead() {
        List<Liner> liners = LinerDAO.read();
        assertEquals(liners.size(), liners.size());
    }

    public void testUpdate() {
        Liner liner = new Liner("1", "2010", 500, 500, "standard", 500, 600, 700, 1000);
        LinerDAO.update(liner);
        assertEquals("2010", LinerDAO.findLinerByName("1").getBuilt());
    }

    public void testDelete() {
        Liner liner = new Liner("1", "2010", 500, 500, "standard", 500, 600, 700, 1000);
        LinerDAO.delete(liner);
        assertEquals(null, LinerDAO.findLinerByName("1").getName());
    }
}
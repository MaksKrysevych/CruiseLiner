package DAO;

import CruiseLiner.dao.CruiseDAO;
import CruiseLiner.model.Cruise;
import junit.framework.TestCase;
import org.junit.Test;

import java.sql.Date;
import java.util.List;

public class CruiseDAOTest extends TestCase {
    @Test
    public void testCreate() {
        Cruise cruise = new Cruise("s", "s", "Neptune", Date.valueOf("2022-06-25"), Date.valueOf("2022-06-30"), "s", "s", 5, "dsfgfhgj");
        CruiseDAO.create(cruise);
        assertEquals("s", CruiseDAO.findCruiseByName("s").getName());
    }

    @Test
    public void testFindCruiseByName() {
        Cruise cruise = CruiseDAO.findCruiseByName("s");

        assertEquals("s", cruise.getName());
    }

    @Test
    public void testRead() {
        List<Cruise> cruises = CruiseDAO.read();

        assertEquals(4, cruises.size());
    }

    @Test
    public void testUpdate() {
        Cruise cruise = new Cruise("s", "solo", "Neptune", Date.valueOf("2022-06-25"), Date.valueOf("2022-06-30"), "s", "s", 5, "dsfgfhgj");
        CruiseDAO.update(cruise);
        assertEquals("solo", CruiseDAO.findCruiseByName("s").getRegions());
    }

    @Test
    public void testDelete() {
        Cruise cruise = new Cruise("s", "s", "Neptune", Date.valueOf("2022-06-25"), Date.valueOf("2022-06-30"), "s", "s", 5, "dsfgfhgj");
        CruiseDAO.delete(cruise);
        assertEquals(null, CruiseDAO.findCruiseByName("s").getName());
    }
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.Report;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Eduard
 */
public class ReportsControllerTest {
    
    public ReportsControllerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of createReport method, of class ReportsController.
     */
    @Test
    public void testCreateReport() {
        System.out.println("createReport");
        int idMeeting = 0;
        String description = "";
        boolean expResult = false;
        boolean result = ReportsController.createReport(idMeeting, description);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAll method, of class ReportsController.
     */
    @Test
    public void testGetAll() throws Exception {
        System.out.println("getAll");
        List<Report> expResult = null;
        List<Report> result = ReportsController.getAll();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getById method, of class ReportsController.
     */
    @Test
    public void testGetById() {
        System.out.println("getById");
        int id = 0;
        Report expResult = null;
        Report result = ReportsController.getById(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getByMeeting method, of class ReportsController.
     */
    @Test
    public void testGetByMeeting() {
        System.out.println("getByMeeting");
        int id = 0;
        Report expResult = null;
        Report result = ReportsController.getByMeeting(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}

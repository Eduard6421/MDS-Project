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
     * Test of getAll method, of class ReportsController.
     */
    @Test
    public void testGetAll() throws Exception {
        System.out.println("getAll");
        List<Report> result = ReportsController.getAll();
        boolean expResult = true;
        boolean trueResult = result.size() == 2;

        assertEquals(expResult, trueResult);
    }

    /**
     * Test of getById method, of class ReportsController.
     */
    @Test
    public void testGetById1() {
        System.out.println("getById");
        int id = 0;
        Report expResult = null;
        Report result = ReportsController.getById(id);
        assertEquals(expResult, result);
    }

    @Test
    public void testGetById2() {
        System.out.println("getById");
        int id = 1;
        boolean expResult = true;
        Report result = ReportsController.getById(id);
        boolean trueResult = result == null;

        assertEquals(expResult, trueResult);
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
    }

}

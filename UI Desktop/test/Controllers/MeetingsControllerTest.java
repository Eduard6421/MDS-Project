/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.Meeting;
import java.sql.Date;
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
public class MeetingsControllerTest {

    public MeetingsControllerTest() {
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
     * Test of createMeeting method, of class MeetingsController.
     */
    @Test
    public void testCreateMeeting() {
        System.out.println("createMeeting");
        int clientId = 0;
        int employeeId = 0;
        Date date = null;
        String Description = "";
        boolean expResult = false;
        boolean result = MeetingsController.createMeeting(clientId, employeeId, date, Description);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAll method, of class MeetingsController.
     */
    
    //Test for Meetings Number of 2
    @Test
    public void testGetAll1() {
        System.out.println("getAll");
        boolean expResult = true;
        List<Meeting> result = MeetingsController.getAll();
        boolean trueResult = (result.size() == 2);   
        assertEquals(expResult, trueResult);
        
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getByClient method, of class MeetingsController.
     */
    @Test
    public void testGetByClient() {
        System.out.println("getByClient");
        int clientId = 1;
        boolean expResult = true;
        Meeting result = MeetingsController.getByClient(clientId);
        boolean trueResult = (result != null);
        
        assertEquals(expResult, trueResult);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of getAllByEmployee method, of class MeetingsController.
     */
    @Test
    public void testGetAllByEmployee() {
        System.out.println("getAllByEmployee");
        int employeeId = 1;
        List<Meeting> expResult = null;
        List<Meeting> result = MeetingsController.getAllByEmployee(employeeId);
        
        boolean trueResult = (result.size() == 2);   
        assertEquals(expResult, trueResult);
        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of getAllOpenedByEmployee method, of class MeetingsController.
     */
    @Test
    public void testGetAllOpenedByEmployee() {
        System.out.println("getAllOpenedByEmployee");
        int employeeId = 0;
        List<Meeting> expResult = null;
        List<Meeting> result = MeetingsController.getAllOpenedByEmployee(employeeId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of getAllClosedByEmployee method, of class MeetingsController.
     */
    @Test
    public void testGetAllClosedByEmployee() {
        System.out.println("getAllClosedByEmployee");
        int employeeId = 0;
        List<Meeting> expResult = null;
        List<Meeting> result = MeetingsController.getAllClosedByEmployee(employeeId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of getByMeeting method, of class MeetingsController.
     */
    @Test
    public void testGetByMeeting() {
        System.out.println("getByMeeting");
        int id = 0;
        Meeting expResult = null;
        Meeting result = MeetingsController.getByMeeting(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

}

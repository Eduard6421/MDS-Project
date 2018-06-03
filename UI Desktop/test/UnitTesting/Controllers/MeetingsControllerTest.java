/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UnitTesting.Controllers;

import Controllers.MeetingsController;
import Models.Meeting;
import Utils.GlobalData;
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
     * Test of getAll method, of class MeetingsController.
     */
    //Test for Meetings Number of 2
    @Test
    public void testGetAll1() {
        System.out.println("getAll");
        boolean expResult = true;
        List<Meeting> result = MeetingsController.getAll(GlobalData.getCompanyName());
        boolean trueResult = (result.size() != 0);
        assertEquals(expResult, trueResult);

        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getAllOpen method, of class MeetingsController.
     */
    @Test
    public void testGetAllOpen1() {
        System.out.println("getAllOpen");
        boolean expResult = true;
        GlobalData.setCompanyName("");
        List<Meeting> result = MeetingsController.getAllOpen(GlobalData.getCompanyName());
        boolean trueResult = (result.size() == 0);
        assertEquals(expResult, trueResult);

        // TODO review the generated test code and remove the default call to fail.
    }

    @Test
    public void testGetAllOpen2() {
        System.out.println("getAllOpen");
        boolean expResult = true;
        GlobalData.setCompanyName("Firma1");
        List<Meeting> result = MeetingsController.getAllOpen(GlobalData.getCompanyName());
        boolean trueResult = (result.size() != 0);
        assertEquals(expResult, trueResult);

        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getAllClosed method, of class MeetingsController.
     */
    @Test
    public void testGetAllClosed1() {
        System.out.println("getAllClosed");
        boolean expResult = true;
        GlobalData.setCompanyName("Firma1");
        List<Meeting> result = MeetingsController.getAllClosed(GlobalData.getCompanyName());
        boolean trueResult = (result.size() == 0);
        assertEquals(expResult, trueResult);

        // TODO review the generated test code and remove the default call to fail.
    }

    @Test
    public void testGetAllClosed2() {
        System.out.println("getAllClosed");
        boolean expResult = false;
        GlobalData.setCompanyName("Firma2");
        List<Meeting> result = MeetingsController.getAllClosed(GlobalData.getCompanyName());
        boolean trueResult = (result.size() == 1);
        assertEquals(expResult, trueResult);

        // TODO review the generated test code and remove the default call to fail.
    }

    @Test
    public void testGetAllClosed3() {
        System.out.println("getAllClosed");
        boolean expResult = true;
        GlobalData.setCompanyName("");
        List<Meeting> result = MeetingsController.getAllClosed(GlobalData.getCompanyName());
        boolean trueResult = result.isEmpty();
        assertEquals(expResult, trueResult);

        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getByClientId method, of class MeetingsController.
     */
    @Test
    public void testGetByClientId1() {
        System.out.println("getByClientId");
        int clientId = 1;
        boolean expResult = true;
        GlobalData.setCompanyName("Firma1");
        Meeting result = MeetingsController.getByClientId(GlobalData.getCompanyName(), clientId);
        boolean trueResult = (result != null);

        assertEquals(expResult, trueResult);
        // TODO review the generated test code and remove the default call to fail.

    }

    @Test
    public void testGetByClientId2() {
        System.out.println("getByClientId");
        int clientId = 0;
        boolean expResult = true;
        Meeting result = MeetingsController.getByClientId(GlobalData.getCompanyName(), clientId);
        boolean trueResult = (result == null);

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
        boolean expResult = true;
        List<Meeting> result = MeetingsController.getAllByEmployee(GlobalData.getCompanyName(), employeeId);

        boolean trueResult = (result.size() == 1);
        assertEquals(expResult, trueResult);

        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getAllOpenedByEmployee method, of class MeetingsController.
     */
    @Test
    public void testGetAllOpenedByEmployee1() {
        System.out.println("getAllOpenedByEmployee");
        int employeeId = 1;
        GlobalData.setCompanyName("Firma1");
        List<Meeting> result = MeetingsController.getAllOpenedByEmployee(GlobalData.getCompanyName(), employeeId);
        boolean expResult = true;
        boolean trueResult = (result.size() == 1);

        assertEquals(expResult, trueResult);
        // TODO review the generated test code and remove the default call to fail.

    }

    @Test
    public void testGetAllOpenedByEmployee2() {
        System.out.println("getAllOpenedByEmployee");
        int employeeId = 2;
        GlobalData.setCompanyName("Firma1");
        List<Meeting> result = MeetingsController.getAllOpenedByEmployee(GlobalData.getCompanyName(), employeeId);
        boolean expResult = true;
        boolean trueResult = (result.size() == 0);

        assertEquals(expResult, trueResult);
        // TODO review the generated test code and remove the default call to fail.

    }

    @Test
    public void testGetAllOpenedByEmployee3() {
        System.out.println("getAllOpenedByEmployee");
        int employeeId = 0;
        List<Meeting> result = MeetingsController.getAllOpenedByEmployee(GlobalData.getCompanyName(), employeeId);
        boolean expResult = true;
        boolean trueResult = (result.size() == 0);

        assertEquals(expResult, trueResult);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of getAllClosedByEmployee method, of class MeetingsController.
     */
    @Test
    public void testGetAllClosedByEmployee1() {
        System.out.println("getAllClosedByEmployee");
        int employeeId = 1;
        GlobalData.setCompanyName("Firma1");
        List<Meeting> result = MeetingsController.getAllClosedByEmployee(GlobalData.getCompanyName(), employeeId);
        boolean expResult = true;
        boolean trueResult = (result.size() == 0);

        assertEquals(expResult, trueResult);
        // TODO review the generated test code and remove the default call to fail.

    }

    @Test
    public void testGetAllClosedByEmployee2() {
        System.out.println("getAllClosedByEmployee");
        int employeeId = 2;
        GlobalData.setCompanyName("Firma1");
        List<Meeting> result = MeetingsController.getAllClosedByEmployee(GlobalData.getCompanyName(), employeeId);
        boolean expResult = true;
        boolean trueResult = (result.size() == 0);

        assertEquals(expResult, trueResult);
        // TODO review the generated test code and remove the default call to fail.

    }

    @Test
    public void testGetAllClosedByEmployee3() {
        System.out.println("getAllClosedByEmployee");
        int employeeId = 0;
        GlobalData.setCompanyName("Firma1");
        List<Meeting> result = MeetingsController.getAllClosedByEmployee(GlobalData.getCompanyName(), employeeId);
        boolean expResult = true;
        boolean trueResult = (result.size() == 0);

        assertEquals(expResult, trueResult);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of getAllOpenByClient method, of class MeetingsController.
     */
    @Test
    public void testGetAllOpenByClient1() {
        System.out.println("getAllOpenByClient");
        GlobalData.setCompanyName("Firma1");
        int clientId = 1;
        List<Meeting> result = MeetingsController.getAllOpenByClient(GlobalData.getCompanyName(), clientId);
        boolean expResult = true;
        boolean trueResult = (result.size() == 1);

        assertEquals(expResult, trueResult);
        // TODO review the generated test code and remove the default call to fail.

    }

    @Test
    public void testGetAllOpenByClient2() {
        System.out.println("getAllOpenByClient");
        int clientId = 2;
        GlobalData.setCompanyName("Firma1");
        List<Meeting> result = MeetingsController.getAllOpenByClient(GlobalData.getCompanyName(), clientId);
        boolean expResult = true;
        boolean trueResult = (result.size() == 0);

        assertEquals(expResult, trueResult);
        // TODO review the generated test code and remove the default call to fail.

    }

    @Test
    public void testGetAllOpenByClient3() {
        System.out.println("getAllOpenByClient");
        int clientId = 0;
        List<Meeting> result = MeetingsController.getAllOpenedByEmployee(GlobalData.getCompanyName(), clientId);
        boolean expResult = true;
        boolean trueResult = (result.size() == 0);

        assertEquals(expResult, trueResult);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of getAllClosedByClient method, of class MeetingsController.
     */
    @Test
    public void testGetAllClosedByClient1() {
        System.out.println("getAllClosedByClient");
        int clientId = 1;
        List<Meeting> result = MeetingsController.getAllClosedByClient(GlobalData.getCompanyName(), clientId);
        boolean expResult = true;
        boolean trueResult = (result.size() == 0);

        assertEquals(expResult, trueResult);
        // TODO review the generated test code and remove the default call to fail.

    }

    @Test
    public void testGetAllClosedByClient2() {
        System.out.println("getAllClosedByClient");
        int clientId = 2;
        GlobalData.setCompanyName("Firma1");
        List<Meeting> result = MeetingsController.getAllClosedByClient(GlobalData.getCompanyName(), clientId);
        boolean expResult = true;
        boolean trueResult = (result.size() == 0);

        assertEquals(expResult, trueResult);
        // TODO review the generated test code and remove the default call to fail.

    }

    @Test
    public void testGetAllClosedByClient3() {
        System.out.println("getAllClosedByClient");
        int clientId = 0;
        List<Meeting> result = MeetingsController.getAllClosedByClient(GlobalData.getCompanyName(), clientId);
        boolean expResult = true;
        boolean trueResult = (result.size() == 0);

        assertEquals(expResult, trueResult);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of getByMeeting method, of class MeetingsController.
     */
    @Test
    public void testGetByMeeting1() {
        System.out.println("getByMeeting");
        int meetingId = 1;
        boolean expResult = true;
        Meeting result = MeetingsController.getByMeeting(meetingId);
        boolean trueResult = (result != null);

        assertEquals(expResult, trueResult);
        // TODO review the generated test code and remove the default call to fail.

    }

    @Test
    public void testGetByMeeting2() {
        System.out.println("getByMeeting");
        int meetingId = 0;
        boolean expResult = true;
        Meeting result = MeetingsController.getByMeeting(meetingId);
        boolean trueResult = (result == null);

        assertEquals(expResult, trueResult);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of getPercentUnassigned method, of class MeetingsController.
     */
    @Test
    public void testGetPercentUnassigned1() {
        System.out.println("getPercentUnassigned");
        GlobalData.setCompanyName("Firma1");
        Double result = MeetingsController.getPercentUnassigned(GlobalData.getCompanyName());
        boolean expResult = true;
        boolean trueResult = result.equals(100.0d);

        assertEquals(expResult, trueResult);
    }

    @Test
    public void testGetPercentUnassigned2() {
        System.out.println("getPercentUnassigned");
        GlobalData.setCompanyName("Firma2");
        Double result = MeetingsController.getPercentUnassigned(GlobalData.getCompanyName());
        boolean expResult = true;
        boolean trueResult = result.equals(100.0d);

        assertEquals(expResult, trueResult);
    }

}

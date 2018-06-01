/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

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
        boolean trueResult = (result.size() == 2);
        assertEquals(expResult, trueResult);

        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getByClient method, of class MeetingsController.
     */
    @Test
    public void testGetByClient1() {
        System.out.println("getByClient");
        int clientId = 1;
        boolean expResult = true;
        Meeting result = MeetingsController.getByClientId(GlobalData.getCompanyName(), clientId);
        boolean trueResult = (result != null);

        assertEquals(expResult, trueResult);
        // TODO review the generated test code and remove the default call to fail.

    }

    @Test
    public void testGetByClient2() {
        System.out.println("getByClient");
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
        boolean expResult = false;
        List<Meeting> result = MeetingsController.getAllByEmployee(GlobalData.getCompanyName(), employeeId);

        boolean trueResult = (result.size() == 2);
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
        List<Meeting> result = MeetingsController.getAllOpenedByEmployee(GlobalData.getCompanyName(), employeeId);
        boolean expResult = true;
        boolean trueResult = (result.size() == 1);

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

}

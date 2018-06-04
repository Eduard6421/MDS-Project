/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IntegrationTesting.Controllers;
import Controllers.NotificationsController;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
/**
 *
 * @author user
 */
public class NotificationsControllerTest {
    public NotificationsControllerTest()
    {
        
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
     * Test of getNotificationByClientId method, of class ClientContractsController.
     */
    @Test
    public void testGetNotificationByClientId1()
    {
        System.out.println("getNotificationByClientId");
        int id = 0;
        boolean expResult = false;
        boolean trueResult = NotificationsController.getNotificationByClientId(id);
        
        assertEquals(expResult,trueResult);
    }
    @Test
    public void testGetNotificationByClientId2()
    {
        System.out.println("getNotificationByClientId");
        int id = 1;
        boolean expResult = true;
        boolean trueResult = NotificationsController.getNotificationByClientId(id);
        
        assertEquals(expResult,trueResult);
    }
    /**
     * Test of getNotificationByEmployeeId method, of class ClientContractsController.
     */
    @Test
    public void testGetNotificationByEmployeeId1()
    {
        System.out.println("getNotificationByEmployeeId");
        int id = 0;
        boolean expResult = false;
        boolean trueResult = NotificationsController.getNotificationByEmployeeId(id);
        
        assertEquals(expResult,trueResult);
    }
    @Test
    public void testGetNotificationByEmployeeId2()
    {
        System.out.println("getNotificationByEmployeeId");
        int id = 1;
        boolean expResult = true;
        boolean trueResult = NotificationsController.getNotificationByEmployeeId(id);
        
        assertEquals(expResult,trueResult);
    }
}

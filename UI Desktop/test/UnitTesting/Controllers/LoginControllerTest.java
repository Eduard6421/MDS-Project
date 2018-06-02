/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UnitTesting.Controllers;

import Controllers.LoginController;
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
public class LoginControllerTest {
    
    public LoginControllerTest() {
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
     * Test of connectClient method, of class LoginController.
     */
    @Test
    public void testConnectClient1() {
        System.out.println("connectClient");
        String username = "";
        String password = "";
        boolean expResult = false;
        boolean result = LoginController.connectClient(username, password);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }
    
    @Test
    public void testConnectClient2()
    {
        System.out.println("connectClient");
        String username = "1";
        String password = "1";
        boolean expResult = true;
        boolean result = LoginController.connectClient(username, password);
        assertEquals(expResult, result);
        
    }
    
    
     @Test
    public void testConnectClient3()
    {
        System.out.println("connectClient");
        String username = "1";
        String password = "OR 1=1;";
        boolean expResult = false;
        boolean result = LoginController.connectClient(username, password);
        assertEquals(expResult, result);
        
    }
    
    /**
     * Test of connectEmployee method, of class LoginController.
     */
    @Test
    public void testConnectEmployee1() {
        System.out.println("connectEmployee");
        String username = "";
        String password = "";
        boolean expResult = false;
        boolean result = LoginController.connectEmployee(username, password);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testConnectEmployee2() {
        System.out.println("connectEmployee");
        String username = "employee1";
        String password = "employee1";
        boolean expResult = true;
        boolean result = LoginController.connectEmployee(username, password);
        assertEquals(expResult, result);
    }
    @Test
    public void testConnectEmployee3() {
        System.out.println("connectEmployee");
        String username = "asd";
        String password = ";select*fromclients";
        boolean expResult = false;
        boolean result = LoginController.connectEmployee(username, password);
        assertEquals(expResult, result);
    }
    
    
    @Test
    public void testConnectEmployee4() {
        System.out.println("connectEmployee");
        String username = "";
        String password = "";
        boolean expResult = false;
        boolean result = LoginController.connectEmployee(username, password);
        assertEquals(expResult, result);
    }
    
    
    @Test
    public void testConnectEmployee5() {
        System.out.println("connectEmployee");
        String username = "";
        String password = "OR 1=1;";
        boolean expResult = false;
        boolean result = LoginController.connectEmployee(username, password);
        assertEquals(expResult, result);
    }
    

    /**
     * Test of connectCompany method, of class LoginController.
     */
    @Test
    public void testConnectCompany1() {
        System.out.println("connectCompany");
        String username = "";
        String password = "";
        boolean expResult = false;
        boolean result = LoginController.connectCompany(username, password);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testConnectCompany2() {
        System.out.println("connectCompany");
        String username = "firma1";
        String password = "parola1";
        boolean expResult = true;
        boolean result = LoginController.connectCompany(username, password);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testConnectCompany3() {
        System.out.println("connectCompany");
        String username = "firma1";
        String password = "parola2";
        boolean expResult = false;
        boolean result = LoginController.connectCompany(username, password);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testConnectCompany4() {
        System.out.println("connectCompany");
        String username = "firma1";
        String password = "parola2 OR 1=1";
        boolean expResult = false;
        boolean result = LoginController.connectCompany(username, password);
        assertEquals(expResult, result);
    }
    
}

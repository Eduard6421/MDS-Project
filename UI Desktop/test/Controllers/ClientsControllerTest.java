/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.Client;
import java.util.List;
import javafx.util.Pair;
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
public class ClientsControllerTest {
    
    public ClientsControllerTest() {
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
     * Test of registerClient method, of class ClientsController.
     */
    @Test
    public void testRegisterClient() {
        System.out.println("registerClient");
        String firstName = "";
        String lastName = "";
        String userName = "";
        String userPassword = "";
        String address = "";
        String phone = "";
        String email = "";
        boolean expResult = false;
        boolean result = ClientsController.registerClient(firstName, lastName, userName, userPassword, address, phone, email);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getByAccount method, of class ClientsController.
     */
    @Test
    public void testGetByAccount() {
        System.out.println("getByAccount");
        String username = "";
        String password = "";
        Client expResult = null;
        Client result = ClientsController.getByAccount(username, password);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getByUsername method, of class ClientsController.
     */
    @Test
    public void testGetByUsername() {
        System.out.println("getByUsername");
        String username = "";
        Client expResult = null;
        Client result = ClientsController.getByUsername(username);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getById method, of class ClientsController.
     */
    @Test
    public void testGetById() {
        System.out.println("getById");
        int id = 0;
        Client expResult = null;
        Client result = ClientsController.getById(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of changePassword method, of class ClientsController.
     */
    @Test
    public void testChangePassword() {
        System.out.println("changePassword");
        String oldPassword = "";
        String newPassword = "";
        boolean expResult = false;
        boolean result = ClientsController.changePassword(oldPassword, newPassword);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateData method, of class ClientsController.
     */
    @Test
    public void testUpdateData() {
        System.out.println("updateData");
        String email = "";
        String phoneNumber = "";
        boolean expResult = false;
        boolean result = ClientsController.updateData(email, phoneNumber);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAll method, of class ClientsController.
     */
    @Test
    public void testGetAll() throws Exception {
        System.out.println("getAll");
        List<Client> expResult = null;
        List<Client> result = ClientsController.getAll();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAllOnlyGeneralData method, of class ClientsController.
     */
    @Test
    public void testGetAllOnlyGeneralData() throws Exception {
        System.out.println("getAllOnlyGeneralData");
        List<Pair<Integer, String>> expResult = null;
        List<Pair<Integer, String>> result = ClientsController.getAllOnlyGeneralData();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}

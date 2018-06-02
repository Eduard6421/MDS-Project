/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IntegrationTesting.Controllers;

import Controllers.ClientsController;
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
     * Test of getByAccount method, of class ClientsController.
     */
    @Test
    public void testGetByAccount1() {
        System.out.println("getByAccount");
        String username = "%";
        String password = "%";
        Client expResult = null;
        Client result = ClientsController.getByAccount(username, password);
        assertEquals(expResult, result);
    }

    @Test
    public void testGetByAccount2() {
        System.out.println("getByAccount");
        String username = "";
        String password = ";OR 1=1";
        Client expResult = null;
        Client result = ClientsController.getByAccount(username, password);
        assertEquals(expResult, result);
    }

    @Test
    public void testGetByAccount3() {
        System.out.println("getByAccount");
        String username = "client1";
        String password = "parolaclient1";
        boolean expResult = true;
        Client result = ClientsController.getByAccount(username, password);
        boolean trueResult = result != null;

        assertEquals(expResult, trueResult);
    }

    /**
     * Test of getByUsername method, of class ClientsController.
     */
    @Test
    public void testGetByUsername() {
        System.out.println("getByUsername");
        String username = ";OR1=1";
        Client expResult = null;
        Client result = ClientsController.getByUsername(username);
        assertEquals(expResult, result);
    }

    @Test
    public void testGetByUsername2() {
        System.out.println("getByUsername");
        String username = "%";
        Client expResult = null;
        Client result = ClientsController.getByUsername(username);
        assertEquals(expResult, result);
    }

    @Test
    public void testGetByUsername3() {
        System.out.println("getByUsername");
        String username = ";OR USER_NAME LIKE '%'";
        Client expResult = null;
        Client result = ClientsController.getByUsername(username);
        assertEquals(expResult, result);
    }

    /**
     * Test of getById method, of class ClientsController.
     */
    @Test
    public void testGetById1() {
        System.out.println("getById");
        int id = 0;
        Client expResult = null;
        Client result = ClientsController.getById(id);
        assertEquals(expResult, result);
    }

    @Test
    public void testGetById2() {
        System.out.println("getById");
        int id = 1;
        boolean expResult = true;
        Client result = ClientsController.getById(id);
        boolean trueResult = result != null;

        assertEquals(expResult, trueResult);
    }
     /**
     * Test of getById method, of class ClientsController.
     */
    @Test
    public void testGetAll() throws Exception {
        System.out.println("getAll");
        String companyname="Firma1";
        List <Client> result = ClientsController.getAll(companyname);
        boolean expResult = true;
        boolean trueResult = result.size() == 2;

        assertEquals(expResult, trueResult);
    }

}

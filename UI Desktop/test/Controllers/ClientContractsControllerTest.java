/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.ClientContract;
import java.util.Date;
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
public class ClientContractsControllerTest {

    public ClientContractsControllerTest() {
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
     * Test of getById method, of class ClientContractsController.
     */
    @Test
    public void testGetById1() {
        System.out.println("getById");
        int id = 0;
        ClientContract expResult = null;
        ClientContract result = ClientContractsController.getById(id);
        assertEquals(expResult, result);

    }

    @Test
    public void testGetById2() {
        System.out.println("getById");
        int id = 1;
        boolean expResult = true;
        ClientContract result = ClientContractsController.getById(id);
        boolean trueResult = result != null;
        assertEquals(expResult, trueResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getByClient method, of class ClientContractsController.
     */
    @Test
    public void testGetByClient() {
        System.out.println("getByClient");
        int id = 0;
        List<ClientContract> expResult = null;
        List<ClientContract> result = ClientContractsController.getByClient(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getByCompany method, of class ClientContractsController.
     */
    @Test
    public void testGetByCompany() {
        System.out.println("getByCompany");
        int id = 0;
        List<ClientContract> expResult = null;
        List<ClientContract> result = ClientContractsController.getByCompany(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}

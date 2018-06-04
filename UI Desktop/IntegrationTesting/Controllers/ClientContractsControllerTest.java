/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IntegrationTesting.Controllers;

import Controllers.ClientContractsController;
import Controllers.ClientsController;
import Models.ClientContract;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
        String aux = "(112011-02-022012-02-02)";
        boolean trueResult = aux.equals(result.toString());
        assertEquals(expResult, trueResult);
    }

    /**
     * Test of getByClient method, of class ClientContractsController.
     */
    @Test
    public void testGetByClient1() {
        System.out.println("getByClient");
        int id = 0;
        List<ClientContract> result = ClientContractsController.getByClient(id);
        boolean trueResult = result.isEmpty();
        boolean expResult = true;
        assertEquals(expResult, trueResult);
    }

    @Test
    public void testGetByClient2() {
        System.out.println("getByClient");
        int id = 1;
        List<ClientContract> result = ClientContractsController.getByClient(id);
        String aux = "[(112011-02-022012-02-02)]";
        boolean trueResult = aux.equals(result.toString());
        boolean expResult = true;
        assertEquals(expResult, trueResult);
    }

    /**
     * Test of getByCompany method, of class ClientContractsController.
     */
    @Test
    public void testGetByCompany1() {
        System.out.println("getByCompany");
        int id = 0;
        List<ClientContract> result = ClientContractsController.getByCompany(id);
        boolean trueResult = result.size() == 0;
        boolean expResult = true;
        assertEquals(expResult, trueResult);
    }

    @Test
    public void testGetByCompany2() {
        System.out.println("getByCompany");
        int id = 1;
        List<ClientContract> result = ClientContractsController.getByCompany(id);
        String aux = "[(112011-02-022012-02-02), (212012-02-032014-02-02)]";
        boolean trueResult = aux.equals(result.toString());
        boolean expResult = true;
        assertEquals(expResult, trueResult);
    }

    /**
     * Test of getAllOnlyGeneralData method, of class ClientsController.
     */
    @Test
    public void testGetAllOnlyGeneralData1() {
        System.out.println("getAllOnlyGeneralData");
        List<Pair<Integer, String>> result = null;
        try {
            result = ClientsController.getAllOnlyGeneralData("");
        } catch (SQLException ex) {
            Logger.getLogger(ClientsControllerTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        boolean expResult = true;
        boolean trueResult = result.size() == 0;

        assertEquals(expResult, trueResult);
    }

    @Test
    public void testGetAllOnlyGeneralData2() {
        System.out.println("getAllOnlyGeneralData");
        List<Pair<Integer, String>> result = null;
        try {
            result = ClientsController.getAllOnlyGeneralData("Firma1");
        } catch (SQLException ex) {
            Logger.getLogger(ClientsControllerTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        String aux = "[1=client1, 2=client2]";
        boolean expResult = true;
        boolean trueResult = aux.equals(result.toString());

        assertEquals(expResult, trueResult);
    }
}

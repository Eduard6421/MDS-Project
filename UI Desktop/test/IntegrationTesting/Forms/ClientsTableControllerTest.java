/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IntegrationTesting.Forms;

import Forms.Controllers.ClientsTableController;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
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
public class ClientsTableControllerTest {
    
    public ClientsTableControllerTest() {
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
     * Test of actionPerformed method, of class ClientsTableController.
     */
    @Test
    public void testActionPerformed() throws SQLException {
        System.out.println("actionPerformed");
        ActionEvent evt = null;
        ClientsTableController instance = new ClientsTableController();
        instance.actionPerformed(evt);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toggleFocus method, of class ClientsTableController.
     */
    @Test
    public void testToggleFocus() throws SQLException {
        System.out.println("toggleFocus");
        ClientsTableController instance = new ClientsTableController();
        instance.toggleFocus();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setWindowInvisible method, of class ClientsTableController.
     */
    @Test
    public void testSetWindowInvisible() throws SQLException {
        System.out.println("setWindowInvisible");
        ClientsTableController instance = new ClientsTableController();
        instance.setWindowInvisible();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setWindowVisible method, of class ClientsTableController.
     */
    @Test
    public void testSetWindowVisible() throws SQLException {
        System.out.println("setWindowVisible");
        ClientsTableController instance = new ClientsTableController();
        instance.setWindowVisible();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of closeWindow method, of class ClientsTableController.
     */
    @Test
    public void testCloseWindow() throws SQLException{
        System.out.println("closeWindow");
        ClientsTableController instance = new ClientsTableController();
        instance.closeWindow();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of fillTable method, of class ClientsTableController.
     */
    @Test
    public void testFillTable() throws Exception {
        System.out.println("fillTable");
        ClientsTableController instance = new ClientsTableController();
        instance.fillTable();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}

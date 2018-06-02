/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IntegrationTesting.Forms;

import Forms.Controllers.EmployeesTableController;
import java.awt.event.ActionEvent;
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
public class EmployeesTableControllerTest {
    
    public EmployeesTableControllerTest() {
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
     * Test of actionPerformed method, of class EmployeesTableController.
     */
    @Test
    public void testActionPerformed() {
        System.out.println("actionPerformed");
        ActionEvent evt = null;
        EmployeesTableController instance = new EmployeesTableController();
        instance.actionPerformed(evt);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toggleFocus method, of class EmployeesTableController.
     */
    @Test
    public void testToggleFocus() {
        System.out.println("toggleFocus");
        EmployeesTableController instance = new EmployeesTableController();
        instance.toggleFocus();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setWindowInvisible method, of class EmployeesTableController.
     */
    @Test
    public void testSetWindowInvisible() {
        System.out.println("setWindowInvisible");
        EmployeesTableController instance = new EmployeesTableController();
        instance.setWindowInvisible();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }   

    /**
     * Test of setWindowVisible method, of class EmployeesTableController.
     */
    @Test
    public void testSetWindowVisible() {
        System.out.println("setWindowVisible");
        EmployeesTableController instance = new EmployeesTableController();
        instance.setWindowVisible();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of closeWindow method, of class EmployeesTableController.
     */
    @Test
    public void testCloseWindow() {
        System.out.println("closeWindow");
        EmployeesTableController instance = new EmployeesTableController();
        instance.closeWindow();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of fillTable method, of class EmployeesTableController.
     */
    @Test
    public void testFillTable() throws Exception {
        System.out.println("fillTable");
        EmployeesTableController instance = new EmployeesTableController();
        instance.fillTable();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}

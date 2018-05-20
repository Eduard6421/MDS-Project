/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Forms.Controllers;

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
public class EmployeeMenuControllerTest {
    
    public EmployeeMenuControllerTest() {
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
     * Test of actionPerformed method, of class EmployeeMenuController.
     */
    @Test
    public void testActionPerformed() {
        System.out.println("actionPerformed");
        ActionEvent evt = null;
        EmployeeMenuController instance = new EmployeeMenuController();
        instance.actionPerformed(evt);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toggleFocus method, of class EmployeeMenuController.
     */
    @Test
    public void testToggleFocus() {
        System.out.println("toggleFocus");
        EmployeeMenuController instance = new EmployeeMenuController();
        instance.toggleFocus();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setWindowInvisible method, of class EmployeeMenuController.
     */
    @Test
    public void testSetWindowInvisible() {
        System.out.println("setWindowInvisible");
        EmployeeMenuController instance = new EmployeeMenuController();
        instance.setWindowInvisible();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setWindowVisible method, of class EmployeeMenuController.
     */
    @Test
    public void testSetWindowVisible() {
        System.out.println("setWindowVisible");
        EmployeeMenuController instance = new EmployeeMenuController();
        instance.setWindowVisible();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of closeWindow method, of class EmployeeMenuController.
     */
    @Test
    public void testCloseWindow() {
        System.out.println("closeWindow");
        EmployeeMenuController instance = new EmployeeMenuController();
        instance.closeWindow();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}

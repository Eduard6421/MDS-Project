/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UnitTesting.Forms;

import Forms.Controllers.CompanyMenuController;
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
public class CompanyMenuControllerTest {
    
    public CompanyMenuControllerTest() {
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
     * Test of actionPerformed method, of class CompanyMenuController.
     */
    

    
    @Test
    public void testActionPerformed() {
        System.out.println("actionPerformed");
        ActionEvent evt = null;
        CompanyMenuController instance = new CompanyMenuController();
        instance.actionPerformed(evt);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toggleFocus method, of class CompanyMenuController.
     */
    @Test
    public void testToggleFocus() {
        System.out.println("toggleFocus");
        CompanyMenuController instance = new CompanyMenuController();
        instance.toggleFocus();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setWindowInvisible method, of class CompanyMenuController.
     */
    @Test
    public void testSetWindowInvisible() {
        System.out.println("setWindowInvisible");
        CompanyMenuController instance = new CompanyMenuController();
        instance.setWindowInvisible();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setWindowVisible method, of class CompanyMenuController.
     */
    @Test
    public void testSetWindowVisible() {
        System.out.println("setWindowVisible");
        CompanyMenuController instance = new CompanyMenuController();
        instance.setWindowVisible();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of closeWindow method, of class CompanyMenuController.
     */
    @Test
    public void testCloseWindow() {
        System.out.println("closeWindow");
        CompanyMenuController instance = new CompanyMenuController();
        instance.closeWindow();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IntegrationTesting.Forms;

import Forms.Controllers.LoginController;
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
     * Test of actionPerformed method, of class LoginController.
     */
    @Test
    public void testActionPerformed() {
        System.out.println("actionPerformed");
        ActionEvent evt = null;
        LoginController instance = new LoginController();
        instance.actionPerformed(evt);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setWindowInvisible method, of class LoginController.
     */
    @Test
    public void testSetWindowInvisible() {
        System.out.println("setWindowInvisible");
        LoginController instance = new LoginController();
        instance.setWindowInvisible();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setWindowVisible method, of class LoginController.
     */
    @Test
    public void testSetWindowVisible() {
        System.out.println("setWindowVisible");
        LoginController instance = new LoginController();
        instance.setWindowVisible();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of closeWindow method, of class LoginController.
     */
    @Test
    public void testCloseWindow() {
        System.out.println("closeWindow");
        LoginController instance = new LoginController();
        instance.closeWindow();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toggleFocus method, of class LoginController.
     */
    @Test
    public void testToggleFocus() {
        System.out.println("toggleFocus");
        LoginController instance = new LoginController();
        instance.toggleFocus();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of displayConnectionError method, of class LoginController.
     */
    @Test
    public void testDisplayConnectionError() {
        System.out.println("displayConnectionError");
        LoginController instance = new LoginController();
        instance.displayConnectionError();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}

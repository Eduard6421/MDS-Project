/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IntegrationTesting.Forms;

import Forms.Controllers.CompanyMenuController;
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
    public void testLogin1()
    {
        LoginController controller = new LoginController();
        String user = controller.getForm().getUsername();
        String pass = controller.getForm().getPassword();
        boolean expResult = false;
        boolean trueResult = Controllers.LoginController.connectCompany(user, pass);
        CompanyMenuController companyMenuController = new CompanyMenuController(controller);
        
        assertEquals(expResult,trueResult);   
    }
    @Test
    public void testLogin2()
    {
        LoginController controller = new LoginController();
        String user = "firma1";
        String pass = "parola1";
        boolean expResult = true;
        boolean trueResult = Controllers.LoginController.connectCompany(user, pass);
        CompanyMenuController companyMenuController = new CompanyMenuController(controller);
        
        assertEquals(expResult,trueResult);   
    }
     public void testLogin3()
    {
        LoginController controller = new LoginController();
        String user = "firma2";
        String pass = "parola2";
        boolean expResult = true;
        boolean trueResult = Controllers.LoginController.connectCompany(user, pass);
        CompanyMenuController companyMenuController = new CompanyMenuController(controller);
        
        assertEquals(expResult,trueResult);   
    }
    
}

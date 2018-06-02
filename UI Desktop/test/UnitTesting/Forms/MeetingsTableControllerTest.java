/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UnitTesting.Forms;

import Forms.Controllers.MeetingsTableController;
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
public class MeetingsTableControllerTest {
    
    public MeetingsTableControllerTest() {
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
     * Test of actionPerformed method, of class MeetingsTableController.
     */
    @Test
    public void testActionPerformed() {
        System.out.println("actionPerformed");
        ActionEvent evt = null;
        MeetingsTableController instance = new MeetingsTableController();
        instance.actionPerformed(evt);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of populateClientsList method, of class MeetingsTableController.
     */
    @Test
    public void testPopulateClientsList() {
        System.out.println("populateClientsList");
        MeetingsTableController instance = new MeetingsTableController();
        instance.populateClientsList();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of populateEmployeesList method, of class MeetingsTableController.
     */
    @Test
    public void testPopulateEmployeesList() {
        System.out.println("populateEmployeesList");
        MeetingsTableController instance = new MeetingsTableController();
        instance.populateEmployeesList();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toggleFocus method, of class MeetingsTableController.
     */
    @Test
    public void testToggleFocus() {
        System.out.println("toggleFocus");
        MeetingsTableController instance = new MeetingsTableController();
        instance.toggleFocus();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setWindowInvisible method, of class MeetingsTableController.
     */
    @Test
    public void testSetWindowInvisible() {
        System.out.println("setWindowInvisible");
        MeetingsTableController instance = new MeetingsTableController();
        instance.setWindowInvisible();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setWindowVisible method, of class MeetingsTableController.
     */
    @Test
    public void testSetWindowVisible() {
        System.out.println("setWindowVisible");
        MeetingsTableController instance = new MeetingsTableController();
        instance.setWindowVisible();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of closeWindow method, of class MeetingsTableController.
     */
    @Test
    public void testCloseWindow() {
        System.out.println("closeWindow");
        MeetingsTableController instance = new MeetingsTableController();
        instance.closeWindow();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of fillTable method, of class MeetingsTableController.
     */
    @Test
    public void testFillTable() {
        System.out.println("fillTable");
        String tableType = "";
        MeetingsTableController instance = new MeetingsTableController();
        instance.fillTable(tableType);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findEmployeeNameById method, of class MeetingsTableController.
     */
    @Test
    public void testFindEmployeeNameById() {
        System.out.println("findEmployeeNameById");
        int id = 0;
        MeetingsTableController instance = new MeetingsTableController();
        String expResult = "";
        String result = instance.findEmployeeNameById(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findClientNameById method, of class MeetingsTableController.
     */
    @Test
    public void testFindClientNameById() {
        System.out.println("findClientNameById");
        int id = 0;
        MeetingsTableController instance = new MeetingsTableController();
        String expResult = "";
        String result = instance.findClientNameById(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.Employee;
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
public class EmployeesControllerTest {
    
    public EmployeesControllerTest() {
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
     * Test of registerEmployee method, of class EmployeesController.
     */
    @Test
    public void testRegisterEmployee() {
        System.out.println("registerEmployee");
        String firstName = "";
        String lastName = "";
        String userName = "";
        String password = "";
        String phone = "";
        String email = "";
        boolean expResult = false;
        boolean result = EmployeesController.registerEmployee(firstName, lastName, userName, password, phone, email);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getByAccount method, of class EmployeesController.
     */
    @Test
    public void testGetByAccount() {
        System.out.println("getByAccount");
        String username = "";
        String password = "";
        Employee expResult = null;
        Employee result = EmployeesController.getByAccount(username, password);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getByUsername method, of class EmployeesController.
     */
    @Test
    public void testGetByUsername() {
        System.out.println("getByUsername");
        String username = "";
        Employee expResult = null;
        Employee result = EmployeesController.getByUsername(username);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getById method, of class EmployeesController.
     */
    @Test
    public void testGetById() {
        System.out.println("getById");
        int id = 0;
        Employee expResult = null;
        Employee result = EmployeesController.getById(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of changePassword method, of class EmployeesController.
     */
    @Test
    public void testChangePassword() {
        System.out.println("changePassword");
        String oldPassword = "";
        String newPassword = "";
        boolean expResult = false;
        boolean result = EmployeesController.changePassword(oldPassword, newPassword);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateData method, of class EmployeesController.
     */
    @Test
    public void testUpdateData() {
        System.out.println("updateData");
        String email = "";
        String phoneNumber = "";
        boolean expResult = false;
        boolean result = EmployeesController.updateData(email, phoneNumber);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAll method, of class EmployeesController.
     */
    @Test
    public void testGetAll() throws Exception {
        System.out.println("getAll");
        List<Employee> expResult = null;
        List<Employee> result = EmployeesController.getAll();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAllOnlyGeneralData method, of class EmployeesController.
     */
    @Test
    public void testGetAllOnlyGeneralData() throws Exception {
        System.out.println("getAllOnlyGeneralData");
        List<Pair<Integer, String>> expResult = null;
        List<Pair<Integer, String>> result = EmployeesController.getAllOnlyGeneralData();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}

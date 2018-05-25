/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.Company;
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
public class CompaniesControllerTest {
    
    public CompaniesControllerTest() {
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
     * Test of getByAccount method, of class CompaniesController.
     */
    @Test
    public void testGetByAccount() {
        System.out.println("getByAccount");
        String username = "";
        String password = "";
        Company expResult = null;
        Company result = CompaniesController.getByAccount(username, password);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getByUsername method, of class CompaniesController.
     */
    @Test
    public void testGetByUsername() {
        System.out.println("getByUsername");
        String username = "";
        Company expResult = null;
        Company result = CompaniesController.getByUsername(username);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getById method, of class CompaniesController.
     */
    @Test
    public void testGetById() {
        System.out.println("getById");
        int id = 0;
        Company expResult = null;
        Company result = CompaniesController.getById(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}

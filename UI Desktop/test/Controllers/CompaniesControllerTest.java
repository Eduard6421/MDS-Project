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
    public void testGetByAccount1() {
        System.out.println("getByAccount");
        String username = "";
        String password = "";
        Company expResult = null;
        Company result = CompaniesController.getByAccount(username, password);
        assertEquals(expResult, result);
    }

    @Test
    public void testGetByAccount2() {
        System.out.println("getByAccount");
        String username = "";
        String password = "; OR 1=1";
        Company expResult = null;
        Company result = CompaniesController.getByAccount(username, password);
        assertEquals(expResult, result);
    }

    @Test
    public void testGetByAccount3() {
        System.out.println("getByAccount");
        String username = "firma1";
        String password = "parola1";

        boolean expResult = true;
        Company result = CompaniesController.getByAccount(username, password);
        boolean trueResult = (result != null);
        assertEquals(expResult, trueResult);
    }

    /**
     * Test of getByUsername method, of class CompaniesController.
     */
    @Test
    public void testGetByUsername1() {
        System.out.println("getByUsername");
        String username = ";OR 1=1";
        Company expResult = null;
        Company result = CompaniesController.getByUsername(username);
        assertEquals(expResult, result);
    }
    @Test
    public void testGetByUsername2() {
        System.out.println("getByUsername");
        String username = "%";
        Company expResult = null;
        Company result = CompaniesController.getByUsername(username);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testGetByUsername3() {
        System.out.println("getByUsername");
        String username = "firma1";
        boolean expResult = true;
        Company result = CompaniesController.getByUsername(username);
        boolean trueResult = result!= null;
        assertEquals(expResult, trueResult);
    }
    /**
     * Test of getByName method, of class CompaniesController.
     */
     @Test
    public void testGetByName1() {
        System.out.println("getByName");
        String name = "%";
        Company expResult = null;
        Company result = CompaniesController.getByName(name);
        assertEquals(expResult, result);
    }
    @Test
    public void testGetByName2() {
        System.out.println("getByName");
        String name = "Firma1";
        boolean expResult = true;
        Company result = CompaniesController.getByName(name);
        boolean trueResult = result!= null;
        assertEquals(expResult, trueResult);
    }
    

    /**
     * Test of getById method, of class CompaniesController.
     */
    @Test
    public void testGetById1() {
        System.out.println("getById");
        int id = 0;
        Company expResult = null;
        Company result = CompaniesController.getById(id);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testGetById2() {
        System.out.println("getById");
        int id = 1;
        boolean expResult = true;
        Company result = CompaniesController.getById(id);
        boolean trueResult = result!=null;
        assertEquals(expResult, trueResult);
    }
    

}

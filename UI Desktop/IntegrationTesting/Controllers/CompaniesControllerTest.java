/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IntegrationTesting.Controllers;

import Controllers.CompaniesController;
import Models.Company;
import java.util.List;
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
        String username = "firma1";
        String password = "parola1";

        boolean expResult = true;
        Company result = CompaniesController.getByAccount(username, password);
        String aux = "(Firma1firma1parola12011-04-022012-04-02asd)";
        boolean trueResult = aux.equals(result.toString());
        assertEquals(expResult, trueResult);
    }

    /**
     * Test of getByUsername method, of class CompaniesController.
     */
 
    @Test
    public void testGetByUsername1() {
        System.out.println("getByUsername");
        String username = "";
        Company expResult = null;
        Company result = CompaniesController.getByUsername(username);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testGetByUsername3() {
        System.out.println("getByUsername");
        String username = "firma2";
        boolean expResult = true;
        Company result = CompaniesController.getByUsername(username);
        String aux = "(Firma2firma2parola22012-04-052014-05-12asd1)";
        boolean trueResult = aux.equals(result.toString());
        assertEquals(expResult, trueResult);
    }
    /**
     * Test of getByName method, of class CompaniesController.
     */
     @Test
    public void testGetByName1() {
        System.out.println("getByName");
        String name = "";
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
        String aux = "(Firma1firma1parola12011-04-022012-04-02asd)";
        boolean trueResult = aux.equals(result.toString());
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
        String aux = "(Firma1firma1parola12011-04-022012-04-02asd)";
        boolean trueResult = aux.equals(result.toString());
        assertEquals(expResult, trueResult);
    }
    /**
     * Test of getAll method, of class CompaniesController.
     */
    @Test
    public void testGetAll1() {
        System.out.println("getAll");
        boolean expResult = true;
        List<Company> result = CompaniesController.getAll();
        String aux = "[(Firma1firma1parola12011-04-022012-04-02asd), (Firma2firma2parola22012-04-052014-05-12asd1)]";
        boolean trueResult = aux.equals(result.toString());
        assertEquals(expResult,trueResult);
    }
    
   
    

}

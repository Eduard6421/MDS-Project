/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.EmployeeContract;
import java.sql.Date;
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
public class EmployeeContractsControllerTest {

    public EmployeeContractsControllerTest() {
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
     * Test of getById method, of class EmployeeContractsController.
     */
    @Test
    public void testGetById1() {
        System.out.println("getById");
        int id = 0;
        EmployeeContract expResult = null;
        EmployeeContract result = EmployeeContractsController.getById(id);
        assertEquals(expResult, result);
    }
   @Test
    public void testGetById2() {
        System.out.println("getById");
        int id = 100;
        EmployeeContract expResult = null;
        EmployeeContract result = EmployeeContractsController.getById(id);
        assertEquals(expResult, result);
    }
   @Test
    public void testGetById3() {
        System.out.println("getById");
        int id = 1;
        boolean expResult = true;
        EmployeeContract result = EmployeeContractsController.getById(id);
        boolean trueResult = result != null;
        assertEquals(expResult, trueResult);
    }

    /**
     * Test of getByEmployee method, of class EmployeeContractsController.
     */
    @Test
    public void testGetByEmployee1() {
        System.out.println("getByEmployee");
        int id = 0;

        List<EmployeeContract> result = EmployeeContractsController.getByEmployee(id);
        boolean expResult = true;
        boolean trueResult = (result.size() == 0);

        assertEquals(expResult, trueResult);
    }
       @Test
    public void testGetByEmployee2() {
        System.out.println("getByEmployee");
        int id = 1;

        List<EmployeeContract> result = EmployeeContractsController.getByEmployee(id);
        boolean expResult = true;
        boolean trueResult = (result.size() == 1);

        assertEquals(expResult, trueResult);
    }
    

    /**
     * Test of getByCompany method, of class EmployeeContractsController.
     */
    @Test
    public void testGetByCompany1() {
        System.out.println("getByCompany");
        int id = 0;
        
        List<EmployeeContract> result = EmployeeContractsController.getByCompany(id);
        boolean expResult = true;
        boolean trueResult = (result.size() == 0);

        assertEquals(expResult, trueResult);
    }
    
       @Test
    public void testGetByCompany2() {
        System.out.println("getByCompany");
        int id = 1;
        
        List<EmployeeContract> result = EmployeeContractsController.getByCompany(id);
        boolean expResult = true;
        boolean trueResult = (result.size() == 1);

        assertEquals(expResult, trueResult);
    }

}

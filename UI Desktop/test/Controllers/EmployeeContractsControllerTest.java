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
     * Test of createEmployeeContract method, of class EmployeeContractsController.
     */
    @Test
    public void testCreateEmployeeContract() {
        System.out.println("createEmployeeContract");
        int companyId = 0;
        int employeeId = 0;
        Date startDate = null;
        Date endDate = null;
        boolean expResult = false;
        boolean result = EmployeeContractsController.createEmployeeContract(companyId, employeeId, startDate, endDate);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getById method, of class EmployeeContractsController.
     */
    @Test
    public void testGetById() {
        System.out.println("getById");
        int id = 0;
        EmployeeContract expResult = null;
        EmployeeContract result = EmployeeContractsController.getById(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getByEmployee method, of class EmployeeContractsController.
     */
    @Test
    public void testGetByEmployee() {
        System.out.println("getByEmployee");
        int id = 0;
        List<EmployeeContract> expResult = null;
        List<EmployeeContract> result = EmployeeContractsController.getByEmployee(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getByCompany method, of class EmployeeContractsController.
     */
    @Test
    public void testGetByCompany() {
        System.out.println("getByCompany");
        int id = 0;
        List<EmployeeContract> expResult = null;
        List<EmployeeContract> result = EmployeeContractsController.getByCompany(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}

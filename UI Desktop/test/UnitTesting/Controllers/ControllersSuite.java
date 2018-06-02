/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UnitTesting.Controllers;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author Eduard
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({UnitTesting.Controllers.MeetingsControllerTest.class, UnitTesting.Controllers.ClientContractsControllerTest.class, UnitTesting.Controllers.EmployeesControllerTest.class, UnitTesting.Controllers.ReportsControllerTest.class, UnitTesting.Controllers.CompaniesControllerTest.class, UnitTesting.Controllers.LoginControllerTest.class, UnitTesting.Controllers.EmployeeContractsControllerTest.class, UnitTesting.Controllers.ClientsControllerTest.class})
public class ControllersSuite {

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

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
@Suite.SuiteClasses({Controllers.MeetingsControllerTest.class, Controllers.ClientContractsControllerTest.class, Controllers.EmployeesControllerTest.class, Controllers.ReportsControllerTest.class, Controllers.CompaniesControllerTest.class, Controllers.LoginControllerTest.class, Controllers.EmployeeContractsControllerTest.class, Controllers.ClientsControllerTest.class})
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

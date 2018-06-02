/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UnitTesting.Forms;

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
@Suite.SuiteClasses({UnitTesting.Forms.CompanyMenuControllerTest.class, UnitTesting.Forms.EmployeeMenuControllerTest.class, UnitTesting.Forms.LoginControllerTest.class, UnitTesting.Forms.EmployeesTableControllerTest.class, UnitTesting.Forms.ClientsTableControllerTest.class, UnitTesting.Forms.MeetingsTableControllerTest.class})
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

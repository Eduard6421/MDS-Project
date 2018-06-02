/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UnitTesting.Forms;

import Forms.Controllers.ClientsTableController;
import Utils.GlobalData;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
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
public class ClientsTableControllerTest {

    public ClientsTableControllerTest() {
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
     * Test of actionPerformed method, of class ClientsTableController.
     */
    @Test

    public void testTableClientsCompany1() throws SQLException, InterruptedException {
        
        GlobalData.setCompanyName("Firma1");
        
        ClientsTableController controller = new ClientsTableController();
        
        

    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IntegrationTesting.Forms;

import Forms.Controllers.ClientsTableController;
import Utils.GlobalData;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
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

    @Test
    public void testCleintsTableController1()
    {
        GlobalData.setCompanyName("Firma1");
        try {
            ClientsTableController controller = new ClientsTableController();
            boolean expResult = true;
            DefaultTableModel tm = (DefaultTableModel)controller.getForm().getjTable1().getModel();
            Vector<Vector> aux1 =(Vector<Vector>) tm.getDataVector();
            Vector<Vector> aux2 = new Vector<Vector>();
            Vector aux3 = new Vector();
            aux3.add("client1");
            aux3.add("NumeClient1");
            aux3.add("PrenumeClient1");
            aux3.add("Strada Clientului Nr.7");
            aux3.add("0711223344");
            aux3.add("client@hotmail.com");
            aux2.add(aux3);
            Vector aux4 = new Vector();
            aux4.add("client2");
            aux4.add("NumeClient1");
            aux4.add("PrenumeClient2");
            aux4.add("Strada Clientului nr 2");
            aux4.add("07112234");
            aux4.add("client2@hotmail.com");
            aux2.add(aux4);
            boolean trueResult = aux1.equals(aux2);
            assertEquals(expResult,trueResult);
            
        } catch (Exception ex) {
            Logger.getLogger(ClientsTableControllerTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    @Test
    public void testCleintsTableController2()
    {
        GlobalData.setCompanyName("FUNFFEEQ");
        try {
            ClientsTableController controller = new ClientsTableController();
            boolean expResult = true;
            DefaultTableModel tm = (DefaultTableModel)controller.getForm().getjTable1().getModel();
            Vector<Vector> aux1 =(Vector<Vector>) tm.getDataVector();
            
            boolean trueResult = aux1.size() == 0;
            assertEquals(expResult,trueResult);
            
        } catch (Exception ex) {
            Logger.getLogger(ClientsTableControllerTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    @Test
    public void testCleintsTableController3()
    {
        GlobalData.setCompanyName("");
        try {
            ClientsTableController controller = new ClientsTableController();
            boolean expResult = true;
            DefaultTableModel tm = (DefaultTableModel)controller.getForm().getjTable1().getModel();
            Vector<Vector> aux1 =(Vector<Vector>) tm.getDataVector();
            
            boolean trueResult = aux1.size() == 0;
            assertEquals(expResult,trueResult);
            
        } catch (Exception ex) {
            Logger.getLogger(ClientsTableControllerTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
   
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IntegrationTesting.Forms;

import Forms.Controllers.EmployeesTableController;
import Utils.GlobalData;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
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
public class EmployeesTableControllerTest {
    
    public EmployeesTableControllerTest() {
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
     * Test of actionPerformed method, of class EmployeesTableController.
     */
   
    @Test
    public void testEmployeeTableControllerCompany1()
    {
        String companyName = "Firma1";
        GlobalData.setCompanyName(companyName);
        EmployeesTableController controller = new EmployeesTableController();   
        boolean expResult = true;
        DefaultTableModel tm = (DefaultTableModel)controller.getForm().getTableEmployees().getModel();
        Vector aux1 =(Vector) tm.getDataVector().get(0);
        Vector aux2 = new Vector();
        aux2.addAll(aux1);
        aux2.set(aux2.size()-1, aux2.get(aux2.size()-1).toString());
        Vector aux3 = new Vector();
        aux3.add("employee1");
        aux3.add("employee1");
        aux3.add("employee1");
        aux3.add("0123012312");
        aux3.add("employee1@hotmail.com");
        aux3.add("0.0");
        boolean trueResult = aux2.equals(aux3);
             
        assertEquals(expResult, trueResult);
       
    }
    @Test
    public void testEmployeeTableControllerCompany2()
    {
        String companyName = "Firma2";
        GlobalData.setCompanyName(companyName);
        EmployeesTableController controller = new EmployeesTableController();   
        boolean expResult = true;
        DefaultTableModel tm = (DefaultTableModel)controller.getForm().getTableEmployees().getModel();
        Vector aux1 =(Vector) tm.getDataVector().get(0);
        Vector aux2 = new Vector();
        aux2.addAll(aux1);
        aux2.set(aux2.size()-1, aux2.get(aux2.size()-1).toString());
        Vector aux3 = new Vector();
        aux3.add("employee");
        aux3.add("employee2");
        aux3.add("employee2");
        aux3.add("012312313");
        aux3.add("employee2@hotmail.com");
        aux3.add("0.0");
  
        boolean trueResult = aux2.equals(aux3);
             
        assertEquals(expResult, trueResult);
       
    }
     @Test
    public void testEmployeeTableControllerCompany3()
    {
        String companyName = "";
        GlobalData.setCompanyName(companyName);
        EmployeesTableController controller = new EmployeesTableController();   
        boolean expResult = true;
        DefaultTableModel tm = (DefaultTableModel)controller.getForm().getTableEmployees().getModel();
     
        boolean trueResult = tm.getDataVector().size() == 0;
             
        assertEquals(expResult, trueResult);
       
    }
        
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IntegrationTesting.Forms;

import Forms.Controllers.MeetingsTableController;
import Utils.GlobalData;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
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
public class MeetingsTableControllerTest {

    public MeetingsTableControllerTest() {
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
    public void testMeetingTableController1() {
        GlobalData.setCompanyName("Firma1");
        GlobalData.setUserId(1);
        MeetingsTableController controller = new MeetingsTableController("View all meetings");
        boolean expResult = true;
        DefaultTableModel tm = (DefaultTableModel) controller.getForm().getTable().getModel();
        Vector aux1 = (Vector) tm.getDataVector().get(0);
        Vector aux2 = new Vector();

        aux2.add(true);

        aux2.add("client1");

        aux2.add("employee1");

        aux2.add("2010-01-01");

        aux2.add("da");

        boolean trueResult = aux1.equals(aux2);

        controller.closeWindow();

        assertEquals(expResult, trueResult);

    }

    
    @Test
    public void testMeetingTableController2() {
        GlobalData.setCompanyName("Firma2");
        GlobalData.setUserId(2);
        MeetingsTableController controller = new MeetingsTableController("View all meetings");
        boolean expResult = false;
        DefaultTableModel tm = (DefaultTableModel) controller.getForm().getTable().getModel();
        Vector aux1 = (Vector) tm.getDataVector().get(0);
        
        Vector aux2 = new Vector();
        aux2.add(false);
        aux2.add("client1");
        aux2.add("employee");
        aux2.add("2010-04-02");
        aux2.add("nu");
        boolean trueResult = aux1.equals(aux2);
        
        controller.closeWindow();
        
        assertEquals(expResult, trueResult);
        
    }
     
    @Test
    public void testMeetingTableController3() {

        MeetingsTableController controller = new MeetingsTableController("View all meetings");
        boolean expResult = false;
        DefaultTableModel tm = (DefaultTableModel) controller.getForm().getTable().getModel();

        List<String> realAnswer = new ArrayList<>();


        String element = new String();
        StringBuilder build = new StringBuilder();

        for (int i = 0; i < tm.getRowCount(); ++i) {
            for (int j = 0; j < tm.getColumnCount(); ++j) {
                build.append(tm.getValueAt(i, j));
            }
            realAnswer.add(build.toString());
            build.setLength(0);
        }

        boolean realResult = realAnswer.isEmpty();
     
        assertEquals(expResult,realResult);
    }

    @Test
    public void testMeetingTableController4() {

        GlobalData.setCompanyName("Firma1");
        GlobalData.setUserId(1);
        MeetingsTableController controller = new MeetingsTableController("View closed meetings");

        DefaultTableModel tm = (DefaultTableModel) controller.getForm().getTable().getModel();

        List<String> realAnswer = new ArrayList<>();
        List<String> expectedAnswer = new ArrayList<>();

        expectedAnswer.add("trueclient1employee12010-01-01da");

        String element = new String();
        StringBuilder build = new StringBuilder();

        for (int i = 0; i < tm.getRowCount(); ++i) {
            for (int j = 0; j < tm.getColumnCount(); ++j) {
                build.append(tm.getValueAt(i, j));
            }
            realAnswer.add(build.toString());
            build.setLength(0);
        }

        boolean realResult = realAnswer.equals(expectedAnswer);
        boolean expResult = true;

        assertEquals(expResult, realResult);

    }

    @Test
    public void testMeetingTableController5() {

        GlobalData.setCompanyName("Firma1");
        GlobalData.setUserId(1);
        MeetingsTableController controller = new MeetingsTableController("View closed meetings");

        DefaultTableModel tm = (DefaultTableModel) controller.getForm().getTable().getModel();

        List<String> realAnswer = new ArrayList<>();
        List<String> expectedAnswer = new ArrayList<>();

        expectedAnswer.add("trueclient1employee12010-01-01da");

        String element = new String();
        StringBuilder build = new StringBuilder();

        for (int i = 0; i < tm.getRowCount(); ++i) {
            for (int j = 0; j < tm.getColumnCount(); ++j) {
                build.append(tm.getValueAt(i, j));
            }
            realAnswer.add(build.toString());
            build.setLength(0);
        }

        boolean realResult = realAnswer.equals(expectedAnswer);
        boolean expResult = true;

        assertEquals(expResult, realResult);

    }

}

package Forms.Controllers;

import Controllers.ClientsController;
import Controllers.EmployeesController;
import Controllers.MeetingsController;
import Forms.AssignedMeetingsTable;
import Models.Meeting;
import Utils.Converters;
import Utils.GlobalData;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.util.Pair;

public class AssignedMeetingsController implements ActionListener {
    
    private AssignedMeetingsTable form;
    
    private boolean focus = true;
    private CompanyMenuController parentController;
    
    private List<Pair<Integer, String>> employees;
    private List<Pair<Integer, String>> clients;
    
    public AssignedMeetingsController() {
    }
    public AssignedMeetingsController(String tableType)
    {
        form = new AssignedMeetingsTable(this);
        form.setVisible(true);
        
        populateClientsList();
        populateEmployeesList();

        
        fillTable();
    }

    public AssignedMeetingsTable getForm() {
        return form;
    }
    
    public AssignedMeetingsController(CompanyMenuController parentController) {
        
        this.parentController = parentController;
        this.parentController.setWindowInvisible();
        
        form = new AssignedMeetingsTable(this);
        form.setVisible(true);
        
        populateClientsList();
        populateEmployeesList();
        
        fillTable();
    }
    
    @Override
    public void actionPerformed(ActionEvent evt) {     

        String command = evt.getActionCommand();
        
        if (focus) {
            switch (command) {
                case "Back":
                    form.setVisible(false);
                    form.dispose();
                    parentController.setWindowVisible();
                    break;
            }
        }   
    }
    
    public void populateClientsList() {
        try {
            clients = ClientsController.getAllOnlyGeneralData(GlobalData.getCompanyName());
        } catch (SQLException ex) {
            Logger.getLogger(AssignedMeetingsController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void populateEmployeesList() {
        try {
            employees = EmployeesController.getAllOnlyGeneralData();
        } catch (SQLException ex) {
            Logger.getLogger(AssignedMeetingsController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void toggleFocus() {
        focus = !focus;
    }

    public void setWindowInvisible() {
        form.setVisible(false);
    }

    public void setWindowVisible() {
        form.setVisible(true);
    }

    public void closeWindow() {
        form.setVisible(false);
        form.dispose();
    }
    
    public void fillTable() {
        
        List<Object[]> rows = new ArrayList<>();
        
        List<Meeting> meetings = new ArrayList<>();
        
        meetings = MeetingsController.getAll(GlobalData.getCompanyName());
        
        for (Meeting meeting : meetings) {
            String employeeName = findEmployeeNameById(meeting.getIdEmployee());
            String clientName = findClientNameById(meeting.getIdClient());
            String meetingDate = Converters.dateToString(meeting.getMeetingDate());
            
            Object[] row = new Object[5];
            row[0] = !meeting.getIsOpen();
            row[1] = clientName;
            row[2] = employeeName;
            row[3] = meetingDate;
            row[4] = meeting.getDescription();
            
            rows.add(row);       
        }
          
        form.showPopulation(rows);
    }
    
    public String findEmployeeNameById(int id) {
        for (Pair<Integer, String> employee : employees) {
            if(employee.getKey() == id) {
                return employee.getValue();
            }
        }
        return null;
    }
    
    public String findClientNameById(int id) {
        for (Pair<Integer, String> client : clients) {
            if(client.getKey() == id) {
                return client.getValue();
            }
        }
        return null;
    }
    
}

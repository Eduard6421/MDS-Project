package Forms.Controllers;

import Controllers.ClientsController;
import Controllers.EmployeesController;
import Controllers.MeetingsController;
import Controllers.ReportsController;
import Forms.AssignEmployee;
import Forms.PendingMeetingsTable;
import Forms.MeetingReport;
import Models.Employee;
import Models.Meeting;
import Models.Report;
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
import javax.swing.JOptionPane;

public class PendingMeetingsController implements ActionListener {
    
    private PendingMeetingsTable form;
    
    private boolean focus = true;
    private CompanyMenuController parentController;
    
    private List<Pair<Integer, String>> employees;
    private List<Pair<Integer, String>> clients;
    private List<Pair<Integer, String>> availableEmployees;
    
    private List<Meeting> meetingsList;
    
    private AssignEmployee assignEmployeeForm = null;
    
    public PendingMeetingsController() {
    }
    public PendingMeetingsController(String tableType)
    {
        form = new PendingMeetingsTable(this);
        form.setVisible(true);
        
        populateClientsList();
        populateEmployeesList();
        populateAvailableEmployeesList();
        
        fillTable();
    }

    public PendingMeetingsTable getForm() {
        return form;
    }
    
    public PendingMeetingsController(CompanyMenuController parentController) {
        
        this.parentController = parentController;
        this.parentController.setWindowInvisible();
        
        form = new PendingMeetingsTable(this);
        form.setVisible(true);
        
        populateClientsList();
        populateEmployeesList();
        populateAvailableEmployeesList();
        
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
                case "Assign Employee":
                    if (getSelectedMeeting() != null) {
                        Meeting selectedMeeting = getSelectedMeeting();
                        String clientName = findClientNameById(selectedMeeting.getId());
                        assignEmployeeForm = new AssignEmployee(this, clientName, selectedMeeting, availableEmployees);
                        assignEmployeeForm.setVisible(true);
                        
                        toggleFocus();
                    }
                    break;
            }
        }
        else {
            switch (command) {
                case "Exit":
                    assignEmployeeForm.setVisible(false);
                    assignEmployeeForm.dispose();
                    assignEmployeeForm = null;
                    toggleFocus();
                    break;
                case "Assign":
                    Pair<String, Meeting> meeting = assignEmployeeForm.getAssignedMeeting();
                    int employeeId = findAvailableEmployeeIdByName(meeting.getKey());
                    if (employeeId != -1) {
                        MeetingsController.assignMeetingToEmployee(meeting.getValue().getId(), employeeId);
                        fillTable();
                        toggleFocus();
                        assignEmployeeForm.setVisible(false);
                        assignEmployeeForm.dispose();
                        assignEmployeeForm = null;
                    }                 
                    break;
            }
        }
    }
    
    public void populateClientsList() {
        try {
            clients = ClientsController.getAllOnlyGeneralData(GlobalData.getCompanyName());
        } catch (SQLException ex) {
            Logger.getLogger(PendingMeetingsController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void populateEmployeesList() {
        try {
            employees = EmployeesController.getAllOnlyGeneralData();
        } catch (SQLException ex) {
            Logger.getLogger(PendingMeetingsController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void populateAvailableEmployeesList() {
        try {
            availableEmployees = EmployeesController.getAllOnlyGeneralData();
        } catch (SQLException ex) {
            Logger.getLogger(PendingMeetingsController.class.getName()).log(Level.SEVERE, null, ex);
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
        meetingsList = new ArrayList<>();
        
        meetings = MeetingsController.getAllPending(GlobalData.getCompanyName());
        for (Meeting meeting : meetings) {
            meetingsList.add(meeting);
        }
        
        for (Meeting meeting : meetings) {
            String clientName = findClientNameById(meeting.getIdClient());
            String meetingDate = Converters.dateToString(meeting.getMeetingDate());
            
            Object[] row = new Object[3];
            row[0] = clientName;
            row[1] = meetingDate;
            row[2] = meeting.getDescription();
            
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
    
    public int findAvailableEmployeeIdByName(String name) {
        for (Pair<Integer, String> employee : availableEmployees) {
            if(employee.getValue().equals(name)) {
                return employee.getKey();
            }
        }
        return -1;       
    }
    
    public String findClientNameById(int id) {
        for (Pair<Integer, String> client : clients) {
            if(client.getKey() == id) {
                return client.getValue();
            }
        }
        return null;
    }
    
    public Meeting getSelectedMeeting() {
        int selectedIndex = form.getSelectedRowIndex();
        if (selectedIndex == -1)
            return null; 

        Meeting meeting = meetingsList.get(selectedIndex);
        
        return meeting;
    }
}

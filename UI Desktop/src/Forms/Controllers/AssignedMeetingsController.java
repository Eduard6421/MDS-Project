package Forms.Controllers;

import Controllers.ClientsController;
import Controllers.EmployeesController;
import Controllers.MeetingsController;
import Forms.AssignedMeetingsTable;
import Models.Employee;
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
import javax.swing.JOptionPane;

public class AssignedMeetingsController implements ActionListener {
    
    private AssignedMeetingsTable form;
    
    private boolean focus = true;
    private CompanyMenuController parentController;
    
    private List<Pair<Integer, String>> employees;
    private List<Pair<Integer, String>> clients;
    private List<Meeting> meetingsList;
    
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
                case "Cancel Meeting":
                    if (getSelectedMeeting() != null) {
                        Meeting selectedMeeting = getSelectedMeeting();
                        tryCancelMeeting(selectedMeeting);
                    }
                    break;
                case "Mark as Finished":
                    if (getSelectedMeeting() != null) {
                        Meeting selectedMeeting = getSelectedMeeting();
                        if (selectedMeeting.getIsOpen() == true)
                            MeetingsController.closeMeeting(selectedMeeting.getId());
                        fillTable();
                    }
                    break;
                case "Mark as Open":
                    if (getSelectedMeeting() != null) {
                        Meeting selectedMeeting = getSelectedMeeting();
                        if (selectedMeeting.getIsOpen() == false)
                            MeetingsController.reopenMeeting(selectedMeeting.getId());
                        fillTable();
                    }
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
        meetingsList = new ArrayList<>();
        
        meetings = MeetingsController.getAllAssigned(GlobalData.getCompanyName());
        for (Meeting meeting : meetings) {
            meetingsList.add(meeting);
        }
        
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
    
    public Meeting getSelectedMeeting() {
        int selectedIndex = form.getSelectedRowIndex();
        if (selectedIndex == -1)
            return null; 

        Meeting meeting = meetingsList.get(selectedIndex);
        
        return meeting;
    }
    
    public void tryCancelMeeting(Meeting meeting) {
        int confirmationDialog = JOptionPane
                                    .showConfirmDialog(null, 
                                                       "Do you want to cancel this meeting?",
                                                       "Cancel meeting", JOptionPane.YES_NO_OPTION);
        
        if (confirmationDialog == JOptionPane.YES_OPTION) {
            MeetingsController.cancelMeetingById(meeting.getId());
            fillTable();
        }
    }
}

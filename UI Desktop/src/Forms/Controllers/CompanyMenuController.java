package Forms.Controllers;

import Forms.CompanyMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CompanyMenuController implements ActionListener {
    
    private CompanyMenu form;
    
    private boolean focus = true;
    
    private LoginController parentController;
    
    public CompanyMenuController() {
        form = new CompanyMenu(this);
        form.setVisible(true);
    }
    
    public CompanyMenuController(LoginController parentController) {
        
        this.parentController = parentController;
        this.parentController.setWindowInvisible();
        
        form = new CompanyMenu(this);
        form.setVisible(true);
        
    }
    
    @Override
    public void actionPerformed(ActionEvent evt) {     

        String command = evt.getActionCommand();
        
        if (focus) {
            switch (command) {
                case "Employees":
                    try {
                        EmployeesTableController employeesTableController = new EmployeesTableController(this);
                    } catch (SQLException ex) {
                        Logger.getLogger(CompanyMenuController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
                case "Assigned Meetings":
                    AssignedMeetingsController assignedMeetingsController = new AssignedMeetingsController(this);
                    break;
                case "Pending Meetings":
                    PendingMeetingsController pendingMeetingsController = new PendingMeetingsController(this);
                    break;
                case "Log out":
                    form.setVisible(false);
                    form.dispose();
                    parentController.setWindowVisible();
                    break;
            }
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
    
}

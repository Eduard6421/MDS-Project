package Forms.Controllers;

import Forms.EmployeeMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class EmployeeMenuController implements ActionListener {
    
    private EmployeeMenu form;
    
    private boolean focus = true;
    
    private LoginController parentController;
    
    public EmployeeMenuController() {
        form = new EmployeeMenu(this);
        form.setVisible(true);
    }
    
    public EmployeeMenuController(LoginController parentController) {
        
        this.parentController = parentController;
        this.parentController.setWindowInvisible();
        
        form = new EmployeeMenu(this);
        form.setVisible(true);
        
    }
    
    @Override
    public void actionPerformed(ActionEvent evt) {     

        String command = evt.getActionCommand();
        
        if (focus) {
            switch (command) {
                case "View all meetings":
                    //MeetingsTableController meetingsTableController = new MeetingsTableController(this, command);
                    break;
                case "View closed meetings":
                    //meetingsTableController = new MeetingsTableController(this, command);
                    break;
                case "View opened meetings":
                    //meetingsTableController = new MeetingsTableController(this, command);
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

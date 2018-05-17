package Forms.Controllers;

import Forms.MeetingsTable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class MeetingsTableController implements ActionListener {
    
    private MeetingsTable form;
    
    private boolean focus = true;
    
    private EmployeeMenuController parentController;
    
    public MeetingsTableController() {
    }
    
    public MeetingsTableController(EmployeeMenuController parentController, String tableType) {
        
        this.parentController = parentController;
        this.parentController.setWindowInvisible();
        
        form = new MeetingsTable(this, tableType);
        form.setVisible(true);
        
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

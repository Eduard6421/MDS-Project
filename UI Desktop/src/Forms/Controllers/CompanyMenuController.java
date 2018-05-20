package Forms.Controllers;

import Forms.Menu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class CompanyMenuController implements ActionListener {
    
    private Menu form;
    
    private boolean focus = true;
    
    private LoginController parentController;
    
    public CompanyMenuController() {
        form = new Menu(this);
        form.setVisible(true);
    }
    
    public CompanyMenuController(LoginController parentController) {
        
        this.parentController = parentController;
        this.parentController.setWindowInvisible();
        
        form = new Menu(this);
        form.setVisible(true);
        
    }
    
    @Override
    public void actionPerformed(ActionEvent evt) {     

        String command = evt.getActionCommand();
        
        if (focus) {
            switch (command) {
                case "Employees":
                    EmployeesTableController employeesTableController = new EmployeesTableController(this, command);
                    break;
                case "Clients":
                    ClientsTableController clientsTableController= new ClientsTableController(this, command);
                    break;
                case "Requests":
                    //ReportsTableController reportsTablesController = new ReportsTableController(this, command);
                    break;
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

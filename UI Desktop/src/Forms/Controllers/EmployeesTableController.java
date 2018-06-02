package Forms.Controllers;


import Controllers.CompaniesController;
import Controllers.EmployeeContractsController;
import Controllers.EmployeesController;
import Forms.AddEditEmployee;
import Forms.EmployeesTable;
import Models.Company;
import Models.Employee;
import Utils.Converters;
import Utils.GlobalData;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.util.Pair;
import org.javatuples.Triplet;

public class EmployeesTableController implements ActionListener {
    
    private EmployeesTable form;
    
    private boolean focus = true;
    
    private CompanyMenuController parentController;
    
    private AddEditEmployee addEditEmployeeForm;
    
    private List<Pair<Integer, String>> employeesIds = new ArrayList<>();
    
    public EmployeesTableController() {
    }
    
    public EmployeesTableController(CompanyMenuController parentController) throws SQLException {
        
        this.parentController = parentController;
        this.parentController.setWindowInvisible();
        
        form = new EmployeesTable(this);
        form.setVisible(true);     
        
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
                case "New Employee":
                    addEditEmployeeForm = new AddEditEmployee(this);
                    addEditEmployeeForm.setVisible(true);
                    addEditEmployeeForm.formForUpdate(false);
                    toggleFocus();
                    break;
            }
        }
        else {
            switch (command) {
                case "Exit":
                    addEditEmployeeForm.setVisible(false);
                    addEditEmployeeForm.dispose();
                    toggleFocus();
                    {
                        try {
                            fillTable();
                        } catch (SQLException ex) {
                            Logger.getLogger(EmployeesTableController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    break;

                case "Insert":
                    Triplet<Employee, Date, Date> newEmployeeTriplet = addEditEmployeeForm.getNewEmployee();
                    tryInsertNewEmployee(newEmployeeTriplet);
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
    
    public void fillTable() throws SQLException {
        
        List<Object[]> rows = new ArrayList<>();
        
        List<Employee> employees = new ArrayList<>();
        
        employees = (List<Employee>) EmployeesController.getAll(GlobalData.getCompanyName());
        
        for (Employee employee : employees) {
            
            Object[] row = new Object[6];
            row[0] = employee.getUsername();
            row[1] = employee.getFirstName();
            row[2] = employee.getLastName();
            row[3] = employee.getPhone();
            row[4] = employee.getEmail();
            row[5] = employee.getRating();
            
            employeesIds.add(new Pair<Integer, String>(employee.getId(), employee.getUsername()));
            
            rows.add(row);       
        }
          
        form.showPopulation(rows);
        
    }
    
    public void tryInsertNewEmployee(Triplet<Employee, Date, Date> newEmployeeTriplet) {
        if (newEmployeeTriplet != null) {
            addEditEmployeeForm.setVisible(false);
            addEditEmployeeForm.dispose();
            toggleFocus();
            Employee newEmployee = newEmployeeTriplet.getValue0();
            int newEmployeeId = EmployeesController.registerEmployee(newEmployee.getFirstName(), 
                                                                     newEmployee.getLastName(),
                                                                     newEmployee.getUsername(), 
                                                                     newEmployee.getUserPassword(), 
                                                                     newEmployee.getPhone(), 
                                                                     newEmployee.getEmail());
            if (newEmployeeId != -1) {
                Company company = CompaniesController.getByUsername(GlobalData.getCompanyName());
                EmployeeContractsController.createEmployeeContract(company.getId(), 
                                                                   newEmployeeId, 
                                                                   new java.sql.Date(newEmployeeTriplet.getValue1().getTime()), 
                                                                   new java.sql.Date(newEmployeeTriplet.getValue2().getTime()));
            }
            try {
                fillTable();
            } catch (SQLException ex) {
                Logger.getLogger(EmployeesTableController.class.getName()).log(Level.SEVERE, null, ex);
           }
        }
    }
}
    
   
        
    
    



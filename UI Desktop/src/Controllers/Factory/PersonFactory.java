package Controllers.Factory;

import Controllers.ClientsController;
import Controllers.EmployeesController;
import Models.Person;

public class PersonFactory {
    
    public static Person getByAccount(String username, String password, String personType) {
        if (personType == null) {
            return null;
        }
        if (personType.equalsIgnoreCase("CLIENT")) {
            return ClientsController.getByAccount(username, password);
        }
        else if (personType.equalsIgnoreCase("EMPLOYEE")) {
            return EmployeesController.getByAccount(username, password);
        }
        
        return null;
    }
    
    public static Person getByUsername(String username, String personType) {
        if (personType == null) {
            return null;
        }
        if (personType.equalsIgnoreCase("CLIENT")) {
            return ClientsController.getByUsername(username);
        }
        else if (personType.equalsIgnoreCase("EMPLOYEE")) {
            return EmployeesController.getByUsername(username);
        }
        
        return null;
    }
    
    public static Person getById(int id, String personType) {
        if (personType == null) {
            return null;
        }
        if (personType.equalsIgnoreCase("CLIENT")) {
            return ClientsController.getById(id);
        }
        else if (personType.equalsIgnoreCase("EMPLOYEE")) {
            return EmployeesController.getById(id);
        }
        
        return null;
    }
}

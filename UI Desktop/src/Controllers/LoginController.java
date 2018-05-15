package Controllers;

import Models.Client;
import Models.Company;
import Models.Employee;
import Utils.GlobalData;

public class LoginController {

    public static boolean connectEmployee(String username, String password) {

        Employee EmployeeInstance = EmployeeController.getByAccount(username, password);

        if (EmployeeInstance != null) {
            GlobalData.setUsername(username);
            GlobalData.setUserType("employee");
            return true;

        }

        return false;
    }

    public static boolean connectCompany(String username, String password) {

        Company CompanyInstance = CompanyController.getByAccount(username, password);

        if (CompanyInstance != null) {
            GlobalData.setUsername(username);
            GlobalData.setUserType("company");
            return true;

        }

        return false;
    }

}

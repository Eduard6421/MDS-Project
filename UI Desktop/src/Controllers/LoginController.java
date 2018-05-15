package Controllers;

import Models.Client;
import Models.Company;
import Models.Employee;
import Utils.GlobalData;

public class LoginController {

    public static boolean connectEmployee(String Username, String Password) {

        Employee EmployeeInstance = EmployeeController.getByAccount(Username, Password);

        if (EmployeeInstance != null) {
            GlobalData.setUsername(Username);
            GlobalData.setUserType("employee");
            return true;

        }

        return false;
    }

    public static boolean connectCompany(String Username, String Password) {

        Company CompanyInstance = CompanyController.getByAccount(Username, Password);

        if (CompanyInstance != null) {
            GlobalData.setUsername(Username);
            GlobalData.setUserType("company");
            return true;

        }

        return false;
    }

}

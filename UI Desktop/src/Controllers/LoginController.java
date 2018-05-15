/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.Client;
import Models.Company;
import Models.Employee;
import Utils.GlobalData;

/**
 *
 * @author Eduard
 */
public class LoginController {

    
    public static boolean connectClient(String Username, String Password) {

        Client ClientInstance = ClientController.getByAccount(Username, Password);

        if (ClientInstance != null) {
            GlobalData.setUsername(Username);
            GlobalData.setUserType("client");
            return true;

        }

        return false;
    }

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

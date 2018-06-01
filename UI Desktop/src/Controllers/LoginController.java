package Controllers;

import Models.Client;
import Models.Company;
import Models.Employee;
import Models.EmployeeContract;
import Utils.GlobalData;

public class LoginController {

    public static boolean connectClient(String username, String password) {

        Client client = ClientsController.getByAccount(username, password);

        if (client != null) {
            GlobalData.setUsername(username);
            GlobalData.setUserType("client");
            GlobalData.setUserId(client.getId());
            return true;
        }

        return false;
    }

    public static boolean connectEmployee(String username, String password) {

        Employee employee = EmployeesController.getByAccount(username, password);

        if (employee != null) {
            GlobalData.setUsername(username);
            GlobalData.setUserType("employee");
            GlobalData.setUserId(employee.getId());
            EmployeeContract tmp = EmployeeContractsController.getById(employee.getId());
            Company tmp1 = CompaniesController.getById(tmp.getIdCompany());
            GlobalData.setCompanyName(tmp1.getName());
            return true;
        }

        return false;
    }

    public static boolean connectCompany(String username, String password) {

        Company company = CompaniesController.getByAccount(username, password);

        if (company != null) {
            GlobalData.setUsername(username);
            GlobalData.setCompanyName(username);
            GlobalData.setUserType("company");
            GlobalData.setUserId(company.getId());
            return true;
        }

        return false;
    }

}

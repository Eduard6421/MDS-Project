package Controllers;

import Models.EmployeeContract;
import Utils.MySQLConnector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class EmployeeContractsController {

    private static final Connection conn = MySQLConnector.getConnection();

    public static boolean createEmployeeContract(int companyId, int employeeId, java.sql.Date startDate, java.sql.Date endDate) {

        java.sql.Date SQLStartDate = new java.sql.Date(startDate.getTime());
        java.sql.Date SQLEndDate = new java.sql.Date(endDate.getTime());

        try {
            String query = "INSERT INTO employee_contracts (IdCompany, IdEmployee, StartDate, EndDate) VALUES (?,?,?,?)";

            PreparedStatement statement = conn.prepareStatement(query);

            statement.setInt(1, companyId);
            statement.setInt(2, employeeId);
            statement.setDate(3, SQLStartDate);
            statement.setDate(4, SQLEndDate);

            int result = statement.executeUpdate();

            statement.close();

            return result > 0;

        } catch (SQLException e) {
            System.out.println("Exception : " + e);
        }

        return false;
    }

    public static EmployeeContract getById(int id) {

        EmployeeContract employeeContract = null;

        try {
            String query = "SELECT * FROM employee_contracts WHERE Id = (?)";

            PreparedStatement statement = conn.prepareStatement(query);
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();

            while (result.next()) {

                employeeContract = new EmployeeContract(
                        result.getInt("Id"),
                        result.getInt("IdEmployee"),
                        result.getInt("IdCompany"),
                        result.getDate("StartDate"),
                        result.getDate("EndDate"));

            }
            statement.close();
        } catch (SQLException e) {
            System.out.println(e);
        }

        return employeeContract;
    }

    public static EmployeeContract getByEmployee(int id) {

        EmployeeContract employeeContract = null;

        try {
            String query = "SELECT  * FROM employee_contracts WHERE IdEmployee = (?)";

            PreparedStatement statement = conn.prepareStatement(query);
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();

            while (result.next()) {

                employeeContract = new EmployeeContract(
                        result.getInt("Id"),
                        result.getInt("IdEmployee"),
                        result.getInt("IdCompany"),
                        result.getDate("StartDate"),
                        result.getDate("EndDate"));

            }
            statement.close();
        } catch (SQLException e) {
            System.out.println(e);
        }

        return employeeContract;
    }

    public static List<EmployeeContract> getByCompany(int id) {

        EmployeeContract employeeContract = null;

        List<EmployeeContract> employeeContracts = new ArrayList<>();

        try {
            String query = "SELECT  * FROM employee_contracts WHERE IdCompany = (?)";

            PreparedStatement statement = conn.prepareStatement(query);
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                employeeContract = new EmployeeContract(
                        result.getInt("Id"),
                        result.getInt("IdEmployee"),
                        result.getInt("IdCompany"),
                        result.getDate("StartDate"),
                        result.getDate("EndDate"));

                employeeContracts.add(employeeContract);
            }
            statement.close();

        } catch (SQLException e) {
            System.out.println(e);
        }

        return employeeContracts;
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.EmployeeContract;
import Util.MySQLConnector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class EmployeeContractController {

    private static final Connection Conn = MySQLConnector.getConnection();

    public static boolean createEmployeeContract(int companyId, int employeeId, java.sql.Date startDate, java.sql.Date endDate) {

        java.sql.Date SQLStartDate = new java.sql.Date(startDate.getTime());
        java.sql.Date SQLEndDate = new java.sql.Date(endDate.getTime());

        try {

            String query = "INSERT INTO EMPLOYEE_CONTRACT (ID_COMPANY,ID_EMPLOYEE,START_DATE,END_DATE) VALUES (?,?,?,?)";

            PreparedStatement statement = Conn.prepareStatement(query);

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

    public static EmployeeContract getById(int Id) {

        EmployeeContract contractInstance = null;

        try {

            String query = "SELECT * FROM employee_contract WHERE ID = (?);";

            PreparedStatement statement = Conn.prepareStatement(query);
            statement.setInt(1, Id);
            ResultSet result = statement.executeQuery();

            while (result.next()) {

                contractInstance = new EmployeeContract(
                        result.getInt("ID"),
                        result.getInt("ID_EMPLOYEE"),
                        result.getInt("ID_COMPANY"),
                        result.getDate("START_DATE"),
                        result.getDate("END_DATE"));

                statement.close();

            }

        } catch (SQLException e) {
            System.out.println(e);
        }

        return contractInstance;
    }

    public static List<EmployeeContract> getByEmployee(int Id) {

        EmployeeContract contractInstance = null;

        List<EmployeeContract> contractList = new ArrayList<>();

        try {

            String query = "SELECT  * from employee_contract WHERE ID_EMPLOYEE = (?); ";

            PreparedStatement statement = Conn.prepareStatement(query);
            ResultSet result = statement.executeQuery();

            while (result.next()) {

                contractInstance = new EmployeeContract(
                        result.getInt("ID"),
                        result.getInt("ID_EMPLOYEE"),
                        result.getInt("ID_COMPANY"),
                        result.getDate("START_DATE"),
                        result.getDate("END_DATE"));

                contractList.add(contractInstance);

                statement.close();

            }

        } catch (SQLException e) {
            System.out.println(e);

        }

        return contractList;
    }

    public static List<EmployeeContract> getByCompany(int Id) {

        EmployeeContract contractInstance = null;

        List<EmployeeContract> contractList = new ArrayList<>();

        try {

            String query = "SELECT  * from employee_contract WHERE ID_COMPANY = (?); ";

            PreparedStatement statement = Conn.prepareStatement(query);
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                contractInstance = new EmployeeContract(
                        result.getInt("ID"),
                        result.getInt("ID_EMPLOYEE"),
                        result.getInt("ID_COMPANY"),
                        result.getDate("START_DATE"),
                        result.getDate("END_DATE"));

                contractList.add(contractInstance);
            }
            statement.close();

        } catch (SQLException e) {
            System.out.println(e);

        }

        return contractList;
    }

}

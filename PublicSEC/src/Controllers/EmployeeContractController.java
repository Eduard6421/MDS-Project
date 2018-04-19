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

public class EmployeeContractController {

    private static final Connection Conn = MySQLConnector.getConnection();

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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.Employee;
import Util.MySQLConnector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeController {

    private static final Connection Conn = MySQLConnector.getConnection();

    public static Employee getById(int id) {

        Employee employeeInstance = null;

        try {

            String query = "SELECT * FROM Employee WHERE ID = (?) ;";

            PreparedStatement statement = Conn.prepareStatement(query);
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();

            while (result.next()) {

                employeeInstance = new Employee(
                        result.getInt("ID"),
                        result.getString("First_Name"),
                        result.getString("Last_Name"),
                        result.getString("Username"),
                        result.getString("Password"),
                        result.getString("Address"),
                        result.getString("Phone"),
                        result.getString("Email"));
            }

            statement.close();

        } catch (SQLException e) {
            System.out.println("Error : " + e);
        }

        return employeeInstance;
    }

    private static List<Employee> getAll() throws SQLException {

        Employee employeeInstance = null;

        List<Employee> employeeList = new ArrayList<>();

        try {
            String query = "SELECT * FROM EMPLOYEE";

            PreparedStatement statement = Conn.prepareStatement(query);
            ResultSet result = statement.executeQuery();

            while (result.next()) {

                employeeInstance = new Employee(
                        result.getInt("ID"),
                        result.getString("First_Name"),
                        result.getString("Last_Name"),
                        result.getString("Username"),
                        result.getString("Password"),
                        result.getString("Address"),
                        result.getString("Phone"),
                        result.getString("Email"));

                employeeList.add(employeeInstance);
            }
            statement.close();

        } catch (SQLException e) {
            System.out.println(e);
        }

        return employeeList;

    }

}

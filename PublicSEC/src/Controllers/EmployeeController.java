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

public class EmployeeController {

    private static final Connection Conn = MySQLConnector.getConnection();

    public static Employee GetById(int id) {

        Employee EmployeeInstance = null;

        try {

            String query = "SELECT * FROM COMPANY WHERE ID = (?) ;";

            PreparedStatement statement = Conn.prepareStatement(query);
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();

            while (result.next()) {

                EmployeeInstance = new Employee(
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

        } catch (Exception e) {
            System.out.println("Error : " + e);
        }

        return EmployeeInstance;
    }

}

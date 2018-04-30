/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.Company;
import Util.MySQLConnector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CompanyController {

    private static final Connection Conn = MySQLConnector.getConnection();

    public static Company getByAccount(String Username, String Password) {

        Company companyInstance = null;

        try {

            String query = "SELECT * FROM COMPANY WHERE USERNAME = (?) AND PASSWORD = (?);";

            PreparedStatement statement = Conn.prepareStatement(query);
            statement.setString(1, Username);
            statement.setString(2, Password);

            ResultSet result = statement.executeQuery();

            while (result.next()) {

                companyInstance = new Company(
                        result.getInt("ID"),
                        result.getString("Name"),
                        result.getDate("Contract_Start_Date"),
                        result.getDate("Contract_End_Date"),
                        result.getString("Description"),
                        result.getString("Username"),
                        result.getString("Password"));
            }

            statement.close();

        } catch (SQLException e) {
            System.out.println("Error : " + e);
        }

        return companyInstance;
    }

    public static Company getByUsername(String Username) {

        Company companyInstance = null;

        try {

            String query = "SELECT * FROM COMPANY WHERE USERNAME = (?) ;";

            PreparedStatement statement = Conn.prepareStatement(query);
            statement.setString(1, Username);
            ResultSet result = statement.executeQuery();

            while (result.next()) {

                companyInstance = new Company(
                        result.getInt("ID"),
                        result.getString("Name"),
                        result.getDate("Contract_Start_Date"),
                        result.getDate("Contract_End_Date"),
                        result.getString("Description"),
                        result.getString("Username"),
                        result.getString("Password"));
            }

            statement.close();

        } catch (SQLException e) {
            System.out.println("Error : " + e);
        }

        return companyInstance;
    }

    public static Company getById(int id) {

        Company companyInstance = null;

        try {

            String query = "SELECT * FROM COMPANY WHERE ID = (?) ;";

            PreparedStatement statement = Conn.prepareStatement(query);
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();

            while (result.next()) {

                companyInstance = new Company(
                        result.getInt("ID"),
                        result.getString("Name"),
                        result.getDate("Contract_Start_Date"),
                        result.getDate("Contract_End_Date"),
                        result.getString("Description"),
                        result.getString("Username"),
                        result.getString("Password"));
            }

            statement.close();

        } catch (SQLException e) {
            System.out.println("Error : " + e);
        }

        return companyInstance;
    }

    private static List<Company> getAll() {

        Company companyInstance = null;

        List<Company> companyList = new ArrayList<>();

        try {
            String query = "SELECT * from COMPANY";

            PreparedStatement statement = Conn.prepareStatement(query);
            ResultSet result = statement.executeQuery();

            while (result.next()) {

                companyInstance = new Company(
                        result.getInt("ID"),
                        result.getString("Name"),
                        result.getDate("Contract_Start_Date"),
                        result.getDate("Contract_End_Date"),
                        result.getString("Description"),
                        result.getString("Username"),
                        result.getString("Password"));

                companyList.add(companyInstance);
            }
            statement.close();
        } catch (SQLException e) {

            System.out.println(e);
        }

        return companyList;

    }

}

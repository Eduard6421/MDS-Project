package Controllers;

import Models.Company;
import Utils.MySQLConnector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CompanyController {

    private static final Connection conn = MySQLConnector.getConnection();

    public static Company getByAccount(String username, String password) {

        Company companyInstance = null;

        try {
            String query = "SELECT * FROM COMPANY WHERE USER_NAME = (?) AND USER_PASSWORD = (?);";

            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, username);
            statement.setString(2, password);

            ResultSet result = statement.executeQuery();

            while (result.next()) {

                companyInstance = new Company(
                        result.getInt("ID"),
                        result.getString("Name"),
                        result.getDate("Contract_Start_Date"),
                        result.getDate("Contract_End_Date"),
                        result.getString("Description"),
                        result.getString("User_Name"),
                        result.getString("User_Password"));
            }

            statement.close();

        } catch (SQLException e) {
            System.out.println("Error : " + e);
        }

        return companyInstance;
    }

    public static Company getByUsername(String username) {

        Company companyInstance = null;

        try {
            String query = "SELECT * FROM COMPANY WHERE USER_NAME = (?) ;";

            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, username);
            ResultSet result = statement.executeQuery();

            while (result.next()) {

                companyInstance = new Company(
                        result.getInt("ID"),
                        result.getString("Name"),
                        result.getDate("Contract_Start_Date"),
                        result.getDate("Contract_End_Date"),
                        result.getString("Description"),
                        result.getString("User_Name"),
                        result.getString("User_Password"));
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

            PreparedStatement statement = conn.prepareStatement(query);
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();

            while (result.next()) {

                companyInstance = new Company(
                        result.getInt("ID"),
                        result.getString("Name"),
                        result.getDate("Contract_Start_Date"),
                        result.getDate("Contract_End_Date"),
                        result.getString("Description"),
                        result.getString("User_Name"),
                        result.getString("User_Password"));
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

            PreparedStatement statement = conn.prepareStatement(query);
            ResultSet result = statement.executeQuery();

            while (result.next()) {

                companyInstance = new Company(
                        result.getInt("ID"),
                        result.getString("Name"),
                        result.getDate("Contract_Start_Date"),
                        result.getDate("Contract_End_Date"),
                        result.getString("Description"),
                        result.getString("User_Name"),
                        result.getString("User_Password"));

                companyList.add(companyInstance);
            }
            statement.close();
        } catch (SQLException e) {

            System.out.println(e);
        }

        return companyList;
    }
    
}

package Controllers;

import Models.Company;
import Utils.MySQLConnector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CompaniesController {

    private static final Connection conn = MySQLConnector.getConnection();

    public static Company getByAccount(String username, String password) {

        Company company = null;

        try {
            String query = "SELECT * FROM Companies WHERE Username = (?) AND Password = (?)";

            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, username);
            statement.setString(2, password);

            ResultSet result = statement.executeQuery();

            while (result.next()) {

                company = new Company(
                        result.getInt("Id"),
                        result.getString("Name"),
                        result.getDate("ContractStartDate"),
                        result.getDate("ContractEndDate"),
                        result.getString("Description"),
                        result.getString("Username"),
                        result.getString("Password"));
            }

            statement.close();

        } catch (SQLException e) {
            System.out.println("Error : " + e);
        }

        return company;
    }

    public static Company getByUsername(String username) {

        Company company = null;

        try {
            String query = "SELECT * FROM Companies WHERE Username = (?)";

            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, username);
            ResultSet result = statement.executeQuery();

            while (result.next()) {

                company = new Company(
                        result.getInt("Id"),
                        result.getString("Name"),
                        result.getDate("ContractStartDate"),
                        result.getDate("ContractEndDate"),
                        result.getString("Description"),
                        result.getString("Username"),
                        result.getString("Password"));
            }

            statement.close();

        } catch (SQLException e) {
            System.out.println("Error : " + e);
        }

        return company;
    }

    public static Company getById(int id) {

        Company company = null;

        try {
            String query = "SELECT * FROM Companies WHERE Id = (?)";

            PreparedStatement statement = conn.prepareStatement(query);
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();

            while (result.next()) {

                company = new Company(
                        result.getInt("Id"),
                        result.getString("Name"),
                        result.getDate("ContractStartDate"),
                        result.getDate("ContractEndDate"),
                        result.getString("Description"),
                        result.getString("Username"),
                        result.getString("Password"));
            }

            statement.close();

        } catch (SQLException e) {
            System.out.println("Error : " + e);
        }

        return company;
    }

    private static List<Company> getAll() {

        Company company = null;

        List<Company> companies = new ArrayList<>();

        try {
            String query = "SELECT * FROM Companies";

            PreparedStatement statement = conn.prepareStatement(query);
            ResultSet result = statement.executeQuery();

            while (result.next()) {

                company = new Company(
                        result.getInt("Id"),
                        result.getString("Name"),
                        result.getDate("ContractStartDate"),
                        result.getDate("ContractEndDate"),
                        result.getString("Description"),
                        result.getString("Username"),
                        result.getString("Password"));

                companies.add(company);
            }
            statement.close();
        } catch (SQLException e) {

            System.out.println(e);
        }

        return companies;
    }
    
}

package Controllers;

import Models.Employee;
import Utils.GlobalData;
import Utils.MySQLConnector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javafx.util.Pair;

public class EmployeesController {

    private static final Connection conn = MySQLConnector.getConnection();

    public static boolean registerEmployee(String firstName, String lastName, String userName, String password, String phone, String email) {

        try {
            String query = "INSERT INTO Employees (FirstName, LastName, Username, Password, Phone, Email, Rating) values (?,?,?,?,?,?,?,?)";

            double rating = 0;
            
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, firstName);
            statement.setString(2, lastName);
            statement.setString(3, userName);
            statement.setString(4, password);
            statement.setString(5, phone);
            statement.setString(6, email);
            statement.setDouble(7, rating);

            int result = statement.executeUpdate();

            statement.close();

            return result > 0;

        } catch (SQLException e) {
            return false;
        } finally {
            return false;
        }
    }

    public static Employee getByAccount(String username, String password) {

        Employee employee = null;

        try {
            String query = "SELECT * FROM Employees WHERE Username = (?) AND Password = (?)";

            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, username);
            statement.setString(2, username);
            ResultSet result = statement.executeQuery();

            while (result.next()) {

                employee = new Employee(
                        result.getInt("Id"),
                        result.getString("FirstName"),
                        result.getString("LastName"),
                        result.getString("Username"),
                        result.getString("Password"),
                        result.getString("Phone"),
                        result.getString("Email"),
                        result.getDouble("Rating"));
            }

            statement.close();

        } catch (SQLException e) {
            System.out.println("Error : " + e);
        }

        return employee;
    }

    public static Employee getByUsername(String username) {

        Employee employee = null;

        try {
            String query = "SELECT * FROM Employees WHERE Username = (?)";

            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, username);
            ResultSet result = statement.executeQuery();

            while (result.next()) {

                employee = new Employee(
                        result.getInt("Id"),
                        result.getString("FirstName"),
                        result.getString("LastName"),
                        result.getString("Username"),
                        result.getString("Password"),
                        result.getString("Phone"),
                        result.getString("Email"),
                        result.getDouble("Rating"));
            }

            statement.close();

        } catch (SQLException e) {
            System.out.println("Error : " + e);
        }

        return employee;
    }

    public static Employee getById(int id) {

        Employee employee = null;

        try {
            String query = "SELECT * FROM Employees WHERE Id = (?)";

            PreparedStatement statement = conn.prepareStatement(query);
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();

            while (result.next()) {

                employee = new Employee(
                        result.getInt("Id"),
                        result.getString("FirstName"),
                        result.getString("LastName"),
                        result.getString("Username"),
                        result.getString("Password"),
                        result.getString("Phone"),
                        result.getString("Email"),
                        result.getDouble("Rating"));
            }

            statement.close();

        } catch (SQLException e) {
            System.out.println("Error : " + e);
        }

        return employee;
    }

    public static boolean changePassword(String oldPassword, String newPassword) {
        String username = GlobalData.getUsername();

        try {
            String update = "UPDATE Employees SET Password = (?) WHERE Username = (?) AND Password = (?)";

            PreparedStatement statement = conn.prepareStatement(update);
            statement.setString(1, newPassword);
            statement.setString(2, username);
            statement.setString(3, oldPassword);

            int result = statement.executeUpdate();

            return result > 0;

        } catch (SQLException e) {
            System.out.println("Wrong oldPassword : " + e);
        }

        return false;
    }

    public static boolean updateData(String email, String phoneNumber) {
        String username = GlobalData.getUsername();

        try {
            String update = "UPDATE Employees SET Email = (?), Phone = (?) WHERE Username = (?)";

            PreparedStatement statement = conn.prepareStatement(update);
            statement.setString(1, email);
            statement.setString(2, phoneNumber);
            statement.setString(3, username);

            int result = statement.executeUpdate();

            return result > 0;

        } catch (SQLException e) {
            System.out.println("Error : " + e);
        }

        return false;
    }

    private static List<Employee> getAll() throws SQLException {

        Employee employee = null;

        List<Employee> employees = new ArrayList<>();

        try {
            String query = "SELECT * FROM Employees";

            PreparedStatement statement = conn.prepareStatement(query);
            ResultSet result = statement.executeQuery();

            while (result.next()) {

                employee = new Employee(
                        result.getInt("Id"),
                        result.getString("FirstName"),
                        result.getString("LastName"),
                        result.getString("Username"),
                        result.getString("Password"),
                        result.getString("Phone"),
                        result.getString("Email"),
                        result.getDouble("Rating"));

                employees.add(employee);
            }
            statement.close();

        } catch (SQLException e) {
            System.out.println(e);
        }

        return employees;
    }
    
    public static List<Pair<Integer, String>> getAllOnlyGeneralData() throws SQLException {

        Pair<Integer, String> employee = null;

        List<Pair<Integer, String>> employees = new ArrayList<>();

        try {
            String query = "SELECT Id, Username FROM Employees";

            PreparedStatement statement = conn.prepareStatement(query);
            ResultSet result = statement.executeQuery();

            while (result.next()) {

                employee = new Pair<Integer, String>(result.getInt("Id"),
                                                   result.getString("Username"));

                employees.add(employee);
            }

            statement.close();

        } catch (SQLException e) {
            System.out.println("Error : " + e);
        }

        return employees;
    }
    
}

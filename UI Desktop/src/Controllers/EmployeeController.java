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

public class EmployeeController {

    private static final Connection conn = MySQLConnector.getConnection();

    public static boolean registerEmployee(String firstName, String lastName, String userName, String userPassword, String address, String phone, String email) {

        try {
            String query = "INSERT INTO employee (FIRST_NAME,LAST_NAME,USER_NAME,USER_PASSWORD,ADDRESS,PHONE,EMAIL) values (?,?,?,?,?,?,?);";

            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, firstName);
            statement.setString(2, lastName);
            statement.setString(3, userName);
            statement.setString(4, userPassword);
            statement.setString(5, address);
            statement.setString(6, phone);
            statement.setString(7, email);

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

        Employee employeeInstance = null;

        try {
            String query = "SELECT * FROM Employee WHERE User_Name = (?) AND User_Password = (?);";

            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, username);
            statement.setString(2, username);
            ResultSet result = statement.executeQuery();

            while (result.next()) {

                employeeInstance = new Employee(
                        result.getInt("ID"),
                        result.getString("First_Name"),
                        result.getString("Last_Name"),
                        result.getString("User_Name"),
                        result.getString("User_Password"),
                        result.getString("Address"),
                        result.getString("Phone"),
                        result.getString("Email"),
                        result.getDouble("Rating"));
            }

            statement.close();

        } catch (SQLException e) {
            System.out.println("Error : " + e);
        }

        return employeeInstance;
    }

    public static Employee getByUsername(String username) {

        Employee employeeInstance = null;

        try {
            String query = "SELECT * FROM Employee WHERE USERNAME = (?) ;";

            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, username);
            ResultSet result = statement.executeQuery();

            while (result.next()) {

                employeeInstance = new Employee(
                        result.getInt("ID"),
                        result.getString("First_Name"),
                        result.getString("Last_Name"),
                        result.getString("User_Name"),
                        result.getString("User_Password"),
                        result.getString("Address"),
                        result.getString("Phone"),
                        result.getString("Email"),
                        result.getDouble("Rating"));
            }

            statement.close();

        } catch (SQLException e) {
            System.out.println("Error : " + e);
        }

        return employeeInstance;
    }

    public static Employee getById(int id) {

        Employee employeeInstance = null;

        try {
            String query = "SELECT * FROM Employee WHERE ID = (?) ;";

            PreparedStatement statement = conn.prepareStatement(query);
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();

            while (result.next()) {

                employeeInstance = new Employee(
                        result.getInt("ID"),
                        result.getString("First_Name"),
                        result.getString("Last_Name"),
                        result.getString("User_Name"),
                        result.getString("User_Password"),
                        result.getString("Address"),
                        result.getString("Phone"),
                        result.getString("Email"),
                        result.getDouble("Rating"));
            }

            statement.close();

        } catch (SQLException e) {
            System.out.println("Error : " + e);
        }

        return employeeInstance;
    }

    public static boolean changePassword(String oldPassword, String newPassword) {
        String username = GlobalData.getUsername();

        try {
            String update = "UPDATE employee SET User_Password = (?) WHERE User_Name= (?) AND User_Password = (?);";

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
            String update = "UPDATE employee SET Email=(?),Phone=(?) WHERE User_Name= (?);";

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

        Employee employeeInstance = null;

        List<Employee> employeeList = new ArrayList<>();

        try {
            String query = "SELECT * FROM EMPLOYEE";

            PreparedStatement statement = conn.prepareStatement(query);
            ResultSet result = statement.executeQuery();

            while (result.next()) {

                employeeInstance = new Employee(
                        result.getInt("ID"),
                        result.getString("First_Name"),
                        result.getString("Last_Name"),
                        result.getString("User_Name"),
                        result.getString("User_Password"),
                        result.getString("Address"),
                        result.getString("Phone"),
                        result.getString("Email"),
                        result.getDouble("Rating"));

                employeeList.add(employeeInstance);
            }
            statement.close();

        } catch (SQLException e) {
            System.out.println(e);
        }

        return employeeList;
    }
    
}
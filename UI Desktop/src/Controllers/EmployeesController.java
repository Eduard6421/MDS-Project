package Controllers;

import Models.Employee;
import Utils.GlobalData;
import Utils.MySQLConnector;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javafx.util.Pair;

public class EmployeesController {

    private static final Connection conn = MySQLConnector.getConnection();

    public static int registerEmployee(String firstName, String lastName, String userName, String password, String phone, String email) {

        try {
            String query = "INSERT INTO employees (Username, Password, FirstName, LastName, Phone, Email, Rating) values (?,?,?,?,?,?,?)";

            float rating = 0;

            PreparedStatement statement = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, userName);
            statement.setString(2, password);
            statement.setString(3, firstName);
            statement.setString(4, lastName);
            statement.setString(5, phone);
            statement.setString(6, email);
            statement.setDouble(7, rating);

            int result = statement.executeUpdate();
            ResultSet rs = statement.getGeneratedKeys();

            if (rs.next()) {
                return rs.getInt(1);
            }

            statement.close();

            return -1;

        } catch (SQLException e) {
            System.out.println(e);
            return -1;
        }
    }

    public static Employee getByAccount(String username, String password) {

        Employee employee = null;

        try {
            String query = "SELECT * FROM employees WHERE Username = (?) AND Password = (?)";

            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, username);
            statement.setString(2, password);
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
            String query = "SELECT * FROM employees WHERE Username = (?)";

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
            String query = "SELECT * FROM employees WHERE Id = (?)";

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

    public static List<Employee> getAll(String companyName) throws SQLException {

        Employee employee = null;

        List<Employee> employees = new ArrayList<>();

        try {
            String query = "SELECT e.Id, e.FirstName, e.LastName, e.Username, e.Password, e.Phone, e.Email, e.Rating FROM employees e "
                    + "JOIN employee_contracts ec ON ec.IdEmployee = e.Id "
                    + "JOIN companies c ON ec.IdCompany = c.Id "
                    + "WHERE c.Username = (?);";

            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, companyName);

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

    public static List<Employee> getAllFree(String companyName, Date data) throws SQLException {
        Employee employee = null;

        List<Employee> employees = new ArrayList<>();

        try {
            String query = "SELECT * "
                    + "FROM ( "
                    + "		SELECT emp1.Id,emp1.Username,emp1.Password,emp1.FirstName,emp1.LastName,emp1.Phone,emp1.Email "
                    + "		FROM employees AS emp1 "
                    + "		JOIN employee_contracts AS ec1 ON emp1.Id = ec1.IdEmployee "
                    + "		JOIN companies AS cmp1 ON cmp1.id =ec1.IdCompany "
                    + "		WHERE cmp1.Username= ? ) AS free_employees "
                    + "WHERE free_employees.id "
                    + "NOT IN ( "
                    + "		SELECT emp.id "
                    + "		FROM employees AS emp "
                    + "		JOIN employee_contracts AS ec ON emp.id = ec.IdEmployee "
                    + "		JOIN companies AS cmp ON cmp.id = ec.IdCompany "
                    + "		JOIN meetings AS mt ON mt.IdEmployee = emp.Id "
                    + "		WHERE cmp.Username= ? AND mt.date= ? );";

            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, companyName);
            statement.setString(2, companyName);
            statement.setDate(3, data);
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
            String query = "SELECT Id, Username FROM employees";

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

    public static Double getAverageRating(int employeeId) {

        Double rating = 0d;

        try {
            String query = "select avg(feedback) as feedback from meetings where idEmployee = ? ";

            PreparedStatement statement = conn.prepareStatement(query);

            statement.setInt(1, employeeId);

            ResultSet result = statement.executeQuery();

            while (result.next()) {
                rating = result.getDouble("feedback");
            }

        } catch (SQLException e) {
            System.out.println("Exception : " + e);
        }
        return rating;
    }

    public static boolean changePassword(String oldPassword, String newPassword) {
        String username = GlobalData.getUsername();

        try {
            String update = "UPDATE employees SET Password = (?) WHERE Username = (?) AND Password = (?)";

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
            String update = "UPDATE employees SET Email = (?), Phone = (?) WHERE Username = (?)";

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

}

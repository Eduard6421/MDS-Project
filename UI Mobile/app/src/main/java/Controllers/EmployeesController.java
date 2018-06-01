package Controllers;

import android.os.AsyncTask;
import android.util.Pair;

import Models.Employee;
import Utils.GlobalData;
import Utils.MySQLConnector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class EmployeesController {

    private static final Connection conn = MySQLConnector.getConnection();

    /**************************************************************************************************************************************/
    public static Boolean registerEmployee(String firstName, String lastName, String userName, String password, String phone, String email) {

        try {
            AsyncRegisterEmployee asyncRegisterEmployee = new AsyncRegisterEmployee();
            return asyncRegisterEmployee.execute(firstName, lastName, userName, password, phone, email).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        return false;
    }

    public static class AsyncRegisterEmployee extends AsyncTask<String, String, Boolean> {

        @Override
        protected Boolean doInBackground(String... strings) {

            try {
                String query = "INSERT INTO employees (FirstName, LastName, Username, Password, Phone, Email, Rating) values (?,?,?,?,?,?,?,?)";

                Float rating = 0f;

                PreparedStatement statement = conn.prepareStatement(query);
                statement.setString(1, strings[0]);
                statement.setString(2, strings[1]);
                statement.setString(3, strings[2]);
                statement.setString(4, strings[3]);
                statement.setString(5, strings[4]);
                statement.setString(6, strings[5]);
                statement.setFloat(7, rating);

                int result = statement.executeUpdate();

                statement.close();

                return result > 0;

            } catch (SQLException e) {
                return false;
            } finally {
                return false;
            }
        }
    }

    /***************************************************************************/
    public static Employee getByAccount(String username, String password) {

        try {
            AsyncGetByAccount asyncGetByAccount = new AsyncGetByAccount();
            return asyncGetByAccount.execute(username, password).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static class AsyncGetByAccount extends AsyncTask<String, String, Employee> {

        @Override
        protected Employee doInBackground(String... strings) {
            Employee employee = null;

            try {
                String query = "SELECT * FROM employees WHERE Username = (?) AND Password = (?)";

                PreparedStatement statement = conn.prepareStatement(query);
                statement.setString(1, strings[0]);
                statement.setString(2, strings[1]);
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
                            result.getFloat("Rating"));
                }

                statement.close();

            } catch (SQLException e) {
                System.out.println("Error : " + e);
            }

            return employee;
        }
    }

    /*******************************************************************************************/
    public static Employee getByUsername(String username) {

        try {
            AsyncGetByUsername asyncGetByUsername = new AsyncGetByUsername();
            return asyncGetByUsername.execute(username).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static class AsyncGetByUsername extends AsyncTask<String, String, Employee> {

        @Override
        protected Employee doInBackground(String... strings) {

            Employee employee = null;

            try {
                String query = "SELECT * FROM employees WHERE Username = (?)";

                PreparedStatement statement = conn.prepareStatement(query);
                statement.setString(1, strings[0]);
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
                            result.getFloat("Rating"));
                }

                statement.close();

            } catch (SQLException e) {
                System.out.println("Error : " + e);
            }

            return employee;
        }
    }

    /***************************************************************************/
    public static Employee getById(Integer id) {

        try {
            AsyncGetById asyncGetById = new AsyncGetById();
            return asyncGetById.execute(id).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static class AsyncGetById extends AsyncTask<Integer, String, Employee> {

        @Override
        protected Employee doInBackground(Integer... integers) {
            Employee employee = null;

            try {
                String query = "SELECT * FROM employees WHERE Id = (?)";

                PreparedStatement statement = conn.prepareStatement(query);
                statement.setInt(1, integers[0]);
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
                            result.getFloat("Rating"));
                }

                statement.close();

            } catch (SQLException e) {
                System.out.println("Error : " + e);
            }

            return employee;
        }
    }

    /*********************************************************************************************/
    public static Boolean changePassword(String oldPassword, String newPassword) {

        try {
            AsyncChangePassword asyncChangePassword = new AsyncChangePassword();
            return asyncChangePassword.execute(oldPassword, newPassword).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        return false;
    }

    public static class AsyncChangePassword extends AsyncTask<String, String, Boolean> {

        @Override
        protected Boolean doInBackground(String... strings) {
            String username = GlobalData.getUsername();

            try {
                String update = "UPDATE employees SET Password = (?) WHERE Username = (?) AND Password = (?)";

                PreparedStatement statement = conn.prepareStatement(update);
                statement.setString(1, strings[1]);
                statement.setString(2, username);
                statement.setString(3, strings[0]);

                int result = statement.executeUpdate();

                return result > 0;

            } catch (SQLException e) {
                System.out.println("Wrong oldPassword : " + e);
            }

            return false;
        }
    }

    /****************************************************************************************/
    public static Boolean updateData(String email, String phoneNumber) {

        try {
            AsyncUpdateData asyncUpdateData = new AsyncUpdateData();
            return asyncUpdateData.execute(email, phoneNumber).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        return false;
    }

    public static class AsyncUpdateData extends AsyncTask<String, String, Boolean> {

        @Override
        protected Boolean doInBackground(String... strings) {
            String username = GlobalData.getUsername();

            try {
                String update = "UPDATE employees SET Email = (?), Phone = (?) WHERE Username = (?)";

                PreparedStatement statement = conn.prepareStatement(update);
                statement.setString(1, strings[0]);
                statement.setString(2, strings[1]);
                statement.setString(3, username);

                int result = statement.executeUpdate();

                return result > 0;

            } catch (SQLException e) {
                System.out.println("Error : " + e);
            }

            return false;
        }
    }

    /*****************************************************************************/
    private static List<Employee> getAll() throws SQLException {

        try {
            AsyncGetAll asyncGetAll = new AsyncGetAll();
            return asyncGetAll.execute().get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static class AsyncGetAll extends AsyncTask<String, String, List<Employee>> {

        @Override
        protected List<Employee> doInBackground(String... strings) {
            Employee employee = null;

            List<Employee> employees = new ArrayList<>();

            try {
                String query = "SELECT * FROM employees";

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
                            result.getFloat("Rating"));

                    employees.add(employee);
                }
                statement.close();

            } catch (SQLException e) {
                System.out.println(e);
            }

            return employees;
        }
    }

    /**************************************************************************************/
    public static List<Pair<Integer, String>> getAllOnlyGeneralData() throws SQLException {

        try {
            AsyncGetAllOnlyGeneralData asyncGetAllOnlyGeneralData = new AsyncGetAllOnlyGeneralData();
            return asyncGetAllOnlyGeneralData.execute().get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static class AsyncGetAllOnlyGeneralData extends AsyncTask<String, String, List<Pair<Integer, String>>> {

        @Override
        protected List<Pair<Integer, String>> doInBackground(String... strings) {

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
    }

    /*******************************************************************************/
    public static Double getAverageRating(Integer employeeId) {

        try {
            AsyncGetAverageRating asyncGetAverageRating = new AsyncGetAverageRating();
            return asyncGetAverageRating.execute(employeeId).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static class AsyncGetAverageRating extends AsyncTask<Integer, String, Double> {

        @Override
        protected Double doInBackground(Integer... integers) {

            Double rating = 0d;

            try {
                String query = "select avg(feedback) from meetings where idEmployee = ? ";

                PreparedStatement statement = conn.prepareStatement(query);

                statement.setInt(1, integers[0]);

                ResultSet result = statement.executeQuery();

                while (result.next()) {
                    rating = result.getDouble("feedback");
                }

            } catch (SQLException e) {
                System.out.println("Exception : " + e);
            }
            return rating;
        }
    }

}

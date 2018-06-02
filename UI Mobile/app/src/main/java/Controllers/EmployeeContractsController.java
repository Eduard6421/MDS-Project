package Controllers;

import android.os.AsyncTask;

import Models.EmployeeContract;
import Utils.MySQLConnector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.util.concurrent.ExecutionException;

public class EmployeeContractsController {

    private static final Connection conn = MySQLConnector.getConnection();

    /********************************************************************************************************************************/
    public static Boolean createEmployeeContract(Integer companyId, Integer employeeId, java.sql.Date startDate, java.sql.Date endDate) {

        try {
            AsyncCreateEmployeeContract asyncCreateEmployeeContract = new AsyncCreateEmployeeContract();
            return asyncCreateEmployeeContract.execute(companyId, employeeId, startDate, endDate).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        return false;
    }

    public static class AsyncCreateEmployeeContract extends AsyncTask<Object, String, Boolean> {

        @Override
        protected Boolean doInBackground(Object... objects) {

            java.sql.Date SQLStartDate = new java.sql.Date(((java.sql.Date)objects[2]).getTime());
            java.sql.Date SQLEndDate = new java.sql.Date(((java.sql.Date)objects[3]).getTime());

            try {
                String query = "INSERT INTO employee_contracts (IdCompany, IdEmployee, StartDate, EndDate) VALUES (?,?,?,?)";

                PreparedStatement statement = conn.prepareStatement(query);

                statement.setInt(1, (Integer)objects[0]);
                statement.setInt(2, (Integer)objects[1]);
                statement.setDate(3, SQLStartDate);
                statement.setDate(4, SQLEndDate);

                int result = statement.executeUpdate();

                statement.close();

                return result > 0;

            } catch (SQLException e) {
                System.out.println("Exception : " + e);
            }

            return false;
        }
    }

    /**********************************************************************************************/
    public static EmployeeContract getById(Integer id) {

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

    public static class AsyncGetById extends AsyncTask<Integer, String, EmployeeContract> {

        @Override
        protected EmployeeContract doInBackground(Integer... integers) {

            EmployeeContract employeeContract = null;

            try {
                String query = "SELECT * FROM employee_contracts WHERE Id = (?)";

                PreparedStatement statement = conn.prepareStatement(query);
                statement.setInt(1, integers[0]);
                ResultSet result = statement.executeQuery();

                while (result.next()) {

                    employeeContract = new EmployeeContract(
                            result.getInt("Id"),
                            result.getInt("IdEmployee"),
                            result.getInt("IdCompany"),
                            result.getDate("StartDate"),
                            result.getDate("EndDate"));
                }

                statement.close();

            } catch (SQLException e) {
                System.out.println(e);
            }

            return employeeContract;
        }
    }

    /************************************************************************/
    public static List<EmployeeContract> getByEmployee(Integer id) {

        try {
            AsyncGetByEmployee asyncGetByEmployee = new AsyncGetByEmployee();
            return asyncGetByEmployee.execute(id).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static class AsyncGetByEmployee extends AsyncTask<Integer, String, List<EmployeeContract>> {

        @Override
        protected List<EmployeeContract> doInBackground(Integer... integers) {

            EmployeeContract employeeContract = null;

            List<EmployeeContract> employeeContracts = new ArrayList<>();

            try {
                String query = "SELECT * FROM employee_contracts WHERE IdEmployee = (?)";

                PreparedStatement statement = conn.prepareStatement(query);
                statement.setInt(1, integers[0]);
                ResultSet result = statement.executeQuery();

                while (result.next()) {

                    employeeContract = new EmployeeContract(
                            result.getInt("Id"),
                            result.getInt("IdEmployee"),
                            result.getInt("IdCompany"),
                            result.getDate("StartDate"),
                            result.getDate("EndDate"));

                    employeeContracts.add(employeeContract);

                }

                statement.close();

            } catch (SQLException e) {
                System.out.println(e);
            }

            return employeeContracts;
        }
    }

    /*************************************************************/
    public static List<EmployeeContract> getByCompany(Integer id) {

        try {
            AsyncGetByCompany asyncGetByCompany = new AsyncGetByCompany();
            return asyncGetByCompany.execute(id).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static class AsyncGetByCompany extends AsyncTask<Integer, String, List<EmployeeContract>> {

        @Override
        protected List<EmployeeContract> doInBackground(Integer... integers) {

            EmployeeContract employeeContract = null;

            List<EmployeeContract> employeeContracts = new ArrayList<>();

            try {
                String query = "SELECT * FROM employee_contracts WHERE IdCompany = (?)";

                PreparedStatement statement = conn.prepareStatement(query);
                statement.setInt(1, integers[0]);
                ResultSet result = statement.executeQuery();

                while (result.next()) {
                    employeeContract = new EmployeeContract(
                            result.getInt("Id"),
                            result.getInt("IdEmployee"),
                            result.getInt("IdCompany"),
                            result.getDate("StartDate"),
                            result.getDate("EndDate"));

                    employeeContracts.add(employeeContract);
                }
                statement.close();

            } catch (SQLException e) {
                System.out.println(e);
            }

            return employeeContracts;
        }
    }
}

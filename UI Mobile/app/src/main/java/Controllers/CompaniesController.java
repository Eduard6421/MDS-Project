package Controllers;

import android.os.AsyncTask;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import Models.Company;
import Utils.MySQLConnector;

public class CompaniesController {

    private static final Connection conn = MySQLConnector.getConnection();

    /*************************************************************************/
    public static Company getByAccount(String username, String password) {

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

    public static class AsyncGetByAccount extends AsyncTask<String, String, Company> {

        @Override
        protected Company doInBackground(String... strings) {
            Company company = null;

            try {
                String query = "SELECT * FROM companies WHERE Username = (?) AND Password = (?)";

                PreparedStatement statement = conn.prepareStatement(query);
                statement.setString(1, strings[0]);
                statement.setString(2, strings[1]);

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
    }

    /**************************************************************************************/
    public static Company getByUsername(String username) {

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

    public static class AsyncGetByUsername extends AsyncTask<String, String, Company> {

        @Override
        protected Company doInBackground(String... strings) {

            Company company = null;

            try {
                String query = "SELECT * FROM companies WHERE Username = (?)";

                PreparedStatement statement = conn.prepareStatement(query);
                statement.setString(1, strings[0]);
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
    }

    /***************************************************************************************/
    public static Company getById(Integer id) {

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

    public static class AsyncGetById extends AsyncTask<Integer, String, Company> {

        @Override
        protected Company doInBackground(Integer... integers) {

            Company company = null;

            try {
                String query = "SELECT * FROM companies WHERE Id = (?)";

                PreparedStatement statement = conn.prepareStatement(query);
                statement.setInt(1, integers[0]);
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
    }

    /******************************************************************************/
    public static Company getByName(String name) {

        try {
            AsyncGetByName asyncGetByName = new AsyncGetByName();
            return asyncGetByName.execute(name).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static class AsyncGetByName extends AsyncTask<String, String, Company> {

        @Override
        protected Company doInBackground(String... strings) {
            Company company = null;

            try {
                String query = "SELECT * FROM companies WHERE name = (?)";

                PreparedStatement statement = conn.prepareStatement(query);
                statement.setString(1,strings[0]);
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
    }

    /**************************************************************************************/
    public static List<Company> getByClient(Integer clientId) {

        try {
            AsyncGetByClient asyncGetByClient = new AsyncGetByClient();
            return asyncGetByClient.execute(clientId).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        return null;

    }

    public static class AsyncGetByClient extends AsyncTask<Integer, String, List<Company>> {

        @Override
        protected List<Company> doInBackground(Integer... integers) {

            Company company;
            List<Company> companies = new ArrayList<>();

            try {
                String query = "select cmp.Id,cmp.Name,cmp.ContractStartDate,cmp.ContractEndDate,cmp.Description,cmp.Username,cmp.Password from companies as cmp join client_contracts  con on  cmp.id = con.IdCompany join clients clt on clt.Id = con.IdClient where clt.id = ?";

                PreparedStatement statement = conn.prepareStatement(query);
                statement.setInt(1, integers[0]);

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
                e.printStackTrace();
            }

            return companies;
        }
    }

    /************************************************************************************/
    public static List<Company> getAll() {

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

    public static class AsyncGetAll extends AsyncTask<String, String, List<Company>> {

        @Override
        protected List<Company> doInBackground(String... strings) {

            Company company = null;

            List<Company> companies = new ArrayList<>();

            try {
                String query = "SELECT * FROM companies";

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
    
}

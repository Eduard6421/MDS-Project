package Controllers;

import android.os.AsyncTask;
import android.util.Pair;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import Models.Client;
import Utils.GlobalData;
import Utils.MySQLConnector;

public class ClientsController {

    private static Connection conn = MySQLConnector.getConnection();

    /*********************************************************************************************************************************************************/
    public static Boolean registerClient(String firstName, String lastName,String userName, String userPassword, String address, String phone, String email) {

        try {
            AsyncRegisterClient asyncRegisterClient = new AsyncRegisterClient();
            return asyncRegisterClient.execute(firstName, lastName, userName, userPassword, address, phone, email).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        return false;
    }

    public static class AsyncRegisterClient extends AsyncTask<String, String, Boolean> {

        @Override
        protected Boolean doInBackground(String... strings) {

            try {
                String query = "INSERT INTO clients (FirstName, LastName, Username, Password, Address, Phone, Email) values (?,?,?,?,?,?,?)";

                PreparedStatement statement = conn.prepareStatement(query);
                statement.setString(1, strings[0]);
                statement.setString(2, strings[1]);
                statement.setString(3, strings[2]);
                statement.setString(4, strings[3]);
                statement.setString(5, strings[4]);
                statement.setString(6, strings[5]);
                statement.setString(7, strings[6]);

                int result = statement.executeUpdate();

                statement.close();

                return result > 0;

            } catch (SQLException e) {
                return false;
            }
        }
    }

    /******************************************************************************************/
    public static Client getByAccount(String username, String password) {

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

    public static class AsyncGetByAccount extends AsyncTask<String, String, Client> {

        @Override
        protected Client doInBackground(String... strings) {
            Client client = null;

            try {
                String query = "SELECT * FROM clients WHERE Username = (?) AND Password = (?)";

                PreparedStatement statement = conn.prepareStatement(query);
                statement.setString(1, strings[0]);
                statement.setString(2, strings[1]);
                ResultSet result = statement.executeQuery();

                while (result.next()) {

                    client = new Client(
                            result.getInt("Id"),
                            result.getString("FirstName"),
                            result.getString("LastName"),
                            result.getString("Username"),
                            result.getString("Password"),
                            result.getString("Address"),
                            result.getString("Phone"),
                            result.getString("Email"));
                }

                statement.close();

            } catch (SQLException e) {
                System.out.println("Error : " + e);
            }

            return client;
        }
    }

    /************************************************************************/
    public static Client getByUsername(String username) {

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

    public static class AsyncGetByUsername extends AsyncTask<String, String, Client> {

        @Override
        protected Client doInBackground(String... strings) {

            Client client = null;

            try {
                String query = "SELECT * FROM clients WHERE Username = (?)";

                PreparedStatement statement = conn.prepareStatement(query);
                statement.setString(1, strings[0]);
                ResultSet result = statement.executeQuery();

                while (result.next()) {

                    client = new Client(
                            result.getInt("Id"),
                            result.getString("FirstName"),
                            result.getString("LastName"),
                            result.getString("Username"),
                            result.getString("Password"),
                            result.getString("Address"),
                            result.getString("Phone"),
                            result.getString("Email"));
                }

                statement.close();

            } catch (SQLException e) {
                System.out.println("Error : " + e);
            }

            return client;
        }
    }

    /************************************************************/
    public static Client getById(Integer id) {

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

    public static class AsyncGetById extends AsyncTask<Integer, String, Client> {

        @Override
        protected Client doInBackground(Integer... integers) {

            Client client = null;

            try {
                String query = "SELECT * FROM clients WHERE Id = (?)";

                PreparedStatement statement = conn.prepareStatement(query);
                statement.setInt(1, integers[0]);
                ResultSet result = statement.executeQuery();

                while (result.next()) {

                    client = new Client(
                            result.getInt("Id"),
                            result.getString("FirstName"),
                            result.getString("LastName"),
                            result.getString("Username"),
                            result.getString("Password"),
                            result.getString("Address"),
                            result.getString("Phone"),
                            result.getString("Email"));
                }

                statement.close();

            } catch (SQLException e) {
                System.out.println("Error : " + e);
            }

            return client;
        }
    }

    /**********************************************************************************/
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
                String update = "UPDATE clients SET Password = (?) WHERE Username = (?) AND Password = (?)";

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

    /*********************************************************************************************/
    public static Boolean updateData(String email, String phoneNumber, String address) {

        try {
            AsyncUpdateData asyncUpdateData = new AsyncUpdateData();
            return asyncUpdateData.execute(email, phoneNumber, address).get();
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
                String update = "UPDATE clients SET Email = (?), Phone = (?), Address = (?) WHERE Username = (?)";

                PreparedStatement statement = conn.prepareStatement(update);
                statement.setString(1, strings[0]);
                statement.setString(2, strings[1]);
                statement.setString(3, strings[2]);
                statement.setString(4, username);

                int result = statement.executeUpdate();

                return result > 0;

            } catch (SQLException e) {
                System.out.println("Error : " + e);
            }

            return false;
        }
    }

    /*************************************************************/
    public static List<Client> getAll(String companyName) {

        try {
            AsyncGetAll asyncGetAll = new AsyncGetAll();
            return asyncGetAll.execute(companyName).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static class AsyncGetAll extends AsyncTask<String, String, List<Client>> {

        @Override
        protected List<Client> doInBackground(String... strings) {

            Client client = null;

            List<Client> clients = new ArrayList<>();

            try {
                String query = "select clt.FirstName,clt.LastName,clt.Username,clt.Password,clt.Address,clt.Phone,clt.Email from clients as clt  join client_contracts as cc on clt.id = cc.idClient join companies as cpy on cpy.id = cc.idCompany where cpy.name = (?);";

                PreparedStatement statement = conn.prepareStatement(query);
                ResultSet result = statement.executeQuery();
                statement.setString(1, strings[0]);

                while (result.next()) {

                    client = new Client(
                            result.getInt("Id"),
                            result.getString("FirstName"),
                            result.getString("LastName"),
                            result.getString("Username"),
                            result.getString("Password"),
                            result.getString("Address"),
                            result.getString("Phone"),
                            result.getString("Email"));

                    clients.add(client);
                }

                statement.close();

            } catch (SQLException e) {
                System.out.println("Error : " + e);
            }

            return clients;
        }
    }

    /***************************************************************************************/
    public static List<Pair<Integer, String>> getAllOnlyGeneralData(String companyName) throws SQLException {

        try {
            AsyncGetAllOnlyGeneralData asyncGetAllOnlyGeneralData = new AsyncGetAllOnlyGeneralData();
            return asyncGetAllOnlyGeneralData.execute(companyName).get();
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

            Pair<Integer, String> client = null;

            List<Pair<Integer, String>> clients = new ArrayList<>();

            try {
                String query = "select clt.Id,clt.Username from clients as clt join client_contracts as cc on clt.id = cc.idClient join companies as cpy on cpy.id = cc.idCompany where cpy.name = (?);";

                PreparedStatement statement = conn.prepareStatement(query);
                ResultSet result = statement.executeQuery();
                statement.setString(1, strings[0]);

                while (result.next()) {

                    client = new Pair<Integer, String>(result.getInt("Id"),
                            result.getString("Username"));

                    clients.add(client);
                }

                statement.close();

            } catch (SQLException e) {
                System.out.println("Error : " + e);
            }

            return clients;
        }
    }
}

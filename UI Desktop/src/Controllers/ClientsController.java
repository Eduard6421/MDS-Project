package Controllers;

import Models.Client;
import Utils.GlobalData;
import Utils.MySQLConnector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javafx.util.Pair;

public class ClientsController {

    private static final Connection conn = MySQLConnector.getConnection();
    /**
     * Creates a new client with the given parameters.
     * @param firstName
     * @param lastName
     * @param userName
     * @param userPassword
     * @param address
     * @param phone
     * @param email
     * @return 
     */
    public static boolean registerClient(String firstName, String lastName, String userName, String userPassword, String address, String phone, String email) {

        try {
            String query = "INSERT INTO clients (FirstName, LastName, Username, Password, Address, Phone, Email) values (?,?,?,?,?,?,?)";

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
    /**
     * Selects a client by its username and password.
     * @param username
     * @param password
     * @return 
     */
    public static Client getByAccount(String username, String password) {
        Client client = null;

        try {
            String query = "SELECT * FROM clients WHERE Username = (?) AND Password = (?)";

            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, username);
            statement.setString(2, password);
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
    /**
     * Selects a client by its username.
     * @param username
     * @return 
     */
    public static Client getByUsername(String username) {

        Client client = null;

        try {
            String query = "SELECT * FROM clients WHERE Username = (?)";

            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, username);
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
    /**
     * Selects a client by its id.
     * @param id
     * @return 
     */
    public static Client getById(int id) {

        Client client = null;

        try {
            String query = "SELECT * FROM clients WHERE Id = (?)";

            PreparedStatement statement = conn.prepareStatement(query);
            statement.setInt(1, id);
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
    /**
     * It changes the password of a client with a new one.
     * @param oldPassword
     * @param newPassword
     * @return 
     */
    public static boolean changePassword(String oldPassword, String newPassword) {
        String username = GlobalData.getUsername();

        try {
            String update = "UPDATE clients SET Password = (?) WHERE Username = (?) AND Password = (?)";

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
    /**
     * Updates the email and the phone number of a client.
     * @param email
     * @param phoneNumber
     * @return 
     */
    public static boolean updateData(String email, String phoneNumber) {
        String username = GlobalData.getUsername();

        try {
            String update = "UPDATE clients SET Email = (?), Phone = (?) WHERE Username = (?)";

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
    /**
     * Creates a list of clients of a given company name.
     * @param companyName
     * @return
     * @throws SQLException 
     */
    public static List<Client> getAll(String companyName) throws SQLException {

        Client client = null;

        List<Client> clients = new ArrayList<>();

        try {
            String query = "select clt.Id,clt.FirstName,clt.LastName,clt.Username,clt.Password,clt.Address,clt.Phone,clt.Email from clients as clt  join client_contracts as cc on clt.id = cc.idClient join companies as cpy on cpy.id = cc.idCompany where cpy.name = (?);";

            PreparedStatement statement = conn.prepareStatement(query);

            statement.setString(1, companyName);

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

                clients.add(client);
            }

            statement.close();

        } catch (SQLException e) {
            System.out.println("Error : " + e);
        }

        return clients;
    }
    /**
     * Creates a list of pairs containing the id and the username of the clients.
     * @param companyName
     * @return
     * @throws SQLException 
     */
    public static List<Pair<Integer, String>> getAllOnlyGeneralData(String companyName) throws SQLException {

        Pair<Integer, String> client = null;

        List<Pair<Integer, String>> clients = new ArrayList<>();

        try {
            String query = "select clt.Id,clt.Username from clients as clt  join client_contracts as cc on clt.id = cc.idClient join companies as cpy on cpy.id = cc.idCompany where cpy.name = (?);";

            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, companyName);
            ResultSet result = statement.executeQuery();

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

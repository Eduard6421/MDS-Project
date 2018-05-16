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

public class ClientsController {

    private static final Connection conn = MySQLConnector.getConnection();

    public static boolean registerClient(String firstName, String lastName,String userName, String userPassword, String address, String phone, String email) {
         
        try {
            String query = "INSERT INTO Clients (FirstName, LastName, Username, Password, Address, Phone, Email) values (?,?,?,?,?,?,?)";

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

    public static Client getByAccount(String username, String password) {
        Client client = null;

        try {
            String query = "SELECT * FROM Clients WHERE Username = (?) AND Password = (?)";

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

    public static Client getByUsername(String username) {

        Client client = null;

        try {
            String query = "SELECT * FROM Clients WHERE Username = (?)";

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

    public static Client getById(int id) {

        Client client = null;

        try {
            String query = "SELECT * FROM Clients WHERE Id = (?)";

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

    public static boolean changePassword(String oldPassword, String newPassword) {
        String username = GlobalData.getUsername();

        try {
            String update = "UPDATE Clients SET Password = (?) WHERE Username = (?) AND Password = (?)";

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
            String update = "UPDATE Clients SET Email = (?), Phone = (?) WHERE Username = (?)";

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

    public static List<Client> getAll() throws SQLException {

        Client client = null;

        List<Client> clients = new ArrayList<>();

        try {
            String query = "SELECT * FROM Clients";

            PreparedStatement statement = conn.prepareStatement(query);
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

}

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

public class ClientController {

    private static final Connection conn = MySQLConnector.getConnection();

    public static boolean registerClient(String firstName, String lastName,String userName, String userPassword, String address, String phone, String email) {
         
        try {
            String query = "INSERT INTO CLIENT (FIRST_NAME,LAST_NAME,USER_NAME,USER_PASSWORD,ADDRESS,PHONE,EMAIL) values (?,?,?,?,?,?,?);";

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
        Client clientInstance = null;

        try {
            String query = "SELECT * FROM client WHERE USER_NAME = (?) AND USER_PASSWORD = (?) ;";

            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, username);
            statement.setString(2, password);
            ResultSet result = statement.executeQuery();

            while (result.next()) {

                clientInstance = new Client(
                        result.getInt("ID"),
                        result.getString("FIRST_NAME"),
                        result.getString("LAST_NAME"),
                        result.getString("USER_NAME"),
                        result.getString("USER_PASSWORD"),
                        result.getString("ADDRESS"),
                        result.getString("PHONE"),
                        result.getString("EMAIL"));
            }

            statement.close();

        } catch (SQLException e) {
            System.out.println("Error : " + e);
        }

        return clientInstance;
    }

    public static Client getByUsername(String username) {

        Client clientInstance = null;

        try {
            String query = "SELECT * FROM CLIENT WHERE USER_NAME = (?) ;";

            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, username);
            ResultSet result = statement.executeQuery();

            while (result.next()) {

                clientInstance = new Client(
                        result.getInt("ID"),
                        result.getString("FIRST_NAME"),
                        result.getString("LAST_NAME"),
                        result.getString("USER_NAME"),
                        result.getString("USER_PASSWORD"),
                        result.getString("ADDRESS"),
                        result.getString("PHONE"),
                        result.getString("EMAIL"));
            }

            statement.close();

        } catch (SQLException e) {
            System.out.println("Error : " + e);
        }

        return clientInstance;
    }

    public static Client getById(int id) {

        Client clientInstance = null;

        try {
            String query = "SELECT * FROM CLIENT WHERE ID = (?) ;";

            PreparedStatement statement = conn.prepareStatement(query);
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();

            while (result.next()) {

                clientInstance = new Client(
                        result.getInt("ID"),
                        result.getString("FIRST_NAME"),
                        result.getString("LAST_NAME"),
                        result.getString("USER_NAME"),
                        result.getString("USER_PASSWORD"),
                        result.getString("ADDRESS"),
                        result.getString("PHONE"),
                        result.getString("EMAIL"));
            }

            statement.close();

        } catch (SQLException e) {
            System.out.println("Error : " + e);
        }

        return clientInstance;
    }

    public static boolean changePassword(String oldPassword, String newPassword) {
        String username = GlobalData.getUsername();

        try {
            String update = "UPDATE client SET User_Password = (?) WHERE User_Name= (?) AND User_Password = (?);";

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
            String update = "UPDATE client SET Email=(?),Phone=(?) WHERE User_Name= (?);";

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

        Client clientInstance = null;

        List<Client> clientList = new ArrayList<>();

        try {
            String query = "SELECT * FROM CLIENT;";

            PreparedStatement statement = conn.prepareStatement(query);
            ResultSet result = statement.executeQuery();

            while (result.next()) {

                clientInstance = new Client(
                        result.getInt("ID"),
                        result.getString("FIRST_NAME"),
                        result.getString("LAST_NAME"),
                        result.getString("USER_NAME"),
                        result.getString("USER_PASSWORD"),
                        result.getString("ADDRESS"),
                        result.getString("PHONE"),
                        result.getString("EMAIL"));

                clientList.add(clientInstance);
            }

            statement.close();

        } catch (SQLException e) {
            System.out.println("Error : " + e);
        }

        return clientList;
    }

}
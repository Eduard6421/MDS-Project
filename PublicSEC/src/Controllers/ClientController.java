/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.Client;
import Util.GlobalData;
import Util.MySQLConnector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClientController {

    private static final Connection Conn = MySQLConnector.getConnection();

    public static Client getByAccount(String Username, String Password) {
        Client clientInstance = null;

        try {

            String query = "SELECT * FROM CLIENT WHERE USERNAME = (?) AND PASSWORD = (?) ;";

            PreparedStatement statement = Conn.prepareStatement(query);
            statement.setString(1, Username);
            statement.setString(2, Password);
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

    public static Client getByUsername(String Username) {

        Client clientInstance = null;

        try {

            String query = "SELECT * FROM CLIENT WHERE USERNAME = (?) ;";

            PreparedStatement statement = Conn.prepareStatement(query);
            statement.setString(1, Username);
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

            PreparedStatement statement = Conn.prepareStatement(query);
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
        String Username = GlobalData.getUsername();

        try {

            String update = "UPDATE client SET User_Password = (?) WHERE User_Name= (?) AND User_Password = (?);";

            PreparedStatement statement = Conn.prepareStatement(update);
            statement.setString(1, newPassword);
            statement.setString(2, Username);
            statement.setString(3, oldPassword);

            int result = statement.executeUpdate();

            return result > 0;

        } catch (SQLException e) {
            System.out.println("Wrong oldPassword : " + e);
        }

        return false;
    }

    public static boolean updateData(String email, String phoneNumber) {
        String Username = GlobalData.getUsername();

        try {

            String update = "UPDATE client SET Email=(?),Phone=(?) WHERE User_Name= (?);";

            PreparedStatement statement = Conn.prepareStatement(update);
            statement.setString(1, email);
            statement.setString(2, phoneNumber);
            statement.setString(3, Username);

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

            PreparedStatement statement = Conn.prepareStatement(query);
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

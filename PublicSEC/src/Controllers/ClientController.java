/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.Client;
import Util.MySQLConnector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClientController {

    private static final Connection Conn = MySQLConnector.getConnection();

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

    private static List<Client> getAll() throws SQLException {

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

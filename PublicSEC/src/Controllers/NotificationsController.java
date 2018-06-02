/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Utils.MySQLConnector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Eduard
 */
public class NotificationsController {

    private static final Connection conn = MySQLConnector.getConnection();

    public static boolean createNotification(int clientId, int employeeId, int meetingId, boolean notifyClient, boolean notifyEmployee) {

        boolean result = false;

        try {
            String query = "INSERT INTO notifications(ClientId,EmployeeId,MeetingId,NotifyClient,NotifyEmployee) VALUES (?,?,?,?,?)";

            PreparedStatement statement = conn.prepareStatement(query);

            statement.setInt(1, clientId);
            statement.setInt(2, employeeId);
            statement.setInt(3, meetingId);
            statement.setBoolean(4, notifyClient);
            statement.setBoolean(5, notifyEmployee);

            result = statement.executeUpdate() > 0;

            statement.close();

            return result;

        } catch (SQLException e) {
            System.out.println("Exception : " + e);
        }

        return result;

    }

    public static boolean getNotificationByClientId(int clientId) {

        boolean result = false;

        try {
            String query = "select count(*) from notifications where clientId = ? and notifyClient = 1";

            PreparedStatement statement = conn.prepareStatement(query);

            statement.setInt(1, clientId);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {

                result = true;
            }

            statement.close();

            return result;

        } catch (SQLException e) {
            System.out.println("Exception : " + e);
        }

        return false;

    }

    public static boolean getNotificationByEmployeeId(int employeeId) {

        boolean result = false;

        try {
            String query = "select count(*) from notifications where employeeId = ? and notifyClient = 1";

            PreparedStatement statement = conn.prepareStatement(query);

            statement.setInt(1, employeeId);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {

                result = true;
            }

            statement.close();

            return result;

        } catch (SQLException e) {
            System.out.println("Exception : " + e);
        }

        return false;
    }

    public static boolean seenByClient(int clientId) {
        boolean result = false;

        try {
            String query = "update notifications set NotifyClient = 0 where clientId = ?";

            PreparedStatement statement = conn.prepareStatement(query);

            statement.setInt(1, clientId);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {

                result = true;
            }

            statement.close();

            return result;

        } catch (SQLException e) {
            System.out.println("Exception : " + e);
        }

        return false;

    }

    public static boolean seenByEmployee(int employeeId) {
        boolean result = false;

        try {
            String query = "update notifications set NotifyClient = 0 where employeeId = ?";

            PreparedStatement statement = conn.prepareStatement(query);

            statement.setInt(1, employeeId);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {

                result = true;
            }

            statement.close();

            return result;

        } catch (SQLException e) {
            System.out.println("Exception : " + e);
        }

        return false;

    }

    public static boolean notifyClient(int clientId, int meetingId) {

        boolean result = false;

        try {
            String query = "update notifications set NotifyClient = 1 where clientId = ? and meetingId = ?";

            PreparedStatement statement = conn.prepareStatement(query);

            statement.setInt(1, clientId);
            statement.setInt(2, meetingId);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {

                result = true;
            }

            statement.close();

            return result;

        } catch (SQLException e) {
            System.out.println("Exception : " + e);
        }

        return false;
    }

    public static boolean notifyEmployee(int employeeId, int meetingId) {
        boolean result = false;

        try {
            String query = "update notifications set NotifyClient = 1 where employeeId = ? and meetingId = ?";

            PreparedStatement statement = conn.prepareStatement(query);

            statement.setInt(1, employeeId);
            statement.setInt(2, meetingId);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {

                result = true;
            }

            statement.close();

            return result;

        } catch (SQLException e) {
            System.out.println("Exception : " + e);
        }

        return false;
    }

}

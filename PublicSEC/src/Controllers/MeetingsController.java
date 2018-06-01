package Controllers;

import Models.Meeting;
import Utils.MySQLConnector;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MeetingsController {

    private static final Connection conn = MySQLConnector.getConnection();

    public static boolean createMeeting(int clientId, int companyId,
            Date date, String Description) {

        try {
            String query = "INSERT INTO Meetings (IdClient, Idcompany,Date,Description) VALUES (?,?,?,?)";

            PreparedStatement statement = conn.prepareStatement(query);

            java.sql.Date SQLDate = new java.sql.Date(date.getTime());

            statement.setInt(1, clientId);
            statement.setInt(2, companyId);
            statement.setDate(3, SQLDate);
            statement.setString(4, Description);
            int result = statement.executeUpdate();

            statement.close();

            return result > 0;

        } catch (SQLException e) {
            System.out.println("Error : " + e);
        }

        return false;
    }

    public static List<Meeting> getAll() {
        Meeting meeting = null;

        List<Meeting> meetings = new ArrayList<>();

        try {
            String query = "SELECT * FROM Meetings";

            Statement statement = conn.createStatement();

            ResultSet result = statement.executeQuery(query);

            while (result.next()) {

                meeting = new Meeting(
                        result.getInt("IdClient"),
                        result.getInt("IdCompany"),
                        result.getInt("IdEmployee"),
                        result.getDate("Date"),
                        result.getDouble("Feedback"),
                        result.getString("Description"),
                        result.getBoolean("IsOpen"));

                meetings.add(meeting);

            }

            statement.close();

        } catch (SQLException e) {
            System.out.println("Error " + e);
        }

        return meetings;
    }

    public static List<Meeting> getAllOpen() {

        Meeting meeting = null;

        List<Meeting> meetings = new ArrayList<>();

        try {
            String query = "SELECT * FROM Meetings where IsOpen = 1";

            Statement statement = conn.createStatement();

            ResultSet result = statement.executeQuery(query);

            while (result.next()) {

                meeting = new Meeting(
                        result.getInt("IdClient"),
                        result.getInt("IdCompany"),
                        result.getInt("IdEmployee"),
                        result.getDate("Date"),
                        result.getDouble("Feedback"),
                        result.getString("Description"),
                        result.getBoolean("IsOpen"));

                meetings.add(meeting);

            }

            statement.close();

        } catch (SQLException e) {
            System.out.println("Error " + e);
        }

        return meetings;

    }

    public static List<Meeting> getAllClosed() {
        Meeting meeting = null;

        List<Meeting> meetings = new ArrayList<>();

        try {
            String query = "SELECT * FROM Meetings where IsOpen = 0";

            Statement statement = conn.createStatement();

            ResultSet result = statement.executeQuery(query);

            while (result.next()) {

                meeting = new Meeting(
                        result.getInt("IdClient"),
                        result.getInt("IdCompany"),
                        result.getInt("IdEmployee"),
                        result.getDate("Date"),
                        result.getDouble("Feedback"),
                        result.getString("Description"),
                        result.getBoolean("IsOpen"));

                meetings.add(meeting);

            }

            statement.close();

        } catch (SQLException e) {
            System.out.println("Error " + e);
        }

        return meetings;
    }

    public static Meeting getByClient(int clientId) {
        Meeting meeting = null;

        try {
            String query = "SELECT * FROM Meetings WHERE IdClient = (?)";

            PreparedStatement statement = conn.prepareStatement(query);
            statement.setInt(1, clientId);
            ResultSet result = statement.executeQuery();

            while (result.next()) {

                meeting = new Meeting(
                        result.getInt("IdClient"),
                        result.getInt("IdCompany"),
                        result.getInt("IdEmployee"),
                        result.getDate("Date"),
                        result.getDouble("Feedback"),
                        result.getString("Description"),
                        result.getBoolean("IsOpen"));

            }
            statement.close();

        } catch (Exception e) {
            System.out.println("Error " + e);
        }

        return meeting;
    }

    public static List<Meeting> getAllByEmployee(int employeeId) {
        Meeting meeting = null;

        List<Meeting> meetings = new ArrayList<>();

        try {
            String query = "SELECT * FROM Meetings WHERE IdEmployee = (?)";

            PreparedStatement statement = conn.prepareStatement(query);
            statement.setInt(1, employeeId);
            ResultSet result = statement.executeQuery();

            while (result.next()) {

                meeting = new Meeting(
                        result.getInt("IdClient"),
                        result.getInt("IdCompany"),
                        result.getInt("IdEmployee"),
                        result.getDate("Date"),
                        result.getDouble("Feedback"),
                        result.getString("Description"),
                        result.getBoolean("IsOpen"));

                meetings.add(meeting);
            }
            statement.close();

        } catch (Exception e) {
            System.out.println("Error " + e);
        }

        return meetings;
    }

    public static List<Meeting> getAllOpenByEmployee(int employeeId) {
        Meeting meeting = null;

        List<Meeting> meetings = new ArrayList<>();

        try {
            String query = "SELECT * FROM Meetings WHERE IdEmployee = (?) AND IsOpen = 1";

            PreparedStatement statement = conn.prepareStatement(query);
            statement.setInt(1, employeeId);
            ResultSet result = statement.executeQuery();

            while (result.next()) {

                meeting = new Meeting(
                        result.getInt("IdClient"),
                        result.getInt("IdCompany"),
                        result.getInt("IdEmployee"),
                        result.getDate("Date"),
                        result.getDouble("Feedback"),
                        result.getString("Description"),
                        result.getBoolean("IsOpen"));

                meetings.add(meeting);
            }
            statement.close();

        } catch (Exception e) {
            System.out.println("Error " + e);
        }

        return meetings;
    }

    public static List<Meeting> getAllClosedByEmployee(int employeeId) {
        Meeting meeting = null;

        List<Meeting> meetings = new ArrayList<>();

        try {
            String query = "SELECT * FROM Meetings WHERE IdEmployee = (?) AND IsOpen = 0";

            PreparedStatement statement = conn.prepareStatement(query);
            statement.setInt(1, employeeId);
            ResultSet result = statement.executeQuery();

            while (result.next()) {

                meeting = new Meeting(
                        result.getInt("IdClient"),
                        result.getInt("IdCompany"),
                        result.getInt("IdEmployee"),
                        result.getDate("Date"),
                        result.getDouble("Feedback"),
                        result.getString("Description"),
                        result.getBoolean("IsOpen"));

                meetings.add(meeting);
            }
            statement.close();

        } catch (Exception e) {
            System.out.println("Error " + e);
        }

        return meetings;
    }

    public static List<Meeting> getAllOpenByClient(int clientId) {
        Meeting meeting = null;

        List<Meeting> meetings = new ArrayList<>();

        try {
            String query = "SELECT * FROM Meetings WHERE IdClient = (?) AND IsOpen = 1";

            PreparedStatement statement = conn.prepareStatement(query);
            statement.setInt(1, clientId);
            ResultSet result = statement.executeQuery();

            while (result.next()) {

                meeting = new Meeting(
                        result.getInt("IdClient"),
                        result.getInt("IdCompany"),
                        result.getInt("IdEmployee"),
                        result.getDate("Date"),
                        result.getDouble("Feedback"),
                        result.getString("Description"),
                        result.getBoolean("IsOpen"));

                meetings.add(meeting);
            }
            statement.close();

        } catch (Exception e) {
            System.out.println("Error " + e);
        }

        return meetings;

    }

    public static List<Meeting> getAllClosedByClient(int clientId) {
        Meeting meeting = null;

        List<Meeting> meetings = new ArrayList<>();

        try {
            String query = "SELECT * FROM Meetings WHERE IdClient = (?) AND IsOpen = 0";

            PreparedStatement statement = conn.prepareStatement(query);
            statement.setInt(1, clientId);
            ResultSet result = statement.executeQuery();

            while (result.next()) {

                meeting = new Meeting(
                        result.getInt("IdClient"),
                        result.getInt("IdCompany"),
                        result.getInt("IdEmployee"),
                        result.getDate("Date"),
                        result.getDouble("Feedback"),
                        result.getString("Description"),
                        result.getBoolean("IsOpen"));

                meetings.add(meeting);
            }
            statement.close();

        } catch (Exception e) {
            System.out.println("Error " + e);
        }

        return meetings;

    }

    public static Meeting getByMeeting(int id) {

        Meeting meeting = null;

        try {

            String query = "SELECT * FROM Meetings WHERE IdMeeting = (?)";

            PreparedStatement statement = conn.prepareStatement(query);
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();

            while (result.next()) {

                meeting = new Meeting(
                        result.getInt("IdClient"),
                        result.getInt("IdCompany"),
                        result.getInt("IdEmployee"),
                        result.getDate("Date"),
                        result.getDouble("Feedback"),
                        result.getString("Description"),
                        result.getBoolean("IsOpen"));

            }
            statement.close();

        } catch (SQLException e) {
            System.out.println("Error " + e);
        }

        return meeting;
    }

    public static boolean reopenMeeting(int meetingId) {
        try {

            String query = "update meetings set isopen = 0 where id = ?";

            PreparedStatement statement = conn.prepareStatement(query);

            statement.setInt(1, 1);

            int result = statement.executeUpdate();

            statement.close();

            return result > 0;

        } catch (SQLException e) {
            System.out.println("Error : " + e);
        }

        return false;

    }

    public static boolean closeMeeting(int meetingId) {

        try {

            String query = "update meetings set isopen = 0 where id = ?";

            PreparedStatement statement = conn.prepareStatement(query);

            statement.setInt(1, 0);

            int result = statement.executeUpdate();

            statement.close();

            return result > 0;

        } catch (SQLException e) {
            System.out.println("Error : " + e);
        }

        return false;

    }

    public static boolean giveFeedback(int meetingId, Double feedback) {

        try {
            String query = "update meetings set Feedback = ? where Id = ?";

            PreparedStatement statement = conn.prepareStatement(query);
            statement.setInt(1, meetingId);
            statement.setDouble(2, feedback);

            int result = statement.executeUpdate();

            statement.close();

            return result > 0;

        } catch (SQLException e) {
            System.out.println("Error : " + e);

        }

        return false;

    }

}

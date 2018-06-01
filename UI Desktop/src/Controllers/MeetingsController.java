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
            String query = "INSERT INTO meetings (IdClient, Idcompany,Date,Description) VALUES (?,?,?,?)";

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

    public static List<Meeting> getAll(String companyName) {
        Meeting meeting = null;

        List<Meeting> meetings = new ArrayList<>();

        try {
            String query = "select * from meetings where IdCompany = (select Id from companies where username = (?));";

            PreparedStatement statement = conn.prepareStatement(query);

            statement.setString(1, companyName);

            ResultSet result = statement.executeQuery();

            while (result.next()) {

                meeting = new Meeting(
                        result.getInt("IdClient"),
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

    public static List<Meeting> getAllOpen(String companyName) {

        Meeting meeting = null;

        List<Meeting> meetings = new ArrayList<>();

        try {
            String query = "SELECT * FROM meetings where IsOpen = 1 and IdCompany = (select Id from companies where username = (?)";

            PreparedStatement statement = conn.prepareStatement(query);

            statement.setString(1, companyName);

            ResultSet result = statement.executeQuery();

            while (result.next()) {

                meeting = new Meeting(
                        result.getInt("IdClient"),
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

    public static List<Meeting> getAllClosed(String companyName) {
        Meeting meeting = null;

        List<Meeting> meetings = new ArrayList<>();

        try {
            String query = "SELECT * FROM meetings where IsOpen = 0 and IdCompany = (select Id from companies where username = (?)";

            PreparedStatement statement = conn.prepareStatement(query);

            statement.setString(1, companyName);

            ResultSet result = statement.executeQuery();

            while (result.next()) {

                meeting = new Meeting(
                        result.getInt("IdClient"),
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

    public static List<Meeting> getAllByEmployee(String companyName, int employeeId) {
        Meeting meeting = null;

        List<Meeting> meetings = new ArrayList<>();

        try {
            String query = "SELECT * FROM meetings WHERE IdEmployee = (?) and IdCompany = (select Id from companies where username = (?)";

            PreparedStatement statement = conn.prepareStatement(query);
            statement.setInt(1, employeeId);
            statement.setString(2, companyName);
            ResultSet result = statement.executeQuery();

            while (result.next()) {

                meeting = new Meeting(
                        result.getInt("IdClient"),
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

    public static List<Meeting> getAllOpenedByEmployee(String companyName, int employeeId) {
        Meeting meeting = null;

        List<Meeting> meetings = new ArrayList<>();

        try {
            String query = "SELECT * FROM meetings WHERE IdEmployee = (?) AND IsOpen = 1 AND IdCompany = (select Id from companies where username = (?)";

            PreparedStatement statement = conn.prepareStatement(query);
            statement.setInt(1, employeeId);
            statement.setString(2, companyName);
            ResultSet result = statement.executeQuery();

            while (result.next()) {

                meeting = new Meeting(
                        result.getInt("IdClient"),
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

    public static List<Meeting> getAllClosedByEmployee(String companyName, int employeeId) {
        Meeting meeting = null;

        List<Meeting> meetings = new ArrayList<>();

        try {
            String query = "SELECT * FROM meetings WHERE IdEmployee = (?) AND IsOpen = 0 AND IdCompany = (select Id from companies where username = (?)";

            PreparedStatement statement = conn.prepareStatement(query);
            statement.setInt(1, employeeId);
            statement.setString(2, companyName);
            ResultSet result = statement.executeQuery();

            while (result.next()) {

                meeting = new Meeting(
                        result.getInt("IdClient"),
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

    public static List<Meeting> getAllOpenByClient(String companyName, int clientId) {
        Meeting meeting = null;

        List<Meeting> meetings = new ArrayList<>();

        try {
            String query = "SELECT * FROM meetings WHERE IdClient = (?) AND IsOpen = 1 AND IdCompany = (select Id from companies where username = (?)";

            PreparedStatement statement = conn.prepareStatement(query);
            statement.setInt(1, clientId);
            statement.setString(2, companyName);
            ResultSet result = statement.executeQuery();

            while (result.next()) {

                meeting = new Meeting(
                        result.getInt("IdClient"),
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

    public static List<Meeting> getAllClosedByClient(String companyName, int clientId) {
        Meeting meeting = null;

        List<Meeting> meetings = new ArrayList<>();

        try {
            String query = "SELECT * FROM meetings WHERE IdClient = (?) AND IsOpen = 0 AND IdCompany = (select Id from companies where username = (?)";

            PreparedStatement statement = conn.prepareStatement(query);
            statement.setInt(1, clientId);
            statement.setString(2, companyName);
            ResultSet result = statement.executeQuery();

            while (result.next()) {

                meeting = new Meeting(
                        result.getInt("IdClient"),
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

            String query = "SELECT * FROM meetings WHERE IdMeeting = (?)";

            PreparedStatement statement = conn.prepareStatement(query);
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();

            while (result.next()) {

                meeting = new Meeting(
                        result.getInt("IdClient"),
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

    public static Meeting getByClientId(String companyName, int clientId) {
        Meeting meeting = null;

        try {
            String query = "SELECT * FROM meetings WHERE IdClient = (?) and IdCompany = (select Id from companies where username = (?)";

            PreparedStatement statement = conn.prepareStatement(query);
            statement.setInt(1, clientId);
            ResultSet result = statement.executeQuery();

            while (result.next()) {

                meeting = new Meeting(
                        result.getInt("IdClient"),
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

    public static Double getPercentUnassigned(String companyName) {

        Double answer = 0d;

        try {

            String query = "select count( CASE WHEN isopen='1' THEN 1 END)*100/ count(*)  as 'Percent' from meetings met where idCompany = ( select Id from companies where username = (?))";

            PreparedStatement statement = conn.prepareStatement(query);

            statement.setString(1, companyName);

            ResultSet result = statement.executeQuery();

            while (result.next()) {
                answer = result.getDouble("Percent");

            }

        } catch (Exception e) {
            System.out.println("Exception : " + e);
        }

        return answer;

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

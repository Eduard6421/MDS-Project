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

    public static boolean createMeeting(int clientId, int employeeId, Date date, String Description) {

        try {
            String query = "INSERT INTO Meetings (IdClient, IdEmployee, Date, Feedback, Description) VALUES (?,?,?,?,?)";

            PreparedStatement statement = conn.prepareStatement(query);

            java.sql.Date SQLDate = new java.sql.Date(date.getTime());

            statement.setInt(1, clientId);
            statement.setInt(2, employeeId);
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
                        result.getInt("IdEmployee"),
                        result.getDate("Date"),
                        result.getDouble("Feedback"),
                        result.getString("Description"));

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
                        result.getInt("IdEmployee"),
                        result.getDate("Date"),
                        result.getDouble("Feedback"),
                        result.getString("Description"));

            }
            statement.close();

        } catch (Exception e) {
            System.out.println("Error " + e);
        }

        return meeting;
    }

    public static Meeting getByEmployee(int employeeId) {
        Meeting meeting = null;

        try {
            String query = "SELECT * FROM Meetings WHERE IdEmployee = (?)";

            PreparedStatement statement = conn.prepareStatement(query);
            statement.setInt(1, employeeId);
            ResultSet result = statement.executeQuery();

            while (result.next()) {

                meeting = new Meeting(
                        result.getInt("IdClient"),
                        result.getInt("IdEmployee"),
                        result.getDate("Date"),
                        result.getDouble("Feedback"),
                        result.getString("Description"));

            }
            statement.close();

        } catch (Exception e) {
            System.out.println("Error " + e);
        }

        return meeting;
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
                        result.getInt("IdEmployee"),
                        result.getDate("Date"),
                        result.getDouble("Feedback"),
                        result.getString("Description"));

            }
            statement.close();

        } catch (SQLException e) {
            System.out.println("Error " + e);
        }

        return meeting;
    }
    
}

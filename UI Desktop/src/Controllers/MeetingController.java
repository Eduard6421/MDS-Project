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

public class MeetingController {

    private static final Connection conn = MySQLConnector.getConnection();

    public static boolean createMeeting(int clientId, int employeeId, Date date, String Description) {

        try {
            String query = " INSERT INTO MEETINGS (ID_CLIENT,ID_EMPLOYEE,DATE,FEEDBACK,DECRIPTION) VALUES (?,?,?,?,?);";

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
        Meeting meetingInstance = null;

        List<Meeting> meetingList = new ArrayList<>();

        try {
            String query = " SELECT * FROM MEETINGS";

            Statement statement = conn.createStatement();

            ResultSet result = statement.executeQuery(query);

            while (result.next()) {

                meetingInstance = new Meeting(
                        result.getInt("ID_Client"),
                        result.getInt("ID_Employee"),
                        result.getDate("Date"),
                        result.getDouble("Feedback"),
                        result.getString("Description"));

                meetingList.add(meetingInstance);

            }

            statement.close();

        } catch (SQLException e) {
            System.out.println("Error " + e);
        }

        return meetingList;
    }
    
    public static Meeting getByClient(int clientId) {
        Meeting meetingInstance = null;

        try {
            String query = "SELECT * FROM MEETINGS WHERE ID_CLIENT = (?)";

            PreparedStatement statement = conn.prepareStatement(query);
            statement.setInt(1, clientId);
            ResultSet result = statement.executeQuery();

            while (result.next()) {

                meetingInstance = new Meeting(
                        result.getInt("ID_Client"),
                        result.getInt("ID_Employee"),
                        result.getDate("Date"),
                        result.getDouble("Feedback"),
                        result.getString("Description"));

            }
            statement.close();

        } catch (Exception e) {
            System.out.println("Error " + e);
        }

        return meetingInstance;
    }

    public static Meeting getByEmployee(int employeeId) {
        Meeting meetingInstance = null;

        try {
            String query = "SELECT * FROM MEETINGS WHERE ID_EMPLOYEE = (?)";

            PreparedStatement statement = conn.prepareStatement(query);
            statement.setInt(1, employeeId);
            ResultSet result = statement.executeQuery();

            while (result.next()) {

                meetingInstance = new Meeting(
                        result.getInt("ID_Client"),
                        result.getInt("ID_Employee"),
                        result.getDate("Date"),
                        result.getDouble("Feedback"),
                        result.getString("Description"));

            }
            statement.close();

        } catch (Exception e) {
            System.out.println("Error " + e);
        }

        return meetingInstance;
    }

    public static Meeting getByMeeting(int id) {

        Meeting meetingInstance = null;

        try {

            String query = "SELECT * FROM MEETINGS WHERE ID_MEETING = (?)";

            PreparedStatement statement = conn.prepareStatement(query);
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();

            while (result.next()) {

                meetingInstance = new Meeting(
                        result.getInt("ID_Client"),
                        result.getInt("ID_Employee"),
                        result.getDate("Date"),
                        result.getDouble("Feedback"),
                        result.getString("Description"));

            }
            statement.close();

        } catch (SQLException e) {
            System.out.println("Error " + e);
        }

        return meetingInstance;
    }
    
}

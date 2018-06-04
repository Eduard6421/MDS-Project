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
    /**
     * Creates a new meeting in the data base with the given parameters.
     * @param clientId
     * @param companyId
     * @param date
     * @param Description
     * @return 
     */
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
    /**
     * Creates a list of all the meetings of a given company name.
     * @param companyName
     * @return 
     */
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
                        result.getInt("Id"),
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
    
    public static List<Meeting> getAllAssigned(String companyName) {
        Meeting meeting = null;

        List<Meeting> meetings = new ArrayList<>();

        try {
            String query = "select * from meetings where IdCompany = (select Id from companies where username = (?)) AND IdEmployee IS NOT NULL;";

            PreparedStatement statement = conn.prepareStatement(query);

            statement.setString(1, companyName);

            ResultSet result = statement.executeQuery();

            while (result.next()) {

                meeting = new Meeting(
                        result.getInt("Id"),
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
    
    public static List<Meeting> getAllPending(String companyName) {
        Meeting meeting = null;

        List<Meeting> meetings = new ArrayList<>();

        try {
            String query = "select * from meetings where IdCompany = (select Id from companies where username = (?)) AND IdEmployee IS NULL;";

            PreparedStatement statement = conn.prepareStatement(query);

            statement.setString(1, companyName);

            ResultSet result = statement.executeQuery();

            while (result.next()) {

                meeting = new Meeting(
                        result.getInt("Id"),
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
        
    /**
     * Creates a list of all the open meetings of a given company name.
     * @param companyName
     * @return 
     */
    public static List<Meeting> getAllOpen(String companyName) {

        Meeting meeting = null;

        List<Meeting> meetings = new ArrayList<>();

        try {
            String query = "SELECT * FROM meetings where IsOpen = 1 and IdCompany = (select Id from companies where username = (?) )";

            PreparedStatement statement = conn.prepareStatement(query);

            statement.setString(1, companyName);

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

        } catch (SQLException e) {
            System.out.println("Error " + e);
        }

        return meetings;

    }
    /**
     * Creates a list of all the closed meetings of a given company name.
     * @param companyName
     * @return 
     */
    public static List<Meeting> getAllClosed(String companyName) {
        Meeting meeting = null;

        List<Meeting> meetings = new ArrayList<>();

        try {
            String query = "SELECT * FROM meetings where IsOpen = 0 and IdCompany = (select Id from companies where username = (?) )";

            PreparedStatement statement = conn.prepareStatement(query);

            statement.setString(1, companyName);

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

        } catch (SQLException e) {
            System.out.println("Error " + e);
        }

        return meetings;
    }
    /**
     * Creates a list of all the open meetings of a given company name and employee id.
     * @param companyName
     * @param employeeId
     * @return 
     */
    public static List<Meeting> getAllByEmployee(String companyName, int employeeId) {
        Meeting meeting = null;

        List<Meeting> meetings = new ArrayList<>();

        try {
            String query = "SELECT * FROM meetings WHERE IdEmployee = (?) and IdCompany = (select Id from companies where username = (?) )";

            PreparedStatement statement = conn.prepareStatement(query);
            statement.setInt(1, employeeId);
            statement.setString(2, companyName);
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
    /**
     * Creates a list of all the open meetings of a given company name and employee id.
     * @param companyName
     * @param employeeId
     * @return 
     */
    public static List<Meeting> getAllOpenedByEmployee(String companyName, int employeeId) {
        Meeting meeting = null;

        List<Meeting> meetings = new ArrayList<>();

        try {
            String query = "SELECT * FROM meetings WHERE IdEmployee = (?) AND IsOpen = 1 AND IdCompany = (select Id from companies where username = (?) )";

            PreparedStatement statement = conn.prepareStatement(query);
            statement.setInt(1, employeeId);
            statement.setString(2, companyName);
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
    /**
     * Creates a list of all the closed meetings of a given company name and employee id.
     * @param companyName
     * @param employeeId
     * @return 
     */
    public static List<Meeting> getAllClosedByEmployee(String companyName, int employeeId) {
        Meeting meeting = null;

        List<Meeting> meetings = new ArrayList<>();

        try {
            String query = "SELECT * FROM meetings WHERE IdEmployee = ? AND IsOpen = 0 AND IdCompany = (select Id from companies where username = ? )";

            PreparedStatement statement = conn.prepareStatement(query);
            statement.setInt(1, employeeId);
            statement.setString(2, companyName);
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
    /**
     * Creates a list of all the open meetings of a given company name and client id.
     * @param companyName
     * @param clientId
     * @return 
     */
    public static List<Meeting> getAllOpenByClient(String companyName, int clientId) {
        Meeting meeting = null;

        List<Meeting> meetings = new ArrayList<>();

        try {
            String query = "SELECT * FROM meetings WHERE IdClient = ? AND IsOpen = 1 AND IdCompany = (select Id from companies where username = ? )";

            PreparedStatement statement = conn.prepareStatement(query);
            statement.setInt(1, clientId);
            statement.setString(2, companyName);
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
    /**
     * Creates a list of all the closed meetings of a given company name and client id.
     * @param companyName
     * @param clientId
     * @return 
     */
    public static List<Meeting> getAllClosedByClient(String companyName, int clientId) {
        Meeting meeting = null;

        List<Meeting> meetings = new ArrayList<>();

        try {
            String query = "SELECT * FROM meetings WHERE IdClient = (?) AND IsOpen = 0 AND IdCompany = (select Id from companies where username = (?) )";

            PreparedStatement statement = conn.prepareStatement(query);
            statement.setInt(1, clientId);
            statement.setString(2, companyName);
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
    /**
     * Selects a meeting by its id.
     * @param id
     * @return 
     */
    public static Meeting getByMeeting(int id) {

        Meeting meeting = null;

        try {

            String query = "SELECT * FROM meetings WHERE Id = (?)";

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
    /**
     * Selects a meeting by the company name and client id.
     * @param companyName
     * @param clientId
     * @return 
     */
    public static Meeting getByClientId(String companyName, int clientId) {
        Meeting meeting = null;

        try {
            String query = "SELECT * FROM meetings WHERE IdClient = (?) and IdCompany = (select Id from companies where username = (?) )";

            PreparedStatement statement = conn.prepareStatement(query);
            statement.setInt(1, clientId);
            statement.setString(2, companyName);
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
    /**
     * Returns the percent of unassigned requests of a company.
     * @param companyName
     * @return 
     */
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
    /**
     * It reopens an existing closed meeting.
     * @param meetingId
     * @return 
     */
    public static boolean reopenMeeting(int meetingId) {
        try {

            String query = "update meetings set isopen = 1 where id = ?";

            PreparedStatement statement = conn.prepareStatement(query);

            statement.setInt(1, meetingId);

            int result = statement.executeUpdate();

            statement.close();

            return result > 0;

        } catch (SQLException e) {
            System.out.println("Error : " + e);
        }

        return false;

    }
    
    public static boolean cancelMeetingById(int meetingId) {
        try {

            String query = "update meetings set IdEmployee = NULL where id = ?";

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
    /**
     * It closes an existing meeting.
     * @param meetingId
     * @return 
     */
    public static boolean closeMeeting(int meetingId) {

        try {

            String query = "update meetings set isopen = 0 where id = ?";

            PreparedStatement statement = conn.prepareStatement(query);

            statement.setInt(1, meetingId);

            int result = statement.executeUpdate();

            statement.close();

            return result > 0;

        } catch (SQLException e) {
            System.out.println("Error : " + e);
        }

        return false;

    }
    /**
     * Updates the meeting by setting the feedback.
     * @param meetingId
     * @param feedback
     * @return 
     */
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

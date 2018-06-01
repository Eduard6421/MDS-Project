package Controllers;

import Models.Report;
import Utils.MySQLConnector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ReportsController {

    private static final Connection conn = MySQLConnector.getConnection();

    public static boolean createReport(int idMeeting, String description) {

        try {
            String query = "INSERT INTO reports (IdMeeting, Description) VALUES (?,?)";

            PreparedStatement statement = conn.prepareStatement(query);
            statement.setInt(1, idMeeting);
            statement.setString(2, description);

            int result = statement.executeUpdate();

            statement.close();

            return result > 0;

        } catch (SQLException e) {
            System.out.println("Error : " + e);

        }

        return false;
    }

    public static List<Report> getAll() throws SQLException {

        Report report = null;

        List<Report> reports = new ArrayList<>();

        try {
            String query = "SELECT * FROM reports";

            Statement statement = conn.createStatement();

            ResultSet result = statement.executeQuery(query);

            while (result.next()) {

                report = new Report(result.getInt("Id"),
                        result.getInt("IdMeeting"),
                        result.getString("Description"));

                reports.add(report);

            }

            statement.close();

        } catch (SQLException e) {
            System.out.println("Error : " + e);
        }

        return reports;
    }

    public static Report getById(int id) {

        Report report = null;

        try {
            String query = "SELECT * FROM reports WHERE Id = (?);";

            PreparedStatement statement = conn.prepareStatement(query);
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();

            report = new Report(
                    result.getInt("IdMeeting"),
                    result.getString("Description"));

            statement.close();

        } catch (SQLException e) {

            System.out.println("Error " + e);
        }

        return report;
    }

    public static Report getByMeeting(int id) {

        Report report = null;

        try {
            String query = "SELECT * FROM reports WHERE IdMeeting = (?)";

            PreparedStatement statement = conn.prepareStatement(query);
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();

            while (result.next()) {

                report = new Report(
                        result.getInt("IdMeeting"),
                        result.getString("Description"));

            }
            statement.close();

        } catch (SQLException e) {
            System.out.println("Error " + e);
        }

        return report;
    }
    
}

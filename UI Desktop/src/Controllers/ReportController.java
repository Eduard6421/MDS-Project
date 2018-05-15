/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

public class ReportController {

    private static final Connection Conn = MySQLConnector.getConnection();

    public static boolean createReport(int idMeeting, String Description) {

        try {
            String query = "INSERT INTO reports ID_MEETING,DESCRIPTION VALUES (?,?)";

            PreparedStatement statement = Conn.prepareStatement(query);
            statement.setInt(1, idMeeting);
            statement.setString(2, Description);

            int result = statement.executeUpdate();

            statement.close();

            return result > 0;

        } catch (SQLException e) {
            System.out.println("Error : " + e);

        }

        return false;

    }

    public static List<Report> getAll() throws SQLException {

        Report reportInstance = null;

        List<Report> reportList = new ArrayList<>();

        try {
            String query = "SELECT * FROM EMPLOYEES";

            Statement statement = Conn.createStatement();

            ResultSet result = statement.executeQuery(query);

            while (result.next()) {

                reportInstance = new Report(result.getInt("ID"),
                        result.getInt("ID_MEETING"),
                        result.getString("Description"));

                reportList.add(reportInstance);

            }

            statement.close();

        } catch (SQLException e) {
            System.out.println("Error : " + e);
        }

        return reportList;

    }

    public static Report getById(int Id) {

        Report reportInstance = null;

        try {

            String query = "SELECT * FROM REPORTS WHERE ID = (?);";

            PreparedStatement statement = Conn.prepareStatement(query);
            statement.setInt(1, Id);
            ResultSet result = statement.executeQuery();

            reportInstance = new Report(
                    result.getInt("ID_MEETING"),
                    result.getString("Description"));

            statement.close();

        } catch (SQLException e) {

            System.out.println("Error " + e);
        }

        return reportInstance;

    }

    public static Report getByMeeting(int Id) {

        Report reportInstance = null;

        try {

            String query = "SELECT * FROM REPORTS WHERE ID_MEETING = (?)";

            PreparedStatement statement = Conn.prepareStatement(query);
            statement.setInt(1, Id);
            ResultSet result = statement.executeQuery();

            while (result.next()) {

                reportInstance = new Report(
                        result.getInt("ID_MEETING"),
                        result.getString("Description"));

            }
            statement.close();

        } catch (SQLException e) {
            System.out.println("Error " + e);
        }

        return reportInstance;

    }

}

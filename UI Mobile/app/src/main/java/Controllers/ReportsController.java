package Controllers;

import android.os.AsyncTask;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import Models.Report;
import Utils.MySQLConnector;

public class ReportsController {

    private static final Connection conn = MySQLConnector.getConnection();

    /*********************************************************************************************/
    public static boolean createReport(Integer idMeeting, String description) {

        try {
            AsyncCreateReport asyncCreateReport = new AsyncCreateReport();
            return  asyncCreateReport.execute(idMeeting.toString(), description).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static class AsyncCreateReport extends AsyncTask<String, String, Boolean> {

        @Override
        protected Boolean doInBackground(String... strings) {

            try {
                String query = "INSERT INTO reports (IdMeeting, Description) VALUES (?,?)";

                PreparedStatement statement = conn.prepareStatement(query);
                statement.setInt(1, Integer.parseInt(strings[0]));
                statement.setString(2, strings[1]);

                int result = statement.executeUpdate();

                statement.close();

                return result > 0;

            } catch (SQLException e) {
                System.out.println("Error : " + e);

            }

            return false;
        }
    }

    /*********************************************************************************************/
    public static List<Report> getAll() {

        try {
            AsyncGetAll asyncGetAll = new AsyncGetAll();
            return asyncGetAll.execute().get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static class AsyncGetAll extends AsyncTask<String, String, List<Report>> {

        @Override
        protected List<Report> doInBackground(String... strings) {

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
    }

    /**********************************************************************************************/
    public static Report getById(Integer id) {

        try {
            AsyncGetById asyncGetById = new AsyncGetById();
            return asyncGetById.execute(id).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static class AsyncGetById extends AsyncTask<Integer, String, Report> {

        @Override
        protected Report doInBackground(Integer... integers) {

            Report report = null;

            try {
                String query = "SELECT * FROM reports WHERE Id = (?);";

                PreparedStatement statement = conn.prepareStatement(query);
                statement.setInt(1, integers[0]);
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
    }

    /********************************************************************************************/
    public static Report getByMeeting(Integer id) {

        try {
            AsyncGetByMeeting asyncGetByMeeting = new AsyncGetByMeeting();
            return  asyncGetByMeeting.execute(id).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static class AsyncGetByMeeting extends AsyncTask<Integer, String, Report> {

        @Override
        protected Report doInBackground(Integer... integers) {

            Report report = null;

            try {
                String query = "SELECT * FROM reports WHERE IdMeeting = (?)";

                PreparedStatement statement = conn.prepareStatement(query);
                statement.setInt(1, integers[0]);
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
}

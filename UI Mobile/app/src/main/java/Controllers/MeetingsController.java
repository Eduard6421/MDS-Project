package Controllers;

import android.os.AsyncTask;

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
import java.util.concurrent.ExecutionException;

public class MeetingsController {

    private static final Connection conn = MySQLConnector.getConnection();

    /*********************************************************************************************************/
    public static Boolean createMeeting(Integer clientId, Integer companyId, Date date, String description) {

        try {
            AsyncCreateMeeting asyncCreateMeeting = new AsyncCreateMeeting();
            return asyncCreateMeeting.execute(clientId, companyId, date, description).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        return false;
    }

    public static class AsyncCreateMeeting extends AsyncTask<Object, String, Boolean> {

        @Override
        protected Boolean doInBackground(Object... objects) {
            try {
                String query = "INSERT INTO meetings (IdClient, IdCompany, Date, Description) VALUES (?,?,?,?)";

                PreparedStatement statement = conn.prepareStatement(query);

                java.sql.Date SQLDate = new java.sql.Date(((Date)objects[2]).getTime());

                statement.setInt(1, (Integer)objects[0]);
                statement.setInt(2, (Integer)objects[1]);
                statement.setDate(3, SQLDate);
                statement.setString(4, (String)objects[3]);
                int result = statement.executeUpdate();

                statement.close();

                return result > 0;

            } catch (SQLException e) {
                System.out.println("Error : " + e);
            }

            return false;
        }
    }

    /***********************************************************************************************/
    public static Boolean giveFeedback(Integer meetingId, Float feedback, String description) {

        try {
            AsyncGiveFeedback asyncGiveFeedback = new AsyncGiveFeedback();
            return asyncGiveFeedback.execute(meetingId, feedback, description).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        return false;
    }

    public static class AsyncGiveFeedback extends AsyncTask<Object, String, Boolean> {

        @Override
        protected Boolean doInBackground(Object... objects) {

            try {
                String query = "update meetings set Feedback = ?, Description = ? where Id = ?";

                PreparedStatement statement = conn.prepareStatement(query);
                statement.setFloat(1, (Float)objects[1]);
                statement.setString(2, (String)objects[2]);
                statement.setInt(3, (Integer)objects[0]);

                int result = statement.executeUpdate();

                statement.close();

                return result > 0;

            } catch (SQLException e) {
                System.out.println("Error : " + e);

            }

            return false;
        }
    }
    /**********************************************************************************************/
    public static List<Meeting> getAllByClient(Integer clientId) {

        try {
            AsyncGetAllByClient asyncGetAllByClient = new AsyncGetAllByClient();
            return asyncGetAllByClient.execute(clientId).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static class AsyncGetAllByClient extends AsyncTask<Integer, String, List<Meeting>> {

        @Override
        protected List<Meeting> doInBackground(Integer... integers) {
            Meeting meeting = null;

            List<Meeting> meetings = new ArrayList<>();

            try {
                String query = "select * from meetings where IdClient = (?);";

                PreparedStatement statement = conn.prepareStatement(query);

                statement.setInt(1, integers[0]);

                ResultSet result = statement.executeQuery();

                while (result.next()) {

                    meeting = new Meeting(
                            result.getInt("Id"),
                            result.getInt("IdClient"),
                            result.getInt("IdCompany"),
                            result.getInt("IdEmployee"),
                            result.getDate("Date"),
                            result.getFloat("Feedback"),
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
    }

    /**********************************************************************************************/
    public static List<Meeting> getAllByCompany(String companyName) {

        try {
            AsyncGetAllByCompany asyncGetAllByCompany = new AsyncGetAllByCompany();
            return asyncGetAllByCompany.execute(companyName).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static class AsyncGetAllByCompany extends AsyncTask<String, String, List<Meeting>> {

        @Override
        protected List<Meeting> doInBackground(String... strings) {
            Meeting meeting = null;

            List<Meeting> meetings = new ArrayList<>();

            try {
                String query = "select * from meetings where IdCompany = (select Id from companies where username = (?));";

                PreparedStatement statement = conn.prepareStatement(query);

                statement.setString(1, strings[0]);

                ResultSet result = statement.executeQuery();

                while (result.next()) {

                    meeting = new Meeting(
                            result.getInt("Id"),
                            result.getInt("IdClient"),
                            result.getInt("IdCompany"),
                            result.getInt("IdEmployee"),
                            result.getDate("Date"),
                            result.getFloat("Feedback"),
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
    }

    /*********************************************************************************************/
    public static Meeting getByClientId(String companyName, Integer clientId) {

        try {
            AsyncGetByClientId asyncGetByClientId = new AsyncGetByClientId();
            return asyncGetByClientId.execute(companyName, clientId.toString()).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static class AsyncGetByClientId extends AsyncTask<String, String, Meeting> {

        @Override
        protected Meeting doInBackground(String... strings) {
            Meeting meeting = null;

            try {
                String query = "SELECT * FROM meetings WHERE IdClient = (?) and IdCompany = (select Id from companies where username = (?))";

                PreparedStatement statement = conn.prepareStatement(query);
                statement.setInt(1, Integer.parseInt(strings[1]));
                statement.setString(2, strings[0]);
                ResultSet result = statement.executeQuery();

                while (result.next()) {

                    meeting = new Meeting(
                            result.getInt("Id"),
                            result.getInt("IdClient"),
                            result.getInt("IdCompany"),
                            result.getInt("IdEmployee"),
                            result.getDate("Date"),
                            result.getFloat("Feedback"),
                            result.getString("Description"),
                            result.getBoolean("IsOpen"));

                }
                statement.close();

            } catch (Exception e) {
                System.out.println("Error " + e);
            }

            return meeting;
        }
    }

    /*********************************************************************************************/
    public static List<Meeting> getAllByEmployee(String companyName, Integer employeeId) {

        try {
            AsyncGetAllByEmployee asyncGetAllByEmployee = new AsyncGetAllByEmployee();
            return asyncGetAllByEmployee.execute(companyName, employeeId.toString()).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static class AsyncGetAllByEmployee extends AsyncTask<String, String, List<Meeting>> {

        @Override
        protected List<Meeting> doInBackground(String... strings) {

            Meeting meeting = null;

            List<Meeting> meetings = new ArrayList<>();

            try {
                String query = "SELECT * FROM meetings WHERE IdEmployee = (?) and IdCompany = (select Id from companies where username = (?))";

                PreparedStatement statement = conn.prepareStatement(query);
                statement.setInt(1, Integer.parseInt(strings[1]));
                statement.setString(2, strings[0]);

                ResultSet result = statement.executeQuery();

                while (result.next()) {

                    meeting = new Meeting(
                            result.getInt("Id"),
                            result.getInt("IdClient"),
                            result.getInt("IdCompany"),
                            result.getInt("IdEmployee"),
                            result.getDate("Date"),
                            result.getFloat("Feedback"),
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
    }

    /*********************************************************************************************/
    public static List<Meeting> getAllOpenedByEmployee(String companyName, Integer employeeId) {

        try {
            AsyncGetAllOpenedByEmployee asyncGetAllOpenedByEmployee = new AsyncGetAllOpenedByEmployee();
            return asyncGetAllOpenedByEmployee.execute(companyName, employeeId.toString()).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static class AsyncGetAllOpenedByEmployee extends AsyncTask<String, String, List<Meeting>> {

        @Override
        protected List<Meeting> doInBackground(String... strings) {

            Meeting meeting = null;

            List<Meeting> meetings = new ArrayList<>();

            try {
                String query = "SELECT * FROM meetings WHERE IdClient = (?) AND IsOpen = 1 AND IdCompany = (select Id from companies where username = (?))";

                PreparedStatement statement = conn.prepareStatement(query);
                statement.setInt(1, Integer.parseInt(strings[1]));
                statement.setString(2, strings[0]);
                ResultSet result = statement.executeQuery();

                while (result.next()) {

                    meeting = new Meeting(
                            result.getInt("Id"),
                            result.getInt("IdClient"),
                            result.getInt("IdCompany"),
                            result.getInt("IdEmployee"),
                            result.getDate("Date"),
                            result.getFloat("Feedback"),
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
    }

    /**********************************************************************************************/
    public static List<Meeting> getAllClosedByEmployee(String companyName, Integer employeeId) {

        try {
            AsyncGetAllClosedByEmployee asyncGetAllClosedByEmployee = new AsyncGetAllClosedByEmployee();
            return asyncGetAllClosedByEmployee.execute(companyName, employeeId.toString()).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static class AsyncGetAllClosedByEmployee extends AsyncTask<String, String, List<Meeting>> {

        @Override
        protected List<Meeting> doInBackground(String... strings) {
            Meeting meeting = null;

            List<Meeting> meetings = new ArrayList<>();

            try {
                String query = "SELECT * FROM meetings WHERE IdClient = (?) AND IsOpen = 0 AND IdCompany = (select Id from companies where username = (?))";

                PreparedStatement statement = conn.prepareStatement(query);
                statement.setInt(1, Integer.parseInt(strings[1]));
                statement.setString(2, strings[0]);
                ResultSet result = statement.executeQuery();

                while (result.next()) {

                    meeting = new Meeting(
                            result.getInt("Id"),
                            result.getInt("IdClient"),
                            result.getInt("IdCompany"),
                            result.getInt("IdEmployee"),
                            result.getDate("Date"),
                            result.getFloat("Feedback"),
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
    }

    /**********************************************************************************************/
    public static Meeting getByMeeting(Integer id) {

        try {
            AsyncGetByMeeting asyncGetByMeeting = new AsyncGetByMeeting();
            return asyncGetByMeeting.execute(id).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static class AsyncGetByMeeting extends AsyncTask<Integer, String, Meeting> {

        @Override
        protected Meeting doInBackground(Integer... integers) {

            Meeting meeting = null;

            try {

                String query = "SELECT * FROM meetings WHERE Id = (?)";

                PreparedStatement statement = conn.prepareStatement(query);
                statement.setInt(1, integers[0]);
                ResultSet result = statement.executeQuery();

                while (result.next()) {

                    meeting = new Meeting(
                            result.getInt("Id"),
                            result.getInt("IdClient"),
                            result.getInt("IdCompany"),
                            result.getInt("IdEmployee"),
                            result.getDate("Date"),
                            result.getFloat("Feedback"),
                            result.getString("Description"),
                            result.getBoolean("IsOpen"));

                }
                statement.close();

            } catch (SQLException e) {
                System.out.println("Error " + e);
            }

            return meeting;
        }
    }

    /*******************************************************************************/
    public static List<Meeting> getAllOpen(String companyName) {

        try {
            AsyncGetAllOpen asyncGetAllOpen = new AsyncGetAllOpen();
            return asyncGetAllOpen.execute(companyName).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static class AsyncGetAllOpen extends AsyncTask<String, String, List<Meeting>> {

        @Override
        protected List<Meeting> doInBackground(String... strings) {

            Meeting meeting = null;

            List<Meeting> meetings = new ArrayList<>();

            try {
                String query = "SELECT * FROM meetings where IsOpen = 1 and IdCompany = (select Id from companies where username = (?)";

                PreparedStatement statement = conn.prepareStatement(query);

                statement.setString(1, strings[0]);

                ResultSet result = statement.executeQuery();

                while (result.next()) {

                    meeting = new Meeting(
                            result.getInt("Id"),
                            result.getInt("IdClient"),
                            result.getInt("IdCompany"),
                            result.getInt("IdEmployee"),
                            result.getDate("Date"),
                            result.getFloat("Feedback"),
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
    }

    /*************************************************************************************************/

    public static List<Meeting> getAllClosed(String companyName) {

        try {
            AsyncGetAllClosed asyncGetAllClosed = new AsyncGetAllClosed();
            return asyncGetAllClosed.execute(companyName).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static class AsyncGetAllClosed extends AsyncTask<String, String, List<Meeting>> {

        @Override
        protected List<Meeting> doInBackground(String... strings) {
            Meeting meeting = null;

            List<Meeting> meetings = new ArrayList<>();

            try {
                String query = "SELECT * FROM meetings where IsOpen = 0 and IdCompany = (select Id from companies where username = (?)";

                PreparedStatement statement = conn.prepareStatement(query);

                statement.setString(1, strings[0]);

                ResultSet result = statement.executeQuery();

                while (result.next()) {

                    meeting = new Meeting(
                            result.getInt("Id"),
                            result.getInt("IdClient"),
                            result.getInt("IdCompany"),
                            result.getInt("IdEmployee"),
                            result.getDate("Date"),
                            result.getFloat("Feedback"),
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
    }

    /**********************************************************************************************/
    public static List<Meeting> getAllOpenedByClient(Integer clientId) {

        try {
            AsyncGetAllOpenedByClient asyncGetAllOpenedByClient = new AsyncGetAllOpenedByClient();
            return asyncGetAllOpenedByClient.execute(clientId).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static class AsyncGetAllOpenedByClient extends AsyncTask<Integer, String, List<Meeting>> {

        @Override
        protected List<Meeting> doInBackground(Integer... integers) {
            Meeting meeting = null;

            List<Meeting> meetings = new ArrayList<>();

            try {
                String query = "SELECT * FROM meetings WHERE IdClient = (?) AND IsOpen = 1";

                PreparedStatement statement = conn.prepareStatement(query);
                statement.setInt(1, integers[0]);
                ResultSet result = statement.executeQuery();

                while (result.next()) {

                    meeting = new Meeting(
                            result.getInt("Id"),
                            result.getInt("IdClient"),
                            result.getInt("IdCompany"),
                            result.getInt("IdEmployee"),
                            result.getDate("Date"),
                            result.getFloat("Feedback"),
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
    }

    /************************************************************************************************/
    public static List<Meeting> getAllClosedByClient(Integer clientId) {

        try {
            AsyncGetAllClosedByClient asyncGetAllClosedByClient = new AsyncGetAllClosedByClient();
            return asyncGetAllClosedByClient.execute(clientId).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static class AsyncGetAllClosedByClient extends AsyncTask<Integer, String, List<Meeting>> {

        @Override
        protected List<Meeting> doInBackground(Integer... integers) {

            Meeting meeting = null;

            List<Meeting> meetings = new ArrayList<>();

            try {
                String query = "SELECT * FROM meetings WHERE IdClient = (?) AND IsOpen = 0";

                PreparedStatement statement = conn.prepareStatement(query);
                statement.setInt(1, integers[0]);
                ResultSet result = statement.executeQuery();

                while (result.next()) {

                    meeting = new Meeting(
                            result.getInt("Id"),
                            result.getInt("IdClient"),
                            result.getInt("IdCompany"),
                            result.getInt("IdEmployee"),
                            result.getDate("Date"),
                            result.getFloat("Feedback"),
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
    }

    /***********************************************************************************************/
    public static Double getPercentUnassigned(String companyName) {

        try {
            AsyncGetPercentUnassigned asyncGetPercentUnassigned = new AsyncGetPercentUnassigned();
            return asyncGetPercentUnassigned.execute(companyName).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static class AsyncGetPercentUnassigned extends AsyncTask<String, String, Double> {

        @Override
        protected Double doInBackground(String... strings) {

            Double answer = 0d;

            try {

                String query = "select count( CASE WHEN isopen='1' THEN 1 END)*100/ count(*)  as 'Percent' from meetings met where idCompany = ( select Id from companies where username = (?))";

                PreparedStatement statement = conn.prepareStatement(query);

                statement.setString(1, strings[0]);

                ResultSet result = statement.executeQuery();

                while (result.next()) {
                    answer = result.getDouble("Percent");
                }

            } catch (Exception e) {
                System.out.println("Exception : " + e);
            }

            return answer;
        }
    }

    /********************************************************************************************/
    public static Boolean reopenMeeting(Integer meetingId) {

        try {
            AsyncReopenMeeting asyncReopenMeeting = new AsyncReopenMeeting();
            return asyncReopenMeeting.execute(meetingId).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        return false;
    }

    public static class AsyncReopenMeeting extends AsyncTask<Integer, String, Boolean> {

        @Override
        protected Boolean doInBackground(Integer... integers) {
            try {

                String query = "update meetings set isopen = 0 where id = ?";

                PreparedStatement statement = conn.prepareStatement(query);

                statement.setInt(1, integers[0]);

                int result = statement.executeUpdate();

                statement.close();

                return result > 0;

            } catch (SQLException e) {
                System.out.println("Error : " + e);
            }

            return false;
        }
    }

    /********************************************************************************************/
    public static Boolean closeMeeting(Integer meetingId) {

        try {
            AsyncCloseMeeting asyncCloseMeeting = new AsyncCloseMeeting();
            return asyncCloseMeeting.execute(meetingId).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        return false;
    }

    public static class AsyncCloseMeeting extends AsyncTask<Integer, String, Boolean> {

        @Override
        protected Boolean doInBackground(Integer... integers) {

            try {

                String query = "update meetings set isopen = 0 where id = ?";

                PreparedStatement statement = conn.prepareStatement(query);

                statement.setInt(1, integers[0]);

                int result = statement.executeUpdate();

                statement.close();

                return result > 0;

            } catch (SQLException e) {
                System.out.println("Error : " + e);
            }

            return false;

        }
    }
}

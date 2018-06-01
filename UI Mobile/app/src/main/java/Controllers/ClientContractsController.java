package Controllers;

import android.os.AsyncTask;

import Models.ClientContract;
import Utils.MySQLConnector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class ClientContractsController {

    private static final Connection conn = MySQLConnector.getConnection();

    /******************************************************************************************************/
    public static Boolean createClientContract(Integer idClient, Integer idCompany, Date startDate, Date endDate) {

        try {
            AsyncCreateClientContract asyncCreateClientContract = new AsyncCreateClientContract();
            return asyncCreateClientContract.execute(idClient, idCompany, startDate, endDate).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        return false;
    }

    public static class AsyncCreateClientContract extends AsyncTask<Object, String, Boolean> {

        @Override
        protected Boolean doInBackground(Object... objects) {

            try {
                String query = "INSERT INTO client_contracts (IdCompany, IdClient, StartDate, EndDate) values (?,?,?,?)";

                PreparedStatement statement = conn.prepareStatement(query);

                java.sql.Date SQLStartDate = new java.sql.Date(((java.sql.Date)objects[2]).getTime());
                java.sql.Date SQLEndDate = new java.sql.Date(((java.sql.Date)objects[3]).getTime());

                statement.setInt(1, (Integer)objects[0]);
                statement.setInt(2, (Integer)objects[1]);
                statement.setDate(3, SQLStartDate);
                statement.setDate(4, SQLEndDate);

                int result = statement.executeUpdate();

                statement.close();

                return result > 0;

            } catch (SQLException e) {
                System.out.println("Error " + e);
            }

            return false;
        }
    }

    /*********************************************************************/
    public static ClientContract getById(Integer id) {

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

    public static class AsyncGetById extends AsyncTask<Integer, String, ClientContract> {

        @Override
        protected ClientContract doInBackground(Integer... integers) {

            ClientContract clientContract = null;

            try {

                String query = "SELECT * FROM client_contracts WHERE Id = (?)";

                PreparedStatement statement = conn.prepareStatement(query);
                statement.setInt(1, integers[0]);
                ResultSet result = statement.executeQuery();

                while (result.next()) {

                    clientContract = new ClientContract(
                            result.getInt("Id"),
                            result.getInt("IdClient"),
                            result.getInt("IdCompany"),
                            result.getDate("StartDate"),
                            result.getDate("EndDate"));
                }
                statement.close();

            } catch (SQLException e) {
                System.out.println(e);
            }

            return clientContract;
        }
    }

    /*******************************************************************/
    public static List<ClientContract> getByClient(Integer id) {

        try {
            AsyncGetByClient asyncGetByClient = new AsyncGetByClient();
            return asyncGetByClient.execute(id).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static class AsyncGetByClient extends AsyncTask<Integer, String, List<ClientContract>> {

        @Override
        protected List<ClientContract> doInBackground(Integer... integers) {

            ClientContract clientContract = null;

            List<ClientContract> contractList = new ArrayList<>();

            try {

                String query = "SELECT  * from client_contracts WHERE IdClient = (?)";

                PreparedStatement statement = conn.prepareStatement(query);
                statement.setInt(1, integers[0]);
                ResultSet result = statement.executeQuery();

                while (result.next()) {
                    clientContract = new ClientContract(
                            result.getInt("Id"),
                            result.getInt("IdClient"),
                            result.getInt("IdCompany"),
                            result.getDate("StartDate"),
                            result.getDate("EndDate"));

                    contractList.add(clientContract);
                }
                statement.close();

            } catch (SQLException e) {
                System.out.println(e);
            }

            return contractList;
        }
    }

    /**************************************************************************/
    public static List<ClientContract> getByCompany(Integer id) {

        try {
            AsyncGetByCompany asyncGetByCompany = new AsyncGetByCompany();
            return asyncGetByCompany.execute(id).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static class AsyncGetByCompany extends AsyncTask<Integer, String, List<ClientContract>> {

        @Override
        protected List<ClientContract> doInBackground(Integer... integers) {

            ClientContract clientContract = null;

            List<ClientContract> contractList = new ArrayList<>();

            try {

                String query = "SELECT  * FROM client_contracts WHERE IdCompany = (?)";

                PreparedStatement statement = conn.prepareStatement(query);
                statement.setInt(1, integers[0]);
                ResultSet result = statement.executeQuery();

                while (result.next()) {
                    clientContract = new ClientContract(
                            result.getInt("Id"),
                            result.getInt("IdClient"),
                            result.getInt("IdCompany"),
                            result.getDate("StartDate"),
                            result.getDate("EndDate"));

                    contractList.add(clientContract);
                }
                statement.close();

            } catch (SQLException e) {
                System.out.println(e);
            }

            return contractList;
        }
    }


}

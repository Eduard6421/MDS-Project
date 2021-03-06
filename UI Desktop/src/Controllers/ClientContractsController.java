package Controllers;

import Models.ClientContract;
import Utils.MySQLConnector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ClientContractsController {

    private static final Connection conn = MySQLConnector.getConnection();
    /**
     * Creates a new client contract with the given parameters.
     * @param idClient
     * @param idCompany
     * @param startDate
     * @param endDate
     * @return 
     */
    public static boolean createClientContract(int idClient, int idCompany, Date startDate, Date endDate) {

        try {
            String query = "INSERT INTO client_contracts (IdCompany, IdClient, StartDate, EndDate) values (?,?,?,?)";

            PreparedStatement statement = conn.prepareStatement(query);

            java.sql.Date SQLStartDate = new java.sql.Date(startDate.getTime());
            java.sql.Date SQLEndDate = new java.sql.Date(endDate.getTime());

            statement.setInt(1, idCompany);
            statement.setInt(2, idClient);
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
    /**
     * Selects a client contract with the given id from the database.
     * @param id
     * @return 
     */
    public static ClientContract getById(int id) {

        ClientContract clientContract = null;

        try {

            String query = "SELECT * FROM client_contracts WHERE Id = (?)";

            PreparedStatement statement = conn.prepareStatement(query);
            statement.setInt(1, id);
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
    /**
     * Creates a list of client contracts of a given client id.
     * @param idClient
     * @return 
     */
    public static List<ClientContract> getByClient(int idClient) {

        ClientContract clientContract = null;

        List<ClientContract> contractList = new ArrayList<>();

        try {

            String query = "SELECT  * from client_contracts WHERE IdClient = (?)";

            PreparedStatement statement = conn.prepareStatement(query);
            statement.setInt(1, idClient);
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
    /**
     * Creates a list of client contracts of a given company id.
     * @param id
     * @return 
     */
    public static List<ClientContract> getByCompany(int id) {

        ClientContract clientContract = null;

        List<ClientContract> contractList = new ArrayList<>();

        try {

            String query = "SELECT  * FROM client_contracts WHERE IdCompany = (?)";

            PreparedStatement statement = conn.prepareStatement(query);
            statement.setInt(1, id);
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

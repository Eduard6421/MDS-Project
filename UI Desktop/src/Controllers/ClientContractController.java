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

public class ClientContractController {

    private static final Connection conn = MySQLConnector.getConnection();

    public static boolean createClientContract(int idClient, int idCompany, Date startDate, Date endDate) {

        try {
            String query = "INSERT INTO client_contract (ID_Company,ID_Client,Start_Date,End_Date) values (?,?,?,?)";

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

    public static ClientContract getById(int id) {

        ClientContract contractInstance = null;

        try {

            String query = "SELECT * FROM employee_contract WHERE ID = (?);";

            PreparedStatement statement = conn.prepareStatement(query);
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();

            while (result.next()) {

                contractInstance = new ClientContract(
                        result.getInt("ID"),
                        result.getInt("ID_CLIENT"),
                        result.getInt("ID_COMPANY"),
                        result.getDate("START_DATE"),
                        result.getDate("END_DATE"));

            }

            statement.close();

        } catch (SQLException e) {
            System.out.println(e);
        }

        return contractInstance;
    }

    public static List<ClientContract> getByClient(int id) {

        ClientContract contractInstance = null;

        List<ClientContract> contractList = new ArrayList<>();

        try {

            String query = "SELECT  * from client_contract WHERE ID_CLIENT = (?); ";

            PreparedStatement statement = conn.prepareStatement(query);
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                contractInstance = new ClientContract(
                        result.getInt("ID"),
                        result.getInt("ID_CLIENT"),
                        result.getInt("ID_COMPANY"),
                        result.getDate("START_DATE"),
                        result.getDate("END_DATE"));

                contractList.add(contractInstance);
            }
            statement.close();

        } catch (SQLException e) {
            System.out.println(e);

        }

        return contractList;
    }

    public static List<ClientContract> getByCompany(int id) {

        ClientContract contractInstance = null;

        List<ClientContract> contractList = new ArrayList<>();

        try {

            String query = "SELECT  * from client_contract WHERE ID_COMPANY = (?); ";

            PreparedStatement statement = conn.prepareStatement(query);
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                contractInstance = new ClientContract(
                        result.getInt("ID"),
                        result.getInt("ID_CLIENT"),
                        result.getInt("ID_COMPANY"),
                        result.getDate("START_DATE"),
                        result.getDate("END_DATE"));

                contractList.add(contractInstance);
            }
            statement.close();

        } catch (SQLException e) {
            System.out.println(e);

        }

        return contractList;
    }

}
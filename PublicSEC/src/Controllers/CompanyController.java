/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.Company;
import Util.MySQLConnector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CompanyController {

    private static final Connection Conn = MySQLConnector.getConnection();

    public static Company getById(int id) {

        Company companyInstance = null;

        try {

            String query = "SELECT * FROM COMPANY WHERE ID = (?) ;";

            PreparedStatement statement = Conn.prepareStatement(query);
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();

            while (result.next()) {

                companyInstance = new Company(
                        result.getInt("ID"),
                        result.getString("Name"),
                        result.getDate("Contract_Start_Date"),
                        result.getDate("Contract_End_Date"),
                        result.getString("Description"));
            }

            statement.close();

        } catch (SQLException e) {
            System.out.println("Error : " + e);
        }

        return companyInstance;
    }

    private static List<Company> getAll() {

        Company companyInstance = null;

        List<Company> companyList = new ArrayList<>();

        try {
            String query = "SELECT * from COMPANY";

            PreparedStatement statement = Conn.prepareStatement(query);
            ResultSet result = statement.executeQuery();

            while (result.next()) {

                companyInstance = new Company(
                        result.getInt("ID"),
                        result.getString("Name"),
                        result.getDate("Contract_Start_Date"),
                        result.getDate("Contract_End_Date"),
                        result.getString("Description"));

                companyList.add(companyInstance);

            }

            statement.close();

        } catch (SQLException e) {

            System.out.println(e);
        }

        return companyList;

    }

}
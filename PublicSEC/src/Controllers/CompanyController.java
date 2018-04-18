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

public class CompanyController {

    private static final Connection Conn = MySQLConnector.getConnection();

    public static Company GetById(int id) {

        Company CompanyInstance = null;

        try {

            String query = "SELECT * FROM COMPANY WHERE ID = (?) ;";

            PreparedStatement statement = Conn.prepareStatement(query);
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();

            while (result.next()) {

                CompanyInstance = new Company(
                        result.getInt("ID"),
                        result.getString("Name"),
                        result.getDate("Contract_Start_Date"),
                        result.getDate("Contract_End_Date"),
                        result.getString("Description"));
            }

            statement.close();

        } catch (Exception e) {
            System.out.println("Error : " + e);
        }

        return CompanyInstance;
    }
    
   
    
    
}





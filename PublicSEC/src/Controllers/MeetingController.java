/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controllers;

import Models.Report;
import Util.MySQLConnector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class MeetingController {

    
    private static final Connection Conn = MySQLConnector.getConnection();
    
    
    public static Report getByMeeting(int Id) {

        Report reportInstance = null;

        try {

            String query = "SELECT * FROM REPORTS WHERE ID_MEETING = (?)";

            PreparedStatement statement = Conn.prepareStatement(query);
            statement.setInt(1, Id);
            ResultSet result = statement.executeQuery();

            while (result.next()) {

                reportInstance = new Report(
                        result.getInt("ID"),
                        result.getInt("ID_MEETING"),
                        result.getString("Description"));

            }
            statement.close();

        } catch (Exception e) {
            System.out.println("Error " + e);
        }
        
        return reportInstance;

    }
    
}

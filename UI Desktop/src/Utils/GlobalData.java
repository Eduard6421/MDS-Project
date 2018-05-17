/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

/**
 *
 * @author Eduard
 */

public class GlobalData {

    private static String Username;

    private static String UserType;
    
    private static int UserId;

    public static String getUsername() {
        return Username;
    }

    public static void setUsername(String Username) {
        GlobalData.Username = Username;
    }

    public static String getUserType() {
        return UserType;
    }

    public static void setUserType(String userType) {
        GlobalData.UserType = userType;
    }
    
    public static int getUserId() {
        return UserId;
    }
    
    public static void setUserId(int userId) {
        GlobalData.UserId = userId;
    }

}

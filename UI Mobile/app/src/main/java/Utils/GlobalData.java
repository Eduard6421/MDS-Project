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
    private static String companyName;

    public static String getCompanyName() {
        return companyName;
    }

    public static void setCompanyName(String companyName) {
        GlobalData.companyName = companyName;
    }

    private static Integer UserId;

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

    public static Integer getUserId() {
        return UserId;
    }

    public static void setUserId(Integer userId) {
        GlobalData.UserId = userId;
    }

}

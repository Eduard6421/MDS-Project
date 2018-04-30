/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

/**
 *
 * @author Eduard
 */
public class GlobalData {

    private static String Username;

    public static String getUsername() {
        return Username;
    }

    public static void setUsername(String Username) {
        GlobalData.Username = Username;
    }

}

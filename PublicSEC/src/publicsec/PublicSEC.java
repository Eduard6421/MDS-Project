/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package publicsec;

import Controllers.LoginController;

/**
 *
 * @author t-edpoes
 */
public class PublicSEC {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

            boolean clientSuccesConnection = LoginController.connectClient("asd","def");
        
        
    }

}

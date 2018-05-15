package Forms.Controllers;

import Forms.Login;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

public class LoginController implements ActionListener {
    
    private Login form;
    
    public LoginController() {
        form = new Login(this);
        form.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent evt) {     
        String username = form.getUsername();
        String password = form.getPassword();
        
        if(Controllers.LoginController.connectCompany(username,password))
        {     
        }
        else
        {
            System.out.println("There is no such user / Database connectivity issues!");
                    final JFrame popup = new JFrame();

            JButton button = new JButton();
            button.setText("Wrong credentials or database connectivity issues. Try again!");

            popup.setPreferredSize(new Dimension(500, 200));
            popup.add(button);
            popup.pack();
            popup.setVisible(true);

            button.addActionListener(new java.awt.event.ActionListener() {
                @Override
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    popup.setVisible(false);
                    popup.dispose();
                }
            });
        }     
    } 
    
    public void  setWindowInvisible()
    {
        form.setVisible(false);     
    }
    public void setWindowVisible()
    {
        form.setVisible(true);   
    }
    
    public void closeWindow()
    {
        form.setVisible(false);
        form.dispose();
    }
}

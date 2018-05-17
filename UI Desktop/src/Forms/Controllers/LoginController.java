package Forms.Controllers;

import Forms.Login;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

public class LoginController implements ActionListener {
    
    private Login form;
    
    private boolean focus = true;
    
    public LoginController() {
        form = new Login(this);
        form.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent evt) {     
        String username = form.getUsername();
        String password = form.getPassword();
        
        String command = evt.getActionCommand();
        
        if (focus) {
            switch (command) {
                case "Connect as Employee":
                    if (Controllers.LoginController.connectEmployee(username, password)) {
                        System.out.println("Angajat");
                        EmployeeMenuController employeeMenuController = new EmployeeMenuController(this);
                    }
                    else {
                        displayConnectionError();
                    }
                    break;
                case "Connect as Company":
                    if (Controllers.LoginController.connectCompany(username, password)) {
                        System.out.println("Companie");
                    }
                    else {
                        displayConnectionError();
                    }
                    break;
            }
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
    
    public void toggleFocus() {
        focus = !focus;
    }
    
    public void displayConnectionError() {
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

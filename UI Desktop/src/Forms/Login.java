/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Forms;

import Forms.Controllers.LoginController;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import javax.swing.JTextField;

/**
 *
 * @author user
 */
public class Login extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */
    static Login form;

    public Login() {
        initComponents();
    }

    public Login(LoginController controller) {

        initComponents();
        buttonConnectEmployee.addActionListener(controller);
        buttonConnectCompany.addActionListener(controller);
        buttonExit.addActionListener(controller);

        //-- Adding TAB to switch Input Slot
        inputUsername.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_TAB) {
                    inputUsername.transferFocus();
                    e.consume();
                }
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        inputUsername = new javax.swing.JTextField();
        buttonConnectEmployee = new javax.swing.JButton();
        buttonExit = new javax.swing.JButton();
        buttonConnectCompany = new javax.swing.JButton();
        labelUsername = new javax.swing.JLabel();
        labelPassword = new javax.swing.JLabel();
        inputPassword = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("PublicSEC");
        setBackground(new java.awt.Color(0, 102, 102));
        setIconImages(null);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(0, 153, 204));
        jLabel1.setFont(new java.awt.Font("Calibri", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("PublicSEC");
        jLabel1.setToolTipText("");
        jLabel1.setAlignmentX(0.5F);
        jLabel1.setAutoscrolls(true);
        jLabel1.setMaximumSize(new java.awt.Dimension(232323, 30));
        jLabel1.setOpaque(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setAutoscrolls(true);
        jPanel1.setMaximumSize(new java.awt.Dimension(323232, 232138));

        inputUsername.setMaximumSize(new java.awt.Dimension(26, 20));
        inputUsername.setPreferredSize(new java.awt.Dimension(26, 20));

        buttonConnectEmployee.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        buttonConnectEmployee.setText("Connect as Employee");
        buttonConnectEmployee.setToolTipText("");
        buttonConnectEmployee.setAlignmentX(0.5F);
        buttonConnectEmployee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonConnectEmployeeActionPerformed(evt);
            }
        });

        buttonExit.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        buttonExit.setText("Exit");
        buttonExit.setAlignmentX(0.5F);
        buttonExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonExitActionPerformed(evt);
            }
        });

        buttonConnectCompany.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        buttonConnectCompany.setText("Connect as Company");
        buttonConnectCompany.setToolTipText("");
        buttonConnectCompany.setAlignmentX(0.5F);
        buttonConnectCompany.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonConnectCompanyActionPerformed(evt);
            }
        });

        labelUsername.setText("Username");
        labelUsername.setToolTipText("");

        labelPassword.setText("Password");
        labelPassword.setToolTipText("");

        inputPassword.setToolTipText("");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(labelPassword)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(0, 8, Short.MAX_VALUE)
                                .addComponent(labelUsername)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(inputUsername, javax.swing.GroupLayout.DEFAULT_SIZE, 247, Short.MAX_VALUE)
                            .addComponent(inputPassword)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(buttonConnectEmployee)
                        .addGap(57, 57, 57)
                        .addComponent(buttonConnectCompany)))
                .addGap(184, 184, 184))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(303, 303, 303)
                .addComponent(buttonExit, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(53, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inputUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelUsername))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inputPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelPassword))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonConnectEmployee, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonConnectCompany, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buttonExit, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 694, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(137, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonConnectEmployeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonConnectEmployeeActionPerformed
        // TODO add your handling code here:
        CompanyMenu.form = new CompanyMenu();
        form.dispose();
        form.setVisible(false);
        CompanyMenu.form.setVisible(true);
    }//GEN-LAST:event_buttonConnectEmployeeActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:

    }//GEN-LAST:event_formWindowOpened

    private void buttonExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonExitActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_buttonExitActionPerformed

    private void buttonConnectCompanyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonConnectCompanyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonConnectCompanyActionPerformed

    public JTextField getjTextField1() {
        return inputUsername;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                form = new Login();

                form.setVisible(true);
                
            }
        });
    }
 
    public String getUsername() {
        return inputUsername.getText();
    }    

    public String getPassword() {
        return new String(inputPassword.getPassword());
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonConnectCompany;
    private javax.swing.JButton buttonConnectEmployee;
    private javax.swing.JButton buttonExit;
    private javax.swing.JPasswordField inputPassword;
    private javax.swing.JTextField inputUsername;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel labelPassword;
    private javax.swing.JLabel labelUsername;
    // End of variables declaration//GEN-END:variables
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.swing.*;

/**
 *
 * @author kevin
 */
public class LoginAndRegister extends javax.swing.JFrame {

    private Sender sender;
    private Receiver receiver;
    private String login;
    
    public LoginAndRegister(Sender sender, Receiver receiver) {
        this.receiver = receiver;
        this.sender = sender;
        initComponents();
        setVisible(true);
    }

    public String getLogin() {
        return login;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToggleButton1 = new javax.swing.JToggleButton();
        loginText = new javax.swing.JTextField();
        passwordText = new javax.swing.JPasswordField();
        loginButton = new javax.swing.JButton();
        registerButton = new javax.swing.JButton();
        backButton = new javax.swing.JButton();
        loginLabel = new javax.swing.JLabel();
        passwordLabel = new javax.swing.JLabel();
        languageComboBox = new javax.swing.JComboBox();
        messageLabel = new javax.swing.JLabel();

        jToggleButton1.setText("jToggleButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);

        loginText.setToolTipText("");

        passwordText.setToolTipText("");

        loginButton.setText("Вход");
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButtonActionPerformed(evt);
            }
        });

        registerButton.setText("Регистрация");
        registerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerButtonActionPerformed(evt);
            }
        });

        backButton.setText("Назад");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        loginLabel.setText("Логин");

        passwordLabel.setText("Пароль");

        languageComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Русский", "Турецкий", "Украинский", "Испанский" }));
        languageComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                languageComboBoxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(passwordLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(loginLabel, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(loginButton)
                                .addGap(18, 18, 18)
                                .addComponent(registerButton)
                                .addGap(18, 18, 18)
                                .addComponent(backButton))
                            .addComponent(passwordText)
                            .addComponent(loginText)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(languageComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(messageLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(messageLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(languageComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(loginText, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(loginLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(passwordLabel)
                    .addComponent(passwordText, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(backButton)
                    .addComponent(registerButton)
                    .addComponent(loginButton))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginButtonActionPerformed
        if(loginText.getText() == null ||loginText.getText().trim().equals("")){
            JOptionPane.showMessageDialog(this, "Введите логин","Info",JOptionPane.PLAIN_MESSAGE);
            return;
        }
        if(passwordText.getText() == null ||passwordText.getText().trim().equals("")){
            JOptionPane.showMessageDialog(this, "Введите пароль","Info",JOptionPane.PLAIN_MESSAGE);
            return;
        }
        login = loginText.getText().trim();
        Pair<String, String> loginPassword = new Pair<>(loginText.getText().trim(), passwordText.getText());
        sender.<Pair<String, String>>send(MessageType.LOGIN, loginPassword, 0);
        JOptionPane.showMessageDialog(this, "Запрос отправлен","Info",JOptionPane.PLAIN_MESSAGE);
        receiver.loginChecked();
    }//GEN-LAST:event_loginButtonActionPerformed

    private void languageComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_languageComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_languageComboBoxActionPerformed

    private void registerButtonActionPerformed(java.awt.event.ActionEvent evt) {
        //GEN-FIRST:event_registerButtonActionPerformed
        if(loginText.getText() == null ||loginText.getText().trim().equals("")){
            JOptionPane.showMessageDialog(this, "Введите логин","Info",JOptionPane.PLAIN_MESSAGE);
            return;
        }
        if(passwordText.getText() == null ||passwordText.getText().trim().equals("")){
            JOptionPane.showMessageDialog(this, "Введите пароль","Info",JOptionPane.PLAIN_MESSAGE);
            return;
        }
        Pair<String,String> registerPassword = new Pair<>(loginText.getText().trim(), passwordText.getText());
        sender.<Pair<String, String>>send(MessageType.REGISTER, registerPassword, 0);
        JOptionPane.showMessageDialog(this, "Запрос отправлен","Info",JOptionPane.PLAIN_MESSAGE);
    }//GEN-LAST:event_registerButtonActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        receiver.loginBack();
    }//GEN-LAST:event_backButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JComboBox languageComboBox;
    private javax.swing.JButton loginButton;
    private javax.swing.JLabel loginLabel;
    private javax.swing.JTextField loginText;
    private javax.swing.JLabel messageLabel;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JPasswordField passwordText;
    private javax.swing.JButton registerButton;
    // End of variables declaration//GEN-END:variables
}

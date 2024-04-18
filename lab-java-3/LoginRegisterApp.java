import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class LoginRegisterApp {
    private static final String USERS_DB_FILE = "UsersDB.txt";

    public static void main(String[] args) {
        JFrame frame = new JFrame("Login/Register App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel loginPanel = new JPanel(new GridLayout(3, 2));
        JLabel lblUsername = new JLabel("Username:");
        JTextField txtUsername = new JTextField();
        JLabel lblPassword = new JLabel("Password:");
        JPasswordField txtPassword = new JPasswordField();
        JButton btnLogin = new JButton("Login");
        
        loginPanel.add(lblUsername);
        loginPanel.add(txtUsername);
        loginPanel.add(lblPassword);
        loginPanel.add(txtPassword);
        loginPanel.add(btnLogin);
        
        JPanel registerPanel = new JPanel(new GridLayout(4, 2));
        JLabel lblRegUsername = new JLabel("Username:");
        JTextField txtRegUsername = new JTextField();
        JLabel lblEmail = new JLabel("Email:");
        JTextField txtEmail = new JTextField();
        JLabel lblRegPassword = new JLabel("Password:");
        JPasswordField txtRegPassword = new JPasswordField();
        JLabel lblConfirmPassword = new JLabel("Confirm Password:");
        JPasswordField txtConfirmPassword = new JPasswordField();
        JButton btnRegister = new JButton("Register");
        
        registerPanel.add(lblRegUsername);
        registerPanel.add(txtRegUsername);
        registerPanel.add(lblEmail);
        registerPanel.add(txtEmail);
        registerPanel.add(lblRegPassword);
        registerPanel.add(txtRegPassword);
        registerPanel.add(lblConfirmPassword);
        registerPanel.add(txtConfirmPassword);
        registerPanel.add(btnRegister);
        
        CardLayout cardLayout = new CardLayout();
        JPanel cardPanel = new JPanel(cardLayout);
        cardPanel.add(registerPanel, "register");
        cardPanel.add(loginPanel, "login");
        
        cardLayout.show(cardPanel, "register");
        
        btnRegister.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = txtRegUsername.getText();
                String email = txtEmail.getText();
                String password = new String(txtRegPassword.getPassword());
                String confirmPassword = new String(txtConfirmPassword.getPassword());
                
                if (!password.equals(confirmPassword)) {
                    JOptionPane.showMessageDialog(frame, "Passwords do not match", "Registration Failed", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(USERS_DB_FILE, true))) {
                    writer.write(username + "\t" + password + "\t" + email + "\n");
                    JOptionPane.showMessageDialog(frame, "Registration Successful", "Success", JOptionPane.INFORMATION_MESSAGE);
                    cardLayout.show(cardPanel, "login");
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
        
        btnLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = txtUsername.getText();
                String password = new String(txtPassword.getPassword());
                
                try (BufferedReader reader = new BufferedReader(new FileReader(USERS_DB_FILE))) {
                    String line;
                    while ((line = reader.readLine()) != null) {
                        String[] parts = line.split("\t");
                        if (parts.length == 3 && parts[0].equals(username) && parts[1].equals(password)) {
                            JOptionPane.showMessageDialog(frame, "Hello " + username, "Login Successful", JOptionPane.INFORMATION_MESSAGE);
                            return;
                        }
                    }
                    JOptionPane.showMessageDialog(frame, "Invalid username or password", "Login Failed", JOptionPane.ERROR_MESSAGE);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
        
        frame.add(cardPanel);
        
        frame.pack();
        frame.setVisible(true);
    }
}

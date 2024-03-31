import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class VoterLoginPage extends JFrame {
    private JTextField nameField;
    private JTextField emailField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JButton signupButton;
    private boolean signupMode = false;

    public VoterLoginPage() {
        setTitle("Voter Credentials");
        setSize(600, 400); // Set initial size to be larger
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;

        JLabel nameLabel = new JLabel("Name:");
        JLabel emailLabel = new JLabel("Email:");
        JLabel passwordLabel = new JLabel("Password:");

        nameField = new JTextField(20);
        emailField = new JTextField(20);
        passwordField = new JPasswordField(20);

        loginButton = new JButton("Login");
        signupButton = new JButton("Signup");

        panel.add(nameLabel, gbc);
        gbc.gridx++;
        panel.add(nameField, gbc);
        gbc.gridx = 0;
        gbc.gridy++;
        panel.add(emailLabel, gbc);
        gbc.gridx++;
        panel.add(emailField, gbc);
        gbc.gridx = 0;
        gbc.gridy++;
        panel.add(passwordLabel, gbc);
        gbc.gridx++;
        panel.add(passwordField, gbc);
        gbc.gridx = 0;
        gbc.gridy++;

        panel.add(loginButton, gbc);
        gbc.gridx++;
        panel.add(signupButton, gbc);

        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Add login logic here
                new PollPage();
            }
        });

        signupButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                toggleSignupMode();
            }
        });

        setBounds(460,200,600,400);
        add(panel);
        setVisible(true);
    }

    private void toggleSignupMode() {
        if (signupMode) {
            setTitle("Voter Login");
            signupButton.setText("Signup");
        } else {
            setTitle("Voter Signup");
            signupButton.setText("Back to Login");
        }
        signupMode = !signupMode;
    }

    public static void main(String[] args) {
        new VoterLoginPage();
    }
}

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class AdminDash extends JFrame implements ActionListener {
    JButton createPollButton ;
    public AdminDash() {
        this.setTitle("Hey! Admin");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new GridBagLayout());
        JLabel headlineLabel = new JLabel("Hey! Admin", JLabel.CENTER);
        headlineLabel.setFont(new Font("Arial", Font.BOLD, 24));
        this.add(headlineLabel, new GridBagConstraints(0, 0, 1, 1, 1.0, 0.1, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(50, 10, 10, 10), 0, 0));
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(3, 1, 0, 10));

        createPollButton =  new JButton("Create Poll");
        createPollButton.addActionListener(this);
        buttonPanel.add(createPollButton);

        JButton historyButton = new JButton("History");
        historyButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(AdminDash.this, "History button clicked");
            }
        });
        buttonPanel.add(historyButton);
        JButton endPollButton = new JButton("End Poll");
        endPollButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(AdminDash.this, "End Poll button clicked");
            }
        });
        buttonPanel.add(endPollButton);
        this.add(buttonPanel, new GridBagConstraints(0, 1, 1, 1, 1.0, 0.9, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 10, 10, 10), 0, 0));

        setBounds(460,200,600,400);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new AdminDash().setVisible(true);
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==createPollButton)
        {   setVisible(false);
            new CreatePollPage();
        }
    }
}

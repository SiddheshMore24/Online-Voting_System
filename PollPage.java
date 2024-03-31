import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PollPage extends JFrame {
    private JList<String> representativeList;
    private JButton voteButton;

    public PollPage() {
        setTitle("Select Your Representative");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        JLabel titleLabel = new JLabel("Select your representative");
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        panel.add(titleLabel, gbc);

        String[] representatives = {"Representative 1", "Representative 2", "Representative 3", "Representative 4"};
        representativeList = new JList<>(representatives);
        JScrollPane scrollPane = new JScrollPane(representativeList);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        panel.add(scrollPane, gbc);

        voteButton = new JButton("Vote");
        voteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String selectedRepresentative = representativeList.getSelectedValue();
                if (selectedRepresentative != null) {
                    JOptionPane.showMessageDialog(null, "You have voted for: " + selectedRepresentative);
                    new VoterLoginPage();
                } else {
                    JOptionPane.showMessageDialog(null, "Please select a representative.");
                }
            }
        });
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        setBounds(460,200,600,400);
        panel.add(voteButton, gbc);

        add(panel, BorderLayout.CENTER);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                PollPage pollPage = new PollPage();
                pollPage.setVisible(true);
            }
        });
    }
}

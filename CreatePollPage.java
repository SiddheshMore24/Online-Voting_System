import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CreatePollPage extends JFrame {

    private JLabel titleLabel;
    private JLabel pollNameLabel; // New label for the poll name
    private JTextField pollNameField; // New text field for the poll name
    private JTextField representativeField;
    private JButton addRepresentativeButton;
    private JButton startPollButton;
    private DefaultListModel<String> representativeListModel;
    private JList<String> representativeList;

    public CreatePollPage() {
        // Set up the frame
        setTitle("Create Poll");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new GridBagLayout());

        // Title
        titleLabel = new JLabel("Create Poll", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        add(titleLabel, new GridBagConstraints(0, 0, 2, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(10, 10, 10, 10), 0, 0));

        // Poll Name label
        pollNameLabel = new JLabel("Poll Name:");
        add(pollNameLabel, new GridBagConstraints(0, 1, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(10, 10, 10, 5), 0, 0));

        // Poll Name text field
        pollNameField = new JTextField(15);
        add(pollNameField, new GridBagConstraints(1, 1, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(10, 5, 10, 10), 0, 0));

        // Text field for representative name
        representativeField = new JTextField(15);
        add(representativeField, new GridBagConstraints(0, 2, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(10, 10, 10, 5), 0, 0));

        // Button to add representative
        addRepresentativeButton = new JButton("Add Representative");
        addRepresentativeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addRepresentative();
            }
        });
        add(addRepresentativeButton, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(10, 5, 10, 10), 0, 0));

        // Button to start poll
        startPollButton = new JButton("Post Poll");
        startPollButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startPoll();
            }
        });
        add(startPollButton, new GridBagConstraints(0, 3, 2, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(10, 10, 10, 10), 0, 0));

        // List for displaying representatives
        representativeListModel = new DefaultListModel<>();
        representativeList = new JList<>(representativeListModel);
        JScrollPane scrollPane = new JScrollPane(representativeList);
        add(scrollPane, new GridBagConstraints(0, 4, 2, 1, 1.0, 1.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(10, 10, 10, 10), 0, 0));
        setBounds(460,200,600,400);
        setVisible(true);
    }

    // Method to add a representative to the list
    private void addRepresentative() {
        String representativeName = representativeField.getText().trim();
        if (!representativeName.isEmpty()) {
            representativeListModel.addElement(representativeName);
            representativeField.setText("");
        } else {
            JOptionPane.showMessageDialog(this, "Please enter a representative name.");
        }
    }

    // Method to start the poll
    private void startPoll() {
        if (representativeListModel.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please add at least one representative.");
        } else {
            String pollName = pollNameField.getText().trim(); // Retrieve the poll name from the text field
            if (pollName.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter a poll name.");
            } else {
                // Perform actions to start the poll (not implemented in this example)
                new VoterLoginPage();
                JOptionPane.showMessageDialog(this, "Poll '" + pollName + "' Posted!");
                setVisible(false);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CreatePollPage();
            }
        });
    }
}

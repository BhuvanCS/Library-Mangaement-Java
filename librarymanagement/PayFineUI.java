
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PayFineUI extends JFrame {

    public PayFineUI(User user) {
        // Set window title
        setTitle("Pay Fine");

        // Create heading label
        JLabel headingLabel = new JLabel("Pay Fine");
        Font headingFont = new Font("Copperplate Gothic Bold", Font.BOLD, 30);
        headingLabel.setFont(headingFont);

        // Create labels
        JLabel dueFinesLabel = new JLabel("Due Fines:");
        JLabel fineAmountLabel = new JLabel("Rs. "+ user.getFine());
        JLabel payLabel = new JLabel("Pay Amount:");
        JTextField payTextField = new JTextField(10);

        dueFinesLabel.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 16));
        payLabel.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 16));
        fineAmountLabel.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 16));
        payTextField.setFont(new Font("Arial", Font.PLAIN, 16));
        // Create "Pay Now" button
        JButton payNowButton = new JButton("Pay Now");

        // Add ActionListener to the "Pay Now" button
        payNowButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	int paidAmount = Integer.valueOf(payTextField.getText());
                int confirmation = JOptionPane.showConfirmDialog(
                        PayFineUI.this,
                        "Confirm payment?",
                        "Confirm Payment",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE
                );

                if (confirmation == JOptionPane.YES_OPTION) {
                	user.payFine(paidAmount);
                    JOptionPane.showMessageDialog(
                            PayFineUI.this,
                            "Successful payment!",
                            "Payment Successful",
                            JOptionPane.INFORMATION_MESSAGE
                    );
                    setVisible(false);
                }
            }
        });

        // Create the layout for the GUI
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.insets = new Insets(10, 10, 10, 10);

        // Add the heading label to the panel
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 2;
        panel.add(headingLabel, constraints);

        // Add "Due Fines" label and fine amount label to the panel
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        panel.add(dueFinesLabel, constraints);

        constraints.gridx = 1;
        panel.add(fineAmountLabel, constraints);

        // Add "Pay:" label and text field to the panel
        constraints.gridx = 0;
        constraints.gridy = 2;
        panel.add(payLabel, constraints);

        constraints.gridx = 1;
        panel.add(payTextField, constraints);

        // Add "Pay Now" button to the panel
        constraints.gridx = 0;
        constraints.gridy = 3;
        constraints.gridwidth = 2;
        panel.add(payNowButton, constraints);

        // Add the panel to the frame
        add(panel);

        // Set window properties
        Dimension windowSize = new Dimension(350,250);
        setSize(windowSize);
        setLocationRelativeTo(null); // Center the window
        
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            PayFineUI app = new PayFineUI(null);
            app.setVisible(true);
        });
    }
}

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.GridLayout;

public class AdminUI {
	static String[] adminActions = {"Issue Book", "Return Book", "View BookList", "Add Book", "Delete Book", "Search a Book", "View User Details", "Log Out"};
    public static void main(String[] args) {
        // Create a new JFrame
        JFrame frame = new JFrame("Admin UI");

        // Create a panel to hold the heading label
        JPanel headingPanel = new JPanel();
        
        // Create a label for the heading
        JLabel headingLabel = new JLabel("Admin Page");
        headingLabel.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 30));
        EmptyBorder padding = new EmptyBorder(15,0,30,0);
        headingLabel.setBorder(padding);
        
        // Add the heading label to the panel
        headingPanel.add(headingLabel);

        // Create a panel for the grid layout
        JPanel gridPanel = new JPanel(new GridLayout(4, 2));
        
        // Create and add the buttons to the grid panel
        for (int i = 0; i < 8; i++) {
            JButton button = new JButton(adminActions[i]);
            button.setFont(new Font("Segoe UI", Font.BOLD, 20));
            gridPanel.add(button);
        }
        
        
        // Set the layout manager of the frame to BorderLayout
        frame.setLayout(new BorderLayout());
        
        // Add the heading panel to the top of the frame
        frame.add(headingPanel, BorderLayout.NORTH);
        
        // Add the grid panel to the center of the frame
        frame.add(gridPanel, BorderLayout.CENTER);
        
        // Set the size and behavior of the frame
        frame.setSize(800, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Make the frame visible
        frame.setVisible(true);
    }
}

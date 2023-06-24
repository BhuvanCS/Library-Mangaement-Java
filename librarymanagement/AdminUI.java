import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.BorderLayout;
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
        
        // Add the heading label to the panel
        headingPanel.add(headingLabel);

        // Create a panel for the grid layout
        JPanel gridPanel = new JPanel(new GridLayout(4, 2));
        
        // Create and add the buttons to the grid panel
        for (int i = 0; i < 8; i++) {
            JButton button = new JButton(adminActions[i]);
            gridPanel.add(button);
        }
        
        
        // Set the layout manager of the frame to BorderLayout
        frame.setLayout(new BorderLayout());
        
        // Add the heading panel to the top of the frame
        frame.add(headingPanel, BorderLayout.NORTH);
        
        // Add the grid panel to the center of the frame
        frame.add(gridPanel, BorderLayout.CENTER);
        
        // Set the size and behavior of the frame
        frame.setSize(800, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Make the frame visible
        frame.setVisible(true);
    }
}

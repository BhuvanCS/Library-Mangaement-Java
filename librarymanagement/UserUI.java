
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserUI extends JFrame {
	static String[] userActions = {"Pay Due Fines", "Search a Book", "View Profile", "Log Out"};
	static String username = "XYZ";
	User user;
	
	public UserUI(User user) {
		super("User Homepage: "+user.getuname());
		this.user = user;
		this.username = user.getuname();
		 // Create a panel to hold the heading label
        JPanel headingPanel = new JPanel();
        
        // Create a label for the heading
        JLabel headingLabel = new JLabel("Welcome "+ username);
        headingLabel.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 30));
        EmptyBorder padding = new EmptyBorder(15,0,30,0);
        headingLabel.setBorder(padding);
        
        // Add the heading label to the panel
        headingPanel.add(headingLabel);

        // Create a panel for the grid layout
        JPanel gridPanel = new JPanel(new GridLayout(2,2));
        
        // Create and add the buttons to the grid panel
        for (int i = 0; i < 4; i++) {
        	final int actionIndex = i;
            JButton button = new JButton(userActions[i]);
            button.setFont(new Font("Segoe UI", Font.BOLD, 20));
            button.addActionListener(new ActionListener() {
    			public void actionPerformed(ActionEvent e) {
    				navigate(actionIndex);
    			}
    		});
            gridPanel.add(button);
            
        }
        
        
        // Set the layout manager of the frame to BorderLayout
        setLayout(new BorderLayout());
        
        // Add the heading panel to the top of the frame
        add(headingPanel, BorderLayout.NORTH);
        
        // Add the grid panel to the center of the frame
        add(gridPanel, BorderLayout.CENTER);
        
        // Set the size and behavior of the frame
        setSize(700, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
    
    public  void navigate(int actionIndex) {
    	switch(actionIndex) {
    	case 0:
    		//call
    		new PayFineUI(user).setVisible(true);
    		break;
    	case 1:
    		//call
    		new SearchBookUI().setVisible(true);
    		break;
    	case 2:
    		//call
    		new ViewProfileUI(user).setVisible(true);
    		break;
    	case 3:
    		 int confirmation = JOptionPane.showConfirmDialog(
                     UserUI.this,
                     "Are you sure you want to Logout?",
                     "Confirm Logout",
                     JOptionPane.YES_NO_OPTION,
                     JOptionPane.QUESTION_MESSAGE
             );

             if (confirmation == JOptionPane.YES_OPTION) {
          
                 JOptionPane.showMessageDialog(
                         UserUI.this,
                         "Logged out Succesfully!",
                         "Logout Succesfull",
                         JOptionPane.INFORMATION_MESSAGE
                 );
                 setVisible(false);
                 new HomePage().setVisible(true);
             }
    		break;
    	}
    }
}

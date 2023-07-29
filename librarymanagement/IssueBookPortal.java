import javax.swing.*;

import com.toedter.calendar.JDateChooser;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

public class IssueBookPortal extends JFrame {

    public IssueBookPortal(User user) {
        setTitle("Issue Book Portal");
        setLayout(new BorderLayout());

        // Header label
        JLabel headerLabel = new JLabel("Issue Book Portal");
        headerLabel.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 30));
        headerLabel.setHorizontalAlignment(JLabel.CENTER);
        add(headerLabel, BorderLayout.NORTH);

        // Left section: Student Details
        JPanel leftPanel = new JPanel(new GridLayout(7, 2));
        leftPanel.setBorder(BorderFactory.createEmptyBorder(40, 20, 20, 10));
        JLabel studentdetailsLabel = new JLabel("Student Details");
        JLabel nameLabel = new JLabel("Name:");
        JLabel contactLabel = new JLabel("Contact no.:");
        JLabel libraryCard1Label = new JLabel("Library Card 1:");
        JLabel libraryCard2Label = new JLabel("Library Card 2:");
        JLabel dueFineLabel = new JLabel("Due Fines:");
        JLabel emptyLabel = new JLabel(); // For spacing

        // Fake student data
        JLabel nameValueLabel = new JLabel(user.getuname());
        JLabel contactValueLabel = new JLabel(user.getphno());
        JLabel libraryCard1ValueLabel = new JLabel(user.getlib1() + "\t" +(user.getlibs1().equals("0")?"\tActive":"\tIn Use"));
        JLabel libraryCard2ValueLabel = new JLabel(user.getlib2()+ "\t" + (user.getlibs2().equals("0")?"\tActive":"\tIn Use"));
        JLabel dueFineValueLabel = new JLabel(String.valueOf(user.getFine()));

        // Increase font size for labels
        Font labelFont = nameLabel.getFont();
        studentdetailsLabel.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 20));
        nameLabel.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 16));
        contactLabel.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 16));
        libraryCard1Label.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 16));
        libraryCard2Label.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 16));
        dueFineLabel.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 16));
        nameValueLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        contactValueLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        libraryCard1ValueLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        libraryCard2ValueLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        dueFineValueLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));

        leftPanel.add(studentdetailsLabel);
        leftPanel.add(emptyLabel);
        leftPanel.add(nameLabel);
        leftPanel.add(nameValueLabel);
        leftPanel.add(contactLabel);
        leftPanel.add(contactValueLabel);
        leftPanel.add(libraryCard1Label);
        leftPanel.add(libraryCard1ValueLabel);
        leftPanel.add(libraryCard2Label);
        leftPanel.add(libraryCard2ValueLabel);
        leftPanel.add(dueFineLabel);
        leftPanel.add(dueFineValueLabel);
        add(leftPanel, BorderLayout.WEST);

        // Right section: Book Details
        JPanel rightPanel = new JPanel(new GridLayout(5, 2));
        rightPanel.setBorder(BorderFactory.createEmptyBorder(40, 10, 20, 20));
        JLabel issuedetailsLabel = new JLabel("Issue Details");
        JLabel bookIdLabel = new JLabel("Book ID:");
        JTextField bookIdTextField = new JTextField();
        JLabel issueDateLabel = new JLabel("Issue Date:");
        JDateChooser issueDate = new JDateChooser();
        JLabel returnDateLabel = new JLabel("Return Date:");
        JDateChooser returnDate = new JDateChooser();
        JRadioButton lib1Radio = new JRadioButton("Active", true);
        JRadioButton lib2Radio = new JRadioButton("Inactive");
        ButtonGroup radioButtonGroup = new ButtonGroup();
        radioButtonGroup.add(lib1Radio);
        if(!user.getlibs1().equals("0"))
        	lib1Radio.setEnabled(false);
        radioButtonGroup.add(lib2Radio);
        if(!user.getlibs2().equals("0"))
        	lib2Radio.setEnabled(false);
        JButton issueButton = new JButton("Issue");
        issueButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SimpleDateFormat dFormat=new SimpleDateFormat("dd-mm-yyyy");
				String bookId=bookIdTextField.getText();
				//String Studentid= studentid.getText();
				String IssueDate=dFormat.format(issueDate.getDate());
				String ReturnDate=dFormat.format(returnDate.getDate());
				if(user.getlibs1().equals("0") || user.getlibs2().equals("0"))
				{
					boolean issued = user.issueBook(bookId, IssueDate, ReturnDate);
					if(!issued)
					{
						JOptionPane.showMessageDialog(null,"Cannot Issue! Book ID doesnt exist!");
					}
					else
					{
						JOptionPane.showMessageDialog(null,"Issued Successfully!");
					}
				}
				else
				{
					JOptionPane.showMessageDialog(null,"Cannot Issue! Both Library cards in use!");
				}
				//USE THIS LINE FOR SUCCESSFUL UPDATION
				//JOptionPane.showMessageDialog(null,"SUCESSFULLY DATA REGISTERED INTO DATABASE!!!");
			}
		});

        // Increase font size for labels
        issuedetailsLabel.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 20));
        bookIdLabel.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 16));
        issueDateLabel.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 16));
        returnDateLabel.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 16));

        rightPanel.add(issuedetailsLabel);
        rightPanel.add(new JLabel()); // For spacing
        rightPanel.add(bookIdLabel);
        rightPanel.add(bookIdTextField);
        rightPanel.add(issueDateLabel);
        rightPanel.add(issueDate);
        rightPanel.add(returnDateLabel);
        rightPanel.add(returnDate);
        rightPanel.add(lib1Radio);
        rightPanel.add(lib2Radio);
        add(rightPanel, BorderLayout.CENTER);

        // Center the submit button
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(issueButton);
        add(buttonPanel, BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(null); // Center the window on the screen
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            IssueBookPortal gui = new IssueBookPortal(null);
            gui.setVisible(true);
        });
    }
}

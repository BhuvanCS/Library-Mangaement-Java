

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;

public class NewUser extends JFrame {

	private JPanel contentPane;
	private JTextField unameField;
	private JTextField contactField;
	private JTextField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewUser frame = new NewUser();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public NewUser() {
		setBackground(new Color(255, 255, 255));
		setBounds(100, 100, 834, 731);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 102, 102));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel headingLabel = new JLabel("*****WELCOME TO ABCS LIBRARY *****");
		headingLabel.setBounds(88, 48, 648, 43);
		headingLabel.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 28));
		headingLabel.setForeground(new Color(255, 255, 255));
		contentPane.add(headingLabel);
		
		JLabel subheadingLabel = new JLabel("REGISTRATION DETAILS");
		subheadingLabel.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 26));
		subheadingLabel.setForeground(new Color(255, 255, 51));
		subheadingLabel.setBounds(248, 123, 450, 51);
		contentPane.add(subheadingLabel);
		
		JLabel unameLabel = new JLabel("Username:");
		unameLabel.setForeground(new Color(204, 204, 204));
		unameLabel.setFont(new Font("Segoe UI", Font.BOLD, 22));
		unameLabel.setBounds(130, 227, 316, 51);
		contentPane.add(unameLabel);
		
		JLabel contactLabel = new JLabel("Valid Contact No:");
		contactLabel.setForeground(new Color(204, 204, 204));
		contactLabel.setFont(new Font("Segoe UI", Font.BOLD, 22));
		contactLabel.setBounds(130, 342, 316, 51);
		contentPane.add(contactLabel);
		
		JLabel passwordLabel = new JLabel("Set Password:");
		passwordLabel.setForeground(new Color(204, 204, 204));
		passwordLabel.setFont(new Font("Segoe UI", Font.BOLD, 22));
		passwordLabel.setBounds(130, 461, 316, 51);
		contentPane.add(passwordLabel);
		
		unameField = new JTextField();
		unameField.setBounds(429, 235, 258, 43);
		unameField.setFont(new Font("Segoe UI", Font.BOLD, 20));
		contentPane.add(unameField);
		unameField.setColumns(10);
		
		contactField = new JTextField();
		contactField.setColumns(10);
		contactField.setFont(new Font("Segoe UI", Font.BOLD, 20));
		contactField.setBounds(429, 350, 258, 43);
		contentPane.add(contactField);
		
		passwordField = new JTextField();
		passwordField.setColumns(10);
		passwordField.setFont(new Font("Segoe UI", Font.BOLD, 20));
		passwordField.setBounds(427, 469, 258, 43);
		contentPane.add(passwordField);
		
		JButton regBtn = new JButton("REGISTER");
		regBtn.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 16));
		regBtn.setBounds(303, 586, 168, 51);
		contentPane.add(regBtn);
		regBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String uname = unameField.getText();
				String phno = contactField.getText();
				String pw = passwordField.getText();
				if(phno.length()!=10)
				{
					JOptionPane.showMessageDialog(
                            NewUser.this,
                            "Error: Phone number must be 10 characters",
                            "Error",
                            JOptionPane.ERROR_MESSAGE
                    );
				}
				else
				{
					int confirmation = JOptionPane.showConfirmDialog(
		                    NewUser.this,
		                    "Confirm User Registration?",
		                    "Confirm Registration",
		                    JOptionPane.YES_NO_OPTION,
		                    JOptionPane.QUESTION_MESSAGE
		            );

		            if (confirmation == JOptionPane.YES_OPTION) {
		            	String[] cards = new LibraryManagement().newUser(uname, pw, phno);
		                JOptionPane.showMessageDialog(
		                        NewUser.this,
		                        "Registered Succesfully!\nCard numbers: \nCard1:"+cards[0]+"\nCard2:"+cards[1],
		                        "Registration Succesfull",
		                        JOptionPane.INFORMATION_MESSAGE
		                );
		                setVisible(false);
		                new HomePage().setVisible(true);
		            }
				}
			}
		});
	}

}

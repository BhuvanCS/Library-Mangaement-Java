

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JToolBar;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class IssueReturnLoginPage extends JFrame {

	private JPanel contentPane;
	private JTextField username;
	private JPasswordField passwordField;
	protected Object correctdetails;


	/**
	 * Create the frame.
	 */
	public IssueReturnLoginPage(int issueOrReturn) {
		String text = issueOrReturn == 0 ? "Book Issue - Student Login" : "Book Return - Student Login";
		setBounds(100, 100, 938, 527);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setForeground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel(text);
		lblNewLabel.setBounds(266, 25, 500, 43);
		lblNewLabel.setForeground(new Color(248, 248, 255));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 36));
		contentPane.add(lblNewLabel);
		
		JLabel student = new JLabel("Enter Student Username");
		student.setForeground(new Color(255, 255, 255));
		student.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 23));
		student.setBounds(117, 158, 285, 36);
		contentPane.add(student);
		
		username = new JTextField();
		username.setBounds(409, 151, 307, 43);
		username.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 23));
		contentPane.add(username);
		username.setColumns(10);
		
		JLabel studentpwd = new JLabel("Enter Student Password");
		studentpwd.setForeground(Color.WHITE);
		studentpwd.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 23));
		studentpwd.setBounds(117, 251, 285, 36);
		contentPane.add(studentpwd);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(410, 244, 306, 43);
		passwordField.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 23));
		contentPane.add(passwordField);
		
		JButton btnNewButton = new JButton("LOGIN");
		btnNewButton.setFont(new Font("Copperplate Gothic Light", Font.BOLD, 22));
		btnNewButton.setBounds(341, 354, 154, 49);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String studentname = username.getText();
				char[] pw = passwordField.getPassword();
				String password = new String(pw);
				LibraryManagement lib = new LibraryManagement();
				User validatedUser = lib.userLogin(studentname,password);
				if(validatedUser != null) {
					if(issueOrReturn == 0)
					{
						IssueBookPortal Obj = new IssueBookPortal(validatedUser);
						Obj.setVisible(true);
					}
					else
					{
						ReturnBookPortal Obj=new ReturnBookPortal(validatedUser);
						Obj.setVisible(true);
					}
					
					dispose();
				}
				else {
					System.out.println("Unsuccesful login!");
					dispose();
					IssueReturnLoginPage obj = new IssueReturnLoginPage(0);
					obj.setVisible(true);
				}
				
			}
		});
		
		
	}
}

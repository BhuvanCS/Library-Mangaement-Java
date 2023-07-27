package Library;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ReturnPage extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReturnPage frame = new ReturnPage();
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
	public ReturnPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 723, 423);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("RETURN BOOK PORTAL");
		lblNewLabel.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 18));
		lblNewLabel.setBounds(238, 26, 253, 13);
		contentPane.add(lblNewLabel);
		
		JLabel lblStudentName = new JLabel("Enter Student Username");
		lblStudentName.setFont(new Font("Segoe UI Symbol", Font.BOLD, 18));
		lblStudentName.setBounds(63, 101, 253, 25);
		contentPane.add(lblStudentName);
		
		JLabel lblEnterStudentPassword = new JLabel("Enter Student Password");
		lblEnterStudentPassword.setFont(new Font("Segoe UI Symbol", Font.BOLD, 18));
		lblEnterStudentPassword.setBounds(63, 192, 253, 25);
		contentPane.add(lblEnterStudentPassword);
		
		textField = new JTextField();
		textField.setBounds(346, 101, 236, 35);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(346, 192, 236, 35);
		contentPane.add(passwordField);
		
		JButton btnNewButton = new JButton("LOGIN");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//USE THIS LINE FOR SUCCESSFUL login
				//JOptionPane.showMessageDialog(null,"SUCESSFULLY LOGGED IN!!!");
				//USE THIS LINE FOR UNSUCCESSFUL UPDATION
				//JOptionPane.showMessageDialog(null,"UNSUCCESSFUL LOGIN!!!");
			}
		});
		btnNewButton.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 12));
		btnNewButton.setBounds(276, 281, 118, 35);
		contentPane.add(btnNewButton);
	}
}

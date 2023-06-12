package liop;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JPasswordField;

public class Home extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home frame = new Home();
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
	public Home() {
		setForeground(new Color(255, 204, 204));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 833, 740);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 102, 102));
		contentPane.setForeground(new Color(255, 204, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton Login = new JButton("LOGIN");
		Login.setForeground(new Color(0, 0, 0));
		Login.setBackground(new Color(255, 204, 204));
		Login.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 20));
		Login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			
			
			
			
			
			
			
			
			
			}
		});
		Login.setBounds(309, 525, 181, 57);
		contentPane.add(Login);
		
		JLabel lblNewLabel = new JLabel("USER NAME");
		lblNewLabel.setForeground(new Color(204, 204, 255));
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblNewLabel.setBounds(206, 282, 126, 49);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("PASSWORD");
		lblNewLabel_1.setForeground(new Color(204, 204, 255));
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblNewLabel_1.setBounds(206, 410, 135, 24);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(394, 282, 236, 39);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(394, 395, 236, 39);
		contentPane.add(passwordField);
		
		lblNewLabel_2 = new JLabel("***** WELCOME TO ABCE LIBRARY *****");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 26));
		lblNewLabel_2.setBounds(115, 50, 610, 39);
		contentPane.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("ADMIN LOGIN");
		lblNewLabel_3.setForeground(new Color(255, 255, 51));
		lblNewLabel_3.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 26));
		lblNewLabel_3.setBounds(288, 160, 242, 33);
		contentPane.add(lblNewLabel_3);
	}
}

package liop;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class HomePage extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomePage frame = new HomePage();
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
	public HomePage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 822, 722);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 51));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("HOME PAGE");
		lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 36));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(313, 36, 189, 60);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("***** WELCOME TO ABCS LIBRARY *****");
		lblNewLabel_1.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 24));
		lblNewLabel_1.setForeground(new Color(255, 255, 0));
		lblNewLabel_1.setBounds(139, 106, 554, 33);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("ADMIN LOGIN");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Home Obj=new Home();
				Obj.setVisible(true);
				dispose();
				
			}
		});
		btnNewButton.setFont(new Font("Segoe UI", Font.BOLD, 17));
		btnNewButton.setBounds(270, 197, 266, 76);
		contentPane.add(btnNewButton);
		
		JButton btnRegisterForNew = new JButton("REGISTER FOR NEW USER");
		btnRegisterForNew.setFont(new Font("Segoe UI", Font.BOLD, 17));
		btnRegisterForNew.setBounds(270, 336, 266, 76);
		contentPane.add(btnRegisterForNew);
		
		JButton btnMemberLogin = new JButton("MEMBER LOGIN");
		btnMemberLogin.setFont(new Font("Segoe UI", Font.BOLD, 17));
		btnMemberLogin.setBounds(270, 471, 266, 76);
		contentPane.add(btnMemberLogin);
	}

}

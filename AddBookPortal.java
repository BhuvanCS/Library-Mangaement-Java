package Library;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddBookPortal extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddBookPortal frame = new AddBookPortal();
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
	public AddBookPortal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 591, 406);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Add A Book");
		lblNewLabel.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 18));
		lblNewLabel.setBounds(211, 10, 157, 13);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Enter Book ID");
		lblNewLabel_1.setFont(new Font("Segoe UI Variable", Font.BOLD, 14));
		lblNewLabel_1.setBounds(92, 67, 100, 13);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(254, 60, 191, 31);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Enter Book Name");
		lblNewLabel_1_1.setFont(new Font("Segoe UI Variable", Font.BOLD, 14));
		lblNewLabel_1_1.setBounds(92, 130, 145, 13);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Enter Author Name");
		lblNewLabel_1_1_1.setFont(new Font("Segoe UI Variable", Font.BOLD, 14));
		lblNewLabel_1_1_1.setBounds(92, 201, 145, 13);
		contentPane.add(lblNewLabel_1_1_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(254, 129, 191, 31);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(254, 200, 191, 31);
		contentPane.add(textField_2);
		
		JButton btnNewButton = new JButton("ADD");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//USE THIS LINE FOR SUCCESSFUL login
				//JOptionPane.showMessageDialog(null,"SUCESSFULLY ADDED INTO DATABASE!!!");
				
			}
		});
		btnNewButton.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 14));
		btnNewButton.setBounds(161, 278, 85, 31);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Close");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				//If you want redirect this to homePage
			}
		});
		btnNewButton_1.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 14));
		btnNewButton_1.setBounds(301, 278, 107, 31);
		contentPane.add(btnNewButton_1);
	}
}

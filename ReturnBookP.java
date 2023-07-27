package Library;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ReturnBookP extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReturnBookP frame = new ReturnBookP();
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
	public ReturnBookP() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 813, 462);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Student Details");
		lblNewLabel.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 16));
		lblNewLabel.setBounds(56, 68, 146, 28);
		contentPane.add(lblNewLabel);
		
		JLabel lblReturnPage = new JLabel("Return Page");
		lblReturnPage.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 20));
		lblReturnPage.setBounds(321, 20, 146, 28);
		contentPane.add(lblReturnPage);
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_1.setBounds(56, 136, 57, 13);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Phone NO");
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_1_1.setBounds(56, 196, 84, 13);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("LIB");
		lblNewLabel_1_1_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_1_1_1.setBounds(56, 257, 84, 13);
		contentPane.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_2 = new JLabel("Asdf");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_2.setBounds(193, 136, 72, 15);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("132224343");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_3.setBounds(193, 198, 72, 13);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("1221");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_4.setBounds(193, 259, 72, 13);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_1_2 = new JLabel("Book ID");
		lblNewLabel_1_2.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_1_2.setBounds(417, 136, 84, 13);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_2_2 = new JLabel("Returned Date");
		lblNewLabel_1_2_2.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_1_2_2.setBounds(394, 206, 137, 24);
		contentPane.add(lblNewLabel_1_2_2);
		
		textField = new JTextField();
		textField.setBounds(544, 126, 169, 28);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(544, 206, 169, 28);
		contentPane.add(dateChooser);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("ABCD");
		rdbtnNewRadioButton.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 12));
		rdbtnNewRadioButton.setBounds(417, 74, 103, 21);
		contentPane.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnXyz = new JRadioButton("XYZ");
		rdbtnXyz.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 12));
		rdbtnXyz.setBounds(583, 74, 103, 21);
		contentPane.add(rdbtnXyz);
		
		JButton btnNewButton = new JButton("RETURN");
		btnNewButton.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 12));
		btnNewButton.setBounds(432, 338, 91, 28);
		contentPane.add(btnNewButton);
		
		JButton btnClose = new JButton("CLOSE");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnClose.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 12));
		btnClose.setBounds(595, 338, 91, 28);
		contentPane.add(btnClose);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Fine Amount");
		lblNewLabel_1_2_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_1_2_1.setBounds(394, 280, 114, 13);
		contentPane.add(lblNewLabel_1_2_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(544, 279, 169, 28);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
	}
}



import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddBookPortal extends JFrame {

	private JPanel contentPane;
	private JTextField bookid;
	private JTextField bookname;
	private JTextField authorname;

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
		setBounds(100, 100, 591, 406);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Add A Book");
		lblNewLabel.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 22));
		lblNewLabel.setBounds(211, 20, 157, 20);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Book ID");
		lblNewLabel_1.setFont(new Font("Segoe UI Variable", Font.BOLD, 16));
		lblNewLabel_1.setBounds(140, 85, 100, 13);
		contentPane.add(lblNewLabel_1);
		
		bookid = new JTextField();
		bookid.setBounds(254, 78, 191, 31);
		bookid.setFont(new Font("Segoe UI Variable", Font.PLAIN, 14));
		contentPane.add(bookid);
		bookid.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Book Name");
		lblNewLabel_1_1.setFont(new Font("Segoe UI Variable", Font.BOLD, 16));
		lblNewLabel_1_1.setBounds(140, 145, 145, 13);
		contentPane.add(lblNewLabel_1_1);
		
		bookname = new JTextField();
		bookname.setColumns(10);
		bookname.setFont(new Font("Segoe UI Variable", Font.PLAIN, 14));
		bookname.setBounds(254, 140, 191, 31);
		contentPane.add(bookname);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Author Name");
		lblNewLabel_1_1_1.setFont(new Font("Segoe UI Variable", Font.BOLD, 16));
		lblNewLabel_1_1_1.setBounds(140, 215, 145, 13);
		contentPane.add(lblNewLabel_1_1_1);
		
		
		authorname = new JTextField();
		authorname.setColumns(10);
		authorname.setFont(new Font("Segoe UI Variable", Font.PLAIN, 14));
		authorname.setBounds(254, 205, 191, 31);
		contentPane.add(authorname);
		
		JButton btnNewButton = new JButton("ADD");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Book.addBook(bookid.getText(), bookname.getText(), authorname.getText());
				JOptionPane.showMessageDialog(null,"Book succesfully added to database!");
				setVisible(false);
			}
		});
		btnNewButton.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 14));
		btnNewButton.setBounds(161, 278, 85, 31);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("CLOSE");
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

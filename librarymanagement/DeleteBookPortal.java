

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DeleteBookPortal extends JFrame {

	private JPanel contentPane;


	/**
	 * Create the frame.
	 */
	public DeleteBookPortal() {
		setBounds(100, 100, 568, 278);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Delete a Book");
		lblNewLabel.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 22));
		lblNewLabel.setBounds(190, 20, 250, 30);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Book Id :");
		lblNewLabel_1.setFont(new Font("Segoe UI Symbol", Font.BOLD, 18));
		lblNewLabel_1.setBounds(150, 80, 130, 27);
		contentPane.add(lblNewLabel_1);
		
		JTextField bookid = new JTextField();
		bookid.setBounds(254, 78, 191, 31);
		bookid.setFont(new Font("Segoe UI Variable", Font.PLAIN, 14));
		contentPane.add(bookid);
		bookid.setColumns(10);
		
		JButton btnNewButton = new JButton("DELETE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean deleted = Book.delBook(bookid.getText());
				if(deleted) 
					JOptionPane.showMessageDialog(null,"Book deleted from database!");
				else
					JOptionPane.showMessageDialog(null,"Entered Book id doesnt match with any book in database!");
				setVisible(false);
				
			}
		});
		btnNewButton.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 16));
		btnNewButton.setBounds(206, 139, 119, 27);
		contentPane.add(btnNewButton);
	}

}

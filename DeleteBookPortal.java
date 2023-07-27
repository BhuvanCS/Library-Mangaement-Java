package Library;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DeleteBookPortal extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeleteBookPortal frame = new DeleteBookPortal();
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
	public DeleteBookPortal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 568, 278);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Delete a Book");
		lblNewLabel.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 18));
		lblNewLabel.setBounds(211, 10, 157, 13);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Enter Book Id :");
		lblNewLabel_1.setFont(new Font("Segoe UI Symbol", Font.BOLD, 15));
		lblNewLabel_1.setBounds(66, 71, 130, 27);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("1123");
		lblNewLabel_1_1.setFont(new Font("Segoe UI Symbol", Font.BOLD, 15));
		lblNewLabel_1_1.setBounds(206, 71, 130, 27);
		contentPane.add(lblNewLabel_1_1);
		
		JButton btnNewButton = new JButton("DELETE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//USE THIS LINE FOR SUCCESSFUL Deletion
				//JOptionPane.showMessageDialog(null,"SUCESSFULLY DELETED FROM DATABASE!!!!");
			}
		});
		btnNewButton.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 16));
		btnNewButton.setBounds(206, 139, 119, 27);
		contentPane.add(btnNewButton);
	}

}

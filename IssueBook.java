package Library;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;

public class IssueBook extends JFrame {

	private JPanel contentPane;
	private JTextField Bookid;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IssueBook frame = new IssueBook();
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
	public IssueBook() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 858, 583);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Book Id");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel.setBounds(467, 153, 108, 47);
		contentPane.add(lblNewLabel);
		
		JLabel stulabel = new JLabel("Name");
		stulabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		stulabel.setBounds(69, 153, 127, 47);
		contentPane.add(stulabel);
		
		JLabel lblIssueDate = new JLabel("Issue Date");
		lblIssueDate.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblIssueDate.setBounds(467, 236, 96, 47);
		contentPane.add(lblIssueDate);
		
		JLabel lblDueDate = new JLabel("Due Date");
		lblDueDate.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblDueDate.setBounds(467, 307, 96, 47);
		contentPane.add(lblDueDate);
		
		Bookid = new JTextField();
		Bookid.setBounds(577, 161, 213, 35);
		contentPane.add(Bookid);
		Bookid.setColumns(10);
		
		JDateChooser issuedate = new JDateChooser();
		issuedate.setBounds(577, 236, 213, 34);
		contentPane.add(issuedate);
		
		JDateChooser duedate = new JDateChooser();
		duedate.setBounds(577, 308, 213, 34);
		contentPane.add(duedate);
		
		JButton issuebtn = new JButton("Issue");
		issuebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SimpleDateFormat dFormat=new SimpleDateFormat("dd-mm-yyyy");
				String bookId=Bookid.getText();
				String Studentid=studentid.getText();
				String IssueDate=dFormat.format(issuedate.getDate());
				String DueDate=dFormat.format(duedate.getDate());
				String returnBook="No";
				//USE THIS LINE FOR SUCCESSFUL UPDATION
				//JOptionPane.showMessageDialog(null,"SUCESSFULLY DATA REGISTERED INTO DATABASE!!!");
			}
		});
		issuebtn.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 14));
		issuebtn.setBounds(503, 444, 117, 35);
		contentPane.add(issuebtn);
		
		JButton closebtn = new JButton("Close");
		closebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		closebtn.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 12));
		closebtn.setBounds(673, 444, 117, 35);
		contentPane.add(closebtn);
		
		JLabel lblNewLabel_1 = new JLabel("Book Issue Portal");
		lblNewLabel_1.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 24));
		lblNewLabel_1.setBounds(296, 22, 255, 41);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Student Details");
		lblNewLabel_1_1.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(69, 87, 255, 41);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblPhoneNo = new JLabel("Phone NO");
		lblPhoneNo.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblPhoneNo.setBounds(69, 236, 96, 47);
		contentPane.add(lblPhoneNo);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("ABCD");
		rdbtnNewRadioButton.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 16));
		rdbtnNewRadioButton.setBounds(503, 390, 103, 21);
		contentPane.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnXyz = new JRadioButton("XYZ");
		rdbtnXyz.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 16));
		rdbtnXyz.setBounds(673, 392, 103, 21);
		contentPane.add(rdbtnXyz);
		
		JLabel lblNewLabel_2 = new JLabel("ABS1");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_2.setBounds(212, 167, 88, 21);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("234353534");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_3.setBounds(212, 255, 77, 13);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblLib = new JLabel("LIB1:");
		lblLib.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblLib.setBounds(69, 307, 96, 47);
		contentPane.add(lblLib);
		
		JLabel lblNewLabel_4 = new JLabel("1221");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_4.setBounds(212, 326, 77, 13);
		contentPane.add(lblNewLabel_4);
	}
}

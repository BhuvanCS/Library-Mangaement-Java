
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class ViewProfileUI extends JFrame {

    public ViewProfileUI(User user) {
        // Set window title
        setTitle("View Profile");

        // Create labels
        JLabel headerLabel = new JLabel("User Profile");
        JLabel nameLabel = new JLabel("Name:");
        JLabel contactLabel = new JLabel("Contact:");
        JLabel libraryCard1Label = new JLabel("Library Card 1:");
        JLabel libraryCard2Label = new JLabel("Library Card 2:");
        JLabel dueFineLabel = new JLabel("Due Fine:");
        
        JLabel nameValueLabel = new JLabel(user.getuname());
        JLabel contactValueLabel = new JLabel(user.getphno());
        JLabel libraryCard1ValueLabel = new JLabel(user.getlib1() + (user.getlibs1().equals("0")?"\tActive":"In Use"));
        JLabel libraryCard2ValueLabel = new JLabel(user.getlib2() + (user.getlibs2().equals("0")?"\tActive":"In Use"));
        JLabel dueFineValueLabel = new JLabel(String.valueOf(user.getFine()));

        headerLabel.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 30));
        nameLabel.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 16));
        contactLabel.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 16));
        libraryCard1Label.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 16));
        libraryCard2Label.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 16));
        dueFineLabel.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 16));
        nameValueLabel.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 16));
        contactValueLabel.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 16));
        libraryCard1ValueLabel.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 16));
        libraryCard2ValueLabel.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 16));
        dueFineValueLabel.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 16));
        
        // Create table data
        ArrayList<ArrayList<String>> allinfo = user.viewProfile();
        String[][] tableData = new String[allinfo.size()][2];
        for(int i = 0; i<allinfo.size(); i++)
        {
        	tableData[i][0] = allinfo.get(i).get(0);
        	tableData[i][1] = allinfo.get(i).get(1);
        }

        // Create table column names
        String[] columnNames = {"Action Performed", "Date"};

        // Create table model and add data
        DefaultTableModel tableModel = new DefaultTableModel(tableData, columnNames);

        // Create table
        JTable table = new JTable(tableModel);
        table.getColumnModel().getColumn(0).setPreferredWidth(300);
        table.getColumnModel().getColumn(1).setPreferredWidth(150);
        //table.setPreferredScrollableViewportSize(table.getPreferredSize());
        table.setFont(new Font("Segoe UI", Font.PLAIN, 17));
        int horizontalSpacing = 20;
        int verticalSpacing = 10;
        table.setRowHeight(30);
        table.setIntercellSpacing(new Dimension(horizontalSpacing, verticalSpacing));
        JScrollPane scrollPane = new JScrollPane(table);

        // Create the layout for the labels and the table
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.insets = new Insets(6, 6, 6, 6);

        // Add labels to the panel
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 2;
        panel.add(headerLabel,constraints);
        
        constraints.anchor = GridBagConstraints.WEST;
        constraints.gridwidth = 1;
        constraints.gridx = 0;
        constraints.gridy = 2;
        panel.add(nameLabel, constraints);
        constraints.gridx = 1;
        panel.add(nameValueLabel, constraints);

        constraints.gridx = 0;
        constraints.gridy = 3;
        panel.add(contactLabel, constraints);
        constraints.gridx = 1;
        panel.add(contactValueLabel, constraints);

        constraints.gridx = 0;
        constraints.gridy = 4;
        panel.add(libraryCard1Label, constraints);
        constraints.gridx = 1;
        panel.add(libraryCard1ValueLabel, constraints);

        constraints.gridx = 0;
        constraints.gridy = 5;
        panel.add(libraryCard2Label, constraints);
        constraints.gridx = 1;
        panel.add(libraryCard2ValueLabel, constraints);

        constraints.gridx = 0;
        constraints.gridy = 6;
        panel.add(dueFineLabel, constraints);
        constraints.gridx = 1;
        panel.add(dueFineValueLabel, constraints);

        // Add the table to the panel
        constraints.gridx = 0;
        constraints.gridy = 7;
        constraints.gridwidth = 2;
        constraints.anchor = GridBagConstraints.CENTER;
        panel.add(scrollPane, constraints);

        // Add the panel to the frame
        add(panel);

        // Set window properties
        Dimension windowSize = new Dimension(500, 800);
        setSize(windowSize);
        setLocationRelativeTo(null); // Center the window
    }
}


import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import java.awt.*;
import java.util.ArrayList;

public class ViewUsersUI extends JFrame {
    
    private JTable dataTable;
    private DefaultTableModel tableModel;

    public ViewUsersUI() {
        super("View Users");
        // Initialize components
        dataTable = new JTable();

        // Create table model with column names and no initial data
        String[] columnNames = {"Username","Contact","LibraryCard1", "Card1 Status", "LibraryCard2", "Card2 Status", "Due Fine"};
        tableModel = new DefaultTableModel(columnNames, 0);
        dataTable.setModel(tableModel);

        // Set custom border for the table
        Border tableBorder = BorderFactory.createLineBorder(Color.BLACK);
        dataTable.setBorder(tableBorder);

        // Set custom intercell spacing for the table
        int horizontalSpacing = 10;
        int verticalSpacing = 10;
        dataTable.setRowHeight(30);
        for (int i = 0; i < dataTable.getColumnCount(); i++) {
            dataTable.getColumnModel().getColumn(i).setPreferredWidth(1200);
        }

        dataTable.setIntercellSpacing(new Dimension(horizontalSpacing, verticalSpacing));

        // Set custom styling for components
        
        
        Font headerFont = new Font("Arial", Font.BOLD, 30);
        JTableHeader tableHeader = dataTable.getTableHeader();

        dataTable.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        tableHeader.setFont(headerFont);

        // Center align table header text
        DefaultTableCellRenderer headerRenderer = new DefaultTableCellRenderer();
        headerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        dataTable.getTableHeader().setDefaultRenderer(headerRenderer);
        

        // Set layout and add components to the frame
        setLayout(new BorderLayout());
        add(new JScrollPane(dataTable), BorderLayout.CENTER);
        
        updateTableData();
        
        pack();
        setLocationRelativeTo(null);
    }

    // Update the table data with new data
    private void updateTableData() {
        // Add new data to the table
    	LibraryManagement obj = new LibraryManagement();
        ArrayList<User> allusers = obj.viewUsers();
        Object[][] data = new Object[allusers.size()][7];
        for(int i = 0; i<allusers.size(); i++)
        {
        	User u = allusers.get(i);
        	data[i][0] = u.getuname();
        	data[i][1] = u.getphno();
        	data[i][2] = u.getlib1();
        	data[i][3] = u.getlibs1();
        	data[i][4] = u.getlib2();
        	data[i][5] = u.getlibs2();
        	data[i][6] = u.getFine();
        }
        
        for (Object[] rowData : data) {
            tableModel.addRow(rowData);
        }
    }
}

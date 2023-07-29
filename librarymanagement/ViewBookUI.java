
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import java.awt.*;
import java.util.ArrayList;

public class ViewBookUI extends JFrame {
    
    private JTable dataTable;
    private DefaultTableModel tableModel;

    public ViewBookUI() {
        super("View Book List");

        // Initialize components
        dataTable = new JTable();

        // Create table model with column names and no initial data
        String[] columnNames = {"Book ID", "Title", "Author"};
        tableModel = new DefaultTableModel(columnNames, 0);
        dataTable.setModel(tableModel);

        // Set custom border for the table
        Border tableBorder = BorderFactory.createLineBorder(Color.BLACK);
        dataTable.setBorder(tableBorder);

        // Set custom intercell spacing for the table
        int horizontalSpacing = 20;
        int verticalSpacing = 10;
        dataTable.setRowHeight(30);
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
        setVisible(true);
    }

    // Update the table data with new data
    private void updateTableData() {
        // Add new data to the table
        ArrayList<Book> foundbooks = Book.viewBookList();
        Object[][] data = new Object[foundbooks.size()][3];
        for(int i = 0; i<foundbooks.size(); i++)
        {
        	Book b = foundbooks.get(i);
        	data[i][0] = b.getId();
        	data[i][1] = b.getBookName();
        	data[i][2] = b.getAuthor();
        }
        
        for (Object[] rowData : data) {
            tableModel.addRow(rowData);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ViewBookUI();
            }
        });
    }
}

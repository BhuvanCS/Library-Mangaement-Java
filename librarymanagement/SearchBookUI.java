import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SearchBookUI extends JFrame {
    private JTextField searchField;
    private JButton searchButton;
    private JTable dataTable;
    private DefaultTableModel tableModel;

    public SearchBookUI() {
        super("Book Search and Display");

        // Initialize components
        searchField = new JTextField(30);
        searchButton = new JButton("Search");
        dataTable = new JTable();

        // Create table model with column names and no initial data
        String[] columnNames = {"Title", "Author", "Genre"};
        tableModel = new DefaultTableModel(columnNames, 0);
        dataTable.setModel(tableModel);

        // Set custom styling for components
        Font font = new Font("Arial", Font.PLAIN, 16);
        searchField.setFont(font);
        searchButton.setFont(font);
        searchButton.setBackground(new Color(59, 89, 182));
        searchButton.setForeground(Color.WHITE);
        searchButton.setFocusPainted(false);
        searchButton.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        dataTable.getTableHeader().setFont(font.deriveFont(Font.BOLD));

        // Center align table header text
        DefaultTableCellRenderer headerRenderer = new DefaultTableCellRenderer();
        headerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        dataTable.getTableHeader().setDefaultRenderer(headerRenderer);

        // Set layout and add components to the frame
        setLayout(new BorderLayout());
        JPanel topPanel = new JPanel();
        topPanel.add(searchField);
        topPanel.add(searchButton);
        add(topPanel, BorderLayout.NORTH);
        add(new JScrollPane(dataTable), BorderLayout.CENTER);

        // Set up ActionListener for the search button
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String searchQuery = searchField.getText();
                // You can replace this fake data with your actual data retrieval logic
                Object[][] data = {
                        {"Java Programming", "John Doe", "Programming"},
                        {"The Art of War", "Sun Tzu", "Military"},
                        {"To Kill a Mockingbird", "Harper Lee", "Fiction"},
                        {"Harry Potter", "J.K. Rowling", "Fantasy"}
                };
                updateTableData(data);
            }
        });

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    // Update the table data with new data
    private void updateTableData(Object[][] data) {
        // Clear existing data
        tableModel.setRowCount(0);

        // Add new data to the table
        for (Object[] rowData : data) {
            tableModel.addRow(rowData);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new SearchBookUI();
            }
        });
    }
}

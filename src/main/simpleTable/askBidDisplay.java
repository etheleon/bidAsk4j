package simpleTable;

// Imports
import java.awt.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.*; //required for TableCellRenderer


class askBidDisplay extends JFrame
{
    private static final long serialVersionUID = 1L;
    // Instance attributes used in this example
    private	JPanel  topPanel;
    private	JTable  table;
    private	JScrollPane scrollPane;

    // Constructor of main frame
    public askBidDisplay()
    {
        // Set the frame characteristics
        setTitle( "Stocks ask bid price" );
        setSize( 300, 200 );
        setBackground( Color.gray );

        // Create a panel to hold all other components
        topPanel = new JPanel();
        topPanel.setLayout( new BorderLayout() );
        getContentPane().add( topPanel );
        Object[] columnNames = { "StockName", "Ask", "Bid"};
        Object[][] data = {
            { "abc" , new Double(850.503)  , 53 }   ,
            { "lmn" , new Double(36.23254) , 6  }   ,
            { "pqr" , new Double(8.3)      , 7  }   ,
            { "xyz" , new Double(246.0943) , 23 }
        };

        table = new JTable(data, columnNames) {
            private static final long serialVersionUID = 1L;

            @Override
            public Component prepareRenderer(TableCellRenderer renderer, int row, int col) {
                Component comp = super.prepareRenderer(renderer, row, col);
                int modelRow = convertRowIndexToModel(row);
                int modelColumn = convertColumnIndexToModel(col);
                //Object value = getModel().getValueAt(row, col);
                if (!isRowSelected(modelRow)) {
                    //if (modelColumn != 0 || modelRow != 0) {
                        comp.setBackground(table.getBackground());
                    } else {
                        comp.setBackground(Color.RED);
                        comp.setForeground(Color.BLACK);
                    }
                //}
                return comp;
            }
        };


        // Add the table to a scrolling pane
        scrollPane = new JScrollPane( table );
        topPanel.add( scrollPane, BorderLayout.CENTER );
    }

    // Main entry point for this example
    public static void main( String args[] )
    {
        // Create an instance of the test application
        askBidDisplay mainFrame	= new askBidDisplay();
        mainFrame.setVisible( true );
    }
}


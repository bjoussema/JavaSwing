import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;

public class jTableCouleurs extends DefaultTableCellRenderer {
    
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) 
    {
table.getColumnModel().getColumn(7).setCellRenderer(newjTableCouleurs()); 
super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);  
String chaine = (String) value;
    if (chaine.equals("non"))
   
        setBackground(Color.orange);
    else 
    
        setBackground(Color.white);      
    return this;
 }
    private TableCellRenderer newjTableCouleurs() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
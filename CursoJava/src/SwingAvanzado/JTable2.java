/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SwingAvanzado;

import javax.swing.*;
import javax.swing.table.*;

/**
 *
 * @author jc
 */
public class JTable2 {
    public static void main(String[] args) {
        // TODO code application logic here
        JFrame marco = new MarcoTablaPersonalizada();
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        marco.setVisible(true);
    }
}

class MarcoTablaPersonalizada extends JFrame{
    public MarcoTablaPersonalizada(){
        setTitle("Tablas");
        setBounds(350,200,300,300);
        
        TableModel mimodelo = new ModeloTablaPersonalizada();
        JTable mitabla = new JTable(mimodelo);
        add(new JScrollPane(mitabla));
    }
}

class ModeloTablaPersonalizada extends AbstractTableModel{

    @Override
    public int getRowCount() {
        return 3;
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        int z = rowIndex + 1;
        int y = columnIndex + 1;
        return " " + z + " " + y + " ";
    }
    public String getColumnName(int c){
        return "Column " + c;
    }
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SwingAvanzado;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.sql.DatabaseMetaData;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.table.*;
/**
 *
 * @author jc
 */
public class TablaMySQL {
    public static void main(String[] args) {
        // TODO code application logic here
        JFrame marco = new Marco();
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        marco.setVisible(true);
    }
}
class Marco extends JFrame{
    private JComboBox nombresCampos;
    private DatabaseMetaData datosbbdd;
    private ResultSet rs;
    private Connection miconexion;
    private Statement sentencia;
    private ResulsetModeloTabla modelo;
    
    public Marco(){
        setTitle("Tablas con mysql");
        setBounds(350,200,300,300);
        
        JPanel superior = new JPanel();
        nombresCampos = new JComboBox();
        
        try{
            miconexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","lenov35");
            datosbbdd = miconexion.getMetaData();
            rs=datosbbdd.getTables(null, null, null, null);
            while(rs.next()){
                nombresCampos.addItem(rs.getString("TABLE_NAME"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        nombresCampos.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                String tablaSeleccionada = (String) nombresCampos.getSelectedItem();
                String consulta = "SELECT * FROM " + tablaSeleccionada;
                try{
                    sentencia = miconexion.createStatement();
                    rs = sentencia.executeQuery(consulta);
                    
                    modelo = new ResulsetModeloTabla(rs);
                    JTable table = new JTable(modelo);
                    
                    add(new JScrollPane(table),BorderLayout.CENTER);
                }catch(Exception e2){
                    e2.printStackTrace();
                }
            }
        });
        superior.add(nombresCampos);
        add(superior,BorderLayout.NORTH);
    }
}

class ResulsetModeloTabla extends AbstractTableModel{
    public ResulsetModeloTabla(ResultSet unResultSet){
        rsRegistros = unResultSet;
        
        try{
            resmd = rsRegistros.getMetaData();
        }catch(Exception e3){}
    }
    @Override
    public int getRowCount() {
        try{
            rsRegistros.last();
            return rsRegistros.getRow();
        }catch(Exception e4){
            e4.printStackTrace();
            return 0;
        }
    }

    @Override
    public int getColumnCount() {
        try{
            return resmd.getColumnCount();
        }catch(Exception e4){
            e4.printStackTrace();
            return 0;
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        try{
            rsRegistros.absolute(rowIndex + 1);
            return rsRegistros.getObject(columnIndex + 1);
        }catch(Exception e4){
            e4.printStackTrace();
            return null;
        }
    }
    
    public String getColumnName(int c){
        try {
            return resmd.getColumnName(c + 1);
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
    private ResultSet rsRegistros;
    private ResultSetMetaData resmd;
}
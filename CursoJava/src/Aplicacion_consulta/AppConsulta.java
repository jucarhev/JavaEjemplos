/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aplicacion_consulta;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;

/**
 *
 * @author jc
 */
public class AppConsulta {
    public static void main(String[] args) {
        MarcoAplicacion mimarco = new MarcoAplicacion();
        mimarco.setVisible(true);
        mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

class MarcoAplicacion extends JFrame{
    public MarcoAplicacion(){
        setTitle("Consulta bbdd");
        setBounds(100,100,400,400);
        
        setLayout(new BorderLayout());
        JPanel menus = new JPanel();
        
        menus.setLayout(new FlowLayout());
        secciones = new JComboBox();
        secciones.setEditable(false);
        secciones.addItem("Todos");
        
        menus.add(secciones);
        
        paises = new JComboBox();
        paises.setEditable(false);
        paises.addItem("Todos");
        
        menus.add(paises);
        
        resultado = new JTextArea(4,50);
        resultado.setEditable(false);
        
        add(resultado);
        
        add(menus,BorderLayout.NORTH);
        add(resultado,BorderLayout.CENTER);
        
        JButton botonconsulta = new JButton("Consultar");

        botonconsulta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ejecutaConsulta();
            }
        });
        add(botonconsulta,BorderLayout.SOUTH);
        // conexion bbdd
        try{
            miconexion = DriverManager.getConnection("jdbc:mysql://localhost/test", "root","lenov35");
            Statement sentencia = miconexion.createStatement();
            String consulta = "SELECT DISTINCTROW seccion FROM productos;";
            ResultSet rs = sentencia.executeQuery(consulta);
            while (rs.next()) {
                secciones.addItem(rs.getString(1));
            }
            rs.close();

            String consulta2 = "SELECT DISTINCTROW paisdeorigen FROM productos;";
            ResultSet rs2 = sentencia.executeQuery(consulta2);
            while (rs2.next()) {
                paises.addItem(rs2.getString(1));
            }
            rs2.close();

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    private void ejecutaConsulta(){
        resultado.setText("");
        ResultSet rs = null;
        ResultSet rs2 = null;
        try{
            String seccion = (String)secciones.getSelectedItem();
            String pais = (String)paises.getSelectedItem();
            
            if(seccion.equals("Todos") && pais.equals("Todos")){
                enviaconsulta = miconexion.prepareStatement(consultatodos);
                rs = enviaconsulta.executeQuery();
            }else if(!seccion.equals("Todos") && pais.equals("Todos")){
                enviaconsultaseleccion = miconexion.prepareStatement(consultaSeleccion);
                enviaconsultaseleccion.setString(1,seccion);
                rs = enviaconsultaseleccion.executeQuery();
            }else{
                enviaconsultapais = miconexion.prepareStatement(consultapais);
                enviaconsultapais.setString(1,pais);
                rs = enviaconsultapais.executeQuery();
            }
            
            while (rs.next()) {
                resultado.append(rs.getString(1));
                resultado.append(rs.getString(2));
                resultado.append(rs.getString(3));
                resultado.append("\n");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    JComboBox secciones, paises;
    JTextArea resultado;
    private Connection miconexion;
    private PreparedStatement enviaconsultaseleccion, enviaconsultapais,enviaconsulta;
    private final String consultaSeleccion = "SELECT * FROM productos WHERE seccion = ?";
    private final String consultapais = "SELECT * FROM productos WHERE paisdeorigen = ?";
    private final String consultatodos = "SELECT * FROM productos";
}
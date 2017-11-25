/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SwingAvanzado;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author jc
 */
public class Tablas {
    public static void main(String[] args) {
        // TODO code application logic here
        JFrame marco = new MarcoTabla();
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        marco.setVisible(true);
    }
}

class MarcoTabla extends JFrame{
    private String[] nombresColumnas = {"Nombre","Radio","Lunas","gaseosos"};
    private Object [][] datosFila = {
        {"Mercurio","2440.0","0","false"},
        {"Venus","6052.0","0","false"},
        {"Tierra","6378.0","1","false"},
        {"Marte","6000.0","2","false"},
        {"Jupiter","12000","16","true"},
        {"Saturno","11000","18","true"},
        {"Urano","10000","17","true"},
        {"Neptuno","9000","8","true"},
        {"Pluton","1000","1","false"}
    };
    public MarcoTabla(){
        setTitle("Tablas");
        setBounds(350,200,300,300);
        
        
        JTable tablaPlaneta = new JTable(datosFila,nombresColumnas);
        add(new JScrollPane(tablaPlaneta), BorderLayout.CENTER);
        
        JButton botonImprimir = new JButton("Imprimir tabla");
        botonImprimir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    tablaPlaneta.print();
                }catch(Exception e2){
                    e2.printStackTrace();
                }
            }
        });
        
        JPanel laminaBoton = new JPanel();
        laminaBoton.add(botonImprimir);
        add(laminaBoton,BorderLayout.SOUTH);
    }
}
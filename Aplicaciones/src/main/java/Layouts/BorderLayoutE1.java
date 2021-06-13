/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Layouts;
import java.awt.BorderLayout;
import javax.swing.*;
/**
 *
 * @author carlos
 */
public class BorderLayoutE1 extends JFrame{
    JPanel contentPane;
    JButton n1,n2,n3,n4,n5;
    
    public static void main(String args[]){
        //Code
        BorderLayoutE1 bl = new BorderLayoutE1();
        bl.setVisible(true);
    }
    
    public BorderLayoutE1(){
        super("Ventana border layout"); 
        this.setBounds(100, 100, 300, 400);
        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout());
        
        n1 = new JButton("Boton 1");
        n2 = new JButton("Boton 2");
        n3 = new JButton("Boton 3");
        n4 = new JButton("Boton 4");
        n5 = new JButton("Boton 5");
        
        contentPane.add(n1, BorderLayout.NORTH);
        contentPane.add(n2, BorderLayout.EAST);
    }
}

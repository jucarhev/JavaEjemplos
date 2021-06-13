/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Layouts;

import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author carlos
 */
public class FlowLayoutTest extends JFrame{
    public static void main(String args[]){
        FlowLayoutTest f = new FlowLayoutTest();
        f.setVisible(true);
        f.setBounds(200,200,200,200);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public FlowLayoutTest(){
        JButton b1 = new JButton("Boton");
        add(b1);
    }
    
}

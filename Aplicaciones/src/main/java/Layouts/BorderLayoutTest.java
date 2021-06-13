/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Layouts;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author carlos
 */
public class BorderLayoutTest extends JFrame{
    public static void main(String args[]){
        BorderLayoutTest b = new BorderLayoutTest();
        b.setVisible(true);
        b.setBounds(200,200,200,200);
        b.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public BorderLayoutTest(){
        BorderLayout layout = new BorderLayout();
        setLayout(layout);
        
        JButton b1 = new JButton("Button1");
        JButton b2 = new JButton("Button2");
        JButton b3 = new JButton("Button3");
        JButton b4 = new JButton("Button4");
        JButton b5 = new JButton("Button5");
        
        add(b1, BorderLayout.NORTH);
        add(b2, BorderLayout.CENTER);
    }
}


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Layouts;

import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author carlos
 */
public class GridLayoutTest extends JFrame{
    public static void main(String args[]){
        GridLayoutTest f = new GridLayoutTest();
        f.setVisible(true);
        f.setBounds(200,200,200,200);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public GridLayoutTest(){
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2,2,8,8));
        JButton b1 = new JButton("b1");
        JButton b2 = new JButton("b2");
        JButton b3 = new JButton("b3");
        JButton b4 = new JButton("b4");
        
        panel.add(b1);
        panel.add(b2);
        panel.add(b3);
        panel.add(b4);
        
        add(panel);
        
        
    }
}

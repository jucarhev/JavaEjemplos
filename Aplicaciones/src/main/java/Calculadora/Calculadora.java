/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Calculadora;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author carlos
 */
public class Calculadora extends JFrame implements ActionListener{
    JButton b0,b1,b2,b3,b4,b5,b6,b7,b8,b9,bs, br, bm, bd ,bi, bp;
    JTextField txt;
    public static void main(String args[]){
        Calculadora cal = new Calculadora();
        cal.setVisible(true);
        cal.setBounds(200,200,250,300);
        cal.setTitle("Calculadora");
        cal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public Calculadora(){
        setLayout(new BorderLayout());
        
        JPanel gridPanel = new JPanel();
        gridPanel.setLayout(new GridLayout(4,5,0,0));
        
        b1 = new JButton("1");
        b2 = new JButton("2");
        b3 = new JButton("3");
        b4 = new JButton("4");
        b5 = new JButton("5");
        b6 = new JButton("6");
        b7 = new JButton("7");
        b8 = new JButton("8");
        b9 = new JButton("9");
        b0 = new JButton("0");
        
        bs = new JButton("+");
        br = new JButton("-");
        bm = new JButton("x");
        bd = new JButton("/");
        bi = new JButton("=");
        bp = new JButton(".");
        
        gridPanel.add(b7);
        gridPanel.add(b8);
        gridPanel.add(b9);
        gridPanel.add(br);
        
        gridPanel.add(b4);
        gridPanel.add(b5);
        gridPanel.add(b6);
        gridPanel.add(bd);
        
        gridPanel.add(b1);
        gridPanel.add(b2);
        gridPanel.add(b3);
        gridPanel.add(bm);
        
        gridPanel.add(b0);
        gridPanel.add(bi);
        gridPanel.add(bp);
        gridPanel.add(bs);
        
        txt = new JTextField(20);
        txt.setFont(new Font("Verdand",Font.PLAIN,14));
        txt.setSize(200, 24);
        txt.setHorizontalAlignment(JTextField.RIGHT);
        
        add(txt,BorderLayout.NORTH);
        add(gridPanel, BorderLayout.CENTER);
        
        b0.addActionListener(this);
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        b7.addActionListener(this);
        b8.addActionListener(this);
        b9.addActionListener(this);
        bs.addActionListener(this);
        br.addActionListener(this);
        bm.addActionListener(this);
        bd.addActionListener(this);
        bi.addActionListener(this);
        bp.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == b0){
            txt.setText(txt.getText()+"0");
        }else if(e.getSource() == b1){
            txt.setText(txt.getText()+"1");
        }else if(e.getSource() == b2){
            txt.setText(txt.getText()+"2");
        }else if(e.getSource() == b3){
            txt.setText(txt.getText()+"3");
        }else if(e.getSource() == b4){
            txt.setText(txt.getText()+"4");
        }else if(e.getSource() == b5){
            txt.setText(txt.getText()+"5");
        }else if(e.getSource() == b6){
            txt.setText(txt.getText()+"6");
        }else if(e.getSource() == b7){
            txt.setText(txt.getText()+"7");
        }else if(e.getSource() == b8){
            txt.setText(txt.getText()+"8");
        }else if(e.getSource() == b9){
            txt.setText(txt.getText()+"9");
        }
        
    }
}

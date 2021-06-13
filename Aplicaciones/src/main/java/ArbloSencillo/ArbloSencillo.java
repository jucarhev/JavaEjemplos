/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArbloSencillo;
import java.awt.*;
import javax.swing.JFrame;
import javax.swing.*;
import javax.swing.tree.*;
/**
 *
 * @author carlos
 */
public class ArbloSencillo {
    public static void main(String[] args) {
        // TODO code application logic here
        JFrame marco = new MarcoArbol();
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        marco.setVisible(true);
    }
}

class MarcoArbol extends JFrame{
    public MarcoArbol(){
       setTitle("Arbol");
       setBounds(350,200,100,100);
       
       DefaultMutableTreeNode mundo = new DefaultMutableTreeNode("Mundo");
       DefaultMutableTreeNode pais = new DefaultMutableTreeNode("Pais");
       mundo.add(pais);
       DefaultMutableTreeNode estado = new DefaultMutableTreeNode("Estado");
       pais.add(estado);
       DefaultMutableTreeNode Hidalgo = new DefaultMutableTreeNode("Hidalgo");
       estado.add(Hidalgo);
       DefaultMutableTreeNode Municipio = new DefaultMutableTreeNode("Municipio");
       Hidalgo.add(Municipio);
       DefaultMutableTreeNode Tlanchinol = new DefaultMutableTreeNode("Tlanchinol");
       Municipio.add(Tlanchinol);
       DefaultMutableTreeNode Queretaro = new DefaultMutableTreeNode("Queretaro");
       estado.add(Queretaro);
       DefaultMutableTreeNode Yucatan = new DefaultMutableTreeNode("Yucatan");
       estado.add(Yucatan);
       
       JTree arbol= new JTree(mundo);
       Container laminacontenido = getContentPane();
       laminacontenido.add(new JScrollPane(arbol));
    }
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Writer;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.text.StyledEditorKit;
/**
 *
 * @author carlos
 */
public class ProcesadorTexto {
    public static void main(String[] args) {
        // TODO code application logic here
        Menu_Procesador mimarco = new Menu_Procesador();
        mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mimarco.setVisible(true);
    }
}

class Menu_Procesador extends JFrame{
    public Menu_Procesador(){
        setBounds(100,100,300,300);
        setTitle("Procesador de textos");
        
        laminaProcesador milamina= new laminaProcesador();
        add(milamina);
        
    }   
}

class laminaProcesador extends JPanel{
    public laminaProcesador(){
        setLayout(new BorderLayout());
        JPanel laminaMenu = new JPanel();
        
        JMenuBar barraMenu = new JMenuBar();
        
        fuente = new JMenu("Fuente");
        estilo = new JMenu("Estilo");
        tamagno = new JMenu("Tamaño");
        
        Configura_Menus("Arial","Fuente","Arial",9,12,"");
        Configura_Menus("Verdana","Fuente","Verdana",9,12,"");
        Configura_Menus("Courier","Fuente","Courier",9,12,"");
        
        Configura_Menus("Negrita","Estilo","",Font.BOLD,12,"");//,"/Procesador/img/negrita"
        Configura_Menus("Cursiva","Estilo","",Font.ITALIC,12,"");//,"/Procesador/img/cursiva"
        
        Configura_Menus("12","Tamaño","",0,12,"");
        Configura_Menus("14","Tamaño","",0,14,"");
        Configura_Menus("16","Tamaño","",0,16,"");
        Configura_Menus("18","Tamaño","",0,18,"");
        Configura_Menus("20","Tamaño","",0,20,"");
        
        barraMenu.add(fuente);
        barraMenu.add(estilo);
        barraMenu.add(tamagno);
        
        laminaMenu.add(barraMenu);
        
        add(laminaMenu, BorderLayout.NORTH);
        
        
        miarea = new JTextPane();
        add(miarea, BorderLayout.CENTER);
    }
    
    public void Configura_Menus(String rotulo, String menu, String tipo_letra, int estilos, int tam,String img){
        JMenuItem elem_menu;
        if(img != ""){
            elem_menu = new JMenuItem(rotulo, new ImageIcon(getClass().getResource(img)));
        }else{
            elem_menu = new JMenuItem(rotulo);
        }
        if (menu == "Fuente") {
            fuente.add(elem_menu);
            elem_menu.addActionListener(new StyledEditorKit.FontFamilyAction("tipo letra", tipo_letra));
        }else if(menu == "Estilo"){
            estilo.add(elem_menu);
            if (estilos == 1) {
                elem_menu.addActionListener(new StyledEditorKit.BoldAction());
            }else if (estilos == 2) {
                elem_menu.addActionListener(new StyledEditorKit.ItalicAction());
            }
        }else if(menu == "Tamaño"){
            tamagno.add(elem_menu);
            elem_menu.addActionListener(new StyledEditorKit.FontSizeAction("cambio tamaño",tam));
        }
    }
    
    JTextPane miarea;
    JMenu fuente,estilo,tamagno;
    Font letras;
}
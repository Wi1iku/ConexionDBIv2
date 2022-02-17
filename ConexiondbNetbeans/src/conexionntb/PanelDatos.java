/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexionntb;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Usuario
 */
public class PanelDatos extends JPanel{
    private JLabel jLabel1=new JLabel();
    private JLabel jLabel2=new JLabel();
    private JLabel jLabel3=new JLabel();
    private JLabel jLabel4=new JLabel();
    private String dato1;
    private String dato2;
    private String dato3;
    private String dato4;
    
    public PanelDatos(String dato1,String dato2,String dato3,String dato4) {
        this.setLayout(new java.awt.GridLayout(1, 4));
        this.add(jLabel1);
        this.add(jLabel2);
        this.add(jLabel3);
        this.add(jLabel4);
        this.dato1=dato1;
        this.dato2=dato2;
        this.dato3=dato3;
        this.dato4=dato4;
        jLabel1.setText(dato1);
        jLabel2.setText(dato2);
        jLabel3.setText(dato3);
        jLabel4.setText(dato4);
    }

    public PanelDatos() {
        
    }
    
   
}

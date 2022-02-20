/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexionntb;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;

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
    String claveforanea;
    JPopupMenu menu = new JPopupMenu("Menu");
    Color defaultColor = new Color(214,217,223);
    
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
        claveforanea=dato1;
        JMenuItem delete = new JMenuItem("Borrar");
        JMenuItem modify = new JMenuItem("Modificar");
                   menu.add(delete);
                   menu.add(modify)
                           ;
                   
        JPanel jpanel1 = this;

        //this.add(menu); esto si se añade mueve el texto
        this.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseEntered(java.awt.event.MouseEvent evt) {
                MouseEntered(evt);
            }
        public void mouseExited(java.awt.event.MouseEvent evt) {
                MouseExited(evt);
            }
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            
            
                if(evt.getButton()==MouseEvent.BUTTON1) {
                  MouseClicked1st(evt);
            }
                else if(evt.getButton()==MouseEvent.BUTTON3) {
                    //JOptionPane.showMessageDialog(null,"Delete");
                      menu.show(jpanel1,evt.getX(), evt.getY());
                   
            }
            }
        });
        delete.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    PreparedStatement st;
                    String sql = "DELETE FROM productos WHERE productos.Id ="+dato1;
                    st = ConexionNTB.con.prepareStatement(sql);
                    st.execute();
                    //JOptionPane.showMessageDialog(null,"Datos borrados, pulsa el boton de actualizar");
                    actualizardatos();
                    
                } catch (SQLException ex) {
                    //Logger.getLogger(PanelDatos.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(null,"No se ha podido borrar la entrada");
                }
            }
        }   );
         modify.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    DialogoModify dialogoModify;
                    dialogoModify = new DialogoModify(new javax.swing.JDialog(), true, dato1,dato2,dato3,dato4);
                    dialogoModify.setVisible(true);
                    
                    
                } catch (Exception ex) {
                    //Logger.getLogger(PanelDatos.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(null,"Error al modificar entrada");
                }
            }
        }   );
        
    }

    public PanelDatos() {
        
    }
    private void MouseEntered(java.awt.event.MouseEvent evt) {                                     
        this.setBackground(Color.YELLOW);
    }
    private void MouseExited(java.awt.event.MouseEvent evt) {                                     
        this.setBackground(defaultColor);
    }
    private void MouseClicked1st(java.awt.event.MouseEvent evt){
        PanelBD.relacionados(claveforanea);
    }

    public String getClaveforanea() {
        return claveforanea;
    }
     void actualizardatos(){
    ArrayList<ArrayList<String>> datosmetodo = new ArrayList();
        int heightpanel=0;
        PanelMostrar.jPanel29.removeAll();
        datosmetodo=mostrardatos();
             System.out.println(datosmetodo.size()+"numero de filas1");
        for(ArrayList<String> dato:datosmetodo){
            System.out.println("test1");
        PanelMostrar.jPanel29.add(new PanelDatos(dato.get(0), dato.get(1), dato.get(2), dato.get(3)));
        
        //heightpanel+=38;
        System.out.println("test1");
        }
        PanelMostrar.jPanel29.setBounds(0, 0, 657, heightpanel);
        PanelMostrar.jPanel29.repaint();
        PanelMostrar.jPanel29.revalidate();
        System.out.println(datosmetodo.size()+"numero de filas2");
    }
     public ArrayList<ArrayList<String>> mostrardatos(){
     String sql = "SELECT * FROM productos";
        Statement st;
ArrayList<ArrayList<String>> datosmetodo = new ArrayList();
        
       for (ArrayList<String> dato : datosmetodo) {
           //datos.add(new ArrayList());
       }
       try {
           st = ConexionNTB.con.createStatement();
           ResultSet result = st.executeQuery(sql);
           int i=0;
           while (result.next()){
               datosmetodo.add(new ArrayList());
               datosmetodo.get(i).add(result.getString(1));
               datosmetodo.get(i).add(result.getString(2));
               datosmetodo.get(i).add(result.getString(3));
              datosmetodo.get(i).add(result.getString(4));
               i++;  
           }
           System.out.println("test");
       } catch (SQLException ex) {
           System.out.println("ex");
           System.out.println("error");
           
           
       }
       System.out.println(datosmetodo.get(0).get(1));
      return datosmetodo;
       
    }
    
    
   
}

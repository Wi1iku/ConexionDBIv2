/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package conexionntb;

import java.awt.Color;
import java.awt.Dialog;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JDialog;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


/**
 *
 * @author Wiku
 */
public class PanelMostrar extends javax.swing.JPanel {
//&static String claveforanea;
ArrayList<ArrayList<String>> datos = new ArrayList();
Color defaultColor = new Color(214,217,223);
    /**
     * Creates new form PanelMostrar
     */
    public PanelMostrar() {
        int heightpanel=0;
        System.out.println("test111111111111111111");
        initComponents();
        /*PanelDatos jPanelnuevo= new PanelDatos("IdProd", "Nombre", "Precio", "Categoria");
        jPanel29.add(new PanelDatos("IdProd", "Nombre", "Precio", "Categoria"));*/
        ArrayList<ArrayList<String>> datosmetodo = new ArrayList();

        datosmetodo=mostrardatos();
        
        
        for(ArrayList<String> dato:datosmetodo){
        jPanel29.add(new PanelDatos(dato.get(0), dato.get(1), dato.get(2), dato.get(3)));
        heightpanel+=38;
            //System.out.println("test22222222222");
        }
        jPanel29.setBounds(0, 0, 657, heightpanel);
        
        
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
    public void clickderecho(){
        JMenuItem delete = new JMenuItem("Eliminar");
        JMenuItem update = new JMenuItem("Modificar");
        menu.add(update);
        menu.add(delete);
        update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,"update!");
            }
        });
    }
    void actualizardatos(){
    ArrayList<ArrayList<String>> datosmetodo = new ArrayList();
        int heightpanel=0;
        jPanel29.removeAll();
        datosmetodo=mostrardatos();
             System.out.println(datosmetodo.size()+"numero de filas1");
        for(ArrayList<String> dato:datosmetodo){
            System.out.println("test1");
        jPanel29.add(new PanelDatos(dato.get(0), dato.get(1), dato.get(2), dato.get(3)), jPanel29);
        
        //heightpanel+=38;
        System.out.println("test1");
        }
        jPanel29.setBounds(0, 0, 657, heightpanel);
        jPanel29.repaint();
        jPanel29.revalidate();
        System.out.println(datosmetodo.size()+"numero de filas2");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menu = new javax.swing.JPopupMenu();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel29 = new javax.swing.JPanel();
        jToolBar1 = new javax.swing.JToolBar();
        jButton2 = new javax.swing.JButton();

        jPanel2.setBackground(new java.awt.Color(187, 187, 187));
        jPanel2.setToolTipText("");

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setPreferredSize(new java.awt.Dimension(657, 419));

        jPanel29.setLayout(new java.awt.GridLayout(0, 1));
        jScrollPane1.setViewportView(jPanel29);

        jToolBar1.setBorder(null);
        jToolBar1.setRollover(true);

        jButton2.setText("Actualizar Información");
        jButton2.setFocusable(false);
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton2);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jToolBar1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 657, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 28, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                    .addGap(0, 415, Short.MAX_VALUE)
                    .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       ArrayList<ArrayList<String>> datosmetodo = new ArrayList();
        int heightpanel=0;
        jPanel29.removeAll();
        datosmetodo=mostrardatos();
             System.out.println(datosmetodo.size()+"numero de filas1");
        for(ArrayList<String> dato:datosmetodo){
            System.out.println("test1");
        jPanel29.add(new PanelDatos(dato.get(0), dato.get(1), dato.get(2), dato.get(3)));
        
        //heightpanel+=38;
        System.out.println("test1");
        }
        jPanel29.setBounds(0, 0, 657, heightpanel);
        jPanel29.repaint();
        jPanel29.revalidate();
        System.out.println(datosmetodo.size()+"numero de filas2");
    }//GEN-LAST:event_jButton2ActionPerformed
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JPanel jPanel2;
    public static javax.swing.JPanel jPanel29;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JPopupMenu menu;
    // End of variables declaration//GEN-END:variables
}

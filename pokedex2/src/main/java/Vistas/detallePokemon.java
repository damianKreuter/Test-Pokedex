/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import Controllador.Select;
import Controllador.actualizar;
import Controllador.aniadir;
import Controllador.eliminar;
import Entidades.PokemonDeUsuario;
import Entidades.Tipo;
import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Propietario
 */
public class detallePokemon extends javax.swing.JFrame {

    /**
     * Creates new form detallePokemon
     */
    public int idPokemonDeUser;
    public PokemonsQueTiene1User vista;
    
    private int nivel;
    public detallePokemon(int idPokemon, PokemonsQueTiene1User v) throws SQLException {
        initComponents();
        this.idPokemonDeUser=idPokemon;
        this.vista=v;
        ponerDatos();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabelNombrePokemon = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListHabPokemon = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        jListTotales = new javax.swing.JList<>();
        jLabelNombrePokemon1 = new javax.swing.JLabel();
        jLabelNombrePokemon2 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabelNivel = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldCambiarNombre = new javax.swing.JTextField();
        jButton6 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("POKEMON");

        jLabelNombrePokemon.setText(" ");

        jListHabPokemon.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jListHabPokemon);

        jListTotales.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(jListTotales);

        jLabelNombrePokemon1.setText("Habilidades que existen");

        jLabelNombrePokemon2.setText("Habilidades que tiene el pokemon");

        jLabel2.setText("NIVEL");

        jLabelNivel.setText(" ");

        jButton1.setText("Subir 1 nivel");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Ver posibles evoluciones");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Volver");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("<- Agregar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Quitar ->");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel3.setText("Cambiar nombre");

        jTextFieldCambiarNombre.setText(" ");

        jButton6.setText("Cambiar nombre");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabelNombrePokemon))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabelNivel))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jButton1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton2))
                                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3)
                                    .addComponent(jTextFieldCambiarNombre))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelNombrePokemon1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabelNombrePokemon2))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(22, 22, 22))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabelNombrePokemon)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelNombrePokemon1)
                    .addComponent(jLabelNombrePokemon2))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton5)))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabelNivel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldCambiarNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addComponent(jButton3)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        
        this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
        //SUBIR 1 NIVEL
        actualizar a = new actualizar();
        int n = nivel;
        a.AumentarNivelPokemon(idPokemonDeUser, n+1);
        try {
            
            obtenerDatosPokemon();   
        } catch (SQLException ex) {
            Logger.getLogger(detallePokemon.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    //AGREGAR A LAS HABILIDADES DE POKEMON
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        aniadir act = new aniadir();
        int[] seleccionados = jListTotales.getSelectedIndices();
        int i=0;
        for(int a: seleccionados){
            i++;
            act.AniadirNuevoHabilidadAPokemon(idPokemonDeUser, a+1);
        }
        if(i>0){
            try {
            llenarListaHabilidadDePokemon();
//            initComponents();
        } catch (SQLException ex) {
            Logger.getLogger(detallePokemon.class.getName()).log(Level.SEVERE, null, ex);
        }
        } else {
            JOptionPane.showMessageDialog(null, "No se seleccionó ninguna habilidad");
        }
        
    }//GEN-LAST:event_jButton4ActionPerformed

    //QUITAR HABILIDADES
    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        eliminar e = new eliminar();
        List<String> seleccionados = jListHabPokemon.getSelectedValuesList();
        int cant= seleccionados.size();
        for(String a: seleccionados){
            e.EliminarHabilidadAPokemon(idPokemonDeUser, a);
        }
        if(cant>0){
            try {
            llenarListaHabilidadDePokemon();
//            initComponents();
        } catch (SQLException ex) {
            Logger.getLogger(detallePokemon.class.getName()).log(Level.SEVERE, null, ex);
        }
        } else {
            JOptionPane.showMessageDialog(null, "No se seleccionó ninguna habilidad");
        }
        
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        
        //PASAR A EVOLUCIONES
        try {
            evolucionesDe1Pokemon evols = new evolucionesDe1Pokemon(idPokemonDeUser, this, jLabelNombrePokemon.getText());
            evols.activar(idPokemonDeUser, this, jLabelNombrePokemon.getText());
        } catch (SQLException ex) {
            Logger.getLogger(detallePokemon.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        //CAMBIAR NOMBRE
        String nombreAPoner = jTextFieldCambiarNombre.getText();
        actualizar a = new actualizar();
        a.ActualizarNombreDePokemonDe1User(idPokemonDeUser, nombreAPoner);
        try {
            obtenerDatosPokemon();
        } catch (SQLException ex) {
            Logger.getLogger(detallePokemon.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    
    
    
    public void comenzar(int id_pokemon_de_user, PokemonsQueTiene1User vista) throws SQLException {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(detallePokemon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(detallePokemon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(detallePokemon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(detallePokemon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new detallePokemon(id_pokemon_de_user, vista).setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(detallePokemon.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        
    }
    
    private void ponerDatos() throws SQLException{
        llenarListaHabilidadesTotales();
        llenarListaHabilidadDePokemon();
        obtenerDatosPokemon();
    }
    
    private void llenarListaHabilidadesTotales() throws SQLException{
        Select s = new Select();
        ResultSet res = s.todasLasHabilidades();
        DefaultListModel model = new DefaultListModel();
        while(res.next()){
            model.addElement(new String(res.getString(2)));
        }
        s.cerrarConsulta();
        jListTotales.setModel(model);
        jListTotales.setSelectedIndex(0);
    }
    
    private void llenarListaHabilidadDePokemon() throws SQLException{
        Select s = new Select();
        ResultSet res = s.todasLasHabilidadesDe1PokemonDeUser(idPokemonDeUser);
        DefaultListModel model = new DefaultListModel();
        while(res.next()){
            model.addElement(new String(res.getString(1)));
        }
        s.cerrarConsulta();
        jListHabPokemon.setModel(model);
        jListHabPokemon.setSelectedIndex(0);
    }
    
    private void obtenerDatosPokemon() throws SQLException{
        Select s = new Select();
        ResultSet res = s.obtenerDatoDe1PokemonDe1User(this.idPokemonDeUser);
        ArrayList<PokemonDeUsuario> pokUser = new ArrayList<PokemonDeUsuario>();
        while(res.next()){
            pokUser.add(new PokemonDeUsuario(idPokemonDeUser, res.getString(1), res.getInt(2), res.getString(3)));
            jLabelNivel.setText(String.valueOf(res.getInt(2)));
            nivel = res.getInt(2);
            jLabelNombrePokemon.setText(res.getString(1));
            jTextFieldCambiarNombre.setText(res.getString(3));
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabelNivel;
    private javax.swing.JLabel jLabelNombrePokemon;
    private javax.swing.JLabel jLabelNombrePokemon1;
    private javax.swing.JLabel jLabelNombrePokemon2;
    private javax.swing.JList<String> jListHabPokemon;
    private javax.swing.JList<String> jListTotales;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextFieldCambiarNombre;
    // End of variables declaration//GEN-END:variables
}

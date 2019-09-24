/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import Controllador.Select;
import Controllador.eliminar;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import Entidades.PokemonDeUsuario;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

public class PokemonsQueTiene1User extends javax.swing.JFrame {


    private int IDUSER;
    public PokemonsQueTiene1User(int userID) throws SQLException {
        initComponents();
        crearTabla(userID, false);
        this.IDUSER= userID;
        LabelUser.setText(String.valueOf(userID));
    }

 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        LabelUser = new javax.swing.JLabel();
        jButtonAgregarPokemon = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableListaPokemonesSinDetalle = new javax.swing.JTable();
        jButtonVolver = new javax.swing.JButton();
        jButtonQuitarPokemon = new javax.swing.JButton();
        jButtonVerDetalles = new javax.swing.JButton();
        jTextoIngresoDeID = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("USUARIO");

        LabelUser.setText("user");

        jButtonAgregarPokemon.setText("Agregar Pokemon");
        jButtonAgregarPokemon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAgregarPokemonActionPerformed(evt);
            }
        });

        jTableListaPokemonesSinDetalle.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
            },
            new String [] {
                "ID Registro", "Pokemon", "Nombre"
            }
        ));
        jScrollPane1.setViewportView(jTableListaPokemonesSinDetalle);

        jButtonVolver.setText("Volver");
        jButtonVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVolverActionPerformed(evt);
            }
        });

        jButtonQuitarPokemon.setText("Quitar pokemon seleccionado");
        jButtonQuitarPokemon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonQuitarPokemonActionPerformed(evt);
            }
        });

        jButtonVerDetalles.setText("Ver detalles de pokemon seleccionado");
        jButtonVerDetalles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVerDetallesActionPerformed(evt);
            }
        });

        jLabel2.setText("Los siguientes campos deben ser únicamente numéricos y deben ser los IDs de los pokemones");

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
                            .addComponent(LabelUser))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 596, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButtonVolver)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButtonVerDetalles)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButtonQuitarPokemon)
                                        .addGap(18, 18, 18)
                                        .addComponent(jButtonAgregarPokemon))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(21, 21, 21)
                                        .addComponent(jTextoIngresoDeID, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE)))))
                        .addGap(17, 17, 17))))
            .addGroup(layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(jLabel2)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LabelUser)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addComponent(jTextoIngresoDeID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAgregarPokemon)
                    .addComponent(jButtonVolver)
                    .addComponent(jButtonQuitarPokemon)
                    .addComponent(jButtonVerDetalles))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVolverActionPerformed
        // TODO add your handling code here:
      this.dispose();
    }//GEN-LAST:event_jButtonVolverActionPerformed

    
    
    private void jButtonAgregarPokemonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAgregarPokemonActionPerformed
        // TODO add your handling code here:
        try {
            AniadirPokemon aniadir = new AniadirPokemon(IDUSER, this);
            aniadir.comenzar(this,IDUSER);
        } catch (SQLException ex) {
            Logger.getLogger(PokemonsQueTiene1User.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonAgregarPokemonActionPerformed

    
    private void jButtonVerDetallesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVerDetallesActionPerformed
        // TODO add your handling code here:
        
        //VER DETALLE DE 1 POKEMON DE ALGUN USER
        int numeroID = Integer.parseInt(jTextoIngresoDeID.getText());
        try {
            detallePokemon det = new detallePokemon(numeroID, this);
            System.out.println("ID REGISTRO SELECCIONADO: "+ String.valueOf(numeroID));
            det.comenzar(numeroID, this);
        } catch (SQLException ex) {
            Logger.getLogger(PokemonsQueTiene1User.class.getName()).log(Level.SEVERE, null, ex);
        }
               
    }//GEN-LAST:event_jButtonVerDetallesActionPerformed

    private void jButtonQuitarPokemonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonQuitarPokemonActionPerformed
        // TODO add your handling code here:
        try {
            int numeroID = Integer.parseInt(jTextoIngresoDeID.getText());
            eliminar e = new eliminar();
            e.EliminarPokemonDeUsuario(numeroID);
            Select s = new Select();
            llenarTabla(IDUSER, s, true);
            s.cerrarConsulta();
            recargar(IDUSER);
        } catch (SQLException ex) {
            Logger.getLogger(PokemonsQueTiene1User.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonQuitarPokemonActionPerformed

    public void recargar(int idUsuario) throws SQLException{
        this.IDUSER = idUsuario;
        LabelUser.setText(String.valueOf(idUsuario));
        crearTabla(idUsuario, true);
        initComponents();
        
    }
    
    public void activar() throws SQLException {
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
            java.util.logging.Logger.getLogger(PokemonsQueTiene1User.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PokemonsQueTiene1User.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PokemonsQueTiene1User.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PokemonsQueTiene1User.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new PokemonsQueTiene1User(IDUSER).setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(PokemonsQueTiene1User.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
    }
    
    private void crearTabla(int idUser, boolean recarga) throws SQLException{
        IDUSER = idUser;
        Select s = new Select();
        llenarTabla(idUser, s, recarga);
        s.cerrarConsulta();
    }
    
    private void llenarTabla(int idUser, Select s, boolean recarga) throws SQLException{
        ResultSet res = s.todosLosPokemonesDe1User(idUser);
        ArrayList<PokemonDeUsuario> lista = new ArrayList<PokemonDeUsuario>();
        
        while(res.next()){
            lista.add(new PokemonDeUsuario(res.getInt(1), res.getString(2), res.getInt(3)));
            System.out.println("NRO: "+String.valueOf(res.getInt(1))+
                    ", Nombre: "+ res.getString(2)+", NIVEL: "+String.valueOf(res.getInt(3)));
        }
        DefaultTableModel model;
        if(recarga){
            model = new javax.swing.table.DefaultTableModel(
                                            new Object [][] {},  
                        new String [] {"ID Registro", "Pokemon", "Nombre"});
            
        } else {
            model =  (DefaultTableModel)jTableListaPokemonesSinDetalle.getModel();
        }
        
        Object[] row = new Object[3];
        for(PokemonDeUsuario a: lista){
            row[0]=a.getIdUser();
            row[1]=a.getPokemon();
            row[2]=a.getNivel();
            model.addRow(row);
        }
        if(recarga){
            jTableListaPokemonesSinDetalle.setModel(model);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LabelUser;
    private javax.swing.JButton jButtonAgregarPokemon;
    private javax.swing.JButton jButtonQuitarPokemon;
    private javax.swing.JButton jButtonVerDetalles;
    private javax.swing.JButton jButtonVolver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableListaPokemonesSinDetalle;
    private javax.swing.JTextField jTextoIngresoDeID;
    // End of variables declaration//GEN-END:variables
}

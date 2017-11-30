/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frames;

import Clases.Conexion;
import java.awt.Color;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author juan carlos
 */
public class MantenedorModificar extends javax.swing.JInternalFrame {

    Conexion con = new Conexion();
    Connection cn = con.Conexion();
    Statement stmt = null;
    String titulos[] = {"id", "codigo", "nombre", "usuario", "contraseña", "privilegio", "cargo"};
    String filas[] = new String[7];
    DefaultTableModel modelo;
       
    /**
     * Metodo para actualizar en la base de datos 
     */
    public void Modificar(){

        try {
            stmt = cn.createStatement();         
            ResultSet rs = stmt.executeQuery("SELECT * FROM usuarios ORDER BY id ASC");
            modelo = new DefaultTableModel(null, titulos);
            
            while(rs.next()){
                
                filas[0] = rs.getString("id");
                filas[1] = rs.getString("codigo");
                filas[2] = rs.getString("usuario");
                filas[3] = rs.getString("nombre");
                filas[4] = rs.getString("contraseña");
                filas[5] = rs.getString("cargo");
                filas[6] = rs.getString("privilegio");
                 
                modelo.addRow(filas);                
                }
            
            tablaUsuarios.setModel(modelo);
            
        } catch (SQLException ex) {            
            Logger.getLogger(MantenedorModificar.class.getName()).log(Level.SEVERE, null, ex);            
        }
                
    }
    /**
     * Metodo para llenar las casillas de el frame donde se modificaran
     */
    public void envioFicha (){
    
        MantenedorModificado obj = new MantenedorModificado();
        obj.setVisible(true);        
        
        int fila = tablaUsuarios.getSelectedRow();
        
        MantenedorModificado.txtId.setText(tablaUsuarios.getValueAt(fila, 0).toString());
        MantenedorModificado.txtCodigo.setText(tablaUsuarios.getValueAt(fila, 1).toString());
        MantenedorModificado.txtNombre.setText(tablaUsuarios.getValueAt(fila, 2).toString());
        MantenedorModificado.txtUsuario.setText(tablaUsuarios.getValueAt(fila, 3).toString());
        MantenedorModificado.txtContraseña.setText(tablaUsuarios.getValueAt(fila, 4).toString());
        MantenedorModificado.txtCargo.setText(tablaUsuarios.getValueAt(fila, 5).toString());
        MantenedorModificado.txtPrivilegio.setText(tablaUsuarios.getValueAt(fila, 6).toString());
        
    }
    
    public MantenedorModificar(){
        initComponents();     
        this.getContentPane().setBackground(Color.WHITE);
        setTitle("Modificación de mantenedores.");
        Modificar();
           
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tablaUsuarios = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtBusqueda = new javax.swing.JTextField();
        comboTipo = new javax.swing.JComboBox<>();
        botonBuscar = new javax.swing.JButton();
        botonModificar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setResizable(true);
        try {
            setSelected(true);
        } catch (java.beans.PropertyVetoException e1) {
            e1.printStackTrace();
        }

        tablaUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tablaUsuarios);

        jLabel1.setText("Criterio de busqueda");

        txtBusqueda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBusquedaActionPerformed(evt);
            }
        });

        comboTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Administrador", "Gerente", "Bodeguero", "Vendedor" }));
        comboTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboTipoActionPerformed(evt);
            }
        });

        botonBuscar.setText("Buscar");
        botonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBuscarActionPerformed(evt);
            }
        });

        botonModificar.setText("Modificar");
        botonModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonModificarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(txtBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 377, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(comboTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(66, 66, 66))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(botonBuscar)
                        .addGap(319, 319, 319))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(botonModificar)
                        .addGap(314, 314, 314))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addComponent(botonBuscar)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 94, Short.MAX_VALUE)
                .addComponent(botonModificar)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtBusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBusquedaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBusquedaActionPerformed

    private void botonModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonModificarActionPerformed
    
        envioFicha();
             
    }//GEN-LAST:event_botonModificarActionPerformed

    private void botonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBuscarActionPerformed
        
       
    }//GEN-LAST:event_botonBuscarActionPerformed

    private void comboTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboTipoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboTipoActionPerformed
        
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton botonBuscar;
    public static javax.swing.JButton botonModificar;
    public static javax.swing.JComboBox<String> comboTipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable tablaUsuarios;
    public static javax.swing.JTextField txtBusqueda;
    // End of variables declaration//GEN-END:variables

    
    }

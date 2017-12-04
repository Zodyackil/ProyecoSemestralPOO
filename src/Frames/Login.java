/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frames;

import Clases.Buscar;
import Clases.Conexion;
import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 *
 * @author juan carlos
 */
public class Login extends javax.swing.JFrame {

   
    public Login() {
        initComponents();
        this.getContentPane().setBackground(Color.WHITE);
        cerrar();
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("Login");
        
    }
    

        Conexion cc = new Conexion();
        Connection cn = cc.Conexion();
        
        
       
        /** 
         * Metodo para luego llamarlo y acceder a la BD, redirijiendo a las ventanas
         * correspondientes al usuario.
         */
        
        void acceder (String usuario, String password){
        
        String sql = "SELECT * FROM usuarios WHERE usuario = '"+usuario+"' and contraseña = '"+password+"'";
        String cap = "";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while (rs.next()){
                cap = rs.getString("cargo");
            }
            if (cap.equals("Administrador")){
                VentanaPrincipal obj = new VentanaPrincipal();
                obj.setVisible(true);
                dispose();
            }
            
            if (!cap.equals("Administrador")){
                JOptionPane.showMessageDialog(null, "El usuario no existe");
            }
            
        } catch (SQLException ex) {
            
        }
    }
        
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Nombre = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        botonIngresar = new javax.swing.JButton();
        txtusuario = new javax.swing.JTextField();
        txtpass = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Nombre.setText("Usuario");

        jLabel2.setText("Contraseña");

        botonIngresar.setText("Ingresar");
        botonIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonIngresarActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/key.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(Nombre))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtusuario)
                            .addComponent(txtpass, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addComponent(botonIngresar)))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtusuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Nombre))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtpass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(botonIngresar)))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonIngresarActionPerformed
    
        /**
         * Asigno a un String los valores de usuario y contraseña
         * Y luego los obtengo de lo ingresado en las casillas.
         */
        String usu, pass ;
        usu = txtusuario.getText();
        pass = txtpass.getText();
              
        acceder(usu, pass);
        
        
        
    }//GEN-LAST:event_botonIngresarActionPerformed

  
    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }
     public void cerrar(){
        try{
            this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
            addWindowListener(new WindowAdapter(){
                
                public void windowClosing(WindowEvent e){
                    confimarSalida();
                    }
                });
            this.setVisible(true);
            } catch (Exception e){
            e.printStackTrace();
        }
    }
    public void confimarSalida(){
        int valor = JOptionPane.showConfirmDialog(this,"¿Esta seguro que desea salir?", "Advertencia", JOptionPane.YES_NO_OPTION);
        if (valor == JOptionPane.YES_OPTION){
            
            System.exit(0);
            
            }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Nombre;
    public static javax.swing.JButton botonIngresar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPasswordField txtpass;
    private javax.swing.JTextField txtusuario;
    // End of variables declaration//GEN-END:variables
}

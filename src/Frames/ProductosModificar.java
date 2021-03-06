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
import javax.swing.table.TableColumnModel;

/**
 *
 * @author juan carlos
 */
public class ProductosModificar extends javax.swing.JInternalFrame {

    /**
     * Creates new form ProductosModificar
     */
    Conexion con = new Conexion();
    Connection cn = con.Conexion();
    Statement stmt = null;
    String titulos[] = {"ID", "Código", "Nombre", "Modelo", "Alto", "Largo", "Ancho", "Compra", "Venta", "Tipo", "Stock", "EAN", "Bodega"};
    String filas[] = new String[13];
    DefaultTableModel modelo;

    public ProductosModificar() {
        initComponents();
        this.getContentPane().setBackground(Color.WHITE);
        Modificar();
        setTitle("Modificación de productos.");

    }

    public void Modificar() {

        try {
            stmt = cn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM productos ORDER BY id ASC");
            modelo = new DefaultTableModel(null, titulos);

            while (rs.next()) {

                filas[0] = rs.getString("id");
                filas[1] = rs.getString("codigo");
                filas[2] = rs.getString("nombre");
                filas[3] = rs.getString("modelo");
                filas[4] = rs.getString("dimensiones_alto");
                filas[5] = rs.getString("dimensiones_largo");
                filas[6] = rs.getString("dimensiones_ancho");
                filas[7] = rs.getString("pre_compra");
                filas[8] = rs.getString("pre_venta");
                filas[9] = rs.getString("tipo");
                filas[10] = rs.getString("cantidad");
                filas[11] = rs.getString("ean");
                filas[12] = rs.getString("bodega");

                modelo.addRow(filas);
                /**TableColumnModel columnModel = tablaProductos.getColumnModel();
                columnModel.getColumn(1).setPreferredWidth(15);*/
            }

            tablaProductos.setModel(modelo);

        } catch (SQLException ex) {
            Logger.getLogger(MantenedorModificar.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void envioFicha() {

        ProductoModificado obj = new ProductoModificado();
        obj.setVisible(true);

        int fila = tablaProductos.getSelectedRow();

        ProductoModificado.txtId.setText(tablaProductos.getValueAt(fila, 0).toString());
        ProductoModificado.txtCodigo.setText(tablaProductos.getValueAt(fila, 1).toString());
        ProductoModificado.txtNombre.setText(tablaProductos.getValueAt(fila, 2).toString());
        ProductoModificado.txtModelo.setText(tablaProductos.getValueAt(fila, 3).toString());
        ProductoModificado.txtAlto.setText(tablaProductos.getValueAt(fila, 4).toString());
        ProductoModificado.txtLargo.setText(tablaProductos.getValueAt(fila, 5).toString());
        ProductoModificado.txtAncho.setText(tablaProductos.getValueAt(fila, 6).toString());
        ProductoModificado.comboVenta.setSelectedItem(tablaProductos.getValueAt(fila, 8).toString());
        ProductoModificado.comboTipo.setSelectedItem(tablaProductos.getValueAt(fila, 9).toString());
        ProductoModificado.txtCantidad.setText(tablaProductos.getValueAt(fila, 10).toString());
        ProductoModificado.txtEan.setText(tablaProductos.getValueAt(fila, 11).toString());
        ProductoModificado.txtBodega.setText(tablaProductos.getValueAt(fila, 12).toString());

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtBusqueda = new javax.swing.JTextField();
        botonBuscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaProductos = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);

        jLabel1.setText("Criterio de búsqueda");

        botonBuscar.setText("Buscar");

        tablaProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Codigo", "Nombre", "Title 4", "null", "null", "Title 7", "Title 8", "Title 9", "Title 10", "Title 11", "Title 12", "Title 13"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, true, true, true, true, true, true, true, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaProductos.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jScrollPane1.setViewportView(tablaProductos);
        if (tablaProductos.getColumnModel().getColumnCount() > 0) {
            tablaProductos.getColumnModel().getColumn(0).setResizable(false);
            tablaProductos.getColumnModel().getColumn(0).setPreferredWidth(33);
        }

        jButton1.setText("Modificar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setText("Seleccione un producto de la tabla para modificar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(368, 368, 368)
                                .addComponent(jButton1))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addGap(36, 36, 36)
                                        .addComponent(txtBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(botonBuscar)))))
                        .addGap(0, 304, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonBuscar))
                .addGap(35, 35, 35)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.setVisible(false);
        envioFicha();

    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonBuscar;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaProductos;
    private javax.swing.JTextField txtBusqueda;
    // End of variables declaration//GEN-END:variables
}

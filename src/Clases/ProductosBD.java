/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import Frames.MantenedorIngreso;
import Frames.ProductoModificado;
import Frames.ProductosIngreso;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author juan carlos
 */
public class ProductosBD {

    Conexion con = new Conexion();
    Connection cn = con.Conexion();

    public void Ingreso() {

        try {

            String Compra = ProductosIngreso.txtCompra.getText();
            String Venta = (String) ProductosIngreso.comboPorcentaje.getSelectedItem();
            double CompraInt = Integer.parseInt(Compra);
            double VentaInt = Integer.parseInt(Venta);
            double VentaInt2 = (VentaInt) / (100);
            double VentaBD = CompraInt + ((CompraInt) * (VentaInt2));

            PreparedStatement ps = cn.prepareStatement("INSERT INTO productos (codigo, nombre, modelo, dimensiones_alto, dimensiones_largo, dimensiones_ancho, pre_compra, pre_venta, tipo, cantidad, ean, bodega) VALUES  (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            ps.setString(1, ProductosIngreso.txtCodigo.getText());
            ps.setString(2, ProductosIngreso.txtNombre.getText());
            ps.setString(3, ProductosIngreso.txtModelo.getText());
            ps.setString(4, ProductosIngreso.txtAlto.getText());
            ps.setString(5, ProductosIngreso.txtLargo.getText());
            ps.setString(6, ProductosIngreso.txtAncho.getText());
            ps.setDouble(7, CompraInt);
            ps.setDouble(8, VentaBD);
            ps.setString(9, (String) ProductosIngreso.comboTipo.getSelectedItem());
            ps.setString(10, ProductosIngreso.txtCantidad.getText());
            ps.setString(11, ProductosIngreso.txtEan.getText());
            ps.setString(12, (String) ProductosIngreso.comboBodega.getSelectedItem());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Producto ingresado.");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al registrar el producto.");

            Logger.getLogger(ProductosIngreso.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                cn.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error al cerrar la conexion.");
                Logger.getLogger(ProductosIngreso.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public void actualizacion() {
        String id = ProductoModificado.txtId.getText();
        try {
            PreparedStatement stmtCodigo = cn.prepareStatement("UPDATE productos SET codigo = '" + ProductoModificado.txtCodigo.getText() + "' WHERE id = '" + id + "'");
            PreparedStatement stmtNombre = cn.prepareStatement("UPDATE productos SET nombre = '" + ProductoModificado.txtNombre.getText() + "' WHERE id = '" + id + "'");
            PreparedStatement stmtModelo = cn.prepareStatement("UPDATE productos SET modelo = '" + ProductoModificado.txtModelo.getText() + "' WHERE id = '" + id + "'");
            PreparedStatement stmtAlto = cn.prepareStatement("UPDATE productos SET dimensiones_alto = '" + ProductoModificado.txtAlto.getText() + "' WHERE id = '" + id + "'");
            PreparedStatement stmtLargo = cn.prepareStatement("UPDATE productos SET dimensiones_largo = '" + ProductoModificado.txtLargo.getText() + "' WHERE id = '" + id + "'");
            PreparedStatement stmtAncho = cn.prepareStatement("UPDATE productos SET dimensiones_ancho = '" + ProductoModificado.txtAncho.getText() + "' WHERE id = '" + id + "'");
            PreparedStatement stmtPreCompra = cn.prepareStatement("UPDATE productos SET pre_compra = '" + ProductoModificado.txtCompra.getText() + "' WHERE id = '" + id + "'");
            PreparedStatement stmtPreVenta = cn.prepareStatement("UPDATE productos SET pre_venta = '" + ProductoModificado.txtVenta.getText() + "' WHERE id = '" + id + "'");
            PreparedStatement stmtTipo = cn.prepareStatement("UPDATE productos SET tipo = '" + ProductoModificado.txtTipo.getText() + "' WHERE id = '" + id + "'");
            PreparedStatement stmtCantidad = cn.prepareStatement("UPDATE productos SET cantidad = '" + ProductoModificado.txtCantidad.getText() + "' WHERE id = '" + id + "'");
            PreparedStatement stmtEan = cn.prepareStatement("UPDATE productos SET ean = '" + ProductoModificado.txtEan.getText() + "' WHERE id = '" + id + "'");
            PreparedStatement stmtBodega = cn.prepareStatement("UPDATE productos SET bodega = '" + ProductoModificado.txtBodega.getText() + "' WHERE id = '" + id + "'");

            stmtCodigo.executeUpdate();
            stmtNombre.executeUpdate();
            stmtModelo.executeUpdate();
            stmtAlto.executeUpdate();
            stmtLargo.executeUpdate();
            stmtAncho.executeUpdate();
            stmtPreCompra.executeUpdate();
            stmtPreVenta.executeUpdate();
            stmtTipo.executeUpdate();
            stmtCantidad.executeUpdate();
            stmtEan.executeUpdate();
            stmtBodega.executeUpdate();

            JOptionPane.showMessageDialog(null, "Producto actualizado.");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al actualizar el producto.");

            Logger.getLogger(MantenedorIngreso.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                cn.close();

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error al cerrar la conexion.");
                Logger.getLogger(MantenedorIngreso.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}

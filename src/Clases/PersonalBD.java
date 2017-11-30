package Clases;

import Frames.MantenedorIngreso;
import Frames.MantenedorModificado;
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
public class PersonalBD extends Conexion {

    /**
     * Aqui creamos un metodo para actualizar el personal, el cual llamaremos
     * luego en el frame que utilizaremos.
     */
    Conexion con = new Conexion();
    Connection cn = con.Conexion();

    public void actualizacion() {

        Conexion con = new Conexion();
        Connection cn = con.Conexion();
        String id = MantenedorModificado.txtId.getText();

        try {
            PreparedStatement stmtCodigo = cn.prepareStatement("UPDATE usuarios SET codigo = '" + MantenedorModificado.txtCodigo.getText() + "' WHERE id = '" + id + "'");
            PreparedStatement stmtNombre = cn.prepareStatement("UPDATE usuarios SET nombre = '" + MantenedorModificado.txtNombre.getText() + "' WHERE id = '" + id + "'");
            PreparedStatement stmtUsuario = cn.prepareStatement("UPDATE usuarios SET usuario = '" + MantenedorModificado.txtUsuario.getText() + "' WHERE id = '" + id + "'");
            PreparedStatement stmtContraseña = cn.prepareStatement("UPDATE usuarios SET contraseña = '" + MantenedorModificado.txtContraseña.getText() + "' WHERE id = '" + id + "'");
            PreparedStatement stmtPrivilegio = cn.prepareStatement("UPDATE usuarios SET privilegio = '" + MantenedorModificado.txtPrivilegio.getText() + "' WHERE id = '" + id + "'");
            PreparedStatement stmtCargo = cn.prepareStatement("UPDATE usuarios SET cargo = '" + MantenedorModificado.txtCargo.getText() + "' WHERE id = '" + id + "'");

            stmtCodigo.executeUpdate();
            stmtNombre.executeUpdate();
            stmtUsuario.executeUpdate();
            stmtContraseña.executeUpdate();
            stmtPrivilegio.executeUpdate();
            stmtCargo.executeUpdate();

            JOptionPane.showMessageDialog(null, "Usuario actualizado.");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al actualizar al usuario.");

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

    public void ingreso() {

        Conexion con = new Conexion();
        Connection cn = con.Conexion();

        try {
            PreparedStatement ps = cn.prepareStatement("INSERT INTO usuarios (codigo, nombre, usuario, contraseña, privilegio, cargo) VALUES  (?, ?, ?, ?, ?, ?)");
            ps.setString(1, MantenedorIngreso.txtCodigo.getText());
            ps.setString(2, MantenedorIngreso.txtNombre.getText());
            ps.setString(3, MantenedorIngreso.txtUsuario.getText());
            ps.setString(4, MantenedorIngreso.txtContraseña.getText());
            ps.setString(5, (String) MantenedorIngreso.comboPrivilegio.getSelectedItem());
            ps.setString(6, (String) MantenedorIngreso.comboCargo.getSelectedItem());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Usuario ingresado.");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al registrar al usuario.");
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

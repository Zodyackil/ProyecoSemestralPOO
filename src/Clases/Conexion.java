/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;
import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 * Conexion a la BD
 * @author juan carlos
 */
public class Conexion {
    
    java.sql.Connection conn = null;
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String USER = "root";
    private static final String PASSWORD = "root";
    private static final String URL = "jdbc:mysql://localhost:3306/inventarios";
                    
            
    
    public java.sql.Connection Conexion(){
        
    
        
        try {
            Class.forName(DRIVER);
            conn = (java.sql.Connection)DriverManager.getConnection(URL, USER, PASSWORD);
            
            
            
        }catch  (ClassNotFoundException | SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error al conectar con la base de datos", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
       
        return conn;
    }
    
  

}
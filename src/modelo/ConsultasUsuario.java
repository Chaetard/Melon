/*
 Clase para las consultas
 */
package modelo;

import conexion.Conexion;

import java.sql.Connection;
import java.sql.PreparedStatement; 
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
 
/**
 *
 * @author Jesus Santos 221341606
 */
public class ConsultasUsuario extends Conexion{
    Connection Con = getConexion();
    
    public boolean buscarLogin(ModeloUsuario Modelo){
       
        try{
            PreparedStatement Ps;
            String SQL = "select * from empleados where usuario = ? and password = ?";
            Ps = Con.prepareCall(SQL);
            Ps.setString(1, Modelo.getUsuario());
            Ps.setString(2, Modelo.getPassword());
           ResultSet Rs = Ps.executeQuery();
            if (Rs.next()) {
                Modelo.setNombre(Rs.getString("nombre"));
                Modelo.setTipo(Rs.getString("cargo"));
                return true;
            }
            return false;
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null,"Error: " +  e);
            return false;
        }
        
        
    }
}

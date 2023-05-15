/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import conexion.Conexion;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Jesus Santos 221341606
 */
public class ConsultaUsuarioConf extends Conexion {

    Connection Con = getConexion();

    public boolean insertar(ModeloUsuarioConf Modelo) {
        try {
            PreparedStatement Ps;
            String SQL = "insert into empleados (id_empleados,nombre,usuario,password,cargo) values(?,?,?,?,?)";
            Ps = Con.prepareCall(SQL);
            Ps.setInt(1, Modelo.getId());
            Ps.setString(2, Modelo.getNombre());

            Ps.setString(3, Modelo.getUsuario());
            Ps.setString(4, Modelo.getPassword());

            Ps.setString(5, Modelo.getTipo());

            Ps.execute();
            return true;
        } catch (SQLException e) {
            
            return false;
        }
    }

    public boolean modificar(ModeloUsuarioConf Modelo) {
        try {
            PreparedStatement Ps;
            String SQL = "update empleados set id_empleados = ?, nombre = ?, usuario=?,password = ?, cargo = ? where id_empleados = ?";
            Ps = Con.prepareCall(SQL);
            
            Ps.setInt(1, Modelo.getId());
            Ps.setString(2, Modelo.getNombre());

            Ps.setString(3, Modelo.getUsuario());
            Ps.setString(4, Modelo.getPassword());

            Ps.setString(5, Modelo.getTipo());
            Ps.setInt(6, Modelo.getId());

            Ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al Modificar : " + e);
            return false;
        }
    }
    public boolean eliminar(ModeloUsuarioConf Modelo) {
        try {
            PreparedStatement Ps;
            String SQL = "delete from empleados where id_empleados = ?";
            Ps = Con.prepareCall(SQL);
            Ps.setInt(1, Modelo.getId());
            Ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al Modificar : " + e);
            return false;
        }
    }
    public boolean buscar(ModeloUsuarioConf Modelo) {
        try {
            PreparedStatement Ps;
            String SQL = "select * from empleados where id_empleados = ?";
            Ps = Con.prepareCall(SQL);
            Ps.setInt(1, Modelo.getId());
            ResultSet Rs = Ps.executeQuery();

            if (Rs.next()) {
                Modelo.setId(Rs.getInt("id_empleados"));
                Modelo.setNombre(Rs.getString("nombre"));
                Modelo.setPassword(Rs.getString("password"));
                Modelo.setTipo(Rs.getString("cargo"));
                Modelo.setUsuario(Rs.getString("usuario"));
                

                return true;

            }
            return false;
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Error al Buscar: " + e);
            return false;
        }
    }
}

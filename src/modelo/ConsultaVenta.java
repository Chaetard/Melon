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
public class ConsultaVenta extends Conexion {

    Connection Con = getConexion();

    public boolean insertar(ModeloVenta Modelo) {
        try {
            PreparedStatement Ps;
            String SQL = "insert into venta (id_venta,id_cliente,estado,descuento,metodo_pago,total,id_empleado) values(?,?,?,?,?,?,?)";
            Ps = Con.prepareCall(SQL);
            Ps.setInt(1, Modelo.getid_Venta());
            Ps.setInt(2, Modelo.getId_cliente());

            Ps.setString(3, Modelo.getEstado());
            Ps.setDouble(4, Modelo.getDescuento());

            Ps.setString(5, Modelo.getMetodo_pago());
            Ps.setDouble(6, Modelo.getTotal());

            Ps.setInt(7, Modelo.getId_empleado());
            Ps.execute();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al insertar : " + e);
            return false;
        }
    }

    public boolean modificar(ModeloVenta Modelo) {
        try {
            PreparedStatement Ps;
            String SQL = "update venta set estado=?, id_cliente=?, metodo_pago=?, total=? where id_venta = ?";
            Ps = Con.prepareCall(SQL);
            Ps.setString(1, Modelo.getEstado());
            Ps.setInt(2, Modelo.getId_cliente());
            Ps.setString(3, Modelo.getMetodo_pago());
            Ps.setDouble(4, Modelo.getTotal());
            Ps.setInt(5, Modelo.getid_Venta());

            Ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al Modificar : " + e);
            return false;
        }
    }

    public boolean eliminar(ModeloVenta Modelo) {
        try {
            PreparedStatement Ps;
            String SQL = "delete from venta where id_venta = ?";
            Ps = Con.prepareCall(SQL);
            Ps.setInt(1, Modelo.getid_Venta());
            Ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al Modificar : " + e);
            return false;
        }
    }

    public boolean buscar(ModeloVenta Modelo) {
        try {
            PreparedStatement Ps;
            String SQL = "select * from venta where id_venta = ?";
            Ps = Con.prepareCall(SQL);
            Ps.setInt(1, Modelo.getid_Venta());
            ResultSet Rs = Ps.executeQuery();

            if (Rs.next()) {
                Modelo.setId_cliente(Rs.getInt("id_cliente"));
                Modelo.setEstado(Rs.getString("estado"));
                Modelo.setDescuento(Rs.getFloat("descuento"));
                Modelo.setMetodo_pago(Rs.getString("metodo_pago"));
                Modelo.setTotal(Rs.getFloat("total"));
                Modelo.setId_empleado(Rs.getInt("id_empleado"));

                return true;

            }
            return false;
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Error al Buscar: " + e);
            return false;
        }
    }
}

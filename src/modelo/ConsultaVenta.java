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
}

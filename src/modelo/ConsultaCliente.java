/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import vista.VistaClientes;

/**
 *
 * @author Victor Manuel Beas Aguilar
 */
public class ConsultaCliente extends Conexion {

    Connection Con = getConexion();
    VistaClientes vistaClientes;

    public boolean insertar(ModeloCliente Modelo) {
        try {
            PreparedStatement Ps;
            String SQL = "insert into cliente (id_cliente,Nombre,Direccion,Correo_e,Rfc,Telefono) values(?,?,?,?,?,?)";
            Ps = Con.prepareCall(SQL);
            Ps.setInt(1, Modelo.getid_Cliente());
            Ps.setString(2, Modelo.getNombre());

            Ps.setString(3, Modelo.getDireccion());
            Ps.setString(4, Modelo.getCorreo_e());
            Ps.setString(5, Modelo.getRfc());
            Ps.setString(6, Modelo.getTelefono());

            Ps.execute();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al insertar : " + e);
            return false;
        }
    }

    public boolean modificar(ModeloCliente Modelo) {
        try {
            PreparedStatement Ps;
            String SQL = "update cliente set Nombre=?,Direccion=?,Correo_e=?,rfc=?,Telefono=? where id_cliente=?";
            Ps = Con.prepareCall(SQL);

            Ps.setString(1, Modelo.getNombre());

            Ps.setString(2, Modelo.getDireccion());
            Ps.setString(3, Modelo.getCorreo_e());
            Ps.setString(4, Modelo.getRfc());
            Ps.setString(5, Modelo.getTelefono());
            Ps.setInt(6, Modelo.getid_Cliente());

            Ps.execute();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(vistaClientes, "Error SQL Modificar()\n " + e);
            return false;
        }
    }

    public boolean eliminar(ModeloCliente Modelo) {
        try {
            PreparedStatement ps;
            String SQL = "Delete  from cliente  where id_cliente=?";
            ps = Con.prepareCall(SQL);
            ps.setInt(1, Modelo.getid_Cliente());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error  SQL: eliminar()\n " + e);
            return false;
        }
    }

    public boolean buscar(ModeloCliente Modelo) {
        try {
            PreparedStatement ps;
            String SQL = "SELECT * FROM cliente where id_cliente=?";
            ps = Con.prepareCall(SQL);
            ps.setInt(1, Modelo.getid_Cliente());
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Modelo.setCorreo_e(rs.getString("Correo_e"));
                Modelo.setDireccion(rs.getString("Direccion"));
                Modelo.setNombre(rs.getString("Nombre"));
                Modelo.setRfc(rs.getString("Rfc"));
                Modelo.setTelefono(rs.getString("Telefono"));
                return true;
            }
            return false;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al buscar" + e);
            return false;
        }
        //Metodos para la Tbla de busqueda de clientes

    }

    public boolean buscarTodosLosCliente(DefaultTableModel Modelo) {
        try {
            PreparedStatement Ps;
            String SQL = "select * from cliente order by id_cliente";
            Ps = Con.prepareCall(SQL);
            ResultSet Rs = Ps.executeQuery();
            int nuemeroDeCampos = Rs.getMetaData().getColumnCount();
            while (Rs.next()) {
                Object Fila[] = new Object[nuemeroDeCampos];
                Fila[0] = Rs.getInt("id_cliente");
                Fila[1] = Rs.getString("Nombre");
                Fila[2] = Rs.getString("Correo_e");
                Fila[3] = Rs.getString("Direccion");
                Fila[4] = Rs.getString("rfc");
                Fila[5] = Rs.getString("telefono");
                

                Modelo.addRow(Fila);

            }
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error:buscaTodosLosClientes()\n" + e);
            return false;
        }
    }

   
    public void buscaFrase(JTextField TxtConsultar, DefaultTableModel ModeloTabla) {
        try {
            PreparedStatement Ps;
            String SQL = "select * from cliente where nombre like '%" + TxtConsultar.getText() + "%'";

            Ps = Con.prepareCall(SQL);
            ResultSet Rs = Ps.executeQuery();
            int numeroDeCampos = Ps.getMetaData().getColumnCount();
            ModeloTabla.setRowCount(0);
            while (Rs.next()) {
                Object Fila[] = new Object[numeroDeCampos];
                Fila[0] = Rs.getInt("id_cliente");
                Fila[1] = Rs.getString("Nombre");
                Fila[2] = Rs.getString("Correo_e");
                Fila[3] = Rs.getString("Direccion");
                Fila[4] = Rs.getString("rfc");
                Fila[5] = Rs.getString("telefono");
                
                ModeloTabla.addRow(Fila);

            }
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Error: buscarFrase()\n" + e);

        }

    }

}

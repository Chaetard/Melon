/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import conexion.Conexion;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Moises peña anaya codigo:218017687
 */
public class ConsultaProveedor extends Conexion {

    Connection Con = getConexion();

    //Metodos para la Tabla de busqueda de proeveedores

    

    
    public boolean insertar(ModeloProveedor Modelo) {
        try {
            PreparedStatement Ps;
            String SQL = "insert into proveedor (idproveedor,telefono,nombre_empresa,RFC,correo_electronico) values(?,?,?,?,?)";
            Ps = Con.prepareCall(SQL);
            Ps.setInt(1, Modelo.getIdproveedor());
            Ps.setString(2, Modelo.getTelefono());

            Ps.setString(3, Modelo.getNombre_empresa());
            Ps.setString(4, Modelo.getRFC());

            Ps.setString(5, Modelo.getCorreo_electronico());
            Ps.execute();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al insertar : " + e);
            return false;
        }
    }
    public boolean modificar(ModeloProveedor Modelo){
        try {
         PreparedStatement Ps;
        String SQL = "update proveedor set telefono=?,nombre_empresa=?,RFC=?,correo_electronico=? where idproveedor=?";
        Ps = Con.prepareCall(SQL);   
        Ps.setInt(1,Modelo.getIdproveedor());
        Ps.setString(2, Modelo.getTelefono());
        Ps.setString(3, Modelo.getNombre_empresa());
        Ps.setString(4, Modelo.getRFC());
        Ps.setString(5, Modelo.getCorreo_electronico());
        
        Ps.executeUpdate();
        return true;
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Error SQL Modificar()\n " +e);
            return false;
        }
    }
    public boolean eliminar(ModeloProveedor Modelo){
        try{
            PreparedStatement ps;
            String SQL = "Delete  from proveedor  where idproveedor=?";
            ps = Con.prepareCall(SQL);
            ps.setInt(1, Modelo.getIdproveedor());
            ps.executeUpdate();
            return true;
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error  SQL: eliminar()\n "+e);
            return false;
        }
    }
    public boolean buscar (ModeloProveedor Modelo){
        try{
            PreparedStatement ps;
            String SQL = "SELECT * FROM proveedor where idproveedor =?";
            ps = Con.prepareCall(SQL);
            ps.setInt(1, Modelo.getIdproveedor());
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                Modelo.setNombre_empresa(rs.getString("nombre_empresa"));
                Modelo.setCorreo_electronico(rs.getString("correo_electronico"));
                Modelo.setRFC(rs.getString("RFC"));
                Modelo.setTelefono(rs.getString("telefono"));
                return true;
            }return false;
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Error SQL: buscar()\n"+e);
            return false;
        }
    }
    
        public boolean buscarTodosLosProveedores(DefaultTableModel Modelo){
        try {
            PreparedStatement Ps;//Para hacer la consulta sql
            String SQL = "select * from proveedor order by idproveedor";
            Ps = Con.prepareCall(SQL);
            ResultSet Rs = Ps.executeQuery();//Rs para obtener los resultados
            int numeroDeCampos = Rs.getMetaData().getColumnCount();
            while(Rs.next()){
                Object Fila[] = new Object[numeroDeCampos];
                Fila[0] = Rs.getInt("idproveedor");
                Fila[1] = Rs.getString("telefono");
                Fila[2] = Rs.getString("nombre_empresa");
                Fila[3] = Rs.getString("RFC");
                Fila[4] = Rs.getString("correo_electronico");
                
                Modelo.addRow(Fila);
            }
            return true;
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null,"Error: buscarTodosLosProveedores()\n"+ e);
            return false;//La consulta no se realizo y termino con un error 
       }
    }
        public void buscarFrase(JTextField TxtConsultar, DefaultTableModel ModeloTabla){
        try{
            PreparedStatement Ps;
            String SQL = "select * from proveedor where nombre_empresa like '%"+
                    TxtConsultar.getText()+"%'";
            Ps  = Con.prepareCall(SQL);
            ResultSet Rs = Ps.executeQuery();
            int numeroDeCampos = Rs.getMetaData().getColumnCount();
            ModeloTabla.setRowCount(0);
            while(Rs.next()){
                String Fila[] = new String[numeroDeCampos];
                Fila[0] = Rs.getInt("idproveedor")+"";
                Fila[1] = Rs.getString("telefono")+"";
                Fila[2] = Rs.getString("nombre_empresa")+"";
                Fila[3] = Rs.getString("RFC")+"";
                Fila[4] = Rs.getString("correo_electronico")+"";
                
                ModeloTabla.addRow(Fila);
            
        }
    } catch (SQLException e){
        JOptionPane.showMessageDialog(null,"Error: buscarFrase()\n"+ e);
    }
}
    
}

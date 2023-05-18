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
import vista.VistaEmpleados;

/**
 *
 * @author Pedro Daniel Figueroa Romero
 */
public class ConsultaEmpleado extends Conexion {

    Connection Con = getConexion();
    VistaEmpleados VE;

    public boolean insertar(ModeloEmpleado Modelo) {
        try {
            PreparedStatement Ps;
            String SQL = "insert into empleados (id_empleados,nombre,direccion,cargo,salario,turno) values(?,?,?,?,?,?)";
            Ps = Con.prepareCall(SQL);
            Ps.setInt(1, Modelo.getid_Empleado());
            Ps.setString(2, Modelo.getNombre());

            Ps.setString(3, Modelo.getDireccion());
            Ps.setString(4, Modelo.getCargo());
            Ps.setDouble(5, Modelo.getSalario());
            Ps.setString(6, Modelo.getTurno());


            Ps.execute();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(VE, "Error al insertar : " + e);
            return false;
        }
    }
    
    public boolean modificar(ModeloEmpleado Modelo){
        try {
            PreparedStatement Ps;
            String SQL = "update empleados set nombre=?,direccion=?,cargo=?,salario=?,turno=? where id_empleados=?";
            Ps = Con.prepareCall(SQL);

            Ps.setString(1, Modelo.getNombre());

            Ps.setString(2, Modelo.getDireccion());
            Ps.setString(3, Modelo.getCargo());
            Ps.setDouble(4, Modelo.getSalario());
            Ps.setString(5, Modelo.getTurno());
            Ps.setInt(6, Modelo.getid_Empleado());

            Ps.execute();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(VE, "Error SQL Modificar()\n " + e);
            return false;
        }
    }   
    
    public boolean eliminar(ModeloEmpleado Modelo){
        try{
            PreparedStatement ps;
            String SQL = "Delete  from empleados  where id_empleados=?";
            ps = Con.prepareCall(SQL);
            ps.setInt(1, Modelo.getid_Empleado());
            ps.execute();
            return true;
        }catch(SQLException e){
            JOptionPane.showMessageDialog(VE, "Error  SQL: eliminar()\n "+e);
            return false;
        }
    }
    public boolean buscar (ModeloEmpleado Modelo){
        try{
            PreparedStatement ps;
            String SQL = "SELECT * FROM empleados where id_empleados=?";
            ps = Con.prepareCall(SQL);
            ps.setInt(1, Modelo.getid_Empleado());
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                Modelo.setCargo(rs.getString("cargo"));
                Modelo.setDireccion(rs.getString("direccion"));
                Modelo.setNombre(rs.getString("nombre"));
                Modelo.setSalario(rs.getDouble("salario"));
                Modelo.setTurno(rs.getString("turno"));

                return true;
            }return false;
        }catch (SQLException e){
            JOptionPane.showMessageDialog(VE, "Error SQL: buscar()\n"+e);
            return false;
        }
    }
    
    
        public boolean buscarTodosLosEmpleados(DefaultTableModel Modelo) {
        try {
            PreparedStatement Ps;
            String SQL = "select * from empleados order by id_empleados";
            Ps = Con.prepareCall(SQL);
            ResultSet Rs = Ps.executeQuery();
            int numeroDeCampos = Rs.getMetaData().getColumnCount();
            while (Rs.next()) {
                Object Fila[] = new Object[numeroDeCampos];
                Fila[0] = Rs.getInt("id_empleados");
                Fila[1] = Rs.getString("nombre");
                Fila[2] = Rs.getString("direccion");
                Fila[3] = Rs.getString("cargo");
                Fila[4] = Rs.getString("salario");
                Fila[5] = Rs.getString("turno");

     
                Modelo.addRow(Fila);

            }
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(VE, "Error:buscaTodosLosEmpleados()\n" + e);
            return false;
        }
    }
        
        
    public void buscarFrase(JTextField TxtConsultar, DefaultTableModel ModeloTabla) {
        try {
            PreparedStatement Ps;
            String SQL = "select * from empleados where nombre like '%" + TxtConsultar.getText() + "%'";

            Ps = Con.prepareCall(SQL);
            ResultSet Rs = Ps.executeQuery();
            int numeroDeCampos = Ps.getMetaData().getColumnCount();
            ModeloTabla.setRowCount(0);
            while (Rs.next()) {
                Object Fila[] = new Object[numeroDeCampos];
                Fila[0] = Rs.getInt("id_empleados");
                Fila[1] = Rs.getString("nombre");
                Fila[2] = Rs.getString("direccion");
                Fila[3] = Rs.getString("cargo");
                Fila[4] = Rs.getString("salario");
                Fila[5] = Rs.getString("turno");

                
                ModeloTabla.addRow(Fila);

            }
        } catch (SQLException e){
            JOptionPane.showMessageDialog(VE, "Error: buscarFrase()\n" + e);

        }

    }        
}

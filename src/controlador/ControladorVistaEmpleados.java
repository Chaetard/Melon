/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import modelo.ConsultaEmpleado;
import modelo.ModeloEmpleado;
import vista.VistaEmpleados;

/**
 *
 * @author Pedro Daniel Figueroa Romero
 */
public class ControladorVistaEmpleados implements MouseListener {

   private VistaEmpleados VE;
   private ModeloEmpleado ModeloEmpleado;
   private ConsultaEmpleado ConsultaEmpleado = new ConsultaEmpleado();

    public ControladorVistaEmpleados(VistaEmpleados VE, ModeloEmpleado ModeloEmpleado) {
        this.VE = VE;
        this.ModeloEmpleado = ModeloEmpleado;
        this.VE.setVisible(true);
        oyentes();
    }

    private void oyentes() {
        VE.BtnGuardar.addMouseListener(this);
        VE.BtnBuscar.addMouseListener(this);
        VE.BtnEliminar.addMouseListener(this);
        VE.BtnActualizar.addMouseListener(this);
        VE.BtnSalir.addMouseListener(this);
      
        
    }

    private void llenarModeloEmpleado() {
        String id_empleado = VE.idEmpleado.getText();
        int empleado = Integer.parseInt(id_empleado);
        ModeloEmpleado.setid_Empleado(empleado);

        ModeloEmpleado.setNombre(VE.nombre.getText());
        
        ModeloEmpleado.setDireccion(VE.direccion.getText());
        
        ModeloEmpleado.setCargo(VE.cargo.getText());

        String salarioC = VE.salario.getText();
        double salario = Double.parseDouble(salarioC);
        ModeloEmpleado.setSalario(salario);

        ModeloEmpleado.setTurno(VE.turno.getText());

    }
    
    private void llenarVistaEmpleado() {
        VE.idEmpleado.setText(ModeloEmpleado.getid_Empleado()+"");
        VE.nombre.setText(ModeloEmpleado.getNombre()+"");
        VE.direccion.setText(ModeloEmpleado.getDireccion()+"");
        VE.cargo.setText(ModeloEmpleado.getCargo()+"");
        VE.salario.setText(ModeloEmpleado.getSalario()+"");
        VE.turno.setText(ModeloEmpleado.getTurno()+"");

    }
    
    private void limpiarCampos() {
        VE.idEmpleado.setText("");
        VE.nombre.setText("");
        VE.direccion.setText("");
        VE.cargo.setText("");
        VE.salario.setText("");
        VE.turno.setText("");

    }
    
    private boolean validarCampoId() {
        if (VE.idEmpleado.getText().isEmpty()) 
            return false;
        else
            return true;
    }
    
    private boolean validarTodosLosCampos() {
        if (VE.idEmpleado.getText().isEmpty()||
            VE.nombre.getText().isEmpty()||
            VE.direccion.getText().isEmpty()||
            VE.cargo.getText().isEmpty()||
            VE.salario.getText().isEmpty()||
            VE.turno.getText().isEmpty())
                
            return false;
        else
            return true;
    }
    
    private void guardar() {
        if (validarTodosLosCampos()){
            ModeloEmpleado.setid_Empleado(Integer.parseInt(VE.idEmpleado.getText()));
            if (ConsultaEmpleado.buscar(ModeloEmpleado)==true){
                JOptionPane.showMessageDialog(VE, "Ese empleado ya existe");
            }else{
                llenarModeloEmpleado();
                if (ConsultaEmpleado.insertar(ModeloEmpleado)==true) {
                    JOptionPane.showMessageDialog(VE, "Registro guardado correctamente");
                    limpiarCampos();
                }else{
                    JOptionPane.showMessageDialog(VE, "Error al guardar el registro");
                }
            }
            
        }else{
            JOptionPane.showMessageDialog(null, "El campo id_empleado no debe estar vacío.");
        }
    }

    private void modificar() {
        if (validarTodosLosCampos()){
            llenarModeloEmpleado();
            
            ConsultaEmpleado.modificar(ModeloEmpleado);
            if (ConsultaEmpleado.buscar(ModeloEmpleado)==false){
                JOptionPane.showMessageDialog(VE, "Ese empleado no existe");
            }else{
                if (ConsultaEmpleado.modificar(ModeloEmpleado)) {
                    JOptionPane.showMessageDialog(VE, "Registro modificado correctamente");
                    limpiarCampos();
                }else{
                    JOptionPane.showMessageDialog(VE, "Error al modificar el registro");
                }
            }
            
        }else{
            JOptionPane.showMessageDialog(VE, "Los campos no deben estar vacíos.");
        }
    }
    
    private void eliminar() {
        if (validarCampoId()){
            ModeloEmpleado.setid_Empleado(Integer.parseInt(VE.idEmpleado.getText()));
            
            if (ConsultaEmpleado.buscar(ModeloEmpleado)==false){
                JOptionPane.showMessageDialog(VE, "Ese empleado no existe");
            }else{
                if (ConsultaEmpleado.eliminar(ModeloEmpleado)) {
                    JOptionPane.showMessageDialog(VE, "Registro eliminado correctamente");
                    limpiarCampos();
                }else{
                    JOptionPane.showMessageDialog(VE, "Error al eliminar el registro");
                }
            }
            
        }else{
            JOptionPane.showMessageDialog(VE, "El campo id_empleado no debe estar vacío.");
        }
    }
    private void buscar() {
        if (validarCampoId()){
            ModeloEmpleado.setid_Empleado(Integer.parseInt(VE.idEmpleado.getText()));
            
            if (ConsultaEmpleado.buscar(ModeloEmpleado)==true){
                llenarVistaEmpleado();
            }else{
                JOptionPane.showMessageDialog(VE, "Registro no existe.");
            }
            
        }else{
            JOptionPane.showMessageDialog(VE, "Los campos no deben estar vacíos.");
        }
    }
    
    private void salir() {
        
        int opc = JOptionPane.showConfirmDialog(VE, "¿Deseas salir de Empleados?","Alerta!",0,1);
        if (opc == 0) VE.dispose();
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == VE.BtnGuardar) {
            guardar();
        }
          
        if (e.getSource() == VE.BtnActualizar) {
            modificar();

        }
        if (e.getSource() == VE.BtnBuscar) {
            buscar();

        }
        if (e.getSource() == VE.BtnEliminar) {
            eliminar();
        }
        if (e.getSource() == VE.BtnSalir) {
            salir();
        }
        
        
    }

    private void InsertarDatosEmpleado() {
        llenarModeloEmpleado();
        if (ConsultaEmpleado.insertar(ModeloEmpleado) == true) {
            JOptionPane.showMessageDialog(VE, "Datos Introducidos", "Hecho", 1);
        } else {
            
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
    
   
}

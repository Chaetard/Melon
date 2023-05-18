



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import modelo.ConsultaProveedor;
import modelo.ModeloProveedor;
import vista.VistaProveedor;

/**
 *
 * @author Moises peña anaya codigo:218017687
 */
public class ControladorVistaProveedor implements MouseListener {

    VistaProveedor Vp;
    ModeloProveedor ModeloProveedor;
    ConsultaProveedor ConsultaProveedor = new ConsultaProveedor();

    public ControladorVistaProveedor(VistaProveedor Vp, ModeloProveedor ModeloProveedor) {
        this.Vp = Vp;
        this.ModeloProveedor = ModeloProveedor;
        this.Vp.setVisible(true);
        oyentes();

    }
    

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource()==Vp.BtnGuardar) {
            guardar();
        }else if (e.getSource()==Vp.BtnActualizar) {
            modificar();
        }else if (e.getSource()==Vp.BtnEliminar) {
            eliminar();
        }else if (e.getSource()==Vp.BtnBuscar) {
            buscar();
        }else if (e.getSource()==Vp.BtnSalir) {
            salir();
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
    
    private void oyentes() {
        Vp.BtnGuardar.addMouseListener(this);
        Vp.BtnActualizar.addMouseListener(this);
        Vp.BtnBuscar.addMouseListener(this);
        Vp.BtnEliminar.addMouseListener(this);
        Vp.BtnSalir.addMouseListener(this);
       
    }
    
    private void llenarModeloConVista(){
        
        ModeloProveedor.setIdproveedor(Integer.parseInt(Vp.idPro.getText()));
        ModeloProveedor.setNombre_empresa(Vp.nombreEmpresa.getText());
        ModeloProveedor.setRFC(Vp.rfc.getText());
        ModeloProveedor.setTelefono(Vp.telefono.getText());
        ModeloProveedor.setCorreo_electronico(Vp.correoelectronico.getText());
    }
    private void llenarVistaConModelo(){
        Vp.idPro.setText(ModeloProveedor.getIdproveedor()+"");
        Vp.nombreEmpresa.setText(ModeloProveedor.getNombre_empresa()+"");
        Vp.rfc.setText(ModeloProveedor.getRFC()+"");
        Vp.telefono.setText(ModeloProveedor.getTelefono()+"");
        Vp.correoelectronico.setText(ModeloProveedor.getNombre_empresa()+"");
    }
    private void limpiarCampos(){
        Vp.idPro.setText("");
        Vp.nombreEmpresa.setText("");
        Vp.rfc.setText("");
        Vp.telefono.setText("");
        Vp.correoelectronico.setText("");
    }
    private boolean validarCampoId(){
        if (Vp.idPro.getText().isEmpty())
            return false;
        else
            return true;
    }
    private boolean validarTodosLosCampos(){
        if (Vp.idPro.getText().isEmpty()||
            Vp.nombreEmpresa.getText().isEmpty()||
            Vp.rfc.getText().isEmpty()||
            Vp.telefono.getText().isEmpty()||
            Vp.correoelectronico.getText().isEmpty()) {
            return false;
        }else
            return true;
    }

    private void guardar() {
        if (validarTodosLosCampos()) {
            ModeloProveedor.setIdproveedor(Integer.parseInt(Vp.idPro.getText()));
            if (ConsultaProveedor.buscar(ModeloProveedor)==true) {
                JOptionPane.showMessageDialog(Vp, "Ese proveedor ya existe");
            }else
                llenarModeloConVista();
            if (ConsultaProveedor.insertar(ModeloProveedor)==true) {
                JOptionPane.showMessageDialog(Vp, "Registro guardado correctamente");
                limpiarCampos();
            }else{
                JOptionPane.showMessageDialog(Vp, "Error al guardar el registro");
            }
        }else{
    JOptionPane.showMessageDialog(Vp, "Los campos no deben estar vacio");
}
    }

    private void modificar() {
        if (validarTodosLosCampos()){
            llenarModeloConVista();
            
            ModeloProveedor ModeloTemporal = new ModeloProveedor();
            ModeloTemporal.setIdproveedor(Integer.parseInt(Vp.idPro.getText()));
            
            ConsultaProveedor.modificar(ModeloProveedor);
            if (ConsultaProveedor.modificar(ModeloProveedor)==false){
                JOptionPane.showMessageDialog(Vp, "Ese proveedor no existe");
            }else{
                if (ConsultaProveedor.modificar(ModeloProveedor)) {
                    JOptionPane.showMessageDialog(Vp, "Registro modificado correctamente");
                    limpiarCampos();
                }else{
                    JOptionPane.showMessageDialog(Vp, "Error al modificar el registro");
                }
            }
            
        }else{
            JOptionPane.showMessageDialog(Vp, "Los campos no deben estar vacíos.");
        }
    }
    
    private void eliminar() {
        if (validarCampoId()){
            ModeloProveedor.setIdproveedor(Integer.parseInt(Vp.idPro.getText()));
            
            if (ConsultaProveedor.buscar(ModeloProveedor)==false){
                JOptionPane.showMessageDialog(Vp, "Ese proveedor no existe");
            }else{
                if (ConsultaProveedor.eliminar(ModeloProveedor)) {
                    JOptionPane.showMessageDialog(Vp, "Registro eliminado correctamente");
                    limpiarCampos();
                }else{
                    JOptionPane.showMessageDialog(Vp, "Error al eliminar el registro");
                }
            }
            
        }else{
            JOptionPane.showMessageDialog(Vp, "El campo idproveedor no debe estar vacío.");
        }
    }
    private void buscar() {
        if (validarCampoId()){
            ModeloProveedor.setIdproveedor(Integer.parseInt(Vp.idPro.getText()));
            
            if (ConsultaProveedor.buscar(ModeloProveedor)==true){
                llenarVistaConModelo();
            }else{
                JOptionPane.showMessageDialog(Vp, "Registro no existe.");
            }
            
        }else{
            JOptionPane.showMessageDialog(Vp, "Los campos no deben estar vacíos.");
        }
    }
    
    private void salir() {
        
        int opc = JOptionPane.showConfirmDialog(Vp, "¿Deseas salir de Empleados?","Alerta!",0,1);
        if (opc == 0) Vp.dispose();
    }
}
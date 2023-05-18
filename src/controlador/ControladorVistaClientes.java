/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.MouseEvent; 
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import modelo.ConsultaCliente;

import modelo.ModeloCliente;
import vista.VistaClientes;


/**
 *
 * @author Victor Manuel Beas Aguilar
 */
public class ControladorVistaClientes implements MouseListener {

    private VistaClientes VistaClientes;
    private ModeloCliente ModeloCliente;
    private ConsultaCliente ConsultaCliente = new ConsultaCliente();

    public ControladorVistaClientes(VistaClientes vistaClientes, ModeloCliente ModeloCliente) {
        this.VistaClientes = vistaClientes;
        this.ModeloCliente = ModeloCliente;
        this.VistaClientes.setVisible(true);
        oyentes();
    }

    private void oyentes() {
        VistaClientes.BtnGuardar.addMouseListener(this);
        VistaClientes.BtnBuscar.addMouseListener(this);
        VistaClientes.BtnEliminar.addMouseListener(this);
        VistaClientes.BtnActualizar.addMouseListener(this);
        VistaClientes.BtnSalir.addMouseListener(this);
        
    }

    private void llenarModeloCliente() {
        String id_cliente = VistaClientes.idCliente.getText();
        int clientes = Integer.parseInt(id_cliente);
        ModeloCliente.setid_Cliente(clientes);

        ModeloCliente.setNombre(VistaClientes.nombre.getText());

        ModeloCliente.setDireccion(VistaClientes.direccion.getText());

        ModeloCliente.setCorreo_e(VistaClientes.correo_e.getText());

        ModeloCliente.setTelefono(VistaClientes.telefono.getText());

        ModeloCliente.setRfc(VistaClientes.rfc.getText());

    }

    private void llenarVistaCliente() {
        VistaClientes.idCliente.setText(ModeloCliente.getid_Cliente() + "");
        VistaClientes.nombre.setText(ModeloCliente.getNombre() + "");
        VistaClientes.direccion.setText(ModeloCliente.getDireccion() + "");
        VistaClientes.correo_e.setText(ModeloCliente.getCorreo_e() + "");
        VistaClientes.rfc.setText(ModeloCliente.getRfc() + "");
        VistaClientes.telefono.setText(ModeloCliente.getTelefono() + "");
    }

    private void limpiarCampos() {
        VistaClientes.idCliente.setText("");
        VistaClientes.nombre.setText("");
        VistaClientes.direccion.setText("");
        VistaClientes.correo_e.setText("");
        VistaClientes.rfc.setText("");
        VistaClientes.telefono.setText("");

    }

    private boolean validarCampoId() {
        if (VistaClientes.idCliente.getText().isEmpty()) {
            return false;
        } else {
            return true;
        }
    }

    private boolean validarTodosLosCampos() {
        if (VistaClientes.idCliente.getText().isEmpty()
                || VistaClientes.nombre.getText().isEmpty()
                || VistaClientes.direccion.getText().isEmpty()
                || VistaClientes.correo_e.getText().isEmpty()
                || VistaClientes.rfc.getText().isEmpty()
                || VistaClientes.telefono.getText().isEmpty()) {
            return false;
        } else {
            return true;
        }
    }

    private void guardar() {
        if (validarTodosLosCampos()) {
            ModeloCliente.setid_Cliente(Integer.parseInt(VistaClientes.idCliente.getText()));
            if (ConsultaCliente.buscar(ModeloCliente) == true) {
                JOptionPane.showMessageDialog(VistaClientes, "Ese producto ya existe");
            } else {
                llenarModeloCliente();
                if (ConsultaCliente.insertar(ModeloCliente) == true) {
                    JOptionPane.showMessageDialog(VistaClientes, "Registro guardado correctamente");
                    limpiarCampos();
                } else {
                    JOptionPane.showMessageDialog(VistaClientes, "Error al guardar el registro");
                }
            }

        } else {
            JOptionPane.showMessageDialog(VistaClientes, "El campo id_empleado no debe estar vacío.");
        }
    }

    private void modificar() {
        if (validarTodosLosCampos()) {
            llenarModeloCliente();
//
//            ModeloCliente ModeloTemporal = new ModeloCliente();
//            ModeloTemporal.setid_Cliente(Integer.parseInt(VistaClientes.idCliente.getText()));

            
            ConsultaCliente.modificar(ModeloCliente);
            if (ConsultaCliente.modificar(ModeloCliente) == false) {
                JOptionPane.showMessageDialog(VistaClientes, "Ese producto no existe");
            } else {
                if (ConsultaCliente.modificar(ModeloCliente)) {
                    JOptionPane.showMessageDialog(VistaClientes, "Registro modificado correctamente");
                    limpiarCampos();
                } else {
                    JOptionPane.showMessageDialog(VistaClientes, "Error al modificar el registro");
                }
            }

        } else {
            JOptionPane.showMessageDialog(VistaClientes, "Los campos no deben estar vacíos.");
        }
    }

    private void eliminar() {
        if (validarCampoId()) {
            ModeloCliente.setid_Cliente(Integer.parseInt(VistaClientes.idCliente.getText()));

            if (ConsultaCliente.buscar(ModeloCliente) == false) {
                JOptionPane.showMessageDialog(VistaClientes, "Ese producto no existe");
            } else {
                if (ConsultaCliente.eliminar(ModeloCliente)) {
                    JOptionPane.showMessageDialog(VistaClientes, "Registro eliminado correctamente");
                    limpiarCampos();
                } else {
                    JOptionPane.showMessageDialog(VistaClientes, "Error al eliminar el registro");
                }
            }

        } else {
            JOptionPane.showMessageDialog(VistaClientes, "El campo id_cliente no debe estar vacío.");
        }
    }

    private void buscar() {
        if (validarCampoId()) {
            ModeloCliente.setid_Cliente(Integer.parseInt(VistaClientes.idCliente.getText()));

            if (ConsultaCliente.buscar(ModeloCliente) == true) {
                llenarVistaCliente();
            } else {
                JOptionPane.showMessageDialog(VistaClientes, "Registro no existe.");
            }

        } else {
            JOptionPane.showMessageDialog(VistaClientes, "Los campos no deben estar vacíos.");
        }
    }

    private void salir() {

        int opc = JOptionPane.showConfirmDialog(VistaClientes, "¿Deseas salir de Cliente?", "Alerta!", 0, 1);
        if (opc == 0) {
            VistaClientes.dispose();
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == VistaClientes.BtnGuardar) {
            InsertarDatosCliente();

        }
        if (e.getSource() == VistaClientes.BtnActualizar) {
            modificar();

        }
        if (e.getSource() == VistaClientes.BtnBuscar) {
            buscar();

        }
        if (e.getSource() == VistaClientes.BtnEliminar) {
            eliminar();
        }
        if (e.getSource() == VistaClientes.BtnSalir) {
            salir();
            
        }
      

    }

    private void InsertarDatosCliente() {
        llenarModeloCliente();
        if (ConsultaCliente.insertar(ModeloCliente) == true) {
            JOptionPane.showMessageDialog(VistaClientes, "Datos Introducidos", "Hecho", 1);
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

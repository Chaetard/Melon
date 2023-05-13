/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import modelo.ConsultaVenta;
import modelo.ModeloTablaVentas;
import modelo.ModeloVenta;
import vista.VistaBusqueda;

/**
 *
 * @author Jesus Santos 221341606
 */
public class ControladorBusqueda implements MouseListener, KeyListener {

    ModeloTablaVentas ModeloTablaVentas;
    ModeloVenta ModeloVenta;
    VistaBusqueda VistaBusqueda;
    ConsultaVenta ConsultaVenta = new ConsultaVenta();
    public boolean est = false;

    public ControladorBusqueda(ModeloTablaVentas ModeloTablaVentas, ModeloVenta ModeloVenta, VistaBusqueda VistaBusqueda) {
        this.ModeloTablaVentas = ModeloTablaVentas;
        this.ModeloVenta = ModeloVenta;
        this.VistaBusqueda = VistaBusqueda;

        VistaBusqueda.Tabla.setModel(ModeloTablaVentas.getModeloTabla());
        oyentes();
        llenarTablaProductos();
        VistaBusqueda.setVisible(true);

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == VistaBusqueda.BtnAceptar) {
            LlenarModeloConSelecionFilaTabla();

            VistaBusqueda.dispose();
            est = true;
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

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getSource() == VistaBusqueda.TxtId) {

            ConsultaVenta.buscarFrase(VistaBusqueda.TxtId, ModeloTablaVentas.getModeloTabla());
        }
    }

    private void oyentes() {
        VistaBusqueda.TxtId.addMouseListener(this);
        VistaBusqueda.BtnAceptar.addMouseListener(this);
        VistaBusqueda.Tabla.addMouseListener(this);

        VistaBusqueda.TxtId.addKeyListener(this);
    }

    private void llenarTablaProductos() {
        ConsultaVenta.buscarVentas(ModeloTablaVentas.getModeloTabla());
        
        VistaBusqueda.Tabla.setModel(ModeloTablaVentas.getModeloTabla());

    }

    private void LlenarModeloConSelecionFilaTabla() {
        int filaSeleccionada = VistaBusqueda.Tabla.getSelectedRow();
        if (filaSeleccionada != -1) {
            int id_venta = Integer.parseInt(ModeloTablaVentas.getModeloTabla().getValueAt(filaSeleccionada, 0).toString());
            String estado = ModeloTablaVentas.getModeloTabla().getValueAt(filaSeleccionada, 1).toString();
            int id_cliente = Integer.parseInt(ModeloTablaVentas.getModeloTabla().getValueAt(filaSeleccionada, 2).toString());
            float total = Float.parseFloat(ModeloTablaVentas.getModeloTabla().getValueAt(filaSeleccionada, 3).toString());
            String metodo_pago = ModeloTablaVentas.getModeloTabla().getValueAt(filaSeleccionada, 4).toString();
            float descuento = Float.parseFloat(ModeloTablaVentas.getModeloTabla().getValueAt(filaSeleccionada, 5).toString());
            int id_empleado = Integer.parseInt(ModeloTablaVentas.getModeloTabla().getValueAt(filaSeleccionada, 6).toString());
            String fecha = ModeloTablaVentas.getModeloTabla().getValueAt(filaSeleccionada, 7).toString();

            ModeloVenta.setid_Venta(id_venta);
            ModeloVenta.setEstado(estado);
            ModeloVenta.setId_cliente(id_cliente);
            ModeloVenta.setTotal(total);
            ModeloVenta.setMetodo_pago(metodo_pago);
            ModeloVenta.setDescuento(descuento);
            ModeloVenta.setId_empleado(id_cliente);
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import modelo.ConsultaVenta;

import modelo.ModeloVenta;

import vista.VistaVentas;

/**
 *
 * @author Jesus Santos 221341606
 */
public class ControladorVistaVentas implements MouseListener {

    VistaVentas VV;
    ModeloVenta ModeloVenta;
    ConsultaVenta ConsultaVenta = new ConsultaVenta();

    public ControladorVistaVentas(VistaVentas VV, ModeloVenta ModeloVenta) {
        this.VV = VV;
        this.ModeloVenta = ModeloVenta;
        this.VV.setVisible(true);
        oyentes();

    }

    private void oyentes() {
        VV.BtnGuardar.addMouseListener(this);
    }

    private void llenarModeloCampos() {
        String id_venta = VV.idVenta.getText();
        int ventas = Integer.parseInt(id_venta);
        ModeloVenta.setid_Venta(ventas);

        String id_cliente = VV.cliente.getText();
        int cliente = Integer.parseInt(id_cliente);
        ModeloVenta.setId_cliente(cliente);

        ModeloVenta.setEstado(VV.estado.getText());

        String descuentoi = VV.descuento.getText();
        double descuento = Double.parseDouble(descuentoi);
        ModeloVenta.setDescuento(descuento);

        ModeloVenta.setMetodo_pago(VV.metodoPag.getText());

        String totali = VV.total.getText();
        double total = Double.parseDouble(totali);
        ModeloVenta.setTotal(total);

        String id_emp = VV.idEmp.getText();
        int id_empleado = Integer.parseInt(id_emp);
        ModeloVenta.setId_empleado(id_empleado);

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == VV.BtnGuardar) {
            InsertarDatosVenta();
            
        }
    }

    private void InsertarDatosVenta() {
        llenarModeloCampos();
        if (ConsultaVenta.insertar(ModeloVenta) == true) {
            JOptionPane.showMessageDialog(VV, "Datos Introducidos", "Echo", 1);
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

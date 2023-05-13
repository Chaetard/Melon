/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Jesus Santos 221341606
 */
public class ModeloTablaVentas {

    DefaultTableModel ModeloTabla = new DefaultTableModel();

    public ModeloTablaVentas() {

        ModeloTabla.addColumn("Id Venta");
        ModeloTabla.addColumn("Estado");
        ModeloTabla.addColumn("Id Cliente");
        ModeloTabla.addColumn("Total");
        ModeloTabla.addColumn("Metodo De Pago");
        ModeloTabla.addColumn("Descuento");
        ModeloTabla.addColumn("Id Empleado");
        ModeloTabla.addColumn("Fecha");

    }

    public DefaultTableModel getModeloTabla() {
        return ModeloTabla;
    }

    public void setModeloTabla(DefaultTableModel ModeloTabla) {
        this.ModeloTabla = ModeloTabla;
    }
}

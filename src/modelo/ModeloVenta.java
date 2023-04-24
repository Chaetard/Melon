/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Jesus Santos 221341606
 */
public class ModeloVenta {
    private int id_venta;
    private int id_cliente;
    private String Estado;
    private double  descuento;
    private String Metodo_pago;
    private double total;
    private int id_empleado;
    
    public ModeloVenta(){
        
    }

    public int getid_Venta() {
        return id_venta;
    }

    public void setid_Venta(int venta) {
        this.id_venta = venta;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    public String getMetodo_pago() {
        return Metodo_pago;
    }

    public void setMetodo_pago(String Metodo_pago) {
        this.Metodo_pago = Metodo_pago;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(int id_empleado) {
        this.id_empleado = id_empleado;
    }
    
}

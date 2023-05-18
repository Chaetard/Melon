/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Victor Manuel Beas Aguilar
 */
public class ModeloCliente {
    
    private int id_cliente;
    private String Nombre;
    private String Correo_e;
    private String Direccion;
    private String Rfc;
    private String Telefono;
    
    public ModeloCliente(){
        
    }

    public int getid_Cliente() {
        return id_cliente;
    }

    public void setid_Cliente(int cliente) {
        this.id_cliente = cliente;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public String getCorreo_e() {
        return Correo_e;
    }

    public void setCorreo_e(String Correo_e) {
        this.Correo_e = Correo_e;
    }

    public String getRfc() {
        return Rfc;
    }
    
    public void setRfc(String rfc) {
        this.Rfc = rfc;
    
    }

    public String getTelefono() {
        return Telefono;
        
    }
    public void setTelefono(String telefono) {
        this.Telefono = telefono;
    }

    
    
}

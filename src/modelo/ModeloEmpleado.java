/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Pedro Daniel Figueroa Romero
 */
public class ModeloEmpleado {
    private int id_empleado;
    private String Nombre;
    private String Direccion;
    private String Cargo;
    private double salario;
    private String Turno;

    
    public ModeloEmpleado(){
        
    }

    public int getid_Empleado() {
        return id_empleado;
    }

    public void setid_Empleado(int empleado) {
        this.id_empleado = empleado;
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

    public String getCargo() {
        return Cargo;
    }

    public void setCargo(String Cargo) {
        this.Cargo = Cargo;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getTurno() {
        return Turno;
    }

    public void setTurno(String Turno) {
        this.Turno = Turno;
    }
    
    
}


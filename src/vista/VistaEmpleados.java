/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import interfaces.Fuentes;
import java.awt.Dimension;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author Pedro Daniel Figueroa Romero
 */
public class VistaEmpleados extends JFrame implements Fuentes {
    
    
    ImageIcon ImSave = new ImageIcon(getClass().getResource("/imagenes/savep.png"));
    ImageIcon ImSearch = new ImageIcon(getClass().getResource("/imagenes/searchp.png"));
    ImageIcon ImUpdate = new ImageIcon(getClass().getResource("/imagenes/update.png"));
    ImageIcon ImDelete = new ImageIcon(getClass().getResource("/imagenes/delete.png"));
    ImageIcon ImExit = new ImageIcon(getClass().getResource("/imagenes/exit.png"));
    ImageIcon ImFavicon = new ImageIcon(getClass().getResource("/imagenes/favicon.png"));
    JLabel titulo = new JLabel("Empleados");

    JLabel idEmpleadoL = new JLabel("ID del Empleado");
    public JTextField idEmpleado = new JTextField();

    JLabel nombreL = new JLabel("Nombre");
    public JTextField nombre = new JTextField();

    JLabel direccionL = new JLabel("Dirección");
    public JTextField direccion = new JTextField();

    JLabel cargoL = new JLabel("Cargo");
    public JTextField cargo = new JTextField();

    JLabel salarioL = new JLabel("Salario");
    public JTextField salario = new JTextField();

    JLabel turnoL = new JLabel("Turno");
    public JTextField turno = new JTextField();
    

    public JButton BtnGuardar = new JButton("Guardar",ImSave);
    public JButton BtnBuscar = new JButton("Buscar",ImSearch);
    public JButton BtnEliminar = new JButton("Eliminar",ImDelete);
    public JButton BtnActualizar = new JButton("Actualizar",ImUpdate);
    public JButton BtnSalir = new JButton("Salir",ImExit);
    
   

    public VistaEmpleados() {
        configuracion();
        etiquetas();
        tooltips();

    }

    private void configuracion() {
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setSize(1280, 720);
        this.setTitle("Registro de Empleados 1.0");
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.getContentPane().setBackground(new java.awt.Color(241, 195, 91));
        this.setIconImage(ImFavicon.getImage());
        this.setResizable(false);
        this.setAlwaysOnTop(true);

    }

    private void etiquetas() {
        titulo.setFont(FUENTES_TITULOS);

        this.add(titulo);
        this.add(BtnGuardar);
        this.add(BtnBuscar);
        this.add(BtnEliminar);
        this.add(BtnActualizar);
        this.add(BtnSalir);

        BtnBuscar.setPreferredSize(new Dimension(160, 60));
        BtnActualizar.setPreferredSize(new Dimension(160, 60));
        BtnEliminar.setPreferredSize(new Dimension(160, 60));
        BtnSalir.setPreferredSize(new Dimension(160, 60));
        BtnGuardar.setPreferredSize(new Dimension(160, 60));

        titulo.setBounds(600, 20, 400, 60);
        idEmpleadoL.setFont(FUENTES_SECUNDARIOS);
        this.add(idEmpleadoL);
        this.add(idEmpleado);
        idEmpleadoL.setBounds(340, 80, 500, 100);
        idEmpleado.setBounds(510, 115, 500, 35);
        idEmpleado.setFont(FUENTES_SECUNDARIOS);

        this.add(nombreL);
        this.add(nombre);
        nombreL.setFont(FUENTES_SECUNDARIOS);
        nombreL.setBounds(340, 130, 500, 100);
        nombre.setBounds(510, 165, 500, 35);

        this.add(direccionL);
        this.add(direccion);
        direccionL.setFont(FUENTES_SECUNDARIOS);
        direccionL.setBounds(340, 180, 500, 100);
        direccion.setBounds(510, 215, 500, 35);

        this.add(cargoL);
        this.add(cargo);
        cargoL.setFont(FUENTES_SECUNDARIOS);
        cargoL.setBounds(340, 230, 500, 100);
        cargo.setBounds(510, 265, 500, 35);

        this.add(salarioL);
        this.add(salario);
        salarioL.setFont(FUENTES_SECUNDARIOS);
        salarioL.setBounds(340, 280, 500, 100);
        salario.setBounds(510, 315, 500, 35);

        this.add(turnoL);
        this.add(turno);
        turnoL.setFont(FUENTES_SECUNDARIOS);
        turnoL.setBounds(340, 330, 500, 100);
        turno.setBounds(510, 365, 500, 35);
        

        BtnGuardar.setBounds(120, 585, 160, 60);
        BtnBuscar.setBounds(340, 585, 160, 60);
        BtnEliminar.setBounds(560, 585, 160, 60);
        BtnActualizar.setBounds(780, 585, 160, 60);
        BtnSalir.setBounds(1000, 585, 160, 60);
        
       
    }
    
        private void tooltips() {
        BtnBuscar.setToolTipText("Clic aquí para buscar un registro");
        BtnActualizar.setToolTipText("Clic aquí para actualizar el registro");
        BtnEliminar.setToolTipText("Clic aquí para eliminar el registro");
        BtnSalir.setToolTipText("Clic aquí para salir de Empleados");
        BtnGuardar.setToolTipText("Clic aquí para guardar el registro");
    }
}


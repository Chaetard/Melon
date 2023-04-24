/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import interfaces.Fuentes;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author Jesus Santos 221341606
 */
public class VistaVentas extends JFrame implements Fuentes {

    ImageIcon ImFavicon = new ImageIcon(getClass().getResource("/imagenes/favicon.png"));
    JLabel titulo = new JLabel("ABC De Productos");

    JLabel idVentaL = new JLabel("Id de la Venta");
    public JTextField idVenta = new JTextField();

    JLabel clienteL = new JLabel("Id del Cliente");
    public JTextField cliente = new JTextField();

    JLabel totalL = new JLabel("Total");
    public JTextField total = new JTextField();

    JLabel estadoL = new JLabel("Estado");
    public JTextField estado = new JTextField();

    JLabel descuentoL = new JLabel("Descuento");
    public JTextField descuento = new JTextField();

    JLabel metodoPagL = new JLabel("Forma de Pago");
    public JTextField metodoPag = new JTextField();

    JLabel idEmpL = new JLabel("Id del Empleado");
    public JTextField idEmp = new JTextField();

    public JButton BtnGuardar = new JButton("Guardar");
    public JButton BtnBuscar = new JButton("Buscar");
    public JButton BtnEliminar = new JButton("Eliminar");
    public JButton BtnActualizar = new JButton("Actualizar");
    public JButton BtnSalir = new JButton("Salir");

    public VistaVentas() {
        configuracion();
        etiquetas();

    }

    private void configuracion() {
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setSize(1280, 720);
        this.setTitle("Registro de Ventas 1.0");
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

        BtnBuscar.setPreferredSize(new Dimension(120, 60));
        BtnActualizar.setPreferredSize(new Dimension(120, 60));
        BtnEliminar.setPreferredSize(new Dimension(120, 60));
        BtnSalir.setPreferredSize(new Dimension(120, 60));
        BtnGuardar.setPreferredSize(new Dimension(120, 60));

        titulo.setBounds(440, 20, 400, 60);
        idVentaL.setFont(FUENTES_SECUNDARIOS);
        this.add(idVentaL);
        this.add(idVenta);
        idVentaL.setBounds(340, 80, 500, 100);
        idVenta.setBounds(510, 115, 500, 35);
        total.setFont(FUENTES_SECUNDARIOS);

        this.add(clienteL);
        this.add(cliente);
        clienteL.setFont(FUENTES_SECUNDARIOS);
        clienteL.setBounds(340, 130, 500, 100);
        cliente.setBounds(510, 165, 500, 35);

        this.add(estadoL);
        this.add(estado);
        estadoL.setFont(FUENTES_SECUNDARIOS);
        estadoL.setBounds(340, 180, 500, 100);
        estado.setBounds(510, 215, 500, 35);

        this.add(descuentoL);
        this.add(descuento);
        descuentoL.setFont(FUENTES_SECUNDARIOS);
        descuentoL.setBounds(340, 230, 500, 100);
        descuento.setBounds(510, 265, 500, 35);

        this.add(metodoPagL);
        this.add(metodoPag);
        metodoPagL.setFont(FUENTES_SECUNDARIOS);
        metodoPagL.setBounds(340, 280, 500, 100);
        metodoPag.setBounds(510, 315, 500, 35);

        this.add(totalL);
        this.add(total);
        totalL.setFont(FUENTES_SECUNDARIOS);
        totalL.setBounds(340, 330, 500, 100);
        total.setBounds(510, 365, 500, 35);

        this.add(idEmpL);
        this.add(idEmp);
        idEmpL.setFont(FUENTES_SECUNDARIOS);
        idEmpL.setBounds(340, 400, 500, 100);
        idEmp.setBounds(540, 435, 70, 35);

        BtnGuardar.setBounds(120, 585, 120, 60);
        BtnBuscar.setBounds(340, 585, 120, 60);
        BtnEliminar.setBounds(560, 585, 120, 60);
        BtnActualizar.setBounds(780, 585, 120, 60);
        BtnSalir.setBounds(1000, 585, 120, 60);
    }
}

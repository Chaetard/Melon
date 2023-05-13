/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;


import interfaces.Fuentes;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import controlador.ControladorVistaVentas;

/**
 *
 * @author Jesus Santos 221341606
 */
public class VistaVentas extends JFrame implements Fuentes {

    public ImageIcon ImFavicon = new ImageIcon(getClass().getResource("/imagenes/favicon.png"));
    public JLabel titulo = new JLabel("ABC De Ventas");
    public JLabel parrafo = new JLabel("¿Que desea Hacer?");

    public JLabel idVentaL = new JLabel("Id de la Venta");
    public JTextField idVenta = new JTextField();

    public JLabel clienteL = new JLabel("Id del Cliente");
    public JTextField cliente = new JTextField();

    public JLabel totalL = new JLabel("Total");
    public JTextField total = new JTextField();

    public JLabel estadoL = new JLabel("Estado");
    public JTextField estado = new JTextField();

    public JLabel descuentoL = new JLabel("Descuento");
    public JTextField descuento = new JTextField();

    public JLabel metodoPagL = new JLabel("Forma de Pago");
    public JTextField metodoPag = new JTextField();

    public JLabel idEmpL = new JLabel("Id del Empleado");
    public JTextField idEmp = new JTextField();

    public JButton BtnGuardar = new JButton("Guardar");
    public JButton BtnBuscar = new JButton("Buscar");
    public JButton BtnEliminar = new JButton("Eliminar");
    public JButton BtnActualizar = new JButton("Actualizar");
    

    public int tami = 100;
    private ImageIcon plus = new ImageIcon(getClass().getResource("/imagenes/plus.png"));
    private ImageIcon plusTam = new ImageIcon(plus.getImage().getScaledInstance(tami, tami, Image.SCALE_DEFAULT));
    public JLabel plusL = new JLabel(plusTam);
    
    private ImageIcon busqueda = new ImageIcon(getClass().getResource("/imagenes/si.png"));
    private ImageIcon busquedaTam = new ImageIcon(busqueda.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
    public JLabel busquedaL = new JLabel(busquedaTam);

    private ImageIcon search = new ImageIcon(getClass().getResource("/imagenes/search.png"));
    private ImageIcon searchTam = new ImageIcon(search.getImage().getScaledInstance(tami, tami, Image.SCALE_DEFAULT));
    public JLabel searchL = new JLabel(searchTam);

    private ImageIcon logoutVentas = new ImageIcon(getClass().getResource("/imagenes/logoutVentas.png"));
    private ImageIcon logoutVentasTam = new ImageIcon(logoutVentas.getImage().getScaledInstance(tami, tami, Image.SCALE_DEFAULT));
    public JLabel logoutVentasL = new JLabel(logoutVentasTam);

    private ImageIcon changes = new ImageIcon(getClass().getResource("/imagenes/changes.png"));
    private ImageIcon changesTam = new ImageIcon(changes.getImage().getScaledInstance(tami, tami, Image.SCALE_DEFAULT));
    public JLabel changesL = new JLabel(changesTam);

    private ImageIcon cross = new ImageIcon(getClass().getResource("/imagenes/cross.png"));
    private ImageIcon crossTam = new ImageIcon(cross.getImage().getScaledInstance(tami, tami, Image.SCALE_DEFAULT));
    public JLabel crossL = new JLabel(crossTam);

    public JLabel LplusL = new JLabel("");
    public JLabel LsearchL = new JLabel("");
    public JLabel LchangesL = new JLabel("");
    public JLabel LcrossL = new JLabel("");
    public JLabel LlogoutVentasL = new JLabel("");
    private ControladorVistaVentas CC;

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

        this.add(titulo);
        this.add(parrafo);

        this.add(BtnGuardar);
        this.add(BtnBuscar);
        this.add(BtnEliminar);
        this.add(BtnActualizar);
   
        this.add(idVentaL);
        this.add(idVenta);
        this.add(clienteL);
        this.add(cliente);
        this.add(estadoL);
        this.add(estado);
        this.add(descuentoL);
        this.add(descuento);
        this.add(metodoPagL);
        this.add(metodoPag);
        this.add(idEmpL);
        this.add(idEmp);
        this.add(totalL);
        this.add(total);

        BtnGuardar.setVisible(false);
        BtnBuscar.setVisible(false);
        BtnEliminar.setVisible(false);
        BtnActualizar.setVisible(false);
  
        idVentaL.setVisible(false);
        idVenta.setVisible(false);
        clienteL.setVisible(false);
        cliente.setVisible(false);
        estadoL.setVisible(false);
        estado.setVisible(false);
        descuentoL.setVisible(false);
        descuento.setVisible(false);
        metodoPagL.setVisible(false);
        metodoPag.setVisible(false);
        idEmpL.setVisible(false);
        idEmp.setVisible(false);
        totalL.setVisible(false);
        total.setVisible(false);

        this.add(plusL);
        this.add(crossL);
        this.add(changesL);
        this.add(logoutVentasL);
        this.add(searchL);

        this.add(LplusL);
        this.add(LsearchL);
        this.add(LchangesL);
        this.add(LcrossL);
        this.add(LlogoutVentasL);

        plusL.setBounds(78, 290, tami, tami);
        searchL.setBounds(334, 290, tami, tami);
        changesL.setBounds(590, 290, tami, tami);
        crossL.setBounds(846, 290, tami, tami);
        logoutVentasL.setBounds(1102, 290, tami, tami);
        
        this.add(busquedaL);
        busquedaL.setBounds(430,20,50,50);

        BtnBuscar.setPreferredSize(new Dimension(120, 60));
        BtnActualizar.setPreferredSize(new Dimension(120, 60));
        BtnEliminar.setPreferredSize(new Dimension(120, 60));
      
        BtnGuardar.setPreferredSize(new Dimension(120, 60));

        titulo.setFont(new Font("Arial", Font.PLAIN, 40));
        Dimension titleSize = titulo.getPreferredSize();
        int titleX = (1280 - titleSize.width) / 2;
        int titleY = 20;
        titulo.setBounds(titleX, titleY, titleSize.width, titleSize.height);

        parrafo.setFont(new Font("Arial", Font.PLAIN, 25));
        Dimension parrafoSize = parrafo.getPreferredSize();
        int parrafoX = (1280 - parrafoSize.width) / 2;
        int parrafoY = 75;
        parrafo.setBounds(parrafoX, parrafoY, parrafoSize.width, parrafoSize.height);

        idVentaL.setFont(FUENTES_SECUNDARIOS);
        idVentaL.setBounds(320, 80, 500, 100);
        idVenta.setBounds(510, 115, 500, 35);
        idVenta.setFont(FUENTES_SECUNDARIOS);

        clienteL.setFont(FUENTES_SECUNDARIOS);
        clienteL.setBounds(320, 130, 500, 100);
        cliente.setBounds(510, 165, 500, 35);
        cliente.setFont(FUENTES_SECUNDARIOS);
        

        estadoL.setFont(FUENTES_SECUNDARIOS);
        estadoL.setBounds(320, 180, 500, 100);
        estado.setBounds(510, 215, 500, 35);
        estado.setFont(FUENTES_SECUNDARIOS);

        descuentoL.setFont(FUENTES_SECUNDARIOS);
        descuentoL.setBounds(320, 230, 500, 100);
        descuento.setBounds(510, 265, 500, 35);
        descuento.setFont(FUENTES_SECUNDARIOS);

        metodoPagL.setFont(FUENTES_SECUNDARIOS);
        metodoPagL.setBounds(320, 280, 500, 100);
        metodoPag.setBounds(510, 315, 500, 35);
        metodoPag.setFont(FUENTES_SECUNDARIOS);

        totalL.setFont(FUENTES_SECUNDARIOS);
        totalL.setBounds(320, 330, 500, 100);
        total.setBounds(510, 365, 500, 35);
        total.setFont(FUENTES_SECUNDARIOS);

        idEmpL.setFont(FUENTES_SECUNDARIOS);
        idEmpL.setBounds(320, 400, 500, 100);
        idEmp.setBounds(510, 435, 70, 35);
        idEmp.setFont(FUENTES_SECUNDARIOS);

        BtnGuardar.setBounds(120, 585, 120, 60);
        BtnBuscar.setBounds(340, 585, 120, 60);
        BtnEliminar.setBounds(560, 585, 120, 60);
        BtnActualizar.setBounds(780, 585, 120, 60);
    }
}

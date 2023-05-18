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
 * @author Moises peña anaya codigo:218017687
 */
public class VistaProveedor extends JFrame implements Fuentes {

    ImageIcon ImFavicon = new ImageIcon(getClass().getResource("/imagenes/favicon.png"));
    JLabel titulo = new JLabel("ABC del proveedor");
    

    JLabel idProveedor = new JLabel("Id del proveedor");
    public JTextField idPro = new JTextField();
    
    

    JLabel Telefono = new JLabel("Telefono");
    public JTextField telefono = new JTextField();

    JLabel NombreEmpresa = new JLabel("Nombre de la empresa ");
    public JTextField nombreEmpresa = new JTextField();

    JLabel RFC = new JLabel("RFC");
    public JTextField rfc = new JTextField();

    JLabel CorreoElectronico = new JLabel("Correo electronico");
    public JTextField correoelectronico = new JTextField();

    
    

    public JButton BtnGuardar = new JButton("Guardar");
    public JButton BtnBuscar = new JButton("Buscar");
    public JButton BtnEliminar = new JButton("Eliminar");
    public JButton BtnActualizar = new JButton("Actualizar");
    public JButton BtnSalir = new JButton("Salir");
    
    

    
    

    public VistaProveedor() {
        configuracion();
        etiquetas();
        

    }

   


    private void configuracion() {
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setSize(1280, 720);
        this.setTitle("Registro de proveedor");
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
        idProveedor.setFont(FUENTES_SECUNDARIOS);
        this.add(idProveedor);
        this.add(idPro);
        idProveedor.setBounds(300, 80, 500, 100);
        idPro.setBounds(510, 115, 500, 35);
        nombreEmpresa.setFont(FUENTES_SECUNDARIOS);
        
        

        this.add(Telefono);
        this.add(telefono);
        Telefono.setFont(FUENTES_SECUNDARIOS);
        Telefono.setBounds(390, 130, 500, 100);
        telefono.setBounds(510, 165, 500, 35);

        this.add(RFC);
        this.add(rfc);
        RFC.setFont(FUENTES_SECUNDARIOS);
        RFC.setBounds(435, 180, 500, 100);
        rfc.setBounds(510, 215, 500, 35);

        this.add(CorreoElectronico);
        this.add(correoelectronico);
        CorreoElectronico.setFont(FUENTES_SECUNDARIOS);
        CorreoElectronico.setBounds(270, 230, 500, 100);
        correoelectronico.setBounds(510, 265, 500, 35);

        this.add(NombreEmpresa);
        this.add(nombreEmpresa);
        NombreEmpresa.setFont(FUENTES_SECUNDARIOS);
        NombreEmpresa.setBounds(220, 330, 500, 100);
        nombreEmpresa.setBounds(510, 365, 500, 35);
        
        

        BtnGuardar.setBounds(120, 585, 120, 60);
        BtnBuscar.setBounds(340, 585, 120, 60);
        BtnEliminar.setBounds(560, 585, 120, 60);
        BtnActualizar.setBounds(780, 585, 120, 60);
        BtnSalir.setBounds(1000, 585, 120, 60);
    }

}

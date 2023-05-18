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
 * @author Victor Manuel Beas Aguilar
 */
public class VistaClientes extends JFrame implements Fuentes {

    ImageIcon ImFavicon = new ImageIcon(getClass().getResource("/imagenes/favicon.png"));
    JLabel titulo = new JLabel("ABC De Cliente");

    JLabel idClienteL = new JLabel("ID del Cliente");
    public JTextField idCliente = new JTextField();

    JLabel nombreL = new JLabel("Nombre");
    public JTextField nombre = new JTextField();

    JLabel direccionL = new JLabel("Dirección");
    public JTextField direccion = new JTextField();

    JLabel correo_eL = new JLabel("Correo_e");
    public JTextField correo_e = new JTextField();

    JLabel rfcL = new JLabel("RFC");
    public JTextField rfc = new JTextField();

    JLabel telefonoL = new JLabel("Telefono");
    public JTextField telefono = new JTextField();
  
//Botones
    private ImageIcon save = new ImageIcon(getClass().getResource("/imagenes/save.png"));
    private ImageIcon saveTam = new ImageIcon(save.getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT));
    public JButton BtnGuardar = new JButton("Guardar", saveTam);

    private ImageIcon buscari = new ImageIcon(getClass().getResource("/imagenes/search.png"));
    private ImageIcon buscariTam = new ImageIcon(buscari.getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT));
    public JButton BtnBuscar = new JButton("Buscar", buscariTam);
    
    private ImageIcon eliminari = new ImageIcon(getClass().getResource("/imagenes/cross.png"));
    private ImageIcon eliminariTam = new ImageIcon(eliminari.getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT));
    public JButton BtnEliminar = new JButton("Eliminar",eliminariTam);
    
    private ImageIcon actualizari = new ImageIcon(getClass().getResource("/imagenes/changes.png"));
    private ImageIcon actualizariTam = new ImageIcon(actualizari.getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT));
    public JButton BtnActualizar = new JButton("Actualizar",actualizariTam);
    
    private ImageIcon saliri = new ImageIcon(getClass().getResource("/imagenes/logoutVentas.png"));
    private ImageIcon saliriTam = new ImageIcon(saliri.getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT));
    public JButton BtnSalir = new JButton("Salir",saliriTam);
    
   

    public VistaClientes() {
        configuracion();
        etiquetas();

    }

    public VistaClientes(JFrame jFrame, boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void configuracion() {
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setSize(1280, 720);
        this.setTitle("Registro de Cliente 1.0");
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
        idClienteL.setFont(FUENTES_SECUNDARIOS);
        this.add(idClienteL);
        this.add(idCliente);
        idClienteL.setBounds(340, 80, 500, 100);
        idCliente.setBounds(510, 115, 500, 35);
        idCliente.setFont(FUENTES_SECUNDARIOS);

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

        this.add(correo_eL);
        this.add(correo_e);
        correo_eL.setFont(FUENTES_SECUNDARIOS);
        correo_eL.setBounds(340, 230, 500, 100);
        correo_e.setBounds(510, 265, 500, 35);

        this.add(rfcL);
        this.add(rfc);
        rfcL.setFont(FUENTES_SECUNDARIOS);
        rfcL.setBounds(340, 280, 500, 100);
        rfc.setBounds(510, 315, 500, 35);

        this.add(telefonoL);
        this.add(telefono);
        telefonoL.setFont(FUENTES_SECUNDARIOS);
        telefonoL.setBounds(340, 330, 500, 100);
        telefono.setBounds(510, 365, 500, 35);

        BtnGuardar.setBounds(120, 585, 120, 60);
        BtnBuscar.setBounds(340, 585, 120, 60);
        BtnEliminar.setBounds(560, 585, 120, 60);
        BtnActualizar.setBounds(780, 585, 120, 60);
        BtnSalir.setBounds(1000, 585, 120, 60);

        
    }
}

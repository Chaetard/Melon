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
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Jesus Santos 221341606
 */
public class VistaUsuarios extends JFrame implements Fuentes {

    public JLabel titulo = new JLabel("Usuarios");
    public JLabel parrafo = new JLabel("Altas, Bajas, Busquedas Y Modificaciones");

    public JLabel IdL = new JLabel("Nomina");
    public JLabel NombreL = new JLabel("Nombre");
    public JLabel ContrasenaL = new JLabel("Contraseña");
    public JLabel UsuarioL = new JLabel("Usuario");
    public JLabel TipoL = new JLabel("Tipo");

    public JTextField Tipo = new JTextField();
    public JTextField Usuario = new JTextField();
    public JPasswordField Contrasena = new JPasswordField();
    public JTextField Nombre = new JTextField();
    public JTextField Id = new JTextField();
    int tami2 = 30;
    
    private ImageIcon plus = new ImageIcon(getClass().getResource("/imagenes/plus.png"));
    private ImageIcon plusTam2 = new ImageIcon(plus.getImage().getScaledInstance(tami2, tami2, Image.SCALE_DEFAULT));
    
    private ImageIcon search = new ImageIcon(getClass().getResource("/imagenes/search.png"));
    private ImageIcon searchTam2 = new ImageIcon(search.getImage().getScaledInstance(tami2, tami2, Image.SCALE_DEFAULT));

    private ImageIcon logoutVentas = new ImageIcon(getClass().getResource("/imagenes/logoutVentas.png"));
    private ImageIcon logoutVentasTam2 = new ImageIcon(logoutVentas.getImage().getScaledInstance(tami2, tami2, Image.SCALE_DEFAULT));

    private ImageIcon changes = new ImageIcon(getClass().getResource("/imagenes/changes.png"));
    private ImageIcon changesTam2 = new ImageIcon(changes.getImage().getScaledInstance(tami2, tami2, Image.SCALE_DEFAULT));

    private ImageIcon cross = new ImageIcon(getClass().getResource("/imagenes/cross.png"));
    private ImageIcon crossTam2 = new ImageIcon(cross.getImage().getScaledInstance(tami2, tami2, Image.SCALE_DEFAULT));

  

    public JButton btng = new JButton("Guardar", plusTam2);
    public JButton btnb = new JButton("Buscar",searchTam2);
    public JButton btna = new JButton("Actualizar",changesTam2);
    public JButton btne = new JButton("Eliminar",crossTam2);
    public JButton btns = new JButton("Salir",logoutVentasTam2);

    public VistaUsuarios() {
        configuracion();
        etiquetas();

    }
    ImageIcon ImFavicon = new ImageIcon(getClass().getResource("/imagenes/favicon.png"));

    private void configuracion() {
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setSize(1280, 720);
        this.setTitle("Registro de Usuarios 1.0");
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.getContentPane().setBackground(new java.awt.Color(241, 195, 91));
        this.setIconImage(ImFavicon.getImage());
        this.setResizable(false);
        this.setAlwaysOnTop(true);
    }

    private void etiquetas() {
        this.add(btng);
        this.add(btnb);
        this.add(btna);
        this.add(btne);
        this.add(btns);

        this.add(titulo);
        titulo.setFont(new Font("Arial", Font.PLAIN, 40));
        Dimension titleSize = titulo.getPreferredSize();
        int titleX = (1280 - titleSize.width) / 2;
        int titleY = 20;
        titulo.setBounds(titleX, titleY, titleSize.width, titleSize.height);

        this.add(parrafo);
        parrafo.setFont(new Font("Arial", Font.PLAIN, 25));
        Dimension parrafoSize = parrafo.getPreferredSize();
        int parrafoX = (1280 - parrafoSize.width) / 2;
        int parrafoY = 75;
        parrafo.setBounds(parrafoX, parrafoY, parrafoSize.width, parrafoSize.height);

        this.add(Id);
        this.add(Nombre);
        this.add(Contrasena);
        this.add(Usuario);
        this.add(Tipo);

        Id.setBounds(510, 150, 500, 35);
        Nombre.setBounds(510, 200, 500, 35);
        Usuario.setBounds(510, 250, 500, 35);
        Contrasena.setBounds(510, 300, 500, 35);
        Tipo.setBounds(510, 350, 500, 35);

        IdL.setFont(FUENTES_SECUNDARIOS);
        NombreL.setFont(FUENTES_SECUNDARIOS);
        ContrasenaL.setFont(FUENTES_SECUNDARIOS);
        UsuarioL.setFont(FUENTES_SECUNDARIOS);
        TipoL.setFont(FUENTES_SECUNDARIOS);

        this.add(IdL);
        this.add(NombreL);
        this.add(ContrasenaL);
        this.add(UsuarioL);
        this.add(TipoL);

        IdL.setBounds(340, 150, 500, 35);
        NombreL.setBounds(340, 200, 500, 35);
        UsuarioL.setBounds(340, 250, 500, 35);
        ContrasenaL.setBounds(340, 300, 500, 35);
        TipoL.setBounds(340, 350, 500, 35);

        btng.setBounds(120, 585, 120, 60);
        btna.setBounds(340, 585, 120, 60);
        btne.setBounds(560, 585, 120, 60);
        btnb.setBounds(780, 585, 120, 60);
        btns.setBounds(1000, 585, 120, 60);

        Id.setFont(FUENTES_SECUNDARIOS);
        Nombre.setFont(FUENTES_SECUNDARIOS);
        Usuario.setFont(FUENTES_SECUNDARIOS);
        Contrasena.setFont(FUENTES_SECUNDARIOS);
        Tipo.setFont(FUENTES_SECUNDARIOS);

    }
}

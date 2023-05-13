/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.ControladorVistaLogin;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.ToolTipManager;

/**
 *
 * @author Jesus Santos 221341606
 */
public class VistaPantallaPrincipal extends JFrame implements interfaces.Fuentes {

    JPanel PanelArriba = new JPanel();
    JPanel PanelCentral = new JPanel();
    String msj = ControladorVistaLogin.nam;
    String tmsj = ControladorVistaLogin.tip;
    JLabel Bienvenida = new JLabel(" Bienvenido: " + msj);
    JLabel Tipo = new JLabel(tmsj);
    int is = 45;

    private ImageIcon Melon = new ImageIcon(getClass().getResource("/imagenes/melon.png"));
    private ImageIcon MelonTam = new ImageIcon(Melon.getImage().getScaledInstance(500, 500, Image.SCALE_DEFAULT));
    public JLabel MelonL = new JLabel(MelonTam);

    private ImageIcon ImIcon = new ImageIcon(getClass().getResource("/imagenes/account.png"));
    private ImageIcon ImIconRedimensionado = new ImageIcon(ImIcon.getImage().getScaledInstance(is, is, Image.SCALE_DEFAULT));
    public JLabel LblUsuario = new JLabel(ImIconRedimensionado);

    private ImageIcon Log = new ImageIcon(getClass().getResource("/imagenes/logout.png"));
    private ImageIcon logR = new ImageIcon(Log.getImage().getScaledInstance(is, is, Image.SCALE_DEFAULT));
    public JLabel LblLog = new JLabel(logR);

    private ImageIcon carr = new ImageIcon(getClass().getResource("/imagenes/carr.png"));
    private ImageIcon carrRedimensionado = new ImageIcon(carr.getImage().getScaledInstance(is, is, Image.SCALE_DEFAULT));
    public JLabel LblCarr = new JLabel(carrRedimensionado);

    private ImageIcon min = new ImageIcon(getClass().getResource("/imagenes/min.png"));
    private ImageIcon minRedimensionado = new ImageIcon(min.getImage().getScaledInstance(is, is, Image.SCALE_DEFAULT));
    public JLabel Lblmin = new JLabel(minRedimensionado);

    private ImageIcon close = new ImageIcon(getClass().getResource("/imagenes/close.png"));
    private ImageIcon closeRedimensionado = new ImageIcon(close.getImage().getScaledInstance(is, is, Image.SCALE_DEFAULT));
    public JLabel Lblclose = new JLabel(closeRedimensionado);
    ImageIcon ImFavicon = new ImageIcon(getClass().getResource("/imagenes/favicon.png"));

    public VistaPantallaPrincipal() {
        configuracion();
        etiquetas();
    }

    private void configuracion() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setSize(screenSize.width, screenSize.height);

        this.setExtendedState(MAXIMIZED_BOTH);
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());
        this.getContentPane().setBackground(new java.awt.Color(241, 195, 91));
        this.setUndecorated(true);
        this.setAlwaysOnTop(true);
        this.setIconImage(ImFavicon.getImage());
    }

    private void etiquetas() {
        Bienvenida.setFont(FUENTES_TITULOS);
        //PanelCentral.setBackground(new java.awt.Color(247, 221, 161)); // fondo central
        PanelArriba.setBackground(new java.awt.Color(235, 196, 21));
        this.add(PanelArriba, BorderLayout.NORTH);
        PanelArriba.setLayout(new GridLayout(1, 10));
        this.add(PanelCentral, BorderLayout.CENTER);

        PanelCentral.add(MelonL);
        PanelCentral.add(Bienvenida);
        Tipo.setFont(FUENTES_SECUNDARIOS);
        PanelArriba.add(Tipo);

        if (tmsj.equalsIgnoreCase("GERENTE")||tmsj.equalsIgnoreCase("ADMINISTRADOR")) {
            PanelArriba.add(LblUsuario);
        }
        
        PanelArriba.add(LblCarr);
        LblCarr.setToolTipText("Registrar Ventas");

        PanelArriba.add(LblLog);
        LblLog.setToolTipText("Cerrar Sesion");
        PanelArriba.add(Lblmin);
        PanelArriba.add(Lblclose);
        Lblclose.setToolTipText("Salir");
        ToolTipManager.sharedInstance().setInitialDelay(500); // Milisegundos

    }

}

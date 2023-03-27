/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Jesus Santos 221341606
 */
public class VistaLogin extends JFrame {

    public JPasswordField TxtPassword = new JPasswordField();
    public JTextField TxtUsuario = new JTextField();
    public JCheckBox Ch = new JCheckBox("Recuerdame");

    private ImageIcon ImIcon = new ImageIcon(getClass().getResource("/imagenes/account.png"));
    private ImageIcon ImIconRedimensionado = new ImageIcon(ImIcon.getImage().getScaledInstance(32, 32, Image.SCALE_DEFAULT));
    public JLabel LblUsuario = new JLabel(ImIconRedimensionado);

    private ImageIcon ImIconC = new ImageIcon(getClass().getResource("/imagenes/candado.png"));
    private ImageIcon ImIconRedimensionadoc = new ImageIcon(ImIconC.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));
    public JLabel LblPassword = new JLabel(ImIconRedimensionadoc);

    private ImageIcon Melon = new ImageIcon(getClass().getResource("/imagenes/melon.png"));
    private ImageIcon MelonTam = new ImageIcon(Melon.getImage().getScaledInstance(180, 180, Image.SCALE_DEFAULT));
    public JLabel MelonL = new JLabel(MelonTam);

    private ImageIcon Ojo1 = new ImageIcon(getClass().getResource("/imagenes/hide.png"));
    private ImageIcon Ojo1Tam = new ImageIcon(Ojo1.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
    public JLabel OjoLbl = new JLabel(Ojo1Tam);

    public JLabel Titulo = new JLabel("Melon");
    public JButton BtnLog = new JButton("Login");

    ImageIcon ImFavicon = new ImageIcon(getClass().getResource("/imagenes/favicon.png"));

    public VistaLogin() {
        configuracion();
        etiquetas();

    }

    private void configuracion() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(400, 600);
        this.setTitle("Iniciar Sesion");
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.getContentPane().setBackground(new java.awt.Color(241, 195, 91));
        this.setIconImage(ImFavicon.getImage());
        this.setResizable(false);
        this.setAlwaysOnTop(true);
    }

    private void etiquetas() {
        int ajuste = 80;
        int Escala = 50;
        Ch.setBounds(100, 275 + ajuste, 100, 40);
        Ch.setBackground(new java.awt.Color(0, 0, 0, 0));
        Ch.setOpaque(false);
        Ch.setBackground(new Color(0, 0, 0, 0));
        Ch.setForeground(Color.BLACK);
        Ch.setBackground(new Color(0, 0, 0, 0));

        //Para Ingresar datos
        this.add(Ch);
        TxtUsuario.setBounds(100, 200 + ajuste, 250, 35);
        this.add(TxtUsuario);
        TxtPassword.setBounds(100, 240 + ajuste, 200, 35);
        //para mostrarla we TxtPassword.setEchoChar((char) 0);
        this.add(TxtPassword);

        //Para los Icons
        LblUsuario.setBounds(40, 200 + ajuste, 40, 40);
        this.add(LblUsuario);
        LblPassword.setBounds(40, 240 + ajuste, 40, 40);
        this.add(LblPassword);

        MelonL.setBounds(110, 20, 180, 180);
        this.add(MelonL);

        BtnLog.setBounds(200, 280 + ajuste, 100, 30);
        this.add(BtnLog);

        OjoLbl.setBounds(305, 242 + ajuste, 30, 30);
        this.add(OjoLbl);
       
        Titulo.setBounds(100, 140 + ajuste, 200, 50);
        Titulo.setFont(new Font("Verdana", 1, Escala));

        Titulo.setForeground(Color.BLACK);
        this.add(Titulo);

    }

}

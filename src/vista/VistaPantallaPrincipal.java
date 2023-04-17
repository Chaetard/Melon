/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import modelo.ModeloUsuario;

/**
 *
 * @author Jesus Santos 221341606
 */
public class VistaPantallaPrincipal extends JFrame {

   
    
    private ImageIcon ImIcon = new ImageIcon(getClass().getResource("/imagenes/account.png"));
    private ImageIcon ImIconRedimensionado = new ImageIcon(ImIcon.getImage().getScaledInstance(32, 32, Image.SCALE_DEFAULT));
    public JLabel LblUsuario = new JLabel(ImIconRedimensionado);

    private ImageIcon carr = new ImageIcon(getClass().getResource("/imagenes/carr.png"));
    private ImageIcon carrRedimensionado = new ImageIcon(carr.getImage().getScaledInstance(32, 32, Image.SCALE_DEFAULT));
    public JLabel LblCarr = new JLabel(carrRedimensionado);

    private ImageIcon min = new ImageIcon(getClass().getResource("/imagenes/min.png"));
    private ImageIcon minRedimensionado = new ImageIcon(min.getImage().getScaledInstance(32, 32, Image.SCALE_DEFAULT));
    public JLabel Lblmin = new JLabel(minRedimensionado);

    private ImageIcon close = new ImageIcon(getClass().getResource("/imagenes/close.png"));
    private ImageIcon closeRedimensionado = new ImageIcon(close.getImage().getScaledInstance(32, 32, Image.SCALE_DEFAULT));
    public JLabel Lblclose = new JLabel(closeRedimensionado);

    public VistaPantallaPrincipal() {
        configuracion();
        etiquetas();
    }

    private void configuracion() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(854, 480);
        this.setTitle("Pantalla Principal"  );
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.getContentPane().setBackground(new java.awt.Color(241, 195, 91));
        this.setResizable(false);
        this.setAlwaysOnTop(true);
    }

    private void etiquetas() {
        LblUsuario.setBounds(10, 5, 60, 60);
        this.add(LblUsuario);
        LblCarr.setBounds(10, 70, 60, 60);
        this.add(LblCarr);
        Lblmin.setBounds(10, 135, 60, 60);
        this.add(Lblmin);
        Lblclose.setBounds(10, 200, 60, 60);
        this.add(Lblclose);
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import modelo.ConsultasUsuario;
import modelo.ModeloUsuario;
import vista.VistaLogin;
import vista.VistaPantallaPrincipal;

/**
 *
 * @author Jesus Santos 221341606
 */
public class ControladorVistaLogin implements MouseListener, KeyListener {

    VistaLogin VL;
    ModeloUsuario ModeloUsuario;
    ConsultasUsuario ConsultasUsuario = new ConsultasUsuario();
    public ImageIcon Ojo2 = new ImageIcon(getClass().getResource("/imagenes/view.png"));
    public ImageIcon Ojo2Tam = new ImageIcon(Ojo2.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));

    public ImageIcon Ojo1 = new ImageIcon(getClass().getResource("/imagenes/hide.png"));
    public ImageIcon Ojo1Tam = new ImageIcon(Ojo1.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));

    public static String nam;
    public static String tip;

    public ControladorVistaLogin(VistaLogin VL, ModeloUsuario ModeloUsuario) {
        this.VL = VL;
        this.ModeloUsuario = ModeloUsuario;
        this.VL.setVisible(true);

        oyentes();

    }

    private String encriptarPassword(String Password) throws NoSuchAlgorithmException {
        MessageDigest MD = MessageDigest.getInstance("MD5");
        MD.update(Password.getBytes(), 0, Password.length());
        return new BigInteger(1, MD.digest()).toString(16);
    }

    public boolean camposValidos() {
        if (VL.TxtUsuario.getText().isEmpty() || VL.TxtPassword.getPassword().length == 0) {
            return false;
        } else {
            return true;
        }
    }

    private void llenarModeloConCampos() throws NoSuchAlgorithmException {

        ModeloUsuario.setUsuario(VL.TxtUsuario.getText());

        String PasswordSinEncriptar = new String(VL.TxtPassword.getPassword());
        String passEncriptado = encriptarPassword(PasswordSinEncriptar);
        System.out.println(encriptarPassword(PasswordSinEncriptar));
        ModeloUsuario.setPassword(passEncriptado);
        ModeloUsuario.setNombre("");
        ModeloUsuario.setTipo("");

    }

    private void BuscarUsuarioPassword() throws NoSuchAlgorithmException {
        if (camposValidos() == true) {
            llenarModeloConCampos();
            if (ConsultasUsuario.buscarLogin(ModeloUsuario) == true) {
                JOptionPane.showMessageDialog(VL, "Bienvenido: " + ModeloUsuario.getNombre(), "Tipo: " + ModeloUsuario.getTipo(), 1);
                nam = ModeloUsuario.getNombre();
                tip = ModeloUsuario.getTipo();
                VL.dispose();
                
                
                VistaPantallaPrincipal vistaPantallaPrincipal = new VistaPantallaPrincipal();
                ControladorVistaPantallaPrincipal ControladorVistaPantallaPrincipal;
                ControladorVistaPantallaPrincipal = new ControladorVistaPantallaPrincipal(vistaPantallaPrincipal);

            } else {
                JOptionPane.showMessageDialog(VL, "Usuario o Password Incorrectos");
                VL.TxtUsuario.setBackground(Color.red);
                VL.TxtUsuario.setBackground(new java.awt.Color(255, 26, 26));
                VL.TxtPassword.setBackground(new java.awt.Color(255, 26, 26));
            }
        } else {
            JOptionPane.showMessageDialog(VL, "Debes colocar texto en los campos" + "Usuario y Password");
            VL.TxtPassword.setBackground(new java.awt.Color(255, 26, 26));
            VL.TxtUsuario.setBackground(new java.awt.Color(255, 26, 26));
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == VL.BtnLog) {
            try {
                BuscarUsuarioPassword();
            } catch (NoSuchAlgorithmException ex) {
                Logger.getLogger(ControladorVistaLogin.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (e.getSource() == VL.TxtUsuario || e.getSource() == VL.TxtPassword) {
            VL.TxtUsuario.setBackground(Color.WHITE);
            VL.TxtUsuario.setBackground(Color.WHITE);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getSource() == VL.OjoLbl) {
            VL.OjoLbl.setIcon(Ojo2Tam);
            VL.TxtPassword.setEchoChar((char) 0);

        }

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (e.getSource() == VL.OjoLbl) {
            VL.OjoLbl.setIcon(Ojo1Tam);
            VL.TxtPassword.setEchoChar('\u2022');
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    private void oyentes() {
        VL.OjoLbl.addMouseListener(this);

        VL.BtnLog.addMouseListener(this);

        VL.TxtUsuario.addKeyListener(this);

        VL.TxtPassword.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    try {
                        BuscarUsuarioPassword();
                    } catch (NoSuchAlgorithmException ex) {
                        Logger.getLogger(ControladorVistaLogin.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });
    }

    @Override
    public void keyTyped(KeyEvent e) {
        if (e.getSource() == VL.TxtUsuario || e.getSource() == VL.TxtPassword) {
            VL.TxtUsuario.setBackground(Color.WHITE);
            VL.TxtPassword.setBackground(Color.WHITE);
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {

            if (e.getSource() == VL.TxtUsuario) {
                VL.TxtPassword.requestFocus();
            }
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

}

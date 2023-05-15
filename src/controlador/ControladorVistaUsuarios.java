/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.Color;
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
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import modelo.ConsultaUsuarioConf;
import modelo.ModeloUsuarioConf;
import vista.DoneVista;
import vista.VistaUsuarios;

/**
 *
 * @author Jesus Santos 221341606
 */
public class ControladorVistaUsuarios implements MouseListener, KeyListener {

    VistaUsuarios VU;
    ModeloUsuarioConf ModeloUsuarioConf;
    ConsultaUsuarioConf consultaUsuarioConf = new ConsultaUsuarioConf();

    public ControladorVistaUsuarios(VistaUsuarios VU, ModeloUsuarioConf ModeloUsuarioConf) {
        this.VU = VU;
        this.ModeloUsuarioConf = ModeloUsuarioConf;
        this.VU.setVisible(true);
        oyentes();
    }

    private void oyentes() {

        VU.btng.addMouseListener(this);
        VU.btna.addMouseListener(this);
        VU.btne.addMouseListener(this);
        VU.btnb.addMouseListener(this);
        VU.btns.addMouseListener(this);

        VU.Id.addKeyListener(this);
        VU.Nombre.addKeyListener(this);
        VU.Usuario.addKeyListener(this);
        VU.Contrasena.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    if (e.getSource() == VU.Contrasena) {
                        if (campoVacio(VU.Contrasena.getText(), " NOMBRE", VU.Contrasena) == false) {

                        } else {
                            if (validarLongitud(VU.Contrasena.getText(), 11, VU.Contrasena) == true) {
                                VU.Tipo.requestFocus();
                            }
                        }

                    }

                }
            }
        });
        VU.Tipo.addKeyListener(this);

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == VU.btng) {

            validarCampoId();
            try {
                AgregarCamposUsuario();
            } catch (NoSuchAlgorithmException ex) {
                Logger.getLogger(ControladorVistaUsuarios.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (e.getSource() == VU.btna) {
            validarCampoId();
            try {
                ActualizarCamposUsuario();
            } catch (NoSuchAlgorithmException ex) {
                Logger.getLogger(ControladorVistaUsuarios.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (e.getSource() == VU.btne) {

            EliminarCamposUsuarios();
        }
        if (e.getSource() == VU.btnb) {
            validarCampoId();
            BuscarCamposUsuarios();
        }
        if (e.getSource() == VU.btns) {
            int opcion = JOptionPane.showConfirmDialog(VU, "En verdad quieres salir", "Alerta", 0, 3);
            if (opcion == 0) {

                VU.dispose();
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    private void BuscarCamposUsuarios() {

        if (validarCampoId() == true) {
            llenarId();
            if (consultaUsuarioConf.buscar(ModeloUsuarioConf) == true) {
                done();
                VU.Id.setText(String.valueOf(ModeloUsuarioConf.getId()));
                VU.Nombre.setText(String.valueOf(ModeloUsuarioConf.getNombre()));
                VU.Contrasena.setText("");
                VU.Usuario.setText(String.valueOf(ModeloUsuarioConf.getUsuario()));
                VU.Tipo.setText(String.valueOf(ModeloUsuarioConf.getTipo()));
            } else {
                JOptionPane.showMessageDialog(VU, " ERROR " + "Ese Usuario o Nomina No Existe");
            }
        }

    }

    private void EliminarCamposUsuarios() {
        llenarId();

        consultaUsuarioConf.eliminar(ModeloUsuarioConf);
        if (consultaUsuarioConf.eliminar(ModeloUsuarioConf) == true) {
            done();
            limpiarDatos();
        }

    }

    private void ActualizarCamposUsuario() throws NoSuchAlgorithmException {

        if (validarCampoId() == true) {
            llenarModeloBuscar();
            consultaUsuarioConf.modificar(ModeloUsuarioConf);
            if (consultaUsuarioConf.modificar(ModeloUsuarioConf) == true) {
                done();
                limpiarDatos();
            }
        }
    }

    private void AgregarCamposUsuario() throws NoSuchAlgorithmException {

        if (validarCampoId() == true) {
            llenarModeloBuscar();
            if (consultaUsuarioConf.insertar(ModeloUsuarioConf) == true) {
                done();
                limpiarDatos();
            } else {
                JOptionPane.showMessageDialog(VU, " ERROR " + " Ese Usuario o Nomina ah sido Registrado");
            }
        }

    }

    private boolean validarCampoId() {
        if (VU.Id.getText().isEmpty() && VU.Usuario.getText().isEmpty()) {
            JOptionPane.showMessageDialog(VU, " ERROR " + " Debes Ingresar Un Usuario o Nomina");
            return false;

        } else {
            return true;

        }

    }

    public void llenarModeloBuscar() throws NoSuchAlgorithmException {
        String id_empleado = VU.Id.getText();
        int empleado = Integer.parseInt(id_empleado);
        ModeloUsuarioConf.setId(empleado);

        String PasswordSinEncriptar = new String(VU.Contrasena.getPassword());
        String passEncriptado = encriptarPassword(PasswordSinEncriptar);
        System.out.println(encriptarPassword(PasswordSinEncriptar));
        ModeloUsuarioConf.setPassword(passEncriptado);

        ModeloUsuarioConf.setNombre(VU.Nombre.getText());
        ModeloUsuarioConf.setUsuario(VU.Usuario.getText());
        ModeloUsuarioConf.setTipo(VU.Tipo.getText());
    }

    private void llenarId() {
        if (VU.Id.getText().isEmpty()) {
            ModeloUsuarioConf.setUsuario(VU.Usuario.getText());

        } else {
            String id_empleado = VU.Id.getText();
            int empleado = Integer.parseInt(id_empleado);
            ModeloUsuarioConf.setId(empleado);
        }

    }

    private void done() {
        DoneVista doneVista = new DoneVista();
        ControladorDoneVista controladorDoneVista = new ControladorDoneVista(doneVista);
    }

    private String encriptarPassword(String Password) throws NoSuchAlgorithmException {
        MessageDigest MD = MessageDigest.getInstance("MD5");
        MD.update(Password.getBytes(), 0, Password.length());
        return new BigInteger(1, MD.digest()).toString(16);
    }

    private void limpiarDatos() {
        VU.Id.setText("");
        VU.Nombre.setText("");
        VU.Contrasena.setText("");
        VU.Usuario.setText("");
        VU.Tipo.setText("");
    }



    @Override
    public void keyTyped(KeyEvent e) {
        if (e.getSource() == VU.Id || e.getSource() == VU.Nombre || e.getSource() == VU.Usuario || e.getSource() == VU.Contrasena || e.getSource() == VU.Tipo) {
            VU.Id.setBackground(Color.WHITE);
            VU.Nombre.setBackground(Color.WHITE);
            VU.Usuario.setBackground(Color.WHITE);
            VU.Contrasena.setBackground(Color.WHITE);
            VU.Tipo.setBackground(Color.WHITE);
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {

        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            if (e.getSource() == VU.Id) {
                if (campoVacio(VU.Id.getText(), " ID NOMINA", VU.Id) == false) {

                } else {
                    if (validaCampoEntero(VU.Id.getText(), 11, VU.Id) == true) {
                        VU.Nombre.requestFocus();
                    }
                }

            }
        }
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            if (e.getSource() == VU.Nombre) {
                if (campoVacio(VU.Nombre.getText(), " NOMBRE", VU.Nombre) == false) {

                } else {
                    if (validarLongitud(VU.Nombre.getText(), 50, VU.Nombre) == true) {
                        VU.Usuario.requestFocus();
                    }
                }

            }
        }

        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            if (e.getSource() == VU.Usuario) {
                if (campoVacio(VU.Usuario.getText(), " USUARIO", VU.Usuario) == false) {

                } else {
                    if (validarLongitud(VU.Usuario.getText(), 20, VU.Usuario) == true) {
                        VU.Contrasena.requestFocus();
                    }
                }

            }
        }

        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            if (e.getSource() == VU.Tipo) {
                if (campoVacio(VU.Tipo.getText(), " TIPO", VU.Tipo) == false) {

                } else {
                    if (validarLongitud(VU.Tipo.getText(), 20, VU.Tipo) == true) {

                    }
                }

            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    private boolean validaCampoEntero(String Cadena, int longitud, JTextField jtf) {
        if (Cadena.matches("[0-9,.]+") && Cadena.length() < longitud + 1) {
            return true;
        } else {
            JOptionPane.showMessageDialog(VU, "Solo Numeros validos con una longitud no mayor a: " + longitud);
            jtf.setBackground(new java.awt.Color(255, 26, 26));

            return false;
        }
    }

    private boolean campoVacio(String Cadena, String Tipo, JTextField tipode) {
        if (Cadena.isEmpty()) {
            JOptionPane.showMessageDialog(VU, "Debes Ingresar Datos en el Campo" + Tipo);
            tipode.setBackground(new java.awt.Color(255, 26, 26));
            return false;
        } else {
            return true;
        }
    }

    private boolean validarLongitud(String Cadena, int longitud, JTextField jtf) {
        if (Cadena.length() < longitud - 1) {
            return true;
        } else {
            JOptionPane.showMessageDialog(VU, "Solo una longitud no mayor a: " + longitud);
            jtf.setBackground(new java.awt.Color(255, 26, 26));

            return false;
        }
    }
}

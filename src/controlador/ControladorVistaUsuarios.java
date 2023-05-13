/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.ConsultaUsuarioConf;
import modelo.ModeloUsuarioConf;
import vista.DoneVista;
import vista.VistaUsuarios;

/**
 *
 * @author Jesus Santos 221341606
 */
public class ControladorVistaUsuarios implements MouseListener {

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
            validarCampoId();
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
        llenarId();
        if (validarCampoId() == true) {
            consultaUsuarioConf.buscar(ModeloUsuarioConf);
            if (consultaUsuarioConf.buscar(ModeloUsuarioConf) == true) {
                done();
                VU.Id.setText(String.valueOf(ModeloUsuarioConf.getId()));
                VU.Nombre.setText(String.valueOf(ModeloUsuarioConf.getNombre()));
                VU.Contrasena.setText(String.valueOf(ModeloUsuarioConf.getPassword()));
                VU.Usuario.setText(String.valueOf(ModeloUsuarioConf.getUsuario()));
                VU.Tipo.setText(String.valueOf(ModeloUsuarioConf.getTipo()));
            }
        }

    }

    private void EliminarCamposUsuarios() {
        llenarId();

        if (validarCampoId() == true) {
            consultaUsuarioConf.eliminar(ModeloUsuarioConf);
            if (consultaUsuarioConf.eliminar(ModeloUsuarioConf) == true) {
                done();
                impiarId();
            }
        }
    }

    private void ActualizarCamposUsuario() throws NoSuchAlgorithmException {
        llenarModeloBuscar();

        if (validarCampoId() == true) {
            consultaUsuarioConf.modificar(ModeloUsuarioConf);
            if (consultaUsuarioConf.modificar(ModeloUsuarioConf) == true) {
                done();
                limpiarDatos();
            }
        }
    }

    private void AgregarCamposUsuario() throws NoSuchAlgorithmException {
        llenarModeloBuscar();
        if (validarCampoId() == true) {
            if (consultaUsuarioConf.insertar(ModeloUsuarioConf) == true) {
                done();
                limpiarDatos();
            }
        }

    }

    private boolean validarCampoId() {
        if (VU.Id.getText().isEmpty()) {
            JOptionPane.showMessageDialog(VU, "El campo id_empleado no debe estar vacío.");

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
        String id_empleado = VU.Id.getText();
        int empleado = Integer.parseInt(id_empleado);
        ModeloUsuarioConf.setId(empleado);
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

    private void impiarId() {
        VU.Id.setText("");
    }

}

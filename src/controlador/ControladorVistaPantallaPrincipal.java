/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.Cursor;
import java.awt.Frame;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import modelo.ModeloCliente;
import modelo.ModeloEmpleado;
import modelo.ModeloProveedor;
import modelo.ModeloUsuario;
import modelo.ModeloUsuarioConf;
import modelo.ModeloVenta;
import vista.VistaClientes;
import vista.VistaEmpleados;
import vista.VistaLogin;
import vista.VistaPantallaPrincipal;
import vista.VistaProveedor;
import vista.VistaUsuarios;
import vista.VistaVentas;

/**
 *
 * @author Jesus Santos 221341606
 */
public class ControladorVistaPantallaPrincipal implements MouseListener {

    VistaPantallaPrincipal VPP;

    public ControladorVistaPantallaPrincipal(VistaPantallaPrincipal VPP) {

        this.VPP = VPP;
        this.VPP.setVisible(true);
        oyentes();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == VPP.Lblclose) {
            int opc = JOptionPane.showConfirmDialog(VPP, "¿Deseas Salir?", "Salir", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (opc == 0) {
                System.exit(0);
            }

        }
        if (e.getSource() == VPP.Lblmin) {
            VPP.setExtendedState(Frame.ICONIFIED);
        }
        if (e.getSource() == VPP.LblLog) {
            int opc = JOptionPane.showConfirmDialog(VPP, "¿Deseas Cerrar Sesion?", "Cerrar Sesion", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (opc == 0) {
                VPP.dispose();
                ModeloUsuario ModeloUsuario = new ModeloUsuario();
                VistaLogin VS = new VistaLogin();
                ControladorVistaLogin controladorVistaLogin = new ControladorVistaLogin(VS, ModeloUsuario);

            } else if (e.getSource() == VPP.Lblmin) {
                VPP.setExtendedState(Frame.ICONIFIED);
            }
        }
        if (e.getSource() == VPP.LblCarr) {

            VistaVentas VV = new VistaVentas();
            ModeloVenta ModeloVenta = new ModeloVenta();
            ControladorVistaVentas controladorVistaVentas = new ControladorVistaVentas(VV, ModeloVenta);
        }
        if (e.getSource() == VPP.LblUsuario) {
            VistaUsuarios vistaUsuarios = new VistaUsuarios();
            ModeloUsuarioConf ModeloUsuarioConf = new ModeloUsuarioConf();
            ControladorVistaUsuarios controladorVistaUsuarios = new ControladorVistaUsuarios(vistaUsuarios, ModeloUsuarioConf);
        }
        if (e.getSource() == VPP.Lblcust) {
            VistaClientes vistaClientes = new VistaClientes();
            ModeloCliente modeloCliente = new ModeloCliente();
            ControladorVistaClientes controladorVistaClientes = new ControladorVistaClientes(vistaClientes, modeloCliente);
        }
        if (e.getSource() == VPP.LblParcel) {
            VistaProveedor vistaProveedor = new VistaProveedor();
            ModeloProveedor modeloProveedor = new ModeloProveedor();
            ControladorVistaProveedor controladorVistaProveedor = new ControladorVistaProveedor(vistaProveedor, modeloProveedor);
        }
        if (e.getSource() == VPP.Lblemp) {
            VistaEmpleados vistaEmpleados = new VistaEmpleados();
            ModeloEmpleado modeloEmpleado = new ModeloEmpleado();
            ControladorVistaEmpleados controladorVistaEmpleados = new ControladorVistaEmpleados(vistaEmpleados, modeloEmpleado);
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
        if (e.getSource() == VPP.LblCarr) {
            VPP.LblCarr.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        }
        if (e.getSource() == VPP.LblLog) {
            VPP.LblLog.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        }
        if (e.getSource() == VPP.LblUsuario) {
            VPP.LblUsuario.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        }
        if (e.getSource() == VPP.Lblclose) {
            VPP.Lblclose.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        }
        if (e.getSource() == VPP.Lblmin) {
            VPP.Lblmin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    private void oyentes() {
        VPP.Lblclose.addMouseListener(this);
        VPP.Lblmin.addMouseListener(this);
        VPP.LblLog.addMouseListener(this);
        VPP.LblUsuario.addMouseListener(this);
        VPP.LblCarr.addMouseListener(this);
        VPP.Lblcust.addMouseListener(this);
        VPP.LblParcel.addMouseListener(this);
        VPP.Lblemp.addMouseListener(this);
    }
}

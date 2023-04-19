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
import modelo.ModeloUsuario;
import vista.VistaLogin;
import vista.VistaPantallaPrincipal;

/**
 *
 * @author Jesus Santos 221341606
 */
public class ControladorVistaPantallaPrincipal implements MouseListener{
    VistaPantallaPrincipal VPP;
    
    public ControladorVistaPantallaPrincipal(VistaPantallaPrincipal VPP){
       
        this.VPP = VPP;
        this.VPP.setVisible(true);
         oyentes();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource()==VPP.Lblclose) {
            int opc = JOptionPane.showConfirmDialog(VPP, "¿Deseas Salir?", "Salir", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
            if (opc==0) {
                System.exit(0);
            }
            
        }
        if(e.getSource()==VPP.Lblmin){
               VPP.setExtendedState(Frame.ICONIFIED);
            }
        if (e.getSource()==VPP.LblLog) {
            int opc = JOptionPane.showConfirmDialog(VPP, "¿Deseas Cerrar Sesion?", "Cerrar Sesion", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
            if (opc==0) {
                VPP.dispose();
                 ModeloUsuario ModeloUsuario = new ModeloUsuario();
            VistaLogin VS = new VistaLogin();
            ControladorVistaLogin controladorVistaLogin = new ControladorVistaLogin(VS, ModeloUsuario);
            }else if(e.getSource()==VPP.Lblmin){
               VPP.setExtendedState(Frame.ICONIFIED);
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
    }
}

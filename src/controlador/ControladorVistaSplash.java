/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import vista.VistaLogin;
import vista.VistaSplash;

/**
 *
 * @author Jesus Santos 221341606
 */
public class ControladorVistaSplash implements MouseListener, MouseMotionListener{

    VistaSplash VS;
    int x, y; //Variables para detectar coordenadas del label

    public ControladorVistaSplash(VistaSplash VS) {
        this.VS = VS;
        this.VS.setVisible(true);
        oyentes();
        dormirMatarSplash(5);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getSource() == VS.LblSplash) {
            x = e.getX();
            y = e.getY();
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if (e.getSource() == VS.LblSplash) {
            VS.LblSplash.setCursor(Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR));

        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if (e.getSource() == VS.LblSplash) {
            VS.setLocation(VS.getLocation().x + e.getX() - x,
                    VS.getLocation().y + e.getY() - y);
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
    //para que no se cierre al usar el whell
    /* @Override          
    public void mouseWheelMoved(MouseWheelEvent e) {
         if (e.getSource() == VS.LblSplash) {
             VS.dispose();
         }
    }*/

    private void oyentes() {
        VS.LblSplash.addMouseListener(this);
        VS.LblSplash.addMouseMotionListener(this);
       // para el whell VS.LblSplash.addMouseWheelListener(this);
    }

    private void dormirMatarSplash(int i) {
        try {
            Thread.sleep(i * 1000);
        } catch (InterruptedException ex) {
            System.out.println("Error " + ex);
        }finally{
         VS.dispose();
         
            VistaLogin VS = new VistaLogin();
            ControladorVistaLogin controladorVistaLogin = new ControladorVistaLogin(VS);
        }
    }

   

}

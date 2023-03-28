/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import vista.VistaLogin;

/**
 *
 * @author Jesus Santos 221341606
 */
public class ControladorVistaLogin implements MouseListener {

    VistaLogin VL;
    public ImageIcon Ojo2 = new ImageIcon(getClass().getResource("/imagenes/view.png"));
    public ImageIcon Ojo2Tam = new ImageIcon(Ojo2.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));

    public ImageIcon Ojo1 = new ImageIcon(getClass().getResource("/imagenes/hide.png"));
    public ImageIcon Ojo1Tam = new ImageIcon(Ojo1.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));

    public ControladorVistaLogin(VistaLogin VL) {
        this.VL = VL;
        this.VL.setVisible(true);
        oyentes();
    }

    @Override
    public void mouseClicked(MouseEvent e) {

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
        VL.MelonL.addMouseListener(this);
    }

}

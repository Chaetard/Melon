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
import javax.swing.JOptionPane;
import modelo.ConsultasUsuario;
import modelo.ModeloUsuario;
import vista.VistaLogin;
import vista.VistaPantallaPrincipal;

/**
 *
 * @author Jesus Santos 221341606
 */
public class ControladorVistaLogin implements MouseListener {

    VistaLogin VL;
    ModeloUsuario ModeloUsuario;
    ConsultasUsuario ConsultasUsuario = new ConsultasUsuario();
     public ImageIcon Ojo2 = new ImageIcon(getClass().getResource("/imagenes/view.png"));
    public ImageIcon Ojo2Tam = new ImageIcon(Ojo2.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));

    public ImageIcon Ojo1 = new ImageIcon(getClass().getResource("/imagenes/hide.png"));
    public ImageIcon Ojo1Tam = new ImageIcon(Ojo1.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));

    public ControladorVistaLogin(VistaLogin VL, ModeloUsuario ModeloUsuario) {
        this.VL = VL;
        this.ModeloUsuario = ModeloUsuario;
        this.VL.setVisible(true);
        oyentes();
    }
    public boolean camposValidos(){
        if (VL.TxtUsuario.getText().isEmpty() || VL.TxtPassword.getPassword().length==0) 
            return false;
        else
            return true;
    }
    private void llenarModeloConCampos(){
        ModeloUsuario.setUsuario(VL.TxtUsuario.getText());
        ModeloUsuario.setPassword(new String (VL.TxtPassword.getPassword()));
        ModeloUsuario.setNombre("");
        ModeloUsuario.setTipo("");
    }
    private void BuscarUsuarioPassword(){
        if(camposValidos()==true){
            llenarModeloConCampos();
            if (ConsultasUsuario.buscarLogin(ModeloUsuario)==true) {
                JOptionPane.showMessageDialog(VL,"Bienvenido: " + ModeloUsuario.getNombre(),"Tipo: " + ModeloUsuario.getTipo(),1);
                VL.dispose();
                VistaPantallaPrincipal vistaPantallaPrincipal = new VistaPantallaPrincipal();
                ControladorVistaPantallaPrincipal ControladorVistaPantallaPrincipal;
                ControladorVistaPantallaPrincipal = new ControladorVistaPantallaPrincipal(vistaPantallaPrincipal);
                
            }else{
                JOptionPane.showMessageDialog(VL,"Usuario o Password Incorrectos");
            }
        }else{
            JOptionPane.showMessageDialog(VL, "Debes colocar texto en los campos" + "Usuario y Password");
        }
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == VL.BtnLog) {
            BuscarUsuarioPassword();
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
        VL.MelonL.addMouseListener(this);
        VL.BtnLog.addMouseListener(this);
    
    }

}

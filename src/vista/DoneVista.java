/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

/**
 *
 * @author Jesus Santos 221341606
 */
import java.awt.Color;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;

/**
 *
 * @author Jesus Santos 221341606
 */
public class DoneVista extends JFrame {
   
    private ImageIcon ImSplash2 = new ImageIcon(getClass().getResource("/imagenes/done.png"));
    private ImageIcon ImIconRedimensionado = new ImageIcon(ImSplash2.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT));
    
    public JLabel LblSplash2 = new JLabel(ImIconRedimensionado);
    
    ImageIcon ImFavicon = new ImageIcon(getClass().getResource("/imagenes/favicon.png"));
    public DoneVista() { //Constructor Vacio
        configuracion();
        eiqueta();
    }
    
    private void eiqueta() {
        this.add(LblSplash2);
    }
    
    private void configuracion() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(ImSplash2.getIconWidth(), ImSplash2.getIconHeight());
        this.setLocationRelativeTo(null);
        //Remove the decorate of JFrame
        this.setUndecorated(true);
        //Remove the background
        this.setBackground(new Color(0, 0, 0, 0));
        this.setAlwaysOnTop(true);
         this.setIconImage(ImFavicon.getImage());
    }
    
}

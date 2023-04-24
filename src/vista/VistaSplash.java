/** @DATE 03/12/2023
 */
package vista;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Jesus Santos 221341606
 */
public class VistaSplash extends JFrame {
   
    private ImageIcon ImSplash = new ImageIcon(getClass().getResource("/imagenes/splash.gif"));
    public JLabel LblSplash = new JLabel(ImSplash);
    ImageIcon ImFavicon = new ImageIcon(getClass().getResource("/imagenes/favicon.png"));
    public VistaSplash() { //Constructor Vacio
        configuracion();
        eiqueta();
    }
    
    private void eiqueta() {
        this.add(LblSplash);
    }
    
    private void configuracion() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(ImSplash.getIconWidth(), ImSplash.getIconHeight());
        this.setTitle("Melon");
        this.setLocationRelativeTo(null);
        //Remove the decorate of JFrame
        this.setUndecorated(true);
        //Remove the background
        this.setBackground(new Color(0, 0, 0, 0));
        this.setAlwaysOnTop(true);
         this.setIconImage(ImFavicon.getImage());
    }
    
}

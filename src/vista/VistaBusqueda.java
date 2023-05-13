/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import interfaces.Fuentes;
import java.awt.Dimension;
import java.awt.Frame;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author Jesus Santos 221341606
 */
public class VistaBusqueda extends JDialog  implements Fuentes{

    JLabel LblIdVenta = new JLabel("Estado de la Venta");
    public JTextField TxtId = new JTextField();
    public JButton BtnAceptar = new JButton("Aceptar");

    public JTable Tabla = new JTable();
    public JScrollPane ScrollTabla = new JScrollPane(Tabla);

    public VistaBusqueda(Frame owner, boolean modal) {
        super(owner, modal);
        configuracionInicial();
        agregarComponentes();

    }

    private void configuracionInicial() {
        this.setSize(550, 320);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setAlwaysOnTop(true);
       Tabla.setPreferredScrollableViewportSize(new Dimension(520, 200));
        Tabla.setFillsViewportHeight(true);
       
    }

    private void agregarComponentes() {

        this.add(LblIdVenta);
        this.add(TxtId);
        this.add(ScrollTabla);
        this.add(BtnAceptar);

        LblIdVenta.setFont(FUENTES_SECUNDARIOS);
        
        LblIdVenta.setBounds(10, 15, 300, 40);
        TxtId.setBounds(250, 15, 200, 40);
        ScrollTabla.setBounds(20, 70, 490, 130);
        
        BtnAceptar.setBounds(215, 230, 120, 40);
    }

}

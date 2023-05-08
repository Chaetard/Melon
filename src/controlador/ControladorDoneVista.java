/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import vista.DoneVista;

/**
 *
 * @author Jesus Santos 221341606
 */
public class ControladorDoneVista {
    DoneVista DV;

    public ControladorDoneVista(DoneVista DV) {
        this.DV = DV;
        this.DV.setVisible(true);
        doneMatar(1);
    }

    private void doneMatar(int i) {
        try {
            Thread.sleep(i * 1000);
        } catch (InterruptedException ex) {
            System.out.println("Error " + ex);
        }finally{
         DV.dispose();
        }
    }
}

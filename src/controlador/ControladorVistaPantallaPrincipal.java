/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import vista.VistaPantallaPrincipal;

/**
 *
 * @author Jesus Santos 221341606
 */
public class ControladorVistaPantallaPrincipal {
    VistaPantallaPrincipal VPP;
    
    public ControladorVistaPantallaPrincipal(VistaPantallaPrincipal VPP){
        this.VPP = VPP;
        this.VPP.setVisible(true);
    }
}

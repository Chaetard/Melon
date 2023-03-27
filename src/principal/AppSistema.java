/** @DATE 03/13/2023
 */
package principal;

import controlador.ControladorVistaSplash;
import vista.VistaSplash;

/**
 *
 * @author Jesus Santos 221341606
 */
public class AppSistema {
    public static void main(String[] args) {
        VistaSplash VS = new VistaSplash();
        ControladorVistaSplash CVS = new ControladorVistaSplash(VS);
    }
}

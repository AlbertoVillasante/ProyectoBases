
package aplicacion;

import gui.FachadaGui;
import baseDatos.FachadaBaseDatos;

/**
 *
 * @author hugo
 */
public class GestionBeneficios {

    FachadaGui fgui;
    FachadaBaseDatos fbd;

    public GestionBeneficios(FachadaGui fgui, FachadaBaseDatos fbd) {
        this.fgui = fgui;
        this.fbd = fbd;
    }
    
    public void nuevoBeneficio(){
         fgui.nuevoBeneficio();
    }
}

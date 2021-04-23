
package aplicacion;

import gui.FachadaGui;
import baseDatos.FachadaBaseDatos;
import java.util.ArrayList;

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
     public void altaPagoBeneficios(String fecha, double precio, String nombreEmpresa, int numParticipaciones){
        fbd.altaPagoBeneficios(fecha,precio,nombreEmpresa,numParticipaciones);
    }
      public ArrayList<AnunciarBeneficios> getBeneficios() {
        return fbd.getBeneficios();
    }
}

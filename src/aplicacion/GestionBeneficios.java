
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
     public void altaPagoBeneficios(String fecha, float precio, int numParticipaciones, String nombreEmpresa){
        fbd.altaPagoBeneficios(fecha,precio,numParticipaciones,nombreEmpresa);
    }
      public ArrayList<AnunciarBeneficios> getBeneficios() {
        return fbd.getBeneficios();
    }
}

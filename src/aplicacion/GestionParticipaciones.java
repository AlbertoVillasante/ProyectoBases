
package aplicacion;

import gui.FachadaGui;
import baseDatos.FachadaBaseDatos;

/**
 *
 * @author hugo
 */
public class GestionParticipaciones {

    FachadaGui fgui;
    FachadaBaseDatos fbd;

    public GestionParticipaciones(FachadaGui fgui, FachadaBaseDatos fbd) {
        this.fgui = fgui;
        this.fbd = fbd;
    }

   public void nuevasParticipaciones(EmpresaUsuario eu){
         fgui.nuevasParticipaciones(eu);
    }
   
    public void altaParticipacionesEmpresa(int participaciones, String id) {
        fbd.altaParticipacionesEmpresa(participaciones, id);
    }
    
    public void bajaParticipacionesEmpresa(int participaciones, String id) {
        fbd.bajaParticipacionesEmpresa(participaciones, id);
    }
}

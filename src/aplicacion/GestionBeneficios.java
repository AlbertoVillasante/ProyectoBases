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

    public void nuevoBeneficio(InversorUsuario iu, EmpresaUsuario eu) {
        fgui.nuevoBeneficio(iu,eu);
    }

    public void altaPagoBeneficios(String fecha, double precio, String nombreEmpresa, int numParticipaciones) {
        fbd.altaPagoBeneficios(fecha, precio, nombreEmpresa, numParticipaciones);
    }
    
    public void bajaAnuncioBeneficios(String fecha, String nombreEmpresa){
        fbd.bajaAnuncioBeneficios(fecha, nombreEmpresa);
    }

    public ArrayList<AnunciarBeneficios> getBeneficios() {
        return fbd.getBeneficios();
    }

    public float getSaldoRetenciones(String id) {
        return fbd.getSaldoRetenciones(id);
    }
    
    public int getParticipacionesRetenciones(String id) {
        return fbd.getParticipacionesRetenciones(id);
    }
}

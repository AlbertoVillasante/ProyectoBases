package aplicacion;

import gui.FachadaGui;
import baseDatos.FachadaBaseDatos;

public class GestionPrestamos {

    FachadaGui fgui;
    FachadaBaseDatos fbd;

    public GestionPrestamos(FachadaGui fgui, FachadaBaseDatos fbd) {
        this.fgui = fgui;
        this.fbd = fbd;
    }

    public void nuevoPrestamo(Ejemplar e) {
        if (e.getPrestamo().getUsuario() == null) {
            fgui.nuevoPrestamo(e);
        } else {
            fbd.nuevoPrestamo(e);
        }
    }

    public void devolverEjemplar(Integer ejemplar, String usuario, Integer libro) {
        fbd.devolverEjemplar(ejemplar, usuario, libro);
    }
    
    public Integer DiasFaltanParaVencer(Integer libro, Integer ejemplar) {
        return fbd.DiasFaltanParaVencer(libro, ejemplar);
    }
    
    public void nuevoBeneficio(){
         fgui.nuevoBeneficio();
    }
    
}

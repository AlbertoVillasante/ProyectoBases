
package aplicacion;

import baseDatos.FachadaBaseDatos;
import gui.FachadaGui;

public class GestionNoticias {

    FachadaGui fgui;
    FachadaBaseDatos fbd;

    public GestionNoticias(FachadaGui fgui, FachadaBaseDatos fbd) {
        this.fgui = fgui;
        this.fbd = fbd;
    }
    
    public void nuevaNoticia(){
        fgui.nuevaNoticia();
    }
    
    public void nuevoNoticiero(String tiponoticia){
        fgui.nuevoNoticiero(tiponoticia);
    }
    
    public void insertarNoticia(String tipo, String descripcion, String id){
        fbd.insertarNoticia(tipo, descripcion, id);
    }
    
    public java.util.List<Noticias> getNoticias(String tipo1, String tipo2, String tipo3) {
        return fbd.getNoticias(tipo1, tipo2, tipo3);
    }

}

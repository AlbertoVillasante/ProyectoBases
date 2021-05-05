/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion;

/**
 *
 * @author hugo
 */
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
    
    public void insertarNoticiaInv(String tipo, String descripcion){
        fbd.insertarNoticiaInv(tipo, descripcion);
    }
    
    public void insertarNoticiaEmpr(String tipo, String descripcion){
        fbd.insertarNoticiaEmpr(tipo, descripcion);
    }
    
    public java.util.List<Noticias> getNoticias() {
        return fbd.getNoticias();
    }

}

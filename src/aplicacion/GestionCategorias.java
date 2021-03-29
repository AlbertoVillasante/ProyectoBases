
package aplicacion;

import gui.FachadaGui;
import baseDatos.FachadaBaseDatos;

/**
 *
 * @author hugo
 */
public class GestionCategorias {

    FachadaGui fgui;
    FachadaBaseDatos fbd;

    public GestionCategorias(FachadaGui fgui, FachadaBaseDatos fbd) {
        this.fgui = fgui;
        this.fbd = fbd;
    }

    public void nuevaCategoria() {
        fgui.nuevaCategoria();
    }

    public void actualizarCategoria(Categoria c) {
        boolean selector = false;
        for (Categoria cat : fbd.consultarCategorias()) {
            if (cat.getNombre().equals(c.getNombre())) {
                selector = true;
            }
        }
        if (selector == true) {
            fbd.modificarCategoria(c);
        } else {
            fbd.insertarCategoria(c);
        }

    }

    public java.util.List<Categoria> obtenerCategoria(String nombre) {
        return fbd.consultarListaCategorias(nombre);
    }

    public void borrarCategoria(String nombre) {
        fbd.borrarCategoria(nombre);
    }
}

package aplicacion;

import gui.FachadaGui;
import baseDatos.FachadaBaseDatos;

public class GestionUsuarios {

    FachadaGui fgui;
    FachadaBaseDatos fbd;

    public GestionUsuarios(FachadaGui fgui, FachadaBaseDatos fbd) {
        this.fgui = fgui;
        this.fbd = fbd;
    }

    public Boolean comprobarAutentificacion(String idUsuario, String clave) {
        Usuario u;

        u = fbd.validarUsuario(idUsuario, clave);
        if (u != null) {
            return u.getTipoUsuario() == TipoUsuario.Administrador;
        } else {
            return false;
        }
    }

    public void nuevoUsuario() {
        fgui.nuevoUsuario();
    }

    public java.util.List<Usuario> obtenerUsuarios(String idUsuario, String nombreUsuario) {
        return fbd.consultarListaUsuarios(idUsuario, nombreUsuario);
    }

    public void actualizarUsuario(Usuario u, String id) {

        if (id == null) {
            fbd.insertarUsuario(u);
        } else {
            fbd.modificarUsuario(u, id);
        }
    }

    public void borrarUsuario(String idUsuario) {
        fbd.borrarUsuario(idUsuario);
    }

    public java.util.List<Usuario> obtenerUsuariosPrestamo(String idUsuario, String nombreUsuario) {
        return fbd.consultarListaUsuariosPrestamo(idUsuario, nombreUsuario);
    }
}

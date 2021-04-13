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

    //Comentado para que no de error
    public String comprobarAutentificacion(String idUsuario, String clave) {
        if (idUsuario.length() == 9) {
            InversorUsuario u;
            u = fbd.validarUsuario(idUsuario, clave);
            if (u != null) {
                return u.getTipo().name();
            } else {
                return "";
            }
        } else {
            EmpresaUsuario u;
            u = fbd.validarUsuarioE(idUsuario, clave);
            if (u != null) {
                return u.getTipo().name();
            } else {
                return "";
            }
        }
    }

    public void nuevoUsuario() {
        fgui.nuevoUsuario();
    }
    /*  //Comentado para que no de error
    public java.util.List<EmpresaUsuario> obtenerUsuarios(String idUsuario, String nombreUsuario) {
        return fbd.consultarListaUsuarios(idUsuario, nombreUsuario);
    }

    public void actualizarUsuario(EmpresaUsuario u, String id) {

        if (id == null) {
            fbd.insertarUsuario(u);
        } else {
            fbd.modificarUsuario(u, id);
        }
    }

    public void borrarUsuario(String idUsuario) {
        fbd.borrarUsuario(idUsuario);
    }

    public java.util.List<EmpresaUsuario> obtenerUsuariosPrestamo(String idUsuario, String nombreUsuario) {
        return fbd.consultarListaUsuariosPrestamo(idUsuario, nombreUsuario);
    }
     */
}

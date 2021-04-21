package aplicacion;

import gui.FachadaGui;
import baseDatos.FachadaBaseDatos;
import java.util.ArrayList;

public class GestionUsuarios {

    FachadaGui fgui;
    FachadaBaseDatos fbd;

    public GestionUsuarios(FachadaGui fgui, FachadaBaseDatos fbd) {
        this.fgui = fgui;
        this.fbd = fbd;
    }

    //Comentado para que no de error
    public InversorUsuario comprobarAutentificacionI(String idUsuario, String clave) {
        InversorUsuario u;

        u = fbd.validarUsuario(idUsuario, clave);
        if (u != null) {
            return u;
        } else {
            u = new InversorUsuario("", null, null, null, null, null, null, null);
            return u;
        }

    }

    public EmpresaUsuario comprobarAutentificacionE(String idUsuario, String clave) {
        EmpresaUsuario u;

        u = fbd.validarUsuarioE(idUsuario, clave);
        if (u != null) {
            return u;
        } else {
            u = new EmpresaUsuario("", null, null, null, null, null);
            return u;
        }
    }

    public void nuevoUsuario(boolean c,InversorUsuario iu, EmpresaUsuario eu) {
        fgui.nuevoUsuario(c,iu,eu);
    }

    public void nuevaSolicitud() {
        fgui.nuevaSolicitud();
    }

    public void nuevaModificacion() {
        fgui.nuevaModificacion();
    }

    public void configuracionRegulador(InversorUsuario iu, EmpresaUsuario eu) {
        fgui.configuracionRegulador(iu,eu);
    }
    
     public void nuevaEstadistica(InversorUsuario iu, EmpresaUsuario eu) {
        fgui.nuevaEstadistica(iu, eu);
    }
    
    public void actualizarComision(float comision) {
        fbd.actualizarComision(comision);
    }
    
    public void insertarUsuarioInversor(InversorUsuario u){
        fbd.insertarUsuarioInversor(u);
    }
    
    public void insertarUsuarioEmpresa(EmpresaUsuario u){
        fbd.insertarUsuarioEmpresa(u);
    }
    
    public int comprobarIdInversor(String id){
        return fbd.comprobarIdInversor(id);
    }
    
    public int comprobarIdEmpresa(String id){
        return fbd.comprobarIdEmpresa(id);
    }
    
      public ArrayList<String> getEmpresas() {
        return fbd.getEmpresas();
    }
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


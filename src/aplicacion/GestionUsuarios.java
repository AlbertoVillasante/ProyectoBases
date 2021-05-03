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

    public void nuevoUsuario(boolean c, InversorUsuario iu, EmpresaUsuario eu) {
        fgui.nuevoUsuario(c, iu, eu);
    }

    public void nuevaSolicitud() {
        fgui.nuevaSolicitud();
    }

    public void nuevaModificacion() {
        fgui.nuevaModificacion();
    }

    public void configuracionRegulador(InversorUsuario iu, EmpresaUsuario eu) {
        fgui.configuracionRegulador(iu, eu);
    }

    public void nuevaEstadistica(InversorUsuario iu, EmpresaUsuario eu) {
        fgui.nuevaEstadistica(iu, eu);
    }

    public void actualizarComision(float comision) {
        fbd.actualizarComision(comision);
    }

    public void insertarUsuarioInversor(InversorUsuario u) {
        fbd.insertarUsuarioInversor(u);
    }

    public void insertarUsuarioEmpresa(EmpresaUsuario u) {
        fbd.insertarUsuarioEmpresa(u);
    }

    public int comprobarIdInversor(String id) {
        return fbd.comprobarIdInversor(id);
    }

    public int comprobarIdEmpresa(String id) {
        return fbd.comprobarIdEmpresa(id);
    }

    public ArrayList<String> getEmpresas() {
        return fbd.getEmpresas();
    }

    public java.util.List<InversorUsuario> mostrarUsuarioInvPend() {
        return fbd.mostrarUsuarioInvPend();
    }

    public java.util.List<EmpresaUsuario> mostrarUsuarioEmprPend() {
        return fbd.mostrarUsuarioEmprPend();
    }

    public void registroInversor(InversorUsuario inversor) {
        fbd.registroInversor(inversor);
    }

    public void registroEmpresa(EmpresaUsuario empresa) {
        fbd.registroEmpresa(empresa);
    }

    public void modificarUsuarioEmpresa(EmpresaUsuario u) {
        fbd.modificarUsuarioEmpresa(u);
    }

    public void modificarUsuarioInversor(InversorUsuario u) {
        fbd.modificarUsuarioInversor(u);
    }

    public void solicitarBajaInversor(String id) {
        fbd.solicitarBajaInversor(id);
    }

    public void solicitarBajaEmpresa(String id) {
        fbd.solicitarBajaEmpresa(id);
    }

    public void confirmarBajaInversor(String id) {
        fbd.confirmarBajaInversor(id);
    }

    public void confirmarBajaEmpresa(String id) {
        fbd.confirmarBajaEmpresa(id);
    }

    public void modificarCuentaEmpresa(EmpresaUsuario usuario) {
        fbd.modificarCuentaEmpresa(usuario);
    }

    public void modificarCuentaInversor(InversorUsuario usuario) {
        fbd.modificarCuentaInversor(usuario);
    }

     public ArrayList<Estadisticas> actualizarTablaEstadisticas(InversorUsuario iu, EmpresaUsuario eu) {
        return fbd.actualizarTablaEstadisticas(iu,eu);
    }
     
    public ArrayList<String> getEmpresasInv(String id) {
        return fbd.getEmpresasInv(id);
    }
    
    public ArrayList<String> getEmpresasEmpr(String id) {
        return fbd.getEmpresasEmpr(id);
    }
    
    public String getIdEmpresa(String nombre){
        return fbd.getIdEmpresa(nombre);
    }
    
    public double getRendimiento(String idUsuario){
        return fbd.getRendimiento(idUsuario);
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

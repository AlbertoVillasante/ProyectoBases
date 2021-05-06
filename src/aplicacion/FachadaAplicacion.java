package aplicacion;

import java.util.ArrayList;
import sun.awt.EmbeddedFrame;

public class FachadaAplicacion {

    gui.FachadaGui fgui;
    baseDatos.FachadaBaseDatos fbd;
    GesionLibros gl;
    GestionUsuarios gu;
    GestionCategorias gc;
    GestionPrestamos gp;
    GestionBeneficios gb;
    GestionParticipaciones gpart;
    GestionNoticias gn;

    public FachadaAplicacion() {
        fgui = new gui.FachadaGui(this);
        fbd = new baseDatos.FachadaBaseDatos(this);
        gl = new GesionLibros(fgui, fbd);
        gu = new GestionUsuarios(fgui, fbd);
        gc = new GestionCategorias(fgui, fbd);
        gb = new GestionBeneficios(fgui, fbd);
        gpart = new GestionParticipaciones(fgui, fbd);
        gn = new GestionNoticias(fgui, fbd);
    }

    public static void main(String args[]) {
        FachadaAplicacion fa;

        fa = new FachadaAplicacion();
        fa.iniciaInterfazUsuario();
    }

    public void iniciaInterfazUsuario() {
        fgui.iniciaVista();
    }

    public void muestraExcepcion(String e) {
        fgui.muestraExcepcion(e);
    }

    public java.util.List<Libro> obtenerLibros(Integer id, String titulo, String isbn, String autor) {
        return gl.obtenerLibros(id, titulo, isbn, autor);
    }

    /*public void visualizarLibro(Integer idLibro) {
        gl.visualizarLibro(idLibro);
    }

    public void nuevoLibro() {
        gl.nuevoLibro();
    }*/
    public Integer actualizarLibro(Libro l) {
        return gl.actualizarLibro(l);
    }

    public void borrarLibro(Integer idLibro) {
        gl.borrarLibro(idLibro);
    }

    public void actualizarCategoriasLibro(Integer idLibro, java.util.List<String> categorias) {
        gl.actualizarCategoriasLibro(idLibro, categorias);
    }

    public java.util.List<Ejemplar> actualizarEjemplaresLibro(Integer idLibro, java.util.List<Ejemplar> ejemplares, java.util.List<Integer> borrar) {
        return gl.actualizarEjemplaresLibro(idLibro, ejemplares, borrar);
    }

    public InversorUsuario comprobarAutentificacionI(String idUsuario, String clave) {
        return gu.comprobarAutentificacionI(idUsuario, clave);
    }

    public EmpresaUsuario comprobarAutentificacionE(String idUsuario, String clave) {
        return gu.comprobarAutentificacionE(idUsuario, clave);
    }

    public void nuevoUsuario(boolean c, InversorUsuario iu, EmpresaUsuario eu) {
        gu.nuevoUsuario(c, iu, eu);
    }

    public void insertarUsuarioInversor(InversorUsuario u) {
        gu.insertarUsuarioInversor(u);
    }

    public void insertarUsuarioEmpresa(EmpresaUsuario u) {
        gu.insertarUsuarioEmpresa(u);
    }

    public int comprobarIdInversor(String id) {
        return gu.comprobarIdInversor(id);
    }

    public int comprobarIdEmpresa(String id) {
        return gu.comprobarIdEmpresa(id);
    }

    public java.util.List<InversorUsuario> mostrarUsuarioInvPend() {
        return gu.mostrarUsuarioInvPend();
    }

    public java.util.List<EmpresaUsuario> mostrarUsuarioEmprPend() {
        return gu.mostrarUsuarioEmprPend();
    }

    public void modificarUsuarioEmpresa(EmpresaUsuario u) {
        gu.modificarUsuarioEmpresa(u);
    }

    public void modificarUsuarioInversor(InversorUsuario u) {
        gu.modificarUsuarioInversor(u);
    }

    public boolean checkeo_borrado_ejemplares_prestados(int ejemplar, int libro) {
        return gl.checkeo_borrado_ejemplares_prestados(ejemplar, libro);
    }

    public void nuevoBeneficio(InversorUsuario iu, EmpresaUsuario eu) {
        gb.nuevoBeneficio(iu, eu);
    }

    public void nuevoBajaBeneficio(InversorUsuario iu, EmpresaUsuario eu) {
        gb.nuevoBajaBeneficio(iu, eu);
    }

    public void nuevasParticipaciones(EmpresaUsuario eu, InversorUsuario iu) {
        gpart.nuevasParticipaciones(eu, iu);
    }

    public void nuevaSolicitud() {
        gu.nuevaSolicitud();
    }

    public void nuevaModificacion() {
        gu.nuevaModificacion();
    }

    public void configuracionRegulador(InversorUsuario iu, EmpresaUsuario eu) {
        gu.configuracionRegulador(iu, eu);
    }

    public void altaParticipacionesEmpresa(int participaciones, String id) {
        gpart.altaParticipacionesEmpresa(participaciones, id);
    }

    public void bajaParticipacionesEmpresa(int participaciones, String id) {
        gpart.bajaParticipacionesEmpresa(participaciones, id);
    }

    public void actualizarComision(float comision) {
        gu.actualizarComision(comision);
    }

    public void nuevaEstadistica(InversorUsuario iu, EmpresaUsuario eu) {
        gu.nuevaEstadistica(iu, eu);
    }

    public ArrayList<String> getEmpresas() {
        return gu.getEmpresas();
    }

    public ArrayList<AnunciarBeneficios> getBeneficios() {
        return gb.getBeneficios();
    }

    public ArrayList<Saldos> getSaldoUsuarios() {
        return gu.getSaldoUsuarios();
    }

    public ArrayList<Saldos> getSaldoUsuario(String id) {
        return gu.getSaldoUsuario(id);
    }

    public ArrayList<AnunciarBeneficios> getBeneficiosHoy() {
        return gb.getBeneficiosHoy();
    }

    public ArrayList<AnunciarBeneficios> getBeneficiosEmpresa(String idEmpresa) {
        return gb.getBeneficiosEmpresa(idEmpresa);
    }

    public void altaPagoBeneficios(String fecha, double precio, String nombreEmpresa, int numParticipaciones) {
        gb.altaPagoBeneficios(fecha, precio, nombreEmpresa, numParticipaciones);
    }

    public void bajaAnuncioBeneficios(String fecha, String nombreEmpresa) {
        gb.bajaAnuncioBeneficios(fecha, nombreEmpresa);
    }

    public void registroInversor(InversorUsuario inversor) {
        gu.registroInversor(inversor);
    }

    public void registroEmpresa(EmpresaUsuario empresa) {
        gu.registroEmpresa(empresa);
    }

    public void solicitarBajaInversor(String id) {
        gu.solicitarBajaInversor(id);
    }

    public void solicitarBajaEmpresa(String id) {
        gu.solicitarBajaEmpresa(id);
    }

    public void confirmarBajaInversor(String id) {
        gu.confirmarBajaInversor(id);
    }

    public void confirmarBajaEmpresa(String id) {
        gu.confirmarBajaEmpresa(id);
    }

    public void modificarCuentaEmpresa(EmpresaUsuario usuario) {
        gu.modificarCuentaEmpresa(usuario);
    }

    public void modificarCuentaInversor(InversorUsuario usuario) {
        gu.modificarCuentaInversor(usuario);
    }

    public void nuevaNoticia() {
        gn.nuevaNoticia();
    }

    public void nuevoNoticiero(String tiponoticia) {
        gn.nuevoNoticiero(tiponoticia);
    }

    public float getSaldoRetenciones(String id) {
        return gb.getSaldoRetenciones(id);
    }

    public int getParticipacionesRetenciones(String id) {
        return gb.getParticipacionesRetenciones(id);
    }

    public ArrayList<Estadisticas> actualizarTablaEstadisticas(InversorUsuario iu, EmpresaUsuario eu) {
        return gu.actualizarTablaEstadisticas(iu, eu);
    }

    public ArrayList<String> getEmpresasInv(String id) {
        return gu.getEmpresasInv(id);
    }

    public ArrayList<String> getEmpresasEmpr(String id) {
        return gu.getEmpresasEmpr(id);
    }

    public java.util.List<OfertaParticipaciones> mostrarVentas() {
        return gpart.mostrarVentas();
    }

    public void ofertaVentaInv(OfertaParticipaciones v) {
        gpart.ofertaVentaInv(v);
    }

    public void ofertaVentaEmpr(OfertaParticipaciones v) {
        gpart.ofertaVentaEmpr(v);
    }

    public boolean comprobarParticipacionesEmpresa(OfertaParticipaciones v) {
        return gpart.comprobarParticipacionesEmpresa(v);
    }

    public boolean comprobarParticipacionesInversor(OfertaParticipaciones v) {
        return gpart.comprobarParticipacionesInversor(v);
    }

    public String getIdEmpresa(String nombre) {
        return gu.getIdEmpresa(nombre);
    }

    public int numParticipacionesInvEmpr(String idUsuario, String idEmpresa) {
        return gpart.numParticipacionesInvEmpr(idUsuario, idEmpresa);
    }

    public int numParticipacionesEmprEmpr(String idUsuario, String idEmpresa) {
        return gpart.numParticipacionesEmprEmpr(idUsuario, idEmpresa);
    }

    public int partInvBloq(String id, String id2) {
        return gpart.partInvBloq(id, id2);
    }

    public int partEmprBloq(String id, String id2) {
        return gpart.partEmprBloq(id, id2);
    }

    public void borrarVentaInv(OfertaParticipaciones v) {
        gpart.borrarVentaInv(v);
    }

    public void borrarVentaEmpr(OfertaParticipaciones v) {
        gpart.borrarVentaEmpr(v);
    }

    public String getnombreInversor(String id) {
        return gu.getnombreInversor(id);
    }

    public String getnombreEmpresa(String id) {
        return gu.getnombreEmpresa(id);
    }

    public double getRendimiento(String idUsuario) {
        return gu.getRendimiento(idUsuario);
    }

    public int contarOfertas(String id, double precio, String yo) {
        return gpart.contarOfertas(id, precio, yo);
    }

    public OfertaParticipaciones getOfertaParticipaciones(String id, double precio, String yo) {
        return gpart.getOfertaParticipaciones(id, precio, yo);
    }

    public int moverParticipacionesTodas(String idUsuario, OfertaParticipaciones oferta) {
        return gpart.moverParticipacionesTodas(idUsuario, oferta);
    }

    public void moverParticipacionesParciales(OfertaParticipaciones oferta, String idUsuario, int participacionesRestantes) {
        gpart.moverParticipacionesParciales(oferta, idUsuario, participacionesRestantes);
    }

    public void eliminarInversor(String id) {
        gu.eliminarInversor(id);
    }

    public void eliminarEmpresa(String id) {
        gu.eliminarEmpresa(id);
    }

    public void estadoNormalInv(String id) {
        gu.estadoNormalInv(id);
    }

    public void estadoNormalEmpr(String id) {
        gu.estadoNormalEmpr(id);
    }

    public void pagarBeneficios() {
        gb.pagarBeneficios();
    }

    public void cambiarSaldoUsuario(Saldos s) {
        gu.cambiarSaldoUsuario(s);
    }

    public void insertarNoticia(String tipo, String descripcion, String id) {
        gn.insertarNoticia(tipo, descripcion, id);
    }

    public java.util.List<Noticias> getNoticias(String tipo1, String tipo2, String tipo3) {
        return gn.getNoticias(tipo1, tipo2, tipo3);
    }

    public double getSaldoCompraVenta(String id) {
        return gpart.getSaldoCompraVenta(id);
    }

    public int participacionesComprobarBaja(String id) {
        return gpart.participacionesComprobarBaja(id);
    }

    public void modificarRegulador(InversorUsuario u) {
        gu.modificarRegulador(u);
    }

    public float obtenerComisionOferta(String fechaOferta) {
        return gpart.obtenerComisionOferta(fechaOferta);
    }

    public void actualizaSaldoEmpresa(EmpresaUsuario eu, double precio) {
        gpart.actualizaSaldoEmpresa(eu, precio);
    }

    public ArrayList<prestamo> getPrestamo() {
        return gpart.getPrestamo();
    }

    public int numParticipacionesInversorEmpresa(String usuario, String empresa) {
        return gpart.numParticipacionesInversorEmpresa(usuario, empresa);
    }

    public int numParticipacionesEmpresaEmpresa(String usuario, String empresa) {
        return gpart.numParticipacionesEmpresaEmpresa(usuario, empresa);
    }

    public int numParticipacionesALaVenta(String usuario, String empresa) {
        return gpart.numParticipacionesALaVenta(usuario, empresa);
    }

    public double ventaParticipacionesAEmpresaI(InversorUsuario iu, String empresa, int nParticipaciones) {
        return gpart.ventaParticipacionesAEmpresaI(iu, empresa, nParticipaciones);
    }

    public double ventaParticipacionesAEmpresaE(EmpresaUsuario eu, String empresa, int nParticipaciones) {
        return gpart.ventaParticipacionesAEmpresaE(eu, empresa, nParticipaciones);
    }
}

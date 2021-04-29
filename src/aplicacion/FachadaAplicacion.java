package aplicacion;

import java.util.ArrayList;

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

    /*  //Comentado para que no de error
    public java.util.List<EmpresaUsuario> obtenerUsuarios(String idUsuario, String nombreUsuario) {
        return gu.obtenerUsuarios(idUsuario, nombreUsuario);
    }

    public void actualizarUsuario(EmpresaUsuario u, String id) {
        gu.actualizarUsuario(u, id);
    }

    public void borrarUsuario(String idUsuario) {
        gu.borrarUsuario(idUsuario);
    }
     */
 /*public void nuevaCategoria() {
        gc.nuevaCategoria();
    }

    public void actualizarCategoria(Categoria c) {
        gc.actualizarCategoria(c);
    }

    public java.util.List<Categoria> obtenerCategoria(String nombre) {
        return gc.obtenerCategoria(nombre);
    }

    public void borrarCategoria(String nombre) {
        gc.borrarCategoria(nombre);
    }

    public void nuevoPrestamo(Ejemplar e) {
        gp.nuevoPrestamo(e);
    }
/*  //Comentado para que no de error
    public java.util.List<EmpresaUsuario> obtenerUsuariosPrestamo(String idUsuario, String nombreUsuario) {
        return gu.obtenerUsuariosPrestamo(idUsuario, nombreUsuario);
    }
     */
 /*public void devolverEjemplar(Integer ejemplar, String usuario, Integer libro) {
        gp.devolverEjemplar(ejemplar, usuario, libro);
    }*/
    public boolean checkeo_borrado_ejemplares_prestados(int ejemplar, int libro) {
        return gl.checkeo_borrado_ejemplares_prestados(ejemplar, libro);
    }

    /* public Integer DiasFaltanParaVencer(Integer libro, Integer ejemplar) {
        return gp.DiasFaltanParaVencer(libro, ejemplar);
    }*/
    public void nuevoBeneficio(InversorUsuario iu, EmpresaUsuario eu) {
        gb.nuevoBeneficio(iu, eu);
    }
    
    public void nuevoBajaBeneficio(InversorUsuario iu, EmpresaUsuario eu){
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

    public void altaPagoBeneficios(String fecha, double precio, String nombreEmpresa, int numParticipaciones) {
        gb.altaPagoBeneficios(fecha, precio, nombreEmpresa, numParticipaciones);
    }
    
    public void bajaAnuncioBeneficios(String fecha, String nombreEmpresa){
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
    
    public java.util.List<Venta> mostrarVentas(){
        return gpart.mostrarVentas();
    }
    
    public void ofertaVentaInv(Venta v){
        gpart.ofertaVentaInv(v);
    }
    
    public void ofertaVentaEmpr(Venta v){
        gpart.ofertaVentaEmpr(v);
    }
    
    public boolean comprobarParticipacionesEmpresa(Venta v){
        return gpart.comprobarParticipacionesEmpresa(v);
    }
    
    public boolean comprobarParticipacionesInversor(Venta v){
        return gpart.comprobarParticipacionesInversor(v);
    }
    
    public String getIdEmpresa(String nombre){
        return gu.getIdEmpresa(nombre);
    }
}

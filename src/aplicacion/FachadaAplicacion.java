package aplicacion;

public class FachadaAplicacion {

    gui.FachadaGui fgui;
    baseDatos.FachadaBaseDatos fbd;
    GesionLibros gl;
    GestionUsuarios gu;
    GestionCategorias gc;
    GestionPrestamos gp;

    public FachadaAplicacion() {
        fgui = new gui.FachadaGui(this);
        fbd = new baseDatos.FachadaBaseDatos(this);
        gl = new GesionLibros(fgui, fbd);
        gu = new GestionUsuarios(fgui, fbd);
        gc = new GestionCategorias(fgui, fbd);
        gp = new GestionPrestamos(fgui, fbd);
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

    public void visualizarLibro(Integer idLibro) {
        gl.visualizarLibro(idLibro);
    }

    public void nuevoLibro() {
        gl.nuevoLibro();
    }

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
    //Comentado para que no de error
    public Boolean comprobarAutentificacion(String idUsuario, String clave) {
        return gu.comprobarAutentificacion(idUsuario, clave);
    }

    public void nuevoUsuario() {
        gu.nuevoUsuario();
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
    public void nuevaCategoria() {
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
    public void devolverEjemplar(Integer ejemplar, String usuario, Integer libro) {
        gp.devolverEjemplar(ejemplar, usuario, libro);
    }

    public boolean checkeo_borrado_ejemplares_prestados(int ejemplar, int libro) {
        return gl.checkeo_borrado_ejemplares_prestados(ejemplar, libro);
    }

    public Integer DiasFaltanParaVencer(Integer libro, Integer ejemplar) {
        return gp.DiasFaltanParaVencer(libro, ejemplar);
    }

    
     public void nuevoBeneficio() {
        gp.nuevoBeneficio();
    }
}

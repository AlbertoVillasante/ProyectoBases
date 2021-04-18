package baseDatos;

import aplicacion.Ejemplar;
import aplicacion.InversorUsuario;
import aplicacion.Categoria;
import aplicacion.EmpresaUsuario;
import aplicacion.Libro;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class FachadaBaseDatos {

    private aplicacion.FachadaAplicacion fa;
    private java.sql.Connection conexion;
    private DAOLibros daoLibros;
    private DAOCategorias daoCategorias;
    private DAOUsuarios daoUsuarios;
    private DAOParticipaciones daoParticipaciones;

    public FachadaBaseDatos(aplicacion.FachadaAplicacion fa) {

        Properties configuracion = new Properties();
        this.fa = fa;
        FileInputStream arqConfiguracion;

        try {
            arqConfiguracion = new FileInputStream("baseDatos.properties"); //linea a cambiar
            //arqConfiguracion = new FileInputStream("basesDatos.properties");

            configuracion.load(arqConfiguracion);
            arqConfiguracion.close();

            Properties usuario = new Properties();

            String gestor = configuracion.getProperty("gestor");

            usuario.setProperty("user", configuracion.getProperty("usuario"));
            usuario.setProperty("password", configuracion.getProperty("clave"));
            this.conexion = java.sql.DriverManager.getConnection("jdbc:" + gestor + "://"
                    + configuracion.getProperty("servidor") + ":"
                    + configuracion.getProperty("puerto") + "/"
                    + configuracion.getProperty("baseDatos"),
                    usuario);

            daoLibros = new DAOLibros(conexion, fa);
            daoCategorias = new DAOCategorias(conexion, fa);
            daoUsuarios = new DAOUsuarios(conexion, fa);
            daoParticipaciones = new DAOParticipaciones(conexion, fa);

        } catch (FileNotFoundException f) {
            System.out.println(f.getMessage());
            fa.muestraExcepcion(f.getMessage());
        } catch (IOException i) {
            System.out.println(i.getMessage());
            fa.muestraExcepcion(i.getMessage());
        } catch (java.sql.SQLException e) {
            System.out.println(e.getMessage());
            fa.muestraExcepcion(e.getMessage());
        }

    }

    public java.util.List<Libro> consultarCatalogo(Integer id, String titulo, String isbn, String autor) {
        return daoLibros.consultarCatalogo(id, titulo, isbn, autor);
    }

    public Libro consultarLibro(Integer idLibro) {
        return daoLibros.consultarLibro(idLibro);
    }

    public java.util.List<Ejemplar> consultarEjemplaresLibro(Integer idLibro) {
        return daoLibros.consultarEjemplaresLibro(idLibro);
    }

    public java.util.List<String> obtenerRestoCategorias(Integer idLibro) {
        return daoLibros.obtenerRestoCategorias(idLibro);
    }

    public Integer insertarLibro(Libro libro) {
        return daoLibros.insertarLibro(libro);
    }

    public void borrarLibro(Integer idLibro) {
        daoLibros.borrarLibro(idLibro);
    }

    public void modificarLibro(Libro libro) {
        daoLibros.modificarLibro(libro);
    }

    public void modificarCategoriasLibro(Integer idLibro, java.util.List<String> categorias) {
        daoLibros.modificarCategoriasLibro(idLibro, categorias);
    }

    public void insertarEjemplarLibro(Integer idLibro, Ejemplar ejemplar) {
        daoLibros.insertarEjemplarLibro(idLibro, ejemplar);
    }

    public void borrarEjemplaresLibro(Integer idLibro, java.util.List<Integer> numsEjemplar) {
        daoLibros.borrarEjemplaresLibro(idLibro, numsEjemplar);
    }

    public void modificarEjemplarLibro(Integer idLibro, Ejemplar ejemplar) {
        daoLibros.modificarEjemplarLibro(idLibro, ejemplar);
    }

    /*  //Comentado para que no de error
    public EmpresaUsuario validarUsuario(String idUsuario, String clave) {
        return daoUsuarios.validarUsuario(idUsuario, clave);
    }

    public java.util.List<EmpresaUsuario> consultarListaUsuarios(String idUsuario, String nombreUsuario) {
        return daoUsuarios.consultarListaUsuarios(idUsuario, nombreUsuario);
    }

    public void insertarUsuario(EmpresaUsuario u) {
        daoUsuarios.insertarUsuario(u);
    }

    public void modificarUsuario(EmpresaUsuario u, String id) {
        daoUsuarios.modificarUsuario(u, id);
    }

    public void borrarUsuario(String idUsuario) {
        daoUsuarios.borrarUsuario(idUsuario);
    }
     */
    public java.util.List<Categoria> consultarCategorias() {
        return daoCategorias.consultarCategorias();
    }

    public void insertarCategoria(Categoria c) {
        daoCategorias.insertarCategoria(c);
    }

    public void modificarCategoria(Categoria c) {
        daoCategorias.modificarCategoria(c);
    }

    public java.util.List<Categoria> consultarListaCategorias(String nombre) {
        return daoCategorias.consultarListaCategorias(nombre);
    }

    public void borrarCategoria(String nombre) {
        daoCategorias.borrarCategoria(nombre);
    }

    public void nuevoPrestamo(Ejemplar e) {
        daoLibros.nuevoPrestamo(e);
    }

    /*  //Comentado para que no de error
    public java.util.List<EmpresaUsuario> consultarListaUsuariosPrestamo(String idUsuario, String nombreUsuario) {
        return daoUsuarios.consultarListaUsuariosPrestamo(idUsuario, nombreUsuario);
    }
     */
    public void devolverEjemplar(Integer ejemplar, String usuario, Integer libro) {
        daoLibros.devolverEjemplar(ejemplar, usuario, libro);
    }

    public boolean checkeo_borrado_ejemplares_prestados(int ejemplar, int libro) {
        return daoLibros.checkeo_borrado_ejemplares_prestados(ejemplar, libro);
    }

    public Integer DiasFaltanParaVencer(Integer libro, Integer ejemplar) {
        return daoLibros.DiasFaltanParaVencer(libro, ejemplar);
    }

    public InversorUsuario validarUsuario(String idUsuario, String clave) {
        return daoUsuarios.validarUsuarioInversor(idUsuario, clave);
    }

    public EmpresaUsuario validarUsuarioE(String idUsuario, String clave) {
        return daoUsuarios.validarUsuarioEmpresa(idUsuario, clave);
    }

    public void altaParticipacionesEmpresa(int participaciones, String id) {
        daoParticipaciones.altaParticipacionesEmpresa(participaciones, id);
    }

    public void bajaParticipacionesEmpresa(int participaciones, String id) {
        daoParticipaciones.bajaParticipacionesEmpresa(participaciones, id);
    }

    public void actualizarComision(float comision) {
            daoUsuarios.actualizarComision(comision);
    }
    
    public void insertarUsuarioInversor(InversorUsuario u){
        daoUsuarios.insertarUsuarioInversor(u);
    }
    
    public void insertarUsuarioEmpresa(EmpresaUsuario u){
        daoUsuarios.insertarUsuarioEmpresa(u);
    }
    
    public int comprobarIdInversor(String id){
        return daoUsuarios.comprobarIdInversor(id);
    }
    
    public int comprobarIdEmpresa(String id){
        return daoUsuarios.comprobarIdEmpresa(id);
    }
}

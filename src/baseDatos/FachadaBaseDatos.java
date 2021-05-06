package baseDatos;

import aplicacion.AnunciarBeneficios;
import aplicacion.Ejemplar;
import aplicacion.InversorUsuario;
import aplicacion.Categoria;
import aplicacion.EmpresaUsuario;
import aplicacion.Estadisticas;
import aplicacion.Libro;
import aplicacion.Noticias;
import aplicacion.OfertaParticipaciones;
import aplicacion.Saldos;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

public class FachadaBaseDatos {

    private aplicacion.FachadaAplicacion fa;
    private java.sql.Connection conexion;
    private DAOLibros daoLibros;
    private DAOCategorias daoCategorias;
    private DAOUsuarios daoUsuarios;
    private DAOParticipaciones daoParticipaciones;
    private DAOBeneficios daoBeneficios;
    private DAONoticias daoNoticias;

    public FachadaBaseDatos(aplicacion.FachadaAplicacion fa) {

        Properties configuracion = new Properties();
        this.fa = fa;
        FileInputStream arqConfiguracion;

        try {
            //arqConfiguracion = new FileInputStream("baseDatos.properties"); //linea a cambiar
            arqConfiguracion = new FileInputStream("basesDatos.properties");

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
            daoBeneficios = new DAOBeneficios(conexion, fa);
            daoNoticias = new DAONoticias(conexion, fa);

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

    public ArrayList<Saldos> getSaldoUsuarios() {
        return daoUsuarios.getSaldoUsuarios();
    }

    public ArrayList<Saldos> getSaldoUsuario(String id) {
        return daoUsuarios.getSaldoUsuario(id);
    }

    public void insertarUsuarioInversor(InversorUsuario u) {
        daoUsuarios.insertarUsuarioInversor(u);
    }

    public void insertarUsuarioEmpresa(EmpresaUsuario u) {
        daoUsuarios.insertarUsuarioEmpresa(u);
    }

    public int comprobarIdInversor(String id) {
        return daoUsuarios.comprobarIdInversor(id);
    }

    public int comprobarIdEmpresa(String id) {
        return daoUsuarios.comprobarIdEmpresa(id);
    }

    public ArrayList<String> getEmpresas() {
        return daoUsuarios.getEmpresas();
    }

    public void altaPagoBeneficios(String fecha, double precio, String nombreEmpresa, int numParticipaciones) {
        String idEmpresa = daoUsuarios.getIdEmpresa(nombreEmpresa);

        daoBeneficios.altaPagoBeneficios(fecha, precio, idEmpresa, numParticipaciones);
    }

    public void bajaAnuncioBeneficios(String fecha, String nombreEmpresa) {
        String idEmpresa = daoUsuarios.getIdEmpresa(nombreEmpresa);
        daoBeneficios.bajaAnuncioBeneficios(fecha, idEmpresa);
    }

    public ArrayList<AnunciarBeneficios> getBeneficios() {
        return daoBeneficios.getBeneficios();
    }

    public ArrayList<AnunciarBeneficios> getBeneficiosHoy() {
        return daoBeneficios.getBeneficiosHoy();
    }

    public ArrayList<AnunciarBeneficios> getBeneficiosEmpresa(String idEmpresa) {
        return daoBeneficios.getBeneficiosEmpresa(idEmpresa);
    }

    public java.util.List<InversorUsuario> mostrarUsuarioInvPend() {
        return daoUsuarios.mostrarUsuarioInvPend();
    }

    public java.util.List<EmpresaUsuario> mostrarUsuarioEmprPend() {
        return daoUsuarios.mostrarUsuarioEmprPend();
    }

    public void registroInversor(InversorUsuario inversor) {
        daoUsuarios.registroInversor(inversor);
    }

    public void registroEmpresa(EmpresaUsuario empresa) {
        daoUsuarios.registroEmpresa(empresa);
    }

    public void modificarUsuarioEmpresa(EmpresaUsuario u) {
        daoUsuarios.modificarUsuarioEmpresa(u);
    }

    public void modificarUsuarioInversor(InversorUsuario u) {
        daoUsuarios.modificarUsuarioInversor(u);
    }

    public void solicitarBajaInversor(String id) {
        daoUsuarios.solicitarBajaInversor(id);
    }

    public void solicitarBajaEmpresa(String id) {
        daoUsuarios.solicitarBajaEmpresa(id);
    }

    public void confirmarBajaInversor(String id) {
        daoUsuarios.confirmarBajaInversor(id);
    }

    public void confirmarBajaEmpresa(String id) {
        daoUsuarios.confirmarBajaEmpresa(id);
    }

    public void modificarCuentaEmpresa(EmpresaUsuario usuario) {
        daoUsuarios.modificarCuentaEmpresa(usuario);
    }

    public void modificarCuentaInversor(InversorUsuario usuario) {
        daoUsuarios.modificarCuentaInversor(usuario);
    }

    public float getSaldoRetenciones(String id) {
        return daoBeneficios.getSaldoRetenciones(id);
    }

    public int getParticipacionesRetenciones(String id) {
        return daoBeneficios.getParticipacionesRetenciones(id);
    }

    public ArrayList<Estadisticas> actualizarTablaEstadisticas(InversorUsuario iu, EmpresaUsuario eu) {
        if (iu != null) {
            return daoUsuarios.actualizarTablaEstadisticasInversor(iu.getIdUsuario());
        } else {
            return daoUsuarios.actualizarTablaEstadisticasEmpresa(eu.getIdUsuario());
        }
    }

    public ArrayList<String> getEmpresasInv(String id) {
        return daoUsuarios.getEmpresasInv(id);
    }

    public ArrayList<String> getEmpresasEmpr(String id) {
        return daoUsuarios.getEmpresasEmpr(id);
    }

    public java.util.List<OfertaParticipaciones> mostrarVentas() {
        return daoParticipaciones.mostrarVentas();
    }

    public void ofertaVentaInv(OfertaParticipaciones v) {
        daoParticipaciones.ofertaVentaInv(v);
    }

    public void ofertaVentaEmpr(OfertaParticipaciones v) {
        daoParticipaciones.ofertaVentaEmpr(v);
    }

    public boolean comprobarParticipacionesEmpresa(OfertaParticipaciones v) {
        return daoParticipaciones.comprobarParticipacionesEmpresa(v);
    }

    public boolean comprobarParticipacionesInversor(OfertaParticipaciones v) {
        return daoParticipaciones.comprobarParticipacionesInversor(v);
    }

    public String getIdEmpresa(String nombre) {
        return daoUsuarios.getIdEmpresa(nombre);
    }

    public int numParticipacionesInvEmpr(String idUsuario, String idEmpresa) {
        return daoParticipaciones.numParticipacionesInvEmpr(idUsuario, idEmpresa);
    }

    public int numParticipacionesEmprEmpr(String idUsuario, String idEmpresa) {
        return daoParticipaciones.numParticipacionesEmprEmpr(idUsuario, idEmpresa);
    }

    public int partInvBloq(String id, String id2) {
        return daoParticipaciones.partInvBloq(id, id2);
    }

    public int partEmprBloq(String id, String id2) {
        return daoParticipaciones.partEmprBloq(id, id2);
    }

    public void borrarVentaInv(OfertaParticipaciones v) {
        daoParticipaciones.borrarVentaInv(v);
    }

    public void borrarVentaEmpr(OfertaParticipaciones v) {
        daoParticipaciones.borrarVentaEmpr(v);
    }

    public String getnombreInversor(String id) {
        return daoUsuarios.getnombreInversor(id);
    }

    public String getnombreEmpresa(String id) {
        return daoUsuarios.getnombreEmpresa(id);
    }

    public double getRendimiento(String idUsuario) {
        switch (idUsuario.length()) {
            case 9:
                return daoUsuarios.getRendimientoInversor(idUsuario);
            case 13:
                return daoUsuarios.getRendimientoEmpresa(idUsuario);
            default:
                return 1.0; // por defecto no hay rendimiento 
        }
    }

    public int contarOfertas(String id, double precio, String yo) {
        return daoParticipaciones.contarOfertas(id, precio, yo);
    }

    public OfertaParticipaciones getOfertaParticipaciones(String id, double precio, String yo) {
        return daoParticipaciones.getOfertaParticipaciones(id, precio, yo);
    }

    public int moverParticipacionesTodas(String idUsuario, OfertaParticipaciones oferta) {
        return daoParticipaciones.moverParticipacionesTodas(idUsuario, oferta);
    }

    public void moverParticipacionesParciales(OfertaParticipaciones oferta, String idUsuario, int participacionesRestantes) {
        daoParticipaciones.moverParticipacionesParciales(oferta, idUsuario, participacionesRestantes);
    }

    public void eliminarInversor(String id) {
        daoUsuarios.eliminarInversor(id);
    }

    public void eliminarEmpresa(String id) {
        daoUsuarios.eliminarEmpresa(id);
    }

    public void estadoNormalInv(String id) {
        daoUsuarios.estadoNormalInv(id);
    }

    public void estadoNormalEmpr(String id) {
        daoUsuarios.estadoNormalEmpr(id);
    }

    public void cambiarSaldoUsuario(Saldos s) {
        daoUsuarios.cambiarSaldoUsuario(s);
        daoUsuarios.cambiarSaldoUsuarioInicial(s);
    }

    public void pagarBeneficios() {
        daoBeneficios.pagarBeneficios();
    }

    public void insertarNoticia(String tipo, String descripcion, String id) {
        daoNoticias.insertarNoticia(tipo, descripcion, id);
    }

    public java.util.List<Noticias> getNoticias(String tipo1, String tipo2, String tipo3) {
        return daoNoticias.getNoticias(tipo1, tipo2, tipo3);
    }

    public double getSaldoCompraVenta(String id) {
        return daoParticipaciones.getSaldoCompraVenta(id);
    }

    public int participacionesComprobarBaja(String id) {
        return daoParticipaciones.participacionesComprobarBaja(id);
    }

    public void modificarRegulador(InversorUsuario u) {
        daoUsuarios.modificarRegulador(u);
    }

    public float obtenerComisionOferta(String fechaOferta) {
        return daoParticipaciones.obtenerComisionOferta(fechaOferta);
    }
}

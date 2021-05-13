package baseDatos;

import aplicacion.AnunciarBeneficios;
import aplicacion.InversorUsuario;
import aplicacion.EmpresaUsuario;
import aplicacion.Estadisticas;
import aplicacion.Noticias;
import aplicacion.OfertaParticipaciones;
import aplicacion.Saldos;
import aplicacion.prestamo;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

public class FachadaBaseDatos {

    private aplicacion.FachadaAplicacion fa;
    private java.sql.Connection conexion;
    private DAOUsuarios daoUsuarios;
    private DAOParticipaciones daoParticipaciones;
    private DAOBeneficios daoBeneficios;
    private DAONoticias daoNoticias;

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
        java.util.List<OfertaParticipaciones> a = daoParticipaciones.mostrarVentas();
        for (OfertaParticipaciones of : a) {
            of.setIdUsuario2(daoUsuarios.getnombreEmpresa(of.getIdUsuario2()));
        }
        return a;
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

    public boolean pagarBeneficios() {
        return daoBeneficios.pagarBeneficios();
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

    public void actualizaSaldoEmpresa(EmpresaUsuario eu, double precio) {
        daoUsuarios.actualizaSaldoEmpresa(eu, precio);
    }

    public ArrayList<prestamo> getPrestamo() {
        return daoUsuarios.getPrestamo();
    }

    public int numParticipacionesInversorEmpresa(String usuario, String empresa) {
        return daoParticipaciones.numParticipacionesInversorEmpresa(usuario, empresa);
    }

    public int numParticipacionesEmpresaEmpresa(String usuario, String empresa) {
        return daoParticipaciones.numParticipacionesEmpresaEmpresa(usuario, empresa);
    }

    public int numParticipacionesALaVenta(String usuario, String empresa) {
        return daoParticipaciones.numParticipacionesALaVenta(usuario, empresa);
    }

    public double ventaParticipacionesAEmpresaI(InversorUsuario iu, String empresa, int nParticipaciones) {
        return daoParticipaciones.ventaParticipacionesAEmpresaI(iu, empresa, nParticipaciones);
    }

    public double ventaParticipacionesAEmpresaE(EmpresaUsuario eu, String empresa, int nParticipaciones) {
        return daoParticipaciones.ventaParticipacionesAEmpresaE(eu, empresa, nParticipaciones);
    }

    public boolean comprobarFecha(String empresa, String fecha) {
        return daoBeneficios.comprobarFecha(empresa, fecha);
    }

}

package aplicacion;

import gui.FachadaGui;
import baseDatos.FachadaBaseDatos;

/**
 *
 * @author hugo
 */
public class GestionParticipaciones {

    FachadaGui fgui;
    FachadaBaseDatos fbd;

    public GestionParticipaciones(FachadaGui fgui, FachadaBaseDatos fbd) {
        this.fgui = fgui;
        this.fbd = fbd;
    }

    public void nuevasParticipaciones(EmpresaUsuario eu, InversorUsuario iu) {
        fgui.nuevasParticipaciones(eu, iu);
    }

    public void altaParticipacionesEmpresa(int participaciones, String id) {
        fbd.altaParticipacionesEmpresa(participaciones, id);
    }

    public void bajaParticipacionesEmpresa(int participaciones, String id) {
        fbd.bajaParticipacionesEmpresa(participaciones, id);
    }

    public java.util.List<OfertaParticipaciones> mostrarVentas() {
        return fbd.mostrarVentas();
    }

    public void ofertaVentaInv(OfertaParticipaciones v) {
        fbd.ofertaVentaInv(v);
    }

    public void ofertaVentaEmpr(OfertaParticipaciones v) {
        fbd.ofertaVentaEmpr(v);
    }

    public boolean comprobarParticipacionesEmpresa(OfertaParticipaciones v) {
        return fbd.comprobarParticipacionesEmpresa(v);
    }

    public boolean comprobarParticipacionesInversor(OfertaParticipaciones v) {
        return fbd.comprobarParticipacionesInversor(v);
    }

    public int numParticipacionesInvEmpr(String idUsuario, String idEmpresa) {
        return fbd.numParticipacionesInvEmpr(idUsuario, idEmpresa);
    }

    public int numParticipacionesEmprEmpr(String idUsuario, String idEmpresa) {
        return fbd.numParticipacionesEmprEmpr(idUsuario, idEmpresa);
    }

    public int partInvBloq(String idUser, String idEmpr) {
        return fbd.partInvBloq(idUser, idEmpr);
    }

    public int partEmprBloq(String idUser, String idEmpr) {
        return fbd.partEmprBloq(idUser, idEmpr);
    }

    public void borrarVentaInv(OfertaParticipaciones v) {
        fbd.borrarVentaInv(v);
    }

    public void borrarVentaEmpr(OfertaParticipaciones v) {
        fbd.borrarVentaEmpr(v);
    }

    public int contarOfertas(String id, double precio, String yo) {
        return fbd.contarOfertas(id, precio, yo);
    }

    public OfertaParticipaciones getOfertaParticipaciones(String id, double precio, String yo) {
        return fbd.getOfertaParticipaciones(id, precio, yo);
    }

    public int moverParticipacionesTodas(String idUsuario, OfertaParticipaciones oferta) {
        return fbd.moverParticipacionesTodas(idUsuario, oferta);
    }

    public void moverParticipacionesParciales(OfertaParticipaciones oferta, String idUsuario, int participacionesRestantes) {
        fbd.moverParticipacionesParciales(oferta, idUsuario, participacionesRestantes);
    }

    public double getSaldoCompraVenta(String id) {
        return fbd.getSaldoCompraVenta(id);
    }

    public int participacionesComprobarBaja(String id) {
        return fbd.participacionesComprobarBaja(id);
    }

    public float obtenerComisionOferta(String fechaOferta) {
        return fbd.obtenerComisionOferta(fechaOferta);
    }
}

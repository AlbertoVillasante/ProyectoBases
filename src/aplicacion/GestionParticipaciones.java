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

    public java.util.List<Venta> mostrarVentas() {
        return fbd.mostrarVentas();
    }

    public void ofertaVentaInv(Venta v) {
        fbd.ofertaVentaInv(v);
    }

    public void ofertaVentaEmpr(Venta v) {
        fbd.ofertaVentaEmpr(v);
    }

    public boolean comprobarParticipacionesEmpresa(Venta v) {
        return fbd.comprobarParticipacionesEmpresa(v);
    }

    public boolean comprobarParticipacionesInversor(Venta v) {
        return fbd.comprobarParticipacionesInversor(v);
    }

    public int contarOfertas(String id, double precio) {
        return fbd.contarOfertas(id, precio);
    }

    public OfertaParticipaciones getOfertaParticipaciones(String id, double precio) {
        return fbd.getOfertaParticipaciones(id, precio);
    }
    
    public int moverParticipacionesTodas(String idUsuario, OfertaParticipaciones oferta){
        return fbd.moverParticipacionesTodas(idUsuario,oferta);
    }
    
    public void moverParticipacionesParciales(OfertaParticipaciones oferta, String idUsuario, int participacionesRestantes){
        fbd.moverParticipacionesParciales(oferta,idUsuario,participacionesRestantes);
    }
}

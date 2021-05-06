package gui;

import aplicacion.EmpresaUsuario;
import aplicacion.InversorUsuario;

public class FachadaGui {           //Esta es la fachada

    aplicacion.FachadaAplicacion fa;

    public FachadaGui(aplicacion.FachadaAplicacion fa) {
        try {
            this.fa = fa;
        } catch (Exception ex) {
        }
    }

    public void iniciaVista() {
        VAutentificacion va;
        va  = new VAutentificacion(fa);
        va.setLocation(185, 80);
        va.setVisible(true);
    }

    public void nuevoBeneficio(InversorUsuario iu, EmpresaUsuario eu) {
        VBeneficios vb;

        vb = new VBeneficios(fa, iu, eu);
        vb.setVisible(true);

    }

    public void nuevoBajaBeneficio(InversorUsuario iu, EmpresaUsuario eu) {
        VBajaBeneficios vb;

        vb = new VBajaBeneficios(fa, iu, eu);
        vb.setVisible(true);

    }

    public void nuevasParticipaciones(EmpresaUsuario eu, InversorUsuario iu) {
        VParticipaciones vpart;

        vpart = new VParticipaciones(fa, eu, iu);
        vpart.setVisible(true);

    }

    public void muestraExcepcion(String txtExcepcion) {
        VAviso va;

        va  = new VAviso(txtExcepcion);
        va.setVisible(true);
    }

    public void nuevoUsuario(boolean c, InversorUsuario iu, EmpresaUsuario eu) {
        VUsuario vu;

        vu = new VUsuario(fa, c, iu, eu);
        vu.setVisible(true);
    }

    public void nuevaSolicitud() {
        VVerificacion vv;

        vv = new VVerificacion(fa);
        vv.setVisible(true);
    }

    public void nuevaModificacion() {
        VSaldos vs;

        vs = new VSaldos(fa);
        vs.setVisible(true);
    }

    public void configuracionRegulador(InversorUsuario iu, EmpresaUsuario eu) {
        VConfiguracionRegulador vc;

        vc = new VConfiguracionRegulador(fa, iu, eu);
        vc.setVisible(true);
    }

    public void nuevaEstadistica(InversorUsuario iu, EmpresaUsuario eu) {
        VEstadistica Vest;

        Vest = new VEstadistica(fa, iu, eu);
        Vest.setVisible(true);
    }

    public void nuevaNoticia() {
        VNoticias vn;
        vn = new VNoticias(fa);
        vn.setVisible(true);
    }

    public void nuevoNoticiero(String tiponoticia) {
        VNoticiero vn;
        vn = new VNoticiero(fa, tiponoticia);
        vn.setVisible(true);
    }
}

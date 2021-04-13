package gui;

import aplicacion.Categoria;
import aplicacion.Libro;
import aplicacion.EmpresaUsuario;
import aplicacion.Ejemplar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class FachadaGui {           //Esta es la fachada

    aplicacion.FachadaAplicacion fa;
    VPortada vp;

    public FachadaGui(aplicacion.FachadaAplicacion fa) {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.gtk.GTKLookAndFeel");
            this.fa = fa;
            this.vp = new VPortada(fa);
        } catch (Exception ex) {
        }
    }

    public void iniciaVista() {
        VAutentificacion va;
        va  = new VAutentificacion(fa, vp);
        va.setLocation(185, 80);
        vp.setVisible(true);
        va.setVisible(true);
    }

    /* public void visualizaLibro(Libro l, java.util.List<String> restoCategorias) {
        VLibro vl;
        java.util.List<String> categorias = new java.util.ArrayList<String>();

        for (Categoria c : l.getCategorias()) {
            categorias.add(c.getNombre());
        }

        vl = new VLibro(vp, true, fa, l, categorias, restoCategorias);
        vl.setVisible(true);
    }

    public void nuevoLibro(java.util.List<String> restoCategorias) {
        VLibro vl;

        vl = new VLibro(vp, true, fa, restoCategorias);
        vl.setVisible(true);
    }

    public void visualizaUsuario(EmpresaUsuario u) {
        VUsuario vu;
        vu = new VUsuario(vp, true, fa);
        vu.setVisible(true);
    }

    public void nuevaCategoria() {
        VCategorias vc;

        vc = new VCategorias(vp, true, fa);
        vc.setVisible(true);
    }

    public void visualizaCategoria(Categoria c) {
        VCategorias vc;
        vc = new VCategorias(vp, true, fa);
        vc.setVisible(true);
    }

    public void nuevoPrestamo(Ejemplar e) {
        VPrestamos vvp;

        vvp = new VPrestamos(vp, true, fa, e);
        vvp.setVisible(true);
    }*/
    public void nuevoBeneficio() {
        VBeneficios vb;

        vb = new VBeneficios(fa);
        vb.setVisible(true);

    }

    public void nuevasParticipaciones() {
        VParticipaciones vpart;

        vpart = new VParticipaciones(fa);
        vpart.setVisible(true);

    }

    public void muestraExcepcion(String txtExcepcion) {
        VAviso va;

        va  = new VAviso(txtExcepcion);
        va.setVisible(true);
    }

    public void nuevoUsuario() {
        VUsuario vu;

        vu = new VUsuario(fa);
        vu.setVisible(true);
    }

}

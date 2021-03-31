package gui;

import aplicacion.Categoria;
import aplicacion.Libro;
import aplicacion.Usuario;
import aplicacion.Ejemplar;

public class FachadaGui {           //Esta es la fachada

    aplicacion.FachadaAplicacion fa;
    VPrincipal vp;

    public FachadaGui(aplicacion.FachadaAplicacion fa) {
        this.fa = fa;
        this.vp = new VPrincipal(fa);
    }

    public void iniciaVista() {
        VAutentificacion va;

        va  = new VAutentificacion(vp, true, fa);
        vp.setVisible(true);
        va.setVisible(true);
    }

    public void visualizaLibro(Libro l, java.util.List<String> restoCategorias) {
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

    public void muestraExcepcion(String txtExcepcion) {
        VAviso va;

        va  = new VAviso(vp, true, txtExcepcion);
        va.setVisible(true);
    }

    public void nuevoUsuario() {
        VUsuario vu;

        vu = new VUsuario(vp, true, fa);
        vu.setVisible(true);
    }

    public void visualizaUsuario(Usuario u) {
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
    }

}

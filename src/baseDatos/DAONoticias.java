/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baseDatos;

import aplicacion.Noticias;
import java.sql.Connection;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alumnogreibd
 */
public class DAONoticias extends AbstractDAO{
    
    public DAONoticias(Connection conexion, aplicacion.FachadaAplicacion fa) {
        super.setConexion(conexion);
        super.setFachadaAplicacion(fa);
    }
    
    public void insertarNoticiaInv(String tipo, String descripcion){
        Connection con;
        PreparedStatement stmNoticia = null;
        Noticias n;

        con = super.getConexion();

        try {
            stmNoticia = con.prepareStatement("insert into noticiainversor (tiponoticia, descripcion) "
                + "values (?, ?)");
            //n=new Noticias(Integer.parseInt("idnoticia"), tipo, descripcion);
            stmNoticia.setString(1, tipo);
            stmNoticia.setString(2, descripcion);
            stmNoticia.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                stmNoticia.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
    }
    
    public void insertarNoticiaEmpr(String tipo, String descripcion){
        Connection con;
        PreparedStatement stmNoticia = null;
        Noticias n;

        con = super.getConexion();

        try {
            stmNoticia = con.prepareStatement("insert into noticiaempresa (tiponoticia, descripcion) "
                + "values (?, ?)");
            //n=new Noticias(Integer.parseInt("idnoticia"), tipo, descripcion);
            stmNoticia.setString(1, tipo);
            stmNoticia.setString(2, descripcion);
            stmNoticia.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                stmNoticia.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
    }
    
    public java.util.List<Noticias> getNoticias() {
        java.util.List<Noticias> resultado = new java.util.ArrayList<Noticias>();
        Connection con;
        PreparedStatement stmNoticias = null;
        ResultSet rsNoticias;
        String consulta;

        con = this.getConexion();

        try {
            consulta = "select * "
                    + "from noticiainversor "
                    + "UNION"
                    + "select * "
                    + "from noticiaempresa ";

            stmNoticias = con.prepareStatement(consulta);
            rsNoticias = stmNoticias.executeQuery();
            while (rsNoticias.next()) {
                resultado.add(new Noticias(rsNoticias.getInt("idnoticia"), rsNoticias.getString("tiponoticia"), rsNoticias.getString("descripcion")));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                stmNoticias.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
        return resultado;
    }
    
}

package baseDatos;

import aplicacion.Noticias;
import java.sql.Connection;
import java.sql.*;


public class DAONoticias extends AbstractDAO{
    
    public DAONoticias(Connection conexion, aplicacion.FachadaAplicacion fa) {
        super.setConexion(conexion);
        super.setFachadaAplicacion(fa);
    }
    
    public void insertarNoticia(String tipo, String descripcion, String id){
        Connection con;
        PreparedStatement stmNoticia = null;
        String consulta;

        con = super.getConexion();

        try {
            if(id.length() == 9){
                consulta = "insert into noticiainversor (idinversor, tiponoticia, descripcion) "
                        + "values (?, ?, ?)";
            }else{
                consulta = "insert into noticiaempresa (idempresa, tiponoticia, descripcion) "
                        + "values (?, ?, ?)";
            }
            stmNoticia = con.prepareStatement(consulta);
            stmNoticia.setString(1, id);
            stmNoticia.setString(2, tipo);
            stmNoticia.setString(3, descripcion);
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
    
    public java.util.List<Noticias> getNoticias(String tipo1, String tipo2, String tipo3) {
        java.util.List<Noticias> resultado = new java.util.ArrayList<Noticias>();
        Connection con;
        PreparedStatement stmNoticias = null;
        ResultSet rsNoticias;
        String consulta;

        con = this.getConexion();
        
        try {
            consulta = "select idnoticia, idinversor as idusuario, tiponoticia, descripcion "
                    + "from noticiainversor "
                    + "where tiponoticia = ? or tiponoticia = ? or tiponoticia = ? "
                    + "UNION DISTINCT "
                    + "select idnoticia, idempresa as idusuario, tiponoticia, descripcion "
                    + "from noticiaempresa "
                    + "where tiponoticia = ? or tiponoticia = ? or tiponoticia = ? ";

            stmNoticias = con.prepareStatement(consulta);
            stmNoticias.setString(1, tipo1);
            stmNoticias.setString(2, tipo2);
            stmNoticias.setString(3, tipo3);
            stmNoticias.setString(4, tipo1);
            stmNoticias.setString(5, tipo2);
            stmNoticias.setString(6, tipo3);
            rsNoticias = stmNoticias.executeQuery();
            while (rsNoticias.next()) {
                resultado.add(new Noticias(rsNoticias.getInt("idnoticia"), rsNoticias.getString("idusuario"), rsNoticias.getString("tiponoticia"), rsNoticias.getString("descripcion")));
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
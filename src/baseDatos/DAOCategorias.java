package baseDatos;

import aplicacion.Categoria;
import java.sql.*;

public class DAOCategorias extends AbstractDAO {

    public DAOCategorias(Connection conexion, aplicacion.FachadaAplicacion fa) {
        super.setConexion(conexion);
        super.setFachadaAplicacion(fa);
    }

    public java.util.List<Categoria> consultarCategorias() {
        java.util.List<Categoria> resultado = new java.util.ArrayList<Categoria>();
        Categoria categoriaActual;
        Connection con;
        PreparedStatement stmCategorias = null;
        ResultSet rsCategorias;

        con = this.getConexion();

        try {
            stmCategorias = con.prepareStatement("select nombre, descripcion from categoria");
            rsCategorias = stmCategorias.executeQuery();
            while (rsCategorias.next()) {
                categoriaActual = new Categoria(rsCategorias.getString("nombre"), rsCategorias.getString("descripcion"));
                resultado.add(categoriaActual);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                stmCategorias.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
        return resultado;
    }

    public void insertarCategoria(Categoria c) {
        Connection con;
        PreparedStatement stmCategoria = null;
        con = super.getConexion();

        try {
            stmCategoria = con.prepareStatement("insert into categoria(nombre, descripcion) "
                    + "values (?,?)");
            stmCategoria.setString(1, c.getNombre());
            stmCategoria.setString(2, c.getDescripcion());
            stmCategoria.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                stmCategoria.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }

    }

    public void modificarCategoria(Categoria c) {
        Connection con;
        PreparedStatement stmCategoria = null;
        con = super.getConexion();

        try {
            stmCategoria = con.prepareStatement("update categoria "
                    + "set descripcion=? "
                    + "where nombre=?");
            stmCategoria.setString(1, c.getDescripcion());
            stmCategoria.setString(2, c.getNombre());
            stmCategoria.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                stmCategoria.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
    }

    public java.util.List<Categoria> consultarListaCategorias(String nombre) {
        java.util.List<Categoria> resultado = new java.util.ArrayList<Categoria>();
        Categoria categoriaActual;
        Connection con;
        PreparedStatement stmCategoria = null;
        ResultSet rsCategoria;
        con = this.getConexion();

        String consulta = "select * "
                + "from categoria "
                + "where nombre like ?";

        try {
            stmCategoria = con.prepareStatement(consulta);
            stmCategoria.setString(1, "%" + nombre + "%");
            rsCategoria = stmCategoria.executeQuery();

            while (rsCategoria.next()) {
                categoriaActual = new Categoria(rsCategoria.getString("nombre"), rsCategoria.getString("descripcion"));
                resultado.add(categoriaActual);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                stmCategoria.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
        return resultado;
    }

    public void borrarCategoria(String nombre) {
        Connection con;
        PreparedStatement stmCategoria = null;

        con = super.getConexion();

        try {
            stmCategoria = con.prepareStatement("delete from categoria where nombre = ?");
            stmCategoria.setString(1, nombre);
            stmCategoria.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                stmCategoria.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
    }

}

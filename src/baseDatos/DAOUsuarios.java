
package baseDatos;

import aplicacion.Usuario;
import aplicacion.TipoUsuario;
import java.sql.*;

public class DAOUsuarios extends AbstractDAO {

    public DAOUsuarios(Connection conexion, aplicacion.FachadaAplicacion fa) {
        super.setConexion(conexion);
        super.setFachadaAplicacion(fa);
    }

    public Usuario validarUsuario(String idUsuario, String clave) {
        Usuario resultado = null;
        Connection con;
        PreparedStatement stmUsuario = null;
        ResultSet rsUsuario;

        con = this.getConexion();

        try {
            stmUsuario = con.prepareStatement("select id_usuario, clave, nombre, direccion, email, tipo_usuario "
                    + "from usuario "
                    + "where id_usuario = ? and clave = ?");
            stmUsuario.setString(1, idUsuario);
            stmUsuario.setString(2, clave);
            rsUsuario = stmUsuario.executeQuery();
            if (rsUsuario.next()) {
                resultado = new Usuario(rsUsuario.getString("id_usuario"), rsUsuario.getString("clave"),
                        rsUsuario.getString("nombre"), rsUsuario.getString("direccion"),
                        rsUsuario.getString("email"), TipoUsuario.valueOf(rsUsuario.getString("tipo_usuario")));

            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                stmUsuario.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
        return resultado;
    }

    public java.util.List<Usuario> consultarListaUsuarios(String idUsuario, String nombreUsuario) {
        java.util.List<Usuario> resultado = new java.util.ArrayList<Usuario>();
        Usuario usuarioActual;
        Connection con;
        PreparedStatement stmUsuario = null;
        ResultSet rsUsuario;
        con = this.getConexion();

        String consulta = "select * "
                + "from usuario "
                + "where id_usuario like ?"
                + "  and nombre like ?";

        try {
            stmUsuario = con.prepareStatement(consulta);
            stmUsuario.setString(1, "%" + idUsuario + "%");
            stmUsuario.setString(2, "%" + nombreUsuario + "%");
            rsUsuario = stmUsuario.executeQuery();

            while (rsUsuario.next()) {
                usuarioActual = new Usuario(rsUsuario.getString("id_usuario"), rsUsuario.getString("clave"), rsUsuario.getString("nombre"),
                        rsUsuario.getString("direccion"), rsUsuario.getString("email"), TipoUsuario.valueOf(rsUsuario.getString("tipo_usuario")));

                resultado.add(usuarioActual);

            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                stmUsuario.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
        return resultado;
    }

    public void insertarUsuario(Usuario u) {
        Connection con;
        PreparedStatement stmUsuario = null;
        con = super.getConexion();

        try {
            stmUsuario = con.prepareStatement("insert into usuario(id_usuario, clave, nombre, direccion, email, tipo_usuario) "
                    + "values (?,?,?,?,?,?)");
            stmUsuario.setString(1, u.getIdUsuario());
            stmUsuario.setString(2, u.getClave());
            stmUsuario.setString(3, u.getNombre());
            stmUsuario.setString(4, u.getDireccion());
            stmUsuario.setString(5, u.getEmail());
            stmUsuario.setString(6, u.getTipoUsuario().toString());
            stmUsuario.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                stmUsuario.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }

    }

    public void modificarUsuario(Usuario u, String id) {
        Connection con;
        PreparedStatement stmUsuarios = null;
        con = super.getConexion();

        try {
            stmUsuarios = con.prepareStatement("update usuario "
                    + "set id_usuario=?, "
                    + "    clave=?, "
                    + "    nombre=?, "
                    + "    direccion=?, "
                    + "    email=?, "
                    + "tipo_usuario=? "
                    + "where id_usuario=?");
            stmUsuarios.setString(1, u.getIdUsuario());
            stmUsuarios.setString(2, u.getClave());
            stmUsuarios.setString(3, u.getNombre());
            stmUsuarios.setString(4, u.getDireccion());
            stmUsuarios.setString(5, u.getEmail());
            stmUsuarios.setString(6, u.getTipoUsuario().toString());
            stmUsuarios.setString(7, id);
            stmUsuarios.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                stmUsuarios.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
    }

    public void borrarUsuario(String idUsuario) {
        Connection con;
        PreparedStatement stmUsuario = null;

        con = super.getConexion();

        try {
            stmUsuario = con.prepareStatement("delete from usuario where id_usuario = ?");
            stmUsuario.setString(1, idUsuario);
            stmUsuario.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                stmUsuario.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
    }

    public java.util.List<Usuario> consultarListaUsuariosPrestamo(String idUsuario, String nombreUsuario) {
        java.util.List<Usuario> resultado = new java.util.ArrayList<Usuario>();
        Usuario usuarioActual;
        Connection con;
        PreparedStatement stmUsuario = null;
        ResultSet rsUsuario;
        con = this.getConexion();
        String consulta = "select usuario.*, (select count(prestamo.*) " +
                                                             "from prestamo " +
                                                             "where usuario =usuario.id_usuario " +
                                                             "and fecha_devolucion is null " +
                                                             "and now() > (fecha_prestamo + 30)) as vencido "+
                           "from usuario "+
                           "where (usuario.id_usuario like ? and usuario.nombre like ?) ";
        
     
        try {
            stmUsuario = con.prepareStatement(consulta);
            stmUsuario.setString(1, "%" + idUsuario + "%");
            stmUsuario.setString(2, "%" + nombreUsuario + "%");

            rsUsuario = stmUsuario.executeQuery();
            
         
            while (rsUsuario.next()) {
                usuarioActual = new Usuario(rsUsuario.getString("id_usuario"), rsUsuario.getString("clave"), rsUsuario.getString("nombre"),
                        rsUsuario.getString("direccion"), rsUsuario.getString("email"), TipoUsuario.valueOf(rsUsuario.getString("tipo_usuario")));
                usuarioActual.setPrestamosVencidos(rsUsuario.getInt("vencido"));
                resultado.add(usuarioActual);

            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                stmUsuario.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
        return resultado;
    }

}


package baseDatos;

import aplicacion.EmpresaUsuario;
import aplicacion.InversorUsuario;
import aplicacion.TipoUsuario;
import java.sql.*;

public class DAOUsuarios extends AbstractDAO {

    public DAOUsuarios(Connection conexion, aplicacion.FachadaAplicacion fa) {
        super.setConexion(conexion);
        super.setFachadaAplicacion(fa);
    }

    public InversorUsuario validarUsuarioInversor(String idUsuario, String clave) {
        InversorUsuario resultado = null;
        Connection con;
        PreparedStatement stmUsuario = null;
        ResultSet rsUsuario;

        con = this.getConexion();

        try {
            stmUsuario = con.prepareStatement("select idUsuario, clave, nombre, apellido1, apellido2, direccion, telefono, tipoUsuario "
                    + "from inversorUsuario "
                    + "where idUsuario = ? and clave = ? and tipoUsuario != ?");
            stmUsuario.setString(1, idUsuario);
            stmUsuario.setString(2, clave);
            stmUsuario.setString(3, "PendienteAlta");       //Depende de la implementación, posible cambio
            rsUsuario = stmUsuario.executeQuery();
            if (rsUsuario.next()) {
                resultado = new InversorUsuario(rsUsuario.getString("idUsuario"), rsUsuario.getString("clave"),
                        rsUsuario.getString("nombre"), rsUsuario.getString("apellido1"), rsUsuario.getString("apellido2"), rsUsuario.getString("direccion"),
                        rsUsuario.getString("telefono"), TipoUsuario.valueOf(rsUsuario.getString("tipoUsuario")));

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
    
    public EmpresaUsuario validarUsuarioEmpresa(String idUsuario, String clave) {
        EmpresaUsuario resultado = null;
        Connection con;
        PreparedStatement stmUsuario = null;
        ResultSet rsUsuario;

        con = this.getConexion();

        try {
            stmUsuario = con.prepareStatement("select * "
                    + "from EmpresaUsuario "
                    + "where idUsuario = ? and clave = ? and tipoUsuario != ?");
            stmUsuario.setString(1, idUsuario);
            stmUsuario.setString(2, clave);
            stmUsuario.setString(3, "PendienteAlta");           //Igual que en validarUsuarioInversor
            rsUsuario = stmUsuario.executeQuery();
            if (rsUsuario.next()) {
                resultado = new EmpresaUsuario(rsUsuario.getString("idUsuario"), rsUsuario.getString("clave"),
                        rsUsuario.getString("nombreComercial"), rsUsuario.getString("direccion"),
                        rsUsuario.getString("telefono"), TipoUsuario.valueOf(rsUsuario.getString("tipoUsuario")));

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

    /*public java.util.List<EmpresaUsuario> consultarListaUsuarios(String idUsuario, String nombreUsuario) {
        java.util.List<EmpresaUsuario> resultado = new java.util.ArrayList<EmpresaUsuario>();
        EmpresaUsuario usuarioActual;
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
                usuarioActual = new EmpresaUsuario(rsUsuario.getString("id_usuario"), rsUsuario.getString("clave"), rsUsuario.getString("nombre"),
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
    }*/

    public void insertarUsuarioEmpresa(EmpresaUsuario u) {
        Connection con;
        PreparedStatement stmUsuario = null;
        con = super.getConexion();

        try {
            stmUsuario = con.prepareStatement("insert into usuario(idUsuario, clave, nombre, direccion, telefono, tipoUsuario) "
                    + "values (?,?,?,?,?,?)");
            stmUsuario.setString(1, u.getIdUsuario());
            stmUsuario.setString(2, u.getClave());
            stmUsuario.setString(3, u.getNombre());
            stmUsuario.setString(4, u.getDireccion());
            stmUsuario.setString(5, u.getTelefono());
            stmUsuario.setString(6, "PendienteAlta");
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
    
    public void insertarUsuarioInversor(InversorUsuario u) {
        Connection con;
        PreparedStatement stmUsuario = null;
        con = super.getConexion();

        try {
            stmUsuario = con.prepareStatement("insert into usuario(idUsuario, clave, nombre, apellido1, apellido2, direccion, telefono, tipoUsuario) "
                    + "values (?,?,?,?,?,?,?,?)");
            stmUsuario.setString(1, u.getIdUsuario());
            stmUsuario.setString(2, u.getClave());
            stmUsuario.setString(3, u.getNombre());
            stmUsuario.setString(4, u.getApellido1());
            stmUsuario.setString(5, u.getApellido2());
            stmUsuario.setString(6, u.getDireccion());
            stmUsuario.setString(7, u.getTelefono());
            stmUsuario.setString(8, "PendienteAlta");
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
    
    public void registroInversor(InversorUsuario inversor){
        Connection con;
        PreparedStatement stmUsuario = null;
        con = super.getConexion();

        try {
            stmUsuario = con.prepareStatement("update inversorUsuario"
                    + "set tipoUsuario = ?"
                    + "where idUsuario = ?");
            stmUsuario.setString(1, "Normal");
            stmUsuario.setString(2, inversor.getIdUsuario());
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
    
    public void registroEmpresa(EmpresaUsuario empresa){
        
        Connection con;
        PreparedStatement stmUsuario = null;
        con = super.getConexion();

        try {
            stmUsuario = con.prepareStatement("update empresaUsuario"
                    + "set tipoUsuario = ?"
                    + "where idUsuario = ?");
            stmUsuario.setString(1, "Normal");
            stmUsuario.setString(2, empresa.getIdUsuario());
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

    /*public void modificarUsuario(EmpresaUsuario u, String id) {
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

    public java.util.List<EmpresaUsuario> consultarListaUsuariosPrestamo(String idUsuario, String nombreUsuario) {
        java.util.List<EmpresaUsuario> resultado = new java.util.ArrayList<EmpresaUsuario>();
        EmpresaUsuario usuarioActual;
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
                usuarioActual = new EmpresaUsuario(rsUsuario.getString("id_usuario"), rsUsuario.getString("clave"), rsUsuario.getString("nombre"),
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
    }*/

}

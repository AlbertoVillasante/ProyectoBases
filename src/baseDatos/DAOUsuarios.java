package baseDatos;

import aplicacion.EmpresaUsuario;
import aplicacion.Estadisticas;
import aplicacion.InversorUsuario;
import aplicacion.Saldos;
import aplicacion.TipoUsuario;
import aplicacion.prestamo;
import java.sql.*;
import java.util.ArrayList;

public class DAOUsuarios extends AbstractDAO {

    public DAOUsuarios(Connection conexion, aplicacion.FachadaAplicacion fa) {
        super.setConexion(conexion);
        super.setFachadaAplicacion(fa);
    }

    public java.util.List<InversorUsuario> mostrarUsuarioInvPend() {
        java.util.List<InversorUsuario> resultado = new java.util.ArrayList<InversorUsuario>();
        InversorUsuario inversor;
        Connection con;
        PreparedStatement stmInversor = null;
        ResultSet rsUsuario;

        con = this.getConexion();

        try {
            stmInversor = con.prepareStatement("select idUsuario, clave, nombre, apellido1, apellido2, direccion, telefono, tipoUsuario "
                    + "from inversorusuario "
                    + "where tipoUsuario = ? or tipoUsuario = ?");
            stmInversor.setString(1, "PendAlta");
            stmInversor.setString(2, "PendBaja");
            rsUsuario = stmInversor.executeQuery();
            while (rsUsuario.next()) {
                inversor = new InversorUsuario(rsUsuario.getString("idUsuario"), rsUsuario.getString("clave"),
                        rsUsuario.getString("nombre"), rsUsuario.getString("apellido1"), rsUsuario.getString("apellido2"), rsUsuario.getString("direccion"),
                        rsUsuario.getString("telefono"), TipoUsuario.valueOf(rsUsuario.getString("tipoUsuario")));
                resultado.add(inversor);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                stmInversor.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
        return resultado;
    }

    public java.util.List<EmpresaUsuario> mostrarUsuarioEmprPend() {
        java.util.List<EmpresaUsuario> resultado = new java.util.ArrayList<EmpresaUsuario>();
        EmpresaUsuario empresa;
        Connection con;
        PreparedStatement stmEmpresa = null;
        ResultSet rsUsuario;

        con = this.getConexion();

        try {
            stmEmpresa = con.prepareStatement("select * "
                    + "from EmpresaUsuario "
                    + "where tipoUsuario = ? or tipoUsuario = ?");
            stmEmpresa.setString(1, "PendAlta");
            stmEmpresa.setString(2, "PendBaja");
            rsUsuario = stmEmpresa.executeQuery();
            while (rsUsuario.next()) {
                empresa = new EmpresaUsuario(rsUsuario.getString("idUsuario"), rsUsuario.getString("clave"),
                        rsUsuario.getString("nombreComercial"), rsUsuario.getString("direccion"),
                        rsUsuario.getString("telefono"), TipoUsuario.valueOf(rsUsuario.getString("tipoUsuario")));
                resultado.add(empresa);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                stmEmpresa.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
        return resultado;
    }

    public InversorUsuario validarUsuarioInversor(String idUsuario, String clave) {
        InversorUsuario resultado = null;
        Connection con;
        PreparedStatement stmUsuario = null;
        ResultSet rsUsuario;

        con = this.getConexion();

        try {
            stmUsuario = con.prepareStatement("select * "
                    + "from inversorUsuario "
                    + "where idUsuario = ? and clave = ?");
            stmUsuario.setString(1, idUsuario);
            stmUsuario.setString(2, clave);
            rsUsuario = stmUsuario.executeQuery();
            if (rsUsuario.next()) {
                resultado = new InversorUsuario(rsUsuario.getString("idUsuario"), rsUsuario.getString("clave"),
                        rsUsuario.getString("nombre"), rsUsuario.getString("apellido1"), rsUsuario.getString("apellido2"), rsUsuario.getString("direccion"),
                        rsUsuario.getString("telefono"), TipoUsuario.valueOf(rsUsuario.getString("tipoUsuario")));
                resultado.setFondosDisponiblesCuenta(rsUsuario.getFloat("fondosDisponiblesCuenta"));
            }
            try {
                stmUsuario = null;                                 
                stmUsuario = con.prepareStatement("select valor "
                        + "from comision "
                        + "where fechaComision = ( select max(fechaComision) from comision)");
                rsUsuario = null;
                rsUsuario = stmUsuario.executeQuery();
                if (rsUsuario.next() && resultado != null) {
                    resultado.setComision(Float.parseFloat(rsUsuario.getString("valor")));
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
                    + "where idUsuario = ? and clave = ?");
            stmUsuario.setString(1, idUsuario);
            stmUsuario.setString(2, clave);
            rsUsuario = stmUsuario.executeQuery();
            if (rsUsuario.next()) {
                resultado = new EmpresaUsuario(rsUsuario.getString("idUsuario"), rsUsuario.getString("clave"),
                        rsUsuario.getString("nombreComercial"), rsUsuario.getString("direccion"),
                        rsUsuario.getString("telefono"), TipoUsuario.valueOf(rsUsuario.getString("tipoUsuario")));
                resultado.setnParticipaciones(Integer.parseInt(rsUsuario.getString("numeroParticipaciones")));
                resultado.setFondosDisponiblesCuenta(rsUsuario.getFloat("fondosDisponiblesCuenta"));
                resultado.setValorParticipaciones(rsUsuario.getDouble("valorParticipaciones"));

            }
            try {
                stmUsuario = null;
                stmUsuario = con.prepareStatement("select valor "
                        + "from comision "
                        + "where fechaComision = ( select max(fechaComision) from comision)");
                rsUsuario = null;
                rsUsuario = stmUsuario.executeQuery();
                if (rsUsuario.next() && resultado != null) {
                    resultado.setComision(Float.parseFloat(rsUsuario.getString("valor")));
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

    public void insertarUsuarioEmpresa(EmpresaUsuario u) {
        Connection con;
        PreparedStatement stmUsuario = null;
        con = super.getConexion();

        try {
            stmUsuario = con.prepareStatement("insert into empresaUsuario(idUsuario, clave, nombreComercial, direccion, telefono, tipoUsuario) "
                    + "values (?,?,?,?,?,?)");
            stmUsuario.setString(1, u.getIdUsuario());
            stmUsuario.setString(2, u.getClave());
            stmUsuario.setString(3, u.getNombreComercial());
            stmUsuario.setString(4, u.getDireccion());
            stmUsuario.setString(5, u.getTelefono());
            stmUsuario.setString(6, "PendAlta");
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
            stmUsuario = con.prepareStatement("insert into inversorUsuario(idUsuario, clave, nombre, apellido1, apellido2, direccion, telefono, tipoUsuario) "
                    + "values (?,?,?,?,?,?,?,?)");
            stmUsuario.setString(1, u.getIdUsuario());
            stmUsuario.setString(2, u.getClave());
            stmUsuario.setString(3, u.getNombre());
            stmUsuario.setString(4, u.getApellido1());
            stmUsuario.setString(5, u.getApellido2());
            stmUsuario.setString(6, u.getDireccion());
            stmUsuario.setString(7, u.getTelefono());
            stmUsuario.setString(8, "PendAlta");
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

    public void registroInversor(InversorUsuario inversor) {
        Connection con;
        PreparedStatement stmUsuario = null;
        con = super.getConexion();

        try {
            stmUsuario = con.prepareStatement("update inversorUsuario "
                    + "set tipoUsuario = ? "
                    + "where idUsuario = ? ");
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

    public void registroEmpresa(EmpresaUsuario empresa) {

        Connection con;
        PreparedStatement stmUsuario = null;
        con = super.getConexion();

        try {
            stmUsuario = con.prepareStatement("update empresaUsuario "
                    + "set tipoUsuario = ? "
                    + "where idUsuario = ? ");
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

    public int comprobarIdInversor(String id) { 
        Integer resultado = null;
        Connection con;
        PreparedStatement stmPrestamos = null;
        ResultSet rsPrestamos;
        String consulta;

        con = this.getConexion();

        try {
            consulta = "select count(*) as ids "
                    + "from inversorUsuario "
                    + "where idUsuario = ? ";

            stmPrestamos = con.prepareStatement(consulta);
            stmPrestamos.setString(1, id);
            rsPrestamos = stmPrestamos.executeQuery();
            if (rsPrestamos.next()) {
                resultado = rsPrestamos.getInt("ids");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                stmPrestamos.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
        return resultado;
    }

    public int comprobarIdEmpresa(String id) {
        Integer resultado = null;
        Connection con;
        PreparedStatement stmPrestamos = null;
        ResultSet rsPrestamos;
        String consulta;

        con = this.getConexion();

        try {
            consulta = "select count(*) as ids "
                    + "from empresaUsuario "
                    + "where idUsuario = ? ";

            stmPrestamos = con.prepareStatement(consulta);
            stmPrestamos.setString(1, id);
            rsPrestamos = stmPrestamos.executeQuery();
            if (rsPrestamos.next()) {
                resultado = rsPrestamos.getInt("ids");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                stmPrestamos.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
        return resultado;
    }

    public void modificarUsuarioEmpresa(EmpresaUsuario u) {
        Connection con;
        PreparedStatement stmUsuarios = null;
        con = super.getConexion();

        try {
            stmUsuarios = con.prepareStatement("update empresaUsuario "
                    + "set clave = ?, nombrecomercial = ?, direccion = ?, telefono = ? "
                    + "where idusuario= ?");

            stmUsuarios.setString(1, u.getClave());
            stmUsuarios.setString(2, u.getNombreComercial());
            stmUsuarios.setString(3, u.getDireccion());
            stmUsuarios.setString(4, u.getTelefono());
            stmUsuarios.setString(5, u.getIdUsuario());
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

    public void modificarRegulador(InversorUsuario u) {
        Connection con;
        PreparedStatement stmUsuarios = null;
        con = super.getConexion();

        try {
            stmUsuarios = con.prepareStatement("update inversorUsuario "
                    + "set clave = ?, direccion = ?, telefono = ? "
                    + "where idusuario = ?");

            stmUsuarios.setString(1, u.getClave());
            stmUsuarios.setString(2, u.getDireccion());
            stmUsuarios.setString(3, u.getTelefono());
            stmUsuarios.setString(4, u.getIdUsuario());
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

    public void modificarUsuarioInversor(InversorUsuario u) {
        Connection con;
        PreparedStatement stmUsuarios = null;
        con = super.getConexion();

        try {
            stmUsuarios = con.prepareStatement("update inversorUsuario "
                    + "set clave = ?, nombre = ?, apellido1 = ?, apellido2 = ?, direccion = ?, telefono = ? "
                    + "where idusuario= ?");  

            stmUsuarios.setString(1, u.getClave());
            stmUsuarios.setString(2, u.getNombre());
            stmUsuarios.setString(3, u.getApellido1());
            stmUsuarios.setString(4, u.getApellido2());
            stmUsuarios.setString(5, u.getDireccion());
            stmUsuarios.setString(6, u.getTelefono());
            stmUsuarios.setString(7, u.getIdUsuario());
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

    public void solicitarBajaInversor(String id) {
        Connection con;
        PreparedStatement stmUsuario = null;
        con = super.getConexion();
        try {
            stmUsuario = con.prepareStatement("update inversorUsuario "
                    + "set tipoUsuario = ? "
                    + "where idUsuario = ?");

            stmUsuario.setString(1, "PendBaja");
            stmUsuario.setString(2, id);
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

    public void solicitarBajaEmpresa(String id) {
        Connection con;
        PreparedStatement stmUsuario = null;
        con = super.getConexion();
        try {
            stmUsuario = con.prepareStatement("update empresaUsuario "
                    + "set tipoUsuario = ? "
                    + "where idUsuario = ?");

            stmUsuario.setString(1, "PendBaja");
            stmUsuario.setString(2, id);
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

    public void modificarCuentaInversor(InversorUsuario usuario) {
        Connection con;
        PreparedStatement stmUsuarios = null;
        con = super.getConexion();

        try {
            stmUsuarios = con.prepareStatement("update inversorUsuario "
                    + "set fondosDisponiblesCuenta = ? "
                    + "where idusuario= ?");

            stmUsuarios.setDouble(1, usuario.getFondosDisponiblesCuenta());
            stmUsuarios.setString(2, usuario.getIdUsuario());
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

    public void modificarCuentaEmpresa(EmpresaUsuario usuario) {
        Connection con;
        PreparedStatement stmUsuarios = null;
        con = super.getConexion();

        try {
            stmUsuarios = con.prepareStatement("update empresaUsuario "
                    + "set fondosDisponiblesCuenta = ? "
                    + "where idusuario= ?");

            stmUsuarios.setDouble(1, usuario.getFondosDisponiblesCuenta());
            stmUsuarios.setString(2, usuario.getIdUsuario());
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

    public void confirmarBajaInversor(String id) {
        Connection con;
        PreparedStatement stmUsuarios = null;
        con = super.getConexion();

        try {
            stmUsuarios = con.prepareStatement("update inversorUsuario "
                    + "set fondosDisponiblesCuenta = 0.0 "
                    + "where idUsuario = ? "
                    + "and 0 = (SELECT COUNT(p.idUsuario2) "
                    + "FROM poseerparticipacionesinversor as p, inversorUsuario as i "
                    + "WHERE i.idUsuario = ? "
                    + "and i.idUsuario = p.idUsuario1 "
                    + "and p.numparticipaciones <> 0 )");

            stmUsuarios.setString(1, id);
            stmUsuarios.setString(2, id);
            stmUsuarios.executeUpdate();

            try {
                stmUsuarios = con.prepareStatement("delete from inversorUsuario "
                        + "where idUsuario = ? and 0 = (SELECT COUNT(p.idUsuario2) "
                        + "FROM poseerparticipacionesinversor as p, inversorUsuario as i "
                        + "WHERE i.idUsuario = ? "
                        + "and i.idUsuario = p.idUsuario1 "
                        + "and p.numparticipaciones <> 0 )");

                stmUsuarios.setString(1, id);
                stmUsuarios.setString(2, id);
                stmUsuarios.executeUpdate();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
                this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
            }
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

    public void confirmarBajaEmpresa(String id) {
        Connection con;
        PreparedStatement stmUsuarios = null;
        con = super.getConexion();

        try {
            stmUsuarios = con.prepareStatement("update empresaUsuario "
                    + "set fondosDisponiblesCuenta = 0.0 "
                    + "where idUsuario = ? "
                    + "and 0 = (SELECT COUNT(p.idUsuario2) "
                    + "FROM poseerparticipacionesempresa as p, empresaUsuario as i "
                    + "WHERE i.idUsuario = ? "
                    + "and i.idUsuario = p.idUsuario1 "
                    + "and p.numparticipaciones <> 0 )");

            stmUsuarios.setString(1, id);
            stmUsuarios.setString(2, id);
            stmUsuarios.executeUpdate();

            try {
                stmUsuarios = con.prepareStatement("delete from empresaUsuario "
                        + "where idUsuario = ? and 0 = (SELECT COUNT(p.idUsuario2) "
                        + "FROM poseerparticipacionesempresa as p, empresaUsuario as i "
                        + "WHERE i.idUsuario = ? "
                        + "and i.idUsuario = p.idUsuario1 "
                        + "and p.numparticipaciones <> 0 )");

                stmUsuarios.setString(1, id);
                stmUsuarios.setString(2, id);
                stmUsuarios.executeUpdate();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
                this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
            }
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

    public void actualizarComision(float valor) {
        Connection con;
        PreparedStatement stmComision = null;

        con = super.getConexion();

        try {
            stmComision = con.prepareStatement("insert into Comision "
                    + "values (?, now())");

            stmComision.setFloat(1, valor);
            stmComision.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                stmComision.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
    }

    public ArrayList<String> getEmpresas() {
        ArrayList<String> resultado = new ArrayList<String>();
        Connection con;
        PreparedStatement stmPrestamos = null;
        ResultSet rsPrestamos;
        String consulta;

        con = this.getConexion();

        try {
            consulta = "select nombreComercial "
                    + "from empresausuario as e "
                    + "order by e.nombreComercial";

            stmPrestamos = con.prepareStatement(consulta);
            rsPrestamos = stmPrestamos.executeQuery();
            while (rsPrestamos.next()) {
                resultado.add(rsPrestamos.getString("nombreComercial"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                stmPrestamos.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
        return resultado;
    }

    public ArrayList<Saldos> getSaldoUsuarios() {
        ArrayList<Saldos> resultado = new ArrayList<Saldos>();
        Connection con;
        PreparedStatement stmPrestamos = null;
        ResultSet rsPrestamos;
        String consulta;

        con = this.getConexion();

        try {
            consulta = "SELECT idusuario, fondosdisponiblescuenta "
                    + "FROM empresausuario "
                    + "UNION "
                    + "SELECT idusuario, fondosdisponiblescuenta "
                    + "FROM inversorusuario";

            stmPrestamos = con.prepareStatement(consulta);
            rsPrestamos = stmPrestamos.executeQuery();
            while (rsPrestamos.next()) {
                resultado.add(new Saldos(rsPrestamos.getString("idusuario"), Double.valueOf(rsPrestamos.getString("fondosdisponiblescuenta"))));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                stmPrestamos.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
        return resultado;
    }

    public ArrayList<Saldos> getSaldoUsuario(String id) {
        ArrayList<Saldos> resultado = new ArrayList<Saldos>();
        Connection con;
        PreparedStatement stmPrestamos = null;
        ResultSet rsPrestamos;
        String consulta;

        con = this.getConexion();
        try {
            consulta = "SELECT idusuario, fondosdisponiblescuenta "
                    + "FROM inversorusuario "
                    + "WHERE idusuario like ? "
                    + "UNION "
                    + "SELECT idusuario, fondosdisponiblescuenta "
                    + "FROM empresausuario "
                    + "WHERE idusuario like ?";
            stmPrestamos = con.prepareStatement(consulta);
            stmPrestamos.setString(1, id + "%");
            stmPrestamos.setString(2, id + "%");
            rsPrestamos = stmPrestamos.executeQuery();
            while (rsPrestamos.next()) {
                resultado.add(new Saldos(rsPrestamos.getString("idusuario"), Double.valueOf(rsPrestamos.getString("fondosdisponiblescuenta"))));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                stmPrestamos.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
        return resultado;
    }

    public ArrayList<Estadisticas> actualizarTablaEstadisticasInversor(String id) {
        ArrayList<Estadisticas> resultado = new ArrayList<Estadisticas>();
        Estadisticas est;
        Connection con;
        PreparedStatement stmEstadistica = null;
        ResultSet rsEstadistica;
        String consulta;
        String aux;

        con = this.getConexion();

        try {
            consulta = "select * "
                    + "from poseerparticipacionesinversor as ppi "
                    + "where ppi.idusuario1 = ?";

            stmEstadistica = con.prepareStatement(consulta);
            stmEstadistica.setString(1, id);
            rsEstadistica = stmEstadistica.executeQuery();
            while (rsEstadistica.next()) {
                aux = getnombreEmpresa(rsEstadistica.getString("idUsuario2"));
                est = new Estadisticas(rsEstadistica.getInt("numParticipaciones"), aux);
                resultado.add(est);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                stmEstadistica.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
        return resultado;
    }

    public ArrayList<Estadisticas> actualizarTablaEstadisticasEmpresa(String id) {
        ArrayList<Estadisticas> resultado = new ArrayList<Estadisticas>();
        Estadisticas est;
        Connection con;
        PreparedStatement stmEstadistica = null;
        ResultSet rsEstadistica;
        String consulta;
        String aux;

        con = this.getConexion();

        try {
            consulta = "select * "
                    + "from poseerparticipacionesempresa as ppe "
                    + "where ppe.idusuario1 = ?";

            stmEstadistica = con.prepareStatement(consulta);
            stmEstadistica.setString(1, id);
            rsEstadistica = stmEstadistica.executeQuery();
            while (rsEstadistica.next()) {
                aux = getnombreEmpresa(rsEstadistica.getString("idUsuario2"));
                est = new Estadisticas(rsEstadistica.getInt("numParticipaciones"), aux);
                resultado.add(est);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                stmEstadistica.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
        return resultado;
    }

    public ArrayList<String> getEmpresasInv(String id) {
        ArrayList<String> resultado = new ArrayList<String>();
        Connection con;
        PreparedStatement stmPrestamos = null;
        ResultSet rsPrestamos;
        String consulta;

        con = this.getConexion();

        try {
            consulta = "select distinct e.nombreComercial "
                    + "from empresausuario as e, poseerparticipacionesinversor as p "
                    + "WHERE e.idusuario=p.idusuario2 and p.idusuario1 = ? and p.numparticipaciones <> 0 "
                    + "order by e.nombreComercial ";

            stmPrestamos = con.prepareStatement(consulta);
            stmPrestamos.setString(1, id);
            rsPrestamos = stmPrestamos.executeQuery();
            while (rsPrestamos.next()) {
                resultado.add(rsPrestamos.getString("nombreComercial"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                stmPrestamos.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
        return resultado;
    }

    public ArrayList<String> getEmpresasEmpr(String id) {
        ArrayList<String> resultado = new ArrayList<String>();
        Connection con;
        PreparedStatement stmPrestamos = null;
        ResultSet rsPrestamos;
        String consulta;

        con = this.getConexion();

        try {
            consulta = "select distinct e.nombreComercial "
                    + "from empresausuario as e, poseerparticipacionesempresa as p "
                    + "where e.idusuario=p.idusuario2 and p.idusuario1 = ? and p.numparticipaciones <> 0 "
                    + "order by e.nombreComercial";

            stmPrestamos = con.prepareStatement(consulta);
            stmPrestamos.setString(1, id);
            rsPrestamos = stmPrestamos.executeQuery();
            while (rsPrestamos.next()) {
                resultado.add(rsPrestamos.getString("nombreComercial"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                stmPrestamos.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
        return resultado;
    }

    public String getIdEmpresa(String nombre) {
        String resultado = null;
        Connection con;
        PreparedStatement stmEmpresa = null;
        ResultSet rsEmpresa;

        con = this.getConexion();
        try {
            stmEmpresa = con.prepareStatement("select idUsuario "
                    + "from EmpresaUsuario "
                    + "where nombreComercial = ?");

            stmEmpresa.setString(1, nombre);
            rsEmpresa = stmEmpresa.executeQuery();

            if (rsEmpresa.next()) {
                resultado = rsEmpresa.getString("idUsuario");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                stmEmpresa.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
        return resultado;
    }

    public String getnombreEmpresa(String id) {
        String resultado = null;
        Connection con;
        PreparedStatement stmEmpresa = null;
        ResultSet rsEmpresa;

        con = this.getConexion();
        try {
            stmEmpresa = con.prepareStatement("select nombreComercial "
                    + "from EmpresaUsuario "
                    + "where idUsuario = ?");

            stmEmpresa.setString(1, id);
            rsEmpresa = stmEmpresa.executeQuery();

            if (rsEmpresa.next()) {
                resultado = rsEmpresa.getString("nombreComercial");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                stmEmpresa.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
        return resultado;
    }

    public double getRendimientoInversor(String idUsuario) {
        double rendimiento = 1.0;
        Connection con;
        PreparedStatement stmUsuario = null;
        ResultSet rsUsuario;
        con = this.getConexion();

        try {
            stmUsuario = con.prepareStatement("select ((fondosDisponiblesCuenta-fondosInicialesCuenta + "
                    + "(SELECT SUM(ppi.numParticipaciones * eu.valorParticipaciones) as dineroEnAcciones "
                    + "			FROM poseerParticipacionesInversor as ppi, empresaUsuario as eu "
                    + "			where ppi.idUsuario1 = ? and ppi.idUsuario2 = eu.idUsuario) "
                    + ") / fondosInicialesCuenta) as rendimiento "
                    + "from inversorUsuario where "
                    + "fondosInicialesCuenta <>0 and  idUsuario = ?");

            stmUsuario.setString(1, idUsuario);
            stmUsuario.setString(2, idUsuario);
            rsUsuario = stmUsuario.executeQuery();

            if (rsUsuario.next()) {
                rendimiento = rsUsuario.getDouble("rendimiento");
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
        return rendimiento * 100;
    }

    public double getRendimientoEmpresa(String idUsuario) {
        double rendimiento = 1.0;
        Connection con;
        PreparedStatement stmUsuario = null;
        ResultSet rsUsuario;

        con = this.getConexion();
        try {
            stmUsuario = con.prepareStatement("select ((fondosDisponiblesCuenta-fondosInicialesCuenta + "
                    + "(SELECT SUM(ppe.numParticipaciones * eu.valorParticipaciones) as dineroEnAcciones "
                    + "			FROM poseerParticipacionesEmpresa as ppe, empresaUsuario as eu "
                    + "			where ppe.idUsuario1 = ? and ppe.idUsuario2 = eu.idUsuario)"
                    + ") / fondosInicialesCuenta)  as rendimiento "
                    + "from empresaUsuario where "
                    + "fondosInicialesCuenta <>0 and  idUsuario = ?");

            stmUsuario.setString(1, idUsuario);
            stmUsuario.setString(2, idUsuario);
            rsUsuario = stmUsuario.executeQuery();

            if (rsUsuario.next()) {
                rendimiento = rsUsuario.getDouble("rendimiento");
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
        return rendimiento * 100;
    }

    public String getnombreInversor(String id) {
        String resultado = null;
        Connection con;
        PreparedStatement stmEmpresa = null;
        ResultSet rsEmpresa;

        con = this.getConexion();
        try {
            stmEmpresa = con.prepareStatement("select nombre "
                    + "from InversorUsuario "
                    + "where idUsuario = ?");

            stmEmpresa.setString(1, id);
            rsEmpresa = stmEmpresa.executeQuery();

            if (rsEmpresa.next()) {
                resultado = rsEmpresa.getString("nombre");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                stmEmpresa.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
        return resultado;
    }

    public void eliminarInversor(String id) {
        Connection con;
        PreparedStatement stmUsuario = null;
        con = this.getConexion();

        try {
            stmUsuario = con.prepareStatement("delete from inversorusuario where idusuario = ?");
            stmUsuario.setString(1, id);
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

    public void eliminarEmpresa(String id) {
        Connection con;
        PreparedStatement stmUsuario = null;

        con = this.getConexion();

        try {
            stmUsuario = con.prepareStatement("delete from empresausuario where idusuario = ?");
            stmUsuario.setString(1, id);
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

    public void estadoNormalInv(String id) {
        Connection con;
        PreparedStatement stmUsuario = null;

        con = this.getConexion();

        try {
            stmUsuario = con.prepareStatement("update inversorUsuario "
                    + "set tipousuario = ? "
                    + "where idUsuario = ? ");
            stmUsuario.setString(1, "Normal");
            stmUsuario.setString(2, id);
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

    public void estadoNormalEmpr(String id) {
        Connection con;
        PreparedStatement stmUsuario = null;

        con = this.getConexion();

        try {
            stmUsuario = con.prepareStatement("update empresaUsuario "
                    + "set tipousuario = ? "
                    + "where idUsuario = ? ");
            stmUsuario.setString(1, "Normal");
            stmUsuario.setString(2, id);
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

    public void cambiarSaldoUsuario(Saldos s) {
        Connection con;
        PreparedStatement stmUsuario = null;
        String consulta;

        con = this.getConexion();

        try {

            if (s.getUsuario().length() == 9) {
                consulta = "update inversorUsuario "
                        + "set fondosDisponiblesCuenta = ? "
                        + "where idUsuario = ? ";
            } else {
                consulta = "update empresaUsuario "
                        + "set fondosDisponiblesCuenta = ? "
                        + "where idUsuario = ? ";
            }

            stmUsuario = con.prepareStatement(consulta);
            stmUsuario.setDouble(1, s.getSaldo());
            stmUsuario.setString(2, s.getUsuario());
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

    public void cambiarSaldoUsuarioInicial(Saldos s) {
        Connection con;
        PreparedStatement stmUsuario = null;
        String consulta;

        con = this.getConexion();

        try {

            if (s.getUsuario().length() == 9) {
                consulta = "update inversorUsuario "
                        + "set fondosInicialesCuenta = ? "
                        + "where idUsuario = ? ";
            } else {
                consulta = "update empresaUsuario "
                        + "set fondosInicialesCuenta = ? "
                        + "where idUsuario = ? ";
            }

            stmUsuario = con.prepareStatement(consulta);
            stmUsuario.setDouble(1, s.getSaldo());
            stmUsuario.setString(2, s.getUsuario());
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

    public void actualizaSaldoEmpresa(EmpresaUsuario eu, double precio) {
        Connection con;
        PreparedStatement stmUsuario = null;
        String consulta;

        con = this.getConexion();

        try {
            consulta = "update EmpresaUsuario "
                    + "set valorParticipaciones = ? "
                    + "where idUsuario = ? ";

            stmUsuario = con.prepareStatement(consulta);
            stmUsuario.setDouble(1, precio);
            stmUsuario.setString(2, eu.getIdUsuario());
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

    public ArrayList<prestamo> getPrestamo() {
        ArrayList<prestamo> resultado = new ArrayList<prestamo>();
        Connection con;
        PreparedStatement stmPrestamos = null;
        ResultSet rsPrestamos;
        String consulta;
        prestamo p;

        con = this.getConexion();

        try {
            consulta = "select e.nombreComercial, e.idUsuario, e.valorParticipaciones "
                    + "from empresausuario as e";

            stmPrestamos = con.prepareStatement(consulta);
            rsPrestamos = stmPrestamos.executeQuery();
            while (rsPrestamos.next()) {
                p= new prestamo(rsPrestamos.getString("idUsuario"), rsPrestamos.getString("nombreComercial"), rsPrestamos.getDouble("valorParticipaciones"));
                resultado.add(p);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                stmPrestamos.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
        return resultado;
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baseDatos;

import aplicacion.EmpresaUsuario;
import aplicacion.TipoUsuario;
import aplicacion.OfertaParticipaciones;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DAOParticipaciones extends AbstractDAO {

    public DAOParticipaciones(Connection conexion, aplicacion.FachadaAplicacion fa) {
        super.setConexion(conexion);
        super.setFachadaAplicacion(fa);
    }

    
    //FUNCION DE ALTA MODIFICADA POR HUGO: CREO QUE SERÍA ALGO ASÍ:
       public void altaParticipacionesEmpresa(int participaciones, String id) {
        Connection con;
        PreparedStatement stmParticipaciones = null;
        con = super.getConexion();
        String consulta ="update EmpresaUsuario "
                        +"set numeroParticipaciones = numeroParticipaciones + ? "
                        +"where idUsuario=?; ";
        
        if(poseerYaParticipacionesEmpresa(id, id)){ //duda
            consulta += "update poseerParticipacionesEmpresa "
                       +"set numParticipaciones = numParticipaciones + ? "
                       +"where idUsuario1 = ? and idUsuario2 = ?;";
        }else{
            consulta += "insert into poseerParticipacionesEmpresa values (?, ?, ?);";
        }

        try {
            
            con.setAutoCommit(false);
            stmParticipaciones = con.prepareStatement(consulta);
            //Para la tabla empresaUsuario
            stmParticipaciones.setInt(1, participaciones);
            stmParticipaciones.setString(2, id);
            
            //Para la tabla poseerParticipacionesEmpresa
            stmParticipaciones.setInt(3, participaciones);
            stmParticipaciones.setString(4, id);
            stmParticipaciones.setString(5, id);

            stmParticipaciones.executeUpdate();
            con.commit();
            con.setAutoCommit(true);
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            try {
                con.rollback();
            } catch (SQLException ex) {
                Logger.getLogger(DAOParticipaciones.class.getName()).log(Level.SEVERE, null, ex);
            }
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                stmParticipaciones.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
    }
       
    public int participacionesComprobarBaja(String id){
        int participaciones=0;
        Connection con;
        PreparedStatement stmParticipaciones = null;
        ResultSet rsBaja;
        con = super.getConexion();

        try {
            stmParticipaciones = con.prepareStatement("select numParticipaciones from poseerParticipacionesEmpresa where idUsuario1=? and idUsuario2=?");
            stmParticipaciones.setString(1, id);
            stmParticipaciones.setString(2, id);
            rsBaja = stmParticipaciones.executeQuery();
            if (rsBaja.next()) {
                participaciones = rsBaja.getInt("numParticipaciones");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                stmParticipaciones.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
        return participaciones;  
    }
    
    public void bajaParticipacionesEmpresa(int participaciones, String id) {
        Connection con;
        PreparedStatement stmParticipaciones = null;
        con = super.getConexion();
        String consulta ="update EmpresaUsuario "
                        +"set numeroParticipaciones = numeroParticipaciones - ? "
                        +"where idUsuario=?; ";
        
        
        consulta += "update poseerParticipacionesEmpresa "
                    +"set numParticipaciones = numParticipaciones - ? "
                    +"where idUsuario1 = ? and idUsuario2 = ?;";
        

        try {
            
            con.setAutoCommit(false);
            stmParticipaciones = con.prepareStatement(consulta);
            //Para la tabla empresaUsuario
            stmParticipaciones.setInt(1, participaciones);
            stmParticipaciones.setString(2, id);
            
            //Para la tabla poseerParticipacionesEmpresa
            stmParticipaciones.setInt(3, participaciones);
            stmParticipaciones.setString(4, id);
            stmParticipaciones.setString(5, id);

            stmParticipaciones.executeUpdate();
            con.commit();
            con.setAutoCommit(true);
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            try {
                con.rollback();
            } catch (SQLException ex) {
                Logger.getLogger(DAOParticipaciones.class.getName()).log(Level.SEVERE, null, ex);
            }
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                stmParticipaciones.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
    }

    public void ventaParticipacionesInv(String idempresa, int nparticipaciones, String idinv) {
        Connection con;
        PreparedStatement stmUsuarios = null;
        con = super.getConexion();

        try {
            stmUsuarios = con.prepareStatement("update poseerparticipacionesinversor "
                    + "set numparticipaciones = numparticipaciones-nparticipaciones "
                    + "where idUsuario1 = ? and idUsuario2 = ? "
                    + "and nparticipaciones <= (SELECT numparticipaciones "
                    + "FROM poseerparticipacionesinversor as p, inversorUsuario as i "
                    + "WHERE i.idUsuario = ? and p.idUsuario2 = ? "
                    + "and i.idUsuario = p.idUsuario1)");

            stmUsuarios.setString(1, idempresa);
            stmUsuarios.setString(2, idinv);
            stmUsuarios.setString(3, idinv);
            stmUsuarios.setString(4, idempresa);
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

    public void ventaParticipacionesEmpr(String idempresa, int nparticipaciones, String idempresa2) { //idempresa es la que posee las participaciones
        Connection con;
        PreparedStatement stmUsuarios = null;
        con = super.getConexion();

        try {
            stmUsuarios = con.prepareStatement("update poseerparticipacionesempresa "
                    + "set numparticipaciones = numparticipaciones-nparticipaciones "
                    + "where idUsuario1 = ? and idUsuario2 = ? "
                    + "and nparticipaciones <= (SELECT numparticipaciones "
                    + "FROM poseerparticipacionesempresa as p, empresaUsuario as e "
                    + "WHERE e.idUsuario = ? and p.idUsuario2 = ? "
                    + "and i.idUsuario = p.idUsuario1)");

            stmUsuarios.setString(1, idempresa);
            stmUsuarios.setString(2, idempresa2);
            stmUsuarios.setString(3, idempresa);
            stmUsuarios.setString(4, idempresa2);
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

    public java.util.List<OfertaParticipaciones> mostrarVentas() {
        java.util.List<OfertaParticipaciones> resultado = new java.util.ArrayList<OfertaParticipaciones>();
        OfertaParticipaciones v;
        Connection con;
        PreparedStatement stmVenta = null;
        ResultSet rsVenta;

        con = this.getConexion();

        try {
            stmVenta = con.prepareStatement("select o.precio, o.numeroparticipaciones, o.idUsuario2, o.idUsuario1 "
                    + "from ofertaparticipacionesventainversor as o, poseerparticipacionesinversor as p "
                    + "where o.numeroparticipaciones <= p.numparticipaciones and o.idUsuario1 = p.idUsuario1 and o.idUsuario2 = p.idUsuario2 ");
            rsVenta = stmVenta.executeQuery();
            while (rsVenta.next()) {
                v = new OfertaParticipaciones(rsVenta.getFloat("precio"), rsVenta.getInt("numeroparticipaciones"), rsVenta.getString("idUsuario2"), rsVenta.getString("idUsuario1"));
                resultado.add(v);
            }

            try {
                stmVenta = con.prepareStatement("select o.precio, o.numeroparticipaciones, o.idUsuario2, o.idUsuario1 "
                        + "from ofertaparticipacionesventaempresa as o, poseerparticipacionesempresa as p "
                        + "where o.numeroparticipaciones <= p.numparticipaciones and o.idUsuario1 = p.idUsuario1 and o.idUsuario2 = p.idUsuario2 ");
                rsVenta = stmVenta.executeQuery();
                while (rsVenta.next()) {
                    v = new OfertaParticipaciones(rsVenta.getFloat("precio"), rsVenta.getInt("numeroparticipaciones"), rsVenta.getString("idUsuario2"), rsVenta.getString("idUsuario1"));
                    resultado.add(v);
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
                this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
            } finally {
                try {
                    stmVenta.close();
                } catch (SQLException e) {
                    System.out.println("Imposible cerrar cursores");
                }
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                stmVenta.close();
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

    public void ofertaVentaInv(OfertaParticipaciones v) {
        Connection con;
        PreparedStatement stmOferta = null;
        con = super.getConexion();

        try {
            stmOferta = con.prepareStatement("INSERT INTO ofertaparticipacionesventainversor VALUES (?, now(), ?, ?, ?)");

            stmOferta.setDouble(1, v.getPrecioParticipacion());
            stmOferta.setInt(2, v.getNumeroParticipaciones());
            stmOferta.setString(3, v.getIdUsuario1());
            stmOferta.setString(4, v.getIdUsuario2());
            stmOferta.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                stmOferta.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
    }

    public void ofertaVentaEmpr(OfertaParticipaciones v) {
        Connection con;
        PreparedStatement stmOferta = null;
        con = super.getConexion();

        try {
            stmOferta = con.prepareStatement("INSERT INTO ofertaparticipacionesventaempresa VALUES (?, now(), ?, ?, ?)");

            stmOferta.setDouble(1, v.getPrecioParticipacion());
            stmOferta.setInt(2, v.getNumeroParticipaciones());
            stmOferta.setString(3, v.getIdUsuario1());
            stmOferta.setString(4, v.getIdUsuario2());
            stmOferta.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                stmOferta.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
    }

    public boolean comprobarParticipacionesEmpresa(OfertaParticipaciones v) {
        Connection con;
        PreparedStatement stmOferta = null;
        boolean resultado = false;
        ResultSet rsParticipaciones;

        con = this.getConexion();

        try {
            stmOferta = con.prepareStatement("select * "
                    + "from poseerparticipacionesempresa "
                    + "where idUsuario1 = ? and idUsuario2 = ? "
                    + "and (numparticipaciones - ?) >= (select COALESCE(sum(numeroparticipaciones), 0) "
                    + "from ofertaparticipacionesventaempresa "
                    + "where idusuario1 = ? and idusuario2 = ? )");
            stmOferta.setString(1, v.getIdUsuario1());
            stmOferta.setString(2, v.getIdUsuario2());
            stmOferta.setInt(3, v.getNumeroParticipaciones());
            stmOferta.setString(4, v.getIdUsuario1());
            stmOferta.setString(5, v.getIdUsuario2());
            rsParticipaciones = stmOferta.executeQuery();
            if (rsParticipaciones.next()) {
                resultado = true;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                stmOferta.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }

        return resultado;
    }

    public boolean comprobarParticipacionesInversor(OfertaParticipaciones v) {
        Connection con;
        PreparedStatement stmOferta = null;
        boolean resultado = false;
        ResultSet rsParticipaciones;

        con = this.getConexion();

        try {
            stmOferta = con.prepareStatement("select * "
                    + "from poseerparticipacionesinversor "
                    + "where idUsuario1 = ? and idUsuario2 = ? "
                    + "and (numparticipaciones - ?) >= (select COALESCE(sum(numeroparticipaciones), 0) "
                    + "from ofertaparticipacionesventainversor "
                    + "where idusuario1 = ? and idusuario2 = ? )");
            stmOferta.setString(1, v.getIdUsuario1());
            stmOferta.setString(2, v.getIdUsuario2());
            stmOferta.setInt(3, v.getNumeroParticipaciones());
            stmOferta.setString(4, v.getIdUsuario1());
            stmOferta.setString(5, v.getIdUsuario2());
            rsParticipaciones = stmOferta.executeQuery();
            if (rsParticipaciones.next()) {
                resultado = true;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                stmOferta.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }

        return resultado;
    }

    public int numParticipacionesInvEmpr(String idUsuario, String idEmpresa) {
        Integer resultado = null;
        Connection con;
        PreparedStatement stmPrestamos = null;
        ResultSet rsPrestamos;
        String consulta;

        con = this.getConexion();

        try {
            consulta = "SELECT numparticipaciones as nparticipaciones "
                    + "FROM poseerparticipacionesinversor "
                    + "WHERE idUsuario1 = ? and idUsuario2 = ?";

            stmPrestamos = con.prepareStatement(consulta);
            stmPrestamos.setString(1, idUsuario);
            stmPrestamos.setString(2, idEmpresa);
            rsPrestamos = stmPrestamos.executeQuery();
            if (rsPrestamos.next()) {
                resultado = rsPrestamos.getInt("nparticipaciones");
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

    public int numParticipacionesEmprEmpr(String idUsuario, String idEmpresa) {
        Integer resultado = null;
        Connection con;
        PreparedStatement stmPrestamos = null;
        ResultSet rsPrestamos;
        String consulta;

        con = this.getConexion();

        try {
            consulta = "SELECT numparticipaciones as nparticipaciones "
                    + "FROM poseerparticipacionesempresa "
                    + "WHERE idUsuario1 = ? and idUsuario2 = ?";

            stmPrestamos = con.prepareStatement(consulta);
            stmPrestamos.setString(1, idUsuario);
            stmPrestamos.setString(2, idEmpresa);
            rsPrestamos = stmPrestamos.executeQuery();
            if (rsPrestamos.next()) {
                resultado = rsPrestamos.getInt("nparticipaciones");
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

    public int partInvBloq(String idUser, String idEmpr) {
        Integer resultado = null;
        Connection con;
        PreparedStatement stmPrestamos = null;
        ResultSet rsPrestamos;
        String consulta;

        con = this.getConexion();

        try {
            consulta = "SELECT sum(numeroparticipaciones) as suma "
                    + "FROM ofertaparticipacionesventainversor "
                    + "WHERE idusuario1 = ? and idusuario2 = ?";

            stmPrestamos = con.prepareStatement(consulta);
            stmPrestamos.setString(1, idUser);
            stmPrestamos.setString(2, idEmpr);
            rsPrestamos = stmPrestamos.executeQuery();
            if (rsPrestamos.next()) {
                resultado = rsPrestamos.getInt("suma");
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

    public int partEmprBloq(String idUser, String idEmpr) {
        Integer resultado = null;
        Connection con;
        PreparedStatement stmPrestamos = null;
        ResultSet rsPrestamos;
        String consulta;

        con = this.getConexion();

        try {
            consulta = "SELECT sum(numeroparticipaciones) as suma "
                    + "FROM ofertaparticipacionesventaempresa "
                    + "WHERE idusuario1 = ? and idusuario2 = ?";

            stmPrestamos = con.prepareStatement(consulta);
            stmPrestamos.setString(1, idUser);
            stmPrestamos.setString(2, idEmpr);
            rsPrestamos = stmPrestamos.executeQuery();
            if (rsPrestamos.next()) {
                resultado = rsPrestamos.getInt("suma");
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

    public void borrarVentaInv(OfertaParticipaciones v) {
        Connection con;
        PreparedStatement stmUsuario = null;
        ResultSet rsUsuario;

        con = this.getConexion();

        try {
            stmUsuario = con.prepareStatement("DELETE FROM ofertaparticipacionesventainversor "
                    + "WHERE idusuario1 = ? and idusuario2 = ? "
                    + "and fecha = (SELECT min(fecha) "
                    + "FROM ofertaparticipacionesventainversor "
                    + "WHERE precio = ? and numeroparticipaciones = ? and idusuario1 = ? and idusuario2 = ?)");
            stmUsuario.setString(1, v.getIdUsuario1());
            stmUsuario.setString(2, v.getIdUsuario2());
            stmUsuario.setDouble(3, v.getPrecioParticipacion());
            stmUsuario.setInt(4, v.getNumeroParticipaciones());
            stmUsuario.setString(5, v.getIdUsuario1());
            stmUsuario.setString(6, v.getIdUsuario2());
            rsUsuario = stmUsuario.executeQuery();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            //this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                stmUsuario.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
    }

    public void borrarVentaEmpr(OfertaParticipaciones v) {
        Connection con;
        PreparedStatement stmUsuario = null;
        ResultSet rsUsuario;

        con = this.getConexion();

        try {
            stmUsuario = con.prepareStatement("DELETE FROM ofertaparticipacionesventaempresa "
                    + "WHERE idusuario1 = ? and idusuario2 = ? "
                    + "and fecha = (SELECT min(fecha) "
                    + "FROM ofertaparticipacionesventaempresa "
                    + "WHERE precio = ? and numeroparticipaciones = ? and idusuario1 = ? and idusuario2 = ?)");
            stmUsuario.setString(1, v.getIdUsuario1());
            stmUsuario.setString(2, v.getIdUsuario2());
            stmUsuario.setDouble(3, v.getPrecioParticipacion());
            stmUsuario.setInt(4, v.getNumeroParticipaciones());
            stmUsuario.setString(5, v.getIdUsuario1());
            stmUsuario.setString(6, v.getIdUsuario2());
            rsUsuario = stmUsuario.executeQuery();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            //this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                stmUsuario.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
    }

    public int contarOfertas(String idUsuario, double precio, String yo) {
        int resultado = 0;
        Connection con;
        PreparedStatement stmOferta = null;
        ResultSet rsOferta;

        con = this.getConexion();
        String consulta = "select count(*) as cuenta "
                + "from (select pe.* "
                + "from ((select opve.* "
                + "from ofertaparticipacionesventaempresa as opve "
                + "where (opve.idusuario2 = ?) "
                + "and (opve.precio <= ?) and opve.idusuario1!= ?) "
                + "union "
                + "(select opvi.* "
                + "from ofertaparticipacionesventainversor as opvi "
                + "where (opvi.idusuario2 = ?) "
                + "and (opvi.precio <= ?) and opvi.idusuario1!= ?)) as pe "
                + "order by pe.precio, fecha) as subconsulta";
        try {

            stmOferta = con.prepareStatement(consulta);

            stmOferta.setString(1, idUsuario);
            stmOferta.setDouble(2, precio);
            stmOferta.setString(3, yo);
            stmOferta.setString(4, idUsuario);
            stmOferta.setDouble(5, precio);
            stmOferta.setString(6, yo);

            rsOferta = stmOferta.executeQuery();
            if (rsOferta.next()) {
                resultado = rsOferta.getInt("cuenta");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                stmOferta.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
        return resultado;
    }

    public OfertaParticipaciones getOfertaParticipaciones(String idUsuario, double precio, String yo) {

        OfertaParticipaciones resultado = null;
        Connection con;
        PreparedStatement stmOferta = null;
        ResultSet rsOferta;

        con = this.getConexion();
        String consulta = "select pe.* "
                + "from ((select opve.* "
                + "from ofertaparticipacionesventaempresa as opve "
                + "where (opve.idusuario2 = ?) "
                + "and (opve.precio <= ?) and opve.idusuario1!= ?) "
                + "union "
                + "(select opvi.* "
                + "from ofertaparticipacionesventainversor as opvi "
                + "where (opvi.idusuario2 = ?) "
                + "and (opvi.precio <= ?)and opvi.idusuario1!= ?)) as pe "
                + "order by pe.precio, fecha "
                + "Limit 1";
        try {

            stmOferta = con.prepareStatement(consulta);

            stmOferta.setString(1, idUsuario);
            stmOferta.setDouble(2, precio);
            stmOferta.setString(3, yo);
            stmOferta.setString(4, idUsuario);
            stmOferta.setDouble(5, precio);
            stmOferta.setString(6, yo);

            rsOferta = stmOferta.executeQuery();
            if (rsOferta.next()) {
                resultado = new OfertaParticipaciones(rsOferta.getString("fecha"), rsOferta.getString("idUsuario1"), rsOferta.getString("idUsuario2"));
                resultado.setNumeroParticipaciones(rsOferta.getInt("numeroParticipaciones"));
                resultado.setPrecioParticipacion(rsOferta.getDouble("precio"));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                stmOferta.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }

        return resultado;
    }

    public boolean poseerYaParticipacionesInversor(String id, String empresa) {
        boolean respuesta = false;

        Connection con;
        PreparedStatement stmCheck = null;
        ResultSet rsOferta;

        con = this.getConexion();
        String consulta = "select * from poseerparticipacionesinversor where idusuario1 = ? and idUsuario2 = ?";
        try {

            stmCheck = con.prepareStatement(consulta);
            stmCheck.setString(1, id);
            stmCheck.setString(2, empresa);

            rsOferta = stmCheck.executeQuery();
            if (rsOferta.next()) {
                respuesta = true;
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                stmCheck.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
        return respuesta;
    }

    public boolean poseerYaParticipacionesEmpresa(String id, String empresa) {
        boolean respuesta = false;

        Connection con;
        PreparedStatement stmCheck = null;
        ResultSet rsOferta;

        con = this.getConexion();
        String consulta = "select * from poseerparticipacionesempresa where idusuario1 = ? and idUsuario2 = ?";
        try {

            stmCheck = con.prepareStatement(consulta);
            stmCheck.setString(1, id);
            stmCheck.setString(2, empresa);

            rsOferta = stmCheck.executeQuery();
            if (rsOferta.next()) {
                respuesta = true;
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                stmCheck.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
        return respuesta;
    }

    public int moverParticipacionesTodas(String idUsuario, OfertaParticipaciones oferta) {
        Connection con;
        PreparedStatement stmOferta = null;
        int longitudUsuario = oferta.getIdUsuario1().length();
        double comision = oferta.getNumeroParticipaciones() * oferta.getPrecioParticipacion() * oferta.getComision();

        con = this.getConexion();

        String consulta = "";
        if (longitudUsuario != 9) {
            consulta += "delete from ofertaparticipacionesventaempresa ";
        } else {
            consulta += "delete from ofertaparticipacionesventainversor ";
        }

        consulta += "where idusuario1 = ? and idusuario2 = ? and fecha = ?; ";

        if (poseerYaParticipacionesEmpresa(idUsuario, oferta.getIdUsuario2()) ||
            poseerYaParticipacionesInversor(idUsuario, oferta.getIdUsuario2())) {
            
            if (idUsuario.length() != 9) {
                consulta += "update poseerparticipacionesempresa ";
            } else {
                consulta += "update poseerparticipacionesinversor ";
            }

            consulta += "set numparticipaciones= numparticipaciones + ? "
                    + "where idusuario1 = ? "
                    + "and idusuario2 = ?; ";
        } else {
            if (idUsuario.length() != 9) {
                consulta += "insert into poseerparticipacionesempresa ";
            } else {
                consulta += "insert into poseerparticipacionesinversor ";
            }

            consulta += "values (?,?,?); ";
        }

        if (longitudUsuario != 9) {
            consulta += "update poseerparticipacionesempresa ";
        } else {
            consulta += "update poseerparticipacionesinversor ";
        }

        consulta += "set numparticipaciones = numparticipaciones - ? "
                + "where idusuario1 = ? "
                + "and idusuario2 = ?; ";

        if (idUsuario.length() != 9) {
            consulta += "update empresausuario ";
        } else {
            consulta += "update inversorUsuario ";
        }
        consulta += "set fondosDisponiblesCuenta = fondosDisponiblesCuenta - ? "
                + "where idUsuario = ?; ";

        if (longitudUsuario != 9) {
            consulta += "update empresausuario ";
        } else {
            consulta += "update inversorusuario ";
        }

        consulta += "set fondosDisponiblesCuenta = fondosDisponiblesCuenta + ? "
                + "where idUsuario = ?; ";

        consulta += "update inversorusuario ";

        consulta += "set fondosDisponiblesCuenta = fondosDisponiblesCuenta + ? "
                + "where idUsuario = '76736439T';";

        try {
            con.setAutoCommit(false);
            stmOferta = con.prepareStatement(consulta);

            //para el borrado de oferta
            stmOferta.setString(1, oferta.getIdUsuario1());
            stmOferta.setString(2, oferta.getIdUsuario2());
            stmOferta.setTimestamp(3, Timestamp.valueOf(oferta.getFechaOferta()));

            //para dar las participaciones a quien compró
            stmOferta.setInt(4, oferta.getNumeroParticipaciones());
            stmOferta.setString(5, idUsuario);
            stmOferta.setString(6, oferta.getIdUsuario2());

            //para quitar las participaciones a quien vendió
            stmOferta.setInt(7, oferta.getNumeroParticipaciones());
            stmOferta.setString(8, oferta.getIdUsuario1());
            stmOferta.setString(9, oferta.getIdUsuario2());

            //para actualizar los fondos del comprador
            stmOferta.setDouble(10, (oferta.getNumeroParticipaciones() * oferta.getPrecioParticipacion()));
            stmOferta.setString(11, idUsuario);

            //para actualizar los fondos del vendedor
            stmOferta.setDouble(12, oferta.getNumeroParticipaciones() * oferta.getPrecioParticipacion() - comision); //supongo que la comision se le quita a este
            stmOferta.setString(13, oferta.getIdUsuario1());

            //por último la comisión
            stmOferta.setDouble(14, comision);

            stmOferta.executeUpdate();
            con.commit();
            con.setAutoCommit(true);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            try {
                con.rollback();
            } catch (SQLException ex) {
                Logger.getLogger(DAOParticipaciones.class.getName()).log(Level.SEVERE, null, ex);
            }
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                stmOferta.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
        return oferta.getNumeroParticipaciones();
    }

    public void moverParticipacionesParciales(OfertaParticipaciones oferta, String idUsuario, int participacionesRestantes) {
        Connection con;
        PreparedStatement stmOferta = null;
        int longitudUsuario = oferta.getIdUsuario1().length();
        double comision = participacionesRestantes * oferta.getPrecioParticipacion() * oferta.getComision();
        con = this.getConexion();

        String consulta = "";
        if (longitudUsuario != 9) {
            consulta += "update ofertaparticipacionesventaempresa ";
        } else {
            consulta += "update ofertaparticipacionesventainversor ";
        }

        consulta += "set numeroParticipaciones = numeroParticipaciones - ? "
                + "where idusuario1 = ? "
                + "and idusuario2 = ? "
                + "and fecha = ?; ";

        if (poseerYaParticipacionesEmpresa(idUsuario,oferta.getIdUsuario2()) || poseerYaParticipacionesInversor(idUsuario,oferta.getIdUsuario2())) {
            if (idUsuario.length() != 9) {
                consulta += "update poseerparticipacionesempresa ";
            } else {
                consulta += "update poseerparticipacionesinversor ";
            }

            consulta += "set numparticipaciones= numparticipaciones + ? "
                    + "where idusuario1 = ? "
                    + "and idusuario2 = ?; ";
        } else {
            if (idUsuario.length() != 9) {
                consulta += "insert into poseerparticipacionesempresa ";
            } else {
                consulta += "insert into poseerparticipacionesinversor ";
            }

            consulta += "values (?,?,?); ";
        }

        if (longitudUsuario != 9) {
            consulta += "update poseerparticipacionesempresa ";
        } else {
            consulta += "update poseerparticipacionesinversor ";
        }

        consulta += "set numparticipaciones = numparticipaciones - ? "
                + "where idusuario1 = ? "
                + "and idusuario2 = ?; ";

        if (idUsuario.length() != 9) {
            consulta += "update empresausuario ";
        } else {
            consulta += "update inversorUsuario ";
        }
        consulta += "set fondosDisponiblesCuenta = fondosDisponiblesCuenta - ? "
                + "where idUsuario = ?; ";

        if (longitudUsuario != 9) {
            consulta += "update empresausuario ";
        } else {
            consulta += "update inversorusuario ";
        }

        consulta += "set fondosDisponiblesCuenta = fondosDisponiblesCuenta + ? "
                + "where idUsuario = ?; ";

        consulta += "update inversorusuario ";
        consulta += "set fondosDisponiblesCuenta = fondosDisponiblesCuenta + ? "
                + "where idUsuario = '76736439T';";

        try {
            con.setAutoCommit(false);
            stmOferta = con.prepareStatement(consulta);

            //para el borrado de las participaciones de la oferta
            stmOferta.setInt(1, participacionesRestantes);
            stmOferta.setString(2, oferta.getIdUsuario1());
            stmOferta.setString(3, oferta.getIdUsuario2());
            stmOferta.setTimestamp(4, Timestamp.valueOf(oferta.getFechaOferta()));

            //para dar las participaciones a quien compró
            stmOferta.setInt(5, participacionesRestantes);
            stmOferta.setString(6, idUsuario);
            stmOferta.setString(7, oferta.getIdUsuario2());

            //para quitar las participaciones a quien vendió
            stmOferta.setInt(8, oferta.getNumeroParticipaciones());
            stmOferta.setString(9, oferta.getIdUsuario1());
            stmOferta.setString(10, oferta.getIdUsuario2());

            //para actualizar los fondos del comprador
            stmOferta.setDouble(11, (participacionesRestantes * oferta.getPrecioParticipacion()));
            stmOferta.setString(12, idUsuario);

            //para actualizar los fondos del vendedor
            stmOferta.setDouble(13, (participacionesRestantes * oferta.getPrecioParticipacion()) - comision); //supongo que la comision se le quita a este
            stmOferta.setString(14, oferta.getIdUsuario1());

            //por último la comisión
            stmOferta.setDouble(15, comision);

            stmOferta.executeUpdate();
            con.commit();
            con.setAutoCommit(true);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            try {
                con.rollback();
            } catch (SQLException ex) {
                Logger.getLogger(DAOParticipaciones.class.getName()).log(Level.SEVERE, null, ex);
            }
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                stmOferta.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
    }
    
    public double getSaldoCompraVenta(String id){
        double dinero=0;
        
        Connection con;
        PreparedStatement stmCheck = null;
        ResultSet rsOferta;

        con = this.getConexion();
        String consulta = "(select fondosDisponiblesCuenta " 
                         +"from inversorusuario where idUsuario = ?) "
                         +"union " 
                         +"(select fondosDisponiblesCuenta "
                         +"from empresausuario where idUsuario = ?)";
        try {

            stmCheck = con.prepareStatement(consulta);
            stmCheck.setString(1, id);
            stmCheck.setString(2, id);

            rsOferta = stmCheck.executeQuery();
            if (rsOferta.next()) {
                dinero=rsOferta.getDouble("fondosDisponiblesCuenta");
            }
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                stmCheck.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
        return dinero;
    }
    
    public float obtenerComisionOferta(String fechaOferta){
        float comision = 0;
        
        Connection con;
        PreparedStatement stmCheck = null;
        ResultSet rsComision;

        con = this.getConexion();
        String consulta = "select valor from comision where fechaComision <= ? order by fechaComision desc LIMIT 1";
        
        try {
            stmCheck = con.prepareStatement(consulta);
            stmCheck.setTimestamp(1, Timestamp.valueOf(fechaOferta));

            rsComision = stmCheck.executeQuery();
            if (rsComision.next()) {
                comision=rsComision.getFloat("valor");
            }
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                stmCheck.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
        return comision;
    }
}

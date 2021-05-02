/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baseDatos;

import aplicacion.EmpresaUsuario;
import aplicacion.InversorUsuario;
import aplicacion.TipoUsuario;
import aplicacion.OfertaParticipaciones;
import java.sql.*;

public class DAOParticipaciones extends AbstractDAO {

    public DAOParticipaciones(Connection conexion, aplicacion.FachadaAplicacion fa) {
        super.setConexion(conexion);
        super.setFachadaAplicacion(fa);
    }

    public void altaParticipacionesEmpresa(int participaciones, String id) {
        Connection con;
        PreparedStatement stmParticipaciones = null;

        con = super.getConexion();

        try {
            stmParticipaciones = con.prepareStatement("update EmpresaUsuario "
                    + "set numeroParticipaciones=numeroParticipaciones+? "
                    + "where idUsuario=?");
            stmParticipaciones.setInt(1, participaciones);
            stmParticipaciones.setString(2, id);
            stmParticipaciones.executeUpdate();

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
    }

    public void bajaParticipacionesEmpresa(int participaciones, String id) {
        Connection con;
        PreparedStatement stmParticipaciones = null;

        con = super.getConexion();

        try {
            stmParticipaciones = con.prepareStatement("update EmpresaUsuario "
                    + "set numeroParticipaciones=numeroParticipaciones-? "
                    + "where idUsuario=?");
            stmParticipaciones.setInt(1, participaciones);
            stmParticipaciones.setString(2, id);
            stmParticipaciones.executeUpdate();

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
    }
    
    public void ventaParticipacionesInv(String idempresa , int nparticipaciones, String idinv){
        Connection con;
        PreparedStatement stmUsuarios = null;
        con = super.getConexion();

        try {
            stmUsuarios = con.prepareStatement("update poseerparticipacionesinversor "
                    + "set numparticipaciones = numparticipaciones-nparticipaciones "
                    + "where idUsuario1 = ? and idUsuario2 = ? "
                    + "and nparticipaciones <= (SELECT numparticipaciones " +
                                "FROM poseerparticipacionesinversor as p, inversorUsuario as i " +
                                "WHERE i.idUsuario = ? and p.idUsuario2 = ? " +
                                "and i.idUsuario = p.idUsuario1)");

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
    
    public void ventaParticipacionesEmpr(String idempresa , int nparticipaciones, String idempresa2){ //idempresa es la que posee las participaciones
        Connection con;
        PreparedStatement stmUsuarios = null;
        con = super.getConexion();

        try {
            stmUsuarios = con.prepareStatement("update poseerparticipacionesempresa "
                    + "set numparticipaciones = numparticipaciones-nparticipaciones "
                    + "where idUsuario1 = ? and idUsuario2 = ? "
                    + "and nparticipaciones <= (SELECT numparticipaciones " +
                                "FROM poseerparticipacionesempresa as p, empresaUsuario as e " +
                                "WHERE e.idUsuario = ? and p.idUsuario2 = ? " +
                                "and i.idUsuario = p.idUsuario1)");

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
    
    public java.util.List<OfertaParticipaciones> mostrarVentas(){
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
    
    public void ofertaVentaInv(OfertaParticipaciones v){
        Connection con;
        PreparedStatement stmOferta = null;
        con = super.getConexion();

        try {
            stmOferta = con.prepareStatement("INSERT INTO ofertaparticipacionesventainversor VALUES (?, now(), ?, ?, ?)");

            stmOferta.setFloat(1, v.getPrecio());
            stmOferta.setInt(2, v.getNparticipaciones());
            stmOferta.setString(3, v.getIdVendedor());
            stmOferta.setString(4, v.getIdEmpresa());
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
    
    public void ofertaVentaEmpr(OfertaParticipaciones v){
        Connection con;
        PreparedStatement stmOferta = null;
        con = super.getConexion();
        
        try {
            stmOferta = con.prepareStatement("INSERT INTO ofertaparticipacionesventaempresa VALUES (?, now(), ?, ?, ?)");

            stmOferta.setFloat(1, v.getPrecio());
            stmOferta.setInt(2, v.getNparticipaciones());
            stmOferta.setString(3, v.getIdVendedor());
            stmOferta.setString(4, v.getIdEmpresa());
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
    
    public boolean comprobarParticipacionesEmpresa(OfertaParticipaciones v){
        Connection con;
        PreparedStatement stmOferta = null;
        con = super.getConexion();
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
            stmOferta.setString(1, v.getIdVendedor());
            stmOferta.setString(2, v.getIdEmpresa());
            stmOferta.setInt(3, v.getNparticipaciones());
            stmOferta.setString(4, v.getIdVendedor());
            stmOferta.setString(5, v.getIdEmpresa());
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
    
    public boolean comprobarParticipacionesInversor(OfertaParticipaciones v){
        Connection con;
        PreparedStatement stmOferta = null;
        con = super.getConexion();
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
            stmOferta.setString(1, v.getIdVendedor());
            stmOferta.setString(2, v.getIdEmpresa());
            stmOferta.setInt(3, v.getNparticipaciones());
            stmOferta.setString(4, v.getIdVendedor());
            stmOferta.setString(5, v.getIdEmpresa());
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
    
    public int numParticipacionesInvEmpr(String idUsuario, String idEmpresa){
        Integer resultado = null;
        Connection con;
        PreparedStatement stmPrestamos = null;
        ResultSet rsPrestamos;
        String consulta;

        con = this.getConexion();

        try {
            consulta = "SELECT numparticipaciones as nparticipaciones "  
                    +"FROM poseerparticipacionesinversor " 
                    +"WHERE idUsuario1 = ? and idUsuario2 = ?";

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
    
    public int numParticipacionesEmprEmpr(String idUsuario, String idEmpresa){
        Integer resultado = null;
        Connection con;
        PreparedStatement stmPrestamos = null;
        ResultSet rsPrestamos;
        String consulta;

        con = this.getConexion();

        try {
            consulta = "SELECT numparticipaciones as nparticipaciones " 
                    +"FROM poseerparticipacionesempresa " 
                    +"WHERE idUsuario1 = ? and idUsuario2 = ?";

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
    
    public int partInvBloq(String idUser, String idEmpr){
        Integer resultado = null;
        Connection con;
        PreparedStatement stmPrestamos = null;
        ResultSet rsPrestamos;
        String consulta;

        con = this.getConexion();

        try {
            consulta = "SELECT sum(numeroparticipaciones) as suma " 
                    +"FROM ofertaparticipacionesventainversor " 
                    +"WHERE idusuario1 = ? and idusuario2 = ?";

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
    
    public int partEmprBloq(String idUser, String idEmpr){
        Integer resultado = null;
        Connection con;
        PreparedStatement stmPrestamos = null;
        ResultSet rsPrestamos;
        String consulta;

        con = this.getConexion();

        try {
            consulta = "SELECT sum(numeroparticipaciones) as suma " 
                    +"FROM ofertaparticipacionesventaempresa " 
                    +"WHERE idusuario1 = ? and idusuario2 = ?";

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
    
    public void borrarVentaInv(OfertaParticipaciones v){
        Connection con;
        PreparedStatement stmUsuario=null;
        ResultSet rsUsuario;

        con=this.getConexion();

        try {
        stmUsuario=con.prepareStatement("DELETE FROM ofertaparticipacionesventainversor " 
                                       + "WHERE idusuario1 = ? and idusuario2 = ? "
                                       + "and fecha = (SELECT min(fecha) " 
                                                       + "FROM ofertaparticipacionesventainversor " 
                                                       + "WHERE precio = ? and numeroparticipaciones = ? and idusuario1 = ? and idusuario2 = ?)");
        stmUsuario.setString(1, v.getIdVendedor());
        stmUsuario.setString(2, v.getIdEmpresa());
        stmUsuario.setFloat(3, v.getPrecio());
        stmUsuario.setInt(4, v.getNparticipaciones());
        stmUsuario.setString(5, v.getIdVendedor());
        stmUsuario.setString(6, v.getIdEmpresa());
        rsUsuario=stmUsuario.executeQuery();
        } catch (SQLException e){
          System.out.println(e.getMessage());
          //this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
          try {stmUsuario.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
    }
    
    public void borrarVentaEmpr(OfertaParticipaciones v){
        Connection con;
        PreparedStatement stmUsuario=null;
        ResultSet rsUsuario;

        con=this.getConexion();

        try {
        stmUsuario=con.prepareStatement("DELETE FROM ofertaparticipacionesventaempresa " 
                                       + "WHERE idusuario1 = ? and idusuario2 = ? "
                                       + "and fecha = (SELECT min(fecha) " 
                                                       + "FROM ofertaparticipacionesventaempresa " 
                                                       + "WHERE precio = ? and numeroparticipaciones = ? and idusuario1 = ? and idusuario2 = ?)");
        stmUsuario.setString(1, v.getIdVendedor());
        stmUsuario.setString(2, v.getIdEmpresa());
        stmUsuario.setFloat(3, v.getPrecio());
        stmUsuario.setInt(4, v.getNparticipaciones());
        stmUsuario.setString(5, v.getIdVendedor());
        stmUsuario.setString(6, v.getIdEmpresa());
        rsUsuario=stmUsuario.executeQuery();
        } catch (SQLException e){
          System.out.println(e.getMessage());
          //this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
          try {stmUsuario.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
    }
    

}

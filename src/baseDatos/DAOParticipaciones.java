/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baseDatos;

import aplicacion.EmpresaUsuario;
import aplicacion.InversorUsuario;
import aplicacion.TipoUsuario;
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

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baseDatos;

import aplicacion.AnunciarBeneficios;
import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;

public class DAOBeneficios extends AbstractDAO {

    public DAOBeneficios(Connection conexion, aplicacion.FachadaAplicacion fa) {
        super.setConexion(conexion);
        super.setFachadaAplicacion(fa);
    }

    public void altaPagoBeneficios(String fecha, double importe, String idEmpresa,int acciones) {
        Connection con;
        PreparedStatement stmBeneficios = null;
        con = super.getConexion();

        try {
            stmBeneficios = con.prepareStatement("insert into AnunciarBeneficios "
                    + "values (?,?,?,?)");
            stmBeneficios.setDate(1, (Date.valueOf(fecha)));
            stmBeneficios.setDouble(2, importe);
            stmBeneficios.setInt(4, acciones);
            stmBeneficios.setString(3, idEmpresa);
            stmBeneficios.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                stmBeneficios.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
    }

    public String getIdEmpresa(String nombre) {
        Connection con;
        PreparedStatement stmBeneficios = null;
        con = super.getConexion();
        String idUsuario = null;
        ResultSet usuario;

        try {
            stmBeneficios = con.prepareStatement("select EmpresaUsuario.idUsuario "
                    + "from EmpresaUsuario "
                    + "where EmpresaUsuario.nombreComercial=?");
            stmBeneficios.setString(1, nombre);
            usuario = stmBeneficios.executeQuery();
            if (usuario.next()) {
                idUsuario = usuario.getString("IdUsuario");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                stmBeneficios.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
        return idUsuario;
    }

    public ArrayList<AnunciarBeneficios> getBeneficios() {
        Connection con;
        PreparedStatement stmBeneficios = null;
        con = super.getConexion();
        ArrayList<AnunciarBeneficios> resultado = new ArrayList<AnunciarBeneficios>();
        ResultSet beneficios;
        AnunciarBeneficios a;

        try {
            stmBeneficios = con.prepareStatement("select b.*,e.nombreComercial "
                    + "from EmpresaUsuario as e, AnunciarBeneficios as b "
                    + "where e.idUsuario = b.idEmpresa");
            beneficios = stmBeneficios.executeQuery();
            while (beneficios.next()) {
                a= new AnunciarBeneficios(beneficios.getString("fechaAnuncioPago"),
                        beneficios.getFloat("importe"),beneficios.getInt("numParticipaciones") , beneficios.getString("idEmpresa"));
                        a.setNombreEmpresa(beneficios.getString("nombreComercial"));
                resultado.add(a);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                stmBeneficios.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
        return resultado;
    }

}

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

    public void altaPagoBeneficios(String fecha, double importe, String idEmpresa, int acciones) {
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
                a = new AnunciarBeneficios(beneficios.getString("fechaAnuncioPago"),
                        beneficios.getFloat("importe"), beneficios.getInt("numParticipaciones"), beneficios.getString("idEmpresa"));
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

    public float getSaldoRetenciones( String id) {
        Connection con;
        PreparedStatement stmSaldo = null;
        con = super.getConexion();
        float saldo = 0;
        ResultSet saldoFinal;

        try {
            stmSaldo = con.prepareStatement("select eu.fondosdisponiblescuenta - sum(distinct ab.importe) * (sum( distinct ppi.numparticipaciones) + sum(distinct ppe.numparticipaciones)) as dinerosFinales\n" +
"from EmpresaUsuario as eu,AnunciarBeneficios as ab,poseerparticipacionesinversor as ppi, poseerparticipacionesempresa ppe\n" +
"where eu.idUsuario= ab.idEmpresa and ab.idEmpresa= '1' and ((ab.idEmpresa = ppi.idUsuario2 and ab.idEmpresa != ppi.idUsuario1) and (ab.idEmpresa = ppe.idUsuario2 and ab.idEmpresa != ppe.idUsuario1))\n" +
"group by eu.idUsuario;");
            
            stmSaldo.setString(1, id);
            saldoFinal = stmSaldo.executeQuery();
            if (saldoFinal.next()) {
                saldo = saldoFinal.getFloat("dineroFinal");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                stmSaldo.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
        return saldo;
    }
    
    public int getParticipacionesRetenciones( String id) {
        Connection con;
        PreparedStatement stmSaldo = null;
        con = super.getConexion();
        int participaciones = 0;
        ResultSet participacionesFinal;

        try {
            stmSaldo = con.prepareStatement("select eu.numeroParticipaciones - sum(distinct ab.numParticipaciones) * (sum( distinct ppi.numparticipaciones) + sum(distinct ppe.numparticipaciones)) as participacionesFinales\n" +
"from EmpresaUsuario as eu,AnunciarBeneficios as ab,poseerparticipacionesinversor as ppi, poseerparticipacionesempresa ppe\n" +
"where eu.idUsuario= ab.idEmpresa and ab.idEmpresa= '1' and ((ab.idEmpresa = ppi.idUsuario2 and ab.idEmpresa != ppi.idUsuario1) and (ab.idEmpresa = ppe.idUsuario2 and ab.idEmpresa != ppe.idUsuario1))\n" +
"group by eu.idUsuario;");
            
            stmSaldo.setString(1, id);
            participacionesFinal = stmSaldo.executeQuery();
            if (participacionesFinal.next()) {
                participaciones = participacionesFinal.getInt("participacionesFinales");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                stmSaldo.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
        return participaciones;
    }
    
    public void bajaAnuncioBeneficios(String fecha, String idEmpresa){
    
        Connection con;
        PreparedStatement stmBeneficios = null;
        con = super.getConexion();

        try {
            stmBeneficios = con.prepareStatement("delete "
                    + "from anunciarbeneficios "
                    + "where fechaanunciopago = ? and idEmpresa = ? ");
            stmBeneficios.setDate(1, (Date.valueOf(fecha)));
            stmBeneficios.setString(2, idEmpresa);
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
    

}

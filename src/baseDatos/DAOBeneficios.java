package baseDatos;

import aplicacion.AnunciarBeneficios;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

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

    public ArrayList<AnunciarBeneficios> getBeneficiosHoy() {
        Connection con;
        PreparedStatement stmBeneficios = null;
        con = super.getConexion();
        ArrayList<AnunciarBeneficios> resultado = new ArrayList<AnunciarBeneficios>();
        ResultSet beneficios;
        AnunciarBeneficios a;

        try {
            stmBeneficios = con.prepareStatement("select b.*,e.nombreComercial "
                    + "from EmpresaUsuario as e, AnunciarBeneficios as b "
                    + "where e.idUsuario = b.idEmpresa "
                    + "and b.fechaanunciopago = CURRENT_DATE");
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

    public ArrayList<AnunciarBeneficios> getBeneficiosEmpresa(String idEmpresa) {
        Connection con;
        PreparedStatement stmBeneficios = null;
        con = super.getConexion();
        ArrayList<AnunciarBeneficios> resultado = new ArrayList<AnunciarBeneficios>();
        ResultSet beneficios;
        AnunciarBeneficios a;

        try {
            stmBeneficios = con.prepareStatement("select b.*,e.nombreComercial "
                    + "from EmpresaUsuario as e, AnunciarBeneficios as b "
                    + "where e.idUsuario = b.idEmpresa "
                    + "and b.idEmpresa = ?");
            stmBeneficios.setString(1, idEmpresa);
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

    public float getSaldoRetenciones(String id) {
        Connection con;
        PreparedStatement stmSaldo = null;
        con = super.getConexion();
        float saldo = 0;
        ResultSet saldoFinal;

        try {
            stmSaldo = con.prepareStatement("select eu.fondosdisponiblescuenta - sum(distinct ab.importe) * (sum( distinct ppi.numparticipaciones) + sum(distinct ppe.numparticipaciones)) as dineroFinal "
                    + "from EmpresaUsuario as eu,AnunciarBeneficios as ab,poseerparticipacionesinversor as ppi, poseerparticipacionesempresa ppe "
                    + "where eu.idUsuario= ab.idEmpresa and ab.idEmpresa= ? and ((ab.idEmpresa = ppi.idUsuario2 and ab.idEmpresa != ppi.idUsuario1) and (ab.idEmpresa = ppe.idUsuario2 and ab.idEmpresa != ppe.idUsuario1)) "
                    + "group by eu.idUsuario");

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

    public int getParticipacionesRetenciones(String id) {
        Connection con;
        PreparedStatement stmSaldo = null;
        con = super.getConexion();
        int participaciones = 0;
        ResultSet participacionesFinal;
       
        try {
            stmSaldo = con.prepareStatement("select sum(ppe.numParticipaciones - "
                    + "(select sum(distinct ab.numParticipaciones) * (sum( distinct ppi.numparticipaciones) + sum(distinct ppe.numparticipaciones)) "
                    + "from AnunciarBeneficios as ab,poseerparticipacionesinversor as ppi, poseerparticipacionesempresa ppe "
                    + "where  ab.idEmpresa= ? and ((ab.idEmpresa = ppi.idUsuario2 and ab.idEmpresa != ppi.idUsuario1) and (ab.idEmpresa = ppe.idUsuario2 and ab.idEmpresa != ppe.idUsuario1)) "
                    + "group by ab.idEmpresa )) as ParticipacionesFinales "
                    + "FROM poseerParticipacionesEmpresa as ppe "
                    + "WHERE idUsuario1 = ? and idUsuario2 = ? ");
          
            stmSaldo.setString(1, id);
            stmSaldo.setString(2, id);
            stmSaldo.setString(3, id);
            
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

    public void bajaAnuncioBeneficios(String fecha, String idEmpresa) {

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

    public float getSaldoTrasPagarBeneficiosHoy(String id) {
        Connection con;
        PreparedStatement stmSaldo = null;
        con = super.getConexion();
        float saldo = 0;
        ResultSet saldoFinal;

        try {

            stmSaldo = con.prepareStatement("select eu.fondosdisponiblescuenta - sum(distinct ab.importe) * (sum( distinct ppi.numparticipaciones) + sum(distinct ppe.numparticipaciones)) as dineroFinal "
                    + "from EmpresaUsuario as eu,AnunciarBeneficios as ab,poseerparticipacionesinversor as ppi, poseerparticipacionesempresa ppe "
                    + "where ab.fechaAnuncioPago = CURRENT_DATE and eu.idUsuario= ab.idEmpresa and ab.idEmpresa = ? and ((ab.idEmpresa = ppi.idUsuario2 and ab.idEmpresa != ppi.idUsuario1) and (ab.idEmpresa = ppe.idUsuario2 and ab.idEmpresa != ppe.idUsuario1)) "
                    + "group by eu.idUsuario");

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

    public int getParticipacionesTrasPagarBeneficiosHoy(String id) { //AÑADIDA 1 LINEA
        Connection con;
        PreparedStatement stmSaldo = null;
        con = super.getConexion();
        int participaciones = 0;
        ResultSet participacionesFinal;

        try {
            stmSaldo = con.prepareStatement("select sum(ppe.numParticipaciones - "
                    + "(select sum(distinct ab.numParticipaciones) * (sum( distinct ppi.numparticipaciones) + sum(distinct ppe.numparticipaciones)) "
                    + "from AnunciarBeneficios as ab,poseerparticipacionesinversor as ppi, poseerparticipacionesempresa ppe "
                    + "where  ab.fechaAnuncioPago = current_date and ab.idEmpresa = ?  and ((ab.idEmpresa = ppi.idUsuario2 and ab.idEmpresa != ppi.idUsuario1) and (ab.idEmpresa = ppe.idUsuario2 and ab.idEmpresa != ppe.idUsuario1)) "
                    + "group by ab.idEmpresa )) as ParticipacionesFinales "
                    + "FROM poseerParticipacionesEmpresa as ppe "
                    + "WHERE idUsuario1 = ? and idUsuario2 = ?");

            stmSaldo.setString(1, id);
            stmSaldo.setString(2, id);
            stmSaldo.setString(3, id);

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

    public boolean pagarBeneficios() {
        Connection con;
        PreparedStatement stmAnunciosBeneficios = null;
        PreparedStatement stmCobradores = null;
        PreparedStatement stmEmpresas = null;
        PreparedStatement stmQuitarDineroParticipacionesEmpresa = null;
        PreparedStatement stmBorrarBeneficios = null;
        con = super.getConexion();
        ResultSet rsBeneficios;
        ResultSet rsEmpresas;

        try {
            con.setAutoCommit(false);
           
                // Actualizamos la cartera de participaciones y el dinero de la empresa que anuncia beneficios

                try {

                    stmEmpresas = con.prepareStatement("SELECT idEmpresa FROM anunciarBeneficios where fechaAnuncioPago = current_date");
                    rsEmpresas = stmEmpresas.executeQuery();
                    while (rsEmpresas.next()) { // TRas obtener las empresas que anunciaron beneficios hoy les restamos a esta el dinero y las participaciones
                        try {

                            stmQuitarDineroParticipacionesEmpresa = con.prepareStatement("UPDATE empresaUsuario "
                                    + "SET fondosDisponiblesCuenta = ? "
                                    + "where idUsuario =  ? ");

                            stmQuitarDineroParticipacionesEmpresa.setDouble(1, this.getSaldoTrasPagarBeneficiosHoy(rsEmpresas.getString("idEmpresa")));
                            stmQuitarDineroParticipacionesEmpresa.setString(2, rsEmpresas.getString("idEmpresa"));
                            stmQuitarDineroParticipacionesEmpresa.executeUpdate();

                        } catch (SQLException e) {
                            System.out.println(e.getMessage());
                            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
                        } finally {
                            stmQuitarDineroParticipacionesEmpresa.close();
                        }

                        try {

                            stmQuitarDineroParticipacionesEmpresa = null;
                            stmQuitarDineroParticipacionesEmpresa = con.prepareStatement("UPDATE poseerParticipacionesEmpresa "
                                    + "SET numParticipaciones = ? "
                                    + "where idUsuario1 =  ? ");

                            stmQuitarDineroParticipacionesEmpresa.setInt(1, this.getParticipacionesTrasPagarBeneficiosHoy(rsEmpresas.getString("idEmpresa")));
                            stmQuitarDineroParticipacionesEmpresa.setString(2, rsEmpresas.getString("idEmpresa"));
                            stmQuitarDineroParticipacionesEmpresa.executeUpdate();

                        } catch (SQLException e) {
                            System.out.println(e.getMessage());
                            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
                        } finally {
                            stmQuitarDineroParticipacionesEmpresa.close();
                        }

                    }

                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                    this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
                } finally {
                    stmEmpresas.close();
                }

            
            
            
            stmAnunciosBeneficios = con.prepareStatement("( "
                    + "SELECT distinct ppi.idUsuario1 as usuarioCobrador,  ppi.numParticipaciones as participacionesEmpresaAB, ab.importe as dineroPorParticipacion,  ab.numparticipaciones as participacionesPorParticipacion, ab.idEmpresa as empresaPagadora "
                    + "FROM poseerParticipacionesInversor as ppi, anunciarbeneficios as ab "
                    + "WHERE  ppi.idUsuario2 = ab.idEmpresa and ppi.idUsuario1 != ab.idEmpresa and  ab.fechaAnuncioPago = CURRENT_DATE "
                    + ") "
                    + "UNION "
                    + "( "
                    + "SELECT distinct ppe.idUsuario1 as usuarioCobrador,  ppe.numParticipaciones as participacionesEmpresaAB, ab.importe as dineroPorParticipacion,  ab.numparticipaciones as participacionesPorParticipacion, ab.idEmpresa as empresaPagadora  "
                    + "FROM poseerParticipacionesEmpresa as ppe, anunciarbeneficios as ab "
                    + "WHERE ppe.idUsuario2 = ab.idEmpresa and ppe.idUsuario1 != ab.idEmpresa and  ab.fechaAnuncioPago = CURRENT_DATE "
                    + ")", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

            rsBeneficios = stmAnunciosBeneficios.executeQuery(); // Obtenemos los usuarios que tienen participaciones de las empresas que pagan beneficios hoy
            while (rsBeneficios.next()) {
                if ((rsBeneficios.getString("usuarioCobrador")).length() == 9) { // Es INVERSOR
                    try { // Actualizamos el saldo de los inversores usuarios a partir de los resultados de la fila anterior
                        stmCobradores = con.prepareStatement("UPDATE inversorUsuario "
                                + "SET fondosDisponiblesCuenta = fondosDisponiblesCuenta + (? * ?) "
                                + "where idUsuario = ? ");

                        stmCobradores.setDouble(1, rsBeneficios.getDouble("dineroPorParticipacion"));
                        stmCobradores.setInt(2, rsBeneficios.getInt("participacionesEmpresaAB"));
                        stmCobradores.setString(3, rsBeneficios.getString("usuarioCobrador"));
                        stmCobradores.executeUpdate();

                    } catch (SQLException e) {
                        System.out.println(e.getMessage());
                        this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
                    } finally {
                        stmCobradores.close();
                    }

                    try { // Actualizamos la cartera de participaciones del usuario
                        stmCobradores = null;
                        stmCobradores = con.prepareStatement("UPDATE poseerParticipacionesInversor "
                                + "SET numParticipaciones = numParticipaciones + (? * ?) "
                                + "where idUsuario1 = ? and idUsuario2 = ? ");

                        stmCobradores.setInt(1, rsBeneficios.getInt("participacionesPorParticipacion"));
                        stmCobradores.setInt(2, rsBeneficios.getInt("participacionesEmpresaAB"));
                        stmCobradores.setString(3, rsBeneficios.getString("usuarioCobrador"));
                        stmCobradores.setString(4, rsBeneficios.getString("empresaPagadora"));
                        stmCobradores.executeUpdate();

                    } catch (SQLException e) {
                        System.out.println(e.getMessage());
                        this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
                    } finally {
                        stmCobradores.close();
                    }

                } else if ((rsBeneficios.getString("usuarioCobrador")).length() == 13) { // Es EMPRESA

                    try { // Actualizamos el saldo de las empresas usuarios a partir de los resultados de la fila anterior
                        stmCobradores = con.prepareStatement("UPDATE empresaUsuario "
                                + "SET fondosDisponiblesCuenta = fondosDisponiblesCuenta + (? * ?) "
                                + "where idUsuario = ? ");

                        stmCobradores.setDouble(1, rsBeneficios.getDouble("dineroPorParticipacion"));
                        stmCobradores.setInt(2, rsBeneficios.getInt("participacionesEmpresaAB"));
                        stmCobradores.setString(3, rsBeneficios.getString("usuarioCobrador"));
                        stmCobradores.executeUpdate();

                    } catch (SQLException e) {
                        System.out.println(e.getMessage());
                        this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
                    } finally {
                        stmCobradores.close();
                    }
//AQUI
                    try { // Actualizamos la cartera de participaciones de la empresa usuario
                        stmCobradores = null;
                        stmCobradores = con.prepareStatement("UPDATE poseerParticipacionesEmpresa "
                                + "SET numParticipaciones = numParticipaciones + (? * ?) "
                                + "where idUsuario1 = ? and idUsuario2 = ?");

                        stmCobradores.setInt(1, rsBeneficios.getInt("participacionesPorParticipacion"));
                        stmCobradores.setInt(2, rsBeneficios.getInt("participacionesEmpresaAB"));
                        stmCobradores.setString(3, rsBeneficios.getString("usuarioCobrador"));
                        stmCobradores.setString(4, rsBeneficios.getString("empresaPagadora"));
                        stmCobradores.executeUpdate();

                    } catch (SQLException e) {
                        System.out.println(e.getMessage());
                        this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
                    } finally {
                        stmCobradores.close();
                    }

                }

            }

 
            try {

                stmBorrarBeneficios = con.prepareStatement("DELETE from AnunciarBeneficios where fechaAnuncioPago = CURRENT_DATE"); // Borramos todos los anuncios que ya se han pagado hoy
                stmBorrarBeneficios.executeUpdate();

            } catch (SQLException e) {
                System.out.println(e.getMessage());
                this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
            } finally {
                stmBorrarBeneficios.close();
            }
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
                stmAnunciosBeneficios.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }

        return true;
    }

    public boolean comprobarFecha(String empresa, String fecha) {
        boolean check = false;
        Connection con;
        PreparedStatement stmBeneficios = null;
        con = super.getConexion();
        ResultSet checkeo;

        try {
            stmBeneficios = con.prepareStatement("select * from anunciarbeneficios where idEmpresa = ? and fechaAnuncioPago = ?");
            stmBeneficios.setString(1, empresa);
            stmBeneficios.setDate(2, Date.valueOf(fecha));
            checkeo = stmBeneficios.executeQuery();

            if (checkeo.next()) {
                check = true;
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
        return check;
    }

}

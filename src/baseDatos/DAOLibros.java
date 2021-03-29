package baseDatos;

import aplicacion.Ejemplar;
import aplicacion.Categoria;
import aplicacion.Libro;
import java.sql.*;

public class DAOLibros extends AbstractDAO {

    public DAOLibros(Connection conexion, aplicacion.FachadaAplicacion fa) {
        super.setConexion(conexion);
        super.setFachadaAplicacion(fa);
    }

    public java.util.List<Libro> consultarCatalogo(Integer id, String titulo, String isbn, String autor) {
        java.util.List<Libro> resultado = new java.util.ArrayList<Libro>();
        Libro libroActual;
        Connection con;
        PreparedStatement stmCatalogo = null;
        ResultSet rsCatalogo;
        PreparedStatement stmAutores = null;
        ResultSet rsAutores;

        con = this.getConexion();

        String consulta = "select id_libro, titulo, isbn, editorial, paginas, ano "
                + "from libro as l "
                + "where titulo like ?"
                + "  and isbn like ?";
        if (id != null) {
            consulta = consulta + " and id_libro = " + id.toString();
        }

        if (!autor.isEmpty()) {
            consulta = consulta + "  and exists (select * "
                    + "              from autor "
                    + "              where libro=l.id_libro"
                    + "                and nombre like ?)";
        }

        try {
            stmCatalogo = con.prepareStatement(consulta);
            stmCatalogo.setString(1, "%" + titulo + "%");
            stmCatalogo.setString(2, "%" + isbn + "%");
            if (!autor.isEmpty()) {
                stmCatalogo.setString(3, "%" + autor + "%");
            }
            rsCatalogo = stmCatalogo.executeQuery();
            while (rsCatalogo.next()) {
                libroActual = new Libro(rsCatalogo.getInt("id_libro"), rsCatalogo.getString("titulo"),
                        rsCatalogo.getString("isbn"), rsCatalogo.getString("editorial"),
                        rsCatalogo.getInt("paginas"), rsCatalogo.getString("ano"));
                try {
                    stmAutores = con.prepareStatement("select nombre as autor "
                            + "from autor "
                            + "where libro = ? "
                            + "order by orden");
                    stmAutores.setInt(1, libroActual.getIdLibro());
                    rsAutores = stmAutores.executeQuery();
                    while (rsAutores.next()) {
                        libroActual.addAutor(rsAutores.getString("autor"));
                    }
                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                    this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
                } finally {
                    stmAutores.close();
                }
                resultado.add(libroActual);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                stmCatalogo.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
        return resultado;
    }

    public Libro consultarLibro(Integer idLibro) {
        Libro resultado = null;
        Connection con;
        PreparedStatement stmLibro = null;
        ResultSet rsLibro;
        PreparedStatement stmAutores = null;
        ResultSet rsAutores;
        PreparedStatement stmCategorias = null;
        ResultSet rsCategorias;
        PreparedStatement stmEjemplares = null;
        ResultSet rsEjemplares;

        con = super.getConexion();

        try {
            stmLibro = con.prepareStatement("select id_libro, titulo, isbn, editorial, paginas, ano "
                    + "from libro "
                    + "where id_libro = ?");
            stmLibro.setInt(1, idLibro);
            rsLibro = stmLibro.executeQuery();
            if (rsLibro.next()) {
                resultado = new Libro(rsLibro.getInt("id_libro"), rsLibro.getString("titulo"),
                        rsLibro.getString("isbn"), rsLibro.getString("editorial"),
                        rsLibro.getInt("paginas"), rsLibro.getString("ano"));

                try {
                    stmAutores = con.prepareStatement("select nombre as autor "
                            + "from autor "
                            + "where libro = ? "
                            + "order by orden");
                    stmAutores.setInt(1, resultado.getIdLibro());
                    rsAutores = stmAutores.executeQuery();
                    while (rsAutores.next()) {
                        resultado.addAutor(rsAutores.getString("autor"));
                    }
                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                    this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
                } finally {
                    stmAutores.close();
                }
                try {
                    stmCategorias = con.prepareStatement("select categoria "
                            + "from cat_tiene_libro "
                            + "where libro = ?");
                    stmCategorias.setInt(1, resultado.getIdLibro());
                    rsCategorias = stmCategorias.executeQuery();
                    while (rsCategorias.next()) {
                        resultado.addCategoria(new Categoria(rsCategorias.getString("categoria"), null));
                    }
                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                    this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
                } finally {
                    stmCategorias.close();
                }
                try {
                    stmEjemplares = con.prepareStatement("select libro, num_ejemplar, ano_compra, localizador "
                            + "from ejemplar "
                            + "where libro = ?");
                    stmEjemplares.setInt(1, resultado.getIdLibro());
                    rsEjemplares = stmEjemplares.executeQuery();
                    while (rsEjemplares.next()) {
                        resultado.addEjemplar(new Ejemplar(resultado.getIdLibro(), rsEjemplares.getInt("num_ejemplar"),
                                rsEjemplares.getString("localizador"),
                                rsEjemplares.getString("ano_compra")));
                    }
                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                    this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
                } finally {
                    stmEjemplares.close();
                }
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                stmLibro.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
        return resultado;
    }

    public java.util.List<Ejemplar> consultarEjemplaresLibro(Integer idLibro) {

        java.util.List<Ejemplar> resultado = new java.util.ArrayList<Ejemplar>();
        Connection con;
        PreparedStatement stmEjemplares = null;
        ResultSet rsEjemplares;

        con = super.getConexion();

        try {
            stmEjemplares = con.prepareStatement("(select num_ejemplar, ejemplar.libro,ano_compra, localizador,usuario, fecha_prestamo, (fecha_prestamo + 30) as fecha_vencimiento "
                    + "from ejemplar, prestamo "
                    + "where prestamo.libro = ejemplar.libro and ejemplar.libro = ? and ejemplar.num_ejemplar = prestamo.ejemplar and fecha_devolucion is null) "
                    + "union "
                    + "(select num_ejemplar, ejemplar.libro,ano_compra, localizador,null, null, null "
                    + "from ejemplar "
                    + "where (ejemplar.num_ejemplar ,ejemplar.libro) not in "
                    + "(select num_ejemplar, ejemplar.libro "
                    + "from ejemplar, prestamo "
                    + "where prestamo.libro = ejemplar.libro and ejemplar.num_ejemplar = prestamo.ejemplar and fecha_devolucion is null and ejemplar.libro = ?) and ejemplar.libro = ?)");

            stmEjemplares.setInt(1, idLibro);
            stmEjemplares.setInt(2, idLibro);
            stmEjemplares.setInt(3, idLibro);

            rsEjemplares = stmEjemplares.executeQuery();
            while (rsEjemplares.next()) {
                Ejemplar a = new Ejemplar(idLibro, rsEjemplares.getInt("num_ejemplar"),
                        rsEjemplares.getString("localizador"),
                        rsEjemplares.getString("ano_compra"));
                a.getPrestamo().setUsuario(rsEjemplares.getString("usuario"));
                a.getPrestamo().setFecha_vencimiento(rsEjemplares.getString("fecha_vencimiento"));
                a.getPrestamo().setFecha_prestamo(rsEjemplares.getString("fecha_prestamo"));
                a.getPrestamo().setDias(this.DiasFaltanParaVencer(idLibro, a.getNumEjemplar()));

                resultado.add(a);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                stmEjemplares.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
        return resultado;
    }

    public java.util.List<String> obtenerRestoCategorias(Integer idLibro) {
        java.util.List<String> resultado = new java.util.ArrayList<String>();
        String categoriaActual;
        Connection con;
        PreparedStatement stmCategorias = null;
        ResultSet rsCategorias;

        con = super.getConexion();

        try {
            stmCategorias = con.prepareStatement("select nombre "
                    + "from categoria c "
                    + "where not exists (select *  "
                    + "		  from cat_tiene_libro cl "
                    + "		  where cl.libro=? and cl.categoria=c.nombre)");
            stmCategorias.setInt(1, idLibro);
            rsCategorias = stmCategorias.executeQuery();
            while (rsCategorias.next()) {
                categoriaActual = rsCategorias.getString("nombre");
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

    public Integer insertarLibro(Libro libro) {
        Connection con;
        PreparedStatement stmLibro = null;
        PreparedStatement stmAutores = null;
        PreparedStatement stmIdLibro = null;
        ResultSet rsIdLibro;
        Integer numAutor;
        Integer idLibro = null;

        con = super.getConexion();

        try {
            stmLibro = con.prepareStatement("insert into libro(titulo, isbn, editorial, paginas, ano) "
                    + "values (?,?,?,?,?)");
            stmLibro.setString(1, libro.getTitulo());
            stmLibro.setString(2, libro.getIsbn());
            stmLibro.setString(3, libro.getEditorial());
            stmLibro.setInt(4, libro.getPaginas());
            stmLibro.setString(5, libro.getAno());
            stmLibro.executeUpdate();

            try {
                stmIdLibro = con.prepareStatement("select currval('seq_libro_id_libro') as idLibro");
                rsIdLibro = stmIdLibro.executeQuery();
                rsIdLibro.next();
                idLibro = rsIdLibro.getInt("idLibro");
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            } finally {
                stmIdLibro.close();
            }

            try {
                stmAutores = con.prepareStatement("insert into autor(libro, nombre, orden) "
                        + "values (?,?,?)");
                numAutor = 1;
                for (String s : libro.getAutores()) {
                    stmAutores.setInt(1, idLibro);
                    stmAutores.setString(2, s);
                    stmAutores.setInt(3, numAutor);
                    stmAutores.executeUpdate();
                    numAutor = numAutor + 1;
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
                this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
            } finally {
                stmAutores.close();
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                stmLibro.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }

        return idLibro;
    }

    public void borrarLibro(Integer idLibro) {
        Connection con;
        PreparedStatement stmLibro = null;

        con = super.getConexion();

        try {
            stmLibro = con.prepareStatement("delete from libro where id_libro = ?");
            stmLibro.setInt(1, idLibro);
            stmLibro.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                stmLibro.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
    }

    public void modificarLibro(Libro libro) {
        Connection con;
        PreparedStatement stmLibro = null;
        PreparedStatement stmAutores = null;
        PreparedStatement stmBorrado = null;
        Integer numAutor;

        con = super.getConexion();

        try {
            stmLibro = con.prepareStatement("update libro "
                    + "set titulo=?, "
                    + "    isbn=?, "
                    + "    editorial=?, "
                    + "    paginas=?, "
                    + "    ano=? "
                    + "where id_libro=?");
            stmLibro.setString(1, libro.getTitulo());
            stmLibro.setString(2, libro.getIsbn());
            stmLibro.setString(3, libro.getEditorial());
            stmLibro.setInt(4, libro.getPaginas());
            stmLibro.setString(5, libro.getAno());
            stmLibro.setInt(6, libro.getIdLibro());
            stmLibro.executeUpdate();

            try {
                stmBorrado = con.prepareStatement("delete from autor where libro=?");
                stmBorrado.setInt(1, libro.getIdLibro());
                stmBorrado.executeUpdate();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
                this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
            } finally {
                stmBorrado.close();
            }

            try {
                stmAutores = con.prepareStatement("insert into autor (libro, nombre, orden) "
                        + "values (?,?,?)");
                numAutor = 1;
                for (String s : libro.getAutores()) {
                    stmAutores.setInt(1, libro.getIdLibro());
                    stmAutores.setString(2, s);
                    stmAutores.setInt(3, numAutor);
                    stmAutores.executeUpdate();
                    numAutor = numAutor + 1;
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
                this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
            } finally {
                stmAutores.close();
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                stmLibro.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
    }

    public void modificarCategoriasLibro(Integer idLibro, java.util.List<String> categorias) {
        Connection con;
        PreparedStatement stmBorrado = null;
        PreparedStatement stmInsercion = null;

        con = super.getConexion();

        try {
            stmBorrado = con.prepareStatement("delete from cat_tiene_libro where libro = ?");
            stmBorrado.setInt(1, idLibro);
            stmBorrado.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                stmBorrado.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
        try {
            stmInsercion = con.prepareStatement("insert into cat_tiene_libro(libro, categoria) values (?,?)");
            for (String c : categorias) {
                stmInsercion.setInt(1, idLibro);
                stmInsercion.setString(2, c);
                stmInsercion.executeUpdate();
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                stmBorrado.close();
                stmInsercion.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
    }

    public void insertarEjemplarLibro(Integer idLibro, Ejemplar ejemplar) {
        Connection con;
        PreparedStatement stmEjemplar = null;

        con = super.getConexion();

        try {
            stmEjemplar = con.prepareStatement("insert into ejemplar(libro,ano_compra,localizador) "
                    + "values (?,?,?)");
            stmEjemplar.setInt(1, idLibro);
            stmEjemplar.setString(2, ejemplar.getAnoCompra());
            stmEjemplar.setString(3, ejemplar.getLocalizador());
            stmEjemplar.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                stmEjemplar.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
    }

    public void borrarEjemplaresLibro(Integer idLibro, java.util.List<Integer> numsEjemplar) {
        Connection con;
        PreparedStatement stmEjemplar = null;

        con = super.getConexion();
        try {
            stmEjemplar = con.prepareStatement("delete from ejemplar where libro=? and num_ejemplar=?");
            for (Integer i : numsEjemplar) {
                stmEjemplar.setInt(1, idLibro);
                stmEjemplar.setInt(2, i);
                stmEjemplar.executeUpdate();
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                stmEjemplar.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
    }

    public void modificarEjemplarLibro(Integer idLibro, Ejemplar ejemplar) {
        Connection con;
        PreparedStatement stmEjemplar = null;

        con = super.getConexion();

        try {
            stmEjemplar = con.prepareStatement("update ejemplar "
                    + "set ano_compra=?, "
                    + "   localizador=? "
                    + "where libro=? and num_ejemplar=?");
            stmEjemplar.setString(1, ejemplar.getAnoCompra());
            stmEjemplar.setString(2, ejemplar.getLocalizador());
            stmEjemplar.setInt(3, idLibro);
            stmEjemplar.setInt(4, ejemplar.getNumEjemplar());
            stmEjemplar.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                stmEjemplar.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
    }

    public void nuevoPrestamo(Ejemplar ej) {
        Connection con;
        PreparedStatement stmEjemplar = null;

        con = super.getConexion();
        if (checkeo_prestamo_mismo_dia(ej)) {
            this.getFachadaAplicacion().muestraExcepcion("Esta persona ya ha recibido y devuelto este ejemplar hoy.\n Vuelva mañana");
            return;
        }
        try {
            stmEjemplar = con.prepareStatement("insert into prestamo(fecha_prestamo, libro, usuario, ejemplar) "
                    + "values (now(),?,?,?)");
            stmEjemplar.setInt(1, ej.getLibro());
            stmEjemplar.setString(2, ej.getPrestamo().getUsuario());
            stmEjemplar.setInt(3, ej.getNumEjemplar());
            stmEjemplar.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                stmEjemplar.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
    }

    public void devolverEjemplar(Integer ejemplar, String usuario, Integer libro) {
        Connection con;
        PreparedStatement stmEjemplar = null;

        con = super.getConexion();

        try {
            stmEjemplar = con.prepareStatement("update prestamo "
                    + "set fecha_devolucion= now() "
                    + "where libro=? and ejemplar=? and usuario=?");
            stmEjemplar.setInt(1, libro);
            stmEjemplar.setInt(2, ejemplar);
            stmEjemplar.setString(3, usuario);
            stmEjemplar.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                stmEjemplar.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
    }

    public boolean checkeo_prestamo_mismo_dia(Ejemplar ej) {
        Connection con;
        PreparedStatement stmEjemplar = null;
        ResultSet rsEjemplar;

        con = super.getConexion();

        try {
            stmEjemplar = con.prepareStatement("select usuario "
                    + "from prestamo "
                    + "where prestamo.fecha_prestamo= current_date and ejemplar=? and libro =? and usuario=?");
            stmEjemplar.setInt(1, ej.getNumEjemplar());
            stmEjemplar.setInt(2, ej.getLibro());
            stmEjemplar.setString(3, ej.getPrestamo().getUsuario());

            rsEjemplar = stmEjemplar.executeQuery();
            return rsEjemplar.next();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
            return false;

        } finally {
            try {
                stmEjemplar.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
    }

    public boolean checkeo_borrado_ejemplares_prestados(int ejemplar, int libro) {
        Connection con;
        PreparedStatement stmEjemplar = null;
        ResultSet rsEjemplar;

        con = super.getConexion();

        try {
            stmEjemplar = con.prepareStatement("select ejemplar "
                    + "from prestamo "
                    + "where ejemplar=? and libro =?");
            stmEjemplar.setInt(1, ejemplar);
            stmEjemplar.setInt(2, libro);

            rsEjemplar = stmEjemplar.executeQuery();
            return rsEjemplar.next();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
            return false;

        } finally {
            try {
                stmEjemplar.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
    }

    //cambio 7
    public Integer DiasFaltanParaVencer(Integer libro, Integer ejemplar) {
        Integer dias = null;
        Connection con;
        PreparedStatement stmPrestamosVencidos = null;
        ResultSet rsDiasFaltan;
        con = this.getConexion();
        String consulta = "select current_date - (fecha_prestamo + 30) as dias "
                + "from prestamo "
                + "where fecha_devolucion is null and libro = ? and ejemplar = ?";
        try {
            stmPrestamosVencidos = con.prepareStatement(consulta);
            stmPrestamosVencidos.setInt(1, libro);
            stmPrestamosVencidos.setInt(2, ejemplar);
            rsDiasFaltan = stmPrestamosVencidos.executeQuery();
            if (rsDiasFaltan.next()) {
                dias = rsDiasFaltan.getInt("dias");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                stmPrestamosVencidos.close();
            } catch (SQLException e) {
                System.out.println("Imposible   cerrar cursores");
            }
        }
        return dias;
    }
}

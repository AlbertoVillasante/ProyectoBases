package aplicacion;

public class Prestamo {

    private String fecha_prestamo;
    private String fecha_devolucion;
    private String fecha_vencimiento;
    private Integer libro;
    private String usuario;
    private Integer ejemplar;
    private Integer dias;

    public Prestamo(String fecha_prestamo, Integer libro, String usuario, Integer ejemplar) {
        this.fecha_prestamo = fecha_prestamo;
        this.libro = libro;
        this.usuario = usuario;
        this.ejemplar = ejemplar;
    }

    public Integer getDias() {
        return dias;
    }

    public void setDias(Integer dias) {
        this.dias = dias;
    }
    
    
    public String getFecha_vencimiento() {
        return fecha_vencimiento;
    }

    public void setFecha_vencimiento(String fecha_vencimiento) {
        this.fecha_vencimiento = fecha_vencimiento;
    }

    public String getFecha_prestamo() {
        return fecha_prestamo;
    }

    public void setFecha_prestamo(String fecha_prestamo) {
        this.fecha_prestamo = fecha_prestamo;
    }

    public String getFecha_devolucion() {
        return fecha_devolucion;
    }

    public void setFecha_devolucion(String fecha_devolucion) {
        this.fecha_devolucion = fecha_devolucion;
    }

    public int getLibro() {
        return libro;
    }

    public void setLibro(int libro) {
        this.libro = libro;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public int getEjemplar() {
        return ejemplar;
    }

    public void setEjemplar(int ejemplar) {
        this.ejemplar = ejemplar;
    }

}

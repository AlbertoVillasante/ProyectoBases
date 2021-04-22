package aplicacion;

public class EmpresaUsuario {

    private String idUsuario;
    private String clave;
    private String nombreComercial;
    private String direccion;
    private String telefono;
    private TipoUsuario tipo;
    private int nParticipaciones;
    private float comision;
    private double fondosDisponiblesCuenta;

    public EmpresaUsuario(String idUsuario, String clave, String nombreComercial, String direccion, String telefono, TipoUsuario tipo) {
        this.idUsuario = idUsuario;
        this.clave = clave;
        this.nombreComercial = nombreComercial;
        this.direccion = direccion;
        this.telefono = telefono;
        this.tipo = tipo;
    }

    public String getNombreComercial() {
        return nombreComercial;
    }

    public void setNombreComercial(String nombreComercial) {
        this.nombreComercial = nombreComercial;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getnParticipaciones() {
        return nParticipaciones;
    }

    public void setnParticipaciones(int nParticipaciones) {
        this.nParticipaciones = nParticipaciones;
    }

    public double getFondosDisponiblesCuenta() {
        return fondosDisponiblesCuenta;
    }

    public void setFondosDisponiblesCuenta(double fondosDisponiblesCuenta) {
        this.fondosDisponiblesCuenta = fondosDisponiblesCuenta;
    }

    public String getIdUsuario() {

        return this.idUsuario;
    }

    public String getClave() {

        return this.clave;
    }

    public String getDireccion() {

        return this.direccion;
    }

    public TipoUsuario getTipoUsuario() {

        return this.tipo;
    }

    public void setTipoUsuario(TipoUsuario tipo) {
        this.tipo = tipo;
    }
    
    

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public float getComision() {
        return comision;
    }

    public void setComision(float comision) {
        this.comision = comision;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    
}

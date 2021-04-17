/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion;

/**
 *
 * @author alumnogreibd
 */
public class InversorUsuario {
    private String idUsuario;
    private String clave;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private String direccion;
    private String telefono;
    private TipoUsuario tipoUsuario;
    private int nParticipaciones;
    private float comision;
    private double fondosDisponiblesCuenta;

    public InversorUsuario(String idUsuario, String clave, String nombre, String apellido1, String apellido2, String direccion, String telefono, TipoUsuario tipo) {
        this.idUsuario = idUsuario;
        this.clave = clave;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.tipoUsuario = tipo;
    }
    
    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(TipoUsuario tipo) {
        this.tipoUsuario = tipo;
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

    public float getComision() {
        return comision;
    }

    public void setComision(float comision) {
        this.comision = comision;
    }
    
    
    
}

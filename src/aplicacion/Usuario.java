package aplicacion;

public class Usuario {

    private String idUsuario;
    private String clave;
    private String nombre;
    private String direccion;
    private String email;
    private TipoUsuario tipo;
    private int prestamosVencidos = 0;

    public Usuario(String idUsuario, String clave, String nombre, String direccion, String email, TipoUsuario tipo) {
        this.idUsuario = idUsuario;
        this.clave = clave;
        this.nombre = nombre;
        this.direccion = direccion;
        this.email = email;
        this.tipo = tipo;
    }

    public int getPrestamosVencidos() {
        return prestamosVencidos;
    }

    public void setPrestamosVencidos(int prestamosVencidos) {
        this.prestamosVencidos = prestamosVencidos;
    }

    public String getIdUsuario() {

        return this.idUsuario;
    }

    public String getClave() {

        return this.clave;
    }

    public String getNombre() {

        return this.nombre;
    }

    public String getDireccion() {

        return this.direccion;
    }

    public String getEmail() {

        return this.email;
    }

    public TipoUsuario getTipoUsuario() {

        return this.tipo;
    }

}

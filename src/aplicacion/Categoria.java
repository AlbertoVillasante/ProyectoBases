package aplicacion;

public class Categoria {

    private String nombre;
    private String descripcion;

    public Categoria(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public String getNombre() {

        return this.nombre;
    }

    public String getDescripcion() {

        return this.descripcion;
    }

}

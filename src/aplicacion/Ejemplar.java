package aplicacion;

public class Ejemplar {

    private Integer numEjemplar;
    private String localizador;
    private String anoCompra;
    private Integer libro;
    Prestamo prestamo;

    public Ejemplar(Integer libro, Integer numEjemplar, String localizador, String anoCompra) {
        this.numEjemplar = numEjemplar;
        this.anoCompra = anoCompra;
        this.localizador = localizador;
        this.libro = libro;
        this.prestamo = new Prestamo(null, null, null, this.libro);
    }

    public Prestamo getPrestamo() {
        return prestamo;
    }

    public void setPrestamo(Prestamo prestamo) {
        this.prestamo = prestamo;
    }

    public Integer getNumEjemplar() {
        return this.numEjemplar;
    }

    public String getAnoCompra() {
        return this.anoCompra;
    }

    public String getLocalizador() {
        return this.localizador;
    }

    public int getLibro() {
        return libro;
    }

    public void setLocalizador(String l) {
        localizador = l;
    }

    public void setAnoCompra(String a) {
        anoCompra = a;
    }

}

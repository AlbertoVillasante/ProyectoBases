
package aplicacion;

public class AnunciarBeneficios {

    private String fecha;
    private float beneficios;
    private int numParticipaciones;
    private String idEmpresa;
    private String nombreEmpresa;

    public AnunciarBeneficios(String fecha, float beneficios, int numParticipaciones, String idEmpresa) {
        this.fecha = fecha;
        this.beneficios = beneficios;
        this.numParticipaciones = numParticipaciones;
        this.idEmpresa = idEmpresa;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    
    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public float getBeneficios() {
        return beneficios;
    }

    public void setBeneficios(float beneficios) {
        this.beneficios = beneficios;
    }

    public int getNumParticipaciones() {
        return numParticipaciones;
    }

    public void setNumParticipaciones(int numParticipaciones) {
        this.numParticipaciones = numParticipaciones;
    }

    public String getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(String idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

}

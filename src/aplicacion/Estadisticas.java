
package aplicacion;

public class Estadisticas {

    private int numeroParticipaciones;
    private String empresa;

    public Estadisticas(int numeroParticipaciones, String empresa) {
        this.numeroParticipaciones = numeroParticipaciones;
        this.empresa = empresa;
    }

    public int getNumeroParticipaciones() {
        return numeroParticipaciones;
    }

    public void setNumeroParticipaciones(int numeroParticipaciones) {
        this.numeroParticipaciones = numeroParticipaciones;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

}

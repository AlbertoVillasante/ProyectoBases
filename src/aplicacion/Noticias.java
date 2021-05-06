
package aplicacion;


public class Noticias {
    private int idNoticia;
    private String idUsuario;
    private String TipoNoticia;
    private String descripcion;

    public Noticias(int idNoticia, String idUsuario, String TipoNoticia, String descripcion) {
        this.idNoticia = idNoticia;
        this.TipoNoticia = TipoNoticia;
        this.descripcion=descripcion;
    }

    public int getIdNoticia() {
        return idNoticia;
    }

    public void setIdNoticia(int idNoticia) {
        this.idNoticia = idNoticia;
    }

    public String getTipoNoticia() {
        return TipoNoticia;
    }

    public void setTipoNoticia(String TipoNoticia) {
        this.TipoNoticia = TipoNoticia;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
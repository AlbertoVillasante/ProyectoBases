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
public class Noticias {
    private String idUsuario;
    private int idNoticia;
    private String TipoNoticia;

    public Noticias(String idUsuario, int idNoticia, String TipoNoticia) {
        this.idUsuario = idUsuario;
        this.idNoticia = idNoticia;
        this.TipoNoticia = TipoNoticia;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
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
}

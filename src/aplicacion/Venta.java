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
public class Venta {
    Float precio;
    Integer nparticipaciones;
    String idEmpresa;
    String idVendedor;

    public Venta(Float precio, Integer nparticipaciones, String empr, String idVendedor) {
        this.precio = precio;
        this.nparticipaciones = nparticipaciones;
        this.idEmpresa = empr;
        this.idVendedor=idVendedor;
    }

    public Float getPrecio() {
        return precio;
    }

    public Integer getNparticipaciones() {
        return nparticipaciones;
    }

    public String getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(String idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public void setPrecio(Float precio) {
        this.precio = precio;
    }

    public void setNparticipaciones(Integer nparticipaciones) {
        this.nparticipaciones = nparticipaciones;
    }

    public String getIdVendedor() {
        return idVendedor;
    }

    public void setIdVendedor(String idVendedor) {
        this.idVendedor = idVendedor;
    }
}

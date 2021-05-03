/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion;

/**
 *
 * @author hugo
 */
public class OfertaParticipaciones {

    private String fechaOferta;
    private String idUsuario1;
    private String idUsuario2;
    private int numeroParticipaciones;
    private double precioParticipacion;
    private float comision;

    public OfertaParticipaciones(String fechaOferta, String idUsuario1, String idUsuario2) {
        this.fechaOferta = fechaOferta;
        this.idUsuario1 = idUsuario1;
        this.idUsuario2 = idUsuario2;
    }

    public OfertaParticipaciones(double precioParticipacion, int numeroParticipaciones, String idUsuario2, String idUsuario1) {
        this.precioParticipacion = precioParticipacion;
        this.numeroParticipaciones = numeroParticipaciones;
        this.idUsuario1 = idUsuario1;
        this.idUsuario2 = idUsuario2;
    }

    public float getComision() {
        return comision / 100;
    }

    public void setComision(float comision) {
        this.comision = comision;
    }

    public String getFechaOferta() {
        return fechaOferta;
    }

    public void setFechaOferta(String fechaOferta) {
        this.fechaOferta = fechaOferta;
    }

    public String getIdUsuario1() {
        return idUsuario1;
    }

    public void setIdUsuario1(String idUsuario1) {
        this.idUsuario1 = idUsuario1;
    }

    public String getIdUsuario2() {
        return idUsuario2;
    }

    public void setIdUsuario2(String idUsuario2) {
        this.idUsuario2 = idUsuario2;
    }

    public int getNumeroParticipaciones() {
        return numeroParticipaciones;
    }

    public void setNumeroParticipaciones(int numeroParticipaciones) {
        this.numeroParticipaciones = numeroParticipaciones;
    }

    public double getPrecioParticipacion() {
        return precioParticipacion;
    }

    public void setPrecioParticipacion(double precioParticipacion) {
        this.precioParticipacion = precioParticipacion;
    }

    =======
 * @author
    alumnogreibd

    */
public class OfertaParticipaciones {

        private Float precio;
        private Integer nparticipaciones;
        private String idEmpresa;
        private String idVendedor;
        private String fechaOferta;

        public OfertaParticipaciones(Float precio, Integer nparticipaciones, String empr, String idVendedor) {
            this.precio = precio;
            this.nparticipaciones = nparticipaciones;
            this.idEmpresa = empr;
            this.idVendedor = idVendedor;
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

        public String getFechaOferta() {
            return fechaOferta;
        }

        public void setFechaOferta(String fechaOferta) {
            this.fechaOferta = fechaOferta;
        }

        >>>>>>> origin
        /master
    }

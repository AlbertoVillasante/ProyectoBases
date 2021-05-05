/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import aplicacion.OfertaParticipaciones;
import javax.swing.table.AbstractTableModel;
import aplicacion.FachadaAplicacion;

/**
 *
 * @author alumnogreibd
 */
public class ModeloTablaParticipaciones extends AbstractTableModel {

    FachadaAplicacion fa;
    private java.util.List<OfertaParticipaciones> ofertas;

    public ModeloTablaParticipaciones() {
        this.ofertas = new java.util.ArrayList<OfertaParticipaciones>();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public int getRowCount() {
        return ofertas.size();
    }

    @Override
    public String getColumnName(int col) {
        String nombre = "";

        switch (col) {
            case 0:
                nombre = "Numero participaciones";
                break;
            case 1:
                nombre = "Empresa";
                break;
            case 2:
                nombre = "Vendedor";
                break;
            case 3:
                nombre = "Precio";
        }
        return nombre;
    }

    @Override
    public Class getColumnClass(int col) {
        Class clase = null;

        switch (col) {
            case 0:
                clase = java.lang.Integer.class;
                break;
            case 1:
                clase = java.lang.String.class;
                break;
            case 2:
                clase = java.lang.String.class;
                break;
            case 3:
                clase = java.lang.Double.class;
        }
        return clase;
    }

    @Override
    public boolean isCellEditable(int row, int col) {
        return false;
    }

    @Override
    public Object getValueAt(int row, int col) {  
        Object resultado = null;

        switch (col) {
            case 0:
                resultado = ofertas.get(row).getNumeroParticipaciones();
                break;
            case 1:
                resultado = ofertas.get(row).getIdUsuario2();
                break;
            case 2:
                resultado = ofertas.get(row).getIdUsuario1();
                break;
            case 3:
                resultado = ofertas.get(row).getPrecioParticipacion();
        }
        return resultado;
    }

    public void setFilas(java.util.List<OfertaParticipaciones> ventas) {
        this.ofertas = ventas;
        fireTableDataChanged();
    }

    public OfertaParticipaciones obtenerVenta(int i) {
        return this.ofertas.get(i);
    }

    public double obtenerPrecio(int row) {
        return this.ofertas.get(row).getPrecioParticipacion();
    }
}

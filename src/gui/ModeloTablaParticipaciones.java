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
public class ModeloTablaParticipaciones extends AbstractTableModel{
    FachadaAplicacion fa;
    private java.util.List<OfertaParticipaciones> ventas;

    public ModeloTablaParticipaciones() {
        this.ventas = new java.util.ArrayList<OfertaParticipaciones>();
    }

    public int getColumnCount() {
        return 3;
    }

    public int getRowCount() {
        return ventas.size();
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
        }
        return clase;
    }

    @Override
    public boolean isCellEditable(int row, int col) {
        return false;
    }

    public Object getValueAt(int row, int col) {      //Comentado por ahora, para que no de error
        Object resultado = null;

        switch (col) {
            case 0:
                resultado = ventas.get(row).getNparticipaciones();
                break;
            case 1:
                resultado = ventas.get(row).getIdEmpresa();
                break;
            case 2:
                resultado = ventas.get(row).getIdVendedor();
                break;
        }
        return resultado;
    }

    public void setFilas(java.util.List<OfertaParticipaciones> ventas) {
        this.ventas = ventas;
        fireTableDataChanged();
    }

    public OfertaParticipaciones obtenerVenta(int i) {
        return this.ventas.get(i);
    }

    /*public java.util.List<String> obtenerId() {
        java.util.ArrayList<String> us = new ArrayList<String>();
        for (EmpresaUsuario u : this.usuarios) {
            us.add(u.getIdUsuario());
        }
        return us;
    }*/
    
    public Float obtenerPrecio(int row){
        return this.ventas.get(row).getPrecio();
    }
}

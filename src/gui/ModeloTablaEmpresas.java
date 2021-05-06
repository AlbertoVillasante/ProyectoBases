package gui;

import aplicacion.EmpresaUsuario;
import aplicacion.prestamo;
import java.util.ArrayList;
import javax.swing.table.*;

public class ModeloTablaEmpresas extends AbstractTableModel {

    private java.util.List<prestamo> usuarios;

    public ModeloTablaEmpresas() {
        this.usuarios = new java.util.ArrayList<prestamo>();
    }

    public int getColumnCount() {
        return 3;
    }

    public int getRowCount() {
        return usuarios.size();
    }

    @Override
    public String getColumnName(int col) {
        String nombre = "";

        switch (col) {
            case 0:
                nombre = "Id";
                break;
            case 1:
                nombre = "Nombre";
                break;
            case 2:
                nombre = "Precio";
                break;
        }
        return nombre;
    }

    @Override
    public Class getColumnClass(int col) {
        Class clase = null;

        switch (col) {
            case 0:
                clase = java.lang.String.class;
                break;
            case 1:
                clase = java.lang.String.class;
                break;
            case 2:
                clase = java.lang.Double.class;
                break;

        }
        return clase;
    }

    @Override
    public boolean isCellEditable(int row, int col) {
        return false;
    }

    public Object getValueAt(int row, int col) {
        Object resultado = null;

        switch (col) {
            case 0:
                resultado = usuarios.get(row).getId();
                break;
            case 1:
                resultado = usuarios.get(row).getNombre();
                break;
            case 2:
                resultado = usuarios.get(row).getPrecio();
                break;
        }
        return resultado;
    }

    public void setFilas(java.util.List<prestamo> usuarios) {
        this.usuarios = usuarios;
        fireTableDataChanged();
    }

    public prestamo obtenerUsuario(int i) {
        return this.usuarios.get(i);
    }

    public java.util.List<String> obtenerId() {
        java.util.ArrayList<String> us = new ArrayList<String>();
        for (prestamo u : this.usuarios) {
            us.add(u.getId());
        }
        return us;
    }

}

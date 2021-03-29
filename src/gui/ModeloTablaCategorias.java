package gui;

import aplicacion.Categoria;
import javax.swing.table.*;

public class ModeloTablaCategorias extends AbstractTableModel {

    private java.util.List<Categoria> categorias;

    public ModeloTablaCategorias() {
        this.categorias = new java.util.ArrayList<Categoria>();
    }

    public int getColumnCount() {
        return 1;
    }

    public int getRowCount() {
        return categorias.size();
    }

    @Override
    public String getColumnName(int col) {
        String nombre = "";

        switch (col) {
            case 0:
                nombre = "Nombre";
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
                resultado = categorias.get(row).getNombre();
                break;
        }
        return resultado;
    }

    public void setFilas(java.util.List<Categoria> categorias) {
        this.categorias = categorias;
        fireTableDataChanged();
    }

    public Categoria obtenerCategoria(int i) {
        return this.categorias.get(i);
    }
}

package gui;

import aplicacion.Usuario;
import javax.swing.table.*;

public class ModeloTablaPrestamos extends AbstractTableModel {

    private java.util.List<Usuario> usuarios;

    public ModeloTablaPrestamos() {
        this.usuarios = new java.util.ArrayList<Usuario>();
    }

    public int getColumnCount() {
        return 4;
    }

    public int getRowCount() {
        return usuarios.size();
    }

    @Override
    public String getColumnName(int col) {
        String nombre = "";

        switch (col) {
            case 0:
                nombre = "ID";
                break;
            case 1:
                nombre = "Nombre";
                break;
            case 2:
                nombre = "E-mail";
                break;
            case 3:
                nombre = "Prestamos Vencidos";
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
                clase = java.lang.String.class;
                break;
            case 3:
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
                resultado = usuarios.get(row).getIdUsuario();
                break;
            case 1:
                resultado = usuarios.get(row).getNombre();
                break;
            case 2:
                resultado = usuarios.get(row).getEmail();
                break;
            case 3:
                resultado = usuarios.get(row).getPrestamosVencidos();
                break;
        }
        return resultado;
    }

    public void setFilas(java.util.List<Usuario> usuarios) {
        this.usuarios = usuarios;
        fireTableDataChanged();
    }

    public Usuario obtenerUsuario(int i) {
        return this.usuarios.get(i);
    }

}

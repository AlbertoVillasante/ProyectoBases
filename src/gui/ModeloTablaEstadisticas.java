package gui;

import aplicacion.Estadisticas;
import javax.swing.table.*;

public class ModeloTablaEstadisticas extends AbstractTableModel {

    private java.util.List<Estadisticas> estadisticas;

    public ModeloTablaEstadisticas() {
        this.estadisticas = new java.util.ArrayList<Estadisticas>();
    }

    public int getColumnCount() {
        return 2;
    }

    public int getRowCount() {
        return estadisticas.size();
    }

    @Override
    public String getColumnName(int col) {
        String nombre = "";

        switch (col) {
            case 0:
                nombre = "Empresa";
                break;
            case 1:
                nombre = "Nº Participaciones";
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
                clase = java.lang.Integer.class;
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
                resultado = estadisticas.get(row).getEmpresa();
                break;
            case 1:
                resultado = estadisticas.get(row).getNumeroParticipaciones();
                break;
        }

        return resultado;
    }

    public void setFilas(java.util.List<Estadisticas> estadisticas) {
        this.estadisticas = estadisticas;
        fireTableDataChanged();
    }

    public Estadisticas obtenerUsuario(int i) {
        return this.estadisticas.get(i);
    }

}

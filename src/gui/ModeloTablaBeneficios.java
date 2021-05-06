package gui;

import aplicacion.AnunciarBeneficios;
import javax.swing.table.*;

public class ModeloTablaBeneficios extends AbstractTableModel {

    private java.util.List<AnunciarBeneficios> beneficios;

    public ModeloTablaBeneficios() {
        this.beneficios = new java.util.ArrayList<AnunciarBeneficios>();
    }

    public int getColumnCount() {
        return 4;
    }

    public int getRowCount() {
        return beneficios.size();
    }

    @Override
    public String getColumnName(int col) {
        String nombre = "";

        switch (col) {
            case 0:
                nombre = "Fecha de Pago";
                break;
            case 1:
                nombre = "Nombre Empresa";
                break;
            case 2:
                nombre = "Importe/Participacion";
                break;
            case 3:
                nombre = "Participaciones";
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
                clase = java.lang.Float.class;
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
                resultado = beneficios.get(row).getFecha();
                break;
            case 1:
                resultado = beneficios.get(row).getNombreEmpresa();
                break;
            case 2:
                resultado = beneficios.get(row).getBeneficios();
                break;
            case 3:
                resultado = beneficios.get(row).getNumParticipaciones();
                break;
        }
        return resultado;
    }

    public void setFilas(java.util.List<AnunciarBeneficios> beneficios) {
        this.beneficios = beneficios;
        fireTableDataChanged();
    }

    public AnunciarBeneficios obtenerUsuario(int i) {
        return this.beneficios.get(i);
    }

}

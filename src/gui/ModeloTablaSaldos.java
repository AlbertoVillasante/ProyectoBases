package gui;

import aplicacion.Saldos;
import java.util.ArrayList;
import javax.swing.table.*;

public class ModeloTablaSaldos extends AbstractTableModel {

    private java.util.List<Saldos> saldos;

    public ModeloTablaSaldos() {
        this.saldos = new java.util.ArrayList<Saldos>();
    }

    public int getColumnCount() {
        return 2;
    }

    public int getRowCount() {
        return saldos.size();
    }

    @Override
    public String getColumnName(int col) {
        String nombre = "";

        switch (col) {
            case 0:
                nombre = "ID";
                break;
            case 1:
                nombre = "Saldo";
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
                resultado = saldos.get(row).getUsuario();
                break;
            case 1:
                resultado = saldos.get(row).getSaldo();
                break;
        }
        return resultado;
    }

    public void setFilas(java.util.List<Saldos> saldos) {
        this.saldos = saldos;
        fireTableDataChanged();
    }

    public Saldos obtenerSaldo(int i) {
        return this.saldos.get(i);
    }

}

package gui;

import aplicacion.EmpresaUsuario;
import aplicacion.InversorUsuario;
import java.util.ArrayList;
import javax.swing.table.*;
/*
public class ModeloTablaVerificacion extends AbstractTableModel {

    private java.util.List<EmpresaUsuario> usuariosEmp;
    private java.util.List<InversorUsuario> usuariosInv;

    public ModeloTablaVerificacion() {
        this.usuariosEmp = new java.util.ArrayList<EmpresaUsuario>();
        this.usuariosInv = new java.util.ArrayList<InversorUsuario>();
    }

    public int getColumnCount() {
        return 6;
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
                nombre = "Clave";
                break;
            case 2:
                nombre = "Nombre";
                break;
            case 3:
                nombre = "Teléfono";
                break;
            case 4:
                nombre = "Dirección";
                break;
            case 5:
                nombre = "Estado";
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
                clase = java.lang.String.class;
                break;
            case 4:
                clase = java.lang.String.class;
                break;
            case 5:
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
                resultado = usuarios.get(row).getIdUsuario();
                break;
            case 1:
                resultado = usuarios.get(row).getClave();
                break;
            case 2:
                resultado = usuarios.get(row).getNombreComercial();
                break;
            case 3:
                resultado = usuarios.get(row).getTipoUsuario();
                break;
        }
        return resultado;
    }

    public void setFilas(java.util.List<EmpresaUsuario> usuarios) {
        this.usuarios = usuarios;
        fireTableDataChanged();
    }

    public EmpresaUsuario obtenerUsuario(int i) {
        return this.usuarios.get(i);
    }

    public java.util.List<String> obtenerId() {
        java.util.ArrayList<String> us = new ArrayList<String>();
        for (EmpresaUsuario u : this.usuarios) {
            us.add(u.getIdUsuario());
        }
        return us;
    }

}
*/
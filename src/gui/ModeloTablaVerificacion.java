package gui;

import aplicacion.EmpresaUsuario;
import aplicacion.InversorUsuario;
import javax.swing.table.*;

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
        return usuariosEmp.size()+usuariosInv.size();
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

    public Object getValueAt(int row, int col) {      
        Object resultado = null;
        
        if(row < usuariosEmp.size()){
            switch (col) {
                case 0:
                    resultado = usuariosEmp.get(row).getIdUsuario();
                    break;
                case 1:
                    resultado = usuariosEmp.get(row).getClave();
                    break;
                case 2:
                    resultado = usuariosEmp.get(row).getNombreComercial();
                    break;
                case 3:
                    resultado = usuariosEmp.get(row).getTelefono();
                    break;
                case 4:
                    resultado = usuariosEmp.get(row).getDireccion();
                    break;
                case 5:
                    resultado = usuariosEmp.get(row).getTipoUsuario();
                    break;
            }
        }
        
        else{
            switch (col) {
                case 0:
                    resultado = usuariosInv.get(row - usuariosEmp.size()).getIdUsuario();
                    break;
                case 1:
                    resultado = usuariosInv.get(row - usuariosEmp.size()).getClave();
                    break;
                case 2:
                    resultado = usuariosInv.get(row - usuariosEmp.size()).getNombre();
                    break;
                case 3:
                    resultado = usuariosInv.get(row - usuariosEmp.size()).getTelefono();
                    break;
                case 4:
                    resultado = usuariosInv.get(row - usuariosEmp.size()).getDireccion();
                    break;
                case 5:
                    resultado = usuariosInv.get(row - usuariosEmp.size()).getTipoUsuario();
                    break;
            }
        }

        
        return resultado;
    }

    public void setFilas(java.util.List<EmpresaUsuario> usuariosEmpr, java.util.List<InversorUsuario> usuariosInv) {
        this.usuariosEmp=usuariosEmpr;
        this.usuariosInv=usuariosInv;
        fireTableDataChanged();
    }

    public EmpresaUsuario obtenerUsuarioEmpr(int i) {
        return this.usuariosEmp.get(i);
    }
    
    public InversorUsuario obtenerUsuarioInv(int i) {
        return this.usuariosInv.get(i);
    }
    
    public int obtenerNumEmprPend(){
        return this.usuariosEmp.size();
    }


}

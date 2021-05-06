/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import aplicacion.FachadaAplicacion;
import aplicacion.Noticias;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author alumnogreibd
 */
public class ModeloTablaNoticias extends AbstractTableModel{
    private java.util.List<Noticias> noticia;
    FachadaAplicacion fa;

    public ModeloTablaNoticias() {
        this.noticia = new java.util.ArrayList<Noticias>();
    }

    @Override
    public int getColumnCount() {
        return 1;
    }

    @Override
    public int getRowCount() {
        return noticia.size();
    }

    @Override
    public String getColumnName(int col) {
        String nombre = "";

        switch (col) {
            case 0:
                nombre = "Noticia";
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
        }
        return clase;
    }

    @Override
    public boolean isCellEditable(int row, int col) {
        return false;
    }
    
    @Override
    public Object getValueAt(int row, int col) {      
        Object resultado;
        
        resultado = noticia.get(row).getDescripcion();
            
        return resultado;
    }

    public void setFilas(java.util.List<Noticias> not) {
        this.noticia = not;
        fireTableDataChanged();
    }
}
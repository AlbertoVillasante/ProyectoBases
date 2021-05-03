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

    public int getColumnCount() {
        return 1;
    }

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
        Object resultado = null;
        
        if(noticia.get(row).getTipoNoticia().equals("Alta")){
            if(noticia.get(row).getIdUsuario().length() == 9){
                resultado = "El inversor " + fa.getnombreInversor(noticia.get(row).getIdUsuario()) + " ha ingresado en el Mercado de Valores";
            } else{
                resultado = "La empresa " + fa.getnombreEmpresa(noticia.get(row).getIdUsuario()) + " ha ingresado en el Mercado de Valores";
            }
            
        } else if(noticia.get(row).getTipoNoticia().equals("Compra")){
            if(noticia.get(row).getIdUsuario().length() == 9){
                resultado = "El inversor " + fa.getnombreInversor(noticia.get(row).getIdUsuario()) + " ha comprado";
            } else{
                resultado = "La empresa " + fa.getnombreEmpresa(noticia.get(row).getIdUsuario()) + " ha comprado";
            }
            
        } else if(noticia.get(row).getTipoNoticia().equals("Baja")){
            if(noticia.get(row).getIdUsuario().length() == 9){
                resultado = "El inversor " + fa.getnombreInversor(noticia.get(row).getIdUsuario()) + " se ha dado de baja en el Mercado de Valores";
            } else{
                resultado = "La empresa " + fa.getnombreEmpresa(noticia.get(row).getIdUsuario()) + " se ha dado de baja en el Mercado de Valores";
            }
        } else if(noticia.get(row).getTipoNoticia().equals("Alta P")){
            
        } else if(noticia.get(row).getTipoNoticia().equals("Baja P")){
            
        } else if(noticia.get(row).getTipoNoticia().equals("Anuncio beneficios")){
            
        }
            
        return resultado;
    }

    public void setFilas(java.util.List<Noticias> not) {
        this.noticia = not;
        fireTableDataChanged();
    }
}

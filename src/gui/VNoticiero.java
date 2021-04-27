/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.Color;
import javax.swing.ImageIcon;

/**
 *
 * @author alumnogreibd
 */
public class VNoticiero extends javax.swing.JDialog {
    String noticia;
    Color prueba = new Color(60, 63, 65);
    Color prueba1 = new Color(78, 82, 85);
    aplicacion.FachadaAplicacion fa;
    
    public VNoticiero(aplicacion.FachadaAplicacion fa, String tiponoticia) {
        noticia = tiponoticia;
        initComponents();
        this.getContentPane().setBackground(prueba);
        titulo.setText(noticia);
        if(noticia.equals("ANUNCIOS DE BENEFICIOS")) fotoNoticia.setIcon(new ImageIcon(getClass().getResource("/gui/Beneficios.png")));
        if(noticia.equals("ANUNCIOS DE ALTAS Y BAJAS")) fotoNoticia.setIcon(new ImageIcon(getClass().getResource("/gui/gente.png")));
        if(noticia.equals("ANUNCIOS DE PARTICIPACIONES")) fotoNoticia.setIcon(new ImageIcon(getClass().getResource("/gui/participaciones.png")));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titulo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        salir = new javax.swing.JButton();
        fotoNoticia = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        titulo.setEditable(false);
        titulo.setBackground(new java.awt.Color(51, 51, 51));
        titulo.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        titulo.setForeground(new java.awt.Color(153, 153, 153));
        titulo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        titulo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        titulo.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        titulo.setSelectionColor(new java.awt.Color(255, 255, 255));

        jLabel2.setForeground(new java.awt.Color(153, 153, 153));
        jLabel2.setText("__________________________________");

        jLabel3.setForeground(new java.awt.Color(153, 153, 153));
        jLabel3.setText("__________________________________");

        salir.setBackground(new java.awt.Color(180, 22, 45));
        salir.setForeground(new java.awt.Color(0, 0, 0));
        salir.setText("Salir");
        salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirActionPerformed(evt);
            }
        });

        fotoNoticia.setBackground(new java.awt.Color(255, 255, 255));
        fotoNoticia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/Beneficios.png"))); // NOI18N
        fotoNoticia.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        fotoNoticia.setBorderPainted(false);
        fotoNoticia.setContentAreaFilled(false);
        fotoNoticia.setFocusPainted(false);
        fotoNoticia.setFocusable(false);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 545, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fotoNoticia, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(salir, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(titulo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(fotoNoticia, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(salir)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirActionPerformed
        this.dispose();
    }//GEN-LAST:event_salirActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton fotoNoticia;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton salir;
    private javax.swing.JTextField titulo;
    // End of variables declaration//GEN-END:variables
}


package gui;

import java.awt.Color;


public class VNoticias extends javax.swing.JDialog {

    Color prueba = new Color(60, 63, 65);
    Color prueba1 = new Color(78, 82, 85);
    aplicacion.FachadaAplicacion fa;

    public VNoticias(aplicacion.FachadaAplicacion fa) {
        initComponents();
        botonBeneficios.setBackground(prueba);
        gente.setBackground(prueba);
        participaciones.setBackground(prueba);
        this.fa = fa;
        this.getContentPane().setBackground(prueba);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        volver = new javax.swing.JButton();
        salir = new javax.swing.JButton();
        botonBeneficios = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        gente = new javax.swing.JButton();
        participaciones = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setAutoRequestFocus(false);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        volver.setBackground(new java.awt.Color(50, 50, 50));
        volver.setForeground(new java.awt.Color(187, 187, 188));
        volver.setText("Ventana principal");
        volver.setFocusable(false);
        volver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverActionPerformed(evt);
            }
        });

        salir.setBackground(new java.awt.Color(180, 22, 45));
        salir.setForeground(new java.awt.Color(0, 0, 0));
        salir.setText("Salir");
        salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirActionPerformed(evt);
            }
        });

        botonBeneficios.setBackground(new java.awt.Color(255, 255, 255));
        botonBeneficios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/Beneficios.png"))); // NOI18N
        botonBeneficios.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        botonBeneficios.setFocusPainted(false);
        botonBeneficios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBeneficiosActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(50, 50, 50));
        jButton1.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jButton1.setForeground(new java.awt.Color(187, 187, 188));
        jButton1.setText("ÚLTIMAS NOTICIAS");
        jButton1.setEnabled(false);

        jLabel1.setForeground(new java.awt.Color(187, 187, 188));
        jLabel1.setText("_____________________________________");

        jLabel2.setForeground(new java.awt.Color(187, 187, 188));
        jLabel2.setText("____________________________________");

        gente.setBackground(new java.awt.Color(255, 255, 255));
        gente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/gente.png"))); // NOI18N
        gente.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        gente.setFocusPainted(false);
        gente.setFocusable(false);
        gente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                genteActionPerformed(evt);
            }
        });

        participaciones.setBackground(new java.awt.Color(255, 255, 255));
        participaciones.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/participaciones.png"))); // NOI18N
        participaciones.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        participaciones.setFocusPainted(false);
        participaciones.setFocusable(false);
        participaciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                participacionesActionPerformed(evt);
            }
        });

        jLabel3.setForeground(new java.awt.Color(187, 187, 188));
        jLabel3.setText("Beneficios");

        jLabel4.setForeground(new java.awt.Color(187, 187, 188));
        jLabel4.setText("Participaciones");

        jLabel5.setForeground(new java.awt.Color(187, 187, 188));
        jLabel5.setText("Altas ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(0, 32, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(162, 162, 162)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(jLabel5)
                        .addGap(210, 210, 210)
                        .addComponent(jLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(gente)
                        .addGap(141, 141, 141)
                        .addComponent(botonBeneficios, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(participaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel4)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(volver, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(salir, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(178, 178, 178)
                        .addComponent(gente))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(participaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botonBeneficios, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(volver)
                    .addComponent(salir))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirActionPerformed
        this.dispose();
    }//GEN-LAST:event_salirActionPerformed

    private void volverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverActionPerformed
        this.dispose();
        VAutentificacion va=  new VAutentificacion(fa);
        va.setLocation(185, 80);
        va.setVisible(true);
    }//GEN-LAST:event_volverActionPerformed

    private void botonBeneficiosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBeneficiosActionPerformed
        fa.nuevoNoticiero("ANUNCIOS DE BENEFICIOS");
    }//GEN-LAST:event_botonBeneficiosActionPerformed

    private void genteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_genteActionPerformed
        fa.nuevoNoticiero("ANUNCIOS DE ALTAS Y BAJAS");
    }//GEN-LAST:event_genteActionPerformed

    private void participacionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_participacionesActionPerformed
        fa.nuevoNoticiero("ANUNCIOS DE PARTICIPACIONES");
    }//GEN-LAST:event_participacionesActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonBeneficios;
    private javax.swing.JButton gente;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JButton participaciones;
    private javax.swing.JButton salir;
    private javax.swing.JButton volver;
    // End of variables declaration//GEN-END:variables
}


package gui;

import aplicacion.FachadaAplicacion;
import java.awt.Color;

public class VPortada extends javax.swing.JFrame {
    Color prueba = new Color(60, 63, 65);
    FachadaAplicacion fa;
   
    public VPortada(aplicacion.FachadaAplicacion fa) {
        this.fa=fa;
        initComponents();
        this.getContentPane().setBackground(prueba);

    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        botonEstadisticas = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        volver = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        botonEstadisticas.setBackground(new java.awt.Color(255, 255, 255));
        botonEstadisticas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/portada.png"))); // NOI18N
        botonEstadisticas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEstadisticasActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Ubuntu", 2, 15)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(187, 187, 188));
        jLabel1.setText("VERSION 1.0.0 updated on April 2021");

        volver.setBackground(new java.awt.Color(50, 50, 50));
        volver.setForeground(new java.awt.Color(187, 187, 188));
        volver.setText("Volver");
        volver.setFocusable(false);
        volver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(60, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(volver, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1))
                    .addComponent(botonEstadisticas, javax.swing.GroupLayout.PREFERRED_SIZE, 686, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(60, 60, 60))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(59, Short.MAX_VALUE)
                .addComponent(botonEstadisticas, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(volver))
                .addGap(35, 35, 35))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonEstadisticasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEstadisticasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonEstadisticasActionPerformed

    private void volverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverActionPerformed
        this.dispose();
        VAutentificacion va=  new VAutentificacion(fa);
        va.setLocation(185, 80);
        va.setVisible(true);
    }//GEN-LAST:event_volverActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonEstadisticas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton volver;
    // End of variables declaration//GEN-END:variables
}

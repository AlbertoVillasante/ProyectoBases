
package gui;

import aplicacion.AnunciarBeneficios;
import aplicacion.EmpresaUsuario;
import aplicacion.FachadaAplicacion;
import aplicacion.InversorUsuario;
import java.awt.Color;


public class VRegulador extends javax.swing.JFrame {

    Color prueba = new Color(60, 63, 65);
    Color prueba1 = new Color(78, 82, 85);

    FachadaAplicacion fa;
    InversorUsuario iu;
    EmpresaUsuario eu;
    VPagosHoy vph;

    
    public VRegulador(aplicacion.FachadaAplicacion fa, InversorUsuario iu, EmpresaUsuario eu) {
        this.fa = fa;
        if (iu != null) {
            this.iu = iu;
        }
        if (eu != null) {
            this.eu = eu;
        }
        initComponents();
        anunciarPagosHoy();
        this.getContentPane().setBackground(prueba);
        btnBajaBeneficios.setBackground(prueba1);
        btnCerrarSesion.setBackground(prueba1);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        botonBolsa = new javax.swing.JButton();
        botonSolicitudes = new javax.swing.JButton();
        botonConfiguracion = new javax.swing.JButton();
        modificarSaldosLabel = new javax.swing.JLabel();
        solicitudesPendientesLabel = new javax.swing.JLabel();
        configuracionLabel = new javax.swing.JLabel();
        btnSalir = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnCerrarSesion = new javax.swing.JButton();
        btnBajaBeneficios = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        botonBolsa.setBackground(new java.awt.Color(255, 255, 255));
        botonBolsa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/bolsaDinero.jpeg"))); // NOI18N
        botonBolsa.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        botonBolsa.setFocusable(false);
        botonBolsa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBolsaActionPerformed(evt);
            }
        });

        botonSolicitudes.setBackground(new java.awt.Color(255, 255, 255));
        botonSolicitudes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/checkearCandado.jpeg"))); // NOI18N
        botonSolicitudes.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        botonSolicitudes.setFocusable(false);
        botonSolicitudes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonSolicitudesActionPerformed(evt);
            }
        });

        botonConfiguracion.setBackground(new java.awt.Color(255, 255, 255));
        botonConfiguracion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/rueda(1).jpeg"))); // NOI18N
        botonConfiguracion.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        botonConfiguracion.setFocusable(false);
        botonConfiguracion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonConfiguracionActionPerformed(evt);
            }
        });

        modificarSaldosLabel.setForeground(new java.awt.Color(187, 187, 188));
        modificarSaldosLabel.setText("       Modificar saldos");

        solicitudesPendientesLabel.setForeground(new java.awt.Color(187, 187, 188));
        solicitudesPendientesLabel.setText("Solicitudes pendientes");

        configuracionLabel.setForeground(new java.awt.Color(187, 187, 188));
        configuracionLabel.setText("        Configuraci??n");

        btnSalir.setBackground(new java.awt.Color(180, 22, 45));
        btnSalir.setForeground(new java.awt.Color(0, 0, 0));
        btnSalir.setText("Salir");
        btnSalir.setFocusable(false);
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        jButton1.setForeground(new java.awt.Color(187, 187, 188));
        jButton1.setText("Men??");
        jButton1.setEnabled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setForeground(new java.awt.Color(187, 187, 188));
        jLabel1.setText("______________________________________________");

        jLabel2.setForeground(new java.awt.Color(187, 187, 188));
        jLabel2.setText("_____________________________________________");

        btnCerrarSesion.setBackground(new java.awt.Color(153, 153, 153));
        btnCerrarSesion.setForeground(new java.awt.Color(187, 187, 188));
        btnCerrarSesion.setText("Cerrar sesi??n");
        btnCerrarSesion.setFocusable(false);
        btnCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarSesionActionPerformed(evt);
            }
        });

        btnBajaBeneficios.setForeground(new java.awt.Color(187, 187, 188));
        btnBajaBeneficios.setText("Gestionar beneficios");
        btnBajaBeneficios.setFocusable(false);
        btnBajaBeneficios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBajaBeneficiosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(modificarSaldosLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(botonBolsa, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnCerrarSesion))
                        .addGap(74, 74, 74)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(botonSolicitudes, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(solicitudesPendientesLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(77, 77, 77)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(botonConfiguracion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(configuracionLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnBajaBeneficios, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnSalir))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)))
                .addGap(55, 55, 55))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(56, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jButton1)
                    .addComponent(jLabel2))
                .addGap(73, 73, 73)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(botonConfiguracion, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonSolicitudes, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonBolsa, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(modificarSaldosLabel)
                    .addComponent(solicitudesPendientesLabel)
                    .addComponent(configuracionLabel))
                .addGap(87, 87, 87)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalir)
                    .addComponent(btnCerrarSesion)
                    .addComponent(btnBajaBeneficios))
                .addGap(24, 24, 24))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonBolsaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBolsaActionPerformed
        fa.nuevaModificacion();
    }//GEN-LAST:event_botonBolsaActionPerformed

    private void botonSolicitudesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonSolicitudesActionPerformed
        fa.nuevaSolicitud();
    }//GEN-LAST:event_botonSolicitudesActionPerformed

    private void botonConfiguracionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonConfiguracionActionPerformed
        fa.configuracionRegulador(iu, eu);
    }//GEN-LAST:event_botonConfiguracionActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarSesionActionPerformed
        this.dispose();
        VAutentificacion va = new VAutentificacion(fa);
        va.setLocation(185, 80);
        va.setVisible(true);
    }//GEN-LAST:event_btnCerrarSesionActionPerformed

    private void btnBajaBeneficiosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBajaBeneficiosActionPerformed
        // TODO add your handling code here:
        fa.nuevoBajaBeneficio(iu, eu);
    }//GEN-LAST:event_btnBajaBeneficiosActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonBolsa;
    private javax.swing.JButton botonConfiguracion;
    private javax.swing.JButton botonSolicitudes;
    private javax.swing.JButton btnBajaBeneficios;
    private javax.swing.JButton btnCerrarSesion;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel configuracionLabel;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel modificarSaldosLabel;
    private javax.swing.JLabel solicitudesPendientesLabel;
    // End of variables declaration//GEN-END:variables
    void anunciarPagosHoy() {
        String b = "";
        if (!fa.getBeneficiosHoy().isEmpty()) {
            for (AnunciarBeneficios benef : fa.getBeneficiosHoy()) {
                b += benef.getNombreEmpresa() + ", ";
            }
            vph = new VPagosHoy(b);
            vph.setVisible(true);
            vph.setAlwaysOnTop(true);
        }
    }
}

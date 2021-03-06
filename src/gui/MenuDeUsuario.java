
package gui;

import aplicacion.AnunciarBeneficios;
import aplicacion.EmpresaUsuario;
import aplicacion.InversorUsuario;
import java.awt.Color;

public class MenuDeUsuario extends javax.swing.JFrame {

    InversorUsuario iu;
    EmpresaUsuario eu;
    aplicacion.FachadaAplicacion fa;
    VPagosHoy vph;
    Color prueba = new Color(60, 63, 65);
    Color prueba1 = new Color(78, 82, 85);

    public MenuDeUsuario(aplicacion.FachadaAplicacion fa, InversorUsuario iu, EmpresaUsuario eu) {
        this.fa = fa;
        if (iu != null) {
            this.iu = iu;
        }
        if (eu != null) {
            this.eu = eu;
        }
        anunciarPagosHoy();
        fa.pagarBeneficios();
        initComponents();
        this.getContentPane().setBackground(prueba);
        PRESTAMO.setBackground(prueba1);
        btnCerrarSesion.setBackground(prueba1);

    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        botonParticipaciones = new javax.swing.JButton();
        textoBeneficios = new javax.swing.JLabel();
        botonConfiguracion = new javax.swing.JButton();
        textoConfiguracion = new javax.swing.JLabel();
        botonBeneficios = new javax.swing.JButton();
        textoParticipaciones = new javax.swing.JLabel();
        botonEstadisticas = new javax.swing.JButton();
        textoEstadisticas = new javax.swing.JLabel();
        textoMenu = new javax.swing.JLabel();
        btnSalir = new javax.swing.JButton();
        btnCerrarSesion = new javax.swing.JButton();
        PRESTAMO = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        botonParticipaciones.setBackground(new java.awt.Color(255, 255, 255));
        botonParticipaciones.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/stonks.jpeg"))); // NOI18N
        botonParticipaciones.setFocusable(false);
        botonParticipaciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonParticipacionesActionPerformed(evt);
            }
        });

        textoBeneficios.setFont(new java.awt.Font("Ubuntu", 1, 16)); // NOI18N
        textoBeneficios.setForeground(new java.awt.Color(187, 187, 188));
        textoBeneficios.setText("Beneficios");

        botonConfiguracion.setBackground(new java.awt.Color(255, 255, 255));
        botonConfiguracion.setForeground(new java.awt.Color(255, 255, 255));
        botonConfiguracion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/rueda(1).jpeg"))); // NOI18N
        botonConfiguracion.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        botonConfiguracion.setFocusable(false);
        botonConfiguracion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonConfiguracionActionPerformed(evt);
            }
        });

        textoConfiguracion.setFont(new java.awt.Font("Ubuntu", 1, 16)); // NOI18N
        textoConfiguracion.setForeground(new java.awt.Color(187, 187, 188));
        textoConfiguracion.setText("Configuraci??n");

        botonBeneficios.setBackground(new java.awt.Color(255, 255, 255));
        botonBeneficios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/dolar.jpeg"))); // NOI18N
        botonBeneficios.setFocusable(false);
        botonBeneficios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBeneficiosActionPerformed(evt);
            }
        });

        textoParticipaciones.setFont(new java.awt.Font("Ubuntu", 1, 16)); // NOI18N
        textoParticipaciones.setForeground(new java.awt.Color(187, 187, 188));
        textoParticipaciones.setText("Participaciones");

        botonEstadisticas.setBackground(new java.awt.Color(255, 255, 255));
        botonEstadisticas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/Estadistica.jpeg"))); // NOI18N
        botonEstadisticas.setFocusable(false);
        botonEstadisticas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEstadisticasActionPerformed(evt);
            }
        });

        textoEstadisticas.setFont(new java.awt.Font("Ubuntu", 1, 16)); // NOI18N
        textoEstadisticas.setForeground(new java.awt.Color(187, 187, 188));
        textoEstadisticas.setText("Estad??sticas");

        textoMenu.setFont(new java.awt.Font("Ubuntu", 1, 36)); // NOI18N
        textoMenu.setForeground(new java.awt.Color(187, 187, 188));
        textoMenu.setText("Men??");

        btnSalir.setBackground(new java.awt.Color(180, 22, 45));
        btnSalir.setForeground(new java.awt.Color(0, 0, 0));
        btnSalir.setText("Salir");
        btnSalir.setFocusable(false);
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        btnCerrarSesion.setBackground(new java.awt.Color(153, 153, 153));
        btnCerrarSesion.setForeground(new java.awt.Color(187, 187, 188));
        btnCerrarSesion.setText("Cerrar sesi??n");
        btnCerrarSesion.setFocusable(false);
        btnCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarSesionActionPerformed(evt);
            }
        });

        PRESTAMO.setForeground(new java.awt.Color(187, 187, 188));
        PRESTAMO.setText("Prestamo");
        PRESTAMO.setFocusable(false);
        PRESTAMO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PRESTAMOActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(95, 95, 95)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(46, 46, 46)
                                .addComponent(textoBeneficios))
                            .addComponent(botonParticipaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(botonBeneficios, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(119, 119, 119)
                        .addComponent(textoParticipaciones)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 192, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(botonConfiguracion, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(botonEstadisticas, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(96, 96, 96))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(textoConfiguracion)
                        .addGap(130, 130, 130))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(textoEstadisticas)
                        .addGap(133, 133, 133))))
            .addGroup(layout.createSequentialGroup()
                .addGap(311, 311, 311)
                .addComponent(textoMenu)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(PRESTAMO)
                .addGap(26, 26, 26))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnCerrarSesion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSalir)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textoMenu)
                    .addComponent(PRESTAMO))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(botonBeneficios, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(textoBeneficios)
                        .addGap(26, 26, 26)
                        .addComponent(botonParticipaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(textoParticipaciones))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(botonEstadisticas, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(textoEstadisticas)
                        .addGap(30, 30, 30)
                        .addComponent(botonConfiguracion, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(textoConfiguracion)))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalir)
                    .addComponent(btnCerrarSesion))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonParticipacionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonParticipacionesActionPerformed
        fa.nuevasParticipaciones(eu, iu);
    }//GEN-LAST:event_botonParticipacionesActionPerformed

    private void botonConfiguracionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonConfiguracionActionPerformed
        fa.nuevoUsuario(false, iu, eu);
    }//GEN-LAST:event_botonConfiguracionActionPerformed

    private void botonBeneficiosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBeneficiosActionPerformed
        fa.nuevoBeneficio(iu, eu);
    }//GEN-LAST:event_botonBeneficiosActionPerformed

    private void botonEstadisticasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEstadisticasActionPerformed
        fa.nuevaEstadistica(iu, eu);
    }//GEN-LAST:event_botonEstadisticasActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarSesionActionPerformed
        this.dispose();
        VAutentificacion va=  new VAutentificacion(fa);
        va.setLocation(185, 80);
        va.setVisible(true);
    }//GEN-LAST:event_btnCerrarSesionActionPerformed

    private void PRESTAMOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PRESTAMOActionPerformed
        VPrestamo vp = new VPrestamo(fa, iu, eu);
        vp.setVisible(true);
    }//GEN-LAST:event_PRESTAMOActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton PRESTAMO;
    private javax.swing.JButton botonBeneficios;
    private javax.swing.JButton botonConfiguracion;
    private javax.swing.JButton botonEstadisticas;
    private javax.swing.JButton botonParticipaciones;
    private javax.swing.JButton btnCerrarSesion;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel textoBeneficios;
    private javax.swing.JLabel textoConfiguracion;
    private javax.swing.JLabel textoEstadisticas;
    private javax.swing.JLabel textoMenu;
    private javax.swing.JLabel textoParticipaciones;
    // End of variables declaration//GEN-END:variables
    
    void anunciarPagosHoy(){
        String b = "";
        if(!fa.getBeneficiosHoy().isEmpty()){
            for(AnunciarBeneficios benef : fa.getBeneficiosHoy()){
                b += benef.getNombreEmpresa() + ", ";
            }
            vph = new VPagosHoy(b);
            vph.setVisible(true);
            vph.setAlwaysOnTop(true);
        }
    }
}

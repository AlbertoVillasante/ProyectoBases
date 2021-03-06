package gui;

import aplicacion.EmpresaUsuario;
import aplicacion.InversorUsuario;
import java.awt.Color;

public class VAutentificacion extends javax.swing.JDialog {
    
    aplicacion.FachadaAplicacion fa;
    MenuDeUsuario mu;
    VRegulador vr;
    VAviso va;
    Color prueba = new Color(60, 63, 65);
    Color prueba1 = new Color(78, 82, 85);

    
    public VAutentificacion(aplicacion.FachadaAplicacion fa) {
        this.fa = fa;
        initComponents();
        etiquetaFallo.setVisible(false);
        this.getContentPane().setBackground(prueba);
        textoClave.setBackground(prueba1);
        inicio1.setBackground(prueba);
        inicio.setBackground(prueba);
        textoUsuario.setBackground(prueba1);
        this.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {
                System.exit(0);
            }
        });
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialog1 = new javax.swing.JDialog();
        jLabel1 = new javax.swing.JLabel();
        textoUsuario = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        btnAceptar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        etiquetaFallo = new javax.swing.JLabel();
        textoClave = new javax.swing.JPasswordField();
        btnRegistro = new javax.swing.JButton();
        Noticias = new javax.swing.JButton();
        inicio = new javax.swing.JButton();
        inicio1 = new javax.swing.JButton();

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Autentificaci??n de usuarios");
        setModal(true);
        setName("VAutentificacion"); // NOI18N
        setResizable(false);

        jLabel1.setForeground(new java.awt.Color(187, 187, 188));
        jLabel1.setText("Usuario:");

        textoUsuario.setForeground(new java.awt.Color(187, 187, 188));
        textoUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                textoUsuarioKeyPressed(evt);
            }
        });

        jLabel2.setForeground(new java.awt.Color(187, 187, 188));
        jLabel2.setText("Contrase??a:");

        btnAceptar.setBackground(new java.awt.Color(50, 50, 50));
        btnAceptar.setForeground(new java.awt.Color(187, 187, 188));
        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        btnCancelar.setBackground(new java.awt.Color(50, 50, 50));
        btnCancelar.setForeground(new java.awt.Color(187, 187, 188));
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        etiquetaFallo.setForeground(new java.awt.Color(255, 51, 51));
        etiquetaFallo.setText("Autentificaci??n incorrecta!");

        textoClave.setForeground(new java.awt.Color(187, 187, 188));
        textoClave.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                textoClaveKeyPressed(evt);
            }
        });

        btnRegistro.setBackground(new java.awt.Color(50, 50, 50));
        btnRegistro.setForeground(new java.awt.Color(187, 187, 188));
        btnRegistro.setText("Registrarse");
        btnRegistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistroActionPerformed(evt);
            }
        });

        Noticias.setBackground(new java.awt.Color(50, 50, 50));
        Noticias.setForeground(new java.awt.Color(187, 187, 188));
        Noticias.setText("??ltimas noticias de nuestro ecosistema");
        Noticias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NoticiasActionPerformed(evt);
            }
        });

        inicio.setBackground(new java.awt.Color(255, 255, 255));
        inicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/logo.png"))); // NOI18N
        inicio.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        inicio.setFocusPainted(false);
        inicio.setFocusable(false);
        inicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inicioActionPerformed(evt);
            }
        });

        inicio1.setBackground(new java.awt.Color(255, 255, 255));
        inicio1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/info.png"))); // NOI18N
        inicio1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        inicio1.setFocusPainted(false);
        inicio1.setFocusable(false);
        inicio1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inicio1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(etiquetaFallo)
                        .addGap(50, 50, 50))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(btnRegistro)
                                    .addGap(18, 18, 18)
                                    .addComponent(btnAceptar)
                                    .addGap(18, 18, 18)
                                    .addComponent(btnCancelar))
                                .addComponent(Noticias, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel1)
                                            .addGap(29, 29, 29)))
                                    .addComponent(inicio1))
                                .addGap(19, 19, 19)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(textoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(textoClave, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(inicio))))
                        .addGap(0, 36, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(inicio))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(inicio1)))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textoClave, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addComponent(etiquetaFallo)
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegistro)
                    .addComponent(btnAceptar)
                    .addComponent(btnCancelar))
                .addGap(18, 18, 18)
                .addComponent(Noticias)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        etiquetaFallo.setVisible(false);
        if (textoUsuario.getText().length() == 9) {
            InversorUsuario u;
            if (!(u = fa.comprobarAutentificacionI(textoUsuario.getText(), textoClave.getText())).getIdUsuario().equals("")) {
                this.dispose();
                if (u.getTipoUsuario().name().equals("Normal") || u.getTipoUsuario().name().equals("PendBaja")) {
                    mu = new MenuDeUsuario(fa, u, null);
                    mu.setLocation(0, 0);
                    mu.setVisible(true);
                } else if (u.getTipoUsuario().name().equals("Regulador")) {
                    vr = new VRegulador(fa, u, null);
                    vr.setLocation(0, 0);
                    vr.setVisible(true);
                } else if (u.getTipoUsuario().name().equals("PendAlta")) {
                    va  = new VAviso("El usuario introducido todav??a no ha sido validado por el regulador\n");
                    va.setVisible(true);
                }
            } else {
                etiquetaFallo.setVisible(true);
            }
        } else {
            EmpresaUsuario u;
            if (!(u = fa.comprobarAutentificacionE(textoUsuario.getText(), textoClave.getText())).getIdUsuario().equals("")) {
                this.dispose();
                if (u.getTipoUsuario().name().equals("Normal") || u.getTipoUsuario().name().equals("PendBaja")) {
                    mu = new MenuDeUsuario(fa, null, u);
                    mu.setLocation(0, 0);
                    mu.setVisible(true);
                } else if (u.getTipoUsuario().name().equals("Regulador")) {
                    vr = new VRegulador(fa, null, u);
                    vr.setLocation(0, 0);
                    vr.setVisible(true);
                } else if (u.getTipoUsuario().name().equals("PendAlta")) {
                    va  = new VAviso("El usuario introducido todav??a no ha sido validado por el regulador\n");
                    va.setVisible(true);
                }
            } else {
                etiquetaFallo.setVisible(true);
            }
        }
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void textoClaveKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textoClaveKeyPressed
        if (evt.getKeyChar() == '\n') {           
            etiquetaFallo.setVisible(false);
            if (textoUsuario.getText().length() == 9) {
                InversorUsuario u;
                if (!(u = fa.comprobarAutentificacionI(textoUsuario.getText(), textoClave.getText())).getIdUsuario().equals("")) {
                    this.dispose();
                    if (u.getTipoUsuario().name().equals("Normal") || u.getTipoUsuario().name().equals("PendBaja")) {
                        mu = new MenuDeUsuario(fa, u, null);
                        mu.setLocation(0, 0);
                        mu.setVisible(true);
                    } else if (u.getTipoUsuario().name().equals("Regulador")) {
                        vr = new VRegulador(fa, u, null);
                        vr.setLocation(0, 0);
                        vr.setVisible(true);
                    } else if (u.getTipoUsuario().name().equals("PendAlta")) {
                        va  = new VAviso("El usuario introducido todav??a no ha sido validado por el regulador\n");
                        va.setVisible(true);
                    }
                } else {
                    etiquetaFallo.setVisible(true);
                }
            } else {
                EmpresaUsuario u;
                if (!(u = fa.comprobarAutentificacionE(textoUsuario.getText(), textoClave.getText())).getIdUsuario().equals("")) {
                    this.dispose();
                    if (u.getTipoUsuario().name().equals("Normal") || u.getTipoUsuario().name().equals("PendBaja")) {
                        mu = new MenuDeUsuario(fa, null, u);
                        mu.setLocation(0, 0);
                        mu.setVisible(true);
                    } else if (u.getTipoUsuario().name().equals("Regulador")) {
                        vr = new VRegulador(fa, null, u);
                        vr.setLocation(0, 0);
                        vr.setVisible(true);
                    } else if (u.getTipoUsuario().name().equals("PendAlta")) {
                        va  = new VAviso("El usuario introducido todav??a no ha sido validado por el regulador\n");
                        va.setVisible(true);
                    }
                } else {
                    etiquetaFallo.setVisible(true);
                }
            }
        }
    }//GEN-LAST:event_textoClaveKeyPressed

    private void textoUsuarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textoUsuarioKeyPressed
        if (evt.getKeyChar() == '\n') {           

            if (textoUsuario.getText().length() == 9) {
                InversorUsuario u;
                if (!(u = fa.comprobarAutentificacionI(textoUsuario.getText(), textoClave.getText())).getIdUsuario().equals("")) {
                    this.dispose();
                    if (u.getTipoUsuario().name().equals("Normal") || u.getTipoUsuario().name().equals("PendBaja")) {
                        mu = new MenuDeUsuario(fa, u, null);
                        mu.setLocation(0, 0);
                        mu.setVisible(true);
                    } else if (u.getTipoUsuario().name().equals("Regulador")) {
                        vr = new VRegulador(fa, u, null);
                        vr.setLocation(0, 0);
                        vr.setVisible(true);
                    } else if (u.getTipoUsuario().name().equals("PendAlta")) {
                        va  = new VAviso("El usuario introducido todav??a no ha sido validado por el regulador\n");
                        va.setVisible(true);
                    }
                } else {
                    etiquetaFallo.setVisible(true);
                }
            } else {
                EmpresaUsuario u;
                if (!(u = fa.comprobarAutentificacionE(textoUsuario.getText(), textoClave.getText())).getIdUsuario().equals("")) {
                    this.dispose();
                    if (u.getTipoUsuario().name().equals("Normal") || u.getTipoUsuario().name().equals("PendBaja")) {
                        mu = new MenuDeUsuario(fa, null, u);
                        mu.setLocation(0, 0);
                        mu.setVisible(true);
                    } else if (u.getTipoUsuario().name().equals("Regulador")) {
                        vr = new VRegulador(fa, null, u);
                        vr.setLocation(0, 0);
                        vr.setVisible(true);
                    } else if (u.getTipoUsuario().name().equals("PendAlta")) {
                        va  = new VAviso("El usuario introducido todav??a no ha sido validado por el regulador\n");
                        va.setVisible(true);
                    }
                } else {
                    etiquetaFallo.setVisible(true);
                }
            }
        }
    }//GEN-LAST:event_textoUsuarioKeyPressed

    private void btnRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistroActionPerformed
        this.dispose();
        fa.nuevoUsuario(true, null, null);
    }//GEN-LAST:event_btnRegistroActionPerformed

    private void NoticiasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NoticiasActionPerformed
        fa.nuevaNoticia();
        this.dispose();
    }//GEN-LAST:event_NoticiasActionPerformed

    private void inicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inicioActionPerformed

    }//GEN-LAST:event_inicioActionPerformed

    private void inicio1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inicio1ActionPerformed
        VPortada vp = new VPortada(fa);
        vp.setLocation(0, 0);
        vp.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_inicio1ActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Noticias;
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnRegistro;
    private javax.swing.JLabel etiquetaFallo;
    private javax.swing.JButton inicio;
    private javax.swing.JButton inicio1;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPasswordField textoClave;
    private javax.swing.JTextField textoUsuario;
    // End of variables declaration//GEN-END:variables

}

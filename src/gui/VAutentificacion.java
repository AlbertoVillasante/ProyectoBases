package gui;

import java.awt.Color;

public class VAutentificacion extends javax.swing.JDialog {

    aplicacion.FachadaAplicacion fa;
    VPortada vp;
    MenuDeUsuario mu;
    VRegulador vr;
    Color prueba = new Color(60, 63, 65);
    Color prueba1 = new Color(78, 82, 85);

    /**
     * Creates new form VAutentificacion
     */
    
    public VAutentificacion(aplicacion.FachadaAplicacion fa, VPortada vp) {
        this.fa = fa;
        this.vp = vp;
        initComponents();
        etiquetaFallo.setVisible(false);
        this.getContentPane().setBackground(prueba);
        textoClave.setBackground(prueba1);
        textoUsuario.setBackground(prueba1);
        this.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {
                System.exit(0);
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
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
        setTitle("Autentificación de usuarios");
        setLocationByPlatform(true);
        setModal(true);
        setName("VAutentificacion"); // NOI18N
        setResizable(false);

        jLabel1.setForeground(new java.awt.Color(187, 187, 188));
        jLabel1.setText("Usuario:");

        textoUsuario.setForeground(new java.awt.Color(187, 187, 188));
        textoUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textoUsuarioActionPerformed(evt);
            }
        });
        textoUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                textoUsuarioKeyPressed(evt);
            }
        });

        jLabel2.setForeground(new java.awt.Color(187, 187, 188));
        jLabel2.setText("Contraseña:");

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
        etiquetaFallo.setText("Autentificación incorrecta!");

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addGap(29, 29, 29))
                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGap(19, 19, 19)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(textoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textoClave, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btnRegistro)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnAceptar)
                                .addGap(18, 18, 18)
                                .addComponent(btnCancelar)))
                        .addGap(0, 27, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(etiquetaFallo)
                        .addGap(50, 50, 50))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
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
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void textoUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textoUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textoUsuarioActionPerformed

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        etiquetaFallo.setVisible(false);
        String tipo;
        if (!(tipo = fa.comprobarAutentificacion(textoUsuario.getText(), textoClave.getText())).equals("")) {
            this.dispose();
            vp.dispose();
            vp.setVisible(false);
            if (tipo.equals("Normal")) {
                mu = new MenuDeUsuario(fa);
                mu.setVisible(true);
            } else if (tipo.equals("Regulador")) {
                vr = new VRegulador(fa);
                vr.setVisible(true);
            }
        } else
            etiquetaFallo.setVisible(true);
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void textoClaveKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textoClaveKeyPressed
        if (evt.getKeyChar() == '\n') {           //Comentado para que no de error
            etiquetaFallo.setVisible(false);
            String tipo;

            if (!(tipo = fa.comprobarAutentificacion(textoUsuario.getText(), textoClave.getText())).equals("")) {
                this.dispose();
                vp.dispose();
                vp.setVisible(false);
                if (tipo.equals("Normal")) {
                    mu = new MenuDeUsuario(fa);
                    mu.setVisible(true);
                } else if (tipo.equals("Regulador")) {
                    vr = new VRegulador(fa);
                    vr.setVisible(true);
                }
            } else {
                etiquetaFallo.setVisible(true);
            }
        }
    }//GEN-LAST:event_textoClaveKeyPressed

    private void textoUsuarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textoUsuarioKeyPressed
        if (evt.getKeyChar() == '\n') {
            String tipo;
            etiquetaFallo.setVisible(false);
            if (!(tipo = fa.comprobarAutentificacion(textoUsuario.getText(), textoClave.getText())).equals("")) {
                this.dispose();
                vp.dispose();
                vp.setVisible(false);
                if (tipo.equals("Normal")) {
                    mu = new MenuDeUsuario(fa);
                    mu.setVisible(true);
                } else if (tipo.equals("Regulador")) {
                    vr = new VRegulador(fa);
                    vr.setVisible(true);
                }
            } else {
                etiquetaFallo.setVisible(true);
            }
        }
    }//GEN-LAST:event_textoUsuarioKeyPressed

    private void btnRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistroActionPerformed
        this.dispose();
        fa.nuevoRegistro();
        vp.dispose();
        vp.setVisible(false);
    }//GEN-LAST:event_btnRegistroActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnRegistro;
    private javax.swing.JLabel etiquetaFallo;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPasswordField textoClave;
    private javax.swing.JTextField textoUsuario;
    // End of variables declaration//GEN-END:variables

}

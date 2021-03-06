
package gui;

import aplicacion.EmpresaUsuario;
import aplicacion.FachadaAplicacion;
import aplicacion.InversorUsuario;
import java.awt.Color;
import java.text.DecimalFormat;


public class VConfiguracionRegulador extends javax.swing.JDialog {

    FachadaAplicacion fa;
    double saldo;
    Color prueba = new Color(60, 63, 65);
    Color prueba1 = new Color(78, 82, 85);
    InversorUsuario iu;
    EmpresaUsuario eu;

    public VConfiguracionRegulador(FachadaAplicacion fa, InversorUsuario iu, EmpresaUsuario eu) {
        this.fa = fa;
        initComponents();
        this.getContentPane().setBackground(prueba);
        claveText.setBackground(prueba1);
        direcciontext.setBackground(prueba1);
        tlfnText.setBackground(prueba1);
        fondosText.setBackground(prueba1);
        comisionText.setBackground(prueba1);
        botonAceptar.setBackground(prueba1);
        fondosText.setEditable(false);

        if (iu != null) {
            this.iu = iu;
            claveText.setText(iu.getClave());
            direcciontext.setText(iu.getDireccion());
            tlfnText.setText(iu.getTelefono());
            DecimalFormat df = new DecimalFormat("#.00");
            String fondos = String.valueOf(df.format(iu.getFondosDisponiblesCuenta()));
            fondosText.setText(fondos);
            comisionText.setText(String.valueOf(iu.getComision()));

        }
        if (eu != null) {
            this.eu = eu;
            claveText.setText(eu.getClave());
            direcciontext.setText(eu.getDireccion());
            tlfnText.setText(eu.getTelefono());
            DecimalFormat df = new DecimalFormat("#.00");
            String fondos = String.valueOf(df.format(eu.getFondosDisponiblesCuenta()));
            fondosText.setText(fondos);
            comisionText.setText(String.valueOf(eu.getComision()));
        }
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lineaLabel = new javax.swing.JLabel();
        micuentaLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        obligatorio3 = new javax.swing.JLabel();
        obligatorio2 = new javax.swing.JLabel();
        obligatorio4 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        claveText = new javax.swing.JTextField();
        comisionText = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        obligatorio5 = new javax.swing.JLabel();
        comisionLabel = new javax.swing.JLabel();
        tlfnText = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        fondosLabel = new javax.swing.JLabel();
        obligatorio6 = new javax.swing.JLabel();
        fondosText = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();
        botonAceptar = new javax.swing.JButton();
        direcciontext = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lineaLabel.setForeground(new java.awt.Color(187, 187, 188));
        lineaLabel.setText("_____________________________________________________________________");

        micuentaLabel.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        micuentaLabel.setForeground(new java.awt.Color(187, 187, 188));
        micuentaLabel.setText("MI CUENTA");

        jLabel1.setForeground(new java.awt.Color(255, 51, 51));
        jLabel1.setText("Rellena los campos obligatorios *");

        obligatorio3.setForeground(new java.awt.Color(255, 0, 0));
        obligatorio3.setText("*");

        obligatorio2.setForeground(new java.awt.Color(255, 0, 0));
        obligatorio2.setText("*");

        obligatorio4.setForeground(new java.awt.Color(255, 0, 0));
        obligatorio4.setText("*");

        jLabel4.setForeground(new java.awt.Color(187, 187, 188));
        jLabel4.setText("Clave:");

        claveText.setForeground(new java.awt.Color(187, 187, 188));
        claveText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                claveTextActionPerformed(evt);
            }
        });

        comisionText.setForeground(new java.awt.Color(187, 187, 188));
        comisionText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comisionTextActionPerformed(evt);
            }
        });

        jLabel5.setForeground(new java.awt.Color(187, 187, 188));
        jLabel5.setText("Direcci??n:");

        jLabel6.setForeground(new java.awt.Color(187, 187, 188));
        jLabel6.setText("Tel??fono:");

        obligatorio5.setForeground(new java.awt.Color(255, 0, 0));
        obligatorio5.setText("*");

        comisionLabel.setForeground(new java.awt.Color(187, 187, 188));
        comisionLabel.setText("Comisi??n:");

        tlfnText.setForeground(new java.awt.Color(187, 187, 188));
        tlfnText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tlfnTextActionPerformed(evt);
            }
        });

        jLabel3.setForeground(new java.awt.Color(187, 187, 188));
        jLabel3.setText("%");

        fondosLabel.setForeground(new java.awt.Color(187, 187, 188));
        fondosLabel.setText("Fondos:");

        obligatorio6.setForeground(new java.awt.Color(255, 0, 0));
        obligatorio6.setText("*");

        fondosText.setForeground(new java.awt.Color(187, 187, 188));
        fondosText.setFocusable(false);
        fondosText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fondosTextActionPerformed(evt);
            }
        });

        jLabel2.setForeground(new java.awt.Color(187, 187, 188));
        jLabel2.setText("??? ");

        btnCancelar.setBackground(new java.awt.Color(180, 22, 45));
        btnCancelar.setForeground(new java.awt.Color(0, 0, 0));
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        botonAceptar.setForeground(new java.awt.Color(187, 187, 188));
        botonAceptar.setText("Aceptar");
        botonAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAceptarActionPerformed(evt);
            }
        });

        direcciontext.setForeground(new java.awt.Color(187, 187, 188));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(138, 138, 138))
                    .addComponent(botonAceptar, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addComponent(btnCancelar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(lineaLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 497, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(237, 237, 237)
                        .addComponent(micuentaLabel))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(76, 76, 76)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(obligatorio4)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel6))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(obligatorio3)
                                        .addGap(20, 20, 20)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel5)))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(74, 74, 74)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(obligatorio5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(obligatorio6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(fondosLabel)
                                    .addComponent(comisionLabel))))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(fondosText, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(comisionText, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(tlfnText, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(claveText, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
                                    .addComponent(direcciontext))))))
                .addContainerGap(20, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(75, 75, 75)
                    .addComponent(obligatorio2)
                    .addContainerGap(477, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(micuentaLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lineaLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(claveText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(obligatorio3, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(direcciontext, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(obligatorio4, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tlfnText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnCancelar)
                        .addComponent(botonAceptar)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(obligatorio5, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comisionText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(comisionLabel))
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(obligatorio6, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fondosLabel)
                            .addComponent(fondosText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(53, 53, 53)))
                .addGap(23, 23, 23))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(76, 76, 76)
                    .addComponent(obligatorio2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(249, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void claveTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_claveTextActionPerformed

    }//GEN-LAST:event_claveTextActionPerformed

    private void comisionTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comisionTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comisionTextActionPerformed

    private void tlfnTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tlfnTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tlfnTextActionPerformed

    private void fondosTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fondosTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fondosTextActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void botonAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAceptarActionPerformed
        float comision = Float.parseFloat(comisionText.getText());
        fa.actualizarComision(comision);
        if (iu != null) {
            iu.setComision(comision);
            iu.setClave(claveText.getText());
            iu.setDireccion(direcciontext.getText());
            iu.setTelefono(tlfnText.getText());
            fa.modificarRegulador(iu);
        }
        if (eu != null) {
            eu.setComision(comision);
        }
        this.dispose();
    }//GEN-LAST:event_botonAceptarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonAceptar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JTextField claveText;
    private javax.swing.JLabel comisionLabel;
    private javax.swing.JTextField comisionText;
    private javax.swing.JTextField direcciontext;
    private javax.swing.JLabel fondosLabel;
    private javax.swing.JTextField fondosText;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel lineaLabel;
    private javax.swing.JLabel micuentaLabel;
    private javax.swing.JLabel obligatorio2;
    private javax.swing.JLabel obligatorio3;
    private javax.swing.JLabel obligatorio4;
    private javax.swing.JLabel obligatorio5;
    private javax.swing.JLabel obligatorio6;
    private javax.swing.JTextField tlfnText;
    // End of variables declaration//GEN-END:variables
}

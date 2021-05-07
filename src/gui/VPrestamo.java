package gui;

import aplicacion.EmpresaUsuario;
import aplicacion.FachadaAplicacion;
import aplicacion.InversorUsuario;
import java.awt.Color;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Locale;

public class VPrestamo extends javax.swing.JDialog {

    FachadaAplicacion fa;
    InversorUsuario iu;
    EmpresaUsuario eu;

    Color prueba = new Color(60, 63, 65);
    Color prueba1 = new Color(78, 82, 85);

    public VPrestamo(FachadaAplicacion fa, InversorUsuario iu, EmpresaUsuario eu) {
        initComponents();
        this.iu = iu;
        this.eu = eu;
        this.fa = fa;
        this.getContentPane().setBackground(prueba);
        saldoText.setBackground(prueba1);
        saldoText.setEditable(false);
        participaciones.setBackground(prueba1);
        btnAceptar.setBackground(prueba1);
        interes.setBackground(prueba1);
        btnEmpresas.setBackground(prueba1);

        ArrayList<String> empresas = fa.getEmpresas(); //cogemos todas las empresas
        for (String e : empresas) {
            btnEmpresas.addItem(e);
        }
        if (iu != null) {
            saldoText.setText(String.valueOf(convertir(iu.getFondosDisponiblesCuenta())));
            interes.setText(String.valueOf(iu.getComision()));
        } else {
            saldoText.setText(String.valueOf(convertir(eu.getFondosDisponiblesCuenta())));
            interes.setText(String.valueOf(eu.getComision()));
        }
        actualizarTabla();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        saldoText = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        participaciones = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        btnAceptar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        interes = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        btnEmpresas = new javax.swing.JComboBox();
        btnSalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jTable1.setModel(new ModeloTablaEmpresas());
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 28)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(187, 187, 188));
        jLabel1.setText("Venta Empresa");

        jLabel2.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(187, 187, 188));
        jLabel2.setText("Saldo Disponible:");

        saldoText.setEditable(false);
        saldoText.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        saldoText.setForeground(new java.awt.Color(187, 187, 188));
        saldoText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saldoTextActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(187, 187, 188));
        jLabel3.setText("Participaciones a vender");

        participaciones.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        participaciones.setForeground(new java.awt.Color(187, 187, 188));
        participaciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                participacionesActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(187, 187, 188));
        jLabel4.setText("€ ");

        btnAceptar.setForeground(new java.awt.Color(187, 187, 188));
        btnAceptar.setText("Aceptar");
        btnAceptar.setFocusable(false);
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Ubuntu", 1, 28)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(187, 187, 188));
        jLabel6.setText("_________________________________");

        jLabel7.setFont(new java.awt.Font("Ubuntu", 1, 28)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(187, 187, 188));
        jLabel7.setText("______________");

        interes.setEditable(false);
        interes.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        interes.setForeground(new java.awt.Color(187, 187, 188));
        interes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                interesActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(187, 187, 188));
        jLabel8.setText("%");

        jLabel9.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(187, 187, 188));
        jLabel9.setText("Interés");

        btnEmpresas.setForeground(new java.awt.Color(187, 187, 188));
        btnEmpresas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEmpresasMouseClicked(evt);
            }
        });
        btnEmpresas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEmpresasActionPerformed(evt);
            }
        });

        btnSalir.setBackground(new java.awt.Color(180, 22, 45));
        btnSalir.setForeground(new java.awt.Color(0, 0, 0));
        btnSalir.setLabel("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(70, 70, 70)
                        .addComponent(jLabel1)
                        .addGap(70, 70, 70)
                        .addComponent(jLabel6))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(30, 30, 30)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(participaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(saldoText, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGap(18, 18, 18)
                                .addComponent(interes, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel8)
                                .addGap(18, 18, 18)
                                .addComponent(btnEmpresas, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(65, 65, 65)
                        .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(80, 80, 80))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel1)
                    .addComponent(jLabel7))
                .addGap(63, 63, 63)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(saldoText, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(42, 42, 42)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(participaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(interes, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9)
                            .addComponent(btnEmpresas, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnAceptar, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                    .addComponent(btnSalir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(47, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void saldoTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saldoTextActionPerformed

    }//GEN-LAST:event_saldoTextActionPerformed

    private void participacionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_participacionesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_participacionesActionPerformed

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        this.venderParticipacionesAEmpresa();
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void interesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_interesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_interesActionPerformed

    private void btnEmpresasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEmpresasMouseClicked

        // TODO add your handling code here:
    }//GEN-LAST:event_btnEmpresasMouseClicked

    private void btnEmpresasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEmpresasActionPerformed


    }//GEN-LAST:event_btnEmpresasActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JComboBox btnEmpresas;
    private javax.swing.JButton btnSalir;
    private javax.swing.JTextField interes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField participaciones;
    private javax.swing.JTextField saldoText;
    // End of variables declaration//GEN-END:variables

    private void actualizarTabla() {
        ModeloTablaEmpresas m;
        m = (ModeloTablaEmpresas) jTable1.getModel();
        m.setFilas(fa.getPrestamo());
    }

    public static String convertir(double val) {
        Locale.setDefault(Locale.US);
        DecimalFormat num = new DecimalFormat("#,###.00");
        return num.format(val);
    }

    public void venderParticipacionesAEmpresa() {
        boolean correcto = true;
        double dinero = 0;
        try {
            if (iu != null) {
                if ((fa.numParticipacionesInvEmpr(iu.getIdUsuario(), fa.getIdEmpresa(btnEmpresas.getSelectedItem().toString()))
                        - fa.numParticipacionesALaVenta(iu.getIdUsuario(), fa.getIdEmpresa(btnEmpresas.getSelectedItem().toString())))
                        < Integer.valueOf(participaciones.getText()) || Integer.valueOf(participaciones.getText()) < 0) {

                    VAviso va  = new VAviso("No dispone de esas participaciones");
                    va.setVisible(true);
                    correcto = false;
                } else {
                    dinero = fa.ventaParticipacionesAEmpresaI(iu, fa.getIdEmpresa(btnEmpresas.getSelectedItem().toString()), Integer.valueOf(participaciones.getText()));
                    iu.setFondosDisponiblesCuenta(iu.getFondosDisponiblesCuenta() + dinero);
                    saldoText.setText(String.valueOf(convertir(iu.getFondosDisponiblesCuenta())));
                }

            } else {
                if ((fa.numParticipacionesEmprEmpr(eu.getIdUsuario(), fa.getIdEmpresa(btnEmpresas.getSelectedItem().toString()))
                        - fa.numParticipacionesALaVenta(eu.getIdUsuario(), fa.getIdEmpresa(btnEmpresas.getSelectedItem().toString())))
                        < Integer.valueOf(participaciones.getText()) || Integer.valueOf(participaciones.getText()) < 0) {

                    VAviso va  = new VAviso("No dispone de esas participaciones");
                    va.setVisible(true);
                    correcto = false;
                } else {
                    dinero = fa.ventaParticipacionesAEmpresaE(eu, fa.getIdEmpresa(btnEmpresas.getSelectedItem().toString()), Integer.valueOf(participaciones.getText()));
                    eu.setFondosDisponiblesCuenta(eu.getFondosDisponiblesCuenta() + dinero);
                    saldoText.setText(String.valueOf(convertir(eu.getFondosDisponiblesCuenta())));
                }
            }
        } catch (java.lang.NumberFormatException e) {
            VAviso entero = new VAviso("El número ha de ser un entero");
            entero.setVisible(true);
            correcto = false;
        }
        if (correcto) {
            VAvisoCorrecto vcorrecto = new VAvisoCorrecto("Has conseguido " + dinero + " € al vender \n"
                    + Integer.valueOf(participaciones.getText()) + " participaciones a la empresa " + btnEmpresas.getSelectedItem().toString());
            vcorrecto.setVisible(true);
        }

    }
}

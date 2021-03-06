package gui;

import aplicacion.EmpresaUsuario;
import aplicacion.FachadaAplicacion;
import aplicacion.InversorUsuario;
import java.awt.Color;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;

public class VBeneficios extends javax.swing.JDialog {

    Color prueba = new Color(60, 63, 65);
    Color prueba1 = new Color(78, 82, 85);
    FachadaAplicacion fa;
    VEstadistica ve;
    InversorUsuario iu;
    EmpresaUsuario eu;

    public VBeneficios(aplicacion.FachadaAplicacion fa, InversorUsuario iu, EmpresaUsuario eu) {
        initComponents();
        this.fa = fa;
        if (iu != null) {
            this.iu = iu;
            cuadroFechaPago.setEnabled(false);
            numPart.setEnabled(false);
            cuadroBeneficio.setEnabled(false);
            btnPagar.setEnabled(false);
            btnAceptar.setEnabled(false);
        }
        if (eu != null) {
            this.eu = eu;
        }

        this.getContentPane().setBackground(prueba);
        actualizarTablaBeneficios();
        btnSelector.setBackground(prueba1);
        btnBuscar.setBackground(prueba1);
        btnPagar.setBackground(prueba1);
        btnAceptar.setBackground(prueba);
        cuadroFechaPago.setBackground(prueba1);
        numPart.setBackground(prueba1);
        cuadroBeneficio.setBackground(prueba1);
        tablaBeneficios.setBackground(prueba1);
        numPart.setBackground(prueba1);
        tablaBeneficios.setSelectionBackground(prueba1);
        ArrayList<String> empresas = fa.getEmpresas();
        for (String i : empresas) {
            btnSelector.addItem(i);
        }
        error.setVisible(false);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnSelector = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        btnAceptar = new javax.swing.JButton();
        btnPagar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cuadroBeneficio = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        numPart = new javax.swing.JSpinner();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaBeneficios = new javax.swing.JTable();
        cuadroFechaPago = new com.toedter.calendar.JDateChooser();
        textoEstad??sticas = new javax.swing.JLabel();
        estadisticas = new javax.swing.JButton();
        error = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        btnSelector.setForeground(new java.awt.Color(187, 187, 188));
        btnSelector.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelectorActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(180, 22, 45));
        jButton1.setForeground(new java.awt.Color(0, 0, 0));
        jButton1.setText("Cancelar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btnAceptar.setForeground(new java.awt.Color(187, 187, 188));
        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        btnPagar.setForeground(new java.awt.Color(255, 51, 51));
        btnPagar.setText("Pagar ahora");
        btnPagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPagarActionPerformed(evt);
            }
        });

        jLabel1.setForeground(new java.awt.Color(187, 187, 188));
        jLabel1.setText("Fecha pago:");

        jLabel2.setForeground(new java.awt.Color(187, 187, 188));
        jLabel2.setText("Beneficio/Participaci??n:");

        cuadroBeneficio.setForeground(new java.awt.Color(187, 187, 188));

        btnBuscar.setForeground(new java.awt.Color(187, 187, 188));
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        numPart.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        jLabel3.setForeground(new java.awt.Color(187, 187, 188));
        jLabel3.setText("N??mero de Participaciones:");

        tablaBeneficios.setForeground(new java.awt.Color(187, 187, 188));
        tablaBeneficios.setModel(new ModeloTablaBeneficios());
        jScrollPane1.setViewportView(tablaBeneficios);

        cuadroFechaPago.setMinSelectableDate(Date.valueOf(LocalDate.now()));

        textoEstad??sticas.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        textoEstad??sticas.setForeground(new java.awt.Color(187, 187, 188));

        estadisticas.setBackground(new java.awt.Color(50, 50, 50));
        estadisticas.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        estadisticas.setForeground(new java.awt.Color(187, 187, 188));
        estadisticas.setText("Ver mis estad??sticas");
        estadisticas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                estadisticasActionPerformed(evt);
            }
        });

        error.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        error.setForeground(new java.awt.Color(187, 50, 50));
        error.setText("Datos inconsistentes");
        error.setFocusable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(btnPagar)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(btnSelector, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(63, 63, 63)
                                .addComponent(error)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(118, 118, 118)
                        .addComponent(estadisticas)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textoEstad??sticas))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(113, 113, 113)
                                .addComponent(jButton1)))
                        .addGap(90, 90, 90))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(numPart, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addGap(97, 97, 97))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cuadroBeneficio, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                                    .addComponent(cuadroFechaPago, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(36, 36, 36)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(70, 70, 70))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(cuadroFechaPago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(cuadroBeneficio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(numPart, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addComponent(btnSelector, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnPagar)
                            .addComponent(btnBuscar)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAceptar)
                    .addComponent(jButton1)
                    .addComponent(textoEstad??sticas)
                    .addComponent(estadisticas)
                    .addComponent(error))
                .addGap(40, 40, 40))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        //comprobaciones

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        if (cuadroFechaPago.getDate() == null) {
            error.setVisible(true);
        } else {
            String date = sdf.format(cuadroFechaPago.getDate());

            if (!btnSelector.getSelectedItem().toString().equals(eu.getNombreComercial())) {
                VAviso va;
                va = new VAviso("Esa empresa no es de su propiedad.\nAcci??n no disponible");
                va.setVisible(true);
            } else {
                if (fa.comprobarFecha(fa.getIdEmpresa(btnSelector.getSelectedItem().toString()), date)) {
                    VAviso falloFecha;
                    falloFecha = new VAviso("Hoy ya no puedes anunciar beneficios.\nAcci??n no disponible");
                    falloFecha.setVisible(true);
                } else {
                    if (cuadroBeneficio.getText().equals("")) {
                        cuadroBeneficio.setText("0");
                    }
                    if (Integer.parseInt(numPart.getValue().toString()) == 0 && Double.parseDouble(cuadroBeneficio.getText()) <= 0) {
                        error.setVisible(true);
                    } else if (Double.parseDouble(cuadroBeneficio.getText()) < 0) {
                        error.setVisible(true);
                    } else {

                        if (fa.getSaldoRetenciones(eu.getIdUsuario()) < 0) {
                            /*error.setText("Saldo insuficiente para completar la transacci??n");
                             error.setVisible(true);*/
                            VAviso saldo = new VAviso("El saldo es insuficiente");
                            saldo.setVisible(true);

                        }
                        if (fa.getParticipacionesRetenciones(eu.getIdUsuario()) < 0 && Integer.parseInt(numPart.getValue().toString()) > 0) {
                            /*error.setText("Saldo insuficiente para completar la transacci??n");
                             error.setVisible(true);*/
                            VAviso part = new VAviso("El saldo es insuficiente");
                            part.setVisible(true);

                        } else {
                          
                            fa.altaPagoBeneficios(date, Double.parseDouble(cuadroBeneficio.getText()), btnSelector.getSelectedItem().toString(), Integer.parseInt(numPart.getValue().toString()));
                            if (fa.getSaldoRetenciones(eu.getIdUsuario()) < 0) {
                                /*error.setText("Saldo insuficiente para completar la transacci??n");
                                 error.setVisible(true);*/
                                VAviso saldo = new VAviso("El saldo es insuficiente");
                                saldo.setVisible(true);
                                fa.bajaAnuncioBeneficios(date, btnSelector.getSelectedItem().toString());

                            } else if (fa.getParticipacionesRetenciones(eu.getIdUsuario()) < 0 && Integer.parseInt(numPart.getValue().toString()) > 0) {
                                /*error.setText("Participaciones insuficientes para completar la transacci??n");
                                 error.setVisible(true);*/
                                VAviso part = new VAviso("Las participaciones son insuficiente");
                                part.setVisible(true);
                                fa.bajaAnuncioBeneficios(date, btnSelector.getSelectedItem().toString());

                            } else {
                                VAvisoCorrecto bien = new VAvisoCorrecto("Se han anunciado beneficios por un valor de " + cuadroBeneficio.getText() + " euros por participaci??n."
                                        + "\n y " + numPart.getValue().toString() + " participaciones");
                                bien.setVisible(true);
                                fa.insertarNoticia("Anuncio beneficios", "El usuario " + eu.getNombreComercial() + " ha anunciado " + cuadroBeneficio.getText() + " de beneficio por participacion", eu.getIdUsuario());
                                actualizarTablaBeneficios();
                                error.setVisible(false);
                            }
                        }
                    }
                }
            }
        }
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void estadisticasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_estadisticasActionPerformed
        ve = new VEstadistica(fa, iu, eu);
        ve.setVisible(true);    }//GEN-LAST:event_estadisticasActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // TODO add your handling code here:
        ModeloTablaBeneficios m;
        m = (ModeloTablaBeneficios) tablaBeneficios.getModel();
        m.setFilas(fa.getBeneficiosEmpresa(fa.getIdEmpresa(btnSelector.getSelectedItem().toString())));
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnPagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPagarActionPerformed
        //comprobaciones

        if (!btnSelector.getSelectedItem().toString().equals(eu.getNombreComercial())) {
            VAviso va;
            va = new VAviso("Esa empresa no es de su propiedad.\nAcci??n no disponible");
            va.setVisible(true);
        } else {
            if (cuadroBeneficio.getText().equals("")) {
                cuadroBeneficio.setText("0");
            }
            if (Integer.parseInt(numPart.getValue().toString()) == 0 && Double.parseDouble(cuadroBeneficio.getText()) <= 0) {
                error.setVisible(true);
            } else if (Double.parseDouble(cuadroBeneficio.getText()) < 0 ) {
                error.setVisible(true);
            } else {

                if (fa.getSaldoRetenciones(eu.getIdUsuario()) < 0) {
                    /*error.setText("Saldo insuficiente para completar la transacci??n");
                     error.setVisible(true);*/
                    VAviso saldo = new VAviso("El saldo es insuficiente");
                    saldo.setVisible(true);

                }
                if (fa.getParticipacionesRetenciones(eu.getIdUsuario()) < 0  && Integer.parseInt(numPart.getValue().toString()) > 0) {
                    /*error.setText("Participaciones insuficientes para completar la transacci??n");
                     error.setVisible(true);*/
                    VAviso part = new VAviso("Las participaciones son insuficiente");
                    part.setVisible(true);

                } else {

                    fa.altaPagoBeneficios(String.valueOf(LocalDate.now()), Double.parseDouble(cuadroBeneficio.getText()), btnSelector.getSelectedItem().toString(), Integer.parseInt(numPart.getValue().toString()));

                    actualizarTablaBeneficios();

                    if (fa.getSaldoRetenciones(eu.getIdUsuario()) < 0) {
                        /*error.setText("Saldo insuficiente para completar la transacci??n");
                         error.setVisible(true);*/
                        VAviso saldo = new VAviso("El saldo es insuficiente");
                        saldo.setVisible(true);

                        fa.bajaAnuncioBeneficios(String.valueOf(LocalDate.now()), btnSelector.getSelectedItem().toString());

                    } else if (fa.getParticipacionesRetenciones(eu.getIdUsuario()) < 0 &&  Integer.parseInt(numPart.getValue().toString()) > 0) {
                        /*error.setText("Participaciones insuficientes para completar la transacci??n");
                         error.setVisible(true);*/
                        VAviso part = new VAviso("Las participaciones son insuficientes");
                        part.setVisible(true);
                        fa.bajaAnuncioBeneficios(String.valueOf(LocalDate.now()), btnSelector.getSelectedItem().toString());

                    } else {

                        fa.pagarBeneficios();

                        VAvisoCorrecto bien = new VAvisoCorrecto("Se han pagado beneficios por un valor de " + cuadroBeneficio.getText() + " euros por participaci??n."
                                + "\n y " + numPart.getValue().toString() + " participaciones");
                        bien.setVisible(true);
                        error.setVisible(false);

                    }

                }
            }
        }
    }//GEN-LAST:event_btnPagarActionPerformed

    private void btnSelectorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelectorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSelectorActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnPagar;
    private javax.swing.JComboBox btnSelector;
    private javax.swing.JTextField cuadroBeneficio;
    private com.toedter.calendar.JDateChooser cuadroFechaPago;
    private javax.swing.JLabel error;
    private javax.swing.JButton estadisticas;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner numPart;
    private javax.swing.JTable tablaBeneficios;
    private javax.swing.JLabel textoEstad??sticas;
    // End of variables declaration//GEN-END:variables

    private void actualizarTablaBeneficios() {
        ModeloTablaBeneficios m;
        m = (ModeloTablaBeneficios) tablaBeneficios.getModel();
        m.setFilas(fa.getBeneficios());
    }

}


package gui;

import aplicacion.EmpresaUsuario;
import aplicacion.FachadaAplicacion;
import aplicacion.InversorUsuario;
import aplicacion.Saldos;
import aplicacion.TipoUsuario;
import java.awt.Color;

public class VSaldos extends javax.swing.JDialog {

    Color prueba = new Color(60, 63, 65);
    Color prueba1 = new Color(78, 82, 85);

    FachadaAplicacion fa;

    public VSaldos(FachadaAplicacion fa) {
        initComponents();
        this.fa = fa;
        this.getContentPane().setBackground(prueba);
        cuadroDni.setBackground(prueba1);
        cuadroSaldo.setBackground(prueba1);
        btnBuscar.setBackground(prueba1);
        btnActualizar.setBackground(prueba1);
        tabla.setBackground(prueba1);
        aceptarButton.setBackground(prueba1);
        error.setVisible(false);
        actualizarTablaSaldos();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        DNILablel = new javax.swing.JLabel();
        saldoLabel = new javax.swing.JLabel();
        cuadroSaldo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        btnActualizar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        aceptarButton = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        error = new javax.swing.JLabel();
        cuadroDni = new javax.swing.JTextField();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        DNILablel.setForeground(new java.awt.Color(187, 187, 188));
        DNILablel.setText("ID:");

        saldoLabel.setForeground(new java.awt.Color(187, 187, 188));
        saldoLabel.setText("Saldo:");

        cuadroSaldo.setForeground(new java.awt.Color(187, 187, 188));

        jLabel2.setForeground(new java.awt.Color(187, 187, 188));
        jLabel2.setText("??? ");

        btnActualizar.setForeground(new java.awt.Color(187, 187, 188));
        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        btnCancelar.setBackground(new java.awt.Color(180, 22, 45));
        btnCancelar.setForeground(new java.awt.Color(0, 0, 0));
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        aceptarButton.setForeground(new java.awt.Color(187, 187, 188));
        aceptarButton.setText("Aceptar");
        aceptarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aceptarButtonActionPerformed(evt);
            }
        });

        btnBuscar.setForeground(new java.awt.Color(187, 187, 188));
        btnBuscar.setText("Buscar");
        btnBuscar.setFocusable(false);
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        tabla.setForeground(new java.awt.Color(204, 204, 204));
        tabla.setModel(new ModeloTablaSaldos());
        tabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabla);

        error.setForeground(new java.awt.Color(255, 51, 51));
        error.setText("Introduzca un ID v??lido!");

        cuadroDni.setForeground(new java.awt.Color(187, 187, 188));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnActualizar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(aceptarButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(saldoLabel)
                            .addComponent(DNILablel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(error)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cuadroSaldo, javax.swing.GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE)
                                    .addComponent(cuadroDni))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 91, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)))))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(DNILablel)
                            .addComponent(btnBuscar)
                            .addComponent(cuadroDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cuadroSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(saldoLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(error)
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(aceptarButton)
                    .addComponent(btnActualizar)
                    .addComponent(btnCancelar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        switch (cuadroDni.getText().length()) {
            case 9:
                InversorUsuario i = new InversorUsuario(cuadroDni.getText(), "", "", "", "", "", "", TipoUsuario.Normal);
                i.setFondosDisponiblesCuenta(Double.valueOf(cuadroSaldo.getText()));
                fa.modificarCuentaInversor(i);
                break;
            case 13:
                EmpresaUsuario e = new EmpresaUsuario(cuadroDni.getText(), "", "", "", "", TipoUsuario.Normal);
                e.setFondosDisponiblesCuenta(Double.valueOf(cuadroSaldo.getText()));
                fa.modificarCuentaEmpresa(e);
                break;
            default:
                error.setVisible(true);
                break;
        }
        actualizarTablaSaldos();
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed
                                          
    private void tablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaMouseClicked
        // TODO add your handling code here:
        ModeloTablaSaldos m;
        m = (ModeloTablaSaldos) tabla.getModel();
        
        if(m.getRowCount() != 0){
            int i = tabla.getSelectedRow();
            Saldos s = m.obtenerSaldo(i);
            cuadroDni.setText(s.getUsuario());
            cuadroSaldo.setText(String.valueOf(s.getSaldo()));
        }
    }//GEN-LAST:event_tablaMouseClicked

    private void aceptarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aceptarButtonActionPerformed
        // TODO add your handling code here:
        switch (cuadroDni.getText().length()) {
            case 9:
                InversorUsuario i = new InversorUsuario(cuadroDni.getText(), "", "", "", "", "", "", TipoUsuario.Normal);
                i.setFondosDisponiblesCuenta(Double.valueOf(cuadroSaldo.getText()));
                fa.modificarCuentaInversor(i);
                break;
            case 13:
                EmpresaUsuario e = new EmpresaUsuario(cuadroDni.getText(), "", "", "", "", TipoUsuario.Normal);
                e.setFondosDisponiblesCuenta(Double.valueOf(cuadroSaldo.getText()));
                fa.modificarCuentaEmpresa(e);
                break;
            default:
                error.setVisible(true);
                break;
        }
        this.dispose();
    }//GEN-LAST:event_aceptarButtonActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // TODO add your handling code here:
        ModeloTablaSaldos m;
        m = (ModeloTablaSaldos) tabla.getModel();
        m.setFilas(fa.getSaldoUsuario(cuadroDni.getText()));
    }//GEN-LAST:event_btnBuscarActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel DNILablel;
    private javax.swing.JButton aceptarButton;
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JTextField cuadroDni;
    private javax.swing.JTextField cuadroSaldo;
    private javax.swing.JLabel error;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel saldoLabel;
    private javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables
    
    private void actualizarTablaSaldos() {
        ModeloTablaSaldos m;
        m = (ModeloTablaSaldos) tabla.getModel();
        m.setFilas(fa.getSaldoUsuarios());
    }
}


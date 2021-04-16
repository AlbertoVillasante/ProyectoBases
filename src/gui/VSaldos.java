/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import aplicacion.FachadaAplicacion;
import java.awt.Color;

public class VSaldos extends javax.swing.JDialog {

    Color prueba = new Color(60, 63, 65);
    Color prueba1 = new Color(78, 82, 85);

    FachadaAplicacion fa;

    public VSaldos(FachadaAplicacion fa) {
        this.fa = fa;
        initComponents();
        this.getContentPane().setBackground(prueba);
        cuadroDni.setBackground(prueba1);
        btnSaldo.setBackground(prueba1);
        btnBuscar.setBackground(prueba1);
        btnActualizar.setBackground(prueba1);
        lista.setBackground(prueba1);
        aceptarButton.setBackground(prueba1);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        DNILablel = new javax.swing.JLabel();
        saldoLabel = new javax.swing.JLabel();
        btnSaldo = new javax.swing.JTextField();
        cuadroDni = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lista = new javax.swing.JList();
        btnActualizar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        aceptarButton = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        DNILablel.setForeground(new java.awt.Color(187, 187, 188));
        DNILablel.setText("DNI:");

        saldoLabel.setForeground(new java.awt.Color(187, 187, 188));
        saldoLabel.setText("Saldo:");

        btnSaldo.setForeground(new java.awt.Color(187, 187, 188));

        cuadroDni.setForeground(new java.awt.Color(187, 187, 188));
        cuadroDni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cuadroDniActionPerformed(evt);
            }
        });

        jLabel2.setForeground(new java.awt.Color(187, 187, 188));
        jLabel2.setText("€ ");

        lista.setForeground(new java.awt.Color(187, 187, 188));
        lista.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(lista);

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

        btnBuscar.setForeground(new java.awt.Color(187, 187, 188));
        btnBuscar.setText("Buscar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(saldoLabel)
                                .addGap(18, 18, 18)
                                .addComponent(btnSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(DNILablel)
                                .addGap(18, 18, 18)
                                .addComponent(cuadroDni, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnBuscar)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnActualizar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                        .addComponent(aceptarButton)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancelar)
                        .addGap(33, 33, 33)))
                .addContainerGap(41, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(DNILablel)
                            .addComponent(cuadroDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnBuscar))
                        .addGap(52, 52, 52)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(saldoLabel)
                            .addComponent(jLabel2))
                        .addGap(84, 84, 84))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addGap(18, 18, 18)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(aceptarButton)
                    .addComponent(btnActualizar))
                .addContainerGap(39, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        //id = null;
        /*btnUsuario.setText("");
        btnDireccion.setText("");
        btnClave.setText("");
        btnEmpresa.setText("");
        btnTelefono.setText("");
        btnApellido1.setText("");
        btnApellido2.setText("");
        btnInversor.setText("");
        tipo_usr.setSelectedIndex(0);*/

        //btnBorrar.setEnabled(true);
        //btnRegistrar.setEnabled(true);
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void cuadroDniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cuadroDniActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cuadroDniActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel DNILablel;
    private javax.swing.JButton aceptarButton;
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JTextField btnSaldo;
    private javax.swing.JTextField cuadroDni;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList lista;
    private javax.swing.JLabel saldoLabel;
    // End of variables declaration//GEN-END:variables
}

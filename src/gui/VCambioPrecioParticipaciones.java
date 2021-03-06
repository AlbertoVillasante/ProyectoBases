
package gui;

import aplicacion.EmpresaUsuario;
import aplicacion.FachadaAplicacion;
import java.awt.Color;


public class VCambioPrecioParticipaciones extends javax.swing.JDialog {

    EmpresaUsuario eu;
    FachadaAplicacion fa;

    Color prueba = new Color(60, 63, 65);
    Color prueba1 = new Color(78, 82, 85);

    public VCambioPrecioParticipaciones(FachadaAplicacion fa, EmpresaUsuario eu) {
        initComponents();
        this.getContentPane().setBackground(prueba);
        jButton1.setBackground(prueba1);
        texto.setBackground(prueba1);
        this.eu = eu;
        this.fa = fa;
        texto.setText(String.valueOf(eu.getValorParticipaciones()));
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        texto = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jButton1.setForeground(new java.awt.Color(187, 187, 188));
        jButton1.setText("Aceptar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        texto.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        texto.setForeground(new java.awt.Color(187, 187, 188));

        jLabel4.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(187, 187, 188));
        jLabel4.setText("€ ");

        jLabel1.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(187, 187, 188));
        jLabel1.setText("Precio de Participaciones: ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(jLabel1)
                        .addGap(49, 49, 49)
                        .addComponent(texto, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(jLabel4))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(213, 213, 213)
                        .addComponent(jButton1)))
                .addContainerGap(48, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(45, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(texto, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addGap(15, 15, 15))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (texto.getText().isEmpty()) {
            VAviso va;
            va  = new VAviso("Rellene el campo requerido.");
        } else {
            fa.actualizaSaldoEmpresa(eu, Double.valueOf(texto.getText()));
            eu.setValorParticipaciones(Double.valueOf(texto.getText()));
        }
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField texto;
    // End of variables declaration//GEN-END:variables
}

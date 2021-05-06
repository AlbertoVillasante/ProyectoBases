
package gui;

import aplicacion.EmpresaUsuario;
import aplicacion.InversorUsuario;
import java.awt.Color;


public class VBajaBeneficios extends javax.swing.JDialog {

    aplicacion.FachadaAplicacion fa;
    

    Color prueba = new Color(60, 63, 65);
    Color prueba1 = new Color(78, 82, 85);

    
    public VBajaBeneficios(aplicacion.FachadaAplicacion fa, InversorUsuario iu, EmpresaUsuario eu) {
        this.fa = fa;
        this.initComponents();
        this.getContentPane().setBackground(prueba);
        btnBaja.setBackground(prueba1);

        actualizarTablaBeneficios();
        btnBaja.setEnabled(false);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tablaBeneficios = new javax.swing.JTable();
        btnBaja = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tablaBeneficios.setModel(new ModeloTablaBeneficios());
        tablaBeneficios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaBeneficiosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaBeneficios);

        btnBaja.setForeground(new java.awt.Color(187, 187, 188));
        btnBaja.setText("Confirmar baja");
        btnBaja.setFocusable(false);
        btnBaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBajaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 391, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBaja))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnBaja)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBajaActionPerformed
        // TODO add your handling code here:
        ModeloTablaBeneficios m;
        m = (ModeloTablaBeneficios) tablaBeneficios.getModel();
        String nombreEmpresa = (String) m.getValueAt(tablaBeneficios.getSelectedRow(), 1);
        String fecha = (String) m.getValueAt(tablaBeneficios.getSelectedRow(), 0);
        fa.bajaAnuncioBeneficios(fecha, nombreEmpresa);

        actualizarTablaBeneficios();

    }//GEN-LAST:event_btnBajaActionPerformed

    private void tablaBeneficiosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaBeneficiosMouseClicked
        // TODO add your handling code here:
        btnBaja.setEnabled(true);
    }//GEN-LAST:event_tablaBeneficiosMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBaja;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaBeneficios;
    // End of variables declaration//GEN-END:variables

    private void actualizarTablaBeneficios() {
        ModeloTablaBeneficios m;
        m = (ModeloTablaBeneficios) tablaBeneficios.getModel();
        m.setFilas(fa.getBeneficios());
    }
}

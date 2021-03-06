
package gui;

import aplicacion.EmpresaUsuario;
import aplicacion.FachadaAplicacion;
import aplicacion.InversorUsuario;
import java.awt.Color;


public class VVerificacion extends javax.swing.JDialog {

    FachadaAplicacion fa;
    Color prueba = new Color(60, 63, 65);
    Color prueba1 = new Color(78, 82, 85);

    
    public VVerificacion(FachadaAplicacion fa) {
        this.fa = fa;
        initComponents();
        buscarUsuario();
        this.getContentPane().setBackground(prueba);
        btnAceptar.setBackground(prueba1);
        rechazarBtn.setBackground(prueba1);
        tablaVerificacion.setBackground(prueba1);
        

    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnCancelar = new javax.swing.JButton();
        btnAceptar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaVerificacion = new javax.swing.JTable();
        rechazarBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        btnCancelar.setBackground(new java.awt.Color(180, 22, 45));
        btnCancelar.setForeground(new java.awt.Color(0, 0, 0));
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnAceptar.setForeground(new java.awt.Color(187, 187, 188));
        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        tablaVerificacion.setForeground(new java.awt.Color(187, 187, 188));
        tablaVerificacion.setModel(new ModeloTablaVerificacion());
        tablaVerificacion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaVerificacionMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaVerificacion);

        rechazarBtn.setForeground(new java.awt.Color(187, 187, 188));
        rechazarBtn.setText("Rechazar");
        rechazarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rechazarBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAceptar)
                        .addGap(96, 96, 96)
                        .addComponent(rechazarBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCancelar))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 495, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAceptar)
                    .addComponent(btnCancelar)
                    .addComponent(rechazarBtn))
                .addGap(0, 16, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed

        actualizarEstado();
        buscarUsuario();
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void tablaVerificacionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaVerificacionMouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_tablaVerificacionMouseClicked

    private void rechazarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rechazarBtnActionPerformed
        rechazar();
        buscarUsuario();
        // TODO add your handling code here:
    }//GEN-LAST:event_rechazarBtnActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton rechazarBtn;
    private javax.swing.JTable tablaVerificacion;
    // End of variables declaration//GEN-END:variables
    
    public void buscarUsuario(){
        ModeloTablaVerificacion m;
        m=(ModeloTablaVerificacion) tablaVerificacion.getModel();
        m.setFilas(fa.mostrarUsuarioEmprPend(), fa.mostrarUsuarioInvPend());
        if (m.getRowCount() > 0) {
            tablaVerificacion.setRowSelectionInterval(0, 0);
            btnAceptar.setEnabled(true);
            rechazarBtn.setEnabled(true);
        }else{
            btnAceptar.setEnabled(false);
            rechazarBtn.setEnabled(false);
        }
    }
    
    public void actualizarEstado(){
        ModeloTablaVerificacion m;
        m=(ModeloTablaVerificacion) tablaVerificacion.getModel();
        
        if(tablaVerificacion.getSelectedRow() < m.obtenerNumEmprPend()){
            EmpresaUsuario eu= m.obtenerUsuarioEmpr(tablaVerificacion.getSelectedRow());
            if(eu.getTipoUsuario().toString().equals("PendAlta")){
                fa.registroEmpresa(eu);
                fa.insertarNoticia("Alta", "El usuario " + eu.getNombreComercial() + " se ha dado de alta en el Mercado de Valores", eu.getIdUsuario());
            }else{
                fa.confirmarBajaEmpresa(eu.getIdUsuario());
            }
            
        }
        
        else{
            InversorUsuario iu= m.obtenerUsuarioInv(tablaVerificacion.getSelectedRow() - m.obtenerNumEmprPend());
            if(iu.getTipoUsuario().toString().equals("PendAlta")){
                fa.registroInversor(iu);
                fa.insertarNoticia("Alta", "El usuario " + iu.getNombre() + " se ha dado de alta en el Mercado de Valores", iu.getIdUsuario());
            }else{
                fa.confirmarBajaInversor(iu.getIdUsuario());
            }
        }
    }
    
    public void rechazar(){
        ModeloTablaVerificacion m;
        m=(ModeloTablaVerificacion) tablaVerificacion.getModel();
        
        if(tablaVerificacion.getSelectedRow() < m.obtenerNumEmprPend()){
            EmpresaUsuario eu= m.obtenerUsuarioEmpr(tablaVerificacion.getSelectedRow());
            if(eu.getTipoUsuario().toString().equals("PendAlta")){
                fa.eliminarEmpresa(eu.getIdUsuario());
            }else{
                fa.estadoNormalEmpr(eu.getIdUsuario());
            }
            
        }
        
        else{
            InversorUsuario iu= m.obtenerUsuarioInv(tablaVerificacion.getSelectedRow() - m.obtenerNumEmprPend());
            if(iu.getTipoUsuario().toString().equals("PendAlta")){
                fa.eliminarInversor(iu.getIdUsuario());
            }else{
                fa.estadoNormalInv(iu.getIdUsuario());
            }
        }
    }

}

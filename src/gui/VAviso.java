package gui;

import java.awt.Color;

public class VAviso extends javax.swing.JDialog {

    Color prueba = new Color(60, 63, 65);
    Color prueba1 = new Color(78, 82, 85);
    Color prueba2 = new Color(255, 255, 255);

    public VAviso(String txtExcepcion) {
        initComponents();
        this.getContentPane().setBackground(prueba);
        textoExcepcion.setBackground(prueba1);
        btnCerrar.setBackground(prueba1);
        textoExcepcion.setForeground(prueba2);
        textoExcepcion.setText(txtExcepcion);
        aviso.setBackground(prueba);
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

        btnCerrar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        textoExcepcion = new javax.swing.JTextArea();
        btnDerecha = new javax.swing.JButton();
        aviso = new java.awt.Label();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        btnCerrar.setForeground(new java.awt.Color(187, 187, 188));
        btnCerrar.setText("Cerrar");
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });

        textoExcepcion.setColumns(20);
        textoExcepcion.setForeground(new java.awt.Color(244, 44, 44));
        textoExcepcion.setRows(5);
        jScrollPane1.setViewportView(textoExcepcion);

        btnDerecha.setBackground(new java.awt.Color(255, 255, 255));
        btnDerecha.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/a.png"))); // NOI18N
        btnDerecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDerechaActionPerformed(evt);
            }
        });

        aviso.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        aviso.setForeground(new java.awt.Color(180, 0, 0));
        aviso.setMinimumSize(new java.awt.Dimension(80, 27));
        aviso.setPreferredSize(new java.awt.Dimension(80, 30));
        aviso.setText("CUIDADO");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(169, 169, 169)
                        .addComponent(btnDerecha, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22)
                        .addComponent(aviso, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 432, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(208, 208, 208)
                        .addComponent(btnCerrar)))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(40, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnDerecha, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(aviso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCerrar)
                .addGap(12, 12, 12))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCerrarActionPerformed

    private void btnDerechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDerechaActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_btnDerechaActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Label aviso;
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnDerecha;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea textoExcepcion;
    // End of variables declaration//GEN-END:variables
}

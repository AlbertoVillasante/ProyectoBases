
package gui;

import aplicacion.EmpresaUsuario;
import aplicacion.FachadaAplicacion;
import aplicacion.InversorUsuario;
import java.awt.Color;
import java.text.DecimalFormat;
import java.util.Locale;


public class VEstadistica extends javax.swing.JDialog {

    FachadaAplicacion fa;
    Color prueba = new Color(60, 63, 65);
    Color prueba1 = new Color(78, 82, 85);
    EmpresaUsuario eu;
    InversorUsuario iu;

    /**
     * Creates new form VEstadistica
     *
     * @param fa
     * @param iu
     * @param eu
     */
    public VEstadistica(FachadaAplicacion fa, InversorUsuario iu, EmpresaUsuario eu) {
        this.fa = fa;
        initComponents();
        this.getContentPane().setBackground(prueba);
        aceptar.setBackground(prueba1);
        textPartTot.setBackground(prueba1);
        TextFond.setBackground(prueba1);
        tablaEstadisticas.setBackground(prueba1);
        TextFondosRetenciones.setBackground(prueba1);
        rendimientoText.setBackground(prueba1);
        textPartTot1.setBackground(prueba1);
        if (iu != null) {
            this.iu = iu;
            TextFondosRetenciones.setVisible(false);
            textPartTot1.setVisible(false);
            jLabel6.setVisible(false);
            jLabel5.setVisible(false);
            jLabel4.setVisible(false);
            textPartTot.setVisible(false);
            jLabel2.setVisible(false);
            TextFond.setText(String.valueOf(Math.round(iu.getFondosDisponiblesCuenta() * 100.0) / 100.0));
             DecimalFormat df = new DecimalFormat("#.00");
            String rendimiento = String.valueOf(df.format(fa.getRendimiento(iu.getIdUsuario())));
            rendimientoText.setText(rendimiento);
        }
        if (eu != null) {
            this.eu = eu;
            TextFondosRetenciones.setText(convertir(fa.getSaldoRetenciones(eu.getIdUsuario())));
            TextFond.setText(String.valueOf(Math.round(eu.getFondosDisponiblesCuenta() * 100.0) / 100.0));
            textPartTot.setText(String.valueOf(eu.getnParticipaciones()));
            textPartTot1.setText(Integer.toString(fa.getParticipacionesRetenciones(eu.getIdUsuario())));
            if(fa.getSaldoRetenciones(eu.getIdUsuario()) < 0){
                TextFondosRetenciones.setForeground(new Color(255, 0, 0));
            }
            if(fa.getParticipacionesRetenciones(eu.getIdUsuario()) < 0){
                textPartTot1.setForeground(new Color(255, 0, 0));
            }
            DecimalFormat df = new DecimalFormat("#.00");
            String rendimiento = String.valueOf(df.format(fa.getRendimiento(eu.getIdUsuario())));
            rendimientoText.setText(rendimiento);
            
        }
        actualizarTablaEstadisticas();
       
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tablaEstadisticas = new javax.swing.JTable();
        aceptar = new javax.swing.JButton();
        cancelar = new javax.swing.JButton();
        textPartTot = new javax.swing.JTextField();
        TextFond = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        TextFondosRetenciones = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        textPartTot1 = new javax.swing.JTextField();
        rendimientoLabel = new javax.swing.JLabel();
        rendimientoText = new javax.swing.JTextField();
        porcentajeLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tablaEstadisticas.setForeground(new java.awt.Color(187, 187, 188));
        tablaEstadisticas.setModel(new ModeloTablaEstadisticas());
        jScrollPane1.setViewportView(tablaEstadisticas);

        aceptar.setForeground(new java.awt.Color(187, 187, 188));
        aceptar.setText("Aceptar");
        aceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aceptarActionPerformed(evt);
            }
        });

        cancelar.setBackground(new java.awt.Color(180, 22, 45));
        cancelar.setForeground(new java.awt.Color(0, 0, 0));
        cancelar.setText("Cancelar");
        cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarActionPerformed(evt);
            }
        });

        textPartTot.setEditable(false);
        textPartTot.setForeground(new java.awt.Color(187, 187, 188));

        TextFond.setEditable(false);
        TextFond.setForeground(new java.awt.Color(187, 187, 188));

        jLabel1.setForeground(new java.awt.Color(187, 187, 188));
        jLabel1.setText("€");

        jLabel2.setForeground(new java.awt.Color(187, 187, 188));
        jLabel2.setText("Nº participaciones totales:");

        jLabel3.setForeground(new java.awt.Color(187, 187, 188));
        jLabel3.setText("Fondos disponibles cuenta:");

        jLabel4.setForeground(new java.awt.Color(187, 187, 188));
        jLabel4.setText("€");

        jLabel5.setForeground(new java.awt.Color(187, 187, 188));
        jLabel5.setText("Fondos tras retenciones:");

        TextFondosRetenciones.setEditable(false);
        TextFondosRetenciones.setForeground(new java.awt.Color(187, 187, 188));
        TextFondosRetenciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextFondosRetencionesActionPerformed(evt);
            }
        });

        jLabel6.setForeground(new java.awt.Color(187, 187, 188));
        jLabel6.setText("Nº participaciones tras retenciones:");

        textPartTot1.setEditable(false);
        textPartTot1.setForeground(new java.awt.Color(187, 187, 188));

        rendimientoLabel.setForeground(new java.awt.Color(187, 187, 188));
        rendimientoLabel.setText("Rendimiento:");

        rendimientoText.setEditable(false);
        rendimientoText.setForeground(new java.awt.Color(187, 187, 188));

        porcentajeLabel.setForeground(new java.awt.Color(187, 187, 188));
        porcentajeLabel.setText("%");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(aceptar))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(textPartTot1, javax.swing.GroupLayout.DEFAULT_SIZE, 247, Short.MAX_VALUE)
                                .addGap(70, 70, 70))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(TextFond, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(TextFondosRetenciones))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel1)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(cancelar)))
                        .addGap(30, 30, 30))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(textPartTot, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(rendimientoLabel)
                                .addGap(12, 12, 12)
                                .addComponent(rendimientoText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(porcentajeLabel)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cancelar)
                            .addComponent(aceptar)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textPartTot, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(textPartTot1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TextFond, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TextFondosRetenciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rendimientoLabel)
                            .addComponent(rendimientoText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(porcentajeLabel))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_cancelarActionPerformed

    private void TextFondosRetencionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextFondosRetencionesActionPerformed


    }//GEN-LAST:event_TextFondosRetencionesActionPerformed

    private void aceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aceptarActionPerformed
        this.dispose();
    }//GEN-LAST:event_aceptarActionPerformed
    public static String convertir(double val) {
        Locale.setDefault(Locale.US);
        DecimalFormat num = new DecimalFormat("#,###.00");
        return num.format(val);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField TextFond;
    private javax.swing.JTextField TextFondosRetenciones;
    private javax.swing.JButton aceptar;
    private javax.swing.JButton cancelar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel porcentajeLabel;
    private javax.swing.JLabel rendimientoLabel;
    private javax.swing.JTextField rendimientoText;
    private javax.swing.JTable tablaEstadisticas;
    private javax.swing.JTextField textPartTot;
    private javax.swing.JTextField textPartTot1;
    // End of variables declaration//GEN-END:variables

    private void actualizarTablaEstadisticas() {
        ModeloTablaEstadisticas m;
        m = (ModeloTablaEstadisticas) tablaEstadisticas.getModel();
        m.setFilas(fa.actualizarTablaEstadisticas(iu, eu));
    }
    
}

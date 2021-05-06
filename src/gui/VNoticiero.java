
package gui;

import aplicacion.Noticias;
import java.awt.Color;
import javax.swing.ImageIcon;


public class VNoticiero extends javax.swing.JDialog {
    Color prueba = new Color(60, 63, 65);
    Color prueba1 = new Color(78, 82, 85);
    aplicacion.FachadaAplicacion fa;
    
    public VNoticiero(aplicacion.FachadaAplicacion fa, String tiponoticia) {
        initComponents();
        this.fa = fa;
        int flag = 0;
        this.getContentPane().setBackground(prueba);
        titulo.setText(tiponoticia);
        if(tiponoticia.equals("ANUNCIOS DE BENEFICIOS")){
            fotoNoticia.setIcon(new ImageIcon(getClass().getResource("/gui/Beneficios.png")));
            flag = 0;
        }
        if(tiponoticia.equals("ANUNCIOS DE ALTAS Y BAJAS")){
            fotoNoticia.setIcon(new ImageIcon(getClass().getResource("/gui/gente.png")));
            flag = 1;
        }
        if(tiponoticia.equals("ANUNCIOS DE PARTICIPACIONES")){
            fotoNoticia.setIcon(new ImageIcon(getClass().getResource("/gui/participaciones.png")));
            flag = 2;
        }
        mostrarNoticias(flag);
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titulo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        salir = new javax.swing.JButton();
        fotoNoticia = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaNoticias = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        titulo.setEditable(false);
        titulo.setBackground(new java.awt.Color(51, 51, 51));
        titulo.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        titulo.setForeground(new java.awt.Color(153, 153, 153));
        titulo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        titulo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        titulo.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        titulo.setSelectionColor(new java.awt.Color(255, 255, 255));

        jLabel2.setForeground(new java.awt.Color(153, 153, 153));
        jLabel2.setText("__________________________________");

        jLabel3.setForeground(new java.awt.Color(153, 153, 153));
        jLabel3.setText("__________________________________");

        salir.setBackground(new java.awt.Color(180, 22, 45));
        salir.setForeground(new java.awt.Color(0, 0, 0));
        salir.setText("Salir");
        salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirActionPerformed(evt);
            }
        });

        fotoNoticia.setBackground(new java.awt.Color(255, 255, 255));
        fotoNoticia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/Beneficios.png"))); // NOI18N
        fotoNoticia.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        fotoNoticia.setBorderPainted(false);
        fotoNoticia.setContentAreaFilled(false);
        fotoNoticia.setFocusPainted(false);
        fotoNoticia.setFocusable(false);

        tablaNoticias.setModel(new ModeloTablaNoticias());
        jScrollPane1.setViewportView(tablaNoticias);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 472, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fotoNoticia, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(salir, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(titulo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)))
                .addGap(40, 40, 40))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(fotoNoticia, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(salir)))
                .addGap(30, 30, 30))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirActionPerformed
        this.dispose();
    }//GEN-LAST:event_salirActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton fotoNoticia;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton salir;
    private javax.swing.JTable tablaNoticias;
    private javax.swing.JTextField titulo;
    // End of variables declaration//GEN-END:variables
    
    public void mostrarNoticias(int flag){
        ModeloTablaNoticias m;
        m=(ModeloTablaNoticias) tablaNoticias.getModel();
        java.util.List<Noticias> noticias = null;
        
        switch(flag){
            case 0:
                noticias = fa.getNoticias("Anuncio beneficios", null, null);
                break;
            case 1:
                noticias = fa.getNoticias("Alta", null, null);
                break;
            case 2:
                noticias = fa.getNoticias("Compra", "Alta P", "Baja P");
                break;
        }
        
        if(noticias == null){
            VAviso v = new VAviso("Aviso");
            v.setVisible(true);
        } else{
            m.setFilas(noticias);
        }
        
    }

}

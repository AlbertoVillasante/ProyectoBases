package gui;

import aplicacion.TipoUsuario;
import aplicacion.EmpresaUsuario;
import aplicacion.InversorUsuario;
import java.awt.Color;

public class VUsuario extends javax.swing.JDialog {

    aplicacion.FachadaAplicacion fa;
    String id = null;
    
    EmpresaUsuario empu;
    InversorUsuario invu;

    int CheckeoUsuario;

    Color prueba = new Color(60, 63, 65);
    Color prueba1 = new Color(78, 82, 85);

    public VUsuario(aplicacion.FachadaAplicacion fa, boolean flag, InversorUsuario iu, EmpresaUsuario eu) {
        this.fa = fa;
        this.empu = eu;
        this.invu = iu;
        initComponents();
        this.getContentPane().setBackground(prueba);
        tipo_usr.setBackground(prueba1);
        btnUsuario.setBackground(prueba1);
        btnActualizar.setBackground(prueba1);
        btnApellido1.setBackground(prueba1);
        btnApellido2.setBackground(prueba1);
        btnBaja.setBackground(prueba1);
        btnDireccion.setBackground(prueba1);
        btnClave1.setBackground(prueba1);
        btnEmpresa.setBackground(prueba);
        btnInversor.setBackground(prueba1);
        btnRegistrar.setBackground(prueba1);
        btnTelefono.setBackground(prueba1);
        btnUsuario.setBackground(prueba1);
        txtUsuarioNoDisponible.setEnabled(false);

        if (flag) {
            tipo_usr.setEnabled(true);
            btnEmpresa.setEnabled(false);
            obligatorio5.setEnabled(false);
            nombreEmpresa.setEnabled(false);
            obligatorioTexto.setEnabled(false);
        } else {
            tipo_usr.setEnabled(false);
            tipo_usr.setForeground(prueba);
            if (iu != null) {
                tipo_usr.setSelectedIndex(0);
                btnUsuario.setText(iu.getIdUsuario());
                btnClave1.setText(iu.getClave());
                btnDireccion.setText(iu.getDireccion());
                btnTelefono.setText(iu.getTelefono());
                btnInversor.setText(iu.getNombre());
                btnApellido1.setText(iu.getApellido1());
                btnApellido2.setText(iu.getApellido2());

            }
            if (eu != null) {
                tipo_usr.setSelectedIndex(1);
                btnUsuario.setText(eu.getIdUsuario());
                btnClave1.setText(eu.getClave());
                btnDireccion.setText(eu.getDireccion());
                btnTelefono.setText(eu.getTelefono());
                btnEmpresa.setText(eu.getNombreComercial());
            }
        }
    }

    /*this.buscarUsuarios();*/
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton4 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        btnUsuario = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        btnDireccion = new javax.swing.JTextField();
        btnTelefono = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btnEmpresa = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        nombreEmpresa = new javax.swing.JLabel();
        tipo_usr = new javax.swing.JComboBox();
        btnActualizar = new javax.swing.JButton();
        btnRegistrar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        obligatorio1 = new javax.swing.JLabel();
        obligatorio3 = new javax.swing.JLabel();
        obligatorio2 = new javax.swing.JLabel();
        obligatorio4 = new javax.swing.JLabel();
        obligatorio5 = new javax.swing.JLabel();
        obligatorio7 = new javax.swing.JLabel();
        obligatorio6 = new javax.swing.JLabel();
        obligatorio8 = new javax.swing.JLabel();
        nombreInversor = new javax.swing.JLabel();
        btnInversor = new javax.swing.JTextField();
        apellido2 = new javax.swing.JLabel();
        btnApellido2 = new javax.swing.JTextField();
        btnApellido1 = new javax.swing.JTextField();
        apellido1 = new javax.swing.JLabel();
        btnBaja = new javax.swing.JButton();
        obligatorioTexto = new javax.swing.JLabel();
        txtUsuarioNoDisponible = new javax.swing.JLabel();
        btnClave1 = new javax.swing.JTextField();

        jButton4.setText("Guardar");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Gestión de Usuarios");

        jLabel3.setForeground(new java.awt.Color(187, 187, 188));
        jLabel3.setText("Usuario:");

        btnUsuario.setForeground(new java.awt.Color(187, 187, 188));
        btnUsuario.setText("DNI / NIF");
        btnUsuario.setToolTipText("DNI/NIF");
        btnUsuario.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                btnUsuarioFocusGained(evt);
            }
        });
        btnUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUsuarioActionPerformed(evt);
            }
        });

        jLabel4.setForeground(new java.awt.Color(187, 187, 188));
        jLabel4.setText("Clave:");

        btnDireccion.setForeground(new java.awt.Color(187, 187, 188));
        btnDireccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDireccionActionPerformed(evt);
            }
        });

        btnTelefono.setForeground(new java.awt.Color(187, 187, 188));
        btnTelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTelefonoActionPerformed(evt);
            }
        });

        jLabel5.setForeground(new java.awt.Color(187, 187, 188));
        jLabel5.setText("Dirección:");

        jLabel6.setForeground(new java.awt.Color(187, 187, 188));
        jLabel6.setText("Teléfono:");

        btnEmpresa.setForeground(new java.awt.Color(187, 187, 188));
        btnEmpresa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEmpresaActionPerformed(evt);
            }
        });

        jLabel7.setForeground(new java.awt.Color(187, 187, 188));
        jLabel7.setText("Tipo usuario:");

        nombreEmpresa.setForeground(new java.awt.Color(187, 187, 188));
        nombreEmpresa.setText("Nombre empresa:");

        tipo_usr.setForeground(new java.awt.Color(187, 187, 188));
        tipo_usr.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Inversor", "Empresa" }));
        tipo_usr.setAutoscrolls(true);
        tipo_usr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tipo_usrActionPerformed(evt);
            }
        });

        btnActualizar.setForeground(new java.awt.Color(187, 187, 188));
        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        btnRegistrar.setForeground(new java.awt.Color(187, 187, 188));
        btnRegistrar.setText("Registrarse");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
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

        obligatorio1.setForeground(new java.awt.Color(255, 0, 0));
        obligatorio1.setText("*");

        obligatorio3.setForeground(new java.awt.Color(255, 0, 0));
        obligatorio3.setText("*");

        obligatorio2.setForeground(new java.awt.Color(255, 0, 0));
        obligatorio2.setText("*");

        obligatorio4.setForeground(new java.awt.Color(255, 0, 0));
        obligatorio4.setText("*");

        obligatorio5.setForeground(new java.awt.Color(255, 0, 0));
        obligatorio5.setText("*");

        obligatorio7.setForeground(new java.awt.Color(255, 0, 0));
        obligatorio7.setText("*");

        obligatorio6.setForeground(new java.awt.Color(255, 0, 0));
        obligatorio6.setText("*");

        obligatorio8.setForeground(new java.awt.Color(255, 0, 0));
        obligatorio8.setText("*");

        nombreInversor.setForeground(new java.awt.Color(187, 187, 188));
        nombreInversor.setText("Nombre inversor:");

        btnInversor.setForeground(new java.awt.Color(187, 187, 188));
        btnInversor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInversorActionPerformed(evt);
            }
        });

        apellido2.setForeground(new java.awt.Color(187, 187, 188));
        apellido2.setText("Apellido 2:");

        btnApellido2.setForeground(new java.awt.Color(187, 187, 188));
        btnApellido2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnApellido2ActionPerformed(evt);
            }
        });

        btnApellido1.setForeground(new java.awt.Color(187, 187, 188));
        btnApellido1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnApellido1ActionPerformed(evt);
            }
        });

        apellido1.setForeground(new java.awt.Color(187, 187, 188));
        apellido1.setText("Apellido 1:");

        btnBaja.setForeground(new java.awt.Color(187, 187, 188));
        btnBaja.setText("Solicitar baja");

        obligatorioTexto.setForeground(new java.awt.Color(255, 51, 51));
        obligatorioTexto.setText("Rellena los campos obligatorios *");

        txtUsuarioNoDisponible.setForeground(new java.awt.Color(255, 51, 51));
        txtUsuarioNoDisponible.setText("Usuario no disponible");

        btnClave1.setForeground(new java.awt.Color(187, 187, 188));
        btnClave1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClave1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtUsuarioNoDisponible)
                            .addComponent(obligatorioTexto))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(obligatorio2)
                            .addComponent(obligatorio4)
                            .addComponent(obligatorio3)
                            .addComponent(obligatorio1))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(jLabel7)
                                        .addGap(18, 18, 18)
                                        .addComponent(tipo_usr, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(btnClave1, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(obligatorio7)
                                            .addComponent(obligatorio6)
                                            .addComponent(obligatorio8)
                                            .addComponent(obligatorio5))
                                        .addGap(20, 20, 20)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(nombreInversor)
                                            .addComponent(nombreEmpresa))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(btnEmpresa)
                                            .addComponent(btnInversor, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE))
                                        .addGap(35, 35, 35))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(143, 143, 143)
                                        .addComponent(btnApellido2, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(btnBaja)
                                        .addGap(99, 99, 99))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 187, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(apellido1)
                                    .addComponent(apellido2))
                                .addGap(69, 69, 69)
                                .addComponent(btnApellido1, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(35, 35, 35))))))
            .addGroup(layout.createSequentialGroup()
                .addGap(97, 97, 97)
                .addComponent(btnActualizar)
                .addGap(156, 156, 156)
                .addComponent(btnRegistrar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCancelar)
                .addGap(60, 60, 60))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBaja)
                    .addComponent(jLabel7)
                    .addComponent(tipo_usr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addComponent(txtUsuarioNoDisponible)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(btnUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(obligatorio1))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(nombreEmpresa)
                        .addComponent(btnEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(obligatorio5)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(79, 79, 79)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(obligatorio3, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nombreInversor)
                            .addComponent(btnInversor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(obligatorio6, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(obligatorio2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(btnClave1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(apellido1)
                            .addComponent(obligatorio7, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnApellido1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(apellido2)
                            .addComponent(btnApellido2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(obligatorio8, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(obligatorio4, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addComponent(obligatorioTexto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegistrar)
                    .addComponent(btnActualizar)
                    .addComponent(btnCancelar))
                .addGap(35, 35, 35))
        );

        tipo_usr.getAccessibleContext().setAccessibleName("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUsuarioActionPerformed

    }//GEN-LAST:event_btnUsuarioActionPerformed

    private void btnDireccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDireccionActionPerformed

    }//GEN-LAST:event_btnDireccionActionPerformed

    private void btnTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTelefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnTelefonoActionPerformed

    private void btnEmpresaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEmpresaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEmpresaActionPerformed

    private void tipo_usrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tipo_usrActionPerformed
        if (tipo_usr.getSelectedIndex() == 1) {
            btnEmpresa.setEnabled(true);
            obligatorio5.setEnabled(true);
            nombreEmpresa.setEnabled(true);
            apellido1.setEnabled(false);
            apellido2.setEnabled(false);
            nombreInversor.setEnabled(false);
            obligatorio6.setEnabled(false);
            obligatorio7.setEnabled(false);
            obligatorio8.setEnabled(false);
            btnInversor.setEnabled(false);
            btnApellido1.setEnabled(false);
            btnApellido2.setEnabled(false);

        } else {
            btnEmpresa.setEnabled(false);
            obligatorio5.setEnabled(false);
            nombreEmpresa.setEnabled(false);
            apellido1.setEnabled(true);
            apellido2.setEnabled(true);
            nombreInversor.setEnabled(true);
            obligatorio6.setEnabled(true);
            obligatorio7.setEnabled(true);
            obligatorio8.setEnabled(true);
            btnInversor.setEnabled(true);
            btnApellido1.setEnabled(true);
            btnApellido2.setEnabled(true);
        }
    }//GEN-LAST:event_tipo_usrActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        //id = null;
        /*btnUsuario.setText("DNI / NIF");
        btnClave1.setText("");
        btnDireccion.setText("");
        btnEmpresa.setText("");
        btnTelefono.setText("");
        btnApellido1.setText("");
        btnApellido2.setText("");
        btnInversor.setText("");
        tipo_usr.setSelectedIndex(0);*/
        
        actualizarDatos();

        //btnBorrar.setEnabled(true);
        //btnRegistrar.setEnabled(true);
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        /*ModeloTablaUsuarios m;
        m = (ModeloTablaUsuarios) TablaUsuarios.getModel();*/
        txtUsuarioNoDisponible.setEnabled(false);

        if (btnUsuario.getText().equals("") || btnUsuario.getText().equals("DNI / NIF")) {
            obligatorioTexto.setEnabled(true);
            obligatorio1.setEnabled(true);
        } else {
            obligatorio1.setEnabled(false);
        }
        if (btnClave1.getText().equals("")) {
            obligatorioTexto.setEnabled(true);
            obligatorio2.setEnabled(true);
        } else {
            obligatorio2.setEnabled(false);
        }
        if (btnDireccion.getText().equals("")) {
            obligatorioTexto.setEnabled(true);
            obligatorio3.setEnabled(true);
        } else {
            obligatorio3.setEnabled(false);
        }
        if (btnTelefono.getText().equals("")) {
            obligatorioTexto.setEnabled(true);
            obligatorio4.setEnabled(true);
        } else {
            obligatorio4.setEnabled(false);
        }

        if (tipo_usr.getSelectedIndex() == 0) {
            if (btnInversor.getText().equals("")) {
                obligatorioTexto.setEnabled(true);
                obligatorio6.setEnabled(true);
            } else {
                obligatorio6.setEnabled(false);
            }
            if (btnApellido1.getText().equals("")) {
                obligatorioTexto.setEnabled(true);
                obligatorio7.setEnabled(true);
            } else {
                obligatorio7.setEnabled(false);
            }
            if (btnApellido2.getText().equals("")) {
                obligatorioTexto.setEnabled(true);
                obligatorio8.setEnabled(true);
            } else {
                obligatorio8.setEnabled(false);
            }
        }

        if (tipo_usr.getSelectedIndex() == 1) {
            if (btnApellido2.getText().equals("")) {
                obligatorioTexto.setEnabled(true);
                obligatorio5.setEnabled(true);
            } else {
                obligatorio5.setEnabled(false);
            }
        }
        if (tipo_usr.getSelectedIndex() == 0) {
            if (!btnUsuario.getText().equals("") && !btnUsuario.getText().equals("DNI / NIF") && !btnDireccion.getText().equals("")
                    && !btnClave1.getText().equals("") && !btnTelefono.getText().equals("")
                    && !btnInversor.getText().equals("") && !btnApellido1.getText().equals("") && !btnApellido2.getText().equals("")) {
                obligatorioTexto.setEnabled(false);
            }
        }
        if (tipo_usr.getSelectedIndex() == 1) {
            if (!btnUsuario.getText().equals("") && !btnUsuario.getText().equals("DNI / NIF") && !btnDireccion.getText().equals("")
                    && !btnClave1.getText().equals("") && !btnTelefono.getText().equals("")
                    && btnEmpresa.getText().equals("")) {
                obligatorioTexto.setEnabled(false);
            }
        }

        if (obligatorioTexto.isEnabled()) {
            return;
        }

        registrarUsuario();

        /* EmpresaUsuario u;
        u = new EmpresaUsuario(btnUsuario.getText(), btnDireccion.getText(), btnClave.getText(), btnEmpresa.getText(),
                btnTelefono.getText(), TipoUsuario.valueOf(tipo_usr.getSelectedItem().toString()));
        if (m.obtenerId().contains(u.getIdUsuario())) {
            id = u.getIdUsuario();
        }*/
        //fa.actualizarUsuario(u, id);  //Comentado para que no de error
        //this.buscarUsuarios();
        // this.BtnNuevoUsuarioActionPerformed(evt);
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnInversorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInversorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnInversorActionPerformed

    private void btnApellido2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnApellido2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnApellido2ActionPerformed

    private void btnApellido1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnApellido1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnApellido1ActionPerformed

    private void btnUsuarioFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_btnUsuarioFocusGained
        if (btnUsuario.getText().equals("DNI / NIF")) {
            btnUsuario.setText("");
        }
    }//GEN-LAST:event_btnUsuarioFocusGained

    private void btnClave1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClave1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnClave1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel apellido1;
    private javax.swing.JLabel apellido2;
    private javax.swing.JButton btnActualizar;
    private javax.swing.JTextField btnApellido1;
    private javax.swing.JTextField btnApellido2;
    private javax.swing.JButton btnBaja;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JTextField btnClave1;
    private javax.swing.JTextField btnDireccion;
    private javax.swing.JTextField btnEmpresa;
    private javax.swing.JTextField btnInversor;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JTextField btnTelefono;
    private javax.swing.JTextField btnUsuario;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel nombreEmpresa;
    private javax.swing.JLabel nombreInversor;
    private javax.swing.JLabel obligatorio1;
    private javax.swing.JLabel obligatorio2;
    private javax.swing.JLabel obligatorio3;
    private javax.swing.JLabel obligatorio4;
    private javax.swing.JLabel obligatorio5;
    private javax.swing.JLabel obligatorio6;
    private javax.swing.JLabel obligatorio7;
    private javax.swing.JLabel obligatorio8;
    private javax.swing.JLabel obligatorioTexto;
    private javax.swing.JComboBox tipo_usr;
    private javax.swing.JLabel txtUsuarioNoDisponible;
    // End of variables declaration//GEN-END:variables

    /*public void buscarUsuarios() {
        ModeloTablaUsuarios m;

        m = (ModeloTablaUsuarios) TablaUsuarios.getModel();
        //m.setFilas(fa.obtenerUsuarios(buscaId.getText(), buscaNombre.getText()));     //Comentado para que no de error
        if (m.getRowCount() > 0) {
            TablaUsuarios.setRowSelectionInterval(0, 0);
            btnBorrar.setEnabled(true);
        } else {
            btnBorrar.setEnabled(false);
        }

    }*/
    public void registrarUsuario() {
        Integer tipoUser = tipo_usr.getSelectedIndex();
        String tipo = "PendAlta";
        int cont = 0;

        if (tipoUser == 0) {
            if (!btnUsuario.getText().isEmpty() && btnUsuario.getText().length() == 9 && fa.comprobarIdInversor(btnUsuario.getText()) == 0) {
                if (!btnClave1.getText().isEmpty() && !btnDireccion.getText().isEmpty() && !btnTelefono.getText().isEmpty() && !btnInversor.getText().isEmpty() && !btnApellido1.getText().isEmpty() && !btnApellido2.getText().isEmpty()) {
                    InversorUsuario iu;
                    iu = new InversorUsuario(btnUsuario.getText(), btnClave1.getText(), btnInversor.getText(), btnApellido1.getText(), btnApellido2.getText(), btnDireccion.getText(), btnTelefono.getText(), TipoUsuario.valueOf(tipo));
                    fa.insertarUsuarioInversor(iu);
                    this.dispose();
                }
            }
            if (fa.comprobarIdInversor(btnUsuario.getText()) != 0) {
                txtUsuarioNoDisponible.setEnabled(true);
            }
            if (btnUsuario.getText().length() != 9) {
                VAviso a = new VAviso("Longitud de DNI incorrecta.Tiene que ser 9 y has introducido " + btnUsuario.getText().length());
                a.setVisible(true);
            }
        } else {
            if (!btnUsuario.getText().isEmpty() && btnUsuario.getText().length() == 13 && fa.comprobarIdEmpresa(btnUsuario.getText()) == 0) {
                if (!btnClave1.getText().isEmpty() && !btnDireccion.getText().isEmpty() && !btnTelefono.getText().isEmpty() && !btnEmpresa.getText().isEmpty()) {
                    EmpresaUsuario eu;
                    eu = new EmpresaUsuario(btnUsuario.getText(), btnClave1.getText(), btnEmpresa.getText(), btnDireccion.getText(), btnTelefono.getText(), TipoUsuario.valueOf(tipo));
                    fa.insertarUsuarioEmpresa(eu);
                    this.dispose();
                }
            }
            if (fa.comprobarIdEmpresa(btnUsuario.getText()) != 0) {
                txtUsuarioNoDisponible.setEnabled(true);
            }
            if (btnUsuario.getText().length() != 13) {
                VAviso a = new VAviso("Longitud de NIF incorrecta.Tiene que ser 13 y has introducido " + btnUsuario.getText().length());
                a.setVisible(true);
            }
        }
    }
    
    public void actualizarDatos(){
        String tipo = "Normal";
        if(this.invu != null){
            /*this.invu.setNombre(btnInversor.getText());
            this.invu.setApellido1(btnApellido1.getText());
            this.invu.setApellido2(btnApellido2.getText());
            this.invu.setClave(btnClave1.getText());
            this.invu.setDireccion(btnDireccion.getText());
            this.invu.setTelefono(btnTelefono.getText());*/
            
            
            InversorUsuario inv = new InversorUsuario(btnUsuario.getText(), btnClave1.getText(), btnInversor.getText(), btnApellido1.getText(), btnApellido2.getText(), btnDireccion.getText(), btnTelefono.getText(), TipoUsuario.valueOf(tipo));
            fa.modificarUsuarioInversor(inv);
            /*btnClave1.setText(invu.getClave());
            btnDireccion.setText(invu.getDireccion());
            btnTelefono.setText(invu.getTelefono());
            btnApellido1.setText(invu.getApellido1());
            btnApellido2.setText(invu.getApellido2());
            btnInversor.setText(invu.getNombre());*/
        }
        
        else if(this.empu != null){
            this.empu.setNombreComercial(btnEmpresa.getText());
            this.empu.setClave(btnClave1.getText());
            this.empu.setDireccion(btnDireccion.getText());
            this.empu.setTelefono(btnTelefono.getText());
            
            EmpresaUsuario emp = new EmpresaUsuario(empu.getIdUsuario(), empu.getClave(), empu.getNombreComercial(), empu.getDireccion(), empu.getTelefono(), empu.getTipoUsuario());
            fa.modificarUsuarioEmpresa(empu);
            /*btnClave1.setText(empu.getClave());
            btnDireccion.setText(empu.getDireccion());
            btnEmpresa.setText(empu.getNombreComercial());
            btnTelefono.setText(empu.getTelefono());*/
        }
    }
}

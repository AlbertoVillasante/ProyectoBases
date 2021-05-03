/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import aplicacion.EmpresaUsuario;
import aplicacion.FachadaAplicacion;
import aplicacion.InversorUsuario;
import aplicacion.OfertaParticipaciones;
import java.awt.Color;
import static java.lang.Float.parseFloat;
import static java.lang.Integer.parseInt;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Locale;
import javax.swing.JPanel;

/**
 *
 * @author alumnogreibd
 */
public class VParticipaciones extends javax.swing.JDialog {

    aplicacion.FachadaAplicacion fa;
    Color prueba = new Color(60, 63, 65);
    Color prueba1 = new Color(78, 82, 85);
    EmpresaUsuario eu;
    InversorUsuario iu;
    VAviso va;

    /**
     * Creates new form VParticipaciones
     */
    public VParticipaciones(aplicacion.FachadaAplicacion fa, EmpresaUsuario eu, InversorUsuario iu) {
        initComponents();
        colores();

        if (eu != null) {
            carteraText.setText(String.valueOf(eu.getnParticipaciones()));
            this.eu = eu;
            partBloqText.setVisible(true);
            jLabel8.setVisible(true);
        } else {
            participacionesPanel.setSelectedIndex(1);
            participacionesPanel.setEnabled(false);
            partBloqText.setVisible(false);
            jLabel8.setVisible(false);
            this.iu = iu;
        }

        ArrayList<String> empresas = fa.getEmpresas(); //cogemos todas las empresas
        for (String e : empresas) {
            btnEmpresas.addItem(e);
        }
        this.fa = fa;

        mostrarVentas();

        if (eu != null) {
            saldoText.setText(String.valueOf(convertir(eu.getFondosDisponiblesCuenta())));
            comisionText.setText(String.valueOf(eu.getComision()));
        } else {
            saldoText.setText(String.valueOf(convertir(iu.getFondosDisponiblesCuenta())));
            comisionText.setText(String.valueOf(iu.getComision()));
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        buttonGroup4 = new javax.swing.ButtonGroup();
        buttonGroup5 = new javax.swing.ButtonGroup();
        buttonGroup6 = new javax.swing.ButtonGroup();
        buttonGroup7 = new javax.swing.ButtonGroup();
        buttonGroup8 = new javax.swing.ButtonGroup();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        participacionesPanel = new javax.swing.JTabbedPane();
        altabajaPanel = new javax.swing.JPanel();
        carteraLabel = new javax.swing.JLabel();
        numeroLabel = new javax.swing.JLabel();
        carteraText = new javax.swing.JTextField();
        numeroText = new javax.swing.JTextField();
        aceptarButton1 = new javax.swing.JButton();
        msjObligatorio = new java.awt.Label();
        msNoParticipaciones = new java.awt.Label();
        Alta = new javax.swing.JRadioButton();
        Baja = new javax.swing.JRadioButton();
        compraventaPanel = new javax.swing.JPanel();
        saldoLabel = new javax.swing.JLabel();
        saldoText = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btnEmpresas = new javax.swing.JComboBox();
        selectorCV = new javax.swing.JComboBox();
        nparticipacionesLabel = new javax.swing.JLabel();
        nParticipacionesText = new javax.swing.JTextField();
        precioLabel = new javax.swing.JLabel();
        comisionLabel = new javax.swing.JLabel();
        comisionText = new javax.swing.JTextField();
        precioText = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaParticipacionesVenta = new javax.swing.JTable();
        aceptarButton = new javax.swing.JButton();
        buscarButton = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        partPropText = new javax.swing.JTextField();
        partBloqText = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        eliminarBtn = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane3.setViewportView(jTextArea1);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        participacionesPanel.setForeground(new java.awt.Color(187, 187, 188));

        carteraLabel.setForeground(new java.awt.Color(187, 187, 188));
        carteraLabel.setText("Cartera de participaciones:");

        numeroLabel.setForeground(new java.awt.Color(187, 187, 188));
        numeroLabel.setText("Número de participaciones:");

        carteraText.setForeground(new java.awt.Color(187, 187, 188));
        carteraText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                carteraTextActionPerformed(evt);
            }
        });

        numeroText.setForeground(new java.awt.Color(187, 187, 188));
        numeroText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                numeroTextActionPerformed(evt);
            }
        });

        aceptarButton1.setForeground(new java.awt.Color(187, 187, 188));
        aceptarButton1.setText("Aceptar");
        aceptarButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aceptarButton1ActionPerformed(evt);
            }
        });

        msjObligatorio.setForeground(new java.awt.Color(255, 0, 0));
        msjObligatorio.setText("Rellena los campos obligatorios (*)");

        msNoParticipaciones.setForeground(new java.awt.Color(255, 0, 0));
        msNoParticipaciones.setText("No dispones de ese número de participaciones*");

        Alta.setForeground(new java.awt.Color(187, 187, 188));
        Alta.setText("Alta");
        Alta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AltaActionPerformed(evt);
            }
        });

        Baja.setForeground(new java.awt.Color(187, 187, 188));
        Baja.setText("Baja");
        Baja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BajaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout altabajaPanelLayout = new javax.swing.GroupLayout(altabajaPanel);
        altabajaPanel.setLayout(altabajaPanelLayout);
        altabajaPanelLayout.setHorizontalGroup(
            altabajaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(altabajaPanelLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(altabajaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(altabajaPanelLayout.createSequentialGroup()
                        .addGroup(altabajaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(numeroLabel)
                            .addComponent(carteraLabel))
                        .addGap(18, 18, 18)
                        .addGroup(altabajaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(carteraText)
                            .addComponent(numeroText, javax.swing.GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE))
                        .addGap(316, 316, 316))
                    .addGroup(altabajaPanelLayout.createSequentialGroup()
                        .addComponent(msjObligatorio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(aceptarButton1)
                        .addGap(41, 41, 41))
                    .addGroup(altabajaPanelLayout.createSequentialGroup()
                        .addGroup(altabajaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(msNoParticipaciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(altabajaPanelLayout.createSequentialGroup()
                                .addComponent(Alta, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31)
                                .addComponent(Baja)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        altabajaPanelLayout.setVerticalGroup(
            altabajaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(altabajaPanelLayout.createSequentialGroup()
                .addContainerGap(111, Short.MAX_VALUE)
                .addGroup(altabajaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(carteraLabel)
                    .addComponent(carteraText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(altabajaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(numeroLabel)
                    .addComponent(numeroText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(msNoParticipaciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(altabajaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Alta, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Baja, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(altabajaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(aceptarButton1)
                    .addComponent(msjObligatorio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38))
        );

        participacionesPanel.addTab("alta / baja", altabajaPanel);

        saldoLabel.setForeground(new java.awt.Color(187, 187, 188));
        saldoLabel.setText("saldo:");

        saldoText.setEditable(false);
        saldoText.setForeground(new java.awt.Color(187, 187, 188));
        saldoText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saldoTextActionPerformed(evt);
            }
        });

        jLabel1.setForeground(new java.awt.Color(187, 187, 188));
        jLabel1.setText("€ ");

        btnEmpresas.setForeground(new java.awt.Color(187, 187, 188));
        btnEmpresas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEmpresasMouseClicked(evt);
            }
        });
        btnEmpresas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEmpresasActionPerformed(evt);
            }
        });

        selectorCV.setForeground(new java.awt.Color(187, 187, 188));
        selectorCV.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Comprar", "Vender" }));
        selectorCV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectorCVActionPerformed(evt);
            }
        });

        nparticipacionesLabel.setForeground(new java.awt.Color(187, 187, 188));
        nparticipacionesLabel.setText("Número de participaciones:");

        nParticipacionesText.setForeground(new java.awt.Color(187, 187, 188));
        nParticipacionesText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nParticipacionesTextActionPerformed(evt);
            }
        });

        precioLabel.setForeground(new java.awt.Color(187, 187, 188));
        precioLabel.setText("Precio:");

        comisionLabel.setForeground(new java.awt.Color(187, 187, 188));
        comisionLabel.setText("Comisión:");

        comisionText.setEditable(false);
        comisionText.setForeground(new java.awt.Color(187, 187, 188));

        precioText.setForeground(new java.awt.Color(187, 187, 188));
        precioText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                precioTextActionPerformed(evt);
            }
        });

        jLabel2.setForeground(new java.awt.Color(187, 187, 188));
        jLabel2.setText("€ ");

        jLabel3.setForeground(new java.awt.Color(187, 187, 188));
        jLabel3.setText("%");

        tablaParticipacionesVenta.setForeground(new java.awt.Color(187, 187, 188));
        tablaParticipacionesVenta.setModel(new ModeloTablaParticipaciones());
        tablaParticipacionesVenta.setSelectionForeground(new java.awt.Color(187, 187, 188));
        jScrollPane2.setViewportView(tablaParticipacionesVenta);

        aceptarButton.setForeground(new java.awt.Color(187, 187, 188));
        aceptarButton.setText("Aceptar");
        aceptarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aceptarButtonActionPerformed(evt);
            }
        });

        buscarButton.setForeground(new java.awt.Color(187, 187, 188));
        buscarButton.setText("Buscar");
        buscarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarButtonActionPerformed(evt);
            }
        });

        jLabel4.setForeground(new java.awt.Color(255, 51, 51));
        jLabel4.setText("Rellena los campos obligatorios *");

        jLabel5.setForeground(new java.awt.Color(187, 187, 188));
        jLabel5.setText("Participaciones en propiedad:");

        partPropText.setEditable(false);
        partPropText.setForeground(new java.awt.Color(187, 187, 188));
        partPropText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                partPropTextActionPerformed(evt);
            }
        });

        partBloqText.setEditable(false);
        partBloqText.setForeground(new java.awt.Color(187, 187, 188));
        partBloqText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                partBloqTextActionPerformed(evt);
            }
        });

        jLabel6.setForeground(new java.awt.Color(255, 51, 51));
        jLabel6.setText("*");

        jLabel7.setForeground(new java.awt.Color(255, 51, 51));
        jLabel7.setText("*");

        jLabel8.setForeground(new java.awt.Color(187, 187, 188));
        jLabel8.setText("Participaciones bloqueadas:  ");

        eliminarBtn.setForeground(new java.awt.Color(187, 187, 188));
        eliminarBtn.setText("Eliminar");
        eliminarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout compraventaPanelLayout = new javax.swing.GroupLayout(compraventaPanel);
        compraventaPanel.setLayout(compraventaPanelLayout);
        compraventaPanelLayout.setHorizontalGroup(
            compraventaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(compraventaPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(compraventaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(compraventaPanelLayout.createSequentialGroup()
                        .addGroup(compraventaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 7, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 7, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(compraventaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(compraventaPanelLayout.createSequentialGroup()
                                .addGroup(compraventaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(aceptarButton)
                                    .addGroup(compraventaPanelLayout.createSequentialGroup()
                                        .addComponent(precioLabel)
                                        .addGap(32, 32, 32)
                                        .addComponent(precioText, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(compraventaPanelLayout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(saldoLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(saldoText, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel1))
                            .addGroup(compraventaPanelLayout.createSequentialGroup()
                                .addComponent(comisionLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(comisionText, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel3))
                            .addGroup(compraventaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(btnEmpresas, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(selectorCV, javax.swing.GroupLayout.Alignment.LEADING, 0, 112, Short.MAX_VALUE))
                            .addGroup(compraventaPanelLayout.createSequentialGroup()
                                .addGroup(compraventaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(nparticipacionesLabel)
                                    .addComponent(jLabel8))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(compraventaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(partPropText, javax.swing.GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE)
                                    .addComponent(partBloqText)
                                    .addComponent(nParticipacionesText)))))
                    .addComponent(jLabel4))
                .addGap(27, 27, 27)
                .addGroup(compraventaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(compraventaPanelLayout.createSequentialGroup()
                        .addComponent(buscarButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(eliminarBtn)))
                .addGap(38, 38, 38))
        );
        compraventaPanelLayout.setVerticalGroup(
            compraventaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(compraventaPanelLayout.createSequentialGroup()
                .addGroup(compraventaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(compraventaPanelLayout.createSequentialGroup()
                        .addGroup(compraventaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(compraventaPanelLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(compraventaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(saldoText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, compraventaPanelLayout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(saldoLabel)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(selectorCV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnEmpresas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(compraventaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(partPropText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(compraventaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(partBloqText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addGap(18, 18, 18)
                        .addGroup(compraventaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, compraventaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(nparticipacionesLabel)
                                .addComponent(nParticipacionesText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(compraventaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, compraventaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(precioLabel)
                                .addComponent(jLabel6))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, compraventaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(precioText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel2)))
                        .addGap(18, 18, 18)
                        .addGroup(compraventaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(comisionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comisionText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(11, 11, 11)
                        .addComponent(aceptarButton)
                        .addGap(12, 12, 12)
                        .addComponent(jLabel4))
                    .addGroup(compraventaPanelLayout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(compraventaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(buscarButton)
                            .addComponent(eliminarBtn))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        participacionesPanel.addTab("compra / venta", compraventaPanel);

        btnSalir.setBackground(new java.awt.Color(180, 22, 45));
        btnSalir.setForeground(new java.awt.Color(0, 0, 0));
        btnSalir.setLabel("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(participacionesPanel)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSalir)
                .addGap(53, 53, 53))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(participacionesPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSalir)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        participacionesPanel.getAccessibleContext().setAccessibleName("Compra / Venta");

        getAccessibleContext().setAccessibleName("altabajaPanel");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buscarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buscarButtonActionPerformed

    private void precioTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_precioTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_precioTextActionPerformed

    private void nParticipacionesTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nParticipacionesTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nParticipacionesTextActionPerformed

    private void btnEmpresasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEmpresasActionPerformed

        if (selectorCV.getSelectedIndex() == 1) { //Vender
            actualizarPartBloq(iu, eu);
        }

    }//GEN-LAST:event_btnEmpresasActionPerformed

    private void saldoTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saldoTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_saldoTextActionPerformed

    private void carteraTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_carteraTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_carteraTextActionPerformed

    private void numeroTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_numeroTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_numeroTextActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void AltaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AltaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AltaActionPerformed

    private void BajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BajaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BajaActionPerformed

    private void aceptarButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aceptarButton1ActionPerformed
        if (Alta.isSelected()) {
            fa.altaParticipacionesEmpresa(Integer.parseInt(numeroText.getText()), eu.getIdUsuario());
            eu.setnParticipaciones(eu.getnParticipaciones() + Integer.parseInt(numeroText.getText()));
            carteraText.setText(String.valueOf(eu.getnParticipaciones()));
        } else if (Baja.isSelected()) {
            if (Integer.parseInt(carteraText.getText()) - Integer.parseInt(numeroText.getText()) >= 0) {
                fa.bajaParticipacionesEmpresa(Integer.parseInt(numeroText.getText()), eu.getIdUsuario());
                eu.setnParticipaciones(eu.getnParticipaciones() - Integer.parseInt(numeroText.getText()));
                carteraText.setText(String.valueOf(eu.getnParticipaciones()));
            } else {
                va  = new VAviso("No dispone de ese número de participaciones");
                va.setVisible(true);
            }
        }
        numeroText.setText("");
        //this.dispose();
    }//GEN-LAST:event_aceptarButton1ActionPerformed

    private void selectorCVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectorCVActionPerformed
        int selec = selectorCV.getSelectedIndex(), part = 0;
        btnEmpresas.removeAllItems();
        ArrayList<String> empresas;

        if (selec == 0) { //Comprar
            for (String i : fa.getEmpresas()) {//cogemos todas las empresas
                btnEmpresas.addItem(i);
            }

        } else { //Vender

            nParticipacionesText.setText("");
            precioText.setText("");

            if (eu != null) {
                empresas = fa.getEmpresasEmpr(eu.getIdUsuario());
                if (!empresas.isEmpty()) {
                    for (String i : empresas) {
                        btnEmpresas.addItem(i);
                    }

                    part = fa.numParticipacionesEmprEmpr(eu.getIdUsuario(), fa.getIdEmpresa(btnEmpresas.getSelectedItem().toString()));
                    partPropText.setText(String.valueOf(part));
                }

            } else {
                empresas = fa.getEmpresasInv(iu.getIdUsuario());
                if (!empresas.isEmpty()) {
                    for (String i : empresas) {
                        btnEmpresas.addItem(i);
                    }

                    part = fa.numParticipacionesInvEmpr(iu.getIdUsuario(), fa.getIdEmpresa(btnEmpresas.getSelectedItem().toString()));
                    partPropText.setText(String.valueOf(part));
                }
            }

            if (btnEmpresas.getItemCount() > 0) {
                aceptarButton.setEnabled(true);
            } else {
                aceptarButton.setEnabled(false);
            }
        }
    }//GEN-LAST:event_selectorCVActionPerformed

    private void aceptarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aceptarButtonActionPerformed
        if (nParticipacionesText.getText().isEmpty() && precioText.getText().isEmpty()) {
            jLabel4.setVisible(true);
            jLabel6.setVisible(true);
            jLabel7.setVisible(true);
        } else {
            jLabel4.setVisible(false);
            if (selectorCV.getSelectedIndex() == 0) { //Comprar
                compraParticipaciones();
            } else {
                vender();
                mostrarVentas();
                actualizarPartBloq(iu, eu);
                nParticipacionesText.setText("");
                precioText.setText("");
            }
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_aceptarButtonActionPerformed

    private void partPropTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_partPropTextActionPerformed

// TODO add your handling code here:
    }//GEN-LAST:event_partPropTextActionPerformed

    private void btnEmpresasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEmpresasMouseClicked

        // TODO add your handling code here:
    }//GEN-LAST:event_btnEmpresasMouseClicked

    private void partBloqTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_partBloqTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_partBloqTextActionPerformed

    private void eliminarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarBtnActionPerformed
        eliminar();
        mostrarVentas();
        // TODO add your handling code here:
    }//GEN-LAST:event_eliminarBtnActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton Alta;
    private javax.swing.JRadioButton Baja;
    private javax.swing.JButton aceptarButton;
    private javax.swing.JButton aceptarButton1;
    private javax.swing.JPanel altabajaPanel;
    private javax.swing.JComboBox btnEmpresas;
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton buscarButton;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.ButtonGroup buttonGroup4;
    private javax.swing.ButtonGroup buttonGroup5;
    private javax.swing.ButtonGroup buttonGroup6;
    private javax.swing.ButtonGroup buttonGroup7;
    private javax.swing.ButtonGroup buttonGroup8;
    private javax.swing.JLabel carteraLabel;
    private javax.swing.JTextField carteraText;
    private javax.swing.JLabel comisionLabel;
    private javax.swing.JTextField comisionText;
    private javax.swing.JPanel compraventaPanel;
    private javax.swing.JButton eliminarBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea jTextArea1;
    private java.awt.Label msNoParticipaciones;
    private java.awt.Label msjObligatorio;
    private javax.swing.JTextField nParticipacionesText;
    private javax.swing.JLabel nparticipacionesLabel;
    private javax.swing.JLabel numeroLabel;
    private javax.swing.JTextField numeroText;
    private javax.swing.JTextField partBloqText;
    private javax.swing.JTextField partPropText;
    private javax.swing.JTabbedPane participacionesPanel;
    private javax.swing.JLabel precioLabel;
    private javax.swing.JTextField precioText;
    private javax.swing.JLabel saldoLabel;
    private javax.swing.JTextField saldoText;
    private javax.swing.JComboBox selectorCV;
    private javax.swing.JTable tablaParticipacionesVenta;
    // End of variables declaration//GEN-END:variables

    public void mostrarVentas() {
        int selec = selectorCV.getSelectedIndex(), i;
        ModeloTablaParticipaciones m;
        m = (ModeloTablaParticipaciones) tablaParticipacionesVenta.getModel();
        m.setFilas(fa.mostrarVentas());

        if (m.getRowCount() > 0) {
            tablaParticipacionesVenta.setRowSelectionInterval(0, 0);
            aceptarButton.setEnabled(true);
            if (selec == 0) { //Comprar
                i = tablaParticipacionesVenta.getSelectedRow();
                OfertaParticipaciones v = m.obtenerVenta(i);
                nParticipacionesText.setText(String.valueOf(v.getNumeroParticipaciones()));
                precioText.setText(String.valueOf(v.getPrecioParticipacion()));
            } else { //Vender

            }

        } else {
            if (selec == 0) { //Comprar
                aceptarButton.setEnabled(false);
            } else if (btnEmpresas.getItemCount() > 0) { //Vender
                aceptarButton.setEnabled(true);
            }
        }
    }

    public void vender() {
        int i;
        String id = null;
        i = btnEmpresas.getSelectedIndex();
        VAviso avisoVenta = new VAviso("¡No puedes vender más!");

        if (iu != null) {
            OfertaParticipaciones v = new OfertaParticipaciones(parseFloat(precioText.getText()), parseInt(nParticipacionesText.getText()), fa.getIdEmpresa(btnEmpresas.getItemAt(i).toString()), iu.getIdUsuario());
            if (fa.comprobarParticipacionesInversor(v)) {
                fa.ofertaVentaInv(v);

            } else {
                avisoVenta.setVisible(true);
            }

        } else {
            OfertaParticipaciones v = new OfertaParticipaciones(parseFloat(precioText.getText()), parseInt(nParticipacionesText.getText()), fa.getIdEmpresa(btnEmpresas.getItemAt(i).toString()), eu.getIdUsuario());
            if (fa.comprobarParticipacionesEmpresa(v)) {
                fa.ofertaVentaEmpr(v);
            } else {
                avisoVenta.setVisible(true);
            }

        }

    }

    public static String convertir(double val) {
        Locale.setDefault(Locale.US);
        DecimalFormat num = new DecimalFormat("#,###.00");
        return num.format(val);
    }

    public void actualizarPartBloq(InversorUsuario iu, EmpresaUsuario eu) {
        int part;
        if (btnEmpresas.getItemAt(btnEmpresas.getSelectedIndex()) != null) {
            if (eu != null) {
                part = fa.numParticipacionesEmprEmpr(eu.getIdUsuario(), fa.getIdEmpresa(btnEmpresas.getSelectedItem().toString()));
                partPropText.setText(String.valueOf(part));
                partBloqText.setText(String.valueOf(fa.partEmprBloq(eu.getIdUsuario(), fa.getIdEmpresa(btnEmpresas.getSelectedItem().toString()))));
            } else {
                part = fa.numParticipacionesInvEmpr(iu.getIdUsuario(), fa.getIdEmpresa(btnEmpresas.getSelectedItem().toString()));
                partPropText.setText(String.valueOf(part));
                partBloqText.setText(String.valueOf(fa.partInvBloq(iu.getIdUsuario(), fa.getIdEmpresa(btnEmpresas.getSelectedItem().toString()))));
            }
        }
    }

    public void eliminar() {
        int i;
        ModeloTablaParticipaciones m;
        m = (ModeloTablaParticipaciones) tablaParticipacionesVenta.getModel();
        i = tablaParticipacionesVenta.getSelectedRow();
        OfertaParticipaciones v = m.obtenerVenta(i);
        VAviso eliminarOfertas = new VAviso("¡No puedes eliminar ofertas que no sean de tu propiedad!");

        if (iu != null) {
            if (iu.getIdUsuario().equals(v.getIdUsuario1())) {
                fa.borrarVentaInv(v);
            } else {
                eliminarOfertas.setVisible(true);
            }

        } else {
            if (eu.getIdUsuario().equals(v.getIdUsuario1())) {
                fa.borrarVentaEmpr(v);
            } else {
                eliminarOfertas.setVisible(true);
            }
        }
    }

    public void compraParticipaciones() {

        //Se utilizará esta variable para llevar la cuenta de las participaciones que faltan por comprar:
        Integer participacionesRestantes = Integer.parseInt(nParticipacionesText.getText());
        Double precio = Double.parseDouble(precioText.getText());
        Integer ofertasRestantes;
        OfertaParticipaciones oferta;
        String idEmpresa = fa.getIdEmpresa(btnEmpresas.getSelectedItem().toString());

        if (eu != null) {
            if (fa.getnombreEmpresa(eu.getIdUsuario()).equals(idEmpresa)) {
                VAviso vnoticia;
                vnoticia = new VAviso("No puedes comprar participaciones de tu propia empresa");
                vnoticia.setVisible(true);

            } else {
                //En primer lugar comprobamos si la empresa tiene el dinero suficiente para comprar las participaciones que quiere:
                if (participacionesRestantes * precio > eu.getFondosDisponiblesCuenta()) {

                    VAviso vnoticia;
                    vnoticia = new VAviso("El precio y numero de participaciones introducido es incompatible con la cantidad de dinero que posee");
                    vnoticia.setVisible(true);

                } else {
                    ofertasRestantes = fa.contarOfertas(idEmpresa, precio); //Relleno el número de ofertas que cumplan lo que pido
                    if (ofertasRestantes == 0) {

                        VAviso vofertas;
                        vofertas = new VAviso("No hay ofertas disponibles con esas características");
                        vofertas.setVisible(true);

                    } else {

                        //mientras me quede dinero sigo comprando las más baratas o queden participaciones que pueda comprar con el dinero indicado
                        while (participacionesRestantes > 0 && ofertasRestantes > 0) {

                            oferta = fa.getOfertaParticipaciones(idEmpresa, precio); //saco la primera
                            oferta.setComision(eu.getComision());

                            if (oferta.getNumeroParticipaciones() <= participacionesRestantes) {

                                /*=============================================================================================================
                                Esta funcion :
                                1- tiene como return el número de participaciones totales ya que como se quitan todas se puede hacer
                                2- recibe como argumentos el usuario y  la oferta.
                                3- borra la oferta de la tabla
                                4- se las mete al otro.
                                5- actualiza el dinero de las dos tablas.
                                6- le da el dinero al regulador.
                            ==============================================================================================================*/
                                participacionesRestantes -= fa.moverParticipacionesTodas(eu.getIdUsuario(), oferta);

                            } else {

                                fa.moverParticipacionesParciales(oferta, eu.getIdUsuario(), participacionesRestantes);
                                participacionesRestantes = 0;

                            }
                            ofertasRestantes--;
                        }
                    }
                }
            }
        } else {
            //En primer lugar comprobamos si la empresa tiene el dinero suficiente para comprar las participaciones que quiere:
            if (participacionesRestantes * precio > iu.getFondosDisponiblesCuenta()) {

                VAviso vnoticia;
                vnoticia = new VAviso("El precio y numero de participaciones introducido es incompatible con la cantidad de dinero que posee");
                vnoticia.setVisible(true);

            } else {

                ofertasRestantes = fa.contarOfertas(idEmpresa, precio); //Relleno el número de ofertas que cumplan lo que pido

                if (ofertasRestantes == 0) {

                    VAviso vofertas;
                    vofertas = new VAviso("No hay ofertas disponibles con esas características");
                    vofertas.setVisible(true);

                } else {

                    while (participacionesRestantes > 0 && ofertasRestantes > 0) {

                        oferta = fa.getOfertaParticipaciones(idEmpresa, precio); //saco la primera
                        oferta.setComision(iu.getComision());

                        if (oferta.getNumeroParticipaciones() <= participacionesRestantes) {

                            participacionesRestantes -= fa.moverParticipacionesTodas(iu.getIdUsuario(), oferta);

                        } else {

                            fa.moverParticipacionesParciales(oferta, iu.getIdUsuario(), participacionesRestantes);
                            participacionesRestantes = 0;

                        }
                        ofertasRestantes--;
                    }

                }
            }
        }
        VAvisoCorrecto compraEfectuada = new VAvisoCorrecto("Compra realizada con éxito");
        compraEfectuada.setVisible(true);
    }

    private void colores() {
        this.getContentPane().setBackground(prueba);
        saldoText.setBackground(prueba1);
        selectorCV.setBackground(prueba1);
        btnEmpresas.setBackground(prueba1);
        nParticipacionesText.setBackground(prueba1);
        partPropText.setBackground(prueba1);
        partBloqText.setBackground(prueba1);
        precioText.setBackground(prueba1);
        comisionText.setBackground(prueba1);
        carteraText.setBackground(prueba1);
        carteraText.setEditable(false);
        numeroText.setBackground(prueba1);
        msNoParticipaciones.setBackground(prueba);
        msjObligatorio.setBackground(prueba);
        buscarButton.setBackground(prueba1);
        eliminarBtn.setBackground(prueba1);
        Alta.setBackground(prueba);
        Baja.setBackground(prueba);
        aceptarButton.setBackground(prueba1);
        aceptarButton1.setBackground(prueba1);
        compraventaPanel.setBackground(prueba);
        altabajaPanel.setBackground(prueba);
        tablaParticipacionesVenta.setBackground(prueba1);
        tablaParticipacionesVenta.setSelectionBackground(prueba1);
        participacionesPanel.setBackgroundAt(0, prueba);
        participacionesPanel.setBackgroundAt(1, prueba);
        buttonGroup8.add(Baja);
        buttonGroup8.add(Alta);
        jLabel4.setVisible(false);
        jLabel6.setVisible(false);
        jLabel7.setVisible(false);
    }

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.metodos.licencias.view;


/**
 *
 * @author valec
 */
public class InfoTitular extends javax.swing.JPanel {

    /**
     * Creates new form Usuarios
     */
    
    private int cornerRadius;
    
    public InfoTitular() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new RoundedPanel(30);
        Alta_titular_apellido = new javax.swing.JTextField();
        Alta_titular_nombre = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        Alta_titular_numerodni = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        Alta_titular_gruposanguineo = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        Alta_titular_fechanac = new com.toedter.calendar.JDateChooser();
        jLabel6 = new javax.swing.JLabel();
        Alta_titular_esdonante = new javax.swing.JCheckBox();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        Alta_titular_calle = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        Alta_titular_altura = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        Alta_titular_tipodni = new javax.swing.JComboBox<>();
        Alta_titular_guardarBtn = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        jPanel2 = new RoundedPanel(30);
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setBackground(new java.awt.Color(153, 153, 153));
        setForeground(new java.awt.Color(51, 51, 51));
        setPreferredSize(new java.awt.Dimension(1200, 620));
        setLayout(new java.awt.GridBagLayout());

        jPanel1.setBackground(new java.awt.Color(252, 252, 252));
        jPanel1.setPreferredSize(new java.awt.Dimension(0, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Alta_titular_apellido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Alta_titular_apellidoActionPerformed(evt);
            }
        });
        jPanel1.add(Alta_titular_apellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 90, 170, 40));

        Alta_titular_nombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Alta_titular_nombreActionPerformed(evt);
            }
        });
        jPanel1.add(Alta_titular_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 170, 40));

        jLabel1.setText("Apellido");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 70, 70, -1));

        Alta_titular_numerodni.setToolTipText("");
        Alta_titular_numerodni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Alta_titular_numerodniActionPerformed(evt);
            }
        });
        jPanel1.add(Alta_titular_numerodni, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 160, 170, 40));

        jLabel3.setText("Tipo DNI");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, -1, -1));

        jLabel4.setText("Número DNI");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 140, 90, -1));

        Alta_titular_gruposanguineo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(Alta_titular_gruposanguineo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, 170, 40));

        jLabel5.setText("Fecha Nacimiento");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 210, 120, -1));

        Alta_titular_fechanac.setBackground(new java.awt.Color(220, 220, 220));
        jPanel1.add(Alta_titular_fechanac, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 230, 170, 40));

        jLabel6.setText("Grupo Sanguíneo");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, -1, -1));

        Alta_titular_esdonante.setText("Es donante de órganos");
        Alta_titular_esdonante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Alta_titular_esdonanteActionPerformed(evt);
            }
        });
        jPanel1.add(Alta_titular_esdonante, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 300, 170, -1));

        jLabel7.setText("Nombre");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, -1, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("Datos Personales");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, -1, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setText("Dirección");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 350, -1, -1));

        Alta_titular_calle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Alta_titular_calleActionPerformed(evt);
            }
        });
        jPanel1.add(Alta_titular_calle, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 400, 170, 40));

        jLabel11.setText("Calle");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 380, -1, -1));

        Alta_titular_altura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Alta_titular_alturaActionPerformed(evt);
            }
        });
        jPanel1.add(Alta_titular_altura, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 400, 170, 40));

        jLabel12.setText("Altura");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 380, 60, -1));

        Alta_titular_tipodni.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(Alta_titular_tipodni, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 170, 40));

        Alta_titular_guardarBtn.setBackground(new java.awt.Color(0, 153, 204));
        Alta_titular_guardarBtn.setText("Editar");
        jPanel1.add(Alta_titular_guardarBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 550, 120, 40));

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel18.setText("Información del titular");
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.4;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        add(jPanel1, gridBagConstraints);

        jPanel2.setBackground(new java.awt.Color(252, 252, 252));
        jPanel2.setPreferredSize(new java.awt.Dimension(0, 0));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("Licencias solicitadas");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Apellido", "Tipo DNI", "Numero DNI", "Clase", "Grupo Sanguineo", "Donante"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 87, 630, 490));

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.6;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 10, 10);
        add(jPanel2, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void Alta_titular_apellidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Alta_titular_apellidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Alta_titular_apellidoActionPerformed

    private void Alta_titular_nombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Alta_titular_nombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Alta_titular_nombreActionPerformed

    private void Alta_titular_numerodniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Alta_titular_numerodniActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Alta_titular_numerodniActionPerformed

    private void Alta_titular_esdonanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Alta_titular_esdonanteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Alta_titular_esdonanteActionPerformed

    private void Alta_titular_calleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Alta_titular_calleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Alta_titular_calleActionPerformed

    private void Alta_titular_alturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Alta_titular_alturaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Alta_titular_alturaActionPerformed
    
 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Alta_titular_altura;
    private javax.swing.JTextField Alta_titular_apellido;
    private javax.swing.JTextField Alta_titular_calle;
    private javax.swing.JCheckBox Alta_titular_esdonante;
    public com.toedter.calendar.JDateChooser Alta_titular_fechanac;
    private javax.swing.JComboBox<String> Alta_titular_gruposanguineo;
    private javax.swing.JButton Alta_titular_guardarBtn;
    private javax.swing.JTextField Alta_titular_nombre;
    private javax.swing.JTextField Alta_titular_numerodni;
    private javax.swing.JComboBox<String> Alta_titular_tipodni;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
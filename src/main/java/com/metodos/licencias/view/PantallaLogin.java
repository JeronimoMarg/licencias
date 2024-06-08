/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.metodos.licencias.view;

import com.metodos.licencias.DTO.UsuarioDTO;
import com.metodos.licencias.controller.UsuariosController;
import com.metodos.licencias.logic.Rol;
import java.awt.Color;

import org.springframework.stereotype.Component;

/**
 *
 * @author valec
 */
@Component
public class PantallaLogin extends javax.swing.JPanel {

    /**
     * Creates new form Usuarios
     */
    
    private int cornerRadius;
    private Color grisOscuro = new Color(80,80,80);
    
    public PantallaLogin() {
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
        login_usuario = new RoundedTextField(15, grisOscuro);
        jLabel11 = new javax.swing.JLabel();
        login_contrasenia = new RoundedTextField(15,grisOscuro);
        jLabel12 = new javax.swing.JLabel();
        login_ingresarBtn = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        login_mostrarContraseñaCB = new javax.swing.JCheckBox();

        setBackground(new java.awt.Color(153, 153, 153));
        setForeground(new java.awt.Color(51, 51, 51));
        setPreferredSize(new java.awt.Dimension(1200, 620));
        setLayout(new java.awt.GridBagLayout());

        jPanel1.setBackground(new java.awt.Color(252, 252, 252));
        jPanel1.setPreferredSize(new java.awt.Dimension(0, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        login_usuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                login_usuarioActionPerformed(evt);
            }
        });
        jPanel1.add(login_usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 200, 370, 40));

        jLabel11.setText("Usuario");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 180, -1, -1));

        login_contrasenia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                login_contraseniaActionPerformed(evt);
            }
        });
        jPanel1.add(login_contrasenia, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 280, 370, 40));

        jLabel12.setText("Contraseña");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 260, 60, -1));

        login_ingresarBtn.setBackground(new java.awt.Color(0, 153, 204));
        login_ingresarBtn.setText("Ingresar");
        login_ingresarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                login_ingresarBtnActionPerformed(evt);
            }
        });
        jPanel1.add(login_ingresarBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 380, 370, 40));

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel18.setText("Inicia sesión");
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 130, -1, -1));

        login_mostrarContraseñaCB.setText("Mostrar contraseña");
        login_mostrarContraseñaCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                login_mostrarContraseñaCBActionPerformed(evt);
            }
        });
        jPanel1.add(login_mostrarContraseñaCB, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 340, -1, -1));

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.4;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        add(jPanel1, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void login_usuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_login_usuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_login_usuarioActionPerformed

    private void login_contraseniaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_login_contraseniaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_login_contraseniaActionPerformed

    private void login_ingresarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_login_ingresarBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_login_ingresarBtnActionPerformed

    private void login_mostrarContraseñaCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_login_mostrarContraseñaCBActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_login_mostrarContraseñaCBActionPerformed
    
 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField login_contrasenia;
    private javax.swing.JButton login_ingresarBtn;
    private javax.swing.JCheckBox login_mostrarContraseñaCB;
    private javax.swing.JTextField login_usuario;
    // End of variables declaration//GEN-END:variables

    public void addSaveButtonListener(UsuariosController.SaveButtonListener saveButtonListener) {
        login_ingresarBtn.addActionListener(saveButtonListener);
    }
    
    
    public void nombreUsuarioExistente(String mensajeError){
        //ventana emergente error
        VentanaEmergente ventanaEmergente = new VentanaEmergente(mensajeError);
        ventanaEmergente.setVisible(true);
        //cambiar borde a rojo
        ((RoundedTextField)login_usuario).setBorderColor(Color.RED);
    }

        
    public void ventanaError(String message) {
        //ventana emergente con confirmacion
        VentanaEmergente ventanaEmergente = new VentanaEmergente(message);
        ventanaEmergente.setVisible(true);
    }
    
}

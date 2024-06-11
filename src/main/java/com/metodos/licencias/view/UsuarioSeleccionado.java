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
public class UsuarioSeleccionado extends javax.swing.JPanel {

    /**
     * Creates new form Usuarios
     */
    
    private int cornerRadius;
    private Color grisOscuro = new Color(80,80,80);
    private UsuariosMain main;
    
    public UsuarioSeleccionado() {
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
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        Alta_usuario_usuario = new RoundedTextField(15, grisOscuro);
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        Alta_usuario_tipodni = new javax.swing.JComboBox<>();
        Busqueda_usuario_guardarBtn = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        Alta_usuario_numerodni1 = new RoundedTextField(15,grisOscuro);
        Alta_usuario_tipodni1 = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        Busqueda_usuario_guardarBtn1 = new javax.swing.JButton();
        volver_btn = new javax.swing.JButton();
        jPasswordField1 = new javax.swing.JPasswordField();
        jPanel2 = new javax.swing.JPanel();

        setBackground(new java.awt.Color(153, 153, 153));
        setForeground(new java.awt.Color(51, 51, 51));
        setPreferredSize(new java.awt.Dimension(1200, 620));
        setLayout(new java.awt.GridBagLayout());

        jPanel1.setBackground(new java.awt.Color(252, 252, 252));
        jPanel1.setAutoscrolls(true);
        jPanel1.setMaximumSize(new java.awt.Dimension(430, 320));
        jPanel1.setPreferredSize(new java.awt.Dimension(0, 0));
        jPanel1.setLayout(new java.awt.GridBagLayout());

        jLabel3.setText("Tipo DNI");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 20, 5, 0);
        jPanel1.add(jLabel3, gridBagConstraints);

        jLabel4.setText("Número DNI");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.ipadx = 23;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 5, 30);
        jPanel1.add(jLabel4, gridBagConstraints);

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("Datos Personales");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(20, 20, 0, 0);
        jPanel1.add(jLabel8, gridBagConstraints);

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setText("Datos usuario");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(20, 20, 0, 0);
        jPanel1.add(jLabel9, gridBagConstraints);

        Alta_usuario_usuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Alta_usuario_usuarioActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 20;
        gridBagConstraints.ipady = 16;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 0, 20);
        jPanel1.add(Alta_usuario_usuario, gridBagConstraints);

        jLabel11.setText("Rol");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 20, 5, 0);
        jPanel1.add(jLabel11, gridBagConstraints);

        jLabel12.setText("Contraseña");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 5, 30);
        jPanel1.add(jLabel12, gridBagConstraints);

        Alta_usuario_tipodni.setModel(new javax.swing.DefaultComboBoxModel<>());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 20;
        gridBagConstraints.ipady = 16;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 0, 20);
        jPanel1.add(Alta_usuario_tipodni, gridBagConstraints);

        Busqueda_usuario_guardarBtn.setBackground(new java.awt.Color(252, 252, 252));
        Busqueda_usuario_guardarBtn.setText("Editar");
        Busqueda_usuario_guardarBtn.setBorder(null);
        Busqueda_usuario_guardarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Busqueda_usuario_guardarBtnActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 30);
        jPanel1.add(Busqueda_usuario_guardarBtn, gridBagConstraints);

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel18.setText("Información del usuario");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 20, 0, 0);
        jPanel1.add(jLabel18, gridBagConstraints);

        Alta_usuario_numerodni1.setToolTipText("");
        Alta_usuario_numerodni1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Alta_usuario_numerodni1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 20;
        gridBagConstraints.ipady = 16;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 30);
        jPanel1.add(Alta_usuario_numerodni1, gridBagConstraints);

        Alta_usuario_tipodni1.setModel(new javax.swing.DefaultComboBoxModel<>());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 20;
        gridBagConstraints.ipady = 16;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 0, 20);
        jPanel1.add(Alta_usuario_tipodni1, gridBagConstraints);

        jLabel13.setText("Usuario");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 20, 5, 0);
        jPanel1.add(jLabel13, gridBagConstraints);

        Busqueda_usuario_guardarBtn1.setBackground(new java.awt.Color(0, 153, 204));
        Busqueda_usuario_guardarBtn1.setText("Eliminar usuario");
        Busqueda_usuario_guardarBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Busqueda_usuario_guardarBtn1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.ipadx = 55;
        gridBagConstraints.ipady = 17;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 30, 30);
        jPanel1.add(Busqueda_usuario_guardarBtn1, gridBagConstraints);

        volver_btn.setText("Volver");
        volver_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volver_btnActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 30, 20);
        jPanel1.add(volver_btn, gridBagConstraints);

        jPasswordField1.setText("jPasswordField1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 20;
        gridBagConstraints.ipady = 16;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 30);
        jPanel1.add(jPasswordField1, gridBagConstraints);

        jPanel2.setBackground(new java.awt.Color(252, 252, 252));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 11;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weighty = 0.3;
        jPanel1.add(jPanel2, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.ipadx = 500;
        gridBagConstraints.ipady = 100;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        add(jPanel1, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void Alta_usuario_usuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Alta_usuario_usuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Alta_usuario_usuarioActionPerformed

    private void Alta_usuario_numerodni1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Alta_usuario_numerodni1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Alta_usuario_numerodni1ActionPerformed

    private void Busqueda_usuario_guardarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Busqueda_usuario_guardarBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Busqueda_usuario_guardarBtnActionPerformed

    private void Busqueda_usuario_guardarBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Busqueda_usuario_guardarBtn1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Busqueda_usuario_guardarBtn1ActionPerformed

    private void volver_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volver_btnActionPerformed
       main.switchScreen("Usuarios");
    }//GEN-LAST:event_volver_btnActionPerformed
    
 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Alta_usuario_numerodni1;
    private javax.swing.JComboBox<String> Alta_usuario_tipodni;
    private javax.swing.JComboBox<String> Alta_usuario_tipodni1;
    private javax.swing.JTextField Alta_usuario_usuario;
    private javax.swing.JButton Busqueda_usuario_guardarBtn;
    private javax.swing.JButton Busqueda_usuario_guardarBtn1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JButton volver_btn;
    // End of variables declaration//GEN-END:variables

    public void addSaveButtonListener(UsuariosController.SaveButtonListener saveButtonListener) {
        Busqueda_usuario_guardarBtn.addActionListener(saveButtonListener);
    }
    /*
    public UsuarioDTO getUsuarioDTO(){
        return new UsuarioDTO(
        Alta_usuario_tipodni.getSelectedItem().toString(),
        Alta_usuario_numerodni1.getText(),
        Alta_usuario_usuario.getText(),
        Alta_usuario_contrasenia.getText(),
        Rol.ADMINISTRATIVO.toString()
        );
    }
    
    public void usuarioCreado(){
        //ventana emergente con confirmacion
        VentanaEmergente ventanaEmergente = new VentanaEmergente("Usuario creado exitosamente.");
        ventanaEmergente.setVisible(true);
        //limpiar inputs
        Alta_usuario_numerodni1.setText("");
        Alta_usuario_contrasenia.setText("");
        Alta_usuario_usuario.setText("");
    }
    */
    public void nombreUsuarioExistente(String mensajeError){
        //ventana emergente error
        VentanaEmergente ventanaEmergente = new VentanaEmergente(mensajeError);
        ventanaEmergente.setVisible(true);
        //cambiar borde a rojo
        ((RoundedTextField)Alta_usuario_usuario).setBorderColor(Color.RED);
    }

    public void dniExistente(String mensajeError){
        //ventana emergente error
        VentanaEmergente ventanaEmergente = new VentanaEmergente(mensajeError);
        ventanaEmergente.setVisible(true);
        //cambiar borde a rojo         
        ((RoundedTextField)Alta_usuario_numerodni1).setBorderColor(Color.RED);
    }
        
    public void nombreDniExistentes(String mensajeError){
        //ventana emergente error
        VentanaEmergente ventanaEmergente = new VentanaEmergente(mensajeError);
        ventanaEmergente.setVisible(true);
        //cambiar ambos bordes a rojo 
        ((RoundedTextField)Alta_usuario_numerodni1).setBorderColor(Color.RED);
        ((RoundedTextField)Alta_usuario_usuario).setBorderColor(Color.RED);

    }

    public void ventanaError(String message) {
        //ventana emergente con confirmacion
        VentanaEmergente ventanaEmergente = new VentanaEmergente(message);
        ventanaEmergente.setVisible(true);
    }
    
    public void setAltaTipoDNI(String tipo){
        Alta_usuario_tipodni.addItem(tipo);
    }
    
    public void setMain(UsuariosMain main){
        this.main = main;
    }
    
    public void cargarUsuario(UsuarioDTO usuario){
        
        Alta_usuario_numerodni1.setText(usuario.getNroDocumento());
        Alta_usuario_usuario.setText(usuario.getUsuario());
        jPasswordField1.setText(usuario.getContrasenia());
        
        
    }
    
}

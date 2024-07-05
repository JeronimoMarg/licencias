/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.metodos.licencias.view;

import com.metodos.licencias.DTO.LicenciaDTO;
import com.metodos.licencias.DTO.TitularDTO;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentCatalog;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm;
import org.apache.pdfbox.pdmodel.interactive.form.PDField;
import org.apache.pdfbox.rendering.PDFRenderer;

/**
 *
 * @author valec
 */
public class LicenciaEmitidaMain extends javax.swing.JPanel {

    /**
     * Creates new form LicenciaEmitidaMain
     */
    
    CardLayout cl;
    int cornerRadius = 15;
    Color grisOscuro = new Color(80,80,80);
    private double zoomFactor = 1;
    PDDocument document = null;
    JFrame frame;
    LicenciaDTO licencia;
    TitularDTO titular;
    
    public LicenciaEmitidaMain(LicenciaDTO licencia, TitularDTO titularDTO, JFrame main) {
        this.frame = main;
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {

                try {
                    document.close();
                } catch (IOException ex) {
                    VentanaEmergente cerrarArchivo = new VentanaEmergente("Error al cerrar el documento PDF");
                }

                frame.dispose();
            }
            
            
        });
        
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
               try {
                    document.close();
                } catch (IOException ex) {
                    VentanaEmergente cerrarArchivo = new VentanaEmergente("Error al cerrar el documento PDF");
                }

                frame.dispose();
            }
        });
        
        
        this.licencia = licencia;
        this.titular = titularDTO;
        initComponents();
        armarCardLayout(licencia, titularDTO);
        pdfConfig();
        pdf.revalidate();
        pdf.repaint();
        revalidate();
        repaint();
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

        cardPanel = new RoundedPanel(15);
        licenciaPanel = new RoundedPanel(15);
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        tipoLicencia = new RoundedLabel(cornerRadius,grisOscuro);
        nroLicencia = new RoundedLabel(cornerRadius,grisOscuro);
        inicioLicencia = new RoundedLabel(cornerRadius,grisOscuro);
        finLicencia = new RoundedLabel(cornerRadius,grisOscuro);
        observaciones = new RoundedLabel(cornerRadius,grisOscuro);
        jPanel2 = new javax.swing.JPanel();
        cerrarBtn = new RoundedButton(15);
        pdfButton = new RoundedButton(15);
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        esDonanteTitular = new javax.swing.JCheckBox();
        apellidoTitular = new RoundedLabel(cornerRadius,grisOscuro);
        nombreTitular = new RoundedLabel(cornerRadius,grisOscuro);
        tipoDocumentoTitular = new RoundedLabel(cornerRadius,grisOscuro);
        numeroDocumentoTitular = new RoundedLabel(cornerRadius,grisOscuro);
        fechaNacimientoTitular = new RoundedLabel(cornerRadius,grisOscuro);
        grupoSanguineoTitular = new RoundedLabel(cornerRadius,grisOscuro);
        calleTitular = new RoundedLabel(cornerRadius,grisOscuro);
        alturaTitular = new RoundedLabel(cornerRadius,grisOscuro);
        jLabel12 = new javax.swing.JLabel();
        pdf = new RoundedPanel(15);

        setBackground(new java.awt.Color(194, 194, 194));
        setLayout(new java.awt.GridBagLayout());

        cardPanel.setBackground(new java.awt.Color(252, 252, 252));
        cardPanel.setLayout(new java.awt.CardLayout());

        licenciaPanel.setBackground(new java.awt.Color(252, 252, 252));
        licenciaPanel.setLayout(new java.awt.GridBagLayout());

        jLabel1.setText("Titular");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(20, 20, 0, 0);
        licenciaPanel.add(jLabel1, gridBagConstraints);

        jLabel2.setText("nroLicencia");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 30);
        licenciaPanel.add(jLabel2, gridBagConstraints);

        jLabel3.setText("inicio");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 20, 0, 0);
        licenciaPanel.add(jLabel3, gridBagConstraints);

        jLabel4.setText("fin");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 30);
        licenciaPanel.add(jLabel4, gridBagConstraints);

        jLabel5.setText("tipo");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 20, 0, 0);
        licenciaPanel.add(jLabel5, gridBagConstraints);

        jLabel6.setText("Observaciones");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 20, 0, 0);
        licenciaPanel.add(jLabel6, gridBagConstraints);

        tipoLicencia.setBackground(new java.awt.Color(252, 252, 252));
        tipoLicencia.setForeground(new java.awt.Color(80, 80, 80));
        tipoLicencia.setText("jLabel7");
        tipoLicencia.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 51, 51), 1, true));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipady = 20;
        gridBagConstraints.insets = new java.awt.Insets(5, 20, 0, 10);
        licenciaPanel.add(tipoLicencia, gridBagConstraints);

        nroLicencia.setBackground(new java.awt.Color(252, 252, 252));
        nroLicencia.setForeground(new java.awt.Color(80, 80, 80));
        nroLicencia.setText("jLabel8");
        nroLicencia.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 51, 51), 1, true));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipady = 20;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 30);
        licenciaPanel.add(nroLicencia, gridBagConstraints);

        inicioLicencia.setBackground(new java.awt.Color(252, 252, 252));
        inicioLicencia.setForeground(new java.awt.Color(80, 80, 80));
        inicioLicencia.setText("jLabel9");
        inicioLicencia.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 51, 51), 1, true));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipady = 20;
        gridBagConstraints.insets = new java.awt.Insets(5, 20, 0, 10);
        licenciaPanel.add(inicioLicencia, gridBagConstraints);

        finLicencia.setBackground(new java.awt.Color(252, 252, 252));
        finLicencia.setForeground(new java.awt.Color(80, 80, 80));
        finLicencia.setText("jLabel10");
        finLicencia.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 51, 51), 1, true));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipady = 20;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 30);
        licenciaPanel.add(finLicencia, gridBagConstraints);

        observaciones.setBackground(new java.awt.Color(252, 252, 252));
        observaciones.setForeground(new java.awt.Color(80, 80, 80));
        observaciones.setText("jLabel11");
        observaciones.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 51, 51), 1, true));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipady = 20;
        gridBagConstraints.insets = new java.awt.Insets(5, 20, 10, 30);
        licenciaPanel.add(observaciones, gridBagConstraints);

        jPanel2.setBackground(new java.awt.Color(252, 252, 252));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 632, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 38, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 17;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 0, 30);
        licenciaPanel.add(jPanel2, gridBagConstraints);

        cerrarBtn.setBackground(new java.awt.Color(27, 140, 188));
        cerrarBtn.setForeground(new java.awt.Color(255, 255, 255));
        cerrarBtn.setText("Cerrar");
        cerrarBtn.setFocusable(false);
        cerrarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cerrarBtnJButton1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 18;
        gridBagConstraints.ipadx = 10;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 10, 10);
        licenciaPanel.add(cerrarBtn, gridBagConstraints);

        pdfButton.setBackground(new java.awt.Color(27, 140, 188));
        pdfButton.setForeground(new java.awt.Color(255, 255, 255));
        pdfButton.setText("Imprimir PDF");
        pdfButton.setFocusable(false);
        pdfButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pdfButtonJButton2ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 18;
        gridBagConstraints.ipadx = 10;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 10, 30);
        licenciaPanel.add(pdfButton, gridBagConstraints);

        jLabel7.setText("Nombre");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 20, 0, 0);
        licenciaPanel.add(jLabel7, gridBagConstraints);

        jLabel8.setText("Apellido");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 30);
        licenciaPanel.add(jLabel8, gridBagConstraints);

        jLabel9.setText("Fecha de nacimiento");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 20, 0, 0);
        licenciaPanel.add(jLabel9, gridBagConstraints);

        jLabel10.setText("Tipo de documento");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 20, 0, 0);
        licenciaPanel.add(jLabel10, gridBagConstraints);

        jLabel11.setText("Numero de documento");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 30);
        licenciaPanel.add(jLabel11, gridBagConstraints);

        jLabel16.setText("Calle");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 14;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 20, 0, 0);
        licenciaPanel.add(jLabel16, gridBagConstraints);

        jLabel17.setText("Altura");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 14;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 30);
        licenciaPanel.add(jLabel17, gridBagConstraints);

        jLabel18.setText("Grupo sanguíneo");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 30);
        licenciaPanel.add(jLabel18, gridBagConstraints);

        esDonanteTitular.setBackground(new java.awt.Color(252, 252, 252));
        esDonanteTitular.setText("Es donante");
        esDonanteTitular.setEnabled(false);
        esDonanteTitular.setFocusable(false);
        esDonanteTitular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                esDonanteTitularActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 16;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(15, 20, 0, 10);
        licenciaPanel.add(esDonanteTitular, gridBagConstraints);

        apellidoTitular.setBackground(new java.awt.Color(252, 252, 252));
        apellidoTitular.setForeground(new java.awt.Color(80, 80, 80));
        apellidoTitular.setText("jLabel7");
        apellidoTitular.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 51, 51), 1, true));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipady = 20;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 30);
        licenciaPanel.add(apellidoTitular, gridBagConstraints);

        nombreTitular.setBackground(new java.awt.Color(252, 252, 252));
        nombreTitular.setForeground(new java.awt.Color(80, 80, 80));
        nombreTitular.setText("jLabel8");
        nombreTitular.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 51, 51), 1, true));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipady = 20;
        gridBagConstraints.insets = new java.awt.Insets(5, 20, 0, 10);
        licenciaPanel.add(nombreTitular, gridBagConstraints);

        tipoDocumentoTitular.setBackground(new java.awt.Color(252, 252, 252));
        tipoDocumentoTitular.setForeground(new java.awt.Color(80, 80, 80));
        tipoDocumentoTitular.setText("jLabel9");
        tipoDocumentoTitular.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 51, 51), 1, true));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipady = 20;
        gridBagConstraints.insets = new java.awt.Insets(5, 20, 0, 10);
        licenciaPanel.add(tipoDocumentoTitular, gridBagConstraints);

        numeroDocumentoTitular.setBackground(new java.awt.Color(252, 252, 252));
        numeroDocumentoTitular.setForeground(new java.awt.Color(80, 80, 80));
        numeroDocumentoTitular.setText("jLabel10");
        numeroDocumentoTitular.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 51, 51), 1, true));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipady = 20;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 30);
        licenciaPanel.add(numeroDocumentoTitular, gridBagConstraints);

        fechaNacimientoTitular.setBackground(new java.awt.Color(252, 252, 252));
        fechaNacimientoTitular.setForeground(new java.awt.Color(80, 80, 80));
        fechaNacimientoTitular.setText("jLabel10");
        fechaNacimientoTitular.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 51, 51), 1, true));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 13;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipady = 20;
        gridBagConstraints.insets = new java.awt.Insets(5, 20, 0, 10);
        licenciaPanel.add(fechaNacimientoTitular, gridBagConstraints);

        grupoSanguineoTitular.setBackground(new java.awt.Color(252, 252, 252));
        grupoSanguineoTitular.setForeground(new java.awt.Color(80, 80, 80));
        grupoSanguineoTitular.setText("jLabel9");
        grupoSanguineoTitular.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 51, 51), 1, true));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 13;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipady = 20;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 30);
        licenciaPanel.add(grupoSanguineoTitular, gridBagConstraints);

        calleTitular.setBackground(new java.awt.Color(252, 252, 252));
        calleTitular.setForeground(new java.awt.Color(80, 80, 80));
        calleTitular.setText("jLabel7");
        calleTitular.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 51, 51), 1, true));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 15;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipady = 20;
        gridBagConstraints.insets = new java.awt.Insets(5, 20, 0, 10);
        licenciaPanel.add(calleTitular, gridBagConstraints);

        alturaTitular.setBackground(new java.awt.Color(252, 252, 252));
        alturaTitular.setForeground(new java.awt.Color(80, 80, 80));
        alturaTitular.setText("jLabel8");
        alturaTitular.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 51, 51), 1, true));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 15;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipady = 20;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 30);
        licenciaPanel.add(alturaTitular, gridBagConstraints);

        jLabel12.setText("Licencia");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(20, 20, 0, 0);
        licenciaPanel.add(jLabel12, gridBagConstraints);

        cardPanel.add(licenciaPanel, "Panel");

        pdf.setBackground(new java.awt.Color(252, 252, 252));
        pdf.setLayout(new java.awt.GridBagLayout());
        cardPanel.add(pdf, "PDF");

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.ipadx = 300;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        add(cardPanel, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void cerrarBtnJButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cerrarBtnJButton1ActionPerformed
        try {
            document.close();
        } catch (IOException ex) {
            VentanaEmergente cerrarArchivo = new VentanaEmergente("Error al cerrar el documento PDF");
        }
        frame.dispose();
    }//GEN-LAST:event_cerrarBtnJButton1ActionPerformed

    private void pdfButtonJButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pdfButtonJButton2ActionPerformed
        switchScreen("PDF");
        /*
        pdf.revalidate();
        pdf.repaint();
        revalidate();
        repaint();
        */
    }//GEN-LAST:event_pdfButtonJButton2ActionPerformed

    private void esDonanteTitularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_esDonanteTitularActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_esDonanteTitularActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel alturaTitular;
    private javax.swing.JLabel apellidoTitular;
    private javax.swing.JLabel calleTitular;
    private javax.swing.JPanel cardPanel;
    private javax.swing.JButton cerrarBtn;
    private javax.swing.JCheckBox esDonanteTitular;
    private javax.swing.JLabel fechaNacimientoTitular;
    private javax.swing.JLabel finLicencia;
    private javax.swing.JLabel grupoSanguineoTitular;
    private javax.swing.JLabel inicioLicencia;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel licenciaPanel;
    private javax.swing.JLabel nombreTitular;
    private javax.swing.JLabel nroLicencia;
    private javax.swing.JLabel numeroDocumentoTitular;
    private javax.swing.JLabel observaciones;
    private javax.swing.JPanel pdf;
    private javax.swing.JButton pdfButton;
    private javax.swing.JLabel tipoDocumentoTitular;
    private javax.swing.JLabel tipoLicencia;
    // End of variables declaration//GEN-END:variables

    private void armarCardLayout(LicenciaDTO licencia, TitularDTO titular){

        cl = (CardLayout) (cardPanel.getLayout());
        
        //datos licencia
        tipoLicencia.setText(" " + licencia.getTipoLicencia().getAtributo1());
        nroLicencia.setText(" " +licencia.getNumeroLicencia().toString());
        inicioLicencia.setText(" " +licencia.getInicioVigencia().toString());
        finLicencia.setText(" " +licencia.getFinVigencia().toString());
        observaciones.setText(" " + licencia.getObservaciones());
        
        //datos titular
        nombreTitular.setText( " " +titular.getNombre());
        apellidoTitular.setText(" " +titular.getApellido());
        tipoDocumentoTitular.setText(" " +titular.getTipoDoc());
        numeroDocumentoTitular.setText(" " +titular.getNumDNI());
        fechaNacimientoTitular.setText(" " +titular.getFechaNacimiento().toString());
        grupoSanguineoTitular.setText(" " +titular.getGrupoSanguineo());
        calleTitular.setText(" " +titular.getCalle());
        alturaTitular.setText(" " +titular.getAltura());
        esDonanteTitular.setSelected(titular.esDonante());
        
        
        
    }
    
    public void switchScreen (String pantalla) {    
      cl.show(cardPanel, pantalla);
      revalidate();
    } 
    
    private PDDocument displayPDF(String pdfFilePath, double zoomFactor, JPanel panelPDF) {
       
        document = new PDDocument();
        
        try {
            document = PDDocument.load(new File(pdfFilePath));
            PDFRenderer renderer = new PDFRenderer(document);
            
            try{
            llenarPDF(document);
            }
            catch(Exception e){
                VentanaEmergente errorCargarDoc = new VentanaEmergente("No se puede completar el cargado del PDF");
            }
            
            int pageCount = document.getNumberOfPages();
            for (int pageIndex = 0; pageIndex < pageCount; pageIndex++) {
                BufferedImage image = renderer.renderImageWithDPI(pageIndex, (float) (100 * zoomFactor));

                ImageIcon imageIcon = new ImageIcon(image);
                JLabel label = new JLabel(imageIcon);
                panelPDF.add(label);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
  
        
        return document;
    }

    private void llenarPDF(PDDocument document) throws IOException {
       PDAcroForm pDAcroForm = document.getDocumentCatalog().getAcroForm();
            PDField field = pDAcroForm.getField("field_tipo");
            field.setValue(licencia.getTipoLicencia().getAtributo1());
            field = pDAcroForm.getField("field_nro");
            field.setValue(licencia.getNumeroLicencia().toString());
            field = pDAcroForm.getField("field_inicio");
            field.setValue(licencia.getInicioVigencia().toString());
            field = pDAcroForm.getField("field_fin");
            field.setValue(licencia.getFinVigencia().toString());
            field = pDAcroForm.getField("field_observaciones");
            field.setValue(licencia.getObservaciones());
            field = pDAcroForm.getField("field_nombre");
            field.setValue(titular.getNombre());
            field = pDAcroForm.getField("field_apellido");
            field.setValue(titular.getApellido());
            field = pDAcroForm.getField("field_tipoDocumento");
            field.setValue(titular.getTipoDoc());
            field = pDAcroForm.getField("field_numeroDocumento");
            field.setValue(titular.getNumDNI());
            field = pDAcroForm.getField("field_fechaNacimiento");
            Date fechaNacimiento = titular.getFechaNacimiento();
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
            String date = dateFormat.format(fechaNacimiento);
            field.setValue(date);
            field = pDAcroForm.getField("field_grupoSanguineo");
            field.setValue(titular.getGrupoSanguineo());
            field = pDAcroForm.getField("field_calle");
            field.setValue(titular.getCalle());
            field = pDAcroForm.getField("field_altura");
            field.setValue(titular.getAltura());
            field = pDAcroForm.getField("field_esDonante");
            if(titular.esDonante()){
                field.setValue("Es donante de sangre.");
            } else {
                field.setValue("No es donante de sangre.");
            }
            
            
    }
    
    private void pdfConfig() {
        
        pdf.setLayout(new GridBagLayout());
        JPanel pdfPanel  = new JPanel();
        
        JPanel relleno = new JPanel();
        relleno.setBackground(new Color(252,252,252));
        RoundedButton zoomInButton = new RoundedButton(cornerRadius);
        zoomInButton.setText("+");
        zoomInButton.setBackground(new Color(194,194,194));
        zoomInButton.setForeground(new Color(51,51,51));
        zoomInButton.setFocusable(false);
        RoundedButton zoomOutButton = new RoundedButton(cornerRadius);
        zoomOutButton.setText("-");
        zoomOutButton.setBackground(new Color(194,194,194));
        zoomOutButton.setForeground(new Color(51,51,51));
        zoomOutButton.setFocusable(false);
        RoundedButton volver = new RoundedButton(cornerRadius);
        volver.setBackground(new Color(27, 140, 188));
        volver.setForeground(new Color(252,252,252));
        volver.setFocusable(false);
        volver.setText("Volver");
        RoundedButton descargar = new RoundedButton(cornerRadius);
        descargar.setBackground(new Color(27, 140, 188));
        descargar.setForeground(new Color(252,252,252));
        descargar.setFocusable(false);
        descargar.setText("Imprimir");
        
        PDDocument document = displayPDF("Licencia.pdf", zoomFactor, pdfPanel);
        
        zoomInButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                if(zoomFactor < 2.5){
                    zoomFactor *= 1.2;
                    updateZoom(pdfPanel, (float) (zoomFactor));
                }
            }
        });

        zoomOutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                if(zoomFactor > 0.4){
                    zoomFactor /= 1.2;
                    updateZoom(pdfPanel, (float) (zoomFactor));
                }
            }
        });
        
        volver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switchScreen("Panel");
            }
        });
        
        descargar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    descargarPDF(document);
                } catch (IOException ex) {
                    Logger.getLogger(LicenciaEmitidaMain.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        pdfPanel.setLayout(new BoxLayout(pdfPanel, BoxLayout.Y_AXIS));
        JScrollPane scrollPane = new JScrollPane(pdfPanel);
           
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weighty = 1;
        gbc.weightx = 0.98;
        gbc.gridheight = 5;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(10,20,20,10);
        pdf.add(scrollPane,gbc);
        
        gbc.gridheight = 1;
        gbc.weightx = 0.02;
        gbc.weighty = 0.01;
        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(10,0,0,30);
        pdf.add(zoomInButton, gbc);
        
        gbc.gridy = 1;
        gbc.insets = new Insets(10,0,0,30);
        pdf.add(zoomOutButton, gbc);
        
        gbc.gridy = 2;
        gbc.insets = new Insets(0,0,0,30);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.weighty = 1;
        pdf.add(relleno,gbc);
        
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.VERTICAL;
        //gbc.anchor = GridBagConstraints.WEST;
        gbc.weighty = 0.01;
        gbc.insets = new Insets(0,0,10,30);
        pdf.add(volver,gbc);
        
        gbc.gridy = 4;
        gbc.fill = GridBagConstraints.VERTICAL;
        //gbc.anchor = GridBagConstraints.EAST;
        gbc.weighty = 0.01;
        gbc.insets = new Insets(0,0,20,30);
        pdf.add(descargar,gbc);

    }
    
    private void updateZoom(JPanel pdfPanel,  double zoomFactor) {
        pdfPanel.removeAll();
        displayPDF("Licencia.pdf", zoomFactor, pdfPanel);
        revalidate();
        repaint();
    }
    
    void descargarPDF(PDDocument document) throws IOException{
        
        // Use JFileChooser to choose the location and filename for saving the PDF
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Save PDF");
            int userSelection = fileChooser.showSaveDialog(null);

            if (userSelection == JFileChooser.APPROVE_OPTION) {
                // Get the selected file
                File selectedFile = fileChooser.getSelectedFile();

                // Ensure the file has a .pdf extension
                String pdfFilePath = selectedFile.getAbsolutePath();
                if (!pdfFilePath.toLowerCase().endsWith(".pdf")) {
                    pdfFilePath += ".pdf";
                }

                // Set the form fields as read-only
                setFormFieldsReadOnly(document);
                
                // Save the document to the specified file
                document.save(pdfFilePath);
                document.close();
            }
    }
    
    private void setFormFieldsReadOnly(PDDocument document) {
        PDDocumentCatalog catalog = document.getDocumentCatalog();
        PDAcroForm acroForm = catalog.getAcroForm();

        if (acroForm != null) {
            // Iterate through all pages
            for (PDPage page : document.getPages()) {
                // Iterate through all fields on the page
                acroForm.getFields().forEach(field -> {
                    // Set the read-only flag for each field
                    field.setReadOnly(true);
                });
            }
        }
    }
    
    

}

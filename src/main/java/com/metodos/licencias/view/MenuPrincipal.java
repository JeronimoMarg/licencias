package com.metodos.licencias.view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MenuPrincipal extends javax.swing.JFrame{
    
    TabButton botonLicencias = new TabButton();
    TabButton botonTitulares = new TabButton();
    TabButton botonUsuarios = new TabButton();
    JPanel mainPanel = new JPanel(new CardLayout());
    CardLayout cl;
    
    private final UsuariosMain panelUsuarios;
    private final TitularesMain panelTitulares;
    private final Licencias panelLicencias;
    
    @Autowired
    public MenuPrincipal(TitularesMain panelTitulares, UsuariosMain panelUsuarios, Licencias panelLicencias) {
        this.panelUsuarios = panelUsuarios;
        this.panelTitulares = panelTitulares;
        this.panelLicencias = panelLicencias;
        
        //creacion Frame
        //JFrame frame = new JFrame("Licencias");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1280, 720);
        setTitle("Licencias");
        setMinimumSize(new Dimension(800, 700));
        
        ImageIcon customIcon = new ImageIcon("logo.png");
        setIconImage(customIcon.getImage());
        
        
        //creacion paneles principales
        JPanel panelContenedor = new JPanel(new BorderLayout());
        JPanel barraSuperior = new JPanel(new FlowLayout(FlowLayout.LEFT));
        botonLicencias.setSeleccionado(true);
        botonTitulares.setSeleccionado(false);
        botonUsuarios.setSeleccionado(false);
        
        barraSuperiorInit(barraSuperior);
        mainPanelInit(mainPanel);
        cl = (CardLayout) (mainPanel.getLayout());

        
        panelContenedor.add(barraSuperior,BorderLayout.NORTH);
      
        panelContenedor.add(mainPanel,BorderLayout.CENTER);
        
        setContentPane(panelContenedor);
        pack();
        setLocationRelativeTo(null);
    }

    private void barraSuperiorInit(JPanel barraSuperior) {

        barraSuperior.setBackground(new java.awt.Color(242, 242, 242));
        barraSuperior.setAlignmentX(0.0F);
        barraSuperior.setAlignmentY(0.0F);
        barraSuperior.setMaximumSize(new java.awt.Dimension(2147483647, 55));
        barraSuperior.setMinimumSize(new java.awt.Dimension(157, 55));
        barraSuperior.setPreferredSize(new java.awt.Dimension(624, 55));

        botonLicencias.setText("Licencias");
        botonLicencias.setBorder(null);
        botonLicencias.setBorderPainted(false);
        botonLicencias.setFocusPainted(false);
        botonLicencias.setFocusable(false);
        botonLicencias.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botonLicencias.setMargin(new java.awt.Insets(0, 0, 0, 0));
        botonLicencias.setMinimumSize(new java.awt.Dimension(75, 50));
        botonLicencias.setPreferredSize(new java.awt.Dimension(90, 50));
        botonLicencias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonLicenciasActionPerformed(evt);
            }
        });
        barraSuperior.add(botonLicencias);

        botonTitulares.setText("Titulares");
        botonTitulares.setBorder(null);
        botonTitulares.setBorderPainted(false);
        botonTitulares.setFocusPainted(false);
        botonTitulares.setFocusable(false);
        botonTitulares.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botonTitulares.setMargin(new java.awt.Insets(0, 0, 0, 0));
        botonTitulares.setMinimumSize(new java.awt.Dimension(75, 50));
        botonTitulares.setPreferredSize(new java.awt.Dimension(90, 50));
        botonTitulares.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonTitularesActionPerformed(evt);
            }
        });
        barraSuperior.add(botonTitulares);

        botonUsuarios.setText("Usuarios");
        botonUsuarios.setBorder(null);
        botonUsuarios.setBorderPainted(false);
        botonUsuarios.setFocusPainted(false);
        botonUsuarios.setFocusable(false);
        botonUsuarios.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botonUsuarios.setMargin(new java.awt.Insets(0, 0, 0, 0));
        botonUsuarios.setMinimumSize(new java.awt.Dimension(75, 50));
        botonUsuarios.setPreferredSize(new java.awt.Dimension(90, 50));
        botonUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonUsuariosActionPerformed(evt);
            }
        });
        barraSuperior.add(botonUsuarios);
    }
         
    private void botonLicenciasActionPerformed(java.awt.event.ActionEvent evt) {                                         
       botonLicencias.setSeleccionado(true);
       botonTitulares.setSeleccionado(false);
       botonUsuarios.setSeleccionado(false);
       cl.show(mainPanel, "Licencias");
    }                                        

    private void botonTitularesActionPerformed(java.awt.event.ActionEvent evt) {                                         
       botonLicencias.setSeleccionado(false);
       botonTitulares.setSeleccionado(true);
       botonUsuarios.setSeleccionado(false);
       cl.show(mainPanel, "Titulares");
    }   
    
    private void botonUsuariosActionPerformed(java.awt.event.ActionEvent evt) {                                         
       botonLicencias.setSeleccionado(false);
       botonTitulares.setSeleccionado(false);
       botonUsuarios.setSeleccionado(true);
       cl.show(mainPanel, "Usuarios");
    }  
    
    private void mainPanelInit(JPanel mainPanel){
        mainPanel.setBackground(new Color(150,150,150));

        // Create the cards
        JPanel card1 = panelLicencias;
        JPanel card2 = panelTitulares;
        JPanel card3 = panelUsuarios;
        
        // Add the cards to the panel with identifiers
        mainPanel.add(card1, "Licencias");
        mainPanel.add(card2, "Titulares");
        mainPanel.add(card3, "Usuarios");
                
    }
    
    public void setVisible(){
        setVisible(true);
    }
    
}

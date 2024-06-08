package com.metodos.licencias.view;

import com.metodos.licencias.controller.TitularesController;
import com.metodos.licencias.controller.UsuariosController;
import com.metodos.licencias.service.UsuarioService;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
//import javax.swing.JTabbedPane;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MenuPrincipal extends javax.swing.JFrame{
    
    TabButton botonLicencias = new TabButton();
    TabButton botonTitulares = new TabButton();
    TabButton botonUsuarios = new TabButton();
    JPanel mainPanel = new JPanel(new CardLayout());
    CardLayout cl;
    
    private final Usuarios panelUsuarios;
    private final Titulares panelTitulares;
    private final InfoTitular panelInfoTitular;
    
    @Autowired
    public MenuPrincipal(Titulares panelTitulares, Usuarios panelUsuarios, InfoTitular infoTitular) {
        this.panelUsuarios = panelUsuarios;
        this.panelTitulares = panelTitulares;
        this.panelInfoTitular = infoTitular;
        
        //creacion Frame
        JFrame frame = new JFrame("Licencias");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1280, 720);
        setLocationRelativeTo(null);
        
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
        
        frame.setContentPane(panelContenedor);
        frame.setVisible(true);
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
       cl.show(mainPanel, "Card1");
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
        mainPanel.setBackground(new Color(0,150,150));

        // Create the cards
        JPanel card1 = new JPanel();
        card1.add(new JLabel("PANTALLA LICENCIAS"));
        card1.setBackground(Color.GRAY);
        
        JPanel card2 = panelTitulares;
        JPanel card3 = panelUsuarios;
        JPanel card4 = panelInfoTitular;
        
        // Add the cards to the panel with identifiers
        mainPanel.add(card1, "Card1");
        mainPanel.add(card2, "Titulares");
        mainPanel.add(card3, "Usuarios");
        mainPanel.add(card4, "Informacion Titular");
                
    }
    
    
}

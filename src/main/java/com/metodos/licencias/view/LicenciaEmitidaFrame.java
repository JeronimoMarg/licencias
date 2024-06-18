/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.metodos.licencias.view;

import com.metodos.licencias.DTO.LicenciaDTO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author valec
 */
public class LicenciaEmitidaFrame extends  JFrame {
    
    public LicenciaEmitidaFrame(LicenciaDTO licenciaDTO){
        
        //creacion Frame
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        
        ImageIcon customIcon = new ImageIcon("logo.png");
        setIconImage(customIcon.getImage());
    
        //inicializo container
        JPanel licenciaEmitidaContainer = new LicenciaEmitidaMain(licenciaDTO, this);
        setContentPane(licenciaEmitidaContainer);
        
        pack();
        setSize(600, 690);
        setLocationRelativeTo(null);
        setVisible(true);
        
    } 
    
    
}

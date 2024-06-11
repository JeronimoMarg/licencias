/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.metodos.licencias.view;

import java.awt.CardLayout;
import javax.swing.JPanel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author valec
 */
@Component
public class TitularesMain extends JPanel{
    
    CardLayout cl;
    Titulares titulares;
    InfoTitular infoTitular;
    
    @Autowired
    public TitularesMain(Titulares titulares, InfoTitular infoTitular) {
        this.titulares = titulares;
        this.titulares.setMain(this);
        this.infoTitular = infoTitular;
        this.infoTitular.setMain(this);
        this.setLayout(new CardLayout());
        cl = (CardLayout) (this.getLayout());
        
        // Add the cards to the panel with identifiers
        add(this.titulares, "Titulares");
        add(this.infoTitular, "InfoTitular");
    }
    
    public void switchScreen (String pantalla) {    
       cl.show(this, pantalla);
       revalidate();
       
    }                                        
 
    
    
}

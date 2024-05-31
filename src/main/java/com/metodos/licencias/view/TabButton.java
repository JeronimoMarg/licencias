
package com.metodos.licencias.view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 *
 * @author valec
 */
public class TabButton extends JButton {
    
    Color blanco = new Color(242, 242, 242);
    Color azul = new java.awt.Color(27, 140, 188);
    Boolean state = false;
    
    public TabButton(){
        initComponents();
    }
    
    private void initComponents(){
        
        //colores selected
        /*
        setBackground(new java.awt.Color(27, 140, 188));
        setForeground(new java.awt.Color(242, 242, 242));
        */
        setBackground(blanco);
        setForeground(new Color(12, 12, 12));
        setBorder(null);
        setBorderPainted(false);
        setFocusPainted(false);
        setFocusable(false);
        setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        setMargin(new java.awt.Insets(0, 0, 0, 0));
        setMinimumSize(new java.awt.Dimension(75, 50));
        setPreferredSize(new java.awt.Dimension(90, 50));
        
        /*
        // Add an ActionListener to the button
        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Toggle the background color
                if (state = false) {
                    setBackground(azul);
                    setForeground(blanco);
                    state = true;
                } else {
                    setBackground(blanco);
                    setForeground(new Color(12, 12, 12));
                    state = false;
                }
            }
        }); 
        */
        
    }
    
    public void setSeleccionado(Boolean flag){
        
      if (flag == true) {
            setBackground(azul);
            setForeground(blanco);
        } else {
            setBackground(blanco);
            setForeground(new Color(12, 12, 12));
        }
        
    }
    
    
}

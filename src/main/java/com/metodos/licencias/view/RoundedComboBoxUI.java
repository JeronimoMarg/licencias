/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.metodos.licencias.view;

import javax.swing.*;
import javax.swing.plaf.basic.BasicComboBoxUI;
import javax.swing.plaf.basic.ComboPopup;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import javax.swing.plaf.basic.BasicComboBoxRenderer;
import javax.swing.plaf.basic.BasicComboPopup;

public class RoundedComboBoxUI extends BasicComboBoxUI {

   private int leftInset = 5;

    @Override
    protected JButton createArrowButton() {
        JButton button = new JButton();
        button.setText("▼");
        button.setBorder(BorderFactory.createEmptyBorder()); // Remove button border
        button.setContentAreaFilled(false); // Make the button transparent
        return button;
    }

    // Optionally, you can override paintCurrentValueBackground() and paintCurrentValue() to customize
    // the appearance of the currently selected item.
   
    
    //esto agrega un inset a la izquierda del texto que muestra el comboBox
    @Override
    protected ListCellRenderer<Object> createRenderer() {
        return new InsetComboBoxRenderer();
    }

    private class InsetComboBoxRenderer extends BasicComboBoxRenderer {

        private static final int INSET = 5; // Adjust the inset as needed

        @Override
        public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
            Component c = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
            if (c instanceof JLabel) {
                ((JLabel) c).setBorder(BorderFactory.createEmptyBorder(2, leftInset, 2, 0));
            }
            return c;
        }
    }


}

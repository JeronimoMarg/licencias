/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.metodos.licencias.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JLabel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

/**
 *
 * @author valec
 */
public class RoundedLabel extends JLabel{
    
    private Shape shape;
    private int cornerRadius;
    Color borderColor;
    public RoundedLabel(int radius, Color color) {
        super();
        this.cornerRadius = radius;
        this.borderColor = color;
        this.setBorder(new CompoundBorder(
        new EmptyBorder(0, 10, 0, 0), // Adjust left inset here (10 pixels in this example)
        new LineBorder(borderColor))); // Optional: You can set a line border around the text field
        
        setOpaque(false); 
    }
    
    public void setBorderColor(Color newBorderColor){
        this.borderColor = newBorderColor;
        this.repaint();
    }
    
    protected void paintComponent(Graphics g) {
        Insets insets = getInsets();
        int x = insets.left; // Adding 10 pixels inset on the left
        int y = insets.top;
        int width = getWidth() - insets.left - insets.right; // Adjusting width for inset
        int height = getHeight() - insets.top - insets.bottom;

        Graphics2D g2 = (Graphics2D) g.create();
        g2.setColor(getBackground());
        g2.fillRoundRect(x, y, width - 1, height - 1, cornerRadius, cornerRadius);
        super.paintComponent(g2);
        g2.dispose();
    }
    protected void paintBorder(Graphics g) {
         g.setColor(borderColor);
         g.drawRoundRect(0, 0, getWidth()-1, getHeight()-1, cornerRadius, cornerRadius);
    }
    public boolean contains(int x, int y) {
         if (shape == null || !shape.getBounds().equals(getBounds())) {
             shape = new RoundRectangle2D.Float(0, 0, getWidth()-1, getHeight()-1, cornerRadius, cornerRadius);
         }
         return shape.contains(x, y);
    }

    
    
}

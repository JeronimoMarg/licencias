/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.metodos.licencias.view;

/**
 *
 * @author valec
 */
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;

public class RoundedTextField extends JTextField {
    private Shape shape;
    private int cornerRadius;
    Color borderColor;
    public RoundedTextField(int radius, Color color) {
        super();
        this.cornerRadius = radius;
        this.borderColor = color;
        setOpaque(false); 
    }
    
    public void setBorderColor(Color newBorderColor){
        this.borderColor = newBorderColor;
        this.repaint();
    }
    
    protected void paintComponent(Graphics g) {
         g.setColor(getBackground());
         g.fillRoundRect(0, 0, getWidth()-1, getHeight()-1, cornerRadius, cornerRadius);
         super.paintComponent(g);
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
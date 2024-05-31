/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.metodos.licencias.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JPanel;

/**
 *
 * @author valec
 */
public class RoundedPanel extends JPanel {
    private int cornerRadius;
    private Color shadowColor;

    public RoundedPanel(int radius) {
        super();
        this.cornerRadius = radius;
        this.shadowColor = new Color(0, 0, 0); // Semi-transparent black color for shadow
        setOpaque(false); // Make sure the background is not painted by the superclass
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Dimension arcs = new Dimension(cornerRadius, cornerRadius);
        int width = getWidth();
        int height = getHeight();
        Graphics2D graphics = (Graphics2D) g;
        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Draw shadow
        int shadowGap = 10; // Adjust this to control the shadow distance
        int shadowOffset = 10; // Adjust this to control the shadow offset
        Color transparentShadow = new Color(0, 0, 0);
        graphics.setColor(transparentShadow);
        graphics.fillRoundRect(shadowOffset, shadowOffset, width - 1 - shadowOffset * 2, height - 1 - shadowOffset * 2, arcs.width, arcs.height);

        // Draws the rounded panel with borders.
        graphics.setColor(new Color(255,255,255));
        graphics.fillRoundRect(0, 0, width - shadowGap, height - shadowGap, arcs.width, arcs.height);
        graphics.setColor(new Color(255,255,255));
        graphics.drawRoundRect(0, 0, width - shadowGap, height - shadowGap, arcs.width, arcs.height);
    }
}

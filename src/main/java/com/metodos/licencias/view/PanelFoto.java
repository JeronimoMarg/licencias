/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.metodos.licencias.view;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author valec
 */
public class PanelFoto extends JPanel{
   
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Image backgroundImage;

    public PanelFoto() {
    	this.setLayout(new GridBagLayout());
        String pathFoto;
        Random random = new Random();
        int randomNumber = random.nextInt(3);
        switch (randomNumber) {
            case 0:
                pathFoto = "foto1.jpg";
                break;
            case 1:
                pathFoto = "foto2.jpg";
                break;
            case 2:
                pathFoto = "foto3.jpg";
                break;
            default:
                pathFoto = "foto1.jpg";
                break;
        }
        backgroundImage = new ImageIcon(pathFoto).getImage();
        // Set the preferred size to match the background image size
        setPreferredSize(new Dimension(backgroundImage.getWidth(null), backgroundImage.getHeight(null)));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        int panelWidth = getWidth();
        int panelHeight = getHeight();
        int imageWidth = backgroundImage.getWidth(null);
        int imageHeight = backgroundImage.getHeight(null);
        
        double aspectRatio = (double) imageWidth / imageHeight;
        double panelAspectRatio = (double) panelWidth / panelHeight;
        
        int drawWidth, drawHeight;
        if (aspectRatio > panelAspectRatio) {
            // Image is wider, so adjust the height to fit the panel
            drawHeight = panelHeight;
            drawWidth = (int) (panelHeight * aspectRatio);
        } else {
            // Image is taller, so adjust the width to fit the panel
            drawWidth = panelWidth;
            drawHeight = (int) (panelWidth / aspectRatio);
        }
        
        // Calculate the position to center the image
        int x = (panelWidth - drawWidth) / 2;
        int y = (panelHeight - drawHeight) / 2;
        
        // Draw the background image with the calculated size and position
        g.drawImage(backgroundImage, x, y, drawWidth, drawHeight, null);
        
       
    }
    
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(backgroundImage.getWidth(null), backgroundImage.getHeight(null));
    }
	 
}

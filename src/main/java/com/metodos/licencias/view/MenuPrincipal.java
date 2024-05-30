package com.metodos.licencias.view;

import javax.swing.JButton;
import javax.swing.SwingUtilities;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;

public class MenuPrincipal {
    
    // Create and show the GUI
    public static void createAndShowGUI() {
        // Create the frame
        JFrame frame = new JFrame("Simple Swing Application");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1920, 1080); // Set the size of the window

        JTabbedPane tabbedPane = new JTabbedPane();


        // Display the window
        frame.setVisible(true);
    }
    
    
}

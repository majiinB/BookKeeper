package com.bookkeeper;

import javax.swing.*;
import java.awt.*;
import java.awt.Component;

import java.awt.Graphics;
import java.awt.Insets;

import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.Border;

class RoundedPanel extends JPanel {
    //dimension
	private int cornerRadius;
    private int borderWidth;
    
    //size
    private int width ;
	private int height ;
	
    //graphic
    private Dimension arcs;
    private Graphics2D graphics ;
    
    //Stroke
    private Stroke oldStroke;
    
    public RoundedPanel(LayoutManager layout, int radius) {
        super(layout);
        cornerRadius = radius;
    }

    public RoundedPanel(int radius) {
        super();
        cornerRadius = radius;
    }
    public void setBorderWidth(int width) {
        borderWidth = width;
        repaint(); // Repaint the panel to update the border
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        /*
            * Use super.paintComponent(g) for proper rendering 
            * of the components 
        */
        
        arcs = new Dimension(cornerRadius, cornerRadius);
        width = getWidth();
        height = getHeight();
        
        graphics = (Graphics2D) g;
        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        oldStroke = graphics.getStroke(); // Store the current stroke
        graphics.setStroke(new BasicStroke(borderWidth)); // Set the new stroke with the desired width

        graphics.setColor(getForeground()); // Set foreground color as the color of the border
        graphics.drawRoundRect(borderWidth / 2, borderWidth / 2, width - borderWidth, height - borderWidth, arcs.width, arcs.height);

        // Draw  rounded rectangle 
        graphics.setStroke(oldStroke); // Restore the previous stroke
    }

}

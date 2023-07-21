package com.bookkeeper;
import java.awt.*;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.*;

public class GradientBackgroundPanel extends JPanel {
	//graphic
	private GradientPaint gp ;
	private Graphics2D graphics;
	//color
	private Color color1;
    private Color color2;
    //size
	private int width ;
	private int height ;
	
    public void setColor1(Color color) {
        this.color1 = color;
        repaint(); // Redraw the panel with the color
    }

    public void setColor2(Color color) {
        this.color2 = color;
        repaint(); // Redraw the panel with the color
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        /*
         * Use super.paintComponent(g) for proper rendering 
         * of the components 
         */
        graphics = (Graphics2D) g;
        graphics.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);

        width = getWidth();
        height = getHeight();
        
        gp = new GradientPaint(0, 0, color1, width, height, color2);
        graphics.setPaint(gp);
        graphics.fillRect(0, 0, width, height);
    }
}

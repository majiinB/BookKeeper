package com.bookkeeper;
import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;
import javax.swing.BorderFactory;
import javax.swing.JPasswordField;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class PlaceholderPassword extends JPasswordField {
    //String
	private String placeholder;
    
    //button
    private JButton btnShowPass;
    
    //icon
	private ImageIcon hideIcon;
	private ImageIcon showIcon;
	private int iconHeight; 
	private int iconWidth;
	
    public PlaceholderPassword(String placeholder) {
    	setOpaque(true);
        this.placeholder = placeholder;

        // Set the initial font and foreground color
        setFont(new Font("Montserrat", Font.ITALIC, 18));
        setForeground(Color.GRAY);

        // Add a focus listener to handle showing and hiding the placeholder text
        addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (getText().equals(placeholder)) {
                    setText("");
                    setFont(getFont().deriveFont(Font.PLAIN));
                    setForeground(Color.BLACK);
                } else {
                	setFont(getFont().deriveFont(Font.PLAIN));
                    setForeground(Color.BLACK);
                }
            }
            @Override
            public void focusLost(FocusEvent e) {
                if (getText().isEmpty()) {
                    setText(placeholder);
                    setFont(getFont().deriveFont(Font.ITALIC));
                    setForeground(Color.GRAY);
                } else {
                    setFont(getFont().deriveFont(Font.ITALIC));
                    setForeground(Color.GRAY); 	
                }
            }
        });
        // Set the initial placeholder text
        setEchoChar('●'); 
        setText(placeholder);
        hideIcon = new ImageIcon("img/Eye_Hide.png");
        showIcon = new ImageIcon("img/Eye_Show.png");
        
    
        btnShowPass = new JButton();
        btnShowPass.setBorderPainted(false);
        btnShowPass.setFocusPainted(false);
        btnShowPass.setContentAreaFilled(false);
        btnShowPass.setPreferredSize(new Dimension(29, 29));

        iconHeight = (int) (btnShowPass.getPreferredSize().getHeight()-9);
        iconWidth = (int) (btnShowPass.getPreferredSize().getHeight()-2);
        hideIcon = new ImageIcon(hideIcon.getImage().getScaledInstance(iconWidth, iconHeight, Image.SCALE_SMOOTH));
        showIcon = new ImageIcon(showIcon.getImage().getScaledInstance(iconWidth, iconHeight, Image.SCALE_SMOOTH));
        btnShowPass.setBorder(new EmptyBorder(5,5,5,5));
        btnShowPass.setIcon(hideIcon);

        
        btnShowPass.addMouseListener(new MouseAdapter() {
        	@Override
            public void mouseClicked(MouseEvent e) {
        		// password visibility
        		if (getEchoChar() == '●') {// Show password 
        			setEchoChar((char) 0); 
        			btnShowPass.setIcon(showIcon);
        		} else {// hide password
        			setEchoChar('●'); 
        			btnShowPass.setIcon(hideIcon);
        		}
        	}
        });

        setLayout(new BorderLayout());
        add(btnShowPass, BorderLayout.EAST);   
    }

    public String getPlaceholder() {
        return placeholder;
    }

    public void setPlaceholder(String placeholder) {
        this.placeholder = placeholder;
        setText(placeholder);
    }

    public String clearInputAndGetPlaceholder() {
        String input = getText();
        setText(placeholder);
        setFont(getFont().deriveFont(Font.ITALIC));
        setForeground(Color.GRAY);
        return input;
    }
}

package com.bookkeeper;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.JSpinner;
import javax.swing.SpinnerListModel;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class PlaceholderSpinner extends JSpinner {
	private int placeholder;
	private SpinnerNumberModel spinnerModel;
	
	public PlaceholderSpinner(int placeholder, int min, int max, int step)  {
		setOpaque(false);
		this.placeholder = placeholder;
		
		
        // Set the model for the JSpinner
	    spinnerModel = new SpinnerNumberModel(placeholder, min, max, step); 
        this.setModel(spinnerModel);
        
        // Set the initial font and foreground color
        setFont(new Font("Montserrat", Font.ITALIC, 18));
        setForeground(Color.GRAY);
        
        // Add a focus listener to handle showing and hiding the placeholder text
        addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                setFont(getFont().deriveFont(Font.PLAIN));
                setForeground(Color.BLACK);
            }

            @Override
            public void focusLost(FocusEvent e) {
            	setFont(getFont().deriveFont(Font.ITALIC));
                setForeground(Color.GRAY); 
            }
        });
        
        // Add a ChangeListener to validate if entered value falls within the range
        addChangeListener(new ChangeListener() {
        	@Override
            public void stateChanged(ChangeEvent e) {
        		int value = (int) getValue();
        		if (value < min || value > max) {     
	            	// Show alert message
        			/* 
        			 * An Error Occurred
        			 * Oops! It seems like an error occurred. 
        			 * Please check the information you provided 
        			 * and try again. 
        			 * Ensure that all fields are correctly filled 
        			 * and any required details are provided.
        			 */
                    // Revert value to the previous valid value
	        		setValue(getPreviousValue());
	           }
	        }
        });
        
        // Set the initial placeholder text
        setValue(placeholder);
    }
    public int getPlaceholder() {
        return placeholder;
    }
    public void setPlaceholder(int placeholder) {
        this.placeholder = placeholder;
        setValue(placeholder);
    }
}
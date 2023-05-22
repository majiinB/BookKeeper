package com.bookkeeper;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.BorderFactory;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public class PlaceholderTextField extends JTextField{
	private String placeholder;
	private Border border;
	
	public PlaceholderTextField(String placeholder) {
		setOpaque(true);
		this.placeholder = placeholder;

        // Set the initial font and foreground color
        setFont(getFont().deriveFont(Font.ITALIC));
        setForeground(Color.GRAY);

        // Add a focus listener to handle showing and hiding the placeholder text
        addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (getText().equals(placeholder)) {
                    setText("");
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

                }
            }
        });

        // Set the initial placeholder text
        setText(placeholder);
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

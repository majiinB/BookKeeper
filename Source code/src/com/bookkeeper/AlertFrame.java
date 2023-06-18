package com.bookkeeper;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Frame for alert notifications

public class AlertFrame extends JFrame {
	private JPanel mainPanel;
	private ImageIcon icon;
	private Image image;	
	
    public AlertFrame() {
		setTitle("Book Keeper");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(712, 230);
		setResizable(false);
		setUndecorated(true);//to remove the frame	
		setLocationRelativeTo(null);//to put frame at the center 
	    setVisible(true);
        setLayout(new BorderLayout());

        //Set the Icon
        icon = new ImageIcon("/Fixed_Book_Keeper/img/Logo_Original.png");//LAGAY MO UNG PATH!!
        image = icon.getImage();
        setIconImage(image); 
        
        //Create panels
        mainPanel = new JPanel();//panel to hold all panels
        mainPanel.setLayout(new BorderLayout(0, 0)); //delete mo toh pag may backend na
      
        

    
    }

}

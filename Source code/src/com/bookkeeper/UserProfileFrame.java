package com.bookkeeper;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//Frame for user to modify their account details

public class UserProfileFrame extends JFrame {
	private JPanel mainPanel;
	private ImageIcon icon;
	private Image image;	
	
    public UserProfileFrame() {
		setTitle("Book Keeper");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400, 560);
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

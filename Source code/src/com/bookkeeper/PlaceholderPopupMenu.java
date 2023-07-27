package com.bookkeeper;
import java.awt.*;
import java.awt.event.ActionListener;
//import java.awt.event.MouseEvent;
//import java.awt.event.MouseListener;

import javax.swing.*;
//import javax.swing.event.PopupMenuEvent;
//import javax.swing.event.PopupMenuListener;

//public class PlaceholderMenuButton extends JLabel 
//	implements MouseListener, PopupMenuListener {
//	JPopupMenu popMenu;
//	
//	@SuppressWarnings("")
//	public PlaceholderMenuButton() {
//		super();
//		popMenu = new JPopupMenu();
//		addMouseListener(this);
//		popMenu.addPopupMenuListener(this);
//		}
//		
//		public JPopupMenu getPopup() { return popMenu; }
//		
//		@Override
//		public void mousePressed(MouseEvent e) {
//		if ( ! popMenu.isShowing()) {
//		    popMenu.show(this, 0, getBounds().height);
//		}
//		}
//		@Override public void popupMenuWillBecomeInvisible(PopupMenuEvent e) { 
//		SwingUtilities.invokeLater(()->{
//		    if (popMenu.isShowing()) {
//		        //  if shpwing, it was hidden and reshown
//		        //  by a mouse down in the 'this' button
//		        popMenu.setVisible(false);
//		    }
//		});
//		}
//
//@Override public void mouseClicked(MouseEvent e) { }
//@Override public void mouseReleased(MouseEvent e) { }
//@Override public void mouseEntered(MouseEvent e) { }
//@Override public void mouseExited(MouseEvent e) { }
//@Override public void popupMenuWillBecomeVisible(PopupMenuEvent e) { }
//@Override public void popupMenuCanceled(PopupMenuEvent e) { }
//
//}

public class PlaceholderPopupMenu extends JPopupMenu {

    public PlaceholderPopupMenu() {
        super();
    }

    // add menu items 
    public void addMenuItem(String item, ActionListener actionListener) {
        JMenuItem menuItem = new JMenuItem(item);
        menuItem.addActionListener(actionListener);
        add(menuItem);
    }

    // set the number of items
    public void setItems(int count) {
        if (count < 0) {
            count = 0;
        }
        for (int i = 0; i < count; i++) {
            add(new JMenuItem("Item " + (i + 1)));
        }
    }
}      
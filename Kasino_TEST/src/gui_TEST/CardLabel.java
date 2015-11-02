package gui_TEST;

import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.SwingUtilities;

public class CardLabel extends JLabel {

	private int id;
	private boolean isClickable;
	private boolean isOnTable;
	private ImageList list;

	private JPopupMenu menu;
	private JMenuItem menuSelect;
	private JMenuItem menuDeselect;

	public CardLabel(ImageList list, ApplicationLogic appLogic) {
		this.list = list;
		isOnTable = false;
		isClickable = true;
		menu = new JPopupMenu();
		setComponentPopupMenu(menu);

		menuSelect = new JMenuItem("Select");
		menuDeselect = new JMenuItem("Deselect");

		menuDeselect.setVisible(false);

		menuSelect.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(isClickable)
				{
					if(isOnTable) {
						appLogic.addTableCardID(id);
					}
					else {
						appLogic.setHandCardID(id);
					}
					//System.out.println("Du har markerat ett kort med ID: " + id);
					menuSelect.setVisible(false);
					menuDeselect.setVisible(true);
				}

			}
		});

		menuDeselect.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(isOnTable) {
					appLogic.removeTableCardID(id);
				}
				else {
					appLogic.removeHandCardID();
				}
				//System.out.println("Du avmarkerade ett kort med ID: " + id);
				menuDeselect.setVisible(false);
				menuSelect.setVisible(true);
			}
		});


		menu.add(menuSelect);
		menu.add(menuDeselect);
	}
	
	public void setSelectable(boolean b) {
		menuSelect.setVisible(b);
		menuDeselect.setVisible(!b);
	}


	public boolean isOnTable() {
		return isOnTable;
	}

	public void setOnTable(boolean isOnTable) {
		this.isOnTable = isOnTable;
	}

	public void setID(int id) {
		this.id = id;
		
		menuDeselect.setVisible(false);
		menuSelect.setVisible(true);
	}

	public int getID() {
		return id;
	}

	public boolean isClickable() {
		return isClickable;
	}

	public void setClickable(boolean isClickable) {
		this.isClickable = isClickable;

		if(isClickable == false) {
			menuSelect.setVisible(false);
			menuDeselect.setVisible(false);
		}

	}

}

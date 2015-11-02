package gui_TEST;


import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;












import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import data_TEST.Deck;

public class ImageList {

	File folder;
	List<ImageIcon> list;
	ImageIcon faceDown;
	
	private final static String PATH = "H:/workspace/Kasino_TEST/CARDS/material3/";

	public ImageList() {

		list = new ArrayList<ImageIcon>();
		folder = new File(PATH);	
		faceDown = new ImageIcon("H:/workspace/Kasino_TEST/CARDS/face_down.png");
		
		for (int i = 0; i < folder.list().length; i++) {
			try {
				list.add(new ImageIcon(PATH + i + ".png"));
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
	}

	public ImageIcon getImage(int id) {
			return list.get(id);
	}
	
	public ImageIcon getFaceDownImage() {
		return faceDown;
	}

	public void print() {
		for(ImageIcon l : list) {
			System.out.println(l);
		}
	}
}

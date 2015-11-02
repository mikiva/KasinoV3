package data_TEST;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class Card {

	private int value;
	private String color;
	private int id;

	public Card(int value, String color, int id){
		this.value = value;
		this.color = color;
		this.id = id;
	}
	
	public String toString(){
		return id + " " + color + " " + value;
	}
	
	public int getId(){
		return id;
	}
	
	public int getValue() {
		return value;
	}
	
	public String getColor() {
		return color;
	}
	
	

}



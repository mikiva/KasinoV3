package gui_TEST;


import java.awt.Component;
import java.awt.Container;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import sun.reflect.generics.visitor.Reifier;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

import data_TEST.Deck;
import data_TEST.Table;

public class TablePanel extends JPanel {

	private ImageList list;
	private Table table;
	private ApplicationLogic appLogic;
	private CardLabel[] label;
	private int startingCards;

	public TablePanel(Table table, ApplicationLogic appLogic, int startingCards) {
		list = new ImageList();
		this.table = table;
		this.appLogic = appLogic;
		this.startingCards = startingCards;
		label = new CardLabel[52];

		for (int i = 0; i < label.length; i++) {
			label[i] = new CardLabel(list, appLogic);
			add(label[i]);
		}

	}

	public void addCardToTable(int id) {
		for (int i = 0; i < label.length; i++) {
			if(label[i].getID() != id) {
				label[findFirstFreeSpace()].setID(id);
				label[findFirstFreeSpace()].setOnTable(true);
				label[findFirstFreeSpace()].setIcon(list.getImage(id));
				break;
			}
		}

	}

	public void addStartingCards() {
		CardLabel l;

		for (int i = 0; i < startingCards; i++) {
			l = label[findFirstFreeSpace()];
			l.setID(table.getTableCards().get(i).getId());
			l.setOnTable(true);
			l.setIcon(list.getImage(table.getTableCards().get(i).getId()));
		}
	}

	public void removeCardFromTable(int id) {
		for (int i = 0; i < label.length; i++) {
			if(label[i].getID() == id)
				label[i].setIcon(null);
		}
	}

	public void clearTable() {
		for (int i = 0; i < label.length; i++) {
			label[i].setIcon(null);
		}
	}
	
	public void setAllToSelectable() {
		for (int i = 0; i < label.length; i++) {
			label[i].setSelectable(true);
		}
	}

	private int findFirstFreeSpace() {
		for (int i = 0; i < label.length; i++) {
			if(label[i].getIcon() == null)
				return i;
		}
		return 0;
	}


}

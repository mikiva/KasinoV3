package gui_TEST;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.text.TabExpander;

import control_TEST.GameLogic;
import data_TEST.Card;

public class ApplicationLogic {

	private List<Integer> tableCardList;
	private Integer handCardID;

	public ApplicationLogic() {
		tableCardList = new ArrayList<Integer>();
		handCardID = null;
	}
	
	public Integer getHandCardID() {
		return handCardID;
	}
	
	public List<Integer> getTableCardList() {
		return tableCardList;
	}
	
	public void addTableCardID(int cardID) {
		tableCardList.add(cardID);
	}
	
	public void removeTableCardID(int cardID) {
		if(tableCardList.contains(cardID)) {
			tableCardList.remove(tableCardList.indexOf(cardID));
		}
	}
	
	public void setHandCardID(Integer handCardID) {
		this.handCardID = handCardID;
	}
	
	public void removeHandCardID() {
		handCardID = null;
	}
	
	public void clearAll() {
		tableCardList.clear();
		handCardID = null;
		
	}

}

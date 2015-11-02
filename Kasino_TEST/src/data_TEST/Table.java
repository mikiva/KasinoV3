package data_TEST;

import java.util.ArrayList;
import java.util.List;

public class Table {

	List<Card> onTable;
	ArrayList<Integer> tableIntegerList;

	public Table() {
		onTable = new ArrayList<Card>();
		tableIntegerList = new ArrayList<Integer>();
	}

	public void addCardToTable(Card card) {
		onTable.add(card);
	}

	public void removeCard(int index) {
		onTable.remove(index);
	}
	
	public void removeCardOnTable(int cardID) {
		for (int i = 0; i < onTable.size(); i++) {
			if(onTable.get(i).getId() == cardID) {
				onTable.remove(i);
			}
		}
	}
	
	public void clearTable() {
		onTable.clear();
	}
	
	public Card getCardOnTable(int cardID) {
		for (int i = 0; i < onTable.size(); i++) {
			if(onTable.get(i).getId() == cardID)
				return onTable.get(i);
		}
		return onTable.get(0);
	}

	public boolean isCardOnTable(Card card) {
		for (int j = 0; j < onTable.size(); j++) {

			if(card.equals(onTable.get(j)))
				return true;
		}
		return false;
	}
	
	public boolean isTableEmpty() {
		if(onTable.isEmpty()) 
			return true;
		
		else 
			return false;
	}
	
	public List<Card> getTableCards() {
		return onTable;
	}
	
	public ArrayList<Integer> getTableIntegerList(){
		
		for (int i = 0; i < onTable.size(); i++) {
			tableIntegerList.add(onTable.get(i).getId());
		}
		return tableIntegerList;
		
		
	}

}

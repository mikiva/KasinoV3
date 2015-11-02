package control_TEST;

import data_TEST.Card;



public class GameRules {
	
	private int cardsOnTable;
	private int cardsToDeal;
	private int nbrOfPlayerUser;
	private int nbrOfPlayerAI;
	
	private static final int ACE = 1;
	private static final int LILLAN = 1;
	private static final int STORAN = 2;
	private static final int TABBE = 1;

	public GameRules(int nbrOfPlayerUser, int nbrOfPlayerAI) {
		this.nbrOfPlayerUser = nbrOfPlayerUser;
		this.nbrOfPlayerAI = nbrOfPlayerAI;
		cardsOnTable = 4;
		cardsToDeal = 4;
	}
	
	public boolean isLegal(Card[] cardsOnTable, Card cardOnHand) {

		for (int i = 0; i < cardsOnTable.length; i++) {
			if(cardOnHand.getValue() < cardsOnTable[i].getValue())
				return false;
		}

		int total = 0;

		for(int i = 0; i < cardsOnTable.length; i++) {
			total += cardsOnTable[i].getValue();
		}

		if(total % cardOnHand.getValue() == 0)
			return true;

		return false;
	}
	
	public int tempName(int value, String color, boolean tabbe) {
		int sum = 0;
		
		if(value == 14)
			sum += ACE;
		if(value == 2 && color.equals("Spades"))
			sum += LILLAN;
		if(value == 10 && color.equals("Diamonds"))
			sum += STORAN;
		if(tabbe) {
			sum += TABBE;
		}
		return sum;
	}
	
	public int spades(Card[] cardsOnTable, Card cardOnHand) {
		int nbrOfSpades = 0;
		
		for (int i = 0; i < cardsOnTable.length; i++) {
			if(cardsOnTable[i].getColor().equals("Spades"))
				nbrOfSpades++;
		}
		if(cardOnHand.getColor().equals("Spades")) 
			nbrOfSpades++;
		
		return nbrOfSpades;
	}
	
	public boolean isGameOver(Dealer dealer, PlayerList playerList) {
		if(dealer.isDeckEmpty() && playerList.isAllPlayerHandEmpty()) 
			return true;
		return false;
	}
	
	public int getCardsOnTable() {
		return cardsOnTable;
	}
	
	public int getCardsToDeal() {
		return cardsToDeal;
	}
	
	public int getNbrOfPlayerUser() {
		return nbrOfPlayerUser;
	}
	
	public void setNbrOfPlayerUser(int nbrOfPlayerUser) {
		this.nbrOfPlayerUser = nbrOfPlayerUser;
	}
	
	public int getNbrOfPlayerAI() {
		return nbrOfPlayerAI;
	}
	
	public void setNbrOfPlayerAI(int nbrOfPlayerAI) {
		this.nbrOfPlayerAI = nbrOfPlayerAI;
	}
	
	
	

}

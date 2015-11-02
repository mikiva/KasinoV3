package control_TEST;

import java.util.List;
import java.util.Random;

import data_TEST.Card;

public class PlayerAI implements Player {
	
	private List<Card> cards;
	private int playerID;
	private GameLogic logic;
	
	public PlayerAI(int playerID) {
		this.playerID = playerID;
	}

	@Override
	public int getPlayerId() {
		return playerID;
	}

	@Override
	public void placeCard(int cardID) {
	
		
	}


	@Override
	public void addToHand(Card card) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void clearHand() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Card> getHand() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean takeCard(List<Integer> cardIDList, int cardID) {
		return false;
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeFromHand(int index) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setLogic(GameLogic logic) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Card getCardOnHand(int cardID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getExtraPoints() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void addExtraPoints(int extraPoints) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getNbrOfSpades() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void addNbrOfSpades(int nbrOfSpades) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getNbrOfTakenCards() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void addNbrOfTakenCards(int nbrOfTakenCards) {
		// TODO Auto-generated method stub
		
	}

}

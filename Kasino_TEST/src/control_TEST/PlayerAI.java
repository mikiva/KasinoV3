package control_TEST;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import data_TEST.Card;

public class PlayerAI implements Player {



	private List<Card> hand;
	private int playerID;
	private GameLogic logic;

	private int extraPoints;
	private int nbrOfSpades;
	private int nbrOfTakenCards;
	
	private ArrayList<Integer> tableList;

	public PlayerAI(int playerID) {
		this.playerID = playerID;
		hand = new ArrayList<Card>();
	}

	@Override
	public int getPlayerId() {
		return playerID;
	}

	public void play(){

		tableList = logic.getTableIntegerList();


		for (int i = 0; i < hand.size(); i++) {

			if(takeCard(tableList, hand.get(i).getId()))
			{
				System.out.println("Tog kort" + hand.get(i).toString());
				return;
		
			}
		}

		placeCard(hand.get(0).getId());
System.out.println("La ut kort");




	}


	@Override
	public void placeCard(int cardID) {
		for (int i = 0; i < hand.size(); i++) {
			if(hand.get(i).getId() == cardID) {
				try {
					Card c = hand.get(i);
					logic.cardPlaced(c);
				}
				catch(Exception e) {
					e.printStackTrace();
				}
				hand.remove(i);
			}
				
		}

	}


	@Override
	public void addToHand(Card card) {
		// TODO Auto-generated method stub
		hand.add(card);
	}

	@Override
	public void clearHand() {
		hand.clear();

	}

	@Override
	public List<Card> getHand() {
		// TODO Auto-generated method stub
		return hand;
	}

	@Override
	public boolean takeCard(List<Integer> cardIDList, int cardID) {

		if(logic.cardTaken(cardIDList, cardID, playerID)) {
			for (int i = 0; i < hand.size(); i++) {
				if(hand.get(i).getId() == cardID)
					hand.remove(i);
			}
			return true;
		}
		return false;
	}


	@Override
	public void removeFromHand(int index) {
		// TODO Auto-generated method stub
		hand.remove(index);
	}

	@Override
	public void setLogic(GameLogic logic) {
		// TODO Auto-generated method stub
		this.logic = logic;
	}

	@Override
	public Card getCardOnHand(int cardID) {
		// TODO Auto-generated method stub
		for (int i = 0; i < hand.size(); i++) {
			if(hand.get(i).getId() == cardID)
				return hand.get(i);
		}
		return hand.get(0);

	}

	@Override
	public int getExtraPoints() {
		// TODO Auto-generated method stub

		return extraPoints;
	}

	@Override
	public void addExtraPoints(int extraPoints) {
		// TODO Auto-generated method stub
		extraPoints += extraPoints;

	}

	@Override
	public int getNbrOfSpades() {
		// TODO Auto-generated method stub
		return nbrOfSpades;
	}

	@Override
	public void addNbrOfSpades(int nbrOfSpades) {
		// TODO Auto-generated method stub
		this.nbrOfSpades += nbrOfSpades;
	}

	@Override
	public int getNbrOfTakenCards() {
		// TODO Auto-generated method stub
		return nbrOfTakenCards;
	}

	@Override
	public void addNbrOfTakenCards(int nbrOfTakenCards) {
		// TODO Auto-generated method stub
		this.nbrOfTakenCards += nbrOfTakenCards;
	}

}

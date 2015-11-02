package control_TEST;

import java.awt.List;
import java.io.IOException;
import java.util.Collections;

import data_TEST.Deck;
import data_TEST.Table;

public class Dealer implements DealerInterface{


	private Deck deck;
	private PlayerList playerList;
	private GameLogic logic;

	private GameRules rules;
	private Table table;

	public Dealer(Deck deck, GameRules rules) {
		this.deck = deck;
		this.rules = rules;
	}

	@Override
	public void shuffleDeck() {
		deck.shuffle();
	}

	public void dealToTable() {
		for (int i = 0; i < rules.getCardsOnTable(); i++) {
			table.addCardToTable(deck.drawCard());
		}
	}


	public void dealToPlayers() {
		if(!isDeckEmpty()) {

			for (int i = 0; i < playerList.getNumberOfPlayers(); i++) {
				for (int n = 0; n < rules.getCardsToDeal() ; n++) 
					playerList.getPlayer(n).addToHand(deck.drawCard());
			}
		}
		else System.out.println("Deck empty");

	}

	public void resetDeck() {
		deck = new Deck();
	}

	public boolean isDeckEmpty() {
		if(deck.getDeck().isEmpty())
			return true;
		return false;
	}
	public void setPlayerList(PlayerList playerList) {
		this.playerList = playerList;
	}

	public void setLogic(GameLogic logic) {
		this.logic = logic;
	}

	public void setRules(GameRules rules) {
		this.rules = rules;
	}

	public void setTable(Table table) {
		this.table = table;
	}


}

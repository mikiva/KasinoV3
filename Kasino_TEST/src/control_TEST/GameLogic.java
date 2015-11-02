package control_TEST;


import java.io.IOException;





import java.util.List;

import data_TEST.Card;
import data_TEST.Deck;
import data_TEST.Table;

public class GameLogic {

	private GameRules rules;
	private Dealer dealer;

	private Table table;
	private PlayerList playerList;
	private Scoreboard scoreboard;

	public GameLogic(GameRules rules, Dealer dealer, PlayerList playerList){


		this.rules = rules;
		this.dealer = dealer;


		this.playerList = playerList;
		this.playerList.setLogicToPlayers(this);
		scoreboard = new Scoreboard(rules.getNbrOfPlayerAI() + rules.getNbrOfPlayerUser());
	}

	public void setRules(GameRules rules) {
		this.rules = rules;
	}

	public void setTable(Table table) {
		this.table = table;
	}

	public void setScoreboard(Scoreboard scoreboard) {
		this.scoreboard = scoreboard;
	}

	public boolean cardTaken(List<Integer> onTable, int cardID, int playerID) {

		int points = 0;

		Card[] cardArr = new Card[onTable.size()];
		for (int i = 0; i < cardArr.length; i++) {
			cardArr[i] = table.getCardOnTable(onTable.get(i));
			points += rules.tempName(cardArr[i].getValue(), cardArr[i].getColor(), table.isTableEmpty());
		}
		Card c = playerList.getPlayer(playerID).getCardOnHand(cardID);

		if(rules.isLegal(cardArr, c)) {
			playerList.getPlayer(playerID).addNbrOfTakenCards(cardArr.length + 1);
			playerList.getPlayer(playerID).addNbrOfSpades(rules.spades(cardArr, c));

			for (int i = 0; i < cardArr.length; i++) {
				table.removeCardOnTable(cardArr[i].getId());
			}
			return true;
		}
		return false;
	}

	public void cardPlaced(Card c) {
		if(!table.isCardOnTable(c))
			table.addCardToTable(c);
	}
	//
	//	public String gameOver() {
	//		if(rules.isGameOver(dealer, playerList)) {
	//			return scoreboard.getPlayerScores();
	//		}
	//		return "";
	//	}

	public void newGame() { //Återställer kortleken och rensar spelarnas händer

		playerList.clearAllHands();
		dealer.resetDeck();
		dealer.shuffleDeck();
		dealer.dealToPlayers();
		table.clearTable();
		dealer.dealToTable();
	}
}
